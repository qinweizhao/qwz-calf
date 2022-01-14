package com.qinweizhao.api.system;


import com.qinweizhao.api.system.dto.SysLogDTO;

/**
 * @author qinweizhao
 * @since 2021/12/13
 */
public interface SysLogApi {

    /**
     * 保存日志
     *
     * @param sysLog sysLog
     */
    void saveLog(SysLogDTO sysLog);
}
