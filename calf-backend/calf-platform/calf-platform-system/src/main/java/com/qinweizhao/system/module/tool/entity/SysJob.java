package com.qinweizhao.system.module.tool.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.qinweizhao.common.core.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 定时任务表
 * </p>
 *
 * @author qinweizhao
 * @since 2021-12-27
 */
@Data
@TableName("sys_job")
@ApiModel(value = "SysJob对象", description = "定时任务表")
@EqualsAndHashCode(callSuper = true)
public class SysJob extends BaseEntity {

    /**
     * 任务调度参数key
     */
    public static final String JOB_PARAM_KEY = "JOB_PARAM_KEY";

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("任务编号")
    @TableId(value = "job_id", type = IdType.AUTO)
    private Long jobId;

    @ApiModelProperty("任务名称")
    private String name;

    @ApiModelProperty("任务状态")
    private Integer status;

    @ApiModelProperty("处理器的名字")
    private String handlerName;

    @ApiModelProperty("处理器的参数")
    private String handlerParam;

    @ApiModelProperty("CRON 表达式")
    private String cronExpression;

    @ApiModelProperty("重试次数")
    private Integer retryCount;

    @ApiModelProperty("重试间隔")
    private Integer retryInterval;

    @ApiModelProperty("监控超时时间")
    private Integer monitorTimeout;

}
