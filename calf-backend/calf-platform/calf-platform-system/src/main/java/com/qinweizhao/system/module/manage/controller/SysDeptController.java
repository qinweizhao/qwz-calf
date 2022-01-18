package com.qinweizhao.system.module.manage.controller;


import com.qinweizhao.api.system.dto.command.SysDeptSaveCmd;
import com.qinweizhao.api.system.dto.command.SysDeptUpdateCmd;
import com.qinweizhao.api.system.dto.query.SysDeptListQry;
import com.qinweizhao.api.system.vo.SysDeptVO;
import com.qinweizhao.common.core.response.Result;
import com.qinweizhao.system.module.manage.convert.SysDeptConvert;
import com.qinweizhao.system.module.manage.service.ISysDeptService;
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
 * 部门表 前端控制器
 * </p>
 *
 * @author qinweizhao
 * @since 2021-12-06
 */
@RestController
@RequestMapping("/system/manage/dept")
public class SysDeptController {

    @Resource
    ISysDeptService sysDeptService;


    @ApiOperation("获取部门列表")
    @PreAuthorize("hasAuthority('system:dept:query')")
    @GetMapping("/list")
    public Result<List<SysDeptVO>> list(SysDeptListQry sysDeptListQry) {
        return Result.success(SysDeptConvert.INSTANCE.convertToVO(sysDeptService.listDepts(sysDeptListQry)));
    }


    @GetMapping("/list-simple")
    @ApiOperation(value = "获取岗位精简信息列表", notes = "启用状态")
    public Result<List<SysDeptVO>> getSimpleRoles() {
        List<SysDeptVO> voList = SysDeptConvert.INSTANCE.convertToVO(sysDeptService.listSimpleDepts());
        voList.sort(Comparator.comparing(SysDeptVO::getSort));
        return Result.success(voList);
    }

    @PostMapping("save")
    @ApiOperation("创建部门")
    @PreAuthorize("hasAuthority('system:dept:create')")
    public Result<Boolean> createDept(@Valid @RequestBody SysDeptSaveCmd sysDeptSaveCmd) {
        return Result.condition(sysDeptService.saveDept(sysDeptSaveCmd));
    }

    @PutMapping("update")
    @ApiOperation("更新部门")
    @PreAuthorize("hasAuthority('system:dept:update')")
    public Result<Boolean> updateDept(@Valid @RequestBody SysDeptUpdateCmd sysDeptUpdateCmd) {
        return Result.condition(sysDeptService.updateDeptById(sysDeptUpdateCmd));
    }

    @DeleteMapping("remove")
    @ApiOperation("删除部门")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    @PreAuthorize("hasAuthority('system:dept:delete')")
    public Result<Boolean> remove(@RequestParam("deptId") Long deptId) {
        return Result.condition(sysDeptService.removeDeptById(deptId));
    }

    @GetMapping("/get")
    @ApiOperation("获得部门信息")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    @PreAuthorize("hasAuthority('system:dept:query')")
    public Result<SysDeptVO> getDept(@RequestParam("deptId") Long deptId) {
        return Result.success(SysDeptConvert.INSTANCE.convert(sysDeptService.getDeptById(deptId)));
    }

}
