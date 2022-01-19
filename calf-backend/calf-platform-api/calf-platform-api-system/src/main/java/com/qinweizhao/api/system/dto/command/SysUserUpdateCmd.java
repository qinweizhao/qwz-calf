package com.qinweizhao.api.system.dto.command;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author qinweizhao
 * @since 2022/1/14
 */
@ApiModel("新增用户请求")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SysUserUpdateCmd implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("部门编号")
    private Long userId;

    @ApiModelProperty("部门编号")
    private Long deptId;

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("昵称")
    private String nickName;

    @ApiModelProperty("性别")
    private Integer sex;

    @ApiModelProperty("手机号码")
    private String phone;

    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty("岗位编号")
    private List<Long> roleIds;

    @ApiModelProperty("岗位编号")
    private List<Long> postIds;

}
