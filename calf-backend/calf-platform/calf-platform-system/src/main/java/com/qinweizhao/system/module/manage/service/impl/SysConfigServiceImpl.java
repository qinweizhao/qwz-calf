package com.qinweizhao.system.module.manage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.qinweizhao.api.system.dto.SysConfigDTO;
import com.qinweizhao.api.system.dto.command.SysConfigSaveCmd;
import com.qinweizhao.api.system.dto.command.SysConfigUpdateCmd;
import com.qinweizhao.api.system.dto.query.SysConfigPageQry;
import com.qinweizhao.common.core.exception.ServiceException;
import com.qinweizhao.common.core.response.ResultCode;
import com.qinweizhao.common.core.util.PageUtil;
import com.qinweizhao.system.module.manage.convert.SysConfigConvert;
import com.qinweizhao.system.module.manage.entity.SysConfig;
import com.qinweizhao.system.module.manage.enums.SysConfigTypeEnum;
import com.qinweizhao.system.module.manage.mapper.SysConfigMapper;
import com.qinweizhao.system.module.manage.service.ISysConfigService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
public class SysConfigServiceImpl implements ISysConfigService {

    @Resource
    private SysConfigMapper sysConfigMapper;

    @Override
    public SysConfig getConfigByCode(String code) {
        return sysConfigMapper.selectByCode(code);
    }

    @Override
    public IPage<SysConfigDTO> pageConfigs(SysConfigPageQry sysConfigPageQry) {
        return SysConfigConvert.INSTANCE.convertToDTO(sysConfigMapper.selectPageConfigs(PageUtil.getPage(sysConfigPageQry), sysConfigPageQry));
    }

    @Override
    public List<SysConfig> listConfigs(SysConfig sysConfig) {
        QueryWrapper<SysConfig> queryWrapper = new QueryWrapper<>();
        return sysConfigMapper.selectList(queryWrapper);
    }

    @Override
    public int saveConfig(SysConfigSaveCmd sysConfigSaveCmd) {

        // 校验正确性
        checkCreateOrUpdate(null, sysConfigSaveCmd.getCode());
        SysConfig sysConfig = SysConfigConvert.INSTANCE.convert(sysConfigSaveCmd);
        // 插入参数配置
        sysConfig.setType(SysConfigTypeEnum.CUSTOM.getType());
        return sysConfigMapper.insert(sysConfig);
    }

    private void checkCreateOrUpdate(Long id, String key) {
        // 校验自己存在
        checkConfigExists(id);
        // 校验参数配置 key 的唯一性
        checkConfigKeyUnique(id, key);
    }

    public SysConfig checkConfigExists(Long configId) {
        if (configId == null) {
            return null;
        }
        SysConfig sysConfig = sysConfigMapper.selectById(configId);
        if (sysConfig == null) {
            throw new ServiceException(ResultCode.CONFIG_NOT_EXISTS);
        }
        return sysConfig;
    }

    public void checkConfigKeyUnique(Long id, String key) {
        SysConfig sysConfig = sysConfigMapper.selectByCode(key);
        if (sysConfig == null) {
            return;
        }
        // 如果 id 为空，说明不用比较是否为相同 id 的参数配置
        if (id == null) {
            throw new ServiceException(ResultCode.CONFIG_KEY_DUPLICATE);
        }
        if (!sysConfig.getConfigId().equals(id)) {
            throw new ServiceException(ResultCode.CONFIG_KEY_DUPLICATE);
        }
    }

    @Override
    public int updateConfig(SysConfigUpdateCmd sysConfigUpdateCmd) {
        // 校验正确性
        // 不允许更新 key
        checkCreateOrUpdate(sysConfigUpdateCmd.getConfigId(), null);
        // 更新参数配置
        SysConfig sysConfig = SysConfigConvert.INSTANCE.convert(sysConfigUpdateCmd);
        return sysConfigMapper.updateById(sysConfig);
    }

    @Override
    public int removeConfig(Long configId) {
        // 校验配置存在
        SysConfig sysConfig = checkConfigExists(configId);
        // 内置配置，不允许删除
        if (SysConfigTypeEnum.SYSTEM.getType().equals(sysConfig.getType())) {
            throw new ServiceException(ResultCode.CONFIG_CAN_NOT_DELETE_SYSTEM_TYPE);
        }
        // 删除
        return sysConfigMapper.deleteById(configId);
    }

    @Override
    public SysConfigDTO getConfig(Long configId) {
        SysConfig sysConfig = sysConfigMapper.selectById(configId);
        return SysConfigConvert.INSTANCE.convert(sysConfig);
    }
}
