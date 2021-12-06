package com.qinweizhao.calf.service.system;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qinweizhao.calf.api.system.ISysUserService;
import com.qinweizhao.calf.dao.system.dataobject.SysUser;
import com.qinweizhao.calf.dao.system.mapper.SysUserMapper;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统用户 服务实现类
 * </p>
 *
 * @author qinweizhao
 * @since 2021-12-06
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

}
