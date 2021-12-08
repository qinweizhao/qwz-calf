package com.qinweizhao.system;




import com.qinweizhao.system.entity.SysUser;

import java.io.IOException;

/**
 * @author qinweizhao
 * @since 2021/12/8
 */
public interface SysUserApi {

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
}
