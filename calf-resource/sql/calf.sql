/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80026
 Source Host           : localhost:3306
 Source Schema         : calf_boot

 Target Server Type    : MySQL
 Target Server Version : 80026
 File Encoding         : 65001

 Date: 08/12/2021 19:44:07
*/

SET NAMES utf8mb4;
SET
FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept`
(
    `dept_id`     bigint(0) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `parent_id`   bigint(0) NULL DEFAULT 0 COMMENT '父ID',
    `dept_name`   varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '名称',
    `phone`       varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '电话',
    `email`       varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '邮箱',
    `dept_sort`   int(0) NULL DEFAULT 0 COMMENT '排序',
    `deleted`     char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '删除：1存在、0删除',
    `enabled`     char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '状态：1启用、0禁用',
    `create_by`   varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '创建者',
    `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
    `update_by`   varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '更新者',
    `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`dept_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '部门表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`
(
    `menu_id`     bigint(0) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `menu_name`   varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '名称',
    `parent_id`   bigint(0) NULL DEFAULT 0 COMMENT '父ID',
    `path`        varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '路径',
    `component`   varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '组件',
    `menu_type`   char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '类型：M目录、C菜单、F按钮',
    `permission`  varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '权限',
    `icon`        varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '#' COMMENT '图标',
    `menu_sort`   int(0) NOT NULL COMMENT '排序',
    `deleted`     char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '删除：1存在、0删除',
    `enabled`     char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci     NOT NULL COMMENT '状态：1正常、0停用',
    `create_by`   varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '创建者',
    `update_by`   varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '更新者',
    `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
    `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`menu_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '菜单权限表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_post
-- ----------------------------
DROP TABLE IF EXISTS `sys_post`;
CREATE TABLE `sys_post`
(
    `post_id`     bigint(0) NOT NULL AUTO_INCREMENT COMMENT '岗位ID',
    `post_code`   varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '岗位编码',
    `post_name`   varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '岗位名称',
    `post_sort`   int(0) NOT NULL COMMENT '显示顺序',
    `deleted`     char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '删除标志：1存在、0删除',
    `enabled`     char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci     NOT NULL COMMENT '状态（1正常 0停用）',
    `create_by`   varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '创建者',
    `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
    `update_by`   varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '更新者',
    `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`post_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '岗位信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`
(
    `role_id`     bigint(0) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `role_name`   varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci       NOT NULL COMMENT '名称',
    `role_key`    varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '标识',
    `level`       int(0) NULL DEFAULT NULL COMMENT '级别',
    `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
    `data_scope`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '数据范围：1全部数据权限、2自定数据权限、3本部门数据权限、4本部门及以下数据权限',
    `role_sort`   int(0) NOT NULL COMMENT '排序',
    `deleted`     char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '删除：1存在、0删除',
    `enabled`     char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci      NOT NULL COMMENT '状态：1正常、0停用',
    `create_by`   varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建者',
    `update_by`   varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新者',
    `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建日期',
    `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`role_id`) USING BTREE,
    UNIQUE INDEX `uniq_name`(`role_name`) USING BTREE,
    INDEX         `role_name_index`(`role_name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for sys_role_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_dept`;
CREATE TABLE `sys_role_dept`
(
    `role_id` bigint(0) NOT NULL COMMENT '角色ID',
    `dept_id` bigint(0) NOT NULL COMMENT '部门ID',
    PRIMARY KEY (`role_id`, `dept_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '角色和部门关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`
(
    `user_id`     bigint(0) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `dept_id`     bigint(0) NULL DEFAULT NULL COMMENT '部门ID',
    `username`    varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
    `password`    varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
    `nick_name`   varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称',
    `sex`         varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
    `phone`       varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号码',
    `email`       varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
    `avatar`      varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像',
    `user_sort`   int(0) NOT NULL COMMENT '排序',
    `deleted`     char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '删除：1存在、0删除',
    `enabled`     char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '状态：1启用、0禁用',
    `create_by`   varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建者',
    `update_by`   varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新者',
    `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建日期',
    `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`user_id`) USING BTREE,
    UNIQUE INDEX `UK_kpubos9gc2cvtkb0thktkbkes`(`email`) USING BTREE,
    UNIQUE INDEX `username`(`username`) USING BTREE,
    UNIQUE INDEX `uniq_username`(`username`) USING BTREE,
    UNIQUE INDEX `uniq_email`(`email`) USING BTREE,
    INDEX         `FK5rwmryny6jthaaxkogownknqp`(`dept_id`) USING BTREE,
    INDEX         `FKpq2dhypk2qgt68nauh2by22jb`(`avatar`) USING BTREE,
    INDEX         `inx_enabled`(`enabled`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统用户' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for sys_user_post
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_post`;
CREATE TABLE `sys_user_post`
(
    `user_id` bigint(0) NOT NULL COMMENT '用户ID',
    `post_id` bigint(0) NOT NULL COMMENT '岗位ID',
    PRIMARY KEY (`user_id`, `post_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '用户与岗位关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`
(
    `user_id` bigint(0) NOT NULL COMMENT '用户ID',
    `role_id` bigint(0) NOT NULL COMMENT '角色ID',
    PRIMARY KEY (`user_id`, `role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '用户和角色关联表' ROW_FORMAT = Dynamic;

SET
FOREIGN_KEY_CHECKS = 1;
