package com.qinweizhao.common.core.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 返回码实现
 *
 * @author qinweizhao
 */

@Getter
@AllArgsConstructor
public enum ResultCode implements IResultCode {

    /**
     * 操作成功
     */
    SUCCESS(200, "操作成功"),
    /**
     * 业务异常
     */
    FAILURE(400, "业务异常"),
    /**
     * 服务未找到
     */
    NOT_FOUND(404, "服务未找到"),
    /**
     * 服务异常
     */
    ERROR(500, "服务异常"),
    /**
     * Too Many Requests
     */
    TOO_MANY_REQUESTS(429, "Too Many Requests"),

    /**
     * 服务不可用
     */
    SERVICE_UNAVAILABLE(503, "服务不可用"),
    /**
     * 参数错误
     */
    GLOBAL_PARAM_ERROR(4000, "参数错误"),
    /**
     * 获取当前用户失败
     */
    CURRENT_USER_FAIL(10001, "获取当前用户失败"),
    /**
     * 用户是超级管理员，不可以修改状态
     */
    UPDATE_USER_STATUS(10002, "用户是超级管理员，不可以修改状态"),
    /**
     * 用户是超级管理员，不可以修改密码
     */
    UPDATE_USER_PASSWORD(10003, "用户是超级管理员，不可以修改密码"),
    /**
     * 用户未登录，请登陆后进行访问
     */
    USER_NEED_LOGIN(11001, "用户未登录，请登陆后进行访问"),
    /**
     * 该用户已在其它地方登录
     */
    USER_MAX_LOGIN(11002, "该用户已在其它地方登录"),
    /**
     * 长时间未操作，自动退出
     */
    USER_LOGIN_TIMEOUT(11003, "长时间未操作，自动退出"),
    /**
     * 用户被禁11005用
     */
    USER_DISABLED(11004, "用户被禁11005用"),
    /**
     * 用户被锁定
     */
    USER_LOCKED(11005, "用户被锁定"),
    /**
     * 用户名或密码错误
     */
    USER_PASSWORD_ERROR(11006, "用户名或密码错误"),
    /**
     * 用户密码过期
     */
    USER_PASSWORD_EXPIRED(11007, "用户密码过期"),
    /**
     * 用户账号过期
     */
    USER_ACCOUNT_EXPIRED(11008, "用户账号过期"),
    /**
     * 没有该用户
     */
    USER_NOT_EXIST(11009, "没有该用户"),
    /**
     * 用户登录失败
     */
    USER_LOGIN_FAIL(11010, "用户登录失败"),
    /**
     * 验证码错误
     */
    VERIFY_CODE_ERROR(11011, "验证码错误"),
    /**
     * 用户已存在
     */
    USER_IS_EXIST(11012, "用户已存在"),
    /**
     * 无权访问
     */
    NO_AUTHENTICATION(1003006, "无权访问"),
    /**
     * 角色ID无效
     */
    ROLE_IS_NOT_EXIST(13001, "角色ID无效"),
    /**
     * 角色代码已存在
     */
    ROLE_IS_EXIST(13002, "角色代码已存在"),
    /**
     * 配置信息为空
     */
    CONFIG_ID_IS_NOT_EXIST(14001, "配置信息为空"),
    /**
     * 配置ID无效
     */
    CONFIG_IS_NOT_EXIST(14002, "配置ID无效"),
    /**
     * 配置ID已存在
     */
    CONFIG_IS_EXIST(14002, "配置ID已存在"),
    /**
     * 系统配置不允许修改
     */
    CONFIG_IS_SYSTEM(14003, "系统配置不允许修改"),
    /**
     * 系统配置不允许删除
     */
    CONFIG_IS_NOT_DELETE(14003, "系统配置不允许删除"),
    /**
     * 文件不存在
     */
    FILE_DOES_NOT_EXIST(16001, "文件不存在"),
    /**
     * 文件上传异常
     */
    FILE_UPLOAD_EXCEPTION(16002, "文件上传异常"),
    /**
     * 文件下载异常
     */
    FILE_DOWNLOAD_ABNORMAL(16003, "文件下载异常"),
    /**
     * 无效的资源ID
     */
    RESOURCE_NOT_FIND(12001, "无效的资源ID"),
    /**
     * 资源ID已存在
     */
    RESOURCE_IS_EXIST(12001, "资源ID已存在"),
    /**
     * 无效资源父节点ID
     */
    RESOURCE_PARENT_NOT_FIND(12002, "无效资源父节点ID"),
    /**
     * 无效资源父节点ID
     */
    RESOURCE_PARENT_INVALID(12003, "无效资源父节点ID"),
    /**
     * 该资源下有子资源，不能删除
     */
    RESOURCE_HAVE_SUB(12004, "该资源下有子资源，不能删除"),
    /**
     * 机构已存在
     */
    ORG_IS_EXIST(17001, "机构已存在"),
    /**
     * 机构不存在
     */
    ORG_NOT_EXIST(17002, "机构不存在"),
    /**
     * 机构下存在用户
     */
    ORG_HAVE_USER(17003, "机构下存在用户"),
    /**
     * 无效机构父节点ID
     */
    ORG_PID_ERROR(17004, "无效机构父节点ID"),
    /**
     * 父级节点禁止删除
     */
    ORG_TOP_FORBID(17005, "父级节点禁止删除"),
    /**
     * 机构下存在子机构
     */
    ORG_HAVE_BRANCH(17006, "机构下存在子机构"),
    /**
     * 停用原因不能为空
     */
    ORG_STOP_REASON(17007, "停用原因不能为空"),
    //数据组
    /**
     * 数据组信息不存在
     */
    GROUP_ID_ERROR(19001, "数据组信息不存在"),
    /**
     * 数据组初始化无机构信息
     */
    GROUP_INIT_DATA_ERROR(19002, "数据组初始化无机构信息"),


