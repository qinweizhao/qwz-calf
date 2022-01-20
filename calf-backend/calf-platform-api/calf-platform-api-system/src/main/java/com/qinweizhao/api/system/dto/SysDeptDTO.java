package com.qinweizhao.api.system.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 部门表
 * </p>
 *
 * @author qinweizhao
 * @since 2021-12-06
 */
@Data
@ApiModel(value = "SysDept对象", description = "部门表")
public class SysDeptDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("ID")
    private Long deptId;

    @ApiModelProperty("父ID")
    private Long parentId;

    @ApiModelProperty("名称")
    private String name;

    @ApiModelProperty("电话")
    private String phone;

    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty("排序")
    private String sort;


    @ApiModelProperty("删除：1存在、0删除")
    private Integer deleted;

    @ApiModelProperty("状态：1启用、0禁用")
    private Integer status;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("更新时间")
    private Date updateTime;


}
