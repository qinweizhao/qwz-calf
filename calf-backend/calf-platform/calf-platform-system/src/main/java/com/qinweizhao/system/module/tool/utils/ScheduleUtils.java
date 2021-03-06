package com.qinweizhao.system.module.tool.utils;


import com.qinweizhao.common.core.exception.ServiceException;
import com.qinweizhao.system.module.tool.entity.SysJob;
import com.qinweizhao.system.module.tool.enums.JobStatusEnum;
import org.quartz.*;

/**
 * 定时任务工具类
 *
 * @author qinweizhao
 * @since 2022/1/21
 */
public class ScheduleUtils {

    private static final String JOB_NAME = "TASK_";

    private ScheduleUtils() {
    }


    /**
     * 获取触发器key
     */
    public static TriggerKey getTriggerKey(Long jobId) {
        return TriggerKey.triggerKey(JOB_NAME + jobId);
    }

    /**
     * 获取jobKey
     */
    public static JobKey getJobKey(Long jobId) {
        return JobKey.jobKey(JOB_NAME + jobId);
    }

    /**
     * 获取表达式触发器
     */
    public static CronTrigger getCronTrigger(Scheduler scheduler, Long jobId) {
        try {
            return (CronTrigger) scheduler.getTrigger(getTriggerKey(jobId));
        } catch (SchedulerException e) {
            throw new ServiceException("获取定时任务CronTrigger出现异常");
        }
    }

    /**
     * 创建定时任务
     */
    public static void createScheduleJob(Scheduler scheduler, SysJob sysJob) {
        try {
            //构建job信息
            JobDetail jobDetail = JobBuilder.newJob(ScheduleJob.class).withIdentity(getJobKey(sysJob.getJobId())).build();

            //表达式调度构建器
            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(sysJob.getCronExpression())
                    .withMisfireHandlingInstructionDoNothing();

            //按新的cronExpression表达式构建一个新的trigger
            CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity(getTriggerKey(sysJob.getJobId())).withSchedule(scheduleBuilder).build();

            //放入参数，运行时的方法可以获取
            jobDetail.getJobDataMap().put(SysJob.JOB_PARAM_KEY, sysJob);

            scheduler.scheduleJob(jobDetail, trigger);

            //暂停任务
            if (sysJob.getStatus().equals(JobStatusEnum.NORMAL.getStatus())) {
                pauseJob(scheduler, sysJob.getJobId());
            }
        } catch (SchedulerException e) {
            throw new ServiceException("创建定时任务失败");
        }
    }

    /**
     * 更新定时任务
     */
    public static void updateScheduleJob(Scheduler scheduler, SysJob sysJob) {
        try {
            TriggerKey triggerKey = getTriggerKey(sysJob.getJobId());

            //表达式调度构建器
            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(sysJob.getCronExpression())
                    .withMisfireHandlingInstructionDoNothing();

            CronTrigger trigger = getCronTrigger(scheduler, sysJob.getJobId());

            //按新的cronExpression表达式重新构建trigger
            trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();

            //参数
            trigger.getJobDataMap().put(SysJob.JOB_PARAM_KEY, sysJob);

            scheduler.rescheduleJob(triggerKey, trigger);

            //暂停任务
//            if (sysJob.getStatus().equals(JobStatusEnum.NORMAL.getStatus())) {
//                pauseJob(scheduler, sysJob.getJobId());
//            }

        } catch (SchedulerException e) {
            throw new ServiceException("更新定时任务失败");
        }
    }

    /**
     * 立即执行任务
     */
    public static void run(Scheduler scheduler, SysJob sysjob) {
        try {
            //参数
            JobDataMap dataMap = new JobDataMap();
            dataMap.put(SysJob.JOB_PARAM_KEY, sysjob);
            scheduler.triggerJob(getJobKey(sysjob.getJobId()), dataMap);
        } catch (SchedulerException e) {
            throw new ServiceException("立即执行定时任务失败");
        }
    }

    /**
     * 暂停任务
     */
    public static void pauseJob(Scheduler scheduler, Long jobId) {
        try {
            scheduler.pauseJob(getJobKey(jobId));
        } catch (SchedulerException e) {
            throw new ServiceException("暂停定时任务失败");
        }
    }

    /**
     * 恢复任务
     */
    public static void resumeJob(Scheduler scheduler, Long jobId) {
        try {
            scheduler.resumeJob(getJobKey(jobId));
        } catch (SchedulerException e) {
            throw new ServiceException("恢复定时任务失败");
        }
    }

    /**
     * 删除定时任务
     */
    public static void deleteScheduleJob(Scheduler scheduler, Long jobId) {
        try {
            scheduler.deleteJob(getJobKey(jobId));
        } catch (SchedulerException e) {
            throw new ServiceException("删除定时任务失败");
        }
    }
}
