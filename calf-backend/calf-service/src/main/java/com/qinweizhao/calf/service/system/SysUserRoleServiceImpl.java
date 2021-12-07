package com.qinweizhao.calf.service.system;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qinweizhao.calf.api.system.SysUserRoleService;
import com.qinweizhao.calf.dao.system.dataobject.SysUserRole;
import com.qinweizhao.calf.dao.system.mapper.SysUserRoleMapper;
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
