package com.qinweizhao.system.module.manage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qinweizhao.api.system.dto.query.SysConfigPageQry;
import com.qinweizhao.system.module.manage.entity.SysConfig;
import org.apache.ibatis.annotations.Param;

/**
 * 参数配置表 Mapper 接口
 *
 * @author qinweizhao
 * @since 2021-12-22
 */
public interface SysConfigMapper extends BaseMapper<SysConfig> {

    /**
     * 查询参数分页信息
     *
     * @param page             page
     * @param sysConfigPageQry sysConfigPageQry
     * @return IPage<SysConfig>
     */
    IPage<SysConfig> selectPageConfigs(Page<SysConfig> page, @Param("query") SysConfigPageQry sysConfigPageQry);

    /**
     * 通过配置码获取配置
     *
     * @param code code
     * @return SysConfig
     */
    SysConfig selectByCode(String code);
}
