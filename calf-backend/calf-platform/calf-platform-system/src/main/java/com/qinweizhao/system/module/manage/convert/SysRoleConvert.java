package com.qinweizhao.system.module.manage.convert;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qinweizhao.api.system.dto.SysRoleDTO;
import com.qinweizhao.api.system.vo.SysRoleVO;
import com.qinweizhao.system.module.manage.entity.SysRole;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

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
     * @param sysRoleDTO sysRoleDTO
     * @return SysRole
     */
    SysRole convert(SysRoleDTO sysRoleDTO);


    /**
     * DO 转 VO
     *
     * @param sysRole sysDept
     * @return SysRole
     */
    SysRoleVO convert(SysRole sysRole);


    /**
     * DO 转 VO
     *
     * @param rolePage userPage
     * @return SysUser
     */
    Page<SysRoleVO> convert(IPage<SysRole> rolePage);
}
