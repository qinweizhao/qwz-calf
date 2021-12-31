
package com.qinweizhao.common.log.event;

import com.qinweizhao.common.log.SysLogDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author lengleng 异步监听日志事件
 */
@Slf4j
@Component
public class SysLogListener {

    //@Resource
    //private SysLogApi sysLogApi;
    //
    //
    //@Async
    //@Order
    //@EventListener(SysLogEvent.class)
    //public void saveSysLog(SysLogEvent event) {
    //    System.out.println("执行");
    //    SysLogDTO sysLog = (SysLogDTO) event.getSource();
    //    sysLogApi.saveLog(sysLog);
    //}

}
