package com.qinweizhao.system.module.manage.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.qinweizhao.api.system.dto.SysConfigDTO;
import com.qinweizhao.api.system.dto.command.SysConfigSaveCmd;
import com.qinweizhao.api.system.dto.command.SysConfigUpdateCmd;
import com.qinweizhao.api.system.dto.query.SysConfigPageQry;
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
public interface ISysConfigService {

    /**
     * 通过 Key 获取配置
     *
     * @param code code
     * @return SysConfig
     */
    SysConfig getConfigByCode(String code);

    /**
     * 配置分页
     *
     * @param sysConfigPageQry sysConfigPageQry
     * @return return
     */
    IPage<SysConfigDTO> pageConfigs(SysConfigPageQry sysConfigPageQry);

    /**
     * 获取配置列表
     *
     * @param sysConfig sysConfig
     * @return List<SysConfig>
     */
    List<SysConfig> listConfigs(SysConfig sysConfig);

    int saveConfig(SysConfigSaveCmd sysConfigSaveCmd);

    int updateConfig(SysConfigUpdateCmd sysConfigUpdateCmd);

    int removeConfig(Long configId);

    SysConfigDTO getConfig(Long configId);
}
