package com.qinweizhao.system.module.manage.convert;

import com.qinweizhao.api.system.dto.SysDeptDTO;
import com.qinweizhao.api.system.dto.command.SysDeptSaveCmd;
import com.qinweizhao.api.system.dto.command.SysDeptUpdateCmd;
import com.qinweizhao.api.system.dto.query.SysDeptListQry;
import com.qinweizhao.api.system.vo.SysDeptVO;
import com.qinweizhao.system.module.manage.entity.SysDept;
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
public interface SysDeptConvert {

    SysDeptConvert INSTANCE = Mappers.getMapper(SysDeptConvert.class);

    /**
     * DO 转 DTO
     *
     * @param sysDept sysDept
     * @return SysDeptDTO
     */
    SysDeptDTO convert(SysDept sysDept);

    /**
     * DO 转 DTO
     *
     * @param sysDept sysDept
     * @return SysDeptDTO
     */
    SysDeptVO convert(SysDeptDTO sysDept);
    /**
     * DO 转 DTO
     *
     * @param sysDeptSaveCmd sysDeptSaveCmd
     * @return SysDeptDTO
     */
    SysDept convert(SysDeptSaveCmd sysDeptSaveCmd);

    /**
     * DO 转 DTO
     *
     * @param sysDeptUpdateCmd sysDeptUpdateCmd
     * @return SysDeptDTO
     */
    SysDept convert(SysDeptUpdateCmd sysDeptUpdateCmd);


    /**
     * DO 转 DTO
     *
     * @param sysDept sysDept
     * @return SysDeptDTO
     */
    List<SysDeptVO> convertToVO(List<SysDeptDTO> sysDept);

    /**
     * DO 转 VO
     *
     * @param deptList deptList
     * @return SysMenuVO
     */
    List<SysDeptVO> convert(List<SysDeptDTO> deptList);


    /**
     * DO 转 DTO
     * @param selectListDepts selectListDepts
     * @return List<SysDeptDTO>
     */
    List<SysDeptDTO> convertToDTO(List<SysDept> selectListDepts);
}
