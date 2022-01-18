package com.qinweizhao.system.module.manage.service.impl;


import com.qinweizhao.api.system.dto.SysDeptDTO;
import com.qinweizhao.api.system.dto.command.SysDeptSaveCmd;
import com.qinweizhao.api.system.dto.command.SysDeptUpdateCmd;
import com.qinweizhao.api.system.dto.query.SysDeptListQry;
import com.qinweizhao.common.core.enums.DeptIdEnum;
import com.qinweizhao.common.core.enums.StatusEnum;
import com.qinweizhao.common.core.exception.ServiceException;
import com.qinweizhao.common.core.response.ResultCode;
import com.qinweizhao.system.module.manage.convert.SysDeptConvert;
import com.qinweizhao.system.module.manage.entity.SysDept;
import com.qinweizhao.system.module.manage.mapper.SysDeptMapper;
import com.qinweizhao.system.module.manage.mapper.SysRoleDeptMapper;
import com.qinweizhao.system.module.manage.service.ISysDeptService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
public class SysDeptServiceImpl implements ISysDeptService {

    @Resource
    private SysDeptMapper sysDeptMapper;

    @Resource
    private SysRoleDeptMapper sysRoleDeptMapper;


    @Override
    public List<SysDeptDTO> listSimpleDepts() {
        return SysDeptConvert.INSTANCE.convertToDTO(sysDeptMapper.selectListSimpleDepts(StatusEnum.ENABLE.getStatus()));
    }

    /**
     * 通过用户名获取部门名称
     *
     * @param userId userId
     * @return String
     */
    @Override
    public String getDeptNameByUserId(Long userId) {
        return sysDeptMapper.selectDeptNameByUserId(userId);
    }

    @Override
    public List<SysDeptDTO> listDepts(SysDeptListQry sysDeptListQry) {
        return SysDeptConvert.INSTANCE.convertToDTO(sysDeptMapper.selectListDepts(sysDeptListQry));
    }

    @Override
    public int saveDept(SysDeptSaveCmd sysDeptSaveCmd) {
        // 校验正确性
        checkSaveOrUpdate(null, sysDeptSaveCmd.getParentId(), sysDeptSaveCmd.getDeptName());
        // 更新部门
        SysDept sysDept = SysDeptConvert.INSTANCE.convert(sysDeptSaveCmd);
        return sysDeptMapper.insert(sysDept);
    }

    @Override
    public int updateDeptById(SysDeptUpdateCmd sysDeptUpdateCmd) {
        // 校验正确性
        checkSaveOrUpdate(sysDeptUpdateCmd.getDeptId(), sysDeptUpdateCmd.getParentId(), sysDeptUpdateCmd.getDeptName());

        SysDept sysDept = SysDeptConvert.INSTANCE.convert(sysDeptUpdateCmd);

        return sysDeptMapper.updateById(sysDept);
    }

    /**
     * 校验正确性
     *
     * @param deptId   deptId
     * @param parentId parentId
     * @param name     name
     */
    private void checkSaveOrUpdate(Long deptId, Long parentId, String name) {
        checkDeptExists(deptId);
        // 校验父部门的有效性
        checkParentDeptEnable(deptId, parentId);
        // 校验部门名的唯一性
        checkDeptNameUnique(deptId, parentId, name);
    }

    /**
     * 校验自己存在
     *
     * @param deptId deptId
     */
    private void checkDeptExists(Long deptId) {
        if (deptId == null) {
            return;
        }
        SysDept dept = sysDeptMapper.selectById(deptId);
        if (dept == null) {
            throw new ServiceException(ResultCode.DEPT_NOT_FOUND);
        }
    }

    /**
     * 校验父部门的有效性
     *
     * @param id       id
     * @param parentId parentId
     */
    private void checkParentDeptEnable(Long id, Long parentId) {
        if (parentId == null || DeptIdEnum.ROOT.getId().equals(parentId)) {
            return;
        }
        // 不能设置自己为父部门
        if (parentId.equals(id)) {
            throw new ServiceException(ResultCode.DEPT_PARENT_ERROR);
        }
        // 父岗位不存在
        SysDept dept = sysDeptMapper.selectById(parentId);
        if (dept == null) {
            throw new ServiceException(ResultCode.DEPT_PARENT_NOT_EXITS);
        }
        // 父部门被禁用
        if (!StatusEnum.ENABLE.getStatus().equals(dept.getStatus())) {
            throw new ServiceException(ResultCode.DEPT_NOT_ENABLE);
        }
    }

    /**
     * 检查部门名称是否唯一
     *
     * @param deptId   deptId
     * @param parentId parentId
     * @param deptName deptName
     */
    private void checkDeptNameUnique(Long deptId, Long parentId, String deptName) {
        SysDept menu = sysDeptMapper.selectDeptByParentIdAndName(parentId, deptName);
        if (menu == null) {
            return;
        }
        // 如果 id 为空，说明不用比较是否为相同 id 的岗位
        if (deptId == null) {
            throw new ServiceException(ResultCode.DEPT_NAME_DUPLICATE);
        }
        if (!menu.getDeptId().equals(deptId)) {
            throw new ServiceException(ResultCode.DEPT_NAME_DUPLICATE);
        }
    }

    @Override
    public int removeDeptById(Long deptId) {
        // 校验是否存在
        checkDeptExists(deptId);
        // 校验是否有子部门
        if (sysDeptMapper.selectCountByParentId(deptId) > 0) {
            throw new ServiceException(ResultCode.DEPT_EXITS_CHILDREN);
        }
        // 删除部门角色关联
        sysRoleDeptMapper.deleteRoleDeptByDeptId(deptId);
        // 删除部门
        return sysDeptMapper.deleteById(deptId);
    }

    @Override
    public SysDeptDTO getDeptById(Long deptId) {
        return SysDeptConvert.INSTANCE.convert(sysDeptMapper.selectById(deptId));
    }
}
