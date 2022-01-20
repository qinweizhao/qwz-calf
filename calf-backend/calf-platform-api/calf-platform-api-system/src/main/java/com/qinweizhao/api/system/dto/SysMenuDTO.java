package com.qinweizhao.api.system.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 菜单权限表
 * </p>
 *
 * @author qinweizhao
 * @since 2021-12-06
 */
@Data
@TableName("sys_menu")
@ApiModel(value = "SysMenu对象", description = "菜单权限表")
public class SysMenuDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("ID")
    @TableId(value = "menu_id", type = IdType.AUTO)
    private Long menuId;

    @ApiModelProperty("名称")
    private String name;

    @ApiModelProperty("父ID")
    private Long parentId;

    @ApiModelProperty("路径")
    private String path;

    @ApiModelProperty("组件")
    private String component;

    @ApiModelProperty("类型：M目录、C菜单、F按钮")
    private Integer type;

    @ApiModelProperty("权限")
    private String permission;

    @ApiModelProperty("图标")
    private String icon;

    @ApiModelProperty("排序")
    private Integer sort;

    @ApiModelProperty("删除：1存在、0删除")
    private Integer deleted;

    @ApiModelProperty("状态：1正常、0停用")
    private Integer status;

    @ApiModelProperty("创建者")
    private String createBy;

    @ApiModelProperty("更新者")
    private String updateBy;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("更新时间")
    private Date updateTime;

    private List<SysMenuDTO> children;
}
