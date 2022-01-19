package com.qinweizhao.system.module.manage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qinweizhao.api.system.dto.query.SysConfigPageQry;
import com.qinweizhao.system.module.manage.entity.SysConfig;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 参数配置表 Mapper 接口
 * </p>
 *
 * @author qinweizhao
 * @since 2021-12-22
 */
public interface SysConfigMapper extends BaseMapper<SysConfig> {

    IPage<SysConfig> selectPageConfigs(Page<SysConfig> page, @Param("query") SysConfigPageQry sysConfigPageQry);

    SysConfig selectByCode(String code);
}
