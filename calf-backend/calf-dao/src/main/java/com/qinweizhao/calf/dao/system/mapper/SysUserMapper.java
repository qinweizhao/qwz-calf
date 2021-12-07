package com.qinweizhao.calf.dao.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qinweizhao.calf.dao.system.dataobject.SysUser;
import org.apache.ibatis.annotations.Mapper;

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
}
