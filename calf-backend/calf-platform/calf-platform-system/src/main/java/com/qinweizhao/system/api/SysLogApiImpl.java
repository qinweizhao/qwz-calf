package com.qinweizhao.system.api;

import com.qinweizhao.api.system.SysLogApi;
import com.qinweizhao.api.system.dto.SysLogDTO;
import com.qinweizhao.system.module.monitor.entity.SysLog;
import com.qinweizhao.system.module.monitor.service.ISysLogService;
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
    private ISysLogService sysLogService;


    @Override
    public void saveLog(SysLogDTO sysLog) {
        SysLog sysOperateLog = new SysLog();
        BeanUtils.copyProperties(sysLog, sysOperateLog);
        sysLogService.save(sysOperateLog);
    }
}
