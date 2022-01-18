package com.qinweizhao.system.module.manage.service;

import com.qinweizhao.api.system.dto.SysMenuDTO;
import com.qinweizhao.api.system.dto.command.SysMenuSaveCmd;
import com.qinweizhao.api.system.dto.command.SysMenuUpdateCmd;
import com.qinweizhao.api.system.dto.query.SysMenuListQry;
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
public interface ISysMenuService  {

    /**
     * 树形菜单
     * @param currentLoginUsername currentLoginUsername
     * @return List<SysMenu>
     */
    List<SysMenu> listWithTree(String currentLoginUsername);

    /**
     * 保存
     * @param sysMenuSaveCmd sysMenuSaveCmd
     * @return Integer
     */
    Integer saveMenu(SysMenuSaveCmd sysMenuSaveCmd);

    /**
     * 更新
     * @param sysMenuUpdateCmd sysMenuUpdateQry
     * @return Integer
     */
    Integer updateMenu(SysMenuUpdateCmd sysMenuUpdateCmd);

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
    List<SysMenuDTO> listSimpleRoles();

    /**
     * 获取菜单列表
     * @param sysMenuListQry sysMenuListQry
     * @return List<SysMenuDTO>
     */
    List<SysMenuDTO> listSysMenus(SysMenuListQry sysMenuListQry);

    /**
     * 通过 Id 获取菜单
     * @param id id
     * @return SysMenuDTO
     */
    SysMenuDTO getMenuById(Long id);

}
