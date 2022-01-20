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
 * 定时任务表
 * </p>
 *
 * @author qinweizhao
 * @since 2021-12-27
 */
@Data
@ApiModel(value = "SysJob对象", description = "定时任务表")
@EqualsAndHashCode(callSuper = true)
public class SysJobPageQry extends PageQry {


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

    private Integer deleted;


    /**
     * 开始日期
     */
    @ApiModelProperty(hidden = true)
    private String beginTime;

    /**
     * 结束日期
     */
    @ApiModelProperty(hidden = true)
    private String endTime;
}
