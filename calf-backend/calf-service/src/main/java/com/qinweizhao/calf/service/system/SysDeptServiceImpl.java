package com.qinweizhao.calf.service.system;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qinweizhao.calf.api.system.SysDeptService;
import com.qinweizhao.calf.dao.system.dataobject.SysDept;
import com.qinweizhao.calf.dao.system.mapper.SysDeptMapper;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 部门表 服务实现类
 * </p>
 *
 * @author qinweizhao
 * @since 2021-12-07
 */
@Service
public class SysDeptServiceImpl extends ServiceImpl<SysDeptMapper, SysDept> implements SysDeptService {

}
