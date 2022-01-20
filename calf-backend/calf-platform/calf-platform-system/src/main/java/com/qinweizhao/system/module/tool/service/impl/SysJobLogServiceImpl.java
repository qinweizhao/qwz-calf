package com.qinweizhao.system.module.tool.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.qinweizhao.api.system.dto.SysJobLogDTO;
import com.qinweizhao.api.system.dto.query.SysJobLogPageQry;
import com.qinweizhao.common.core.util.PageUtil;
import com.qinweizhao.system.module.tool.convert.SysJobLogConvert;
import com.qinweizhao.system.module.tool.entity.SysJobLog;
import com.qinweizhao.system.module.tool.mapper.SysJobLogMapper;
import com.qinweizhao.system.module.tool.service.ISysJobLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

/**
 * <p>
 * 定时任务日志表 服务实现类
 * </p>
 *
 * @author qinweizhao
 * @since 2021-12-27
 */
@Service
public class SysJobLogServiceImpl implements ISysJobLogService {

    @Resource
    SysJobLogMapper sysJobLogMapper;

    @Override
    public SysJobLogDTO getJobLog(Long id) {
        return SysJobLogConvert.INSTANCE.convert(sysJobLogMapper.selectById(id));
    }

    @Override
    public List<SysJobLogDTO> listJobLogs(Collection<Long> ids) {
        return SysJobLogConvert.INSTANCE.convertToDTO(sysJobLogMapper.selectBatchIds(ids));
    }

    @Override
    public IPage<SysJobLogDTO> pageJobLogs(SysJobLogPageQry sysJobLogPageQry) {
        IPage<SysJobLog> pageDTO = sysJobLogMapper.selectPageJobLogs(PageUtil.getPage(sysJobLogPageQry), sysJobLogPageQry);
        System.out.println("pageDTO = " + pageDTO);
        return SysJobLogConvert.INSTANCE.convertToDTO(pageDTO);
    }
}
