package com.qinweizhao.system.module.manage.convert;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qinweizhao.api.system.dto.SysLogDTO;
import com.qinweizhao.api.system.vo.SysLogVO;
import com.qinweizhao.system.module.monitor.entity.SysLog;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * <p>
 * 部门表
 * (unmappedTargetPolicy = ReportingPolicy.IGNORE)
 * </p>
 *
 * @author qinweizhao
 * @since 2021-12-06
 */
@Mapper
public interface SysLogConvert {

    SysLogConvert INSTANCE = Mappers.getMapper(SysLogConvert.class);

    /**
     * DO 转 DTO
     *
     * @param sysLog sysLog
     * @return SysLogDTO
     */
    SysLogDTO convert(SysLog sysLog);

    /**
     * DO 转 DTO
     *
     * @param sysLog sysLog
     * @return SysLogDTO
     */
    SysLogVO convert(SysLogDTO sysLog);


    /**
     * DO 转 DTO
     *
     * @param sysLog sysLog
     * @return SysLogDTO
     */
    Page<SysLogVO> convertToVO(IPage<SysLogDTO> sysLog);

    /**
     * DO 转 VO
     *
     * @param deptList deptList
     * @return SysMenuVO
     */
    List<SysLogVO> convert(List<SysLogDTO> deptList);


    /**
     * DO 转 DTO
     *
     * @param selectListDepts selectListDepts
     * @return List<SysLogDTO>
     */
    Page<SysLogDTO> convertToDTO(IPage<SysLog> selectListDepts);
}
