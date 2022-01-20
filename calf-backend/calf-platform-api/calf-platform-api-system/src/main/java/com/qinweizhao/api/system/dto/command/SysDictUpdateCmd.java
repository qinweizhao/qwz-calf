package com.qinweizhao.api.system.dto.command;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 字典类型表
 * </p>
 *
 * @author qinweizhao
 * @since 2021-12-21
 */
@Data
@TableName("sys_dict")
@ApiModel(value = "SysDictType对象", description = "字典类型表")
public class SysDictUpdateCmd implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("字典主键")
    @TableId(value = "dict_id", type = IdType.AUTO)
    private Long dictId;

    @ApiModelProperty("字典名称")
    private String name;

    @ApiModelProperty("字典类型")
    private String type;

    @ApiModelProperty("状态（0正常 1停用）")
    private Integer status;

    @ApiModelProperty("备注")
    private String remark;

    @ApiModelProperty("创建者")
    private String createBy;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("更新者")
    private String updateBy;

    @ApiModelProperty("更新时间")
    private Date updateTime;

    @ApiModelProperty("是否删除")

    private Integer deleted;


}
