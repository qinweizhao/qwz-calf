package com.qinweizhao.common.log.event;

import com.qinweizhao.api.system.dto.SysLogDTO;
import org.springframework.context.ApplicationEvent;


/**
 * @author qinweizhao
 * @since 2021/12/31
 */
public class SysLogEvent extends ApplicationEvent {

    public SysLogEvent(SysLogDTO source) {
        super(source);
    }

}
