package com.qinweizhao.system.module.tool.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qinweizhao.api.system.dto.query.SysJobLogPageQry;
import com.qinweizhao.system.module.tool.entity.SysJobLog;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 定时任务日志表 Mapper 接口
 * </p>
 *
 * @author qinweizhao
 * @since 2021-12-27
 */
public interface SysJobLogMapper extends BaseMapper<SysJobLog> {

    IPage<SysJobLog> selectPageJobLogs(Page<Object> page, @Param("query") SysJobLogPageQry sysJobLogPageQry);
}
