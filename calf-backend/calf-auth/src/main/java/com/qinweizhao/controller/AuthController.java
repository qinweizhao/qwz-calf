package com.qinweizhao.controller;


import com.qinweizhao.base.response.R;
import com.qinweizhao.system.SysUserApi;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;

    /**
     * @author qinweizhao
     * @since 2021/9/27
     */
@RestController
public class AuthController {


    @Resource
    SysUserApi sysUserApi;

    /**
     * 获取验证码
     *
     * @return r
     * @throws IOException e
     */
    @GetMapping("/captcha")
    public R captcha() throws IOException {
        return R.success(sysUserApi.getCaptcha());
    }
}
