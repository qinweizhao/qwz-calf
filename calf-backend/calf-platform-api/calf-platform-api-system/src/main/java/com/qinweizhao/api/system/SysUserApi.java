package com.qinweizhao.api.system;

import com.qinweizhao.api.system.dto.SysUserDTO;

import java.io.IOException;

/**
 * @author qinweizhao
 * @since 2021/12/13
 */
public interface SysUserApi {


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

    /**
     * 查询用户 id
     *
     * @param username 用户名
     * @return SysUserDTO
     */
    SysUserDTO selectUserIdByUsername(String username);
}
