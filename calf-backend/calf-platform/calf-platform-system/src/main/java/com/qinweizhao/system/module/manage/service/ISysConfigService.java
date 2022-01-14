package com.qinweizhao.system.module.manage.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.qinweizhao.system.module.manage.entity.SysConfig;

import java.util.List;

/**
 * <p>
 * 参数配置表 服务类
 * </p>
 *
 * @author qinweizhao
 * @since 2021-12-22
 */
public interface ISysConfigService extends IService<SysConfig> {

    /**
     * 通过 Key 获取配置
     *
     * @param key key
     * @return SysConfig
     */
    SysConfig getConfigByKey(String key);

    /**
     * 配置分页
     *
     * @param page      page
     * @param sysConfig sysConfig
     * @return return
     */
    IPage<SysConfig> pageConfigs(Page<SysConfig> page, SysConfig sysConfig);

    /**
     * 获取配置列表
     *
     * @param sysConfig sysConfig
     * @return List<SysConfig>
     */
    List<SysConfig> listConfigs(SysConfig sysConfig);

}
