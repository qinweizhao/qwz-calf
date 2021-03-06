package com.qinweizhao.system.module.manage.service.impl;


import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.qinweizhao.api.system.dto.SysRoleDTO;
import com.qinweizhao.api.system.dto.command.SysRoleSaveCmd;
import com.qinweizhao.api.system.dto.command.SysRoleUpdateCmd;
import com.qinweizhao.api.system.dto.query.SysRolePageQry;
import com.qinweizhao.common.core.constant.CalfConstants;
import com.qinweizhao.common.core.enums.StatusEnum;
import com.qinweizhao.common.core.exception.ServiceException;
import com.qinweizhao.common.core.response.ResultCode;
import com.qinweizhao.common.core.util.PageUtil;
import com.qinweizhao.system.module.manage.convert.SysRoleConvert;
import com.qinweizhao.system.module.manage.entity.SysRole;
import com.qinweizhao.system.module.manage.entity.SysRoleDept;
import com.qinweizhao.system.module.manage.mapper.SysRoleDeptMapper;
import com.qinweizhao.system.module.manage.mapper.SysRoleMapper;
import com.qinweizhao.system.module.manage.mapper.SysRoleMenuMapper;
import com.qinweizhao.system.module.manage.mapper.SysUserRoleMapper;
import com.qinweizhao.system.module.manage.service.ISysRoleService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author qinweizhao
 * @since 2021-12-07
 */
@Service
public class SysRoleServiceImpl implements ISysRoleService {

    @Resource
    private SysRoleMapper sysRoleMapper;

    @Resource
    private SysUserRoleMapper sysUserRoleMapper;

    @Resource
    private SysRoleMenuMapper sysRoleMenuMapper;

    @Resource
    private SysRoleDeptMapper sysRoleDeptMapper;


    @Override
    public boolean updateByoleStatusById(Long roleId, Integer status) {
        return sysRoleMapper.updateStatusById(roleId, status);
    }

    @Override
    public int saveRole(SysRoleSaveCmd sysRoleSaveCmd) {
        // 校验角色
        this.checkDuplicateRole(sysRoleSaveCmd.getName(), sysRoleSaveCmd.getCode(), null);
        // 插入到数据库
        SysRole sysRole = SysRoleConvert.INSTANCE.convert(sysRoleSaveCmd);
        return sysRoleMapper.insert(sysRole);
    }

    @Override
    public int updateSysRoleById(SysRoleUpdateCmd sysRoleUpdateCmd) {
        // 校验是否可以更新
        this.checkupdateByole(sysRoleUpdateCmd.getRoleId());
        // 校验角色的唯一字段是否重复
        checkDuplicateRole(sysRoleUpdateCmd.getName(), sysRoleUpdateCmd.getCode(), sysRoleUpdateCmd.getRoleId());
        SysRole sysRole = SysRoleConvert.INSTANCE.convert(sysRoleUpdateCmd);
        return sysRoleMapper.updateById(sysRole);
    }

    @Override
    public int removeRole(Long roleId) {
        // 校验是否可以更新
        this.checkupdateByole(roleId);
        // 标记删除
        int i = sysRoleMapper.deleteById(roleId);
        // 删除相关数据
        // 标记删除 UserRole
        sysUserRoleMapper.deleteUserRoleByRoleId(roleId);
        // 标记删除 RoleMenu
        sysRoleMenuMapper.deleteRoleMenuByRoleId(roleId);
        return i;
    }

    @Override
    public List<SysRoleDTO> listSimpleRoles() {
        return SysRoleConvert.INSTANCE.convertToDTO(sysRoleMapper.selectListSimpleRoles(StatusEnum.ENABLE.getStatus()));
    }

    @Override
    public IPage<SysRoleDTO> pageRoles(SysRolePageQry sysRolePageQry) {
        IPage<SysRole> page = sysRoleMapper.selectPageRoles(PageUtil.getPage(sysRolePageQry), sysRolePageQry);
        return SysRoleConvert.INSTANCE.convertToPageDTO(page);
    }

    @Override
    public List<Long> listMenuIdsByRoleId(Long roleId) {
        return sysRoleMenuMapper.selectListMenuIdsByRoleId(roleId);
    }

