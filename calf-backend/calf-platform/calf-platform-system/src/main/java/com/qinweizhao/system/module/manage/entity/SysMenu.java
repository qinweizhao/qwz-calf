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
 * 菜单权限表
 * </p>
 *
 * @author qinweizhao
 * @since 2021-12-06
 */
@Data
@TableName("sys_menu")
@ApiModel(value = "SysMenu对象", description = "菜单权限表")
@EqualsAndHashCode(callSuper = true)
public class SysMenu extends BaseEntity {

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

}
