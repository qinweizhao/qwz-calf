package com.qinweizhao.system.module.manage.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qinweizhao.common.core.response.Result;
import com.qinweizhao.common.core.util.ExcelUtils;
import com.qinweizhao.system.module.manage.entity.SysRole;
import com.qinweizhao.system.module.manage.service.ISysRoleService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;

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
    @ApiOperation("获得角色分页")
    @PreAuthorize("hasAuthority('system:role:query')")
    @GetMapping("/page")
    public Result<Object> page(Page<SysRole> page) {
        return Result.success(sysRoleService.page(page));
    }

    

    @PostMapping("/save")
    @ApiOperation("创建角色")
    @PreAuthorize("hasAuthority('system:role:save')")
    public Result<Boolean> save(@Valid @RequestBody SysRole sysRole) {
        return Result.condition(sysRoleService.save(sysRole));
    }

    @PutMapping("/update")
    @ApiOperation("修改角色")
    @PreAuthorize("hasAuthority('system:role:update')")
    public Result<Boolean> updateRole(@Valid @RequestBody SysRole sysRole) {
        return Result.condition(sysRoleService.updateById(sysRole));
    }

    //@PutMapping("/update/status")
    //@ApiOperation("修改角色状态")
    //@PreAuthorize("hasAuthority('system:role:update')")
    //public Result<Boolean> updateRoleStatus(@Valid @RequestBody SysRole sysRole) {
    //    sysRoleService.updateRoleStatus(sysRole.getRoleId(), sysRole.getStatus());
    //    return Result.success(true);
    //}

    @DeleteMapping("/delete")
    @ApiOperation("删除角色")
    @ApiImplicitParam(name = "id", value = "角色编号", required = true, example = "1024", dataTypeClass = Long.class)
    @PreAuthorize("hasAuthority('system:role:delete')")
    public Result<Boolean> deleteRole(@RequestParam("id") Long id) {
        sysRoleService.removeById(id);
        return Result.success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得角色信息")
    @PreAuthorize("hasAuthority('system:role:query')")
    public Result<SysRole> get(@RequestParam("id") Long id) {
        return Result.success(sysRoleService.getById(id));
    }

    @GetMapping("/list-all-simple")
    @ApiOperation(value = "获取角色精简信息列表", notes = "只包含被开启的角色，主要用于前端的下拉选项")
    public Result<List<SysRole>> getSimpleRoles() {
        // 获得角色列表，只要开启状态的
        List<SysRole> list = sysRoleService.list();
        // 排序后，返回个诶前端
        list.sort(Comparator.comparing(SysRole::getSort));
        return Result.success(list);
    }

    @GetMapping("/export")
    //@SysLog(value = "EXPORT")
    @PreAuthorize("hasAuthority('system:role:export')")
    public void export(HttpServletResponse response, @Validated SysRole sysRole) throws IOException {
        List<SysRole> list = sysRoleService.list();
        // 输出
        ExcelUtils.write(response, "角色数据.xls", "角色列表", SysRole.class, list);
    }
}
