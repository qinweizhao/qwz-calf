package com.qinweizhao.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qinweizhao.common.request.Search;
import com.qinweizhao.system.entity.SysUser;

import java.io.IOException;

/**
 * <p>
 * 系统用户 服务类
 * </p>
 *
 * @author qinweizhao
 * @since 2021-12-07
 */
public interface SysUserService extends IService<SysUser> {

    /**
     * 通过用户名查询用户
     *
     * @param username 　username
     * @return SysUser
     */
    SysUser selectUserByUsername(String username);

    /**
     * 通过用户 id 获取权限信息
     *
     * @param userId userId
     * @return String
     */
    String getAuthorityByUserId(Long userId);

    /**
     * 获取验证码
     *
     * @return base64编码
     * @throws IOException e
     */
    String getCaptcha() throws IOException;

    Object listPage(Search search, SysUser sysUser);

    boolean status(String ids, String status);
}
