package com.qinweizhao.system.module.tool.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 定时任务日志表
 * </p>
 *
 * @author qinweizhao
 * @since 2021-12-27
 */
@Data
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

    @TableLogic
    @ApiModelProperty("是否删除")
    private Integer deleted;


}
