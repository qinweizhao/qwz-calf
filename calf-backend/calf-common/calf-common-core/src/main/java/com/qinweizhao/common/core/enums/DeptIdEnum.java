package com.qinweizhao.common.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 部门编号枚举
 * @author YVKG
 */
@Getter
@AllArgsConstructor
public enum DeptIdEnum {

    /**
     * 根节点
     */
    ROOT(0L);

    private final Long id;

}
