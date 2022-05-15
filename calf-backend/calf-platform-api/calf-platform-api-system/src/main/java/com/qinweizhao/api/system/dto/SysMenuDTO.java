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

    private Long menuId;

    private String name;

    private Long parentId;

    private String path;

    private String component;

    private Integer type;

    private String permission;

    private String icon;

    private Integer sort;

    private Integer deleted;

    private Integer status;

    private String createBy;

    private String updateBy;

    private Date createTime;

    private Date updateTime;

    private List<SysMenuDTO> children;
}
