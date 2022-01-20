package com.qinweizhao.api.system.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 参数配置表
 * </p>
 *
 * @author qinweizhao
 * @since 2021-12-22
 */
@Data
@ApiModel(value = "SysConfigVO对象")
public class SysConfigVO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("参数主键")
    @TableId(value = "config_id", type = IdType.AUTO)
    private Long configId;

    @ApiModelProperty("参数分组")
    private String group;

    @ApiModelProperty("参数类型")
    private Integer type;

    @ApiModelProperty("参数名称")
    private String name;

    @ApiModelProperty("参数键名")
    private String code;

    @ApiModelProperty("参数分组")
    private String category;

    @ApiModelProperty("参数键值")
    private String value;

    @ApiModelProperty("备注")
    private String remark;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("更新时间")
    private Date updateTime;

    @ApiModelProperty("创建者")
    private String createBy;

    @ApiModelProperty("更新者")
    private String updateBy;

}
