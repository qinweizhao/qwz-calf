package com.qinweizhao.api.system.dto.command;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 角色表
 * </p>
 *
 * @author qinweizhao
 * @since 2021-12-06
 */
@Data
@ApiModel(value = "SysRole对象", description = "角色表")
public class SysRoleSaveCmd implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("ID")
    @TableId(value = "role_id", type = IdType.AUTO)
    private Long roleId;

    @ApiModelProperty("名称")
    private String name;

    @ApiModelProperty("标识")
    private String code;

    @ApiModelProperty("描述")
    private String description;

    @ApiModelProperty("数据范围：1全部数据权限、2自定数据权限、3本部门数据权限、4本部门及以下数据权限")
    private Integer dataScope;

    @ApiModelProperty("排序")
    private Integer sort;

    @ApiModelProperty("删除：0存在、1删除")
    private Integer deleted;

    @ApiModelProperty("状态：1正常、0停用")
    private Integer status;

    @ApiModelProperty("创建者")
    private String createBy;

    @ApiModelProperty("更新者")
    private String updateBy;

    @ApiModelProperty("创建日期")
    private Date createTime;

    @ApiModelProperty("更新时间")
    private Date updateTime;

    @ApiModelProperty("部门编号")
    private List<Long> deptIds;

    @ApiModelProperty("菜单编号")
    private List<Long> menuIds;

}
