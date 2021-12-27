package com.qinweizhao.system.service.impl;

import com.qinweizhao.system.entity.SysJob;
import com.qinweizhao.system.mapper.SysJobMapper;
import com.qinweizhao.system.service.ISysJobService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
