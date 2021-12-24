package com.qinweizhao.system.module.manage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qinweizhao.system.module.manage.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Set;

/**
 * <p>
 * 系统用户 Mapper 接口
 * </p>
 *
 * @author qinweizhao
 * @since 2021-12-06
 */
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {


    /**
     * 通过用户名查询用户
     *
     * @param username 　username
     * @return SysUser
     */
    SysUser selectUserByUsername(String username);

    /**
     * 通过用户 id 查询角色
     *
     * @param userId userId
     * @return Set<String>
     */
    Set<String> selectRolesByUserId(Long userId);

    /**
     * 通过用户 id 查询权限标识
     *
     * @param userId userId
     * @return Set<String>
     */
    Set<String> selectPermissionsByUserId(Long userId);


    /**
     * 通过用户名查询用户
     * @param username username
     * @return return
     */
    Long selectUserIdByUsername(String username);

    IPage<SysUser> selectPageUsers(Page<SysUser> page, @Param("query") SysUser sysUser);

    SysUser selectUserByEmail(String email);

    SysUser selectUserByPhone(String phone);
}
