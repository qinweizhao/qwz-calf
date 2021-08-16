package com.qinweizhao.modules.system;


import com.qinweizhao.common.controller.BaseController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * <p>
 * 菜单权限表 前端控制器
 * </p>
 *
 * @author qinweizhao
 * @since 2021-07-29
 */
@RestController
@RequestMapping("/sys/menu")
public class SysMenuController extends BaseController {

    @GetMapping("/test")
    public String test() {
        return "test";
    }

}
