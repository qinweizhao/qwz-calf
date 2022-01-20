package com.qinweizhao.system.module.tool.convert;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qinweizhao.api.system.dto.SysJobLogDTO;
import com.qinweizhao.api.system.vo.SysJobLogVO;
import com.qinweizhao.system.module.tool.entity.SysJobLog;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * (unmappedTargetPolicy = ReportingPolicy.IGNORE)
 *
 * @author qinweizhao
 * @since 2022/1/10
 */
@Mapper
public interface SysJobLogConvert {

    SysJobLogConvert INSTANCE = Mappers.getMapper(SysJobLogConvert.class);

    /**
     * DTO 转 DO
     *
     * @param rolePageDTO rolePageDTO
     * @return SysJobLog
     */
    Page<SysJobLogDTO> convertToDTO(IPage<SysJobLog> rolePageDTO);

    /**
     * DTO 转 VO
     *
     * @param roleDTO roleDTO
     * @return SysJobLog
     */
    SysJobLogVO convert(SysJobLogDTO roleDTO);


    /**
     * DO 转 VO
     *
     * @param sysJobLog sysJobLog
     * @return SysJobLog
     */
    SysJobLogDTO convert(SysJobLog sysJobLog);


    /**
     * DTO 转 VO
     *
     * @param rolePage userPage
     * @return SysUser
     */
    Page<SysJobLogVO> convertToVO(IPage<SysJobLogDTO> rolePage);

    /**
     * DO 转 VO
     *
     * @param roleList roleList
     * @return SysUser
     */
    List<SysJobLogVO> convert(List<SysJobLog> roleList);

    List<SysJobLogVO> convertToVO(List<SysJobLogDTO> listSimpleRoles);

    List<SysJobLogDTO> convertToDTO(List<SysJobLog> selectListSimpleRoles);

}
