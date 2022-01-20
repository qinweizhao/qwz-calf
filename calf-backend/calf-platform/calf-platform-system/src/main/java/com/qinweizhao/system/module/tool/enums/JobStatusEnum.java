package com.qinweizhao.system.module.tool.enums;

import com.google.common.collect.Sets;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Collections;
import java.util.Set;


/**
 * 任务状态的枚举
 *
 * @author qinweizhao
 * @since 2021-12-06
 */
@Getter
@AllArgsConstructor
public enum JobStatusEnum {

    /**
     * 初始化中
     */
    INIT(0, Collections.emptySet()),
    /**
     * 开启
     */
    NORMAL(1, Sets.newHashSet("WAITING", "ACQUIRED", "BLOCKED")),
    /**
     * 暂停
     */
    STOP(2, Sets.newHashSet("PAUSED", "PAUSED_BLOCKED"));

    /**
     * 状态
     */
    private final Integer status;
    /**
     * 对应的 Quartz 触发器的状态集合
     */
    private final Set<String> quartzStates;

}
