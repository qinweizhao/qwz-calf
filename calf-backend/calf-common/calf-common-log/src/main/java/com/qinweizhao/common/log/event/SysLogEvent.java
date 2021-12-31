package com.qinweizhao.common.log.event;

import com.qinweizhao.common.log.SysLogDTO;
import org.springframework.context.ApplicationEvent;


public class SysLogEvent extends ApplicationEvent {

    public SysLogEvent(SysLogDTO source) {
        super(source);
    }

}
