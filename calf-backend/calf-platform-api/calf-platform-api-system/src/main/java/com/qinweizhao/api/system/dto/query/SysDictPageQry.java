package com.qinweizhao.api.system.dto.query;

import com.qinweizhao.common.core.request.PageQry;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 字典类型表
 * </p>
 *
 * @author qinweizhao
 * @since 2021-12-21
 */
@Data
@ApiModel(value = "SysDictType对象", description = "字典类型表")
@EqualsAndHashCode(callSuper = true)
public class SysDictPageQry extends PageQry {


    @ApiModelProperty("字典名称")
    private String name;

    @ApiModelProperty("字典类型")
    private String type;

    @ApiModelProperty("状态（0正常 1停用）")
    private Integer status;

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
