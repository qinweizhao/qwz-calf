package com.qinweizhao.system.module.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * <p>
 * 角色和部门关联表
 * </p>
 *
 * @author qinweizhao
 * @since 2021-12-06
 */
@TableName("sys_role_dept")
@ApiModel(value = "SysRoleDept对象", description = "角色和部门关联表")
public class SysRoleDept implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("角色ID")
    private Long roleId;

    @ApiModelProperty("部门ID")
    private Long deptId;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    @Override
    public String toString() {
        return "SysRoleDept{" +
                "roleId=" + roleId +
                ", deptId=" + deptId +
                "}";
    }
}
