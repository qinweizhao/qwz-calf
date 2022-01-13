package com.qinweizhao.system.module.manage.controller;


import com.qinweizhao.api.system.dto.SysMenuDTO;
import com.qinweizhao.api.system.vo.SysMenuVO;
import com.qinweizhao.common.core.base.BaseController;
import com.qinweizhao.common.core.response.Result;
import com.qinweizhao.system.module.manage.convert.SysMenuConvert;
import com.qinweizhao.system.module.manage.entity.SysMenu;
import com.qinweizhao.system.module.manage.service.ISysMenuService;
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
 * 菜单权限表 前端控制器
 * </p>
 *
 * @author qinweizhao
 * @since 2021-12-06
 */
@RestController
@RequestMapping("/system/manage/menu")
public class SysMenuController extends BaseController {

    @Resource
    private ISysMenuService sysMenuService;

    @ApiOperation("获取路由列表")
    @GetMapping("/route")
    public Result<List<SysMenu>> route() {
        List<SysMenu> list = sysMenuService.listWithTree(getCurrentLoginUsername());
        return Result.success(list);
    }

    @ApiOperation("获取菜单列表")
    @PreAuthorize("hasAuthority('system:menu:query')")
    @GetMapping("/list")
    public Result<List<SysMenu>> tree() {
        return Result.success(sysMenuService.list());
    }

    @GetMapping("/list_simple")
    @ApiOperation(value = "获取角色精简信息列表", notes = "只包含被开启的角色，主要用于前端的下拉选项")
    public Result<List<SysMenuVO>> getSimpleRoles() {
        List<SysMenuVO> voList = SysMenuConvert.INSTANCE.convert(sysMenuService.listSimpleRoles());
        voList.sort(Comparator.comparing(SysMenuVO::getSort));
        return Result.success(voList);
    }

    @PostMapping("/save")
    @ApiOperation("创建菜单")
    @PreAuthorize("hasAuthority('system:menu:create')")
    public Result<Boolean> save(@Valid @RequestBody SysMenu sysMenu) {
        return Result.condition(sysMenuService.saveMenu(sysMenu));
    }

    @PutMapping("/update")
    @ApiOperation("修改菜单")
    @PreAuthorize("hasAuthority('system:menu:update')")
    public Result<Boolean> update(@Valid @RequestBody SysMenu sysMenu) {
        return Result.condition(sysMenuService.updateMenu(sysMenu));
    }

    @DeleteMapping("/remove")
    @ApiOperation("删除菜单")
    @ApiImplicitParam(name = "id", value = "角色编号", required = true, example = "1024", dataTypeClass = Long.class)
    @PreAuthorize("hasAuthority('system:menu:delete')")
    public Result<Boolean> remove(@RequestParam("id") Long id) {
        return Result.condition(sysMenuService.removeMenuByMenuId(id));
    }


    @GetMapping("/get")
    @ApiOperation("获取菜单信息")
    @PreAuthorize("hasAuthority('system:menu:query')")
    public Result<SysMenu> get(Long id) {
        return Result.success(sysMenuService.getById(id));
    }

}
