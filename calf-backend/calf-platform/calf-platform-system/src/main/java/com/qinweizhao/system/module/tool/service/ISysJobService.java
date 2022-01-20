package com.qinweizhao.system.module.tool.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.qinweizhao.api.system.dto.SysJobDTO;
import com.qinweizhao.api.system.dto.command.SysJobSaveCmd;
import com.qinweizhao.api.system.dto.command.SysJobUpdateCmd;
import com.qinweizhao.api.system.dto.query.SysJobPageQry;

import java.util.Collection;
import java.util.List;

/**
 * <p>
 * 定时任务表 服务类
 * </p>
 *
 * @author qinweizhao
 * @since 2021-12-27
 */
public interface ISysJobService {

    int saveJob(SysJobSaveCmd sysJobSaveCmd);


    int updateJob(SysJobUpdateCmd sysJobUpdateCmd);

    int updateJobStatus(Long id, Integer status);

    int removeJob(Long jobId);

    void triggerJob(Long jobId);

    SysJobDTO getJob(Long jobId);

    List<SysJobDTO> listJobs(Collection<Long> jobIds);

    IPage<SysJobDTO> pageJobs(SysJobPageQry sysJobPageQry);
}
