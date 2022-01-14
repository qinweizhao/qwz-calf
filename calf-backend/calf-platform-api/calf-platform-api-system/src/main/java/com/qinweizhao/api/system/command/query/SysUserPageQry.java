package com.qinweizhao.api.system.command.query;

import com.qinweizhao.common.core.request.PageQry;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author qinweizhao
 * @since 2022/1/14
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SysUserPageQry extends PageQry {

    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名")
    private String username;


    /**
     * 部门 Id
     */
    @ApiModelProperty(value = "部门 Id")
    private Long deptId;

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
