package com.qinweizhao.system.module.controller;


import com.qinweizhao.common.base.BaseException;
import com.qinweizhao.common.request.Search;
import com.qinweizhao.common.response.Result;
import com.qinweizhao.system.module.entity.SysUser;
import com.qinweizhao.system.module.service.ISysPostService;
import com.qinweizhao.system.module.service.ISysRoleService;
import com.qinweizhao.system.module.service.ISysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
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
@RequestMapping("/user")
@Api(tags = "用户管理")
public class SysUserController {

    @Resource
    private ISysUserService sysUserService;

    @Resource
    private ISysRoleService sysRoleService;

    @Resource
    private ISysPostService sysPostService;

    /**
     * 用户列表
     *
     * @param search 　搜索关键词
     * @return Result
     */
    @GetMapping("/page")
    public Result<Object> page(Search search, SysUser sysUser) {
        return Result.success(sysUserService.listPage(search, sysUser));
    }

    /**
     * 设置用户，支持新增或修改
     *
     * @param sysUser 用户信息
     * @return Result
     */
    @PostMapping("/edit")
    @ApiOperation(value = "设置用户", notes = "新增或修改用户")
    public Result<Object> edit(@Valid @RequestBody SysUser sysUser) {
        return Result.condition(sysUserService.updateById(sysUser));
    }

    /**
     * 用户信息
     *
     * @param id Id信息
     * @return Result
     */
    @GetMapping("/info")
    @ApiOperation(value = "用户信息", notes = "根据ID查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", required = true, value = "用户ID", paramType = "form"),
    })
    public Result<SysUser> get(@RequestParam String id) {
        return Result.success(sysUserService.getById(id));
    }

    /**
     * 用户删除
     *
     * @param ids id字符串，根据,号分隔
     * @return Result
     */
    @PostMapping("/del")
    @ApiOperation(value = "用户删除", notes = "用户删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ids", required = true, value = "多个用,号隔开", paramType = "form")
    })
    public Result<Object> del(@RequestParam List<String> ids) {
        return Result.condition(sysUserService.removeByIds(ids));
    }

    /**
     * 设置用户状态
     *
     * @param ids    id字符串，根据,号分隔
     * @param status 状态标识，启用或禁用
     * @return Result
     */
    @PostMapping("/set-status")
    @ApiOperation(value = "用户状态", notes = "状态包括：启用、禁用")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ids", required = true, value = "多个用,号隔开", paramType = "form"),
            @ApiImplicitParam(name = "status", required = true, value = "状态", paramType = "form")
    })
    public Result<Object> setStatus(@RequestParam String ids, @RequestParam String status) {
        return Result.condition(sysUserService.status(ids, status));
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
