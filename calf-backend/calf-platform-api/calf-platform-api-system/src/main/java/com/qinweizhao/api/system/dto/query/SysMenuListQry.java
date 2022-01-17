package com.qinweizhao.api.system.dto.query;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.qinweizhao.common.core.request.PageQry;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 菜单权限表
 * </p>
 *
 * @author qinweizhao
 * @since 2021-12-06
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel(value = "SysMenu对象", description = "菜单权限表")
public class SysMenuListQry extends PageQry {

    @ApiModelProperty("名称")
    private String menuName;

}
