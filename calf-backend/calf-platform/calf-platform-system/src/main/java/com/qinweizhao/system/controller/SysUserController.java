package com.qinweizhao.system.controller;


import com.qinweizhao.system.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 系统用户 前端控制器
 * </p>
 *
 * @author qinweizhao
 * @since 2021-12-06
 */
@RestController
@RequestMapping("/sys/user")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;


    /**
     * info
     * @return List<SysUser>
     */
    @RequestMapping("/info")
    public Object all(Authentication authentication) {
        return authentication.getPrincipal();
    }

}
