package com.qinweizhao.controller;


import com.qinweizhao.common.response.Result;
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
        public Result<String> captcha() throws IOException {
            return Result.data(sysUserApi.getCaptcha());
        }
}
