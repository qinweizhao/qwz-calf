package com.qinweizhao.common.log.util;

import com.qinweizhao.api.system.dto.SysLogDTO;
import lombok.experimental.UtilityClass;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Objects;


/**
 * 系统日志工具类
 *
 * @author qinweizhao
 * @since 2021/12/31
 */
@UtilityClass
public class SysLogUtils {

    public SysLogDTO getSysLog() {

        SysLogDTO sysLog = new SysLogDTO();
        sysLog.setCreateBy(Objects.requireNonNull(getUsername()));
        sysLog.setUpdateBy(Objects.requireNonNull(getUsername()));
        return sysLog;
    }


    /**
     * 获取用户名称
     *
     * @return username
     */
    private String getUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            return null;
        }
        return authentication.getName();
    }

}
