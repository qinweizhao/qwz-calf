package com.qinweizhao.system.api;

import com.qinweizhao.api.system.SysLogApi;

import com.qinweizhao.api.system.dto.SysLogDTO;
import com.qinweizhao.system.module.monitor.entity.SysOperateLog;
import com.qinweizhao.system.module.monitor.service.ISysOperateLogService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author qinweizhao
 * @since 2021/12/13
 */
@Service
public class SysLogApiImpl implements SysLogApi {


    @Resource
    private ISysOperateLogService sysOperateLogService;


    @Override
    public void saveLog(SysLogDTO sysLog) {
        SysOperateLog sysOperateLog = new SysOperateLog();
        BeanUtils.copyProperties(sysLog,sysOperateLog);
        sysOperateLogService.save(sysOperateLog);
    }
}
