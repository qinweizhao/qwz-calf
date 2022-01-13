package com.qinweizhao.system.module.manage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qinweizhao.system.module.manage.entity.SysDept;
import com.qinweizhao.system.module.manage.entity.SysMenu;

import java.util.List;

/**
 * <p>
 * 部门表 服务类
 * </p>
 *
 * @author qinweizhao
 * @since 2021-12-10
 */
public interface ISysDeptService extends IService<SysDept> {


    /**
     * 部门简单列表（开启状态）
     * @return List<SysDept>
     */
    List<SysDept> listSimpleDepts();

}
