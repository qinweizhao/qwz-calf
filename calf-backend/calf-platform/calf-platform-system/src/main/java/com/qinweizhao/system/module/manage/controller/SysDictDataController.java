package com.qinweizhao.system.module.manage.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.qinweizhao.common.core.response.Result;
import com.qinweizhao.system.module.manage.entity.SysDictData;
import com.qinweizhao.system.module.manage.service.ISysDictDataService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * <p>
 * 字典数据表 前端控制器
 * </p>
 *
 * @author qinweizhao
 * @since 2021-12-21
 */
@RestController
@RequestMapping("/sys/dict/data")
public class SysDictDataController {

    @Resource
    private ISysDictDataService sysDictDataService;

    @PostMapping("/save")
    @ApiOperation("新增字典数据")
    public Result<Long> save(@Valid @RequestBody SysDictData sysDictData) {
        Long dictDataId = sysDictDataService.saveDictData(sysDictData);
        return Result.success(dictDataId);
    }

    @PutMapping("update")
    @ApiOperation("修改字典数据")
    public Result<Boolean> updateDictData(@Valid @RequestBody SysDictData sysDictData) {
        return Result.condition(sysDictDataService.updateDictData(sysDictData));
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除字典数据")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    public Result<Boolean> delete(Long id) {
        return Result.condition(sysDictDataService.removeDictData(id));
    }

    @GetMapping("/list")
    @ApiOperation(value = "获得全部字典数据列表")
    public Result<List<SysDictData>> list() {
        return Result.success(sysDictDataService.list());
    }

    @GetMapping("/page")
    @ApiOperation("/获得字典类型的分页列表")
    public Result<IPage<SysDictData>> getDictTypePage(@Valid SysDictData sysDictData) {
        return Result.success(sysDictDataService.pageDictDatas(sysDictData));
    }

    @GetMapping(value = "/get")
    @ApiOperation("/查询字典数据详细")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    public Result<SysDictData> getDictData(@RequestParam("id") Long id) {
        return Result.success(sysDictDataService.getById(id));
    }

}
