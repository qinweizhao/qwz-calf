package com.qinweizhao.system.entity;

import com.qinweizhao.common.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 *
 * </p>
 *
 * @author QinWeiZhao
 * @since 2021-07-13
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "SysRole对象", description = "")
public class SysRole extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "角色名称")
    private String name;

    @ApiModelProperty(value = "角色代码")
    private String code;

    @ApiModelProperty(value = "备注")
    private String remark;


}
