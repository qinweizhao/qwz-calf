package com.qinweizhao.system.module.manage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qinweizhao.system.module.manage.entity.SysRoleMenu;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;
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
     *
     * @param menuId menuId
     * @return int
     */
    int deleteRoleMenuByMenuId(Long menuId);

    /**
     * 通过角色 Id 删除角色菜单
     *
     * @param roleId roleId
     * @return int
     */
    int deleteRoleMenuByRoleId(Long roleId);


    /**
     * 获取角色拥有的菜单 Id 集合
     *
     * @param roleId Id
     * @return List<Long>
     */
    List<Long> selectListMenuIdsByRoleId(Long roleId);


    /**
     * 批量插入
     *
     * @param roleId        roleId
     * @param insertMenuIds insertMenuIds
     */
    void insertRoleMenuByRoleIdAndMenuIds(@Param("roleId") Long roleId, @Param("menuIds") Collection<Long> insertMenuIds);

    /**
     * 批量删除
     *
     * @param roleId        roleId
     * @param deleteMenuIds deleteMenuIds
     */
    void deleteRoleMenuByRoleIdAndMenuIds(@Param("roleId") Long roleId, @Param("menuIds") Collection<Long> deleteMenuIds);
}
