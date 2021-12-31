package com.qinweizhao.system.module.manage.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qinweizhao.common.core.exception.ServiceException;
import com.qinweizhao.common.core.response.Result;
import com.qinweizhao.common.core.util.ExcelUtils;
import com.qinweizhao.system.module.manage.entity.SysConfig;
import com.qinweizhao.system.module.manage.service.ISysConfigService;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

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
    public Result<Long> createConfig(@Valid @RequestBody SysConfig sysConfig) {
        return Result.condition(sysConfigService.save(sysConfig));
    }

    @PutMapping("/update")
    @ApiOperation("修改参数配置")
    @PreAuthorize("hasAuthority('system:config:update')")
    public Result<Boolean> updateConfig(@Valid @RequestBody SysConfig sysConfig) {
        sysConfigService.updateById(sysConfig);
        return Result.success(true);
    }

    @DeleteMapping("/remove")
    @PreAuthorize("hasAuthority('system:config:delete')")
    public Result<Boolean> deleteConfig(@RequestParam("id") Long id) {
        return Result.success(sysConfigService.removeById(id));
    }

    @GetMapping(value = "/get")
    @PreAuthorize("hasAuthority('system:config:query')")
    public Result<SysConfig> getConfig(@RequestParam("id") Long id) {
        return Result.success(sysConfigService.getById(id));
    }

    @GetMapping(value = "/get-value-by-key")
    public Result<String> getConfigKey(@RequestParam("key") String key) {
        SysConfig config = sysConfigService.getConfigByKey(key);
        if (config == null) {
            return null;
        }
        if (config.getSensitive()) {
            throw new ServiceException("ResultCode.CONFIG_GET_VALUE_ERROR_IF_SENSITIVE");
        }
        return Result.success(config.getConfigValue());
    }

    @GetMapping("/page")
    @PreAuthorize("hasAuthority('system:config:query')")
    public Result<IPage<SysConfig>> getConfigPage(Page<SysConfig> page, SysConfig sysConfig) {
        IPage<SysConfig> pageSysConfig = sysConfigService.pageConfigs(page, sysConfig);
        return Result.success(pageSysConfig);
    }

    @GetMapping("/export")
    //@SysLog(value = "1")
    @PreAuthorize("hasAuthority('system:config:export')")
    public void exportSysConfig(@Valid SysConfig sysConfig,
                                HttpServletResponse response) throws IOException {
        List<SysConfig> list = sysConfigService.listConfigs(sysConfig);
        // 输出
        ExcelUtils.write(response, "参数配置.xls", "数据", SysConfig.class, list);
    }

}
