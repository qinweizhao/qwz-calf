package com.qinweizhao.calf.service.system;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qinweizhao.calf.api.system.SysRoleService;
import com.qinweizhao.calf.dao.system.dataobject.SysRole;
import com.qinweizhao.calf.dao.system.mapper.SysRoleMapper;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author qinweizhao
 * @since 2021-12-07
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {

}
