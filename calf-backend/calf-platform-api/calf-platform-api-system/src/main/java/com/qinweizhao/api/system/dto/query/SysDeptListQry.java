package com.qinweizhao.api.system.dto.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 部门表
 * </p>
 *
 * @author qinweizhao
 * @since 2021-12-06
 */
@Data
@ApiModel(value = "SysDept对象", description = "部门表")
public class SysDeptListQry implements Serializable {

    @ApiModelProperty("名称")
    private String name;

}
