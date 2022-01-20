package com.qinweizhao.system.module.tool.utils;

import com.qinweizhao.common.core.util.SpringContextUtils;
import com.qinweizhao.system.module.tool.entity.SysJob;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.lang.reflect.Method;


/**
 * 定时任务
 *
 * @author Mark sunlightcs@gmail.com
 */
public class ScheduleJob extends QuartzJobBean {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        SysJob sysJob = (SysJob) context.getMergedJobDataMap()
                .get(SysJob.JOB_PARAM_KEY);

//        //获取spring bean
//        ScheduleJobLogService scheduleJobLogService = (ScheduleJobLogService) SpringContextUtils.getBean("scheduleJobLogService");
//
//        //数据库保存执行记录
//        ScheduleJobLogEntity log = new ScheduleJobLogEntity();
//        log.setJobId(scheduleJob.getJobId());
//        log.setBeanName(scheduleJob.getBeanName());
//        log.setParams(scheduleJob.getParams());
//        log.setCreateTime(new Date());
//
        //任务开始时间
        long startTime = System.currentTimeMillis();

        try {
            //执行任务
            logger.debug("任务准备执行，任务ID：" + sysJob.getJobId());

            Object target = SpringContextUtils.getBean(sysJob.getHandlerName());
            Method method = target.getClass().getDeclaredMethod("run", String.class);
            method.invoke(target, sysJob.getHandlerParam());

            //任务执行总时长
            long times = System.currentTimeMillis() - startTime;
//			log.setTimes((int)times);
//			//任务状态    0：成功    1：失败
//			log.setStatus(0);

            logger.debug("任务执行完毕，任务ID：" + sysJob.getJobId() + "  总共耗时：" + times + "毫秒");
        } catch (Exception e) {
            logger.error("任务执行失败，任务ID：" + sysJob.getJobId(), e);

            //任务执行总时长
            long times = System.currentTimeMillis() - startTime;
            //log.setTimes((int)times);

            //任务状态    0：成功    1：失败
            //log.setStatus(1);
            //log.setError(StringUtils.substring(e.toString(), 0, 2000));
        } finally {
            //scheduleJobLogService.save(log);
        }
    }
}
