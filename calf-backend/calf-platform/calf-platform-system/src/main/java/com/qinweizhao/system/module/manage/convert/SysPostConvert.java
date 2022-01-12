package com.qinweizhao.system.module.manage.convert;

import com.qinweizhao.api.system.dto.SysDeptDTO;
import com.qinweizhao.system.module.manage.entity.SysDept;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

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
     * @param sysDept sysDept
     * @return SysDeptDTO
     */
    SysDeptDTO convert(SysDept sysDept);


}
