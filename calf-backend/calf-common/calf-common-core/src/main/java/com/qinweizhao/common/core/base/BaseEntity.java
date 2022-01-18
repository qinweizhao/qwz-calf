package com.qinweizhao.common.core.base;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * 实体类的基类
 *
 * @author qinweizhao
 * @since 2021/11/18
 */
@Data
@ApiModel("BaseEntity 对象")
public abstract class BaseEntity implements Serializable {

//    @ApiModelProperty("排序")
//    @TableField(fill = FieldFill.INSERT)
//    private Integer sort;

    @ApiModelProperty("删除：0存在、1删除")
    @TableLogic
    @TableField(fill = FieldFill.INSERT)
    private Integer deleted;

    @ApiModelProperty("状态：1启用、0禁用")
    @TableField(fill = FieldFill.INSERT)
    private Integer status;

    @ApiModelProperty("创建者")
    @TableField(fill = FieldFill.INSERT)
    private String createBy;

    @ApiModelProperty("更新者")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String updateBy;

    @ApiModelProperty("创建日期")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

}
