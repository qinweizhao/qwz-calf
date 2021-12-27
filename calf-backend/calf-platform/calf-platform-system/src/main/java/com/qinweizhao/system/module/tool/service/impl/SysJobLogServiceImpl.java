package com.qinweizhao.system.module.tool.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qinweizhao.system.module.tool.entity.SysJobLog;
import com.qinweizhao.system.module.tool.mapper.SysJobLogMapper;
import com.qinweizhao.system.module.tool.service.ISysJobLogService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 定时任务日志表 服务实现类
 * </p>
 *
 * @author qinweizhao
 * @since 2021-12-27
 */
@Service
public class SysJobLogServiceImpl extends ServiceImpl<SysJobLogMapper, SysJobLog> implements ISysJobLogService {

}
