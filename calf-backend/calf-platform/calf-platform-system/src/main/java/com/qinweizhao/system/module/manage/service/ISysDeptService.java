package com.qinweizhao.system.module.manage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qinweizhao.api.system.dto.SysDeptDTO;
import com.qinweizhao.api.system.dto.command.SysDeptSaveCmd;
import com.qinweizhao.api.system.dto.command.SysDeptUpdateCmd;
import com.qinweizhao.api.system.dto.query.SysDeptListQry;
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
public interface ISysDeptService{


    /**
     * 部门简单列表（开启状态）
     * @return List<SysDept>
     */
    List<SysDeptDTO> listSimpleDepts();

    /**
     * 通过用户名获取部门名称
     * @param userId userId
     * @return String
     */
    String getDeptNameByUserId(Long userId);

    List<SysDeptDTO> listDepts(SysDeptListQry sysDeptListQry);

    int saveDept(SysDeptSaveCmd sysDeptSaveCmd);

    int updateDeptById(SysDeptUpdateCmd sysDeptUpdateCmd);

    int removeDeptById(Long deptId);

    SysDeptDTO getDeptById(Long deptId);

}
