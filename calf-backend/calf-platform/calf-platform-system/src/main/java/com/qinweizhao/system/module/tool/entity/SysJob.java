package com.qinweizhao.system.module.tool.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

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
public class SysJob implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("任务编号")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

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

    @ApiModelProperty("创建者")
    private String createBy;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("更新者")
    private String updateBy;

    @ApiModelProperty("更新时间")
    private LocalDateTime updateTime;

    @ApiModelProperty("是否删除")
    @TableLogic
    private Integer deleted;

}
