package com.qinweizhao.calf.service.system;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qinweizhao.calf.api.system.ISysRoleDeptService;
import com.qinweizhao.calf.dao.system.dataobject.SysRoleDept;
import com.qinweizhao.calf.dao.system.mapper.SysRoleDeptMapper;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色和部门关联表 服务实现类
 * </p>
 *
 * @author qinweizhao
 * @since 2021-12-06
 */
@Service
public class SysRoleDeptServiceImpl extends ServiceImpl<SysRoleDeptMapper, SysRoleDept> implements ISysRoleDeptService {

}
