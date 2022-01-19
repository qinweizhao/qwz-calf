package com.qinweizhao.system.module.manage.convert;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qinweizhao.api.system.dto.SysConfigDTO;
import com.qinweizhao.api.system.dto.command.SysConfigSaveCmd;
import com.qinweizhao.api.system.dto.command.SysConfigUpdateCmd;
import com.qinweizhao.api.system.vo.SysConfigVO;
import com.qinweizhao.system.module.manage.entity.SysConfig;
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
public interface SysConfigConvert {

    SysConfigConvert INSTANCE = Mappers.getMapper(SysConfigConvert.class);

    /**
     * DO 转 DTO
     *
     * @param SysConfig SysConfig
     * @return SysConfigDTO
     */
    SysConfigDTO convert(SysConfig SysConfig);

    /**
     * DO 转 DTO
     *
     * @param SysConfig SysConfig
     * @return SysConfigDTO
     */
    SysConfigVO convert(SysConfigDTO SysConfig);

    /**
     * DO 转 DTO
     *
     * @param SysConfigSaveCmd SysConfigSaveCmd
     * @return SysConfigDTO
     */
    SysConfig convert(SysConfigSaveCmd SysConfigSaveCmd);

    /**
     * DO 转 DTO
     *
     * @param SysConfigUpdateCmd SysConfigUpdateCmd
     * @return SysConfigDTO
     */
    SysConfig convert(SysConfigUpdateCmd SysConfigUpdateCmd);


    /**
     * DO 转 DTO
     *
     * @param sysConfig sysConfig
     * @return SysConfigDTO
     */
    List<SysConfigVO> convertToVO(List<SysConfigDTO> sysConfig);

    /**
     * DO 转 DTO
     *
     * @param selectListDepts selectListDepts
     * @return List<SysConfigDTO>
     */
    List<SysConfigDTO> convertToDTO(List<SysConfig> selectListDepts);


    /**
     * DO 转 DTO
     *
     * @param pageSysConfig pageSysConfig
     * @return List<SysConfigDTO>
     */
    Page<SysConfigDTO> convertToDTO(IPage<SysConfig> pageSysConfig);


    /**
     * DO 转 DTO
     *
     * @param pageSysConfig pageSysConfig
     * @return SysConfigDTO
     */
    Page<SysConfigVO> convertToVO(IPage<SysConfigDTO> pageSysConfig);

}
