package com.qinweizhao.system.module.manage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qinweizhao.api.system.dto.SysMenuDTO;
import com.qinweizhao.system.module.manage.entity.SysMenu;

import java.util.List;

/**
 * <p>
 * 菜单权限表 服务类
 * </p>
 *
 * @author qinweizhao
 * @since 2021-12-10
 */
public interface ISysMenuService extends IService<SysMenu> {

    /**
     * 树形菜单
     * @param currentLoginUsername currentLoginUsername
     * @return List<SysMenu>
     */
    List<SysMenu> listWithTree(String currentLoginUsername);

    /**
     * 保存
     * @param sysMenu sysMenu
     * @return Integer
     */
    Integer saveMenu(SysMenu sysMenu);

    /**
     * 更新
     * @param sysMenu sysMenu
     * @return Integer
     */
    Integer updateMenu(SysMenu sysMenu);

    /**
     * 移除
     * @param menuId menuId
     * @return Integer
     */
    Integer removeMenuByMenuId(Long menuId);

    /**
     * 开启的角色列表
     * @return List<SysMenu>
     */
    List<SysMenu> listSimpleRoles();

}
