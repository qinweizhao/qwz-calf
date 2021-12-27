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
 * 系统异常日志
 * </p>
 *
 * @author qinweizhao
 * @since 2021-12-27
 */
@TableName("sys_api_error_log")
@ApiModel(value = "SysApiErrorLog对象", description = "系统异常日志")
public class SysApiErrorLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("编号")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("链路追踪编号
     *
     * 一般来说，通过链路追踪编号，可以将访问日志，错误日志，链路追踪日志，logger 打印日志等，结合在一起，从而进行排错。")
    private String traceId;

    @ApiModelProperty("用户编号")
    private Integer userId;

    @ApiModelProperty("用户类型")
    private Integer userType;

    @ApiModelProperty("应用名
     *
     * 目前读取 spring.application.name")
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

    @ApiModelProperty("异常发生时间")
    private LocalDateTime exceptionTime;

    @ApiModelProperty("异常名
     *
     * {@link Throwable#getClass()} 的类全名")
    private String exceptionName;

    @ApiModelProperty("异常导致的消息
     *
     * {@link cn.iocoder.common.framework.util.ExceptionUtil#getMessage(Throwable)}")
    private String exceptionMessage;

    @ApiModelProperty("异常导致的根消息
     *
     * {@link cn.iocoder.common.framework.util.ExceptionUtil#getRootCauseMessage(Throwable)}")
    private String exceptionRootCauseMessage;

    @ApiModelProperty("异常的栈轨迹
     *
     * {@link cn.iocoder.common.framework.util.ExceptionUtil#getServiceException(Exception)}")
    private String exceptionStackTrace;

    @ApiModelProperty("异常发生的类全名
     *
     * {@link StackTraceElement#getClassName()}")
    private String exceptionClassName;

    @ApiModelProperty("异常发生的类文件
     *
     * {@link StackTraceElement#getFileName()}")
    private String exceptionFileName;

    @ApiModelProperty("异常发生的方法名
     *
     * {@link StackTraceElement#getMethodName()}")
    private String exceptionMethodName;

    @ApiModelProperty("异常发生的方法所在行
     *
     * {@link StackTraceElement#getLineNumber()}")
    private Integer exceptionLineNumber;

    @ApiModelProperty("处理状态")
    private Integer processStatus;

    @ApiModelProperty("处理时间")
    private LocalDateTime processTime;

    @ApiModelProperty("处理用户编号")
    private Integer processUserId;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getTraceId() {
        return traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
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
    public LocalDateTime getExceptionTime() {
        return exceptionTime;
    }

    public void setExceptionTime(LocalDateTime exceptionTime) {
        this.exceptionTime = exceptionTime;
    }
    public String getExceptionName() {
        return exceptionName;
    }

    public void setExceptionName(String exceptionName) {
        this.exceptionName = exceptionName;
    }
    public String getExceptionMessage() {
        return exceptionMessage;
    }

    public void setExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }
    public String getExceptionRootCauseMessage() {
        return exceptionRootCauseMessage;
    }

    public void setExceptionRootCauseMessage(String exceptionRootCauseMessage) {
        this.exceptionRootCauseMessage = exceptionRootCauseMessage;
    }
    public String getExceptionStackTrace() {
        return exceptionStackTrace;
    }

    public void setExceptionStackTrace(String exceptionStackTrace) {
        this.exceptionStackTrace = exceptionStackTrace;
    }
    public String getExceptionClassName() {
        return exceptionClassName;
    }

    public void setExceptionClassName(String exceptionClassName) {
        this.exceptionClassName = exceptionClassName;
    }
    public String getExceptionFileName() {
        return exceptionFileName;
    }

    public void setExceptionFileName(String exceptionFileName) {
        this.exceptionFileName = exceptionFileName;
    }
    public String getExceptionMethodName() {
        return exceptionMethodName;
    }

    public void setExceptionMethodName(String exceptionMethodName) {
        this.exceptionMethodName = exceptionMethodName;
    }
    public Integer getExceptionLineNumber() {
        return exceptionLineNumber;
    }

    public void setExceptionLineNumber(Integer exceptionLineNumber) {
        this.exceptionLineNumber = exceptionLineNumber;
    }
    public Integer getProcessStatus() {
        return processStatus;
    }

    public void setProcessStatus(Integer processStatus) {
        this.processStatus = processStatus;
    }
    public LocalDateTime getProcessTime() {
        return processTime;
    }

    public void setProcessTime(LocalDateTime processTime) {
        this.processTime = processTime;
    }
    public Integer getProcessUserId() {
        return processUserId;
    }

    public void setProcessUserId(Integer processUserId) {
        this.processUserId = processUserId;
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
        return "SysApiErrorLog{" +
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
            ", exceptionTime=" + exceptionTime +
            ", exceptionName=" + exceptionName +
            ", exceptionMessage=" + exceptionMessage +
            ", exceptionRootCauseMessage=" + exceptionRootCauseMessage +
            ", exceptionStackTrace=" + exceptionStackTrace +
            ", exceptionClassName=" + exceptionClassName +
            ", exceptionFileName=" + exceptionFileName +
            ", exceptionMethodName=" + exceptionMethodName +
            ", exceptionLineNumber=" + exceptionLineNumber +
            ", processStatus=" + processStatus +
            ", processTime=" + processTime +
            ", processUserId=" + processUserId +
            ", creator=" + creator +
            ", createTime=" + createTime +
            ", updater=" + updater +
            ", updateTime=" + updateTime +
            ", deleted=" + deleted +
            ", tenantId=" + tenantId +
        "}";
    }
}
