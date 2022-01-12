package com.qinweizhao.system.module.manage.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.qinweizhao.common.core.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 角色表
 * </p>
 *
 * @author qinweizhao
 * @since 2021-12-06
 */

@Data
@TableName("sys_role")
@ApiModel(value = "SysRole对象", description = "角色表")
@EqualsAndHashCode(callSuper = true)
public class SysRole extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("ID")
    @TableId(value = "role_id", type = IdType.AUTO)
    private Long roleId;

    @ApiModelProperty("名称")
    private String roleName;

    @ApiModelProperty("标识")
    private String roleKey;

    @ApiModelProperty("级别")
    private Integer level;

    @ApiModelProperty("描述")
    private String description;

    @ApiModelProperty("数据范围：1全部数据权限、2自定数据权限、3本部门数据权限、4本部门及以下数据权限")
    private String dataScope;
}
