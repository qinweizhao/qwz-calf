package com.qinweizhao.system.module.authority.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * <p>
 * 角色菜单关联
 * </p>
 *
 * @author qinweizhao
 * @since 2021-12-10
 */
@TableName("sys_role_menu")
@ApiModel(value = "SysRoleMenu对象", description = "角色菜单关联")
public class SysRoleMenu implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("菜单ID")
    private Long menuId;

    @ApiModelProperty("角色ID")
    private Long roleId;

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }
    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "SysRoleMenu{" +
            "menuId=" + menuId +
            ", roleId=" + roleId +
        "}";
    }
}
