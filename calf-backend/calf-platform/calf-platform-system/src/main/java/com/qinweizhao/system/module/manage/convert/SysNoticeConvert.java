package com.qinweizhao.system.module.manage.convert;

import com.qinweizhao.api.system.dto.SysNoticeDTO;
import com.qinweizhao.system.module.manage.entity.SysNotice;
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
public interface SysNoticeConvert {

    SysNoticeConvert INSTANCE = Mappers.getMapper(SysNoticeConvert.class);

    /**
     * DO 转 DTO
     *
     * @param sysNotice sysNotice
     * @return SysDeptDTO
     */
    SysNoticeDTO convert(SysNotice sysNotice);


}
