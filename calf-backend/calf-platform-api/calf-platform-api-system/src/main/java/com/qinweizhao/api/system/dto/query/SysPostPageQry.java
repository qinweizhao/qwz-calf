package com.qinweizhao.api.system.dto.query;

import com.qinweizhao.common.core.request.PageQry;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 岗位信息表
 * </p>
 *
 * @author qinweizhao
 * @since 2021-12-06
 */
@Data
@ApiModel(value = "SysPost对象", description = "岗位信息表")
@EqualsAndHashCode(callSuper = true)
public class SysPostPageQry extends PageQry {

    @ApiModelProperty("岗位名称")
    private String name;

}
