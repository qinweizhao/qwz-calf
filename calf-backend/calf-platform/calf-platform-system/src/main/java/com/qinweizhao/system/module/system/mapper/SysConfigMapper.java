package com.qinweizhao.system.module.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qinweizhao.system.module.system.entity.SysConfig;

/**
 * <p>
 * 参数配置表 Mapper 接口
 * </p>
 *
 * @author qinweizhao
 * @since 2021-12-22
 */
public interface SysConfigMapper extends BaseMapper<SysConfig> {

    IPage<SysConfig> selectPageConfigs(Page<SysConfig> page, SysConfig sysConfig);
}
