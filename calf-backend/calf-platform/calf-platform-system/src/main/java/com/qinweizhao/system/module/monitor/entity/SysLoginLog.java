package com.qinweizhao.system.module.monitor.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 系统访问记录
 * </p>
 *
 * @author qinweizhao
 * @since 2021-12-22
 */
@TableName("sys_login_log")
@ApiModel(value = "SysLoginLog对象", description = "系统访问记录")
public class SysLoginLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("访问ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("日志类型")
    private Long logType;

    @ApiModelProperty("链路追踪编号")
    private String traceId;

    @ApiModelProperty("用户编号")
    private Long userId;

    @ApiModelProperty("用户类型")
    private Integer userType;

    @ApiModelProperty("用户账号")
    private String username;

    @ApiModelProperty("登陆结果")
    private Integer result;

    @ApiModelProperty("用户 IP")
    private String userIp;

    @ApiModelProperty("浏览器 UA")
    private String userAgent;

    @ApiModelProperty("创建者")
    private String creator;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("更新者")
    private String updater;

    @ApiModelProperty("更新时间")
    private LocalDateTime updateTime;

    @ApiModelProperty("是否删除")
    private Boolean deleted;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getLogType() {
        return logType;
    }

    public void setLogType(Long logType) {
        this.logType = logType;
    }
    public String getTraceId() {
        return traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }
    public String getUserIp() {
        return userIp;
    }

    public void setUserIp(String userIp) {
        this.userIp = userIp;
    }
    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }
    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }
    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }
    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "SysLoginLog{" +
            "id=" + id +
            ", logType=" + logType +
            ", traceId=" + traceId +
            ", userId=" + userId +
            ", userType=" + userType +
            ", username=" + username +
            ", result=" + result +
            ", userIp=" + userIp +
            ", userAgent=" + userAgent +
            ", creator=" + creator +
            ", createTime=" + createTime +
            ", updater=" + updater +
            ", updateTime=" + updateTime +
            ", deleted=" + deleted +
        "}";
    }
}
