package com.qinweizhao.system.module.manage.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qinweizhao.common.response.Result;
import com.qinweizhao.system.module.manage.service.ISysNoticeService;
import com.qinweizhao.system.module.manage.entity.SysNotice;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * <p>
 * 通知公告表 前端控制器
 * </p>
 *
 * @author qinweizhao
 * @since 2021-12-22
 */
@RestController
@RequestMapping("/sys/notice")
public class SysNoticeController {

    @Resource
    private ISysNoticeService sysNoticeService;

    @PostMapping("/save")
    @ApiOperation("创建通知公告")
    @PreAuthorize("hasAuthority('system:notice:create')")
    public Result<Boolean> save(@Valid @RequestBody SysNotice sysNotice) {
        return Result.condition(sysNoticeService.save(sysNotice));
    }

    @PutMapping("/update")
    @ApiOperation("修改通知公告")
    @PreAuthorize("hasAuthority('system:notice:update')")
    public Result<Boolean> update(@Valid @RequestBody SysNotice sysNotice) {
        return Result.condition(sysNoticeService.updateById(sysNotice));
    }

    @DeleteMapping("/remove")
    @PreAuthorize("hasAuthority('system:notice:delete')")
    public Result<Boolean> remove(@RequestParam("id") Long id) {
        return Result.condition(sysNoticeService.removeById(id));
    }

    @GetMapping("/page")
    @ApiOperation("获取通知公告列表")
    @PreAuthorize("hasAuthority('system:notice:query')")
    public Result<IPage<SysNotice>> page(Page<SysNotice> page, @Validated SysNotice sysNotice) {
        QueryWrapper<SysNotice> queryWrapper = new QueryWrapper<>();
        return Result.success(sysNoticeService.page(page,queryWrapper));
    }

    @GetMapping("/get")
    @ApiOperation("获得通知公告")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    @PreAuthorize("hasAuthority('system:notice:query')")
    public Result<SysNotice> get(@RequestParam("id") Long id) {
        return Result.success(sysNoticeService.getById(id));
    }

}
