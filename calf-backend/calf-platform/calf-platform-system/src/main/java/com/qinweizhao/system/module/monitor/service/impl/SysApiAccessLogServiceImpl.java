package com.qinweizhao.system.module.monitor.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qinweizhao.system.module.monitor.entity.SysApiAccessLog;
import com.qinweizhao.system.module.monitor.mapper.SysApiAccessLogMapper;
import com.qinweizhao.system.module.monitor.service.ISysApiAccessLogService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * API 访问日志表 服务实现类
 * </p>
 *
 * @author qinweizhao
 * @since 2021-12-24
 */
@Service
public class SysApiAccessLogServiceImpl extends ServiceImpl<SysApiAccessLogMapper, SysApiAccessLog> implements ISysApiAccessLogService {

}
