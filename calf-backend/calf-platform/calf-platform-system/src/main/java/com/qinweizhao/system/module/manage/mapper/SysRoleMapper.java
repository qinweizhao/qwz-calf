package com.qinweizhao.system.module.manage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qinweizhao.api.system.vo.SysRoleVO;
import com.qinweizhao.common.core.request.Search;
import com.qinweizhao.system.module.manage.entity.SysRole;
import com.qinweizhao.system.module.manage.entity.SysUser;
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
     * @param roleId roleId
     * @param status status
     * @return boolean
     */
    boolean updateRoleStatusById(@Param("roleId") Long roleId,@Param("status") Integer status);

    /**
     * 通过 Id 查询角色
     * @param roleName roleName
     * @return SysRole
     */
    SysRole selectRoleByRoleName(String roleName);

    /**
     * 通过 Key 查询角色
     * @param roleKey roleKey
     * @return SysRole
     */
    SysRole selectRoleByRoleKey(String roleKey);


    /**
     * 获得角色列表，只要开启状态的
     * @param status status
     * @return List<SysRole>
     */
    List<SysRole> selectListSimpleRoles(int status);

    /**
     * 分页
     * @param page page
     * @param search search
     * @return IPage<SysRole>
     */
    IPage<SysRole> selectPageRoles(Page<SysRole> page, @Param("search") Search search);

    /**
     * 获取角色拥有的菜单
     * @param roleId roleId
     * @return List<Long>
     */
    List<Long> selectListMenuIdsByRoleId(Long roleId);
}
