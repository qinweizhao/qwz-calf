package com.qinweizhao.common.log.aspect;

import cn.hutool.core.util.URLUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.qinweizhao.api.system.dto.SysLogDTO;
import com.qinweizhao.common.log.annotation.SysLog;
import com.qinweizhao.common.log.constant.LogConstants;
import com.qinweizhao.common.log.event.SysLogEvent;
import com.qinweizhao.common.log.util.SysLogUtils;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.map.HashedMap;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

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

        SysLogDTO sysLogDTO = SysLogUtils.getSysLog();

        sysLogDTO.setLogType(sysLog.type());
        sysLogDTO.setLogTitle(sysLog.value());
        HttpServletRequest request = ((ServletRequestAttributes) Objects
                .requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        String path = URLUtil.getPath(request.getRequestURI());
        Map<String,Object> map = new HashMap<>();
        map.put("className",strClassName);
        map.put("methodName",strMethodName);
        map.put("path",path);
        String method = request.getMethod();
        map.put("method",method);
        String s = JSON.toJSONString(map);
        sysLogDTO.setRequest(s);


        // 发送异步日志事件
        Long startTime = System.currentTimeMillis();
        Object obj;

        try {
            obj = point.proceed();
            sysLogDTO.setStatus(LogConstants.LOG_STATUS_NORMAL);
        } catch (Exception e) {
            sysLogDTO.setStatus(LogConstants.LOG_STATUS_ERROR);
            sysLogDTO.setException(e.getMessage());
            throw e;
        } finally {
            Long endTime = System.currentTimeMillis();
            sysLogDTO.setTime(endTime - startTime);
            applicationContext.publishEvent(new SysLogEvent(sysLogDTO));
        }

        return obj;
    }

}
