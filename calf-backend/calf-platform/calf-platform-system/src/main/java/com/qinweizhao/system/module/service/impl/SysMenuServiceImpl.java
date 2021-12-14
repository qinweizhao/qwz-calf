package com.qinweizhao.system.module.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qinweizhao.system.module.entity.SysMenu;
import com.qinweizhao.system.module.mapper.SysMenuMapper;
import com.qinweizhao.system.module.service.ISysMenuService;
import org.springframework.stereotype.Service;

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

    @Override
    public List<SysMenu> listWithTree(String currentLoginUsername) {
        List<SysMenu> menus = this.baseMapper.selectMenuListByUsername(currentLoginUsername);
        return buildTree(menus);

    }

    /**
     * 构建树形菜单
     * @param menus 所有菜单
     * @return 树形菜单
     */
    private List<SysMenu> buildTree(List<SysMenu> menus){
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
