package com.qinweizhao.system.module.manage.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qinweizhao.common.core.enums.MenuIdEnum;
import com.qinweizhao.common.core.enums.MenuTypeEnum;
import com.qinweizhao.common.core.enums.StatusEnum;
import com.qinweizhao.common.core.exception.ServiceException;
import com.qinweizhao.common.core.response.ResultCode;
import com.qinweizhao.system.module.manage.entity.SysMenu;
import com.qinweizhao.system.module.manage.mapper.SysMenuMapper;
import com.qinweizhao.system.module.manage.mapper.SysRoleMenuMapper;
import com.qinweizhao.system.module.manage.service.ISysMenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 菜单权限表 服务实现类
 * </p>
 *
 * @author qinweizhao
 * @since 2021-12-07
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements ISysMenuService {

    private static final Long LONG_ZERO = 0L;

    @Resource
    private SysRoleMenuMapper sysRoleMenuMapper;

    @Override
    public List<SysMenu> listWithTree(String currentLoginUsername) {
        List<SysMenu> menus = this.baseMapper.selectMenuListByUsername(currentLoginUsername, MenuTypeEnum.BUTTON.getType());
        return buildTree(menus);

    }

    @Override
    public Integer saveMenu(SysMenu sysMenu) {
        // 校验父菜单存在
        this.checkParentResource(sysMenu.getParentId(), null);
        // 校验菜单（自己）
        this.checkResource(sysMenu.getParentId(), sysMenu.getMenuName(), null);
        // 插入数据库
        this.initMenuProperty(sysMenu);
        this.baseMapper.insert(sysMenu);
        return null;
    }

    @Override
    public Integer updateMenu(SysMenu sysMenu) {
        // 校验更新的菜单是否存在
        if (this.baseMapper.selectById(sysMenu.getMenuId()) == null) {
            throw new ServiceException(ResultCode.MENU_NOT_EXISTS);
        }
        // 校验父菜单存在
        checkParentResource(sysMenu.getParentId(), sysMenu.getMenuId());
        // 校验菜单（自己）
        checkResource(sysMenu.getParentId(), sysMenu.getMenuName(), sysMenu.getMenuId());
        // 更新到数据库
        initMenuProperty(sysMenu);
        return this.baseMapper.updateById(sysMenu);
    }

    @Override
    public Integer removeMenuByMenuId(Long menuId) {
        // 校验是否还有子菜单
        if (this.baseMapper.selectCountByParentId(menuId) > 0) {
            throw new ServiceException(ResultCode.MENU_EXISTS_CHILDREN);
        }
        // 校验删除的菜单是否存在
        if (this.baseMapper.selectById(menuId) == null) {
            throw new ServiceException(ResultCode.MENU_NOT_EXISTS);
        }
        // 删除授予给角色的权限
        sysRoleMenuMapper.deleteRoleMenuByMenuId(menuId);
        // 标记删除
        return this.baseMapper.deleteById(menuId);

    }

    @Override
    public List<SysMenu> listSimpleRoles() {
        return this.baseMapper.selectListSimpleMenus(StatusEnum.ENABLE.getStatus());
    }

    /**
     * 初始化菜单的通用属性。
     * <p>
     * 例如说，只有目录或者菜单类型的菜单，才设置 icon
     *
     * @param sysMenu 菜单
     */
    private void initMenuProperty(SysMenu sysMenu) {
        // 菜单为按钮类型时，无需 component、icon、path 属性，进行置空
        if (MenuTypeEnum.BUTTON.getType().equals(sysMenu.getMenuType())) {
            sysMenu.setComponent("");
            sysMenu.setIcon("");
            sysMenu.setPath("");
        }
    }

    /**
     * 校验菜单是否合法
     * <p>
     * 1. 校验相同父菜单编号下，是否存在相同的菜单名
     *
     * @param menuName 菜单名字
     * @param parentId 父菜单编号
     * @param menuId   菜单编号
     */
    private void checkResource(Long parentId, String menuName, Long menuId) {
        SysMenu sysMenu = this.baseMapper.selectMenuByParentIdAndName(parentId, menuName);
        if (sysMenu == null) {
            return;
        }
        // 如果 id 为空，说明不用比较是否为相同 id 的菜单
        if (menuId == null) {
            throw new ServiceException(ResultCode.MENU_NAME_DUPLICATE);
        }
        if (!sysMenu.getMenuId().equals(menuId)) {
            throw new ServiceException(ResultCode.MENU_NAME_DUPLICATE);
        }
    }

    /**
     * 校验父菜单是否合法
     * <p>
     * 1. 不能设置自己为父菜单
     * 2. 父菜单不存在
     * 3. 父菜单必须是 {@link MenuTypeEnum#MENU} 菜单类型
     *
     * @param parentId 父菜单编号
     * @param childId  当前菜单编号
     */
    private void checkParentResource(Long parentId, Long childId) {
        if (parentId == null || MenuIdEnum.ROOT.getId().equals(parentId)) {
            return;
        }
        // 不能设置自己为父菜单
        if (parentId.equals(childId)) {
            throw new ServiceException(ResultCode.MENU_PARENT_ERROR);
        }
        SysMenu sysMenu = this.baseMapper.selectById(parentId);
        // 父菜单不存在
        if (sysMenu == null) {
            throw new ServiceException(ResultCode.MENU_PARENT_NOT_EXISTS);
        }
        // 父菜单必须是目录或者菜单类型
        if (!MenuTypeEnum.DIR.getType().equals(sysMenu.getMenuType())
                && !MenuTypeEnum.MENU.getType().equals(sysMenu.getMenuType())) {
            throw new ServiceException(ResultCode.MENU_PARENT_NOT_DIR_OR_MENU);
        }
    }

    /**
     * 构建树形菜单
     *
     * @param menus 所有菜单
     * @return 树形菜单
     */
    private List<SysMenu> buildTree(List<SysMenu> menus) {
        return menus.stream().filter(item ->
                LONG_ZERO.equals(item.getParentId())
        ).peek(item -> item.setChildren(getChildrenMenu(item, menus))).collect(Collectors.toList());
    }

    /**
     * 获取子菜单
     *
     * @param menu  菜单vo d
     * @param menus 收集菜单的容器
     * @return 返回容器
     */
    private List<SysMenu> getChildrenMenu(SysMenu menu, List<SysMenu> menus) {
        menus.stream().filter(
                i -> menu.getMenuId().equals(i.getParentId())
        ).forEach(item -> item.setChildren(getChildrenMenu(item, menus)));


        System.out.println(menus);
        return menus.stream().filter(
                i -> menu.getMenuId().equals(i.getParentId())
        ).peek(item -> item.setChildren(getChildrenMenu(item, menus))).collect(Collectors.toList());
    }
}
