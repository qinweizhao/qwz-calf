package com.qinweizhao.system.module.manage.convert;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qinweizhao.api.system.dto.SysPostDTO;
import com.qinweizhao.api.system.dto.command.SysPostSaveCmd;
import com.qinweizhao.api.system.dto.command.SysPostUpdateCmd;
import com.qinweizhao.api.system.vo.SysPostVO;
import com.qinweizhao.system.module.manage.entity.SysPost;
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
public interface SysPostConvert {

    SysPostConvert INSTANCE = Mappers.getMapper(SysPostConvert.class);

    /**
     * DO 转 DTO
     *
     * @param SysPost SysPost
     * @return SysPostDTO
     */
    SysPostDTO convert(SysPost SysPost);

    /**
     * DO 转 DTO
     *
     * @param SysPost SysPost
     * @return SysPostDTO
     */
    SysPostVO convert(SysPostDTO SysPost);

    /**
     * DO 转 DTO
     *
     * @param SysPostSaveCmd SysPostSaveCmd
     * @return SysPostDTO
     */
    SysPost convert(SysPostSaveCmd SysPostSaveCmd);

    /**
     * DO 转 DTO
     *
     * @param SysPostUpdateCmd SysPostUpdateCmd
     * @return SysPostDTO
     */
    SysPost convert(SysPostUpdateCmd SysPostUpdateCmd);


    /**
     * DO 转 DTO
     *
     * @param SysPost SysPost
     * @return SysPostDTO
     */
    Page<SysPostVO> convertToVO(IPage<SysPostDTO> SysPost);


    /**
     * DO 转 DTO
     *
     * @param SysPost SysPost
     * @return SysPostDTO
     */
    List<SysPostVO> convertToVO(List<SysPostDTO> SysPost);

    /**
     * DO 转 VO
     *
     * @param deptList deptList
     * @return SysMenuVO
     */
    List<SysPostVO> convert(List<SysPost> deptList);


    /**
     * DO 转 DTO
     *
     * @param selectListDepts selectListDepts
     * @return List<SysPostDTO>
     */
    Page<SysPostDTO> convertToDTO(IPage<SysPost> selectListDepts);

    /**
     * DO 转 DTO
     *
     * @param selectListDepts selectListDepts
     * @return List<SysPostDTO>
     */
    List<SysPostDTO> convertToDTO(List<SysPost> selectListDepts);
}
