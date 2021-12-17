package com.qinweizhao.system.module.authority.controller;


import com.qinweizhao.common.base.BaseController;
import com.qinweizhao.common.response.Result;
import com.qinweizhao.system.module.authority.model.entity.SysMenu;
import com.qinweizhao.system.module.authority.service.ISysMenuService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 菜单权限表 前端控制器
 * </p>
 *
 * @author qinweizhao
 * @since 2021-12-06
 */
@RestController
@RequestMapping("/sys/menu")
public class SysMenuController extends BaseController {

    @Resource
    private ISysMenuService sysMenuService;

    @GetMapping("/tree")
    public Result<List<SysMenu>> tree() {
        List<SysMenu> list = sysMenuService.listWithTree(getCurrentLoginUsername());
        return Result.success(list);
    }


}
