package com.qinweizhao.system.module.manage.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qinweizhao.common.core.response.Result;
import com.qinweizhao.common.core.util.ExcelUtils;
import com.qinweizhao.system.module.manage.entity.SysPost;
import com.qinweizhao.system.module.manage.service.ISysPostService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

/**
 * <p>
 * 岗位信息表 前端控制器
 * </p>
 *
 * @author qinweizhao
 * @since 2021-12-06
 */
@RestController
@RequestMapping("/sys/post")
public class SysPostController {


    @Resource
    private ISysPostService sysPostService;

    @GetMapping("/list")
    public Result<List<SysPost>> list() {
        return Result.success(sysPostService.list());
    }

    @PostMapping("/save")
    @ApiOperation("创建岗位")
    @PreAuthorize("hasAuthority('system:post:save')")
    public Result<Long> save(@Valid @RequestBody SysPost sysPost) {
        return Result.condition(sysPostService.save(sysPost));
    }

    @PutMapping("/update")
    @ApiOperation("修改岗位")
    @PreAuthorize("hasAuthority('system:post:update')")
    public Result<Boolean> updatePost(@Valid @RequestBody SysPost sysPost) {
        return Result.condition(sysPostService.updateById(sysPost));
    }

    @DeleteMapping("/remove")
    @ApiOperation("删除岗位")
    @PreAuthorize("hasAuthority('system:post:remove')")
    public Result<Boolean> remove(@RequestParam("id") Long id) {
        return Result.condition(sysPostService.removeById(id));
    }

    @GetMapping(value = "/get")
    @ApiOperation("获得岗位信息")
    @ApiImplicitParam(name = "id", value = "岗位编号", required = true, example = "1024", dataTypeClass = Long.class)
    @PreAuthorize("hasAuthority('system:post:query')")
    public Result<SysPost> get(@RequestParam("id") Long id) {
        return Result.success(sysPostService.getById(id));
    }

    @GetMapping("/page")
    @ApiOperation("获得岗位分页列表")
    @PreAuthorize("hasAuthority('system:post:query')")
    public Result<IPage<SysPost>> page(Page<SysPost> page, @Validated SysPost sysPost) {
        return Result.success(sysPostService.page(page));
    }

    @GetMapping("/export")
    @ApiOperation("岗位管理")
    @PreAuthorize("hasAuthority('system:post:export')")
    //@SysLog(value = "EXPORT")
    public void export(HttpServletResponse response, @Validated SysPost sysPost) throws IOException {
        List<SysPost> posts = sysPostService.list();
        ExcelUtils.write(response, "岗位数据.xls", "岗位列表", SysPost.class, posts);
    }

}
