package com.qinweizhao.system.module.monitor.entity;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 用户在线 Session
 * </p>
 *
 * @author qinweizhao
 * @since 2021-12-22
 */
@Data
@TableName("sys_user_session")
@ApiModel(value = "SysUserSession对象", description = "用户在线 Session")
public class SysUserSession implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("会话编号")
    private String id;

    @ApiModelProperty("用户编号")
    private Long userId;

    @ApiModelProperty("用户类型")
    private Integer userType;

    @ApiModelProperty("会话超时时间")
    private LocalDateTime sessionTimeout;

    @ApiModelProperty("用户账号")
    private String username;

    @ApiModelProperty("用户 IP")
    private String userIp;

    @ApiModelProperty("浏览器 UA")
    private String userAgent;

    @ApiModelProperty("创建者")
    private String createBy;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("更新者")
    private String updateBy;

    @ApiModelProperty("更新时间")
    private LocalDateTime updateTime;

    @TableLogic
    @ApiModelProperty("是否删除")
    private Integer deleted;

}
