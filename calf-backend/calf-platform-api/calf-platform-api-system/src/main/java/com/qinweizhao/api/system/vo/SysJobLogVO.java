package com.qinweizhao.api.system.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 定时任务日志表
 * </p>
 *
 * @author qinweizhao
 * @since 2021-12-27
 */
@Data
@ApiModel(value = "SysJobLog对象", description = "定时任务日志表")
public class SysJobLogVO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("日志编号")
    private Long jobLogId;

    @ApiModelProperty("任务编号")
    private Long jobId;

    @ApiModelProperty("处理器的名字")
    private String handlerName;

    @ApiModelProperty("处理器的参数")
    private String handlerParam;

    @ApiModelProperty("第几次执行")
    private Integer executeIndex;

    @ApiModelProperty("开始执行时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime beginTime;

    @ApiModelProperty("结束执行时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endTime;

    @ApiModelProperty("执行时长")
    private Integer duration;

    @ApiModelProperty("任务状态")
    private Integer status;

    @ApiModelProperty("结果数据")
    private String result;

    @ApiModelProperty("创建者")
    private String createBy;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("更新者")
    private String updateBy;

    @ApiModelProperty("更新时间")
    private LocalDateTime updateTime;

    @ApiModelProperty("是否删除")
    private Integer deleted;


}
