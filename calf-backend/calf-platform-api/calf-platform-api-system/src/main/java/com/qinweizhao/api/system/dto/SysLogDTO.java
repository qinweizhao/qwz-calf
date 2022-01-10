package com.qinweizhao.api.system.dto;

import com.alibaba.fastjson.JSONObject;
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
 * 操作日志记录
 * </p>
 *
 * @author qinweizhao
 * @since 2021-12-22
 */
@Data
@ApiModel(value = "SysOperateLog对象", description = "操作日志记录")
public class SysLogDTO implements Serializable {

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
    private Long time;

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
