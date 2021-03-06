package com.qinweizhao.system.module.manage.convert;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qinweizhao.api.system.dto.SysRoleDTO;
import com.qinweizhao.api.system.dto.command.SysRoleSaveCmd;
import com.qinweizhao.api.system.dto.command.SysRoleUpdateCmd;
import com.qinweizhao.api.system.vo.SysRoleVO;
import com.qinweizhao.system.module.manage.entity.SysRole;
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
public interface SysRoleConvert {

    SysRoleConvert INSTANCE = Mappers.getMapper(SysRoleConvert.class);


    /**
     * DTO 转 DO
     *
     * @param sysRoleSaveCmd sysRoleSaveCmd
     * @return SysRole
     */
    SysRole convert(SysRoleSaveCmd sysRoleSaveCmd);

    /**
     * DTO 转 DO
     *
     * @param sysRoleUpdateCmd sysRoleUpdateCmd
     * @return SysRole
     */
    SysRole convert(SysRoleUpdateCmd sysRoleUpdateCmd);

    /**
     * DTO 转 DO
     *
     * @param rolePageDTO rolePageDTO
     * @return SysRole
     */
    Page<SysRoleDTO> convertToPageDTO(IPage<SysRole> rolePageDTO);

    /**
     * DTO 转 VO
     *
     * @param roleDTO roleDTO
     * @return SysRole
     */
    SysRoleVO convertToVO(SysRoleDTO roleDTO);


    /**
     * DO 转 VO
     *
     * @param sysRole sysDept
     * @return SysRole
     */
    SysRoleVO convert(SysRole sysRole);


    /**
     * DTO 转 VO
     *
     * @param rolePage userPage
     * @return SysUser
     */
    Page<SysRoleVO> convertToVO(IPage<SysRoleDTO> rolePage);

    /**
     * DO 转 VO
     *
     * @param roleList roleList
     * @return SysUser
     */
    List<SysRoleVO> convert(List<SysRole> roleList);

    List<SysRoleVO> convertToVO(List<SysRoleDTO> listSimpleRoles);

    List<SysRoleDTO> convertToDTO(List<SysRole> selectListSimpleRoles);

}
