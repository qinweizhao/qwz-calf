package com.qinweizhao.api.system.dto.query;

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
public class SysRolePageQry extends PageQry {

    /**
     * 用户名
     */
    @ApiModelProperty(value = "角色名称")
    private String name;

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
