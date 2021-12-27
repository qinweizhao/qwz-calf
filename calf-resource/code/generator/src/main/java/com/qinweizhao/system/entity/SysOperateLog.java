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
 * 操作日志记录
 * </p>
 *
 * @author qinweizhao
 * @since 2021-12-27
 */
@TableName("sys_operate_log")
@ApiModel(value = "SysOperateLog对象", description = "操作日志记录")
public class SysOperateLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("日志主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("链路追踪编号")
    private String traceId;

    @ApiModelProperty("用户编号")
    private Long userId;

    @ApiModelProperty("模块标题")
    private String module;

    @ApiModelProperty("操作名")
    private String name;

    @ApiModelProperty("操作分类")
    private Long operateType;

    @ApiModelProperty("操作内容")
    private String content;

    @ApiModelProperty("拓展字段")
    private String exts;

    @ApiModelProperty("请求方法名")
    private String requestMethod;

    @ApiModelProperty("请求地址")
    private String requestUrl;

    @ApiModelProperty("用户 IP")
    private String userIp;

    @ApiModelProperty("浏览器 UA")
    private String userAgent;

    @ApiModelProperty("Java 方法名")
    private String javaMethod;

    @ApiModelProperty("Java 方法的参数")
    private String javaMethodArgs;

    @ApiModelProperty("操作时间")
    private LocalDateTime startTime;

    @ApiModelProperty("执行时长")
    private Integer duration;

    @ApiModelProperty("结果码")
    private Integer resultCode;

    @ApiModelProperty("结果提示")
    private String resultMsg;

    @ApiModelProperty("结果数据")
    private String resultData;

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
    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Long getOperateType() {
        return operateType;
    }

    public void setOperateType(Long operateType) {
        this.operateType = operateType;
    }
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public String getExts() {
        return exts;
    }

    public void setExts(String exts) {
        this.exts = exts;
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
    public String getJavaMethod() {
        return javaMethod;
    }

    public void setJavaMethod(String javaMethod) {
        this.javaMethod = javaMethod;
    }
    public String getJavaMethodArgs() {
        return javaMethodArgs;
    }

    public void setJavaMethodArgs(String javaMethodArgs) {
        this.javaMethodArgs = javaMethodArgs;
    }
    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
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
    public String getResultData() {
        return resultData;
    }

    public void setResultData(String resultData) {
        this.resultData = resultData;
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
        return "SysOperateLog{" +
            "id=" + id +
            ", traceId=" + traceId +
            ", userId=" + userId +
            ", module=" + module +
            ", name=" + name +
            ", operateType=" + operateType +
            ", content=" + content +
            ", exts=" + exts +
            ", requestMethod=" + requestMethod +
            ", requestUrl=" + requestUrl +
            ", userIp=" + userIp +
            ", userAgent=" + userAgent +
            ", javaMethod=" + javaMethod +
            ", javaMethodArgs=" + javaMethodArgs +
            ", startTime=" + startTime +
            ", duration=" + duration +
            ", resultCode=" + resultCode +
            ", resultMsg=" + resultMsg +
            ", resultData=" + resultData +
            ", creator=" + creator +
            ", createTime=" + createTime +
            ", updater=" + updater +
            ", updateTime=" + updateTime +
            ", deleted=" + deleted +
        "}";
    }
}
