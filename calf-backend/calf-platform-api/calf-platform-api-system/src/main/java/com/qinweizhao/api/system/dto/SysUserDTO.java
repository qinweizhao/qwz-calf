package com.qinweizhao.api.system.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
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
public class SysUserDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    private Long userId;

    /**
     * 部门编号
     */
    private Long deptId;

    /**
     * 用户名
     */
    private String username;


    /**
     * 用户名
     */
    private String password;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 性别
     */
    private Integer sex;


    /**
     * 手机号码
     */
    private String phone;


    /**
     * 邮箱
     */
    private String email;


    /**
     * 头像
     */
    private String avatar;


    /**
     * 状态：1启用、0禁用
     */
    private Integer status;


    /**
     * 岗位编号
     */
    private List<Long> postIds;

    /**
     * 角色编号
     */
    private List<Long> roleIds;

    /**
     * 创建日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

}
