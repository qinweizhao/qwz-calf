package com.qinweizhao.system.module.manage.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 角色标识枚举
 */
@Getter
@AllArgsConstructor
public enum RoleCodeEnum {

    /**
     * 超级管理员
     */
    ADMIN("admin"),
    ;

    /**
     * 角色编码
     */
    private final String code;

}
