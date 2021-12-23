package com.qinweizhao.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 状态枚举
 *
 * @author qinweizhao
 * @since 2021-12-23
 */
@Getter
@AllArgsConstructor
public enum StatusEnum {

    ENABLE(1, "开启"),
    DISABLE(0, "关闭");

    /**
     * 状态值
     */
    private final Integer status;


    /**
     * 状态名
     */
    private final String name;

}
