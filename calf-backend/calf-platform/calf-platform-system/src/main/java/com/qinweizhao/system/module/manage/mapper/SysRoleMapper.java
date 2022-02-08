package com.qinweizhao.system.module.manage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qinweizhao.api.system.dto.query.SysRolePageQry;
import com.qinweizhao.system.module.manage.entity.SysRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 角色表 Mapper 接口
 * </p>
 *
 * @author qinweizhao
 * @since 2021-12-06
 */
@Mapper
public interface SysRoleMapper extends BaseMapper<SysRole> {

    /**
     * 修改角色状态
     *
     * @param roleId roleId
     * @param status status
     * @return boolean
     */
    boolean updateStatusById(@Param("roleId") Long roleId, @Param("status") Integer status);

    /**
     * 通过 Id 查询角色
     *
     * @param roleName roleName
     * @return SysRole
     */
    SysRole selectRoleByRoleName(String roleName);

    /**
     * 通过角色标识查询角色
     *
     * @param code code
     * @return SysRole
     */
    SysRole selectRoleByCode(String code);


    /**
     * 获得角色列表，只要开启状态的
     *
     * @param status status
     * @return List<SysRole>
     */
    List<SysRole> selectListSimpleRoles(int status);

    /**
     * 分页
     *
     * @param page           page
     * @param sysRolePageQry sysRolePageQry
     * @return IPage<SysRole>
     */
    IPage<SysRole> selectPageRoles(Page<SysRole> page, @Param("query") SysRolePageQry sysRolePageQry);


    /**
     * 通过用户 Id 获取角色列表
     *
     * @param userId userId
     * @return List<SysRole>
     */
    List<SysRole> selectListByUserId(Long userId);
}