    @Override
    public int updateByRolePermission(SysRoleDTO sysRoleDTO) {
        Long roleId = sysRoleDTO.getRoleId();
        // 校验是否可以更新
        checkupdateByole(roleId);
        // 更新数据范围
        SysRole sysRole = new SysRole();
        sysRole.setRoleId(sysRoleDTO.getRoleId());
        sysRole.setDataScope(sysRoleDTO.getDataScope());
        // 分配菜单权限
        List<Long> menuIds = sysRoleDTO.getMenuIds();
        List<Long> dbMenuIds = sysRoleMenuMapper.selectListMenuIdsByRoleId(roleId);
        Collection<Long> insertMenuIds = CollUtil.subtract(menuIds, dbMenuIds);
        Collection<Long> deleteMenuIds = CollUtil.subtract(dbMenuIds, menuIds);

        if (!CollUtil.isEmpty(insertMenuIds)) {
            sysRoleMenuMapper.insertRoleMenuByRoleIdAndMenuIds(roleId, insertMenuIds);
        }

        if (!CollUtil.isEmpty(deleteMenuIds)) {
            sysRoleMenuMapper.deleteRoleMenuByRoleIdAndMenuIds(roleId, deleteMenuIds);
        }
        //分配数据权限
        List<Long> deptIds = sysRoleDTO.getDeptIds();
        // 获取 db 中存在的关联
        List<Long> dbDeptIds = sysRoleDeptMapper.selectDeptIdsByRoleId(roleId);
        Collection<Long> insertDeptIds = CollUtil.subtract(deptIds, dbDeptIds);
        Collection<Long> deleteDeptIds = CollUtil.subtract(dbDeptIds, deptIds);
        insertDeptIds.forEach(item -> {
            SysRoleDept sysRoleDept = new SysRoleDept();
            sysRoleDept.setRoleId(roleId);
            sysRoleDept.setDeptId(item);
            sysRoleDeptMapper.insert(sysRoleDept);
        });
        if (!CollUtil.isEmpty(deleteDeptIds)) {
            sysRoleDeptMapper.deleteRoleDeptByRoleIdAndDeptIds(roleId, deleteDeptIds);
        }
        return sysRoleMapper.updateById(sysRole);
    }

    @Override
    public SysRoleDTO getRoleById(Long roleId) {
        SysRole sysRole = sysRoleMapper.selectById(roleId);
        SysRoleDTO sysRoleDTO = new SysRoleDTO();
        sysRoleDTO.setDeptIds(sysRoleDeptMapper.selectDeptIdsByRoleId(roleId));
        BeanUtils.copyProperties(sysRole, sysRoleDTO);
        return sysRoleDTO;
    }

    /**
     * 通过用户 Id 获取所属角色
     *
     * @param userId userId
     * @return List<SysRoleDTO>
     */
    @Override
    public List<SysRoleDTO> listRoleByUserId(Long userId) {
        List<SysRole> userRoles = sysRoleMapper.selectListByUserId(userId);
        return SysRoleConvert.INSTANCE.convertToDTO(userRoles);
    }

    private void checkupdateByole(Long roleId) {
        SysRole sysRole = sysRoleMapper.selectById(roleId);
        if (sysRole == null) {
            throw new ServiceException(ResultCode.ROLE_NOT_EXISTS);
        }
        // 内置角色，不允许删除
        if (CalfConstants.SYSTEM_ROLE_ID.equals(sysRole.getRoleId())) {
            throw new ServiceException(ResultCode.ROLE_CAN_NOT_UPDATE_SYSTEM_TYPE_ROLE);
        }

    }

    /**
     * 检查重复
     *
     * @param roleName roleName
     * @param code     code
     * @param roleId   roleId
     */
    private void checkDuplicateRole(String roleName, String code, Long roleId) {
        // 1. 该 name 名字被其它角色所使用
        SysRole sysRole = sysRoleMapper.selectRoleByRoleName(roleName);
        if (sysRole != null && !sysRole.getRoleId().equals(roleId)) {
            throw new ServiceException(ResultCode.ROLE_NAME_DUPLICATE);
        }
        // 2. 是否存在相同编码的角色
        if (!StringUtils.hasText(code)) {
            return;
        }
        // 3. 该 key 是否被其他角色使用
        sysRole = sysRoleMapper.selectRoleByCode(code);
        if (sysRole != null && !sysRole.getRoleId().equals(roleId)) {
            throw new ServiceException(ResultCode.ROLE_CODE_DUPLICATE);
        }

    }
}
