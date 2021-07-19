package com.qinweizhao.system.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * <p>
 *
 * </p>
 *
 * @author QinWeiZhao
 * @since 2021-07-13
 */
@Data
@ApiModel(value = "SysRoleMenu对象", description = "")
public class SysRoleMenu {

    private static final long serialVersionUID = 1L;

    private Long roleId;

    private Long menuId;


}
