package com.qinweizhao.system.module.manage.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.qinweizhao.common.core.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

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
@EqualsAndHashCode(callSuper = true)
public class SysPost extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("岗位ID")
    @TableId(value = "post_id", type = IdType.AUTO)
    private Long postId;

    @ApiModelProperty("岗位编码")
    private String code;

    @ApiModelProperty("岗位名称")
    private String name;

    @ApiModelProperty("显示顺序")
    private Integer sort;

    @ApiModelProperty("状态（1正常 0停用）")
    private Integer status;

}
