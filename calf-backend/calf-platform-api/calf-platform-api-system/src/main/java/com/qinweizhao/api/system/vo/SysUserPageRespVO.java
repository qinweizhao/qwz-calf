package com.qinweizhao.api.system.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.qinweizhao.api.system.dto.SysDeptDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 系统用户
 * </p>
 *
 * @author qinweizhao
 * @since 2021-12-06
 */
@Data
public class SysUserPageRespVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    private Long userId;

    /**
     * 编号
     */
    private Long deptId;

    /**
     * 用户名
     */
    private String username;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 部门名称
     */
    private String deptName;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 状态：1启用、0禁用
     */
    private Integer status;

    @ApiModelProperty("创建日期")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

}