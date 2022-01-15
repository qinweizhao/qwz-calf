package com.qinweizhao.api.system.vo.resp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.qinweizhao.api.system.dto.SysDeptDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 系统用户
 * </p>
 *
 * @author qinweizhao
 * @since 2021-12-06
 */
@Data
@ApiModel(value = "SysUserDTO对象", description = "系统用户")
public class SysUserVO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("编号")
    private Long userId;

    @ApiModelProperty("部门编号")
    private Long deptId;

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("部门编号")
    private String deptName;

    @ApiModelProperty("昵称")
    private String nickName;

    @ApiModelProperty("性别")
    private String sex;

    @ApiModelProperty("手机号码")
    private String phone;

    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty("头像")
    private String avatar;

    @ApiModelProperty("排序")
    private Integer sort;

    @ApiModelProperty("删除：1存在、0删除")
    private Integer deleted;

    @ApiModelProperty("状态：1启用、0禁用")
    private Integer status;

    @ApiModelProperty("创建者")
    private String createBy;

    @ApiModelProperty("更新者")
    private String updateBy;

    @ApiModelProperty("创建日期")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

    @ApiModelProperty("岗位编号")
    private List<Long> postIds;

    @ApiModelProperty("角色编号")
    private List<Long> roleIds;

    @ApiModelProperty("所属部门")
    private SysDeptDTO dept;


}
