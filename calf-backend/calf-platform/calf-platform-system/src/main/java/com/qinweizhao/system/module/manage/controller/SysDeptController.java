package com.qinweizhao.system.module.manage.controller;


import com.qinweizhao.common.core.response.Result;
import com.qinweizhao.system.module.manage.entity.SysDept;
import com.qinweizhao.system.module.manage.service.ISysDeptService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Comparator;
import java.util.List;

/**
 * <p>
 * 部门表 前端控制器
 * </p>
 *
 * @author qinweizhao
 * @since 2021-12-06
 */
@RestController
@RequestMapping("/sys/dept")
public class SysDeptController {

    @Resource
    ISysDeptService sysDeptService;


    @ApiOperation("获取部门列表")
    @PreAuthorize("hasAuthority('system:dept:query')")
    @GetMapping("/list")
    public Result<Object> list() {
        return Result.success(sysDeptService.list());
    }


    @PostMapping("save")
    @ApiOperation("创建部门")
    @PreAuthorize("hasAuthority('system:dept:create')")
    public Result<Boolean> createDept(@Valid @RequestBody SysDept sysDept) {
        return Result.condition(sysDeptService.save(sysDept));
    }

    @PutMapping("update")
    @ApiOperation("更新部门")
    @PreAuthorize("hasAuthority('system:dept:update')")
    public Result<Boolean> updateDept(@Valid @RequestBody SysDept sysDept) {
        return Result.condition(sysDeptService.updateById(sysDept));
    }

    @DeleteMapping("delete")
    @ApiOperation("删除部门")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    @PreAuthorize("hasAuthority('system:dept:delete')")
    public Result<Boolean> deleteDept(@RequestParam("id") Long id) {
        return Result.success(sysDeptService.removeById(id));
    }


    @GetMapping("/list-all-simple")
    @ApiOperation(value = "获取部门精简信息列表", notes = "只包含被开启的部门，主要用于前端的下拉选项")
    public Result<List<SysDept>> getSimpleDepts() {
        // 获得部门列表，只要开启状态的
        List<SysDept> list = sysDeptService.list();
        // 排序后，返回给前端
        list.sort(Comparator.comparing(SysDept::getSort));
        return Result.success(list);
    }

    @GetMapping("/get")
    @ApiOperation("获得部门信息")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    @PreAuthorize("hasAuthority('system:dept:query')")
    public Result<SysDept> getDept(@RequestParam("id") Long id) {
        return Result.success(sysDeptService.getById(id));
    }

}
