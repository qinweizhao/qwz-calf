package com.qinweizhao.system.module.manage.convert;


import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * (unmappedTargetPolicy = ReportingPolicy.IGNORE)
 *
 * @author qinweizhao
 * @since 2022/1/10
 */
@Mapper
public interface SysConfigConvert {

    SysConfigConvert INSTANCE = Mappers.getMapper(SysConfigConvert.class);


}
