package com.qinweizhao.system.module.manage.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qinweizhao.api.system.dto.command.SysDictSaveCmd;
import com.qinweizhao.api.system.dto.command.SysDictUpdateCmd;
import com.qinweizhao.api.system.vo.SysDictVO;
import com.qinweizhao.common.core.response.Result;
import com.qinweizhao.system.module.manage.convert.SysDictConvert;
import com.qinweizhao.system.module.manage.entity.SysDict;
import com.qinweizhao.system.module.manage.service.ISysDictService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
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
@RestController
@RequestMapping("/system/manage/dict")
public class SysDictController {

    @Resource
    private ISysDictService sysDictTypeService;


    @PostMapping("/save")
    @ApiOperation("创建字典类型")
    public Result<Boolean> createDictType(@Valid @RequestBody SysDictSaveCmd sysDictSaveCmd) {
        return Result.condition(sysDictTypeService.saveDictType(sysDictSaveCmd));
    }

    @PutMapping("/update")
    @ApiOperation("修改字典类型")
    public Result<Boolean> updateDictType(@Valid @RequestBody SysDictUpdateCmd sysDictUpdateCmd) {
        return Result.condition(sysDictTypeService.updateDictType(sysDictUpdateCmd));
    }

    @DeleteMapping("/remove")
    @ApiOperation("删除字典类型")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    public Result<Boolean> deleteDictType(Long dictId) {
        return Result.condition(sysDictTypeService.removeDict(dictId));
    }

    @ApiOperation("/获得字典类型的分页列表")
    @GetMapping("/page")
    public Result<IPage<SysDict>> pageDictTypes(Page<SysDict> page, @Valid SysDict sysDict) {
        return Result.success(sysDictTypeService.pageDictTypes(page, sysDict));
    }

    @ApiOperation("/查询字典类型详细")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    @GetMapping(value = "/get")
    public Result<SysDictVO> get(@RequestParam("dictId") Long dictId) {
        return Result.success(SysDictConvert.INSTANCE.convert(sysDictTypeService.getDict(dictId)));
    }


    @GetMapping("/list-simple")
    @ApiOperation(value = "获得全部字典类型列表", notes = "包括开启 + 禁用的字典类型，主要用于前端的下拉选项")
    public Result<List<SysDictVO>> list() {
        return Result.success(SysDictConvert.INSTANCE.convertToVO(sysDictTypeService.listSimpleDicts()));
    }

}
