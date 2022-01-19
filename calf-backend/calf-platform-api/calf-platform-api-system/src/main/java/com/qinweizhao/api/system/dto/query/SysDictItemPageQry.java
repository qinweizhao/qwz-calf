package com.qinweizhao.api.system.dto.query;

import com.baomidou.mybatisplus.annotation.TableName;
import com.qinweizhao.common.core.request.PageQry;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 字典数据表
 * </p>
 *
 * @author qinweizhao
 * @since 2021-12-21
 */
@Data
@ApiModel(value = "SysDictItem 查询对象")
@EqualsAndHashCode(callSuper = true)
public class SysDictItemPageQry extends PageQry {

    @ApiModelProperty("字典标签")
    private String label;

    @ApiModelProperty("字典键值")
    private String value;

    @ApiModelProperty("字典类型")
    private String dictType;

    @ApiModelProperty("状态（0正常 1停用）")
    private Integer status;

}
