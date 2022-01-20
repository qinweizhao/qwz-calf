package com.qinweizhao.system.api;

import com.qinweizhao.api.system.SysLogApi;
import com.qinweizhao.api.system.dto.SysLogDTO;
import com.qinweizhao.system.module.monitor.entity.SysLog;
import com.qinweizhao.system.module.monitor.mapper.SysLogMapper;
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
    private SysLogMapper sysLogMapper;


    @Override
    public void saveLog(SysLogDTO sysLog) {
        SysLog log = new SysLog();
        BeanUtils.copyProperties(sysLog, log);
        sysLogMapper.insert(log);
    }
}
