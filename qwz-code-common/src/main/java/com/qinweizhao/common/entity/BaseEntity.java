package com.qinweizhao.common.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author qinweizhao
 * @date 2021/7/19
 */
@Data
public class BaseEntity implements Serializable {

    @ApiModelProperty(value = "排序")
    private String sort;

    @ApiModelProperty(value = "创建者")
    private String createBy;

    @ApiModelProperty(value = "更新者")
    private String updateBy;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "备注")
    private String remark;
}
