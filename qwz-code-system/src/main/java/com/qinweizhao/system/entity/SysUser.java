package com.qinweizhao.system.entity;

import com.qinweizhao.common.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * <p>
 *
 * </p>
 *
 * @author QinWeiZhao
 * @since 2021-07-13
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "SysUser对象", description = "")
public class SysUser extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户账号")
    private String username;

    @ApiModelProperty(value = "用户密码")
    private String password;

    @ApiModelProperty(value = "头像地址")
    private String avatar;

    @ApiModelProperty(value = "用户邮箱")
    private String email;

    @ApiModelProperty(value = "最后登录时间")
    private LocalDateTime lastLogin;


}
