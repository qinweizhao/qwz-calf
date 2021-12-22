/*
 Navicat Premium Data Transfer

 Source Server         : TX_Cloud
 Source Server Type    : MySQL
 Source Server Version : 80027
 Source Host           : 42.192.49.72:3306
 Source Schema         : project_calf

 Target Server Type    : MySQL
 Target Server Version : 80027
 File Encoding         : 65001

 Date: 22/12/2021 13:16:53
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_config
-- ----------------------------
DROP TABLE IF EXISTS `sys_config`;
CREATE TABLE `sys_config`  (
  `config_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '参数主键',
  `config_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '参数名称',
  `config_key` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '参数键名',
  `config_value` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '参数键值',
  `config_type` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT 'N' COMMENT '系统内置（Y是 N否）',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`config_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '参数配置表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_config
-- ----------------------------
INSERT INTO `sys_config` VALUES (1, '主框架页-默认皮肤样式名称', 'sys.index.skinName', 'skin-blue', 'Y', 'admin', '2021-12-06 14:50:49', '', NULL, '蓝色 skin-blue、绿色 skin-green、紫色 skin-purple、红色 skin-red、黄色 skin-yellow');
INSERT INTO `sys_config` VALUES (2, '用户管理-账号初始密码', 'sys.user.initPassword', '123456', 'Y', 'admin', '2021-12-06 14:50:49', '', NULL, '初始化密码 123456');
INSERT INTO `sys_config` VALUES (3, '主框架页-侧边栏主题', 'sys.index.sideTheme', 'theme-dark', 'Y', 'admin', '2021-12-06 14:50:49', '', NULL, '深色主题theme-dark，浅色主题theme-light');
INSERT INTO `sys_config` VALUES (4, '账号自助-验证码开关', 'sys.account.captchaOnOff', 'true', 'Y', 'admin', '2021-12-06 14:50:49', '', NULL, '是否开启验证码功能（true开启，false关闭）');
INSERT INTO `sys_config` VALUES (5, '账号自助-是否开启用户注册功能', 'sys.account.registerUser', 'false', 'Y', 'admin', '2021-12-06 14:50:49', '', NULL, '是否开启注册用户功能（true开启，false关闭）');

-- ----------------------------
-- Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept`  (
  `dept_id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `parent_id` bigint(0) NULL DEFAULT 0 COMMENT '父ID',
  `dept_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '名称',
  `phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '电话',
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '邮箱',
  `dept_sort` int(0) NULL DEFAULT 0 COMMENT '排序',
  `deleted` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '删除：1存在、0删除',
  `enabled` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '状态：1启用、0禁用',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`dept_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '部门表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_dept
-- ----------------------------
INSERT INTO `sys_dept` VALUES (1, 0, '1', NULL, NULL, 0, NULL, NULL, '', NULL, '', NULL);
INSERT INTO `sys_dept` VALUES (2, 1, '12', NULL, NULL, 0, NULL, NULL, '', NULL, '', NULL);
INSERT INTO `sys_dept` VALUES (3, 0, '中国', NULL, NULL, 0, NULL, NULL, '', NULL, '', NULL);

-- ----------------------------
-- Table structure for sys_dict_data
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_data`;
CREATE TABLE `sys_dict_data`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '字典编码',
  `sort` int(0) NOT NULL DEFAULT 0 COMMENT '字典排序',
  `label` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '字典标签',
  `value` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '字典键值',
  `dict_type` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '字典类型',
  `status` tinyint(0) NOT NULL DEFAULT 0 COMMENT '状态（0正常 1停用）',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 92 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '字典数据表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_dict_data
-- ----------------------------
INSERT INTO `sys_dict_data` VALUES (1, 1, '男', '1', 'sys_user_sex', 0, '性别男', 'admin', '2021-01-05 17:03:48', '', '2021-01-06 05:48:53', b'0');
INSERT INTO `sys_dict_data` VALUES (2, 2, '女', '2', 'sys_user_sex', 0, '性别女', 'admin', '2021-01-05 17:03:48', '', '2021-01-06 05:48:55', b'0');
INSERT INTO `sys_dict_data` VALUES (8, 1, '正常', '0', 'sys_job_status', 0, '正常状态', 'admin', '2021-01-05 17:03:48', '', '2021-02-07 07:43:57', b'1');
INSERT INTO `sys_dict_data` VALUES (9, 2, '暂停', '1', 'sys_job_status', 0, '停用状态', 'admin', '2021-01-05 17:03:48', '', '2021-02-07 07:43:59', b'1');
INSERT INTO `sys_dict_data` VALUES (10, 1, '默认', 'DEFAULT', 'sys_job_group', 0, '默认分组', 'admin', '2021-01-05 17:03:48', '', '2021-02-07 07:43:44', b'1');
INSERT INTO `sys_dict_data` VALUES (11, 2, '系统', 'SYSTEM', 'sys_job_group', 0, '系统分组', 'admin', '2021-01-05 17:03:48', '', '2021-02-07 07:43:45', b'1');
INSERT INTO `sys_dict_data` VALUES (12, 1, '系统内置', '1', 'sys_config_type', 0, '参数类型 - 系统内置', 'admin', '2021-01-05 17:03:48', '', '2021-01-18 07:41:59', b'0');
INSERT INTO `sys_dict_data` VALUES (13, 2, '自定义', '2', 'sys_config_type', 0, '参数类型 - 自定义', 'admin', '2021-01-05 17:03:48', '', '2021-01-18 07:41:51', b'0');
INSERT INTO `sys_dict_data` VALUES (14, 1, '通知', '1', 'sys_notice_type', 0, '通知', 'admin', '2021-01-05 17:03:48', '', '2021-01-06 00:02:28', b'0');
INSERT INTO `sys_dict_data` VALUES (15, 2, '公告', '2', 'sys_notice_type', 0, '公告', 'admin', '2021-01-05 17:03:48', '', '2021-01-06 00:02:28', b'0');
INSERT INTO `sys_dict_data` VALUES (16, 0, '其它', '0', 'sys_operate_type', 0, '其它操作', 'admin', '2021-01-05 17:03:48', '', '2021-01-16 13:51:12', b'0');
INSERT INTO `sys_dict_data` VALUES (17, 1, '查询', '1', 'sys_operate_type', 0, '查询操作', 'admin', '2021-01-05 17:03:48', '', '2021-01-16 13:51:10', b'0');
INSERT INTO `sys_dict_data` VALUES (18, 2, '新增', '2', 'sys_operate_type', 0, '新增操作', 'admin', '2021-01-05 17:03:48', '', '2021-01-16 13:51:17', b'0');
INSERT INTO `sys_dict_data` VALUES (19, 3, '修改', '3', 'sys_operate_type', 0, '修改操作', 'admin', '2021-01-05 17:03:48', '', '2021-01-16 13:51:20', b'0');
INSERT INTO `sys_dict_data` VALUES (20, 4, '删除', '4', 'sys_operate_type', 0, '删除操作', 'admin', '2021-01-05 17:03:48', '', '2021-01-16 13:51:24', b'0');
INSERT INTO `sys_dict_data` VALUES (22, 5, '导出', '5', 'sys_operate_type', 0, '导出操作', 'admin', '2021-01-05 17:03:48', '', '2021-01-16 13:49:20', b'0');
INSERT INTO `sys_dict_data` VALUES (23, 6, '导入', '6', 'sys_operate_type', 0, '导入操作', 'admin', '2021-01-05 17:03:48', '', '2021-01-16 13:49:24', b'0');
INSERT INTO `sys_dict_data` VALUES (27, 1, '开启', '0', 'sys_common_status', 0, '开启状态', 'admin', '2021-01-05 17:03:48', '', '2021-01-06 02:57:12', b'0');
INSERT INTO `sys_dict_data` VALUES (28, 2, '关闭', '1', 'sys_common_status', 0, '关闭状态', 'admin', '2021-01-05 17:03:48', '', '2021-01-06 05:48:32', b'0');
INSERT INTO `sys_dict_data` VALUES (29, 1, '目录', '1', 'sys_menu_type', 0, '目录', 'admin', '2021-01-05 17:03:48', '', '2021-01-06 13:33:30', b'0');
INSERT INTO `sys_dict_data` VALUES (30, 2, '菜单', '2', 'sys_menu_type', 0, '菜单', 'admin', '2021-01-05 17:03:48', '', '2021-01-06 13:33:35', b'0');
INSERT INTO `sys_dict_data` VALUES (31, 3, '按钮', '3', 'sys_menu_type', 0, '按钮', 'admin', '2021-01-05 17:03:48', '', '2021-01-06 13:33:38', b'0');
INSERT INTO `sys_dict_data` VALUES (32, 1, '内置', '1', 'sys_role_type', 0, '内置角色', 'admin', '2021-01-05 17:03:48', '', '2021-01-06 13:34:22', b'0');
INSERT INTO `sys_dict_data` VALUES (33, 2, '自定义', '2', 'sys_role_type', 0, '自定义角色', 'admin', '2021-01-05 17:03:48', '', '2021-01-06 13:34:26', b'0');
INSERT INTO `sys_dict_data` VALUES (34, 1, '全部数据权限', '1', 'sys_data_scope', 0, '全部数据权限', 'admin', '2021-01-05 17:03:48', '', '2021-01-06 19:38:02', b'0');
INSERT INTO `sys_dict_data` VALUES (35, 2, '指定部门数据权限', '2', 'sys_data_scope', 0, '指定部门数据权限', 'admin', '2021-01-05 17:03:48', '', '2021-01-06 19:38:20', b'0');
INSERT INTO `sys_dict_data` VALUES (36, 3, '本部门数据权限', '3', 'sys_data_scope', 0, '本部门数据权限', 'admin', '2021-01-05 17:03:48', '', '2021-01-06 19:38:29', b'0');
INSERT INTO `sys_dict_data` VALUES (37, 4, '本部门及以下数据权限', '4', 'sys_data_scope', 0, '本部门及以下数据权限', 'admin', '2021-01-05 17:03:48', '', '2021-01-06 19:38:32', b'0');
INSERT INTO `sys_dict_data` VALUES (38, 5, '仅本人数据权限', '5', 'sys_data_scope', 0, '仅本人数据权限', 'admin', '2021-01-05 17:03:48', '', '2021-01-06 19:38:38', b'0');
INSERT INTO `sys_dict_data` VALUES (39, 0, '成功', '0', 'sys_login_result', 0, '登陆结果 - 成功', '', '2021-01-18 06:17:36', '', '2021-01-18 06:17:36', b'0');
INSERT INTO `sys_dict_data` VALUES (40, 10, '账号或密码不正确', '10', 'sys_login_result', 0, '登陆结果 - 账号或密码不正确', '', '2021-01-18 06:17:54', '', '2021-01-18 06:17:54', b'0');
INSERT INTO `sys_dict_data` VALUES (41, 20, '用户被禁用', '20', 'sys_login_result', 0, '登陆结果 - 用户被禁用', '', '2021-01-18 06:17:54', '', '2021-01-18 06:19:02', b'0');
INSERT INTO `sys_dict_data` VALUES (42, 30, '验证码不存在', '30', 'sys_login_result', 0, '登陆结果 - 验证码不存在', '', '2021-01-18 06:17:54', '', '2021-01-18 06:19:24', b'0');
INSERT INTO `sys_dict_data` VALUES (43, 31, '验证码不正确', '31', 'sys_login_result', 0, '登陆结果 - 验证码不正确', '', '2021-01-18 06:17:54', '', '2021-01-18 06:19:33', b'0');
INSERT INTO `sys_dict_data` VALUES (44, 100, '未知异常', '100', 'sys_login_result', 0, '登陆结果 - 未知异常', '', '2021-01-18 06:17:54', '', '2021-01-18 06:19:57', b'0');
INSERT INTO `sys_dict_data` VALUES (45, 1, '是', 'true', 'sys_boolean_string', 0, 'Boolean 是否类型 - 是', '', '2021-01-19 03:20:55', '', '2021-01-19 03:21:08', b'0');
INSERT INTO `sys_dict_data` VALUES (46, 1, '否', 'false', 'sys_boolean_string', 0, 'Boolean 是否类型 - 否', '', '2021-01-19 03:20:55', '', '2021-01-19 03:21:39', b'0');
INSERT INTO `sys_dict_data` VALUES (47, 1, '永不超时', '1', 'inf_redis_timeout_type', 0, 'Redis 未设置超时的情况', '', '2021-01-26 00:53:17', '', '2021-01-26 00:53:17', b'0');
INSERT INTO `sys_dict_data` VALUES (48, 1, '动态超时', '2', 'inf_redis_timeout_type', 0, '程序里动态传入超时时间，无法固定', '', '2021-01-26 00:55:00', '', '2021-01-26 00:55:00', b'0');
INSERT INTO `sys_dict_data` VALUES (49, 3, '固定超时', '3', 'inf_redis_timeout_type', 0, 'Redis 设置了过期时间', '', '2021-01-26 00:55:26', '', '2021-01-26 00:55:26', b'0');
INSERT INTO `sys_dict_data` VALUES (50, 1, '单表（增删改查）', '1', 'tool_codegen_template_type', 0, NULL, '', '2021-02-05 07:09:06', '', '2021-02-05 07:21:52', b'0');
INSERT INTO `sys_dict_data` VALUES (51, 2, '树表（增删改查）', '2', 'tool_codegen_template_type', 0, NULL, '', '2021-02-05 07:14:46', '', '2021-02-05 07:21:49', b'0');
INSERT INTO `sys_dict_data` VALUES (52, 3, '主子表（增删改查）', '3', 'tool_codegen_template_type', 0, NULL, '', '2021-02-05 07:21:45', '', '2021-02-06 18:54:26', b'1');
INSERT INTO `sys_dict_data` VALUES (53, 0, '初始化中', '0', 'inf_job_status', 0, NULL, '', '2021-02-07 07:46:49', '', '2021-02-07 07:46:49', b'0');
INSERT INTO `sys_dict_data` VALUES (54, 1, '开启', '1', 'inf_job_status', 0, NULL, '', '2021-02-07 07:46:57', '', '2021-02-07 11:54:09', b'0');
INSERT INTO `sys_dict_data` VALUES (56, 3, '暂停', '2', 'inf_job_status', 0, NULL, '', '2021-02-07 07:47:16', '', '2021-02-08 04:54:11', b'0');
INSERT INTO `sys_dict_data` VALUES (57, 0, '运行中', '0', 'inf_job_log_status', 0, 'RUNNING', '', '2021-02-08 10:04:24', '', '2021-02-08 10:04:24', b'0');
INSERT INTO `sys_dict_data` VALUES (58, 1, '成功', '1', 'inf_job_log_status', 0, NULL, '', '2021-02-08 10:06:57', '', '2021-02-08 10:06:57', b'0');
INSERT INTO `sys_dict_data` VALUES (59, 2, '失败', '2', 'inf_job_log_status', 0, '失败', '', '2021-02-08 10:07:38', '', '2021-02-08 10:07:38', b'0');
INSERT INTO `sys_dict_data` VALUES (60, 1, '会员', '1', 'user_type', 0, NULL, '', '2021-02-26 00:16:27', '', '2021-02-26 00:16:27', b'0');
INSERT INTO `sys_dict_data` VALUES (61, 2, '管理员', '2', 'user_type', 0, NULL, '', '2021-02-26 00:16:34', '', '2021-02-26 00:16:34', b'0');
INSERT INTO `sys_dict_data` VALUES (62, 0, '未处理', '0', 'inf_api_error_log_process_status', 0, NULL, '', '2021-02-26 07:07:19', '', '2021-02-26 08:11:23', b'0');
INSERT INTO `sys_dict_data` VALUES (63, 1, '已处理', '1', 'inf_api_error_log_process_status', 0, NULL, '', '2021-02-26 07:07:26', '', '2021-02-26 08:11:29', b'0');
INSERT INTO `sys_dict_data` VALUES (64, 2, '已忽略', '2', 'inf_api_error_log_process_status', 0, NULL, '', '2021-02-26 07:07:34', '', '2021-02-26 08:11:34', b'0');
INSERT INTO `sys_dict_data` VALUES (65, 1, '云片', 'YUN_PIAN', 'sys_sms_channel_code', 0, NULL, '1', '2021-04-05 01:05:14', '1', '2021-04-13 00:20:13', b'0');
INSERT INTO `sys_dict_data` VALUES (66, 2, '阿里云', 'ALIYUN', 'sys_sms_channel_code', 0, NULL, '1', '2021-04-05 01:05:26', '1', '2021-04-13 00:20:16', b'0');
INSERT INTO `sys_dict_data` VALUES (67, 1, '验证码', '1', 'sys_sms_template_type', 0, NULL, '1', '2021-04-05 21:50:57', '1', '2021-04-05 21:50:57', b'0');
INSERT INTO `sys_dict_data` VALUES (68, 2, '通知', '2', 'sys_sms_template_type', 0, NULL, '1', '2021-04-05 21:51:08', '1', '2021-04-05 21:51:08', b'0');
INSERT INTO `sys_dict_data` VALUES (69, 0, '营销', '3', 'sys_sms_template_type', 0, NULL, '1', '2021-04-05 21:51:15', '1', '2021-04-05 21:51:15', b'0');
INSERT INTO `sys_dict_data` VALUES (70, 0, '初始化', '0', 'sys_sms_send_status', 0, NULL, '1', '2021-04-11 20:18:33', '1', '2021-04-11 09:30:18', b'0');
INSERT INTO `sys_dict_data` VALUES (71, 1, '发送成功', '10', 'sys_sms_send_status', 0, NULL, '1', '2021-04-11 20:18:43', '1', '2021-04-11 09:30:20', b'0');
INSERT INTO `sys_dict_data` VALUES (72, 2, '发送失败', '20', 'sys_sms_send_status', 0, NULL, '1', '2021-04-11 20:18:49', '1', '2021-04-11 09:30:22', b'0');
INSERT INTO `sys_dict_data` VALUES (73, 3, '不发送', '30', 'sys_sms_send_status', 0, NULL, '1', '2021-04-11 20:19:44', '1', '2021-04-11 09:30:23', b'0');
INSERT INTO `sys_dict_data` VALUES (74, 0, '等待结果', '0', 'sys_sms_receive_status', 0, NULL, '1', '2021-04-11 20:27:43', '1', '2021-04-17 23:05:19', b'0');
INSERT INTO `sys_dict_data` VALUES (75, 1, '接收成功', '10', 'sys_sms_receive_status', 0, NULL, '1', '2021-04-11 20:29:25', '1', '2021-04-11 20:29:35', b'0');
INSERT INTO `sys_dict_data` VALUES (76, 2, '接收失败', '20', 'sys_sms_receive_status', 0, NULL, '1', '2021-04-11 20:29:31', '1', '2021-04-11 20:29:39', b'0');
INSERT INTO `sys_dict_data` VALUES (77, 0, '调试(钉钉)', 'DEBUG_DING_TALK', 'sys_sms_channel_code', 0, NULL, '1', '2021-04-13 00:20:37', '1', '2021-04-13 00:20:37', b'0');
INSERT INTO `sys_dict_data` VALUES (78, 1, '自动生成', '1', 'sys_error_code_type', 0, NULL, '1', '2021-04-21 00:06:48', '1', '2021-04-13 22:06:44', b'0');
INSERT INTO `sys_dict_data` VALUES (79, 2, '手动编辑', '2', 'sys_error_code_type', 0, NULL, '1', '2021-04-21 00:07:14', '1', '2021-04-13 22:06:49', b'0');
INSERT INTO `sys_dict_data` VALUES (80, 100, '账号登录', '100', 'sys_login_type', 0, '账号登录', '1', '2021-10-06 00:52:02', '1', '2021-10-06 00:52:43', b'0');
INSERT INTO `sys_dict_data` VALUES (81, 101, '社交登录', '101', 'sys_login_type', 0, '社交登录', '1', '2021-10-06 00:52:17', '1', '2021-10-06 00:52:17', b'0');
INSERT INTO `sys_dict_data` VALUES (82, 102, 'Mock 登录', '102', 'sys_login_type', 0, 'Mock 登录', '1', '2021-10-06 00:52:32', '1', '2021-10-06 00:52:39', b'0');
INSERT INTO `sys_dict_data` VALUES (83, 200, '主动登出', '200', 'sys_login_type', 0, '主动登出', '1', '2021-10-06 00:52:58', '1', '2021-10-06 00:52:58', b'0');
INSERT INTO `sys_dict_data` VALUES (84, 201, '超时登出', '201', 'sys_login_type', 0, '超时登出', '1', '2021-10-06 00:53:17', '1', '2021-10-06 00:53:17', b'0');
INSERT INTO `sys_dict_data` VALUES (85, 202, '强制登出', '202', 'sys_login_type', 0, '强制退出', '1', '2021-10-06 00:53:41', '1', '2021-10-06 00:53:41', b'0');
INSERT INTO `sys_dict_data` VALUES (86, 0, '病假', '1', 'oa_leave_type', 0, NULL, '1', '2021-09-21 22:35:28', '1', '2021-09-21 14:59:27', b'0');
INSERT INTO `sys_dict_data` VALUES (87, 1, '事假', '2', 'oa_leave_type', 0, NULL, '1', '2021-09-21 22:36:11', '1', '2021-09-21 14:59:27', b'0');
INSERT INTO `sys_dict_data` VALUES (88, 2, '婚假', '3', 'oa_leave_type', 0, NULL, '1', '2021-09-21 22:36:38', '1', '2021-09-21 14:59:27', b'0');
INSERT INTO `sys_dict_data` VALUES (89, 0, '处理中', '1', 'oa_leave_status', 0, NULL, '1', '2021-09-21 22:46:46', '1', '2021-10-12 22:12:20', b'0');
INSERT INTO `sys_dict_data` VALUES (90, 1, '流程结束', '2', 'oa_leave_status', 0, NULL, '1', '2021-09-21 22:47:03', '1', '2021-10-12 22:12:58', b'0');
INSERT INTO `sys_dict_data` VALUES (91, 2, '完成', '3', 'oa_leave_status', 0, NULL, '1', '2021-09-21 22:47:25', '1', '2021-10-12 14:13:06', b'1');

-- ----------------------------
-- Table structure for sys_dict_type
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_type`;
CREATE TABLE `sys_dict_type`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '字典主键',
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '字典名称',
  `type` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '字典类型',
  `status` tinyint(0) NOT NULL DEFAULT 0 COMMENT '状态（0正常 1停用）',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `dict_type`(`type`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 119 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '字典类型表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_dict_type
-- ----------------------------
INSERT INTO `sys_dict_type` VALUES (1, '用户性别', 'sys_user_sex', 0, NULL, 'admin', '2021-01-05 17:03:48', '', '2021-01-05 17:03:48', b'0');
INSERT INTO `sys_dict_type` VALUES (3, '系统开关', 'sys_normal_disable', 0, NULL, 'admin', '2021-01-05 17:03:48', '', '2021-01-07 19:47:48', b'1');
INSERT INTO `sys_dict_type` VALUES (4, '任务状态的枚举', 'sys_job_status', 0, NULL, 'admin', '2021-01-05 17:03:48', '', '2021-02-07 07:44:06', b'1');
INSERT INTO `sys_dict_type` VALUES (5, '任务分组', 'sys_job_group', 0, NULL, 'admin', '2021-01-05 17:03:48', '', '2021-02-07 07:43:52', b'1');
INSERT INTO `sys_dict_type` VALUES (6, '参数类型', 'sys_config_type', 0, NULL, 'admin', '2021-01-05 17:03:48', '', '2021-01-18 07:41:04', b'0');
INSERT INTO `sys_dict_type` VALUES (7, '通知类型', 'sys_notice_type', 0, NULL, 'admin', '2021-01-05 17:03:48', '', '2021-01-05 17:03:48', b'0');
INSERT INTO `sys_dict_type` VALUES (8, '通知状态', 'sys_notice_status', 0, NULL, 'admin', '2021-01-05 17:03:48', '', '2021-01-05 17:03:48', b'0');
INSERT INTO `sys_dict_type` VALUES (9, '操作类型', 'sys_oper_type', 0, NULL, 'admin', '2021-01-05 17:03:48', '', '2021-01-05 17:03:48', b'0');
INSERT INTO `sys_dict_type` VALUES (10, '系统状态', 'sys_common_status', 0, NULL, 'admin', '2021-01-05 17:03:48', '', '2021-01-05 17:03:48', b'0');
INSERT INTO `sys_dict_type` VALUES (11, 'Boolean 是否类型', 'sys_boolean_string', 0, 'boolean 转是否', '', '2021-01-19 03:20:08', '', '2021-01-19 03:20:08', b'0');
INSERT INTO `sys_dict_type` VALUES (104, '登陆结果', 'sys_login_result', 0, '登陆结果', '', '2021-01-18 06:17:11', '', '2021-01-18 06:17:11', b'0');
INSERT INTO `sys_dict_type` VALUES (105, 'Redis 超时类型', 'inf_redis_timeout_type', 0, 'RedisKeyDefine.TimeoutTypeEnum', '', '2021-01-26 00:52:50', '', '2021-01-26 00:52:50', b'0');
INSERT INTO `sys_dict_type` VALUES (106, '代码生成模板类型', 'tool_codegen_template_type', 0, NULL, '', '2021-02-05 07:08:06', '', '2021-02-05 07:08:06', b'0');
INSERT INTO `sys_dict_type` VALUES (107, '定时任务状态', 'inf_job_status', 0, NULL, '', '2021-02-07 07:44:16', '', '2021-02-07 07:44:16', b'0');
INSERT INTO `sys_dict_type` VALUES (108, '定时任务日志状态', 'inf_job_log_status', 0, NULL, '', '2021-02-08 10:03:51', '', '2021-02-08 10:03:51', b'0');
INSERT INTO `sys_dict_type` VALUES (109, '用户类型', 'user_type', 0, NULL, '', '2021-02-26 00:15:51', '', '2021-02-26 00:15:51', b'0');
INSERT INTO `sys_dict_type` VALUES (110, 'API 异常数据的处理状态', 'inf_api_error_log_process_status', 0, NULL, '', '2021-02-26 07:07:01', '', '2021-02-26 07:07:01', b'0');
INSERT INTO `sys_dict_type` VALUES (111, '短信渠道编码', 'sys_sms_channel_code', 0, NULL, '1', '2021-04-05 01:04:50', '1', '2021-04-05 01:04:50', b'0');
INSERT INTO `sys_dict_type` VALUES (112, '短信模板的类型', 'sys_sms_template_type', 0, NULL, '1', '2021-04-05 21:50:43', '1', '2021-04-05 21:50:43', b'0');
INSERT INTO `sys_dict_type` VALUES (113, '短信发送状态', 'sys_sms_send_status', 0, NULL, '1', '2021-04-11 20:18:03', '1', '2021-04-11 09:30:02', b'0');
INSERT INTO `sys_dict_type` VALUES (114, '短信接收状态', 'sys_sms_receive_status', 0, NULL, '1', '2021-04-11 20:27:14', '1', '2021-04-11 20:27:14', b'0');
INSERT INTO `sys_dict_type` VALUES (115, '错误码的类型', 'sys_error_code_type', 0, NULL, '1', '2021-04-21 00:06:30', '1', '2021-04-13 22:07:12', b'0');
INSERT INTO `sys_dict_type` VALUES (116, '登陆日志的类型', 'sys_login_type', 0, '登陆日志的类型', '1', '2021-10-06 00:50:46', '1', '2021-10-06 00:50:46', b'0');
INSERT INTO `sys_dict_type` VALUES (117, '请假类型', 'oa_leave_type', 0, NULL, '1', '2021-09-21 22:34:33', '1', '2021-09-21 15:00:38', b'0');
INSERT INTO `sys_dict_type` VALUES (118, '请假流程状态', 'oa_leave_status', 0, NULL, '1', '2021-09-21 22:46:04', '1', '2021-09-21 15:00:38', b'0');

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `menu_id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `menu_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '名称',
  `parent_id` bigint(0) NULL DEFAULT 0 COMMENT '父ID',
  `path` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '路径',
  `component` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '组件',
  `menu_type` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '类型：M目录、C菜单、F按钮',
  `permission` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '权限',
  `icon` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '#' COMMENT '图标',
  `menu_sort` int(0) NULL DEFAULT NULL COMMENT '排序',
  `deleted` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '删除：1存在、0删除',
  `enabled` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '状态：1正常、0停用',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '创建者',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '更新者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`menu_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1066 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '菜单权限表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES (1, '权限管理', 0, '/infra', '', '1', NULL, 'system', 2, NULL, '1', '', '', NULL, NULL);
INSERT INTO `sys_menu` VALUES (2, '系统监控', 0, '/tool', '', '1', NULL, 'monitor', 3, NULL, '1', '', '', NULL, NULL);
INSERT INTO `sys_menu` VALUES (100, '用户管理', 1, 'user', 'system/user/index', '2', 'system:user:list', 'user', NULL, NULL, '1', '', '', NULL, NULL);
INSERT INTO `sys_menu` VALUES (101, '角色管理', 1, 'role', 'system/role/index', '2', '', 'peoples', NULL, NULL, '1', '', '', NULL, NULL);
INSERT INTO `sys_menu` VALUES (102, '菜单管理', 1, 'menu', 'system/menu/index', '2', '', 'tree-table', 2, '0', '1', '0', 'admin', '2021-01-05 17:03:48', '2021-03-14 22:21:47');
INSERT INTO `sys_menu` VALUES (103, '部门管理', 1, 'dept', 'system/dept/index', '2', '', 'tree', 2, '0', '1', '0', 'admin', '2021-01-05 17:03:48', '2021-03-14 22:21:47');
INSERT INTO `sys_menu` VALUES (104, '岗位管理', 1, 'post', 'system/post/index', '2', '', 'post', NULL, NULL, '1', '', '', NULL, NULL);
INSERT INTO `sys_menu` VALUES (105, '字典管理', 1, 'dict', 'system/dict/index', '2', '', 'dict', NULL, NULL, '1', '', '', NULL, NULL);
INSERT INTO `sys_menu` VALUES (106, '配置管理', 2, 'config', 'infra/config/index', '2', '', 'edit', NULL, NULL, '1', '', '', NULL, NULL);
INSERT INTO `sys_menu` VALUES (107, '通知公告', 1, 'notice', 'system/notice/index', '2', '', 'message', NULL, NULL, '1', '', '', NULL, NULL);
INSERT INTO `sys_menu` VALUES (108, '审计日志', 1, 'log', '', '2', '', 'log', NULL, NULL, '1', '', '', NULL, NULL);
INSERT INTO `sys_menu` VALUES (109, '在线用户', 1, 'user-session', 'system/session/index', '2', 'system:user-session:list', 'online', NULL, NULL, '1', '', '', NULL, NULL);
INSERT INTO `sys_menu` VALUES (110, '定时任务', 2, 'job', 'infra/job/index', '2', '', 'job', NULL, NULL, '1', '', '', NULL, NULL);
INSERT INTO `sys_menu` VALUES (114, '表单构建', 3, 'build', 'tool/build/index', '2', 'tool:build:list', 'build', NULL, NULL, '1', '', '', NULL, NULL);
INSERT INTO `sys_menu` VALUES (115, '代码生成', 3, 'codegen', 'tool/codegen/index', '2', 'tool:codegen:query', 'code', NULL, NULL, '1', '', '', NULL, NULL);
INSERT INTO `sys_menu` VALUES (116, '系统接口', 3, 'swagger', 'tool/swagger/index', '2', 'tool:swagger:list', 'swagger', NULL, NULL, '1', '', '', NULL, NULL);
INSERT INTO `sys_menu` VALUES (500, '操作日志', 108, 'operate-log', 'system/operatelog/index', '2', '', 'form', NULL, NULL, '1', '', '', NULL, NULL);
INSERT INTO `sys_menu` VALUES (501, '登录日志', 108, 'login-log', 'system/loginlog/index', '2', '', 'logininfor', NULL, NULL, '1', '', '', NULL, NULL);
INSERT INTO `sys_menu` VALUES (1001, '用户查询', 100, '', '', '3', 'system:user:query', '#', NULL, NULL, '1', '', '', NULL, NULL);
INSERT INTO `sys_menu` VALUES (1002, '用户新增', 100, '', '', '3', 'system:user:create', '', NULL, NULL, '1', '', '', NULL, NULL);
INSERT INTO `sys_menu` VALUES (1003, '用户修改', 100, '', '', '3', 'system:user:update', '', NULL, NULL, '1', '', '', NULL, NULL);
INSERT INTO `sys_menu` VALUES (1004, '用户删除', 100, '', '', '3', 'system:user:delete', '', NULL, NULL, '1', '', '', NULL, NULL);
INSERT INTO `sys_menu` VALUES (1005, '用户导出', 100, '', '', '3', 'system:user:export', '#', NULL, NULL, '1', '', '', NULL, NULL);
INSERT INTO `sys_menu` VALUES (1006, '用户导入', 100, '', '', '3', 'system:user:import', '#', NULL, NULL, '1', '', '', NULL, NULL);
INSERT INTO `sys_menu` VALUES (1007, '重置密码', 100, '', '', '3', 'system:user:update-password', '', NULL, NULL, '1', '', '', NULL, NULL);
INSERT INTO `sys_menu` VALUES (1008, '角色查询', 101, '', '', '3', 'system:role:query', '#', NULL, NULL, '1', '', '', NULL, NULL);
INSERT INTO `sys_menu` VALUES (1009, '角色新增', 101, '', '', '3', 'system:role:create', '', NULL, NULL, '1', '', '', NULL, NULL);
INSERT INTO `sys_menu` VALUES (1010, '角色修改', 101, '', '', '3', 'system:role:update', '', NULL, NULL, '1', '', '', NULL, NULL);
INSERT INTO `sys_menu` VALUES (1011, '角色删除', 101, '', '', '3', 'system:role:delete', '', NULL, NULL, '1', '', '', NULL, NULL);
INSERT INTO `sys_menu` VALUES (1012, '角色导出', 101, '', '', '3', 'system:role:export', '#', NULL, NULL, '1', '', '', NULL, NULL);
INSERT INTO `sys_menu` VALUES (1013, '菜单查询', 102, '', '', '3', 'system:menu:query', '#', NULL, NULL, '1', '', '', NULL, NULL);
INSERT INTO `sys_menu` VALUES (1014, '菜单新增', 102, '', '', '3', 'system:menu:create', '#', NULL, NULL, '1', '', '', NULL, NULL);
INSERT INTO `sys_menu` VALUES (1015, '菜单修改', 102, '', '', '3', 'system:menu:update', '#', NULL, NULL, '1', '', '', NULL, NULL);
INSERT INTO `sys_menu` VALUES (1016, '菜单删除', 102, '', '', '3', 'system:menu:delete', '#', NULL, NULL, '1', '', '', NULL, NULL);
INSERT INTO `sys_menu` VALUES (1017, '部门查询', 103, '', '', '3', 'system:dept:query', '#', NULL, NULL, '1', '', '', NULL, NULL);
INSERT INTO `sys_menu` VALUES (1018, '部门新增', 103, '', '', '3', 'system:dept:create', '', NULL, NULL, '1', '', '', NULL, NULL);
INSERT INTO `sys_menu` VALUES (1019, '部门修改', 103, '', '', '3', 'system:dept:update', '', NULL, NULL, '1', '', '', NULL, NULL);
INSERT INTO `sys_menu` VALUES (1020, '部门删除', 103, '', '', '3', 'system:dept:delete', '', NULL, NULL, '1', '', '', NULL, NULL);
INSERT INTO `sys_menu` VALUES (1021, '岗位查询', 104, '', '', '3', 'system:post:query', '#', NULL, NULL, '1', '', '', NULL, NULL);
INSERT INTO `sys_menu` VALUES (1022, '岗位新增', 104, '', '', '3', 'system:post:create', '', NULL, NULL, '1', '', '', NULL, NULL);
INSERT INTO `sys_menu` VALUES (1023, '岗位修改', 104, '', '', '3', 'system:post:update', '', NULL, NULL, '1', '', '', NULL, NULL);
INSERT INTO `sys_menu` VALUES (1024, '岗位删除', 104, '', '', '3', 'system:post:delete', '', NULL, NULL, '1', '', '', NULL, NULL);
INSERT INTO `sys_menu` VALUES (1025, '岗位导出', 104, '', '', '3', 'system:post:export', '#', NULL, NULL, '1', '', '', NULL, NULL);
INSERT INTO `sys_menu` VALUES (1026, '字典查询', 105, '#', '', '3', 'system:dict:query', '#', NULL, NULL, '1', '', '', NULL, NULL);
INSERT INTO `sys_menu` VALUES (1027, '字典新增', 105, '', '', '3', 'system:dict:create', '', NULL, NULL, '1', '', '', NULL, NULL);
INSERT INTO `sys_menu` VALUES (1028, '字典修改', 105, '', '', '3', 'system:dict:update', '', NULL, NULL, '1', '', '', NULL, NULL);
INSERT INTO `sys_menu` VALUES (1029, '字典删除', 105, '', '', '3', 'system:dict:delete', '', NULL, NULL, '1', '', '', NULL, NULL);
INSERT INTO `sys_menu` VALUES (1030, '字典导出', 105, '#', '', '3', 'system:dict:export', '#', NULL, NULL, '1', '', '', NULL, NULL);
INSERT INTO `sys_menu` VALUES (1031, '配置查询', 106, '', '', '3', 'infra:config:query', '', NULL, NULL, '1', '', '', NULL, NULL);
INSERT INTO `sys_menu` VALUES (1032, '配置新增', 106, '', '', '3', 'infra:config:create', '', NULL, NULL, '1', '', '', NULL, NULL);
INSERT INTO `sys_menu` VALUES (1033, '配置修改', 106, '', '', '3', 'infra:config:update', '', NULL, NULL, '1', '', '', NULL, NULL);
INSERT INTO `sys_menu` VALUES (1034, '配置删除', 106, '', '', '3', 'infra:config:delete', '', NULL, NULL, '1', '', '', NULL, NULL);
INSERT INTO `sys_menu` VALUES (1035, '配置导出', 106, '', '', '3', 'infra:config:export', '', NULL, NULL, '1', '', '', NULL, NULL);
INSERT INTO `sys_menu` VALUES (1036, '公告查询', 107, '#', '', '3', 'system:notice:query', '#', 2, '0', '1', '0', 'admin', '2021-01-05 17:03:48', '2021-03-14 22:21:47');
INSERT INTO `sys_menu` VALUES (1037, '公告新增', 107, '', '', '3', 'system:notice:create', '', NULL, NULL, '1', '', '', NULL, NULL);
INSERT INTO `sys_menu` VALUES (1038, '公告修改', 107, '', '', '3', 'system:notice:update', '', NULL, NULL, '1', '', '', NULL, NULL);
INSERT INTO `sys_menu` VALUES (1039, '公告删除', 107, '', '', '3', 'system:notice:delete', '', NULL, NULL, '1', '', '', NULL, NULL);
INSERT INTO `sys_menu` VALUES (1040, '操作查询', 500, '', '', '3', 'system:operate-log:query', '', NULL, NULL, '1', '', '', NULL, NULL);
INSERT INTO `sys_menu` VALUES (1042, '日志导出', 500, '', '', '3', 'system:operate-log:export', '', NULL, NULL, '1', '', '', NULL, NULL);
INSERT INTO `sys_menu` VALUES (1043, '登录查询', 501, '#', '', '3', 'system:login-log:query', '#', NULL, NULL, '1', '', '', NULL, NULL);
INSERT INTO `sys_menu` VALUES (1045, '日志导出', 501, '#', '', '3', 'system:login-log:export', '#', NULL, NULL, '1', '', '', NULL, NULL);
INSERT INTO `sys_menu` VALUES (1046, '在线查询', 109, '', '', '3', 'system:user-session:list', '', NULL, NULL, '1', '', '', NULL, NULL);
INSERT INTO `sys_menu` VALUES (1047, '批量强退', 109, '#', '', '3', 'monitor:online:batchLogout', '#', NULL, NULL, '1', '', '', NULL, NULL);
INSERT INTO `sys_menu` VALUES (1048, '单条强退', 109, '', '', '3', 'system:user-session:delete', '', NULL, NULL, '1', '', '', NULL, NULL);
INSERT INTO `sys_menu` VALUES (1049, '任务查询', 110, '#', '', '3', 'monitor:job:query', '#', NULL, NULL, '1', '', '', NULL, NULL);
INSERT INTO `sys_menu` VALUES (1050, '任务新增', 110, '', '', '3', 'infra:job:create', '', NULL, NULL, '1', '', '', NULL, NULL);
INSERT INTO `sys_menu` VALUES (1051, '任务修改', 110, '', '', '3', 'infra:job:update', '', NULL, NULL, '1', '', '', NULL, NULL);
INSERT INTO `sys_menu` VALUES (1052, '任务删除', 110, '', '', '3', 'infra:job:delete', '', NULL, NULL, '1', '', '', NULL, NULL);
INSERT INTO `sys_menu` VALUES (1053, '状态修改', 110, '', '', '3', 'infra:job:update', '', NULL, NULL, '1', '', '', NULL, NULL);
INSERT INTO `sys_menu` VALUES (1054, '任务导出', 110, '', '', '3', 'infra:job:export', '', NULL, NULL, '1', '', '', NULL, NULL);
INSERT INTO `sys_menu` VALUES (1055, '生成查询', 115, '#', '', '3', 'tool:gen:query', '#', NULL, NULL, '1', '', '', NULL, NULL);
INSERT INTO `sys_menu` VALUES (1056, '生成修改', 115, '', '', '3', 'tool:codegen:update', '', NULL, NULL, '1', '', '', NULL, NULL);
INSERT INTO `sys_menu` VALUES (1057, '生成删除', 115, '', '', '3', 'tool:codegen:delete', '', NULL, NULL, '1', '', '', NULL, NULL);
INSERT INTO `sys_menu` VALUES (1058, '导入代码', 115, '', '', '3', 'tool:codegen:create', '', NULL, NULL, '1', '', '', NULL, NULL);
INSERT INTO `sys_menu` VALUES (1059, '预览代码', 115, '', '', '3', 'tool:codegen:preview', '', NULL, NULL, '1', '', '', NULL, NULL);
INSERT INTO `sys_menu` VALUES (1060, '生成代码', 115, '', '', '3', 'tool:codegen:download', '', NULL, NULL, '1', '', '', NULL, NULL);
INSERT INTO `sys_menu` VALUES (1063, '设置角色菜单权限', 101, '', '', '3', 'system:permission:assign-role-menu', '', NULL, NULL, '1', '', '', NULL, NULL);
INSERT INTO `sys_menu` VALUES (1064, '设置角色数据权限', 101, '', '', '3', 'system:permission:assign-role-data-scope', '', NULL, NULL, '1', '', '', NULL, NULL);
INSERT INTO `sys_menu` VALUES (1065, '设置用户角色', 101, '', '', '3', 'system:permission:assign-user-role', '', NULL, NULL, '1', '', '', NULL, NULL);

-- ----------------------------
-- Table structure for sys_post
-- ----------------------------
DROP TABLE IF EXISTS `sys_post`;
CREATE TABLE `sys_post`  (
  `post_id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '岗位ID',
  `post_code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '岗位编码',
  `post_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '岗位名称',
  `post_sort` int(0) NOT NULL COMMENT '显示顺序',
  `deleted` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '删除标志：1存在、0删除',
  `enabled` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '状态（1正常 0停用）',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`post_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '岗位信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_post
-- ----------------------------
INSERT INTO `sys_post` VALUES (1, '1', '1', 1, NULL, '1', '', NULL, '', NULL);

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `role_id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `role_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '名称',
  `role_key` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '标识',
  `level` int(0) NULL DEFAULT NULL COMMENT '级别',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `data_scope` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '数据范围：1全部数据权限、2自定数据权限、3本部门数据权限、4本部门及以下数据权限',
  `role_sort` int(0) NOT NULL COMMENT '排序',
  `deleted` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '删除：1存在、0删除',
  `enabled` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '状态：1正常、0停用',
  `create_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建者',
  `update_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建日期',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`role_id`) USING BTREE,
  UNIQUE INDEX `uniq_name`(`role_name`) USING BTREE,
  INDEX `role_name_index`(`role_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, '超级管理员', 'admin', 1, '1', '1', 1, '1', '1', '1', '1', '2021-12-21 16:26:05', '2021-12-21 16:26:07');

-- ----------------------------
-- Table structure for sys_role_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_dept`;
CREATE TABLE `sys_role_dept`  (
  `role_id` bigint(0) NOT NULL COMMENT '角色ID',
  `dept_id` bigint(0) NOT NULL COMMENT '部门ID',
  PRIMARY KEY (`role_id`, `dept_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '角色和部门关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_dept
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu`  (
  `role_id` bigint(0) NULL DEFAULT NULL COMMENT '角色ID',
  `menu_id` bigint(0) NULL DEFAULT NULL COMMENT '菜单ID',
  INDEX `FKcngg2qadojhi3a651a5adkvbq`(`role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色菜单关联' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES (1, 1);
INSERT INTO `sys_role_menu` VALUES (1, 2);
INSERT INTO `sys_role_menu` VALUES (1, 3);
INSERT INTO `sys_role_menu` VALUES (1, 4);
INSERT INTO `sys_role_menu` VALUES (1, 100);
INSERT INTO `sys_role_menu` VALUES (1, 101);
INSERT INTO `sys_role_menu` VALUES (1, 102);
INSERT INTO `sys_role_menu` VALUES (1, 103);
INSERT INTO `sys_role_menu` VALUES (1, 104);
INSERT INTO `sys_role_menu` VALUES (1, 105);
INSERT INTO `sys_role_menu` VALUES (1, 106);
INSERT INTO `sys_role_menu` VALUES (1, 107);
INSERT INTO `sys_role_menu` VALUES (1, 108);
INSERT INTO `sys_role_menu` VALUES (1, 109);
INSERT INTO `sys_role_menu` VALUES (1, 110);
INSERT INTO `sys_role_menu` VALUES (1, 111);
INSERT INTO `sys_role_menu` VALUES (1, 112);
INSERT INTO `sys_role_menu` VALUES (1, 113);
INSERT INTO `sys_role_menu` VALUES (1, 114);
INSERT INTO `sys_role_menu` VALUES (1, 115);
INSERT INTO `sys_role_menu` VALUES (1, 116);
INSERT INTO `sys_role_menu` VALUES (1, 500);
INSERT INTO `sys_role_menu` VALUES (1, 501);
INSERT INTO `sys_role_menu` VALUES (1, 1000);
INSERT INTO `sys_role_menu` VALUES (1, 1001);
INSERT INTO `sys_role_menu` VALUES (1, 1002);
INSERT INTO `sys_role_menu` VALUES (1, 1003);
INSERT INTO `sys_role_menu` VALUES (1, 1004);
INSERT INTO `sys_role_menu` VALUES (1, 1005);
INSERT INTO `sys_role_menu` VALUES (1, 1006);
INSERT INTO `sys_role_menu` VALUES (1, 1007);
INSERT INTO `sys_role_menu` VALUES (1, 1008);
INSERT INTO `sys_role_menu` VALUES (1, 1009);
INSERT INTO `sys_role_menu` VALUES (1, 1010);
INSERT INTO `sys_role_menu` VALUES (1, 1011);
INSERT INTO `sys_role_menu` VALUES (1, 1012);
INSERT INTO `sys_role_menu` VALUES (1, 1013);
INSERT INTO `sys_role_menu` VALUES (1, 1014);
INSERT INTO `sys_role_menu` VALUES (1, 1015);
INSERT INTO `sys_role_menu` VALUES (1, 1016);
INSERT INTO `sys_role_menu` VALUES (1, 1017);
INSERT INTO `sys_role_menu` VALUES (1, 1018);
INSERT INTO `sys_role_menu` VALUES (1, 1019);
INSERT INTO `sys_role_menu` VALUES (1, 1020);
INSERT INTO `sys_role_menu` VALUES (1, 1021);
INSERT INTO `sys_role_menu` VALUES (1, 1022);
INSERT INTO `sys_role_menu` VALUES (1, 1023);
INSERT INTO `sys_role_menu` VALUES (1, 1024);
INSERT INTO `sys_role_menu` VALUES (1, 1025);
INSERT INTO `sys_role_menu` VALUES (1, 1026);
INSERT INTO `sys_role_menu` VALUES (1, 1027);
INSERT INTO `sys_role_menu` VALUES (1, 1028);
INSERT INTO `sys_role_menu` VALUES (1, 1029);
INSERT INTO `sys_role_menu` VALUES (1, 1030);
INSERT INTO `sys_role_menu` VALUES (1, 1031);
INSERT INTO `sys_role_menu` VALUES (1, 1032);
INSERT INTO `sys_role_menu` VALUES (1, 1033);
INSERT INTO `sys_role_menu` VALUES (1, 1034);
INSERT INTO `sys_role_menu` VALUES (1, 1035);
INSERT INTO `sys_role_menu` VALUES (1, 1036);
INSERT INTO `sys_role_menu` VALUES (1, 1037);
INSERT INTO `sys_role_menu` VALUES (1, 1038);
INSERT INTO `sys_role_menu` VALUES (1, 1039);
INSERT INTO `sys_role_menu` VALUES (1, 1040);
INSERT INTO `sys_role_menu` VALUES (1, 111);
INSERT INTO `sys_role_menu` VALUES (1, 112);
INSERT INTO `sys_role_menu` VALUES (1, 113);
INSERT INTO `sys_role_menu` VALUES (1, 114);
INSERT INTO `sys_role_menu` VALUES (1, 116);
INSERT INTO `sys_role_menu` VALUES (1, 120);
INSERT INTO `sys_role_menu` VALUES (1, 201);
INSERT INTO `sys_role_menu` VALUES (1, 202);
INSERT INTO `sys_role_menu` VALUES (1, 203);
INSERT INTO `sys_role_menu` VALUES (1, 204);
INSERT INTO `sys_role_menu` VALUES (1, NULL);
INSERT INTO `sys_role_menu` VALUES (1, NULL);
INSERT INTO `sys_role_menu` VALUES (1, NULL);
INSERT INTO `sys_role_menu` VALUES (1, NULL);
INSERT INTO `sys_role_menu` VALUES (1, NULL);
INSERT INTO `sys_role_menu` VALUES (1, NULL);
INSERT INTO `sys_role_menu` VALUES (1, NULL);
INSERT INTO `sys_role_menu` VALUES (1, NULL);
INSERT INTO `sys_role_menu` VALUES (1, NULL);
INSERT INTO `sys_role_menu` VALUES (1, NULL);
INSERT INTO `sys_role_menu` VALUES (1, NULL);
INSERT INTO `sys_role_menu` VALUES (1, NULL);
INSERT INTO `sys_role_menu` VALUES (1, NULL);
INSERT INTO `sys_role_menu` VALUES (1, NULL);
INSERT INTO `sys_role_menu` VALUES (1, NULL);
INSERT INTO `sys_role_menu` VALUES (1, NULL);
INSERT INTO `sys_role_menu` VALUES (1, NULL);
INSERT INTO `sys_role_menu` VALUES (1, NULL);
INSERT INTO `sys_role_menu` VALUES (1, NULL);
INSERT INTO `sys_role_menu` VALUES (1, NULL);
INSERT INTO `sys_role_menu` VALUES (1, NULL);
INSERT INTO `sys_role_menu` VALUES (1, NULL);
INSERT INTO `sys_role_menu` VALUES (1, NULL);
INSERT INTO `sys_role_menu` VALUES (1, NULL);
INSERT INTO `sys_role_menu` VALUES (1, NULL);
INSERT INTO `sys_role_menu` VALUES (1, NULL);
INSERT INTO `sys_role_menu` VALUES (1, NULL);
INSERT INTO `sys_role_menu` VALUES (1, NULL);
INSERT INTO `sys_role_menu` VALUES (1, NULL);
INSERT INTO `sys_role_menu` VALUES (1, NULL);
INSERT INTO `sys_role_menu` VALUES (1, NULL);
INSERT INTO `sys_role_menu` VALUES (1, NULL);
INSERT INTO `sys_role_menu` VALUES (1, NULL);
INSERT INTO `sys_role_menu` VALUES (1, NULL);
INSERT INTO `sys_role_menu` VALUES (1, NULL);
INSERT INTO `sys_role_menu` VALUES (1, NULL);
INSERT INTO `sys_role_menu` VALUES (1, NULL);
INSERT INTO `sys_role_menu` VALUES (1, NULL);
INSERT INTO `sys_role_menu` VALUES (1, NULL);
INSERT INTO `sys_role_menu` VALUES (1, NULL);
INSERT INTO `sys_role_menu` VALUES (1, NULL);
INSERT INTO `sys_role_menu` VALUES (1, NULL);
INSERT INTO `sys_role_menu` VALUES (1, NULL);
INSERT INTO `sys_role_menu` VALUES (1, NULL);
INSERT INTO `sys_role_menu` VALUES (1, NULL);
INSERT INTO `sys_role_menu` VALUES (1, NULL);
INSERT INTO `sys_role_menu` VALUES (1, NULL);
INSERT INTO `sys_role_menu` VALUES (1, NULL);
INSERT INTO `sys_role_menu` VALUES (1, NULL);
INSERT INTO `sys_role_menu` VALUES (1, NULL);
INSERT INTO `sys_role_menu` VALUES (1, NULL);
INSERT INTO `sys_role_menu` VALUES (1, NULL);
INSERT INTO `sys_role_menu` VALUES (1, NULL);
INSERT INTO `sys_role_menu` VALUES (1, NULL);
INSERT INTO `sys_role_menu` VALUES (1, NULL);
INSERT INTO `sys_role_menu` VALUES (1, NULL);
INSERT INTO `sys_role_menu` VALUES (1, NULL);
INSERT INTO `sys_role_menu` VALUES (1, NULL);
INSERT INTO `sys_role_menu` VALUES (1, NULL);
INSERT INTO `sys_role_menu` VALUES (1, NULL);
INSERT INTO `sys_role_menu` VALUES (1, NULL);
INSERT INTO `sys_role_menu` VALUES (1, NULL);
INSERT INTO `sys_role_menu` VALUES (1, NULL);
INSERT INTO `sys_role_menu` VALUES (1, NULL);
INSERT INTO `sys_role_menu` VALUES (1, NULL);
INSERT INTO `sys_role_menu` VALUES (1, NULL);
INSERT INTO `sys_role_menu` VALUES (1, NULL);
INSERT INTO `sys_role_menu` VALUES (1, NULL);
INSERT INTO `sys_role_menu` VALUES (1, NULL);
INSERT INTO `sys_role_menu` VALUES (1, NULL);
INSERT INTO `sys_role_menu` VALUES (1, NULL);
INSERT INTO `sys_role_menu` VALUES (1, NULL);
INSERT INTO `sys_role_menu` VALUES (1, NULL);
INSERT INTO `sys_role_menu` VALUES (1, NULL);
INSERT INTO `sys_role_menu` VALUES (1, NULL);
INSERT INTO `sys_role_menu` VALUES (1, NULL);
INSERT INTO `sys_role_menu` VALUES (1, NULL);
INSERT INTO `sys_role_menu` VALUES (1, NULL);
INSERT INTO `sys_role_menu` VALUES (1, NULL);
INSERT INTO `sys_role_menu` VALUES (1, NULL);
INSERT INTO `sys_role_menu` VALUES (1, NULL);
INSERT INTO `sys_role_menu` VALUES (1, NULL);
INSERT INTO `sys_role_menu` VALUES (1, NULL);
INSERT INTO `sys_role_menu` VALUES (1, NULL);
INSERT INTO `sys_role_menu` VALUES (1, NULL);
INSERT INTO `sys_role_menu` VALUES (1, NULL);
INSERT INTO `sys_role_menu` VALUES (1, NULL);
INSERT INTO `sys_role_menu` VALUES (1, NULL);
INSERT INTO `sys_role_menu` VALUES (1, NULL);
INSERT INTO `sys_role_menu` VALUES (1, NULL);
INSERT INTO `sys_role_menu` VALUES (1, NULL);
INSERT INTO `sys_role_menu` VALUES (1, NULL);
INSERT INTO `sys_role_menu` VALUES (1, NULL);
INSERT INTO `sys_role_menu` VALUES (1, NULL);
INSERT INTO `sys_role_menu` VALUES (1, NULL);
INSERT INTO `sys_role_menu` VALUES (1, NULL);
INSERT INTO `sys_role_menu` VALUES (1, NULL);
INSERT INTO `sys_role_menu` VALUES (1, NULL);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `user_id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `dept_id` bigint(0) NULL DEFAULT NULL COMMENT '部门ID',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `nick_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `sex` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号码',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `avatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像',
  `user_sort` int(0) NULL DEFAULT NULL COMMENT '排序',
  `deleted` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '删除：0存在、1删除',
  `enabled` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '状态：0启用、1禁用',
  `create_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建者',
  `update_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建日期',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`user_id`) USING BTREE,
  UNIQUE INDEX `UK_kpubos9gc2cvtkb0thktkbkes`(`email`) USING BTREE,
  UNIQUE INDEX `username`(`username`) USING BTREE,
  UNIQUE INDEX `uniq_username`(`username`) USING BTREE,
  UNIQUE INDEX `uniq_email`(`email`) USING BTREE,
  INDEX `FK5rwmryny6jthaaxkogownknqp`(`dept_id`) USING BTREE,
  INDEX `FKpq2dhypk2qgt68nauh2by22jb`(`avatar`) USING BTREE,
  INDEX `inx_enabled`(`enabled`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统用户' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 1, 'admin', '$2a$10$rimBM4qMHhF.EoNboKk6ZuFCQ7vacvCk1toP.rfkodaPJQzOXxgqK', 'YVKG', '1', '17703911201', 'yvkg@qq.com', 'https://www.qinweizhao.com/upload/2021/11/avatar-9b1b1e49686548049357f88d3eba6e7e.png', 1, '1', '1', 'admin', 'admin', '2021-12-20 17:50:42', '2021-12-20 17:50:45');
INSERT INTO `sys_user` VALUES (6, 2, '11', '', '111', '1', '13523232323', 'yvkg1@qq.com', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for sys_user_post
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_post`;
CREATE TABLE `sys_user_post`  (
  `user_id` bigint(0) NOT NULL COMMENT '用户ID',
  `post_id` bigint(0) NOT NULL COMMENT '岗位ID',
  PRIMARY KEY (`user_id`, `post_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '用户与岗位关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_post
-- ----------------------------
INSERT INTO `sys_user_post` VALUES (1, 1);
INSERT INTO `sys_user_post` VALUES (6, 1);

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `user_id` bigint(0) NOT NULL COMMENT '用户ID',
  `role_id` bigint(0) NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`user_id`, `role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '用户和角色关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES (1, 1);

SET FOREIGN_KEY_CHECKS = 1;
