package com.qinweizhao.system.module.authority.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qinweizhao.api.system.dto.SysUserDTO;
import com.qinweizhao.common.base.BaseController;
import com.qinweizhao.common.response.Result;
import com.qinweizhao.system.module.authority.model.entity.SysDept;
import com.qinweizhao.system.module.authority.model.entity.SysUser;
import com.qinweizhao.system.module.authority.model.query.SysUserQuery;
import com.qinweizhao.system.module.authority.service.ISysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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
@Api(tags = "用户管理")
public class SysUserController extends BaseController {

    @Resource
    private ISysUserService sysUserService;


    /**
     * 获取用户详情
     * @param id id
     * @return SysUser
     */
    @GetMapping("/get")
    @ApiOperation(value = "获取用户", notes = "获取用户详情")
    public Result<SysUser> get(Long id) {
        return Result.success(sysUserService.getById(id));
    }

    /**
     * 修改
     *
     * @param sysUser 用户信息
     * @return Result
     */
    @PostMapping("/save")
    @ApiOperation(value = "设置用户", notes = "新增或修改用户")
    public Result<Object> save(@RequestBody SysUser sysUser) {
        sysUserService.saveUser(sysUser);
        return Result.success();
    }


    /**
     * 用户列表
     *
     * @return Result
     */
    @GetMapping("/page")
    public Result<Object> page(Page<SysUser> page,SysUserQuery sysUserQuery) {
        return Result.success(sysUserService.pageUsers(page,sysUserQuery));
    }

    /**
     * 修改
     *
     * @param sysUser 用户信息
     * @return Result
     */
    @PostMapping("/edit")
    @ApiOperation(value = "设置用户", notes = "修改用户")
    public Result<Object> edit(@Valid @RequestBody SysUser sysUser) {
        return Result.condition(sysUserService.updateById(sysUser));
    }

    /**
     * 登录成功后需要的信息
     *
     * @return Result
     */
    @GetMapping("/info")
    public Result<Map<Object, Object>> info() {
        return Result.success(sysUserService.getProjectInitInfo(getCurrentLoginUsername()));
    }

    /**
     * 用户删除
     *
     * @param ids id字符串，根据,号分隔
     * @return Result
     */
    @PostMapping("/delete")
    @ApiOperation(value = "用户删除", notes = "用户删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ids", required = true, value = "多个用,号隔开", paramType = "form")
    })
    public Result<Object> del(@RequestParam List<Long> ids) {
        return Result.condition(sysUserService.removeUserByIds(ids));
    }

    /**
     * 设置用户状态
     *
     * @param ids    id字符串，根据,号分隔
     * @param status 状态标识，启用或禁用
     * @return Result
     */
    @PostMapping("/setStatus")
    @ApiOperation(value = "用户状态", notes = "状态包括：启用、禁用")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ids", required = true, value = "多个用,号隔开", paramType = "form"),
            @ApiImplicitParam(name = "status", required = true, value = "状态", paramType = "form")
    })
    public Result<Object> setStatus(@RequestParam String ids, @RequestParam String status) {
        return Result.condition(false);
    }

    /**
     * 设置用户密码
     *
     * @param user 用户信息
     * @return Result
     */
    @PostMapping("/set-password")
    @ApiOperation(value = "用户密码设置", notes = "用户密码设置")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", required = true, value = "用户ID", paramType = "form"),
            @ApiImplicitParam(name = "password", required = true, value = "密码", paramType = "form")
    })
    public Result<Object> setPassword(@RequestBody SysUser user) {
        return Result.condition(sysUserService.updateById(user));
    }


}
