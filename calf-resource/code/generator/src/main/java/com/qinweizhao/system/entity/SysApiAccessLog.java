package com.qinweizhao.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * API 访问日志表
 * </p>
 *
 * @author qinweizhao
 * @since 2021-12-28
 */
@TableName("sys_api_access_log")
@ApiModel(value = "SysApiAccessLog对象", description = "API 访问日志表")
public class SysApiAccessLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("日志主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("链路追踪编号")
    private String traceId;

    @ApiModelProperty("用户编号")
    private Long userId;

    @ApiModelProperty("用户类型")
    private Integer userType;

    @ApiModelProperty("应用名")
    private String applicationName;

    @ApiModelProperty("请求方法名")
    private String requestMethod;

    @ApiModelProperty("请求地址")
    private String requestUrl;

    @ApiModelProperty("请求参数")
    private String requestParams;

    @ApiModelProperty("用户 IP")
    private String userIp;

    @ApiModelProperty("浏览器 UA")
    private String userAgent;

    @ApiModelProperty("开始请求时间")
    private LocalDateTime beginTime;

    @ApiModelProperty("结束请求时间")
    private LocalDateTime endTime;

    @ApiModelProperty("执行时长")
    private Integer duration;

    @ApiModelProperty("结果码")
    private Integer resultCode;

    @ApiModelProperty("结果提示")
    private String resultMsg;

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

    @ApiModelProperty("租户编号")
    private Long tenantId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }
    public String getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
    }
    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }
    public String getRequestParams() {
        return requestParams;
    }

    public void setRequestParams(String requestParams) {
        this.requestParams = requestParams;
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
    public LocalDateTime getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(LocalDateTime beginTime) {
        this.beginTime = beginTime;
    }
    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }
    public Integer getResultCode() {
        return resultCode;
    }

    public void setResultCode(Integer resultCode) {
        this.resultCode = resultCode;
    }
    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
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
    public Long getTenantId() {
        return tenantId;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

    @Override
    public String toString() {
        return "SysApiAccessLog{" +
            "id=" + id +
            ", traceId=" + traceId +
            ", userId=" + userId +
            ", userType=" + userType +
            ", applicationName=" + applicationName +
            ", requestMethod=" + requestMethod +
            ", requestUrl=" + requestUrl +
            ", requestParams=" + requestParams +
            ", userIp=" + userIp +
            ", userAgent=" + userAgent +
            ", beginTime=" + beginTime +
            ", endTime=" + endTime +
            ", duration=" + duration +
            ", resultCode=" + resultCode +
            ", resultMsg=" + resultMsg +
            ", creator=" + creator +
            ", createTime=" + createTime +
            ", updater=" + updater +
            ", updateTime=" + updateTime +
            ", deleted=" + deleted +
            ", tenantId=" + tenantId +
        "}";
    }
}
