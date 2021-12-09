package com.qinweizhao.common.event;

import com.qinweizhao.common.dto.CommonLog;
import org.springframework.context.ApplicationEvent;

/**
 * 日志事件
 *
 * @author qinweizhao 7333791@qq.com
 * @since 2020-7-15
 */
public class LogEvent extends ApplicationEvent {

    public LogEvent(CommonLog source) {
        super(source);
    }
}
