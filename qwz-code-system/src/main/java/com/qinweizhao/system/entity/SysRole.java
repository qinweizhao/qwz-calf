package com.qinweizhao.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;

import com.qinweizhao.common.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 角色信息表
 * </p>
 *
 * @author qinweizhao
 * @since 2021-07-29
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value="SysRole对象", description="角色信息表")
public class SysRole extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "角色ID")
    @TableId(value = "role_id", type = IdType.AUTO)
    private Long roleId;

    @ApiModelProperty(value = "角色名称")
    private String roleName;

    @ApiModelProperty(value = "角色权限字符串")
    private String roleKey;

    @ApiModelProperty(value = "角色状态（0正常 1停用）")
    private String status;

    @ApiModelProperty(value = "创建者")
    private String createBy;

    @ApiModelProperty(value = "更新者")
    private String updateBy;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;


}
