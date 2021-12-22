package com.qinweizhao.system.module.monitor.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qinweizhao.system.module.monitor.entity.SysUserSession;
import com.qinweizhao.system.module.monitor.mapper.SysUserSessionMapper;
import com.qinweizhao.system.module.monitor.service.ISysUserSessionService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户在线 Session 服务实现类
 * </p>
 *
 * @author qinweizhao
 * @since 2021-12-22
 */
@Service
public class SysUserSessionServiceImpl extends ServiceImpl<SysUserSessionMapper, SysUserSession> implements ISysUserSessionService {

}
