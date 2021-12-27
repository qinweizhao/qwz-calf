package com.qinweizhao.system.module.tool.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qinweizhao.system.module.tool.entity.SysJob;
import com.qinweizhao.system.module.tool.mapper.SysJobMapper;
import com.qinweizhao.system.module.tool.service.ISysJobService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 定时任务表 服务实现类
 * </p>
 *
 * @author qinweizhao
 * @since 2021-12-27
 */
@Service
public class SysJobServiceImpl extends ServiceImpl<SysJobMapper, SysJob> implements ISysJobService {

}
