package com.qinweizhao.system.module.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qinweizhao.system.module.system.entity.SysConfig;
import com.qinweizhao.system.module.system.mapper.SysConfigMapper;
import com.qinweizhao.system.module.system.service.ISysConfigService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 参数配置表 服务实现类
 * </p>
 *
 * @author qinweizhao
 * @since 2021-12-22
 */
@Service
public class SysConfigServiceImpl extends ServiceImpl<SysConfigMapper, SysConfig> implements ISysConfigService {

    @Override
    public SysConfig getConfigByKey(String key) {
        QueryWrapper<SysConfig> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("type", key);
        return this.baseMapper.selectOne(queryWrapper);
    }

    @Override
    public IPage<SysConfig> pageConfigs(Page<SysConfig> page, SysConfig sysConfig) {
        return this.baseMapper.selectPageConfigs(page,sysConfig);
    }

    @Override
    public List<SysConfig> listConfigs(SysConfig sysConfig) {
        QueryWrapper<SysConfig> queryWrapper = new QueryWrapper<>();
        return this.baseMapper.selectList(queryWrapper);
    }
}
