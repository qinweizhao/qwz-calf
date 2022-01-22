package com.qinweizhao.api.system.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.qinweizhao.api.system.dto.SysPostDTO;
import com.qinweizhao.api.system.dto.SysRoleDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("用户个人中心信息 Response VO")
public class SysUserProfileRespVO {

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
    private Integer sex;

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
    /**
     * 所属角色
     */
    private List<SysRoleDTO> roles;

    /**
     * 所在部门
     */
    private Dept dept;

    /**
     * 所属岗位数组
     */
    private List<SysPostDTO> posts;

    @ApiModel("角色")
    @Data
    public static class Role {

        @ApiModelProperty(value = "角色编号", required = true, example = "1")
        private Long id;

        @ApiModelProperty(value = "角色名称", required = true, example = "普通角色")
        private String name;

    }

    @ApiModel("部门")
    @Data
    public static class Dept {

        @ApiModelProperty(value = "部门编号", required = true, example = "1")
        private Long id;

        @ApiModelProperty(value = "部门名称", required = true, example = "研发部")
        private String name;

    }

    @ApiModel("岗位")
    @Data
    public static class Post {

        @ApiModelProperty(value = "岗位编号", required = true, example = "1")
        private Long id;

        @ApiModelProperty(value = "岗位名称", required = true, example = "开发")
        private String name;

    }


}
