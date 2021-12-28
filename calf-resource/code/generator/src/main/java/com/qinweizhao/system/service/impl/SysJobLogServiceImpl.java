package com.qinweizhao.system.service.impl;

import com.qinweizhao.system.entity.SysJobLog;
import com.qinweizhao.system.mapper.SysJobLogMapper;
import com.qinweizhao.system.service.ISysJobLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 定时任务日志表 服务实现类
 * </p>
 *
 * @author qinweizhao
 * @since 2021-12-28
 */
@Service
public class SysJobLogServiceImpl extends ServiceImpl<SysJobLogMapper, SysJobLog> implements ISysJobLogService {

}
