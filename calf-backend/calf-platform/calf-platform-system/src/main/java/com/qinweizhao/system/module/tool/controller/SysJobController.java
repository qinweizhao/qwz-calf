package com.qinweizhao.system.module.tool.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qinweizhao.api.system.dto.SysJobDTO;
import com.qinweizhao.api.system.dto.command.SysJobSaveCmd;
import com.qinweizhao.api.system.dto.command.SysJobUpdateCmd;
import com.qinweizhao.api.system.dto.query.SysJobPageQry;
import com.qinweizhao.api.system.vo.SysJobVO;
import com.qinweizhao.common.core.response.Result;
import com.qinweizhao.system.module.tool.convert.SysJobConvert;
import com.qinweizhao.system.module.tool.service.ISysJobService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
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
@Api(tags = "定时任务")
@RestController
@RequestMapping("/system/tool/job")
public class SysJobController {

    @Resource
    private ISysJobService sysJobService;


    @PostMapping("/save")
    @ApiOperation("创建定时任务")
    @PreAuthorize("hasAuthority('system:job:create')")
    public Result<Boolean> createJob(@Valid @RequestBody SysJobSaveCmd sysJobSaveCmd) {
        return Result.condition(sysJobService.saveJob(sysJobSaveCmd));
    }

    @PutMapping("/update")
    @ApiOperation("更新定时任务")
    @PreAuthorize("hasAuthority('system:job:update')")
    public Result<Boolean> updateJob(@Valid @RequestBody SysJobUpdateCmd sysJobUpdateCmd) {
        return Result.condition(sysJobService.updateJob(sysJobUpdateCmd));
    }

    @PutMapping("/update-status")
    @ApiOperation("更新定时任务的状态")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "jobId", value = "编号", required = true, example = "1024", dataTypeClass = Long.class),
            @ApiImplicitParam(name = "status", value = "状态", required = true, example = "1", dataTypeClass = Integer.class),
    })
    @PreAuthorize("hasAuthority('system:job:update')")
    public Result<Boolean> updateJobStatus(@RequestParam(value = "jobId") Long jobId, @RequestParam("status") Integer status) {
        return Result.condition(sysJobService.updateJobStatus(jobId, status));
    }

    @DeleteMapping("/remove")
    @ApiOperation("删除定时任务")
    @ApiImplicitParam(name = "jobId", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    @PreAuthorize("hasAuthority('system:job:delete')")
    public Result<Boolean> deleteJob(@RequestParam("jobId") Long jobId) {
        return Result.condition(sysJobService.removeJob(jobId));
    }

    @PutMapping("/trigger")
    @ApiOperation("触发定时任务")
    @ApiImplicitParam(name = "jobId", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    @PreAuthorize("hasAuthority('system:job:trigger')")
    public Result<Boolean> trigger(@RequestParam("jobId") Long jobId) {
        sysJobService.triggerJob(jobId);
        return Result.success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得定时任务")
    @ApiImplicitParam(name = "jobId", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    @PreAuthorize("hasAuthority('system:job:query')")
    public Result<SysJobVO> getJob(@RequestParam("jobId") Long jobId) {
        SysJobDTO job = sysJobService.getJob(jobId);
        return Result.success(SysJobConvert.INSTANCE.convert(job));
    }

    @GetMapping("/list")
    @ApiOperation("获得定时任务列表")
    @ApiImplicitParam(name = "jobIds", value = "编号列表", required = true, dataTypeClass = List.class)
    @PreAuthorize("hasAuthority('system:job:query')")
    public Result<List<SysJobVO>> list(@RequestParam("jobIds") Collection<Long> jobIds) {
        List<SysJobDTO> list = sysJobService.listJobs(jobIds);
        return Result.success(SysJobConvert.INSTANCE.convertToVO(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得定时任务分页")
    @PreAuthorize("hasAuthority('system:job:query')")
    public Result<Page<SysJobVO>> getJobPage(@Valid SysJobPageQry sysJobPageQry) {
        IPage<SysJobDTO> pageResult = sysJobService.pageJobs(sysJobPageQry);
        return Result.success(SysJobConvert.INSTANCE.convertToVO(pageResult));
    }


}
