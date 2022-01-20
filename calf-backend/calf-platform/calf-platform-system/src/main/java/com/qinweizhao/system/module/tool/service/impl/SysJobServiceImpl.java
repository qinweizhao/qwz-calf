package com.qinweizhao.system.module.tool.service.impl;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.qinweizhao.api.system.dto.SysJobDTO;
import com.qinweizhao.api.system.dto.command.SysJobSaveCmd;
import com.qinweizhao.api.system.dto.command.SysJobUpdateCmd;
import com.qinweizhao.api.system.dto.query.SysJobPageQry;
import com.qinweizhao.common.core.exception.ServiceException;
import com.qinweizhao.common.core.response.ResultCode;
import com.qinweizhao.common.core.util.PageUtil;
import com.qinweizhao.system.module.tool.convert.SysJobConvert;
import com.qinweizhao.system.module.tool.entity.SysJob;
import com.qinweizhao.system.module.tool.enums.JobStatusEnum;
import com.qinweizhao.system.module.tool.mapper.SysJobMapper;
import com.qinweizhao.system.module.tool.service.ISysJobService;
import com.qinweizhao.system.module.tool.utils.ScheduleUtils;
import org.quartz.CronExpression;
import org.quartz.Scheduler;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

/**
 * <p>
 * 定时任务表 服务实现类
 * </p>
 *
 * @author qinweizhao
 * @since 2021-12-27
 */
@Service
public class SysJobServiceImpl implements ISysJobService {

    @Resource
    private SysJobMapper sysJobMapper;

    @Resource
    private Scheduler scheduler;

    /**
     * 监控超时时间是否为空
     *
     * @param sysJob sysJob
     */
    private static void fillJobMonitorTimeoutEmpty(SysJob sysJob) {
        if (sysJob.getMonitorTimeout() == null) {
            sysJob.setMonitorTimeout(0);
        }
    }

    @Override
    public int saveJob(SysJobSaveCmd sysJobSaveCmd) {
        validateCronExpression(sysJobSaveCmd.getCronExpression());
        // 校验唯一性
        if (sysJobMapper.selectByHandlerName(sysJobSaveCmd.getHandlerName()) != null) {
            throw new ServiceException(ResultCode.JOB_HANDLER_EXISTS);
        }
        // 插入
        SysJob sysJob = SysJobConvert.INSTANCE.convert(sysJobSaveCmd);
        sysJob.setStatus(JobStatusEnum.INIT.getStatus());
        // 监控超时时间是否为空
        fillJobMonitorTimeoutEmpty(sysJob);
        int i = sysJobMapper.insert(sysJob);
        ScheduleUtils.createScheduleJob(scheduler, sysJob);
        return i;
    }

    /**
     * 校验 Cron 表达式
     *
     * @param cronExpression cronExpression
     */
    private void validateCronExpression(String cronExpression) {
        if (!CronExpression.isValidExpression(cronExpression)) {
            throw new ServiceException(ResultCode.JOB_CRON_EXPRESSION_VALID);
        }
    }

    @Override
    public int updateJob(SysJobUpdateCmd sysJobUpdateCmd) {
        validateCronExpression(sysJobUpdateCmd.getCronExpression());
        // 校验存在
        SysJob checkSysJob = this.validateJobExists(sysJobUpdateCmd.getJobId());
        // 只有开启状态，才可以修改.原因是，如果出暂停状态，修改 Quartz Job 时，会导致任务又开始执行
        if (!checkSysJob.getStatus().equals(JobStatusEnum.NORMAL.getStatus())) {
            throw new ServiceException(ResultCode.JOB_UPDATE_ONLY_NORMAL_STATUS);
        }
        // 更新
        SysJob sysJob = SysJobConvert.INSTANCE.convert(sysJobUpdateCmd);
        fillJobMonitorTimeoutEmpty(sysJob);
        int i = sysJobMapper.updateById(sysJob);
        // 更新 Job 到 Quartz 中
        ScheduleUtils.updateScheduleJob(scheduler, sysJob);
        return i;
    }


    /**
     * 校验任务是否存在
     *
     * @param jobId jobId
     * @return SysJob
     */
    private SysJob validateJobExists(Long jobId) {
        SysJob sysJob = sysJobMapper.selectById(jobId);
        if (sysJob == null) {
            throw new ServiceException(ResultCode.JOB_NOT_EXISTS);
        }
        return sysJob;
    }

    @Override
    public int updateJobStatus(Long jobId, Integer status) {
        // 校验存在
        SysJob checkSysJob = this.validateJobExists(jobId);
        // 校验是否已经为当前状态
        if (checkSysJob.getStatus().equals(status)) {
            throw new ServiceException(ResultCode.JOB_CHANGE_STATUS_EQUALS);
        }
        // 更新 Job 状态
        SysJob sysJob = new SysJob();
        sysJob.setStatus(status);
        int i = sysJobMapper.updateById(sysJob);
        // 更新状态 Job 到 Quartz 中

        if (JobStatusEnum.NORMAL.getStatus().equals(status)) {
            // 开启
            ScheduleUtils.resumeJob(scheduler, sysJob.getJobId());
        } else {
            // 暂停
            ScheduleUtils.pauseJob(scheduler, sysJob.getJobId());
        }
        return i;
    }

    @Override
    public int removeJob(Long jobId) {
        // 校验存在
        this.validateJobExists(jobId);
        // 更新
        int i = sysJobMapper.deleteById(jobId);
        // 删除 Job 到 Quartz 中
        ScheduleUtils.deleteScheduleJob(scheduler, jobId);
        return i;
    }

    @Override
    public void triggerJob(Long jobId) {
        SysJob sysJob = sysJobMapper.selectById(jobId);
        ScheduleUtils.run(scheduler, sysJob);
    }

    @Override
    public SysJobDTO getJob(Long jobId) {
        return SysJobConvert.INSTANCE.convert(sysJobMapper.selectById(jobId));
    }

    @Override
    public List<SysJobDTO> listJobs(Collection<Long> jobIds) {
        return SysJobConvert.INSTANCE.convertToDTO(sysJobMapper.selectBatchIds(jobIds));
    }

    @Override
    public IPage<SysJobDTO> pageJobs(SysJobPageQry sysJobPageQry) {
        IPage<SysJob> pageDTO = sysJobMapper.selectPageJobs(PageUtil.getPage(sysJobPageQry), sysJobPageQry);
        return SysJobConvert.INSTANCE.convertToDTO(pageDTO);
    }
}
