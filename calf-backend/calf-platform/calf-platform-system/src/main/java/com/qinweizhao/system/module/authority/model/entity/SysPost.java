package com.qinweizhao.system.module.authority.model.entity;

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
 * 岗位信息表
 * </p>
 *
 * @author qinweizhao
 * @since 2021-12-06
 */
@Data
@TableName("sys_post")
@ApiModel(value = "SysPost对象", description = "岗位信息表")
public class SysPost implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("岗位ID")
    @TableId(value = "post_id", type = IdType.AUTO)
    private Long postId;

    @ApiModelProperty("岗位编码")
    private String postCode;

    @ApiModelProperty("岗位名称")
    private String postName;

    @ApiModelProperty("显示顺序")
    private Integer postSort;

    @ApiModelProperty("删除标志：1存在、0删除")
    private String deleted;

    @ApiModelProperty("状态（1正常 0停用）")
    private String enabled;

    @ApiModelProperty("创建者")
    private String createBy;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("更新者")
    private String updateBy;

    @ApiModelProperty("更新时间")
    private Date updateTime;

}
