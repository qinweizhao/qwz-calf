package com.qinweizhao.system.module.monitor.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qinweizhao.api.system.dto.query.SysLogPageQry;
import com.qinweizhao.system.module.monitor.entity.SysLog;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 日志表 Mapper 接口
 * </p>
 *
 * @author qinweizhao
 * @since 2022-01-20
 */
public interface SysLogMapper extends BaseMapper<SysLog> {


    /**
     * 查询日志分页信息
     *
     * @param page          page
     * @param sysLogPageQry sysLogPageQry
     * @return IPage<SysLog>
     */
    IPage<SysLog> selectPageLogs(Page<Object> page, @Param("query") SysLogPageQry sysLogPageQry);
}
