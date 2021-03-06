package com.qinweizhao.api.system.dto.command;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 参数配置表
 * </p>
 *
 * @author qinweizhao
 * @since 2021-12-22
 */
@Data
@TableName("sys_config")
@ApiModel(value = "SysConfig对象", description = "参数配置表")
public class SysConfigSaveCmd implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("参数主键")
    @TableId(value = "config_id", type = IdType.AUTO)
    private Long configId;

    @ApiModelProperty("参数分组")
    private String category;

    @ApiModelProperty("参数类型")
    private Integer type;

    @ApiModelProperty("参数名称")
    private String name;

    @ApiModelProperty("参数键名")
    private String code;

    @ApiModelProperty("参数键值")
    private String value;


    @ApiModelProperty("备注")
    private String remark;

}
