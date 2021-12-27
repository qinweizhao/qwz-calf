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
 * 定时任务日志表
 * </p>
 *
 * @author qinweizhao
 * @since 2021-12-27
 */
@TableName("sys_job_log")
@ApiModel(value = "SysJobLog对象", description = "定时任务日志表")
public class SysJobLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("日志编号")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("任务编号")
    private Long jobId;

    @ApiModelProperty("处理器的名字")
    private String handlerName;

    @ApiModelProperty("处理器的参数")
    private String handlerParam;

    @ApiModelProperty("第几次执行")
    private Integer executeIndex;

    @ApiModelProperty("开始执行时间")
    private LocalDateTime beginTime;

    @ApiModelProperty("结束执行时间")
    private LocalDateTime endTime;

    @ApiModelProperty("执行时长")
    private Integer duration;

    @ApiModelProperty("任务状态")
    private Integer status;

    @ApiModelProperty("结果数据")
    private String result;

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
    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }
    public String getHandlerName() {
        return handlerName;
    }

    public void setHandlerName(String handlerName) {
        this.handlerName = handlerName;
    }
    public String getHandlerParam() {
        return handlerParam;
    }

    public void setHandlerParam(String handlerParam) {
        this.handlerParam = handlerParam;
    }
    public Integer getExecuteIndex() {
        return executeIndex;
    }

    public void setExecuteIndex(Integer executeIndex) {
        this.executeIndex = executeIndex;
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
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
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
        return "SysJobLog{" +
            "id=" + id +
            ", jobId=" + jobId +
            ", handlerName=" + handlerName +
            ", handlerParam=" + handlerParam +
            ", executeIndex=" + executeIndex +
            ", beginTime=" + beginTime +
            ", endTime=" + endTime +
            ", duration=" + duration +
            ", status=" + status +
            ", result=" + result +
            ", creator=" + creator +
            ", createTime=" + createTime +
            ", updater=" + updater +
            ", updateTime=" + updateTime +
            ", deleted=" + deleted +
        "}";
    }
}
