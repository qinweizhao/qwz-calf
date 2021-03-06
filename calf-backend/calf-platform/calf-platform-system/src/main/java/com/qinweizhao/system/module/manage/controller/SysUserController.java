package com.qinweizhao.system.module.manage.controller;


import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qinweizhao.api.system.dto.SysDeptDTO;
import com.qinweizhao.api.system.dto.SysPostDTO;
import com.qinweizhao.api.system.dto.SysRoleDTO;
import com.qinweizhao.api.system.dto.SysUserDTO;
import com.qinweizhao.api.system.dto.command.SysUserSaveCmd;
import com.qinweizhao.api.system.dto.command.SysUserUpdateCmd;
import com.qinweizhao.api.system.dto.command.SysUserUpdatePasswordCmd;
import com.qinweizhao.api.system.dto.query.SysUserPageQry;
import com.qinweizhao.api.system.vo.SysUserPageRespVO;
import com.qinweizhao.api.system.vo.SysUserProfileRespVO;
import com.qinweizhao.api.system.vo.SysUserRespVO;
import com.qinweizhao.common.core.base.BaseController;
import com.qinweizhao.common.core.constant.CalfConstants;
import com.qinweizhao.common.core.exception.ServiceException;
import com.qinweizhao.common.core.response.Result;
import com.qinweizhao.common.core.response.ResultCode;
import com.qinweizhao.common.core.util.ServerUtils;
import com.qinweizhao.common.log.annotation.SysLog;
import com.qinweizhao.system.module.manage.convert.SysUserConvert;
import com.qinweizhao.system.module.manage.service.ISysDeptService;
import com.qinweizhao.system.module.manage.service.ISysPostService;
import com.qinweizhao.system.module.manage.service.ISysRoleService;
import com.qinweizhao.system.module.manage.service.ISysUserService;
import com.qinweizhao.system.module.manage.util.SecurityUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * <p>
 * ???????????? ???????????????
 * </p>
 *
 * @author qinweizhao
 * @since 2021-12-06
 */
@Api(tags = "????????????")
@RestController
@RequestMapping("/system/manage/user")
public class SysUserController extends BaseController {

    @Resource
    private ISysUserService sysUserService;

    @Resource
    private ISysDeptService sysDeptService;

    @Resource
    private ISysRoleService sysRoleService;

    @Resource
    private ISysPostService sysPostService;



    @GetMapping("/info")
    @ApiOperation("????????????")
    public Result<Map<Object, Object>> info() {
        return Result.success(sysUserService.getProjectInitInfo(getCurrentLoginUsername()));
    }

    @GetMapping("/get")
    @ApiOperation(value = "????????????")
    public Result<SysUserRespVO> get(Long id) {
        SysUserDTO sysUserDTO = sysUserService.getUserById(id);
        return Result.success(SysUserConvert.INSTANCE.convertToVO(sysUserDTO));
    }

    @GetMapping("/page")
    @ApiOperation(value = "????????????")
    public Result<IPage<SysUserPageRespVO>> page(SysUserPageQry sysUserPageQry) {
        IPage<SysUserDTO> page = sysUserService.pageUsers(sysUserPageQry);
        Page<SysUserPageRespVO> sysUserVO = SysUserConvert.INSTANCE.convertToVO(page);
        List<SysUserPageRespVO> records = sysUserVO.getRecords();
        records.forEach(item ->
                item.setDeptName(sysDeptService.getNameByUserId(item.getUserId())
                ));
        return Result.success(sysUserVO);
    }

    @GetMapping("/list-user-roles")
    @ApiOperation(value = "????????????")
    public Result<List<Long>> listUserRoles(Long userId) {
        return Result.success(sysUserService.listRoleIdsByUserId(userId));
    }

    @SysLog("????????????")
    @ApiOperation("????????????")
    @PostMapping("/save")
    @PreAuthorize("hasAuthority('system:user:insert')")
    public Result<Boolean> save(@RequestBody SysUserSaveCmd sysUserSaveCmd) {
        return Result.condition(sysUserService.saveUser(sysUserSaveCmd));
    }

    @SysLog("????????????")
    @PutMapping("update")
    @ApiOperation("????????????")
    @PreAuthorize("hasAuthority('system:user:update')")
    public Result<Boolean> update(@Valid @RequestBody SysUserUpdateCmd sysUserUpdateCmd) {
        return Result.condition(sysUserService.updateUserById(sysUserUpdateCmd));
    }

    @SysLog("??????????????????")
    @PutMapping("/update_status")
    @ApiOperation("??????????????????")
    @PreAuthorize("hasAuthority('system:user:update')")
    public Result<Boolean> updateUserStatus(@RequestBody SysUserDTO sysUserDTO) {
        Long userId = sysUserDTO.getUserId();
        Integer status = sysUserDTO.getStatus();
        return Result.condition(sysUserService.updateUserStatusById(userId, status));
    }

    @ApiOperation("??????????????????")
    @PostMapping("/update_user_role")
    @PreAuthorize("hasAuthority('system:user:update')")
    public Result<Boolean> assignUserRole(@RequestBody SysUserDTO sysUserDTO) {
        return Result.condition(sysUserService.updateUserRole(sysUserDTO.getUserId(), sysUserDTO.getRoleIds()));
    }

    @SysLog("????????????")
    @DeleteMapping("/remove")
    @ApiOperation("????????????")
    @ApiImplicitParam(name = "id", value = "??????", required = true, example = "1024", dataTypeClass = Long.class)
    @PreAuthorize("hasAuthority('system:user:remove')")
    public Result<Object> remove(@RequestParam List<Long> id) {
        return Result.condition(sysUserService.removeUserByIds(id));
    }


    @GetMapping("/get-profile")
    @ApiOperation("????????????????????????")
    public Result<SysUserProfileRespVO> profile() {
        // ????????????????????????
        SysUserDTO user = sysUserService.getUserById(SecurityUtils.getLoginUser().getUserId());
        SysUserProfileRespVO resp = SysUserConvert.INSTANCE.convert(user);
        // ??????????????????
        List<SysRoleDTO> userRoles = sysRoleService.listRoleByUserId(user.getUserId());
        resp.setRoles(userRoles);
        // ??????????????????
        if (user.getDeptId() != null) {
            SysDeptDTO sysDeptDTO = sysDeptService.getDeptById(user.getDeptId());
            SysUserProfileRespVO.Dept dept = new SysUserProfileRespVO.Dept();
            dept.setId(sysDeptDTO.getDeptId());
            dept.setName(sysDeptDTO.getName());
            resp.setDept(dept);
        }
        // ??????????????????
        if (CollUtil.isNotEmpty(user.getPostIds())) {
            List<SysPostDTO> posts = sysPostService.listByUserId(user.getUserId());
            resp.setPosts(posts);
        }
        return Result.success(resp);
    }

    @PutMapping("/update-password")
    @ApiOperation("????????????????????????")
    public Result<Boolean> updateUserProfilePassword(@Valid @RequestBody SysUserUpdatePasswordCmd sysUserUpdatePasswordCmd) {
        return Result.condition(sysUserService.updatePassword(getLoginUser().getUserId(), sysUserUpdatePasswordCmd));
    }

    @PutMapping("/update-avatar")
    @ApiOperation("????????????")
    public Result<String> updateUserAvatar(@RequestParam("avatarFile") MultipartFile file, HttpServletRequest request) throws IOException {

        return Result.condition(sysUserService.updateAvatar(getLoginUser().getUserId(), file));
    }
}
