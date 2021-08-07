package com.qinweizhao.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qinweizhao.system.entity.SysUser;
import com.qinweizhao.system.mapper.SysUserMapper;
import com.qinweizhao.system.service.SysUserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author qinweizhao
 * @since 2021-07-29
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

}
