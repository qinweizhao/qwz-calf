package com.qinweizhao.system.module.manage.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qinweizhao.common.core.enums.StatusEnum;
import com.qinweizhao.system.module.manage.entity.SysDept;
import com.qinweizhao.system.module.manage.mapper.SysDeptMapper;
import com.qinweizhao.system.module.manage.service.ISysDeptService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 部门表 服务实现类
 * </p>
 *
 * @author qinweizhao
 * @since 2021-12-07
 */
@Service
public class SysDeptServiceImpl extends ServiceImpl<SysDeptMapper, SysDept> implements ISysDeptService {

    @Override
    public List<SysDept> listSimpleDepts() {
        return this.baseMapper.selectListSimpleDepts(StatusEnum.ENABLE.getStatus());
    }
}
