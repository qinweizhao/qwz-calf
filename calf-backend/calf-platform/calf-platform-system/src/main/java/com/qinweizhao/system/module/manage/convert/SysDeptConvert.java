package com.qinweizhao.system.module.manage.convert;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.qinweizhao.api.system.dto.SysDeptDTO;
import com.qinweizhao.system.module.manage.entity.SysDept;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 部门表
 * </p>
 *
 * @author qinweizhao
 * @since 2021-12-06
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SysDeptConvert  {

    SysDeptConvert INSTANCE = Mappers.getMapper(SysDeptConvert.class);

    /**
     * DO 转 DTO
     * @param sysDept sysDept
     * @return SysDeptDTO
     */
    SysDeptDTO convert(SysDept sysDept);


}
