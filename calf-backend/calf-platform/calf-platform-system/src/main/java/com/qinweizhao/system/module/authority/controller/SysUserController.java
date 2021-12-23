package com.qinweizhao.system.module.authority.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qinweizhao.common.base.BaseController;
import com.qinweizhao.common.response.Result;
import com.qinweizhao.system.module.authority.model.entity.SysUser;
import com.qinweizhao.system.module.authority.service.ISysUserService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

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
public class SysUserController extends BaseController {

    @Resource
    private ISysUserService sysUserService;


    @GetMapping("/info")
    public Result<Map<Object, Object>> info() {
        return Result.success(sysUserService.getProjectInitInfo(getCurrentLoginUsername()));
    }


    @GetMapping("/get")
    public Result<SysUser> get(Long id) {
        return Result.success(sysUserService.getUserById(id));
    }


    @GetMapping("/page")
    public Result<IPage<SysUser>> page(Page<SysUser> page, SysUser sysUser) {
        return Result.success(sysUserService.pageUsers(page, sysUser));
    }


    @PostMapping("/save")
    public Result<Object> save(@RequestBody SysUser sysUser) {
        return Result.success(sysUserService.saveUser(sysUser));
    }


    @PostMapping("/edit")
    public Result<Object> edit(@Valid @RequestBody SysUser sysUser) {
        sysUserService.updateUserById(sysUser);
        return Result.success();
    }


    @GetMapping("/delete")
    public Result<Object> delete(@RequestParam List<Long> id) {
        return Result.condition(sysUserService.removeUserByIds(id));
    }

}
