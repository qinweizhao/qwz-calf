package com.qinweizhao.api.system.dto.query;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.qinweizhao.common.core.request.PageQry;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

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
@EqualsAndHashCode(callSuper = true)
public class SysJobLogPageQry extends PageQry {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("日志编号")
    @TableId(value = "id", type = IdType.AUTO)
    private Long jobLogId;

    @ApiModelProperty("任务编号")
    private Long jobId;

    @ApiModelProperty("处理器的名字")
    private String handlerName;

    @ApiModelProperty("处理器的参数")
    private String handlerParam;

    @ApiModelProperty("第几次执行")
    private Integer executeIndex;

    // TODO
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
    private String createBy;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("更新者")
    private String updateBy;

    @ApiModelProperty("更新时间")
    private LocalDateTime updateTime;


}
