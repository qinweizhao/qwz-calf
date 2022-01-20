package com.qinweizhao.system.module.tool.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.qinweizhao.api.system.dto.SysJobLogDTO;
import com.qinweizhao.api.system.dto.query.SysJobLogPageQry;

import java.util.Collection;
import java.util.List;

/**
 * <p>
 * 定时任务日志表 服务类
 * </p>
 *
 * @author qinweizhao
 * @since 2021-12-27
 */
public interface ISysJobLogService {

    SysJobLogDTO getJobLog(Long id);

    List<SysJobLogDTO> listJobLogs(Collection<Long> ids);

    IPage<SysJobLogDTO> pageJobLogs(SysJobLogPageQry sysJobLogPageQry);
}
