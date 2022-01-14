package com.qinweizhao.system.module.manage.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.qinweizhao.api.system.command.query.SysRolePageQry;
import com.qinweizhao.api.system.dto.SysRoleDTO;
import com.qinweizhao.api.system.vo.SysRoleVO;
import com.qinweizhao.common.core.request.Search;
import com.qinweizhao.system.module.manage.entity.SysRole;

import java.util.List;

/**
 * <p>
 * 角色表 服务类
 * </p>
 *
 * @author qinweizhao
 * @since 2021-12-10
 */
public interface ISysRoleService extends IService<SysRole> {


    /**
     * 修改角色状态
     * @param roleId roleId
     * @param status status
     * @return boolean
     */
    boolean updateRoleStatusById(Long roleId, Integer status);

    /**
     * 保存用户
     * @param sysRoleDTO sysRoleDTO
     * @return int
     */
    int saveRole(SysRoleDTO sysRoleDTO);

    /**
     * 通过 Id 更新角色
     * @param sysRoleDTO sysRoleDTO
     * @return int
     */
    int updateSysRoleById(SysRoleDTO sysRoleDTO);

    /**
     * 删除角色
     * @param roleId roleId
     * @return int
     */
    int removeRole(Long roleId);

    /**
     * 获得角色列表，只要开启状态的
     * @return List<SysRole>
     */
    List<SysRole> listSimpleRoles();

    /**
     * 角色分页
     * @param sysRolePageQry sysRolePageQry
     * @return IPage<SysRoleVO>
     */
    IPage<SysRoleDTO> pageRoles(SysRolePageQry sysRolePageQry);

    /**
     * 获取角色拥有的菜单
     * @param roleId roleId
     * @return List<Long>
     */
    List<Long> listMenuIdsByRoleId(Long roleId);

    /**
     * 权限分配 部门和菜单
     * @param sysRoleDTO sysRoleDTO
     * @return int
     */
    int updateRolePermission(SysRoleDTO sysRoleDTO);

    /**
     * 通过 Id 获取角色
     * @param roleId roleId
     * @return SysRoleVO
     */
    SysRoleDTO getRoleById(Long roleId);
}
