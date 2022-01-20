package com.qinweizhao.system.module.manage.convert;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qinweizhao.api.system.dto.SysDictItemDTO;
import com.qinweizhao.api.system.dto.command.SysDictItemSaveCmd;
import com.qinweizhao.api.system.dto.command.SysDictItemUpdateCmd;
import com.qinweizhao.api.system.vo.SysDictItemVO;
import com.qinweizhao.system.module.manage.entity.SysDictItem;
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
public interface SysDictItemConvert {

    SysDictItemConvert INSTANCE = Mappers.getMapper(SysDictItemConvert.class);

    /**
     * DO 转 DTO
     *
     * @param SysDictItem SysDictItem
     * @return SysDictItemDTO
     */
    SysDictItemDTO convert(SysDictItem SysDictItem);

    /**
     * DO 转 DTO
     *
     * @param SysDictItem SysDictItem
     * @return SysDictItemDTO
     */
    SysDictItemVO convert(SysDictItemDTO SysDictItem);

    /**
     * DO 转 DTO
     *
     * @param SysDictItemSaveCmd SysDictItemSaveCmd
     * @return SysDictItemDTO
     */
    SysDictItem convert(SysDictItemSaveCmd SysDictItemSaveCmd);

    /**
     * DO 转 DTO
     *
     * @param SysDictItemUpdateCmd SysDictItemUpdateCmd
     * @return SysDictItemDTO
     */
    SysDictItem convert(SysDictItemUpdateCmd SysDictItemUpdateCmd);


    /**
     * DO 转 DTO
     *
     * @param SysDictItem SysDictItem
     * @return SysDictItemDTO
     */
    List<SysDictItemVO> convertToVO(List<SysDictItemDTO> SysDictItem);

    /**
     * DO 转 VO
     *
     * @param deptList deptList
     * @return SysMenuVO
     */
    List<SysDictItemVO> convert(List<SysDictItemDTO> deptList);


    /**
     * DO 转 DTO
     *
     * @param selectListDepts selectListDepts
     * @return List<SysDictItemDTO>
     */
    List<SysDictItemDTO> convertToDTO(List<SysDictItem> selectListDepts);


    /**
     * DO 转 DTO
     *
     * @param selectListDepts selectListDepts
     * @return List<SysDictItemDTO>
     */
    Page<SysDictItemDTO> convertToDTO(IPage<SysDictItem> selectListDepts);
}
