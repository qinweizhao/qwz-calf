package com.qinweizhao.system.module.manage.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.qinweizhao.api.system.dto.command.SysConfigSaveCmd;
import com.qinweizhao.api.system.dto.command.SysConfigUpdateCmd;
import com.qinweizhao.api.system.dto.query.SysConfigPageQry;
import com.qinweizhao.api.system.vo.SysConfigVO;
import com.qinweizhao.common.core.response.Result;
import com.qinweizhao.system.module.manage.convert.SysConfigConvert;
import com.qinweizhao.system.module.manage.entity.SysConfig;
import com.qinweizhao.system.module.manage.service.ISysConfigService;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * <p>
 * 参数配置表 前端控制器
 * </p>
 *
 * @author qinweizhao
 * @since 2021-12-22
 */
@RestController
@RequestMapping("/sys/config")
public class SysConfigController {

    @Resource
    private ISysConfigService sysConfigService;

    @PostMapping("/save")
    @ApiOperation("创建参数配置")
    @PreAuthorize("hasAuthority('system:config:create')")
    public Result<Boolean> createConfig(@Valid @RequestBody SysConfigSaveCmd sysConfigSaveCmd) {
        return Result.condition(sysConfigService.saveConfig(sysConfigSaveCmd));
    }

    @PutMapping("/update")
    @ApiOperation("修改参数配置")
    @PreAuthorize("hasAuthority('system:config:update')")
    public Result<Boolean> updateConfig(@Valid @RequestBody SysConfigUpdateCmd sysConfigUpdateCmd) {
        return Result.condition(sysConfigService.updateConfig(sysConfigUpdateCmd));
    }

    @DeleteMapping("/remove")
    @PreAuthorize("hasAuthority('system:config:delete')")
    public Result<Boolean> deleteConfig(@RequestParam("id") Long configId) {
        return Result.condition(sysConfigService.removeConfig(configId));
    }

    @GetMapping(value = "/get")
    @PreAuthorize("hasAuthority('system:config:query')")
    public Result<SysConfigVO> getConfig(@RequestParam("id") Long configId) {
        return Result.success(SysConfigConvert.INSTANCE.convert(sysConfigService.getConfig(configId)));
    }

    @GetMapping(value = "/get-value-by-key")
    public Result<String> getkey(@RequestParam("code") String code) {
        SysConfig config = sysConfigService.getConfigByCode(code);
        return Result.success(config.getValue());
    }

    @GetMapping("/page")
    @PreAuthorize("hasAuthority('system:config:query')")
    public Result<IPage<SysConfigVO>> getConfigPage(SysConfigPageQry sysConfigPageQry) {
        return Result.success(SysConfigConvert.INSTANCE.convertToVO(sysConfigService.pageConfigs(sysConfigPageQry)));
    }

}
