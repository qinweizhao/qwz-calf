package com.qinweizhao.common.log.aspect;

import com.qinweizhao.common.log.SysLogDTO;
import com.qinweizhao.common.log.annotation.SysLog;
import com.qinweizhao.common.log.event.SysLogEvent;
import com.qinweizhao.common.log.util.LogTypeEnum;
import com.qinweizhao.common.log.util.SysLogUtils;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 使用spring event异步入库
 *
 * @author qinweizhao
 * @since 2021/12/31
 */
@Aspect
@Slf4j
@Component
public class SysLogAspect {


    @Resource
    private ApplicationContext applicationContext;

    @Around("@annotation(sysLog)")
    @SneakyThrows
    public Object around(ProceedingJoinPoint point, SysLog sysLog) {
        String strClassName = point.getTarget().getClass().getName();
        String strMethodName = point.getSignature().getName();
        log.debug("[类名]:{},[方法]:{}", strClassName, strMethodName);

        SysLogDTO logVo = SysLogUtils.getSysLog();

        logVo.setTraceId(sysLog.value());

        // 发送异步日志事件
        Long startTime = System.currentTimeMillis();
        Object obj;

        try {
            obj = point.proceed();
        } catch (Exception e) {
            logVo.setTraceId(LogTypeEnum.ERROR.getType());
            logVo.setExts(e.getMessage());
            throw e;
        } finally {
            Long endTime = System.currentTimeMillis();
            // logVo.setTime(endTime - startTime);
            applicationContext.publishEvent(new SysLogEvent(logVo));
        }

        return obj;
    }

}
