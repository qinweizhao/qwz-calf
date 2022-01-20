package com.qinweizhao.system.module.tool.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qinweizhao.api.system.dto.query.SysJobPageQry;
import com.qinweizhao.system.module.tool.entity.SysJob;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 定时任务表 Mapper 接口
 * </p>
 *
 * @author qinweizhao
 * @since 2021-12-27
 */
public interface SysJobMapper extends BaseMapper<SysJob> {


    /**
     * 通过处理器的名字获取任务
     *
     * @param handlerName handlerName
     * @return SysJob
     */
    SysJob selectByHandlerName(String handlerName);

    /**
     * 查询任务分页信息
     *
     * @param page          page
     * @param sysJobPageQry sysJobPageQry
     * @return IPage<SysJob>
     */
    IPage<SysJob> selectPageJobs(Page<Object> page, @Param("query") SysJobPageQry sysJobPageQry);
}
