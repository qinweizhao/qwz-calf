package com.qinweizhao.system.module.manage.convert;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
     * @param sysDict sysDict
     * @return SysDictDTO
     */
    SysDictDTO convert(SysDict sysDict);

    /**
     * DO 转 DTO
     *
     * @param sysDict sysDict
     * @return SysDictDTO
     */
    SysDictVO convert(SysDictDTO sysDict);

    /**
     * DO 转 DTO
     *
     * @param sysDictSaveCmd sysDictSaveCmd
     * @return SysDictDTO
     */
    SysDict convert(SysDictSaveCmd sysDictSaveCmd);

    /**
     * DO 转 DTO
     *
     * @param sysDictUpdateCmd sysDictUpdateCmd
     * @return SysDictDTO
     */
    SysDict convert(SysDictUpdateCmd sysDictUpdateCmd);


    /**
     * DO 转 DTO
     *
     * @param sysDict sysDict
     * @return List<SysDictVO>
     */
    List<SysDictVO> convertToVO(List<SysDictDTO> sysDict);


    /**
     * DO 转 DTO
     *
     * @param sysDict sysDict
     * @return SysDictDTO
     */
    Page<SysDictVO> convertToVO(IPage<SysDictDTO> sysDict);

    /**
     * DO 转 DTO
     *
     * @param listDict listDict
     * @return List<SysDictDTO>
     */
    List<SysDictDTO> convertToDTO(List<SysDict> listDict);


    /**
     * DO 转 DTO
     *
     * @param pageDict pageDict
     * @return IPage<SysDictDTO>
     */
    Page<SysDictDTO> convertToDTO(IPage<SysDict> pageDict);
}
