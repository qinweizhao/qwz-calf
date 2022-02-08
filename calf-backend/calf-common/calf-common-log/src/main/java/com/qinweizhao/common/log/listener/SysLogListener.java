package com.qinweizhao.common.log.listener;

import com.qinweizhao.api.system.SysLogApi;
import com.qinweizhao.api.system.dto.SysLogDTO;
import com.qinweizhao.common.log.event.SysLogEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 异步监听日志事件
 *
 * @author qinweizhao
 * @since 2021/12/31
 */
@Slf4j
@Component
public class SysLogListener {

    @Resource
    private SysLogApi sysLogApi;


    @Async
    @Order
    @EventListener(SysLogEvent.class)
    public void saveSysLog(SysLogEvent event) {
        System.out.println("执行");
        SysLogDTO sysLog = (SysLogDTO) event.getSource();
        sysLogApi.saveLog(sysLog);
    }

}
