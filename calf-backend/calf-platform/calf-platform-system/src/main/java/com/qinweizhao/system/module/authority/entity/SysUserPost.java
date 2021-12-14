package com.qinweizhao.system.module.authority.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * <p>
 * 用户与岗位关联表
 * </p>
 *
 * @author qinweizhao
 * @since 2021-12-06
 */
@TableName("sys_user_post")
@ApiModel(value = "SysUserPost对象", description = "用户与岗位关联表")
public class SysUserPost implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("用户ID")
    private Long userId;

    @ApiModelProperty("岗位ID")
    private Long postId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    @Override
    public String toString() {
        return "SysUserPost{" +
                "userId=" + userId +
                ", postId=" + postId +
                "}";
    }
}