    // ========== 菜单模块 1002002000 ==========
    MENU_NAME_DUPLICATE(1002002000, "已经存在该名字的菜单"),

    MENU_PARENT_NOT_EXISTS(1002002001, "父菜单不存在"),

    MENU_PARENT_ERROR(1002002002, "不能设置自己为父菜单"),

    MENU_NOT_EXISTS(1002002003, "菜单不存在"),

    MENU_EXISTS_CHILDREN(1002002004, "存在子菜单，无法删除"),

    MENU_PARENT_NOT_DIR_OR_MENU(1002002005, "父菜单的类型必须是目录或者菜单"),

    // ========== 角色模块 1002003000 ==========
    ROLE_NOT_EXISTS(1002003000, "角色不存在"),

    ROLE_NAME_DUPLICATE(1002003001, "已经存在名为【{}】的角色"),

    ROLE_CODE_DUPLICATE(1002003002, "已经存在编码为【{}】的角色"),

    ROLE_CAN_NOT_UPDATE_SYSTEM_TYPE_ROLE(1002003004, "不能操作类型为系统内置的角色"),

    // ========== 用户模块 1002004000 ==========
    USER_USERNAME_EXISTS(1002004000, "用户名称已经存在"),

    USER_MOBILE_EXISTS(1002004001, "手机号已经存在"),

    USER_EMAIL_EXISTS(1002004002, "邮箱已经存在"),

    USER_NOT_EXISTS(1002004003, "用户不存在"),

    USER_IMPORT_LIST_IS_EMPTY(1002004004, "导入用户数据不能为空！"),

    USER_PASSWORD_FAILED(1002004005, "用户密码校验失败"),

    // ========== 部门模块 1002005000 ==========
    DEPT_NAME_DUPLICATE(1002004001, "已经存在该名字的部门"),

    DEPT_PARENT_NOT_EXITS(1002004002, "父级部门不存在"),

    DEPT_NOT_FOUND(1002004003, "当前部门不存在"),

    DEPT_EXITS_CHILDREN(1002004004, "存在子部门，无法删除"),

    DEPT_PARENT_ERROR(1002004005, "不能设置自己为父部门"),

    DEPT_EXISTS_USER(1002004006, "部门中存在员工，无法删除"),

    DEPT_NOT_ENABLE(1002004007, "部门不处于开启状态，不允许选择"),

    DEPT_PARENT_IS_CHILD(1002004008, "不能设置自己的子部门为父部门"),

    // ========== 岗位模块 1002005000 ==========
    POST_NOT_FOUND(1002005001, "当前岗位不存在"),

    POST_NOT_ENABLE(1002005002, "岗位({}) 不处于开启状态，不允许选择"),

    POST_NAME_DUPLICATE(1002005001, "已经存在该名字的岗位"),

    POST_CODE_DUPLICATE(1002005001, "已经存在该标识的岗位"),

    // ========== 字典类型 1002006000 ==========
    DICT_TYPE_NOT_EXISTS(1002006001, "当前字典类型不存在"),

    DICT_TYPE_NOT_ENABLE(1002006002, "字典类型不处于开启状态，不允许选择"),

    DICT_TYPE_NAME_DUPLICATE(1002006003, "已经存在该名字的字典类型"),

    DICT_TYPE_TYPE_DUPLICATE(1002006004, "已经存在该类型的字典类型"),

    DICT_TYPE_HAS_CHILDREN(1002006004, "无法删除，该字典类型还有字典数据"),

    // ========== 字典数据 1002007000 ==========
    DICT_DATA_NOT_EXISTS(1002007001, "当前字典数据不存在"),

    DICT_DATA_NOT_ENABLE(1002007002, "字典数据不处于开启状态，不允许选择"),

    DICT_DATA_VALUE_DUPLICATE(1002007003, "已经存在该值的字典数据");

    /**
     * 状态码
     */
    final int code;
    /**
     * 消息内容
     */
    final String msg;
}
