package com.qinweizhao.system.module.manage.convert;

import com.qinweizhao.api.system.dto.SysDictDTO;
import com.qinweizhao.api.system.dto.command.SysDictSaveCmd;
import com.qinweizhao.api.system.dto.command.SysDictUpdateCmd;
import com.qinweizhao.api.system.vo.SysDictVO;
import com.qinweizhao.system.module.manage.entity.SysDict;
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
public interface SysDictConvert {

    SysDictConvert INSTANCE = Mappers.getMapper(SysDictConvert.class);

    /**
     * DO 转 DTO
     *
     * @param SysDict SysDict
     * @return SysDictDTO
     */
    SysDictDTO convert(SysDict SysDict);

    /**
     * DO 转 DTO
     *
     * @param SysDict SysDict
     * @return SysDictDTO
     */
    SysDictVO convert(SysDictDTO SysDict);

    /**
     * DO 转 DTO
     *
     * @param SysDictSaveCmd SysDictSaveCmd
     * @return SysDictDTO
     */
    SysDict convert(SysDictSaveCmd SysDictSaveCmd);

    /**
     * DO 转 DTO
     *
     * @param SysDictUpdateCmd SysDictUpdateCmd
     * @return SysDictDTO
     */
    SysDict convert(SysDictUpdateCmd SysDictUpdateCmd);


    /**
     * DO 转 DTO
     *
     * @param SysDict SysDict
     * @return SysDictDTO
     */
    List<SysDictVO> convertToVO(List<SysDictDTO> SysDict);

    /**
     * DO 转 VO
     *
     * @param deptList deptList
     * @return SysMenuVO
     */
    List<SysDictVO> convert(List<SysDictDTO> deptList);


    /**
     * DO 转 DTO
     *
     * @param selectListDepts selectListDepts
     * @return List<SysDictDTO>
     */
    List<SysDictDTO> convertToDTO(List<SysDict> selectListDepts);
}
