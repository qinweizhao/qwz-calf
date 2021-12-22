package com.qinweizhao.system.module.monitor.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qinweizhao.system.module.monitor.entity.SysLoginLog;
import com.qinweizhao.system.module.monitor.mapper.SysLoginLogMapper;
import com.qinweizhao.system.module.monitor.service.ISysLoginLogService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统访问记录 服务实现类
 * </p>
 *
 * @author qinweizhao
 * @since 2021-12-22
 */
@Service
public class SysLoginLogServiceImpl extends ServiceImpl<SysLoginLogMapper, SysLoginLog> implements ISysLoginLogService {

}
