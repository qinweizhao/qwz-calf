package com.qinweizhao.api.system.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 日志表
 * </p>
 *
 * @author qinweizhao
 * @since 2022-01-20
 */
@Data
@TableName("sys_log")
@ApiModel(value = "SysLog对象", description = "日志表")
public class SysLogDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("日志编号")
    @TableId(value = "log_id", type = IdType.AUTO)
    private Long logId;

    @ApiModelProperty("日志类型")
    private String type;

    @ApiModelProperty("日志标题")
    private String title;

    @ApiModelProperty("操作地址")
    private String ip;

    @ApiModelProperty("请求信息")
    private String request;

    @ApiModelProperty("请求信息")
    private String response;

    @ApiModelProperty("响应信息")
    private String exception;

    @ApiModelProperty("执行时间")
    private Long time;

    @ApiModelProperty("备注")
    private String remark;

    @ApiModelProperty("状态：0成功、1失败")
    private Integer status;

    @ApiModelProperty("删除：0存在、1删除")
    private Integer deleted;

    @ApiModelProperty("创建者")
    private String createBy;

    @ApiModelProperty("更新者")
    private String updateBy;

    @ApiModelProperty("创建日期")
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    private LocalDateTime updateTime;


}
