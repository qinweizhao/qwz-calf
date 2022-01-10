package com.qinweizhao.system.module.monitor.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 日志表
 * </p>
 *
 * @author qinweizhao
 * @since 2022-01-04
 */
@Data
@TableName("sys_log")
@ApiModel(value = "SysLog对象", description = "日志表")
public class SysLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("日志编号")
    @TableId(value = "log_id", type = IdType.AUTO)
    private Long logId;

    @ApiModelProperty("日志类型")
    private String logType;

    @ApiModelProperty("日志标题")
    private String logTitle;

    @ApiModelProperty("请求信息")
    private String request;

    @ApiModelProperty("异常信息")
    private String exception;

    @ApiModelProperty("执行时间")
    private String time;

    @ApiModelProperty("删除标记")
    private String deleted;

    @ApiModelProperty("状态：0成功、1失败")
    private String status;

    @ApiModelProperty("创建人")
    private String createBy;

    @ApiModelProperty("更新人")
    private String updateBy;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    private LocalDateTime updateTime;

}
