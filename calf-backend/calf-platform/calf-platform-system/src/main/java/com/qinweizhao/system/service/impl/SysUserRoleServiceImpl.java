package com.qinweizhao.system.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qinweizhao.system.entity.SysUserRole;
import com.qinweizhao.system.mapper.SysUserRoleMapper;
import com.qinweizhao.system.service.SysUserRoleService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户和角色关联表 服务实现类
 * </p>
 *
 * @author qinweizhao
 * @since 2021-12-07
 */
@Service
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRole> implements SysUserRoleService {

}
