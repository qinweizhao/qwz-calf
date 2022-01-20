package com.qinweizhao.system.module.monitor.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qinweizhao.api.system.dto.SysLogDTO;
import com.qinweizhao.api.system.dto.query.SysLogPageQry;

/**
 * <p>
 * 日志表 服务类
 * </p>
 *
 * @author qinweizhao
 * @since 2022-01-20
 */
public interface ISysLogService {

    /**
     * 获取日志信息
     *
     * @param logId logId
     * @return SysLogDTO
     */
    SysLogDTO getLog(Long logId);

    /**
     * 查询日志分页
     *
     * @param sysLogPageQry sysLogPageQry
     * @return Page<SysLogDTO>
     */
    Page<SysLogDTO> pageLogs(SysLogPageQry sysLogPageQry);
}
