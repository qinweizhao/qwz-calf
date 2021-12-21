package com.qinweizhao.system.module.system.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.qinweizhao.common.response.Result;
import com.qinweizhao.system.module.system.entity.SysDictType;
import com.qinweizhao.system.module.system.service.ISysDictTypeService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

/**
 * <p>
 * 字典类型表 前端控制器
 * </p>
 *
 * @author qinweizhao
 * @since 2021-12-21
 */
@Controller
@RequestMapping("/sys/dict/type")
public class SysDictTypeController {

    @Resource
    private ISysDictTypeService sysDictTypeService;


    @PostMapping("/save")
    @ApiOperation("创建字典类型")
    public Result<Long> createDictType(@Valid @RequestBody SysDictType sysDictType) {
        Long dictTypeId = sysDictTypeService.saveDictType(sysDictType);
        return Result.success(dictTypeId);
    }

    @PutMapping("/update")
    @ApiOperation("修改字典类型")
    public Result<Boolean> updateDictType(@Valid @RequestBody SysDictType sysDictType) {
        return Result.condition(sysDictTypeService.updateDictType(sysDictType));
    }

    @DeleteMapping("/remove")
    @ApiOperation("删除字典类型")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    public Result<Boolean> deleteDictType(Long id) {
        return Result.condition(sysDictTypeService.removeDictType(id));
    }

    @ApiOperation("/获得字典类型的分页列表")
    @GetMapping("/page")
    public Result<IPage<SysDictType>> pageDictTypes(@Valid SysDictType sysDictType) {
        return Result.success(sysDictTypeService.pageDictTypes(sysDictType));
    }

    @ApiOperation("/查询字典类型详细")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    @GetMapping(value = "/get")
    public Result<SysDictType> getDictType(@RequestParam("id") Long id) {
        return Result.success(sysDictTypeService.getById(id));
    }

    @GetMapping("/list")
    @ApiOperation(value = "获得全部字典类型列表", notes = "包括开启 + 禁用的字典类型，主要用于前端的下拉选项")
    public Result<List<SysDictType>> list() {
        return Result.success(sysDictTypeService.list());
    }

    @ApiOperation("导出数据类型")
    @GetMapping("/export")
    public void export(HttpServletResponse response, @Valid SysDictType sysDictType) {
        // 输出
    }

}
