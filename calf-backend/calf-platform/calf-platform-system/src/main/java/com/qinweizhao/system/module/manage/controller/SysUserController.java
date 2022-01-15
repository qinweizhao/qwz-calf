package com.qinweizhao.system.module.manage.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.qinweizhao.api.system.vo.req.SysUserSaveReqVO;
import com.qinweizhao.api.system.vo.req.SysUserUpdateReqVO;
import com.qinweizhao.api.system.vo.req.SysUserPageReqVO;
import com.qinweizhao.api.system.dto.SysUserDTO;
import com.qinweizhao.api.system.vo.resp.SysUserVO;
import com.qinweizhao.common.core.base.BaseController;
import com.qinweizhao.common.core.response.Result;
import com.qinweizhao.common.log.annotation.SysLog;
import com.qinweizhao.system.module.manage.convert.SysUserConvert;
import com.qinweizhao.system.module.manage.service.ISysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 系统用户 前端控制器
 * </p>
 *
 * @author qinweizhao
 * @since 2021-12-06
 */
@Api(tags = "用户管理")
@RestController
@RequestMapping("/system/manage/user")
public class SysUserController extends BaseController {

    @Resource
    private ISysUserService sysUserService;

    @GetMapping("/info")
    @ApiOperation("初始信息")
    public Result<Map<Object, Object>> info() {
        return Result.success(sysUserService.getProjectInitInfo(getCurrentLoginUsername()));
    }

    @GetMapping("/get")
    @ApiOperation(value = "用户详情")
    public Result<SysUserVO> get(Long id) {
        SysUserDTO sysUserDTO = sysUserService.getUserById(id);
        return Result.success(SysUserConvert.INSTANCE.convert(sysUserDTO));
    }


    @GetMapping("/page")
    @ApiOperation(value = "查询用户")
    public Result<IPage<SysUserVO>> page(SysUserPageReqVO sysUserPageReqVO) {
        IPage<SysUserDTO> page = sysUserService.pageUsers(sysUserPageReqVO);
        return Result.success(SysUserConvert.INSTANCE.convertToVO(page));
    }

    @GetMapping("/list_user_roles")
    @ApiOperation(value = "用户详情")
    public Result<List<Long>> listUserRoles(Long userId) {
        return Result.success(sysUserService.listRoleIdsByUserId(userId));
    }

    @SysLog("新增用户")
    @ApiOperation("新增用户")
    @PostMapping("/save")
    @PreAuthorize("hasAuthority('system:user:insert')")
    public Result<Boolean> save(@RequestBody SysUserSaveReqVO sysUserSaveReqVO) {
        return Result.condition(sysUserService.saveUser(sysUserSaveReqVO));
    }

    @SysLog("修改用户")
    @PutMapping("update")
    @ApiOperation("修改用户")
    @PreAuthorize("hasAuthority('system:user:update')")
    public Result<Boolean> update(@Valid @RequestBody SysUserUpdateReqVO sysUserUpdateReqVO) {
        return Result.condition(sysUserService.updateUserById(sysUserUpdateReqVO));
    }

    @SysLog("修改用户状态")
    @PutMapping("/update_status")
    @ApiOperation("修改用户状态")
    @PreAuthorize("hasAuthority('system:user:update')")
    public Result<Boolean> updateUserStatus(@RequestBody SysUserDTO sysUserDTO) {
        Long userId = sysUserDTO.getUserId();
        Integer status = sysUserDTO.getStatus();
        return Result.condition(sysUserService.updateUserStatusById(userId, status));
    }

    @ApiOperation("赋予用户角色")
    @PostMapping("/update_user_role")
    @PreAuthorize("hasAuthority('system:user:update')")
    public Result<Boolean> assignUserRole(@RequestBody SysUserDTO sysUserDTO) {
        return Result.condition(sysUserService.updateUserRole(sysUserDTO.getUserId(), sysUserDTO.getRoleIds()));
    }

    @SysLog("删除用户")
    @DeleteMapping("/remove")
    @ApiOperation("删除用户")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    @PreAuthorize("hasAuthority('system:user:delete')")
    public Result<Object> remove(@RequestParam List<Long> id) {
        return Result.condition(sysUserService.removeUserByIds(id));
    }

}
