package com.qinweizhao.system.module.manage.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.qinweizhao.api.system.dto.SysPostDTO;
import com.qinweizhao.api.system.dto.command.SysPostSaveCmd;
import com.qinweizhao.api.system.dto.command.SysPostUpdateCmd;
import com.qinweizhao.api.system.dto.query.SysPostPageQry;
import com.qinweizhao.api.system.vo.SysPostVO;
import com.qinweizhao.common.core.response.Result;
import com.qinweizhao.system.module.manage.convert.SysPostConvert;
import com.qinweizhao.system.module.manage.entity.SysPost;
import com.qinweizhao.system.module.manage.service.ISysPostService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * <p>
 * 岗位信息表 前端控制器
 * </p>
 *
 * @author qinweizhao
 * @since 2021-12-06
 */
@RestController
@RequestMapping("/sys/post")
public class SysPostController {

    @Resource
    private ISysPostService sysPostService;


    @GetMapping("/page")
    @ApiOperation("获得岗位分页列表")
    @PreAuthorize("hasAuthority('system:post:query')")
    public Result<IPage<SysPostVO>> page(SysPostPageQry sysPostPageQry) {
        return Result.success(SysPostConvert.INSTANCE.convertToVO(sysPostService.pageSysPosts(sysPostPageQry)));
    }


    @GetMapping("/list-simple")
    public Result<List<SysPostVO>> sample() {
        return Result.success(SysPostConvert.INSTANCE.convertToVO(sysPostService.listSimplePost()));
    }

    @PostMapping("/save")
    @ApiOperation("创建岗位")
    @PreAuthorize("hasAuthority('system:post:save')")
    public Result<Long> save(@Valid @RequestBody SysPostSaveCmd sysPostSaveCmd) {
        return Result.condition(sysPostService.savePost(sysPostSaveCmd));
    }

    @PutMapping("/update")
    @ApiOperation("修改岗位")
    @PreAuthorize("hasAuthority('system:post:update')")
    public Result<Boolean> updatePost(@Valid @RequestBody SysPostUpdateCmd sysPostUpdateCmd) {
        return Result.condition(sysPostService.updatePostById(sysPostUpdateCmd));
    }

    @DeleteMapping("/remove")
    @ApiOperation("删除岗位")
    @PreAuthorize("hasAuthority('system:post:remove')")
    public Result<Boolean> remove(@RequestParam("postId") Long postId) {
        return Result.condition(sysPostService.removePostById(postId));
    }

    @GetMapping(value = "/get")
    @ApiOperation("获得岗位信息")
    @ApiImplicitParam(name = "id", value = "岗位编号", required = true, example = "1024", dataTypeClass = Long.class)
    @PreAuthorize("hasAuthority('system:post:query')")
    public Result<SysPostVO> get(@RequestParam("postId") Long postId) {
        return Result.success(SysPostConvert.INSTANCE.convert(sysPostService.getPostById(postId)));
    }


}
