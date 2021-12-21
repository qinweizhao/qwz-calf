package com.qinweizhao.system.module.authority.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qinweizhao.common.response.Result;
import com.qinweizhao.system.module.authority.model.entity.SysRole;
import com.qinweizhao.system.module.authority.service.ISysRoleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 角色表 前端控制器
 * </p>
 *
 * @author qinweizhao
 * @since 2021-12-06
 */
@RestController
@RequestMapping("/sys/role")
public class SysRoleController {

    @Resource
    private ISysRoleService sysRoleService;


    /**
     * 用户列表
     *
     * @return Result
     */
    @GetMapping("/page")
    public Result<Object> page(Page<SysRole> page) {
        return Result.success(sysRoleService.page(page));
    }
}
