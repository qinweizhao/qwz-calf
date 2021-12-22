package com.qinweizhao.system.module.system.entity;

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
 * 字典数据表
 * </p>
 *
 * @author qinweizhao
 * @since 2021-12-21
 */
@Data
@TableName("sys_dict_data")
@ApiModel(value = "SysDictData对象", description = "字典数据表")
public class SysDictData implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("字典编码")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("字典排序")
    private Integer sort;

    @ApiModelProperty("字典标签")
    private String label;

    @ApiModelProperty("字典键值")
    private String value;

    @ApiModelProperty("字典类型")
    private String dictType;

    @ApiModelProperty("状态（0正常 1停用）")
    private Integer status;

    @ApiModelProperty("备注")
    private String remark;

    @ApiModelProperty("创建者")
    private String creator;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("更新者")
    private String updater;

    @ApiModelProperty("更新时间")
    private Date updateTime;

    @ApiModelProperty("是否删除")
    private Boolean deleted;

}
