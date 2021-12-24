package com.qinweizhao.system.module.manage.controller;


import com.qinweizhao.common.base.BaseController;
import com.qinweizhao.common.response.Result;
import com.qinweizhao.system.module.manage.entity.SysMenu;
import com.qinweizhao.system.module.manage.service.ISysMenuService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
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
@RequestMapping("/sys/menu")
public class SysMenuController extends BaseController {

    @Resource
    private ISysMenuService sysMenuService;

    @GetMapping("/tree")
    public Result<List<SysMenu>> tree() {
        List<SysMenu> list = sysMenuService.listWithTree(getCurrentLoginUsername());
        return Result.success(list);
    }

    @ApiOperation("获取菜单列表")
    @PreAuthorize("hasAuthority('system:menu:query')")
    @GetMapping("/list")
    public Result<List<SysMenu>> list() {
        return Result.success(sysMenuService.list());
    }



    @PostMapping("/save")
    @ApiOperation("创建菜单")
    @PreAuthorize("hasAuthority('system:menu:create')")
    public Result<Boolean> save(@Valid @RequestBody SysMenu sysMenu) {
        return Result.condition(sysMenuService.save(sysMenu));
    }

    @PutMapping("/update")
    @ApiOperation("修改菜单")
    @PreAuthorize("hasAuthority('system:menu:update')")
    public Result<Boolean> update(@Valid @RequestBody SysMenu sysMenu) {
        return Result.success(sysMenuService.updateById(sysMenu));
    }

    @DeleteMapping("/remove")
    @ApiOperation("删除菜单")
    @ApiImplicitParam(name = "id", value = "角色编号", required= true, example = "1024", dataTypeClass = Long.class)
    @PreAuthorize("hasAuthority('system:menu:delete')")
    public Result<Boolean> remove(@RequestParam("id") Long id) {
        return Result.success(sysMenuService.removeById(id));
    }


    @GetMapping("/list-all-simple")
    @ApiOperation(value = "获取菜单精简信息列表", notes = "只包含被开启的菜单，主要用于前端的下拉选项")
    public Result<List<SysMenu>> getSimpleMenus() {
        // 获得菜单列表，只要开启状态的

        // 排序后，返回个诶前端
        // list.sort(Comparator.comparing(SysMenu::getSort));
        return Result.success(null);
    }

    @GetMapping("/get")
    @ApiOperation("获取菜单信息")
    @PreAuthorize("hasAuthority('system:menu:query')")
    public Result<SysMenu> get(Long id) {
        return Result.success(sysMenuService.getById(id));
    }

}
