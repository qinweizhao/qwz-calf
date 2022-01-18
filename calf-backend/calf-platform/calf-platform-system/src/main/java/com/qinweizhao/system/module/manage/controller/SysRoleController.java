package com.qinweizhao.system.module.manage.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.qinweizhao.api.system.dto.command.SysRoleSaveCmd;
import com.qinweizhao.api.system.dto.command.SysRoleUpdateCmd;
import com.qinweizhao.api.system.dto.query.SysRolePageQry;
import com.qinweizhao.api.system.dto.SysRoleDTO;
import com.qinweizhao.api.system.vo.SysRoleVO;
import com.qinweizhao.common.core.response.Result;
import com.qinweizhao.common.log.annotation.SysLog;
import com.qinweizhao.system.module.manage.convert.SysRoleConvert;
import com.qinweizhao.system.module.manage.service.ISysRoleService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Comparator;
import java.util.List;

/**
 * <p>
 * 角色表 前端控制器
 * </p>
 *
 * @author qinweizhao
 * @since 2021-12-06
 */
@RestController
    @RequestMapping("/system/manage/role")
public class SysRoleController {

    @Resource
    private ISysRoleService sysRoleService;



    @GetMapping("/get")
    @ApiOperation("获得角色信息")
    @PreAuthorize("hasAuthority('system:role:query')")
    public Result<SysRoleVO> get(@RequestParam("roleId") Long roleId) {
        return Result.success(SysRoleConvert.INSTANCE.convertToVO(sysRoleService.getRoleById(roleId)));
    }

    @GetMapping("/list_role_menus")
    @ApiOperation(value = "用户详情")
    public Result<List<Long>> listRoleMenus(Long roleId) {
        return Result.success(sysRoleService.listMenuIdsByRoleId(roleId));
    }

    @ApiOperation("获得角色分页")
    @PreAuthorize("hasAuthority('system:role:select')")
    @GetMapping("/page")
    public Result<IPage<SysRoleVO>> page(SysRolePageQry sysRolePageQry) {
        return Result.success(SysRoleConvert.INSTANCE.convertToVO(sysRoleService.pageRoles(sysRolePageQry)));
    }

    @PostMapping("/save")
    @ApiOperation("创建角色")
    @PreAuthorize("hasAuthority('system:role:save')")
    public Result<Boolean> save(@Valid @RequestBody SysRoleSaveCmd sysRoleSaveCmd) {
        return Result.condition(sysRoleService.saveRole(sysRoleSaveCmd));
    }

    @PutMapping("/update")
    @ApiOperation("修改角色")
    @PreAuthorize("hasAuthority('system:role:update')")
    public Result<Boolean> updateRole(@Valid @RequestBody SysRoleUpdateCmd sysRoleUpdateCmd) {
        return Result.condition(sysRoleService.updateSysRoleById(sysRoleUpdateCmd));
    }

    @SysLog("修改状态")
    @PutMapping("/update_status")
    @ApiOperation("修改状态")
    @PreAuthorize("hasAuthority('system:role:update')")
    public Result<Boolean> updateRoleStatus(@RequestBody SysRoleDTO sysRoleDTO) {
        Long roleId = sysRoleDTO.getRoleId();
        Integer status = sysRoleDTO.getStatus();
        return Result.condition(sysRoleService.updateRoleStatusById(roleId, status));
    }

    @SysLog("分配权限")
    @PutMapping("/update_role_permission")
    @ApiOperation("修改状态")
    @PreAuthorize("hasAuthority('system:role:update')")
    public Result<Boolean> updateRolePermission(@RequestBody SysRoleDTO sysRoleDTO) {
        return Result.condition(sysRoleService.updateRolePermission(sysRoleDTO));
    }


    @DeleteMapping("/remove")
    @ApiOperation("删除角色")
    @ApiImplicitParam(name = "id", value = "角色编号", required = true, example = "1024", dataTypeClass = Long.class)
    @PreAuthorize("hasAuthority('system:role:delete')")
    public Result<Boolean> remove(@RequestParam("roleId") Long roleId) {
        return Result.condition(sysRoleService.removeRole(roleId));
    }


    @GetMapping("/list-simple")
    @ApiOperation(value = "获取角色精简信息列表", notes = "只包含被开启的角色，主要用于前端的下拉选项")
    public Result<List<SysRoleVO>> getSimpleRoles() {
        // 获得角色列表，只要开启状态的
        List<SysRoleVO> list = SysRoleConvert.INSTANCE.convertToVO(sysRoleService.listSimpleRoles());
        // 排序后，返回前端
        list.sort(Comparator.comparing(SysRoleVO::getSort));
        return Result.success(list);
    }

}
