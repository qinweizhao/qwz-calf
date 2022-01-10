package com.qinweizhao.system.module.monitor.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qinweizhao.system.module.monitor.entity.SysLog;
import com.qinweizhao.system.module.monitor.mapper.SysLogMapper;
import com.qinweizhao.system.module.monitor.service.ISysLogService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 日志表 服务实现类
 * </p>
 *
 * @author qinweizhao
 * @since 2022-01-04
 */
@Service
public class SysLogServiceImpl extends ServiceImpl<SysLogMapper, SysLog> implements ISysLogService {

}
