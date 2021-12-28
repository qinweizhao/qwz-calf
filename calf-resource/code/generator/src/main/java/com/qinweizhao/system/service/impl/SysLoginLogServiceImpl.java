package com.qinweizhao.system.service.impl;

import com.qinweizhao.system.entity.SysLoginLog;
import com.qinweizhao.system.mapper.SysLoginLogMapper;
import com.qinweizhao.system.service.ISysLoginLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统访问记录 服务实现类
 * </p>
 *
 * @author qinweizhao
 * @since 2021-12-28
 */
@Service
public class SysLoginLogServiceImpl extends ServiceImpl<SysLoginLogMapper, SysLoginLog> implements ISysLoginLogService {

}
