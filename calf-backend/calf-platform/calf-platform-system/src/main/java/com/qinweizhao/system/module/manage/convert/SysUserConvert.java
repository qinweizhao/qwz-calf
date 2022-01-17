package com.qinweizhao.system.module.manage.convert;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qinweizhao.api.system.dto.SysUserDTO;
import com.qinweizhao.api.system.dto.command.SysUserSaveCmd;
import com.qinweizhao.api.system.dto.command.SysUserUpdateCmd;
import com.qinweizhao.api.system.vo.SysUserPageRespVO;
import com.qinweizhao.api.system.vo.SysUserRespVO;
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
     * @param sysUserSaveCmd sysUserSaveCmd
     * @return SysUser
     */
    SysUser convert(SysUserSaveCmd sysUserSaveCmd);


    /**
     * sysUserUpdateCmd 转 DO
     *
     * @param sysUserUpdateCmd sysUserUpdateCmd
     * @return SysUser
     */
    SysUser convert(SysUserUpdateCmd sysUserUpdateCmd);

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
    SysUserRespVO convertToVO(SysUserDTO sysUser);

    /**
     * DO 转 VO
     *
     * @param userPage userPage
     * @return SysUser
     */
    Page<SysUserDTO> convertToDTO(IPage<SysUser> userPage);


    /**
     * DTO 转 VO
     *
     * @param sysUser sysUser
     * @return SysUser
     */
    Page<SysUserPageRespVO> convertToVO(IPage<SysUserDTO> sysUser);
}
