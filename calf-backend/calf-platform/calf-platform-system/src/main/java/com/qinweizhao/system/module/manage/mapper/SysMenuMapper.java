package com.qinweizhao.system.module.manage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qinweizhao.api.system.dto.query.SysMenuListQry;
import com.qinweizhao.system.module.manage.entity.SysMenu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 菜单权限表 Mapper 接口
 * </p>
 *
 * @author qinweizhao
 * @since 2021-12-06
 */
@Mapper
public interface SysMenuMapper extends BaseMapper<SysMenu> {

    /**
     * 获取菜单列表
     *
     * @param currentLoginUsername currentLoginUsername
     * @param type                 type
     * @return List<SysMenu>
     */
    List<SysMenu> selectListByUsername(@Param("username") String currentLoginUsername, @Param("type") Integer type);

    /**
     * 通过父 Id 和 菜单名称获取菜单
     *
     * @param parentId parentId
     * @param name     name
     * @return SysMenu
     */
    SysMenu selectMenuByParentIdAndName(@Param("parentId") Long parentId, @Param("name") String name);

    /**
     * 通过菜单父 Id 统计个数
     *
     * @param menuId menuId
     * @return Integer
     */
    Integer selectCountByParentId(Long menuId);

    /**
     * 状态开启的菜单列表
     *
     * @param status status
     * @return List<SysMenu>
     */
    List<SysMenu> selectListSimpleMenus(Integer status);

    /**
     * 查询菜单列表
     *
     * @param sysMenuListQry sysMenuListQry
     * @return List<SysMenu>
     */
    List<SysMenu> selectListMenus(@Param("query") SysMenuListQry sysMenuListQry);
}
