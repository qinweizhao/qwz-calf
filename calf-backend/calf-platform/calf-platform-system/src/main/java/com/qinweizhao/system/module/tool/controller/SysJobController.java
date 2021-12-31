package com.qinweizhao.system.module.tool.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qinweizhao.common.core.response.Result;
import com.qinweizhao.common.core.util.ExcelUtils;
import com.qinweizhao.system.module.tool.entity.SysJob;
import com.qinweizhao.system.module.tool.service.ISysJobService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

/**
 * <p>
 * 定时任务表 前端控制器
 * </p>
 *
 * @author qinweizhao
 * @since 2021-12-27
 */
@RestController
@RequestMapping("/system/job")
public class SysJobController {

    @Resource
    private ISysJobService jobService;

    @PostMapping("/save")
    @ApiOperation("创建定时任务")
    @PreAuthorize("hasAuthority('system:job:create')")
    public Result<Long> saveJob(@Valid @RequestBody SysJob sysJob) {
        return Result.condition(jobService.save(sysJob));
    }

    @PutMapping("/update")
    @ApiOperation("更新定时任务")
    @PreAuthorize("hasAuthority('system:job:update')")
    public Result<Boolean> updateJob(@Valid @RequestBody SysJob sysJob) {
        jobService.updateById(sysJob);
        return Result.success(true);
    }
    //
    //@PutMapping("/update-status")
    //@ApiOperation("更新定时任务的状态")
    //@ApiImplicitParams({
    //        @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class),
    //        @ApiImplicitParam(name = "status", value = "状态", required = true, example = "1", dataTypeClass = Integer.class),
    //})
    //@PreAuthorize("hasAuthority('system:job:update')")
    //public Result<Boolean> updateJobStatus(@RequestParam(value = "id") Long id, @RequestParam("status") Integer status)
    //{
    //    jobService.updateJobStatus(id, status);
    //    return Result.success(true);
    //}

    @DeleteMapping("/remove")
    @ApiOperation("删除定时任务")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    @PreAuthorize("hasAuthority('system:job:delete')")
    public Result<Boolean> deleteJob(@RequestParam("id") Long id) {
        jobService.removeById(id);
        return Result.success(true);
    }
    //
    //@PutMapping("/trigger")
    //@ApiOperation("触发定时任务")
    //@ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    //@PreAuthorize("hasAuthority('system:job:trigger')")
    //public Result<Boolean> triggerJob(@RequestParam("id") Long id) throws SchedulerException {
    //    jobService.triggerJob(id);
    //    return Result.success(true);
    //}

    @GetMapping("/get")
    @ApiOperation("获得定时任务")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    @PreAuthorize("hasAuthority('system:job:query')")
    public Result<SysJob> getJob(@RequestParam("id") Long id) {
        SysJob job = jobService.getById(id);
        return Result.success(job);
    }

    @GetMapping("/list")
    @ApiOperation("获得定时任务列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, dataTypeClass = List.class)
    @PreAuthorize("hasAuthority('system:job:query')")
    public Result<List<SysJob>> getJobList(@RequestParam("ids") Collection<Long> ids) {
        List<SysJob> list = jobService.list();
        return Result.success(list);
    }

    @GetMapping("/page")
    @ApiOperation("获得定时任务分页")
    @PreAuthorize("hasAuthority('system:job:query')")
    public Result<IPage<SysJob>> getJobPage(Page<SysJob> page) {
        IPage<SysJob> pageResult = jobService.page(page);
        return Result.success(pageResult);
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出定时任务 Excel")
    @PreAuthorize("hasAuthority('system:job:export')")
    //@SysLog(value = "EXPORT")
    public void exportJobExcel(@Valid SysJob exportReqVO,
                               HttpServletResponse response) throws IOException {
        List<SysJob> list = jobService.list();
        // 导出 Excel
        ExcelUtils.write(response, "定时任务.xls", "数据", SysJob.class, list);
    }

    //@GetMapping("/get_next_times")
    //@ApiOperation("获得定时任务的下 n 次执行时间")
    //@ApiImplicitParams({
    //        @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class),
    //        @ApiImplicitParam(name = "count", value = "数量", example = "5", dataTypeClass = Long.class)
    //})
    //@PreAuthorize("hasAuthority('system:job:query')")
    //public Result<List<Date>> getJobNextTimes(@RequestParam("id") Long id,
    //                                                @RequestParam(value = "count", required = false, defaultValue = "5") Integer count) {
    //    SysJob job = jobService.getById(id);
    //    if (job == null) {
    //        return Result.success(Collections.emptyList());
    //    }
    //    return Result.success(CronUtils.getNextTimes(job.getCronExpression(), count));
    //}
}
