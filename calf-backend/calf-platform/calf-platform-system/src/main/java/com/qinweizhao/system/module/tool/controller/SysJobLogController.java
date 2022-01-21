package com.qinweizhao.system.module.tool.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.qinweizhao.api.system.dto.SysJobLogDTO;
import com.qinweizhao.api.system.dto.query.SysJobLogPageQry;
import com.qinweizhao.api.system.vo.SysJobLogVO;
import com.qinweizhao.common.core.response.Result;
import com.qinweizhao.system.module.tool.convert.SysJobLogConvert;
import com.qinweizhao.system.module.tool.service.ISysJobLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Collection;
import java.util.List;

/**
 * <p>
 * 定时任务日志表 前端控制器
 * </p>
 *
 * @author qinweizhao
 * @since 2021-12-27
 */
@Api(tags = "任务日志")
@RestController
@RequestMapping("/system/tool/job/log")
public class SysJobLogController {

    @Resource
    private ISysJobLogService jobLogService;

    @GetMapping("/get")
    @ApiOperation("获得定时任务日志")
    @ApiImplicitParam(name = "jobLogId", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    @PreAuthorize("hasAuthority('system:job:query')")
    public Result<SysJobLogVO> getJobLog(@RequestParam("jobLogId") Long jobLogId) {
        SysJobLogDTO jobLog = jobLogService.getJobLog(jobLogId);
        return Result.success(SysJobLogConvert.INSTANCE.convert(jobLog));
    }

    @GetMapping("/list")
    @ApiOperation("获得定时任务日志列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("hasAuthority('system:job:query')")
    public Result<List<SysJobLogVO>> getJobLogList(@RequestParam("ids") Collection<Long> ids) {
        List<SysJobLogDTO> list = jobLogService.listJobLogs(ids);
        return Result.success(SysJobLogConvert.INSTANCE.convertToVO(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得定时任务日志分页")
    @PreAuthorize("hasAuthority('system:job:query')")
    public Result<IPage<SysJobLogVO>> getJobLogPage(@Valid SysJobLogPageQry sysJobLogPageQry) {
        IPage<SysJobLogDTO> pageResult = jobLogService.pageJobLogs(sysJobLogPageQry);
        return Result.success(SysJobLogConvert.INSTANCE.convertToVO(pageResult));
    }


}
