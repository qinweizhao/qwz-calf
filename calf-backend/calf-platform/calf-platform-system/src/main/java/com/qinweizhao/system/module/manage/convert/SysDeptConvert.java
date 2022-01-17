package com.qinweizhao.system.module.manage.convert;

import com.qinweizhao.api.system.dto.SysDeptDTO;
import com.qinweizhao.api.system.vo.SysDeptVO;
import com.qinweizhao.system.module.manage.entity.SysDept;
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
public interface SysDeptConvert {

    SysDeptConvert INSTANCE = Mappers.getMapper(SysDeptConvert.class);

    /**
     * DO 转 DTO
     *
     * @param sysDept sysDept
     * @return SysDeptDTO
     */
    SysDeptDTO convert(SysDept sysDept);


    /**
     * DO 转 VO
     *
     * @param deptList deptList
     * @return SysMenuVO
     */
    List<SysDeptVO> convert(List<SysDept> deptList);

}
