package com.qinweizhao.system.entity;

import com.qinweizhao.common.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 角色和菜单关联表
 * </p>
 *
 * @author qinweizhao
 * @since 2021-07-29
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "SysRoleMenu对象", description = "角色和菜单关联表")
public class SysRoleMenu extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "角色ID")
    private Long roleId;

    @ApiModelProperty(value = "菜单ID")
    private Long menuId;


}
