package com.qinweizhao.admin.system;


import com.qinweizhao.common.controller.BaseController;
import com.qinweizhao.system.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author QinWeiZhao
 * @since 2021-07-13
 */
@RestController
@RequestMapping("/sys/menu")
public class SysMenuController extends BaseController {


    @Resource
    private SysMenuService sysMenuService;

    @GetMapping("/test")
    public String testMenu() {
        return sysMenuService.list().get(0).toString();
    }

}
