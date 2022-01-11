package com.qinweizhao.common.core.util;

import com.qinweizhao.common.core.constant.UserConstants;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

/**
 * @author qinweizhao
 * @since 2022/1/11
 */
public class CalfDefaultValueUtils {

    public static Integer getSort() {
        return UserConstants.DEFAULT_SORT;
    }

    public static Integer getDeleted() {
        return UserConstants.DEFAULT_DELETED;
    }

    public static Integer getStatus() {
        return UserConstants.DEFAULT_STATUS;
    }
}
