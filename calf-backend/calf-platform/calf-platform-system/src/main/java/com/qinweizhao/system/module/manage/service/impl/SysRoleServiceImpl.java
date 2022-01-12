package com.qinweizhao.system.module.manage.service.impl;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qinweizhao.api.system.dto.SysRoleDTO;
import com.qinweizhao.api.system.vo.SysRoleVO;
import com.qinweizhao.common.core.constant.CalfConstants;
import com.qinweizhao.common.core.enums.StatusEnum;
import com.qinweizhao.common.core.exception.ServiceException;
import com.qinweizhao.common.core.request.Search;
import com.qinweizhao.common.core.response.ResultCode;
import com.qinweizhao.common.core.util.PageUtil;
import com.qinweizhao.system.module.manage.convert.SysRoleConvert;
import com.qinweizhao.system.module.manage.entity.SysRole;
import com.qinweizhao.system.module.manage.entity.SysUser;
import com.qinweizhao.system.module.manage.mapper.SysRoleMapper;
import com.qinweizhao.system.module.manage.mapper.SysRoleMenuMapper;
import com.qinweizhao.system.module.manage.mapper.SysUserRoleMapper;
import com.qinweizhao.system.module.manage.service.ISysRoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronization;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
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
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements ISysRoleService {

    @Resource
    private SysUserRoleMapper sysUserRoleMapper;

    @Resource
    private SysRoleMenuMapper sysRoleMenuMapper;


    @Override
    public boolean updateRoleStatusById(Long roleId, Integer status) {
        return this.baseMapper.updateRoleStatusById(roleId, status);
    }

    @Override
    public int saveRole(SysRoleDTO sysRoleDTO) {
        // 校验角色
        this.checkDuplicateRole(sysRoleDTO.getRoleName(), sysRoleDTO.getRoleKey(), null);
        // 插入到数据库
        SysRole sysRole = SysRoleConvert.INSTANCE.convert(sysRoleDTO);
        return this.baseMapper.insert(sysRole);
    }

    @Override
    public int updateSysRoleById(SysRoleDTO sysRoleDTO) {
        // 校验是否可以更新
        this.checkUpdateRole(sysRoleDTO.getRoleId());
        // 校验角色的唯一字段是否重复
        checkDuplicateRole(sysRoleDTO.getRoleName(), sysRoleDTO.getRoleKey(), sysRoleDTO.getRoleId());
        SysRole sysRole = SysRoleConvert.INSTANCE.convert(sysRoleDTO);
        return this.baseMapper.updateById(sysRole);
    }

    @Override
    public int removeRole(Long roleId) {
        // 校验是否可以更新
        this.checkUpdateRole(roleId);
        // 标记删除
        int i = this.baseMapper.deleteById(roleId);
        // 删除相关数据
        // 标记删除 UserRole
        sysUserRoleMapper.deleteUserRoleByRoleId(roleId);
        // 标记删除 RoleMenu
        sysRoleMenuMapper.deleteRoleMenuByRoleId(roleId);
        return i;
    }

    @Override
    public List<SysRole> listSimpleRoles() {
        return this.baseMapper.selectListSimpleRoles(StatusEnum.ENABLE.getStatus());
    }

    @Override
    public IPage<SysRoleVO> pageRoles(Search search) {
        IPage<SysRole> page =this.baseMapper.selectPageRoles(PageUtil.getPage(search),search);
        return SysRoleConvert.INSTANCE.convert(page);
    }

    @Override
    public List<Long> listMenuIdsByRoleId(Long roleId) {
        return sysRoleMenuMapper.selectListMenuIdsByRoleId(roleId);
    }

    private void checkUpdateRole(Long roleId) {
        SysRole sysRole = this.baseMapper.selectById(roleId);
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
     * @param roleName roleName
     * @param roleKey roleKey
     * @param roleId roleId
     */
    private void checkDuplicateRole(String roleName, String roleKey, Long roleId) {
        // 1. 该 name 名字被其它角色所使用
        SysRole sysRole = this.baseMapper.selectRoleByRoleName(roleName);
        if (sysRole != null && !sysRole.getRoleId().equals(roleId)) {
            throw new ServiceException(ResultCode.ROLE_NAME_DUPLICATE);
        }
        // 2. 是否存在相同编码的角色
        if (!StringUtils.hasText(roleKey)) {
            return;
        }
        // 3. 该 key 是否被其他角色使用
        sysRole = this.baseMapper.selectRoleByRoleKey(roleKey);
        if (sysRole != null && !sysRole.getRoleId().equals(roleId)) {
            throw new ServiceException(ResultCode.ROLE_CODE_DUPLICATE);
        }

    }
}
