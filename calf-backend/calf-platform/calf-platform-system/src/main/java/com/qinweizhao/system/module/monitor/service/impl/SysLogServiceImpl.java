package com.qinweizhao.system.module.monitor.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qinweizhao.api.system.dto.SysLogDTO;
import com.qinweizhao.api.system.dto.query.SysLogPageQry;
import com.qinweizhao.common.core.util.PageUtil;
import com.qinweizhao.system.module.manage.convert.SysLogConvert;
import com.qinweizhao.system.module.monitor.entity.SysLog;
import com.qinweizhao.system.module.monitor.mapper.SysLogMapper;
import com.qinweizhao.system.module.monitor.service.ISysLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 日志表 服务实现类
 * </p>
 *
 * @author qinweizhao
 * @since 2022-01-20
 */
@Service
public class SysLogServiceImpl implements ISysLogService {

    @Resource
    private SysLogMapper sysLogMapper;

    @Override
    public SysLogDTO getLog(Long logId) {
        return SysLogConvert.INSTANCE.convert(sysLogMapper.selectById(logId));
    }

    @Override
    public Page<SysLogDTO> pageLogs(SysLogPageQry sysLogPageQry) {
        IPage<SysLog> page = sysLogMapper.selectPageLogs(PageUtil.getPage(sysLogPageQry), sysLogPageQry);
        return SysLogConvert.INSTANCE.convertToDTO(page);
    }
}
