package com.qinweizhao.system.module.tool.convert;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qinweizhao.api.system.dto.SysJobDTO;
import com.qinweizhao.api.system.dto.command.SysJobSaveCmd;
import com.qinweizhao.api.system.dto.command.SysJobUpdateCmd;
import com.qinweizhao.api.system.vo.SysJobVO;
import com.qinweizhao.system.module.tool.entity.SysJob;
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
public interface SysJobConvert {

    SysJobConvert INSTANCE = Mappers.getMapper(SysJobConvert.class);

    /**
     * DO 转 DTO
     *
     * @param SysJob SysJob
     * @return SysJobDTO
     */
    SysJobDTO convert(SysJob SysJob);

    /**
     * DO 转 DTO
     *
     * @param sysJobDTO sysJobDTO
     * @return SysJobDTO
     */
    SysJobVO convert(SysJobDTO sysJobDTO);

    /**
     * DO 转 DTO
     *
     * @param sysJobSaveCmd sysJobSaveCmd
     * @return SysJobDTO
     */
    SysJob convert(SysJobSaveCmd sysJobSaveCmd);

    /**
     * DO 转 DTO
     *
     * @param sysJobUpdateCmd sysJobUpdateCmd
     * @return SysJobDTO
     */
    SysJob convert(SysJobUpdateCmd sysJobUpdateCmd);


    /**
     * DO 转 DTO
     *
     * @param sysJob sysJob
     * @return SysJobDTO
     */
    List<SysJobVO> convertToVO(List<SysJobDTO> sysJob);

    /**
     * DO 转 DTO
     *
     * @param sysJob sysJob
     * @return SysJobDTO
     */
    Page<SysJobVO> convertToVO(IPage<SysJobDTO> sysJob);

    /**
     * DO 转 DTO
     *
     * @param selectListDepts selectListDepts
     * @return List<SysJobDTO>
     */
    List<SysJobDTO> convertToDTO(List<SysJob> selectListDepts);

    /**
     * DO 转 DTO
     *
     * @param selectListDepts selectListDepts
     * @return List<SysJobDTO>
     */
    Page<SysJobDTO> convertToDTO(IPage<SysJob> selectListDepts);
}
