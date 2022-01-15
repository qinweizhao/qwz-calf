package com.qinweizhao.system.module.manage.convert;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qinweizhao.api.system.vo.req.SysUserSaveReqVO;
import com.qinweizhao.api.system.vo.req.SysUserUpdateReqVO;
import com.qinweizhao.api.system.dto.SysUserDTO;
import com.qinweizhao.api.system.vo.resp.SysUserVO;
import com.qinweizhao.system.module.manage.entity.SysUser;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * (unmappedTargetPolicy = ReportingPolicy.IGNORE)
 *
 * @author qinweizhao
 * @since 2022/1/10
 */
@Mapper
public interface SysUserConvert {

    SysUserConvert INSTANCE = Mappers.getMapper(SysUserConvert.class);


    /**
     * sysUserUpdateCmd 转 DO
     *
     * @param sysUserSaveReqVO sysUserSaveCmd
     * @return SysUser
     */
    SysUser convert(SysUserSaveReqVO sysUserSaveReqVO);


    /**
     * sysUserUpdateCmd 转 DO
     *
     * @param sysUserUpdateReqVO sysUserUpdateCmd
     * @return SysUser
     */
    SysUser convert(SysUserUpdateReqVO sysUserUpdateReqVO);

    /**
     * DO 转 DTO
     *
     * @param sysUser sysDept
     * @return SysUser
     */
    SysUserDTO convert(SysUser sysUser);

    /**
     * DTO 转 VO
     *
     * @param sysUser sysDept
     * @return SysUser
     */
    SysUserVO convert(SysUserDTO sysUser);

    /**
     * DO 转 VO
     *
     * @param userPage userPage
     * @return SysUser
     */
    Page<SysUserDTO> convertToDTO(IPage<SysUser> userPage);


    /**
     * DO 转 VO
     *
     * @param sysUser sysUser
     * @return SysUser
     */
    Page<SysUserVO> convertToVO(IPage<SysUserDTO> sysUser);
}
