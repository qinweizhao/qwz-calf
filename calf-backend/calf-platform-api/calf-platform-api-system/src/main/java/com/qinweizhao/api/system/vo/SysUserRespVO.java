package com.qinweizhao.api.system.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
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
public class SysUserRespVO implements Serializable {

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
     * 邮箱
     */
    private String email;

    /**
     * 用户名
     */
    private String username;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 性别
     */
    private String sex;

    /**
     * 岗位编号
     */
    private List<Long> postIds;

    /**
     * 部门名称
     */
    private String name;

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