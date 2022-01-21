package com.qinweizhao.system.module.monitor.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.qinweizhao.api.system.dto.query.SysLogPageQry;
import com.qinweizhao.api.system.vo.SysLogVO;
import com.qinweizhao.common.core.response.Result;
import com.qinweizhao.system.module.manage.convert.SysLogConvert;
import com.qinweizhao.system.module.monitor.service.ISysLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 日志表 前端控制器
 * </p>
 *
 * @author qinweizhao
 * @since 2022-01-20
 */
@Api(tags = "日志记录")
@RestController
@RequestMapping("/system/monitor/log")
public class SysLogController {

    @Resource
    private ISysLogService sysLogService;


    @ApiOperation("获得日志分页")
    @PreAuthorize("hasAuthority('system:role:select')")
    @GetMapping("/page")
    public Result<IPage<SysLogVO>> page(SysLogPageQry sysLogPageQry) {
        return Result.success(SysLogConvert.INSTANCE.convertToVO(sysLogService.pageLogs(sysLogPageQry)));
    }

}
