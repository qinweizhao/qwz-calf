package com.qinweizhao.system.module.manage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qinweizhao.system.module.manage.entity.SysRoleMenu;

import java.util.List;

/**
 * <p>
 * 角色菜单关联 Mapper 接口
 * </p>
 *
 * @author qinweizhao
 * @since 2021-12-10
 */
public interface SysRoleMenuMapper extends BaseMapper<SysRoleMenu> {

    /**
     * 通过菜单 Id 删除角色菜单
     * @param menuId menuId
     * @return int
     */
    int deleteRoleMenuByMenuId(Long menuId);

    /**
     * 通过角色 Id 删除角色菜单
     * @param roleId roleId
     */
    int deleteRoleMenuByRoleId(Long roleId);


    /**
     * 获取角色拥有的菜单 Id 集合
     * @param roleId Id
     * @return List<Long>
     */
    List<Long> selectListMenuIdsByRoleId(Long roleId);
}
