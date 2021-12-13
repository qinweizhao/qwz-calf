package com.qinweizhao.system.api;

import com.qinweizhao.system.service.ISysUserService;
import com.qinweizhao.system.service.SysUserApi;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @author qinweizhao
 * @since 2021/12/13
 */
@Service
public class SysUserApiImpl implements SysUserApi {
    @Resource
    ISysUserService sysUserService;

    @Override
    public String getAuthorityByUserId(Long userId) {
        return sysUserService.getAuthorityByUserId(userId);
    }

    @Override
    public String getCaptcha() throws IOException {
        return sysUserService.getCaptcha();
    }

    @Override
    public Long selectUserIdByUsername(String username) {
        return sysUserService.selectUserIdByUsername(username);
    }
}
