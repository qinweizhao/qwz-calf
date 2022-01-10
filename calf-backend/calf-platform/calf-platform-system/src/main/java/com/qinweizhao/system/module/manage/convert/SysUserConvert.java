package com.qinweizhao.system.module.manage.convert;

import com.qinweizhao.api.system.dto.SysUserDTO;
import com.qinweizhao.api.system.vo.SysUserVO;
import com.qinweizhao.system.module.manage.entity.SysUser;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

/**
 * @author qinweizhao
 * @since 2022/1/10
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SysUserConvert {

    SysUserConvert INSTANCE = Mappers.getMapper(SysUserConvert.class);


    /**
     * DTO 转 DO
     *
     * @param sysUser sysDept
     * @return SysUser
     */
    SysUser convert(SysUserDTO sysUser);


    /**
     * DO 转 VO
     *
     * @param sysUser sysDept
     * @return SysUser
     */
    SysUserVO convert(SysUser sysUser);

}
