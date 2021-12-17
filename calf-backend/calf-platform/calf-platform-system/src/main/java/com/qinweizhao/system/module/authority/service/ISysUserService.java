package com.qinweizhao.system.module.authority.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qinweizhao.system.module.authority.entity.SysUser;

import java.util.Map;

/**
 * <p>
 * 系统用户 服务类
 * </p>
 *
 * @author qinweizhao
 * @since 2021-12-10
 */
public interface ISysUserService extends IService<SysUser> {

    /**
     * 通过用户名查询用户
     *
     * @param username 　username
     * @return SysUser
     */
    SysUser getUserByUsername(String username);

    /**
     * 通过用户 id 获取权限信息
     *
     * @param userId userId
     * @return String
     */
    String getAuthorityByUserId(Long userId);


    /**
     * 获取项目初始化需要的信息
     * @param currentLoginUsername 当前登录的用户名
     * @return user roles permissions
     */
    Map<Object,Object> getProjectInitInfo(String currentLoginUsername);
}
