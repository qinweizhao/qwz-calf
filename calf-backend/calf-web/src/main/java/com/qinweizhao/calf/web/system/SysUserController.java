package com.qinweizhao.calf.web.system;


import com.qinweizhao.calf.api.system.SysUserService;
import com.qinweizhao.calf.base.response.R;
import com.qinweizhao.calf.dao.system.dataobject.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

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


    @RequestMapping("/all")
    public List<SysUser> all(){
        return sysUserService.list();
    }

    /**
     * 获取验证码
     *
     * @return r
     * @throws IOException e
     */
    @GetMapping("/captcha")
    public R captcha() throws IOException {
        return R.success(sysUserService.getCaptcha());
    }
}
