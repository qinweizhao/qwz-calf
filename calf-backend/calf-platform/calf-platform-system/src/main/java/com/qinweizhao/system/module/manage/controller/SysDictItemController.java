package com.qinweizhao.system.module.manage.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.qinweizhao.api.system.dto.SysDictItemDTO;
import com.qinweizhao.api.system.dto.command.SysDictItemSaveCmd;
import com.qinweizhao.api.system.dto.command.SysDictItemUpdateCmd;
import com.qinweizhao.api.system.dto.query.SysDictItemPageQry;
import com.qinweizhao.api.system.vo.SysDictItemVO;
import com.qinweizhao.common.core.response.Result;
import com.qinweizhao.system.module.manage.convert.SysDictItemConvert;
import com.qinweizhao.system.module.manage.service.ISysDictItemService;
import io.swagger.annotations.Api;
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
@Api(tags = "字典数据")
@RestController
@RequestMapping("/system/manage/dict/item")
public class SysDictItemController {

    @Resource
    private ISysDictItemService sysDictDataService;

    @PostMapping("/save")
    @ApiOperation("新增字典数据")
    public Result<Long> save(@Valid @RequestBody SysDictItemSaveCmd sysDictItemSaveCmd) {
        return Result.condition(sysDictDataService.saveDictData(sysDictItemSaveCmd));
    }

    @PutMapping("update")
    @ApiOperation("修改字典数据")
    public Result<Boolean> updateDictData(@Valid @RequestBody SysDictItemUpdateCmd sysDictItemUpdateCmd) {
        return Result.condition(sysDictDataService.updateDictItem(sysDictItemUpdateCmd));
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除字典数据")
    @ApiImplicitParam(name = "dictItemId", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    public Result<Boolean> delete(Long dictItemId) {
        return Result.condition(sysDictDataService.removeDictData(dictItemId));
    }

    @GetMapping("/list-simple")
    @ApiOperation(value = "获得全部字典数据列表")
    public Result<List<SysDictItemVO>> simple() {
        return Result.success(
                SysDictItemConvert.INSTANCE.convertToVO(sysDictDataService.listSimpleDictItems())
        );
    }

    @GetMapping("/page")
    @ApiOperation("/获得字典类型的分页列表")
    public Result<IPage<SysDictItemDTO>> getDictTypePage(@Valid SysDictItemPageQry sysDictItemPageQry) {
        return Result.success(sysDictDataService.pageDictItems(sysDictItemPageQry));
    }

    @GetMapping(value = "/get")
    @ApiOperation("/查询字典数据详细")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    public Result<Object> getDictData(@RequestParam("dictItemId") Long dictItemId) {
        return Result.success(sysDictDataService.getDictItem(dictItemId));
    }

}
