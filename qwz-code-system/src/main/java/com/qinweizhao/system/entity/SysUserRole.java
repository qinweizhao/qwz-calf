package com.qinweizhao.system.entity;

import com.qinweizhao.common.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
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
@ApiModel(value = "SysUserRole对象")
public class SysUserRole extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private Long userId;

    private Long roleId;


}
