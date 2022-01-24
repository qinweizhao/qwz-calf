/*
 Navicat Premium Data Transfer

 Source Server         : 42.192.49.72_3306
 Source Server Type    : MySQL
 Source Server Version : 80027
 Source Host           : 42.192.49.72:3306
 Source Schema         : project_calf

 Target Server Type    : MySQL
 Target Server Version : 80027
 File Encoding         : 65001

 Date: 24/01/2022 13:40:10
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for QRTZ_BLOB_TRIGGERS
-- ----------------------------
DROP TABLE IF EXISTS `QRTZ_BLOB_TRIGGERS`;
CREATE TABLE `QRTZ_BLOB_TRIGGERS`  (
  `SCHED_NAME` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_GROUP` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `BLOB_DATA` blob NULL,
  PRIMARY KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) USING BTREE,
  INDEX `SCHED_NAME`(`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) USING BTREE,
  CONSTRAINT `QRTZ_BLOB_TRIGGERS_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `QRTZ_TRIGGERS` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of QRTZ_BLOB_TRIGGERS
-- ----------------------------

-- ----------------------------
-- Table structure for QRTZ_CALENDARS
-- ----------------------------
DROP TABLE IF EXISTS `QRTZ_CALENDARS`;
CREATE TABLE `QRTZ_CALENDARS`  (
  `SCHED_NAME` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `CALENDAR_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `CALENDAR` blob NOT NULL,
  PRIMARY KEY (`SCHED_NAME`, `CALENDAR_NAME`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of QRTZ_CALENDARS
-- ----------------------------

-- ----------------------------
-- Table structure for QRTZ_CRON_TRIGGERS
-- ----------------------------
DROP TABLE IF EXISTS `QRTZ_CRON_TRIGGERS`;
CREATE TABLE `QRTZ_CRON_TRIGGERS`  (
  `SCHED_NAME` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_GROUP` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `CRON_EXPRESSION` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TIME_ZONE_ID` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) USING BTREE,
  CONSTRAINT `QRTZ_CRON_TRIGGERS_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `QRTZ_TRIGGERS` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of QRTZ_CRON_TRIGGERS
-- ----------------------------
INSERT INTO `QRTZ_CRON_TRIGGERS` VALUES ('QwzScheduler', 'TASK_10', 'DEFAULT', '0/5 * * * * ? *', 'Asia/Shanghai');

-- ----------------------------
-- Table structure for QRTZ_FIRED_TRIGGERS
-- ----------------------------
DROP TABLE IF EXISTS `QRTZ_FIRED_TRIGGERS`;
CREATE TABLE `QRTZ_FIRED_TRIGGERS`  (
  `SCHED_NAME` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ENTRY_ID` varchar(95) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_GROUP` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `INSTANCE_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `FIRED_TIME` bigint(0) NOT NULL,
  `SCHED_TIME` bigint(0) NOT NULL,
  `PRIORITY` int(0) NOT NULL,
  `STATE` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `JOB_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `JOB_GROUP` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `IS_NONCONCURRENT` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `REQUESTS_RECOVERY` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`, `ENTRY_ID`) USING BTREE,
  INDEX `IDX_QRTZ_FT_TRIG_INST_NAME`(`SCHED_NAME`, `INSTANCE_NAME`) USING BTREE,
  INDEX `IDX_QRTZ_FT_INST_JOB_REQ_RCVRY`(`SCHED_NAME`, `INSTANCE_NAME`, `REQUESTS_RECOVERY`) USING BTREE,
  INDEX `IDX_QRTZ_FT_J_G`(`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`) USING BTREE,
  INDEX `IDX_QRTZ_FT_JG`(`SCHED_NAME`, `JOB_GROUP`) USING BTREE,
  INDEX `IDX_QRTZ_FT_T_G`(`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) USING BTREE,
  INDEX `IDX_QRTZ_FT_TG`(`SCHED_NAME`, `TRIGGER_GROUP`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of QRTZ_FIRED_TRIGGERS
-- ----------------------------

-- ----------------------------
-- Table structure for QRTZ_JOB_DETAILS
-- ----------------------------
DROP TABLE IF EXISTS `QRTZ_JOB_DETAILS`;
CREATE TABLE `QRTZ_JOB_DETAILS`  (
  `SCHED_NAME` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `JOB_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `JOB_GROUP` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `DESCRIPTION` varchar(250) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `JOB_CLASS_NAME` varchar(250) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `IS_DURABLE` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `IS_NONCONCURRENT` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `IS_UPDATE_DATA` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `REQUESTS_RECOVERY` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `JOB_DATA` blob NULL,
  PRIMARY KEY (`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`) USING BTREE,
  INDEX `IDX_QRTZ_J_REQ_RECOVERY`(`SCHED_NAME`, `REQUESTS_RECOVERY`) USING BTREE,
  INDEX `IDX_QRTZ_J_GRP`(`SCHED_NAME`, `JOB_GROUP`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of QRTZ_JOB_DETAILS
-- ----------------------------
INSERT INTO `QRTZ_JOB_DETAILS` VALUES ('QwzScheduler', 'TASK_10', 'DEFAULT', NULL, 'com.qinweizhao.system.module.tool.utils.ScheduleJob', '0', '0', '0', '0', 0xACED0005737200156F72672E71756172747A2E4A6F62446174614D61709FB083E8BFA9B0CB020000787200266F72672E71756172747A2E7574696C732E537472696E674B65794469727479466C61674D61708208E8C3FBC55D280200015A0013616C6C6F77735472616E7369656E74446174617872001D6F72672E71756172747A2E7574696C732E4469727479466C61674D617013E62EAD28760ACE0200025A000564697274794C00036D617074000F4C6A6176612F7574696C2F4D61703B787001737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F4000000000000C7708000000100000000174000D4A4F425F504152414D5F4B45597372002F636F6D2E71696E7765697A68616F2E73797374656D2E6D6F64756C652E746F6F6C2E656E746974792E5379734A6F6200000000000000010200094C000E63726F6E45787072657373696F6E7400124C6A6176612F6C616E672F537472696E673B4C000B68616E646C65724E616D6571007E00094C000C68616E646C6572506172616D71007E00094C00056A6F6249647400104C6A6176612F6C616E672F4C6F6E673B4C000E6D6F6E69746F7254696D656F75747400134C6A6176612F6C616E672F496E74656765723B4C00046E616D6571007E00094C000A7265747279436F756E7471007E000B4C000D7265747279496E74657276616C71007E000B4C000673746174757371007E000B7872002A636F6D2E71696E7765697A68616F2E636F6D6D6F6E2E636F72652E626173652E42617365456E74697479278F29A490E71E230200064C0008637265617465427971007E00094C000A63726561746554696D657400194C6A6176612F74696D652F4C6F63616C4461746554696D653B4C000764656C6574656471007E000B4C000673746174757371007E000B4C0008757064617465427971007E00094C000A75706461746554696D6571007E000D787074000561646D696E7372000D6A6176612E74696D652E536572955D84BA1B2248B20C00007870770E05000007E601151122031686A5B878737200116A6176612E6C616E672E496E746567657212E2A0A4F781873802000149000576616C7565787200106A6176612E6C616E672E4E756D62657286AC951D0B94E08B0200007870000000007071007E000F7371007E0010770E05000007E601151122031686A5B87874000D30202A202A202A202A203F202A74000474657374740004656565657372000E6A6176612E6C616E672E4C6F6E673B8BE490CC8F23DF0200014A000576616C75657871007E0013000000000000000A7371007E0012000000017400047465737471007E001B71007E001B71007E00147800);

-- ----------------------------
-- Table structure for QRTZ_LOCKS
-- ----------------------------
DROP TABLE IF EXISTS `QRTZ_LOCKS`;
CREATE TABLE `QRTZ_LOCKS`  (
  `SCHED_NAME` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `LOCK_NAME` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`SCHED_NAME`, `LOCK_NAME`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of QRTZ_LOCKS
-- ----------------------------
INSERT INTO `QRTZ_LOCKS` VALUES ('QwzScheduler', 'STATE_ACCESS');
INSERT INTO `QRTZ_LOCKS` VALUES ('QwzScheduler', 'TRIGGER_ACCESS');

-- ----------------------------
-- Table structure for QRTZ_PAUSED_TRIGGER_GRPS
-- ----------------------------
DROP TABLE IF EXISTS `QRTZ_PAUSED_TRIGGER_GRPS`;
CREATE TABLE `QRTZ_PAUSED_TRIGGER_GRPS`  (
  `SCHED_NAME` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_GROUP` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`SCHED_NAME`, `TRIGGER_GROUP`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of QRTZ_PAUSED_TRIGGER_GRPS
-- ----------------------------

-- ----------------------------
-- Table structure for QRTZ_SCHEDULER_STATE
-- ----------------------------
DROP TABLE IF EXISTS `QRTZ_SCHEDULER_STATE`;
CREATE TABLE `QRTZ_SCHEDULER_STATE`  (
  `SCHED_NAME` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `INSTANCE_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `LAST_CHECKIN_TIME` bigint(0) NOT NULL,
  `CHECKIN_INTERVAL` bigint(0) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`, `INSTANCE_NAME`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of QRTZ_SCHEDULER_STATE
-- ----------------------------
INSERT INTO `QRTZ_SCHEDULER_STATE` VALUES ('QwzScheduler', 'DESKTOP-H75DMF11642843016972', 1642843290234, 15000);

-- ----------------------------
-- Table structure for QRTZ_SIMPLE_TRIGGERS
-- ----------------------------
DROP TABLE IF EXISTS `QRTZ_SIMPLE_TRIGGERS`;
CREATE TABLE `QRTZ_SIMPLE_TRIGGERS`  (
  `SCHED_NAME` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_GROUP` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `REPEAT_COUNT` bigint(0) NOT NULL,
  `REPEAT_INTERVAL` bigint(0) NOT NULL,
  `TIMES_TRIGGERED` bigint(0) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) USING BTREE,
  CONSTRAINT `QRTZ_SIMPLE_TRIGGERS_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `QRTZ_TRIGGERS` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of QRTZ_SIMPLE_TRIGGERS
-- ----------------------------

-- ----------------------------
-- Table structure for QRTZ_SIMPROP_TRIGGERS
-- ----------------------------
DROP TABLE IF EXISTS `QRTZ_SIMPROP_TRIGGERS`;
CREATE TABLE `QRTZ_SIMPROP_TRIGGERS`  (
  `SCHED_NAME` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_GROUP` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `STR_PROP_1` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `STR_PROP_2` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `STR_PROP_3` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `INT_PROP_1` int(0) NULL DEFAULT NULL,
  `INT_PROP_2` int(0) NULL DEFAULT NULL,
  `LONG_PROP_1` bigint(0) NULL DEFAULT NULL,
  `LONG_PROP_2` bigint(0) NULL DEFAULT NULL,
  `DEC_PROP_1` decimal(13, 4) NULL DEFAULT NULL,
  `DEC_PROP_2` decimal(13, 4) NULL DEFAULT NULL,
  `BOOL_PROP_1` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `BOOL_PROP_2` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) USING BTREE,
  CONSTRAINT `QRTZ_SIMPROP_TRIGGERS_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `QRTZ_TRIGGERS` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of QRTZ_SIMPROP_TRIGGERS
-- ----------------------------

-- ----------------------------
-- Table structure for QRTZ_TRIGGERS
-- ----------------------------
DROP TABLE IF EXISTS `QRTZ_TRIGGERS`;
CREATE TABLE `QRTZ_TRIGGERS`  (
  `SCHED_NAME` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_GROUP` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `JOB_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `JOB_GROUP` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `DESCRIPTION` varchar(250) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `NEXT_FIRE_TIME` bigint(0) NULL DEFAULT NULL,
  `PREV_FIRE_TIME` bigint(0) NULL DEFAULT NULL,
  `PRIORITY` int(0) NULL DEFAULT NULL,
  `TRIGGER_STATE` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_TYPE` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `START_TIME` bigint(0) NOT NULL,
  `END_TIME` bigint(0) NULL DEFAULT NULL,
  `CALENDAR_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `MISFIRE_INSTR` smallint(0) NULL DEFAULT NULL,
  `JOB_DATA` blob NULL,
  PRIMARY KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) USING BTREE,
  INDEX `IDX_QRTZ_T_J`(`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`) USING BTREE,
  INDEX `IDX_QRTZ_T_JG`(`SCHED_NAME`, `JOB_GROUP`) USING BTREE,
  INDEX `IDX_QRTZ_T_C`(`SCHED_NAME`, `CALENDAR_NAME`) USING BTREE,
  INDEX `IDX_QRTZ_T_G`(`SCHED_NAME`, `TRIGGER_GROUP`) USING BTREE,
  INDEX `IDX_QRTZ_T_STATE`(`SCHED_NAME`, `TRIGGER_STATE`) USING BTREE,
  INDEX `IDX_QRTZ_T_N_STATE`(`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`, `TRIGGER_STATE`) USING BTREE,
  INDEX `IDX_QRTZ_T_N_G_STATE`(`SCHED_NAME`, `TRIGGER_GROUP`, `TRIGGER_STATE`) USING BTREE,
  INDEX `IDX_QRTZ_T_NEXT_FIRE_TIME`(`SCHED_NAME`, `NEXT_FIRE_TIME`) USING BTREE,
  INDEX `IDX_QRTZ_T_NFT_ST`(`SCHED_NAME`, `TRIGGER_STATE`, `NEXT_FIRE_TIME`) USING BTREE,
  INDEX `IDX_QRTZ_T_NFT_MISFIRE`(`SCHED_NAME`, `MISFIRE_INSTR`, `NEXT_FIRE_TIME`) USING BTREE,
  INDEX `IDX_QRTZ_T_NFT_ST_MISFIRE`(`SCHED_NAME`, `MISFIRE_INSTR`, `NEXT_FIRE_TIME`, `TRIGGER_STATE`) USING BTREE,
  INDEX `IDX_QRTZ_T_NFT_ST_MISFIRE_GRP`(`SCHED_NAME`, `MISFIRE_INSTR`, `NEXT_FIRE_TIME`, `TRIGGER_GROUP`, `TRIGGER_STATE`) USING BTREE,
  CONSTRAINT `QRTZ_TRIGGERS_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`) REFERENCES `QRTZ_JOB_DETAILS` (`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of QRTZ_TRIGGERS
-- ----------------------------
INSERT INTO `QRTZ_TRIGGERS` VALUES ('QwzScheduler', 'TASK_10', 'DEFAULT', 'TASK_10', 'DEFAULT', NULL, 1642757645000, -1, 5, 'PAUSED', 'CRON', 1642757643000, 0, NULL, 2, 0xACED0005737200156F72672E71756172747A2E4A6F62446174614D61709FB083E8BFA9B0CB020000787200266F72672E71756172747A2E7574696C732E537472696E674B65794469727479466C61674D61708208E8C3FBC55D280200015A0013616C6C6F77735472616E7369656E74446174617872001D6F72672E71756172747A2E7574696C732E4469727479466C61674D617013E62EAD28760ACE0200025A000564697274794C00036D617074000F4C6A6176612F7574696C2F4D61703B787001737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F4000000000000C7708000000100000000174000D4A4F425F504152414D5F4B45597372002F636F6D2E71696E7765697A68616F2E73797374656D2E6D6F64756C652E746F6F6C2E656E746974792E5379734A6F6200000000000000010200094C000E63726F6E45787072657373696F6E7400124C6A6176612F6C616E672F537472696E673B4C000B68616E646C65724E616D6571007E00094C000C68616E646C6572506172616D71007E00094C00056A6F6249647400104C6A6176612F6C616E672F4C6F6E673B4C000E6D6F6E69746F7254696D656F75747400134C6A6176612F6C616E672F496E74656765723B4C00046E616D6571007E00094C000A7265747279436F756E7471007E000B4C000D7265747279496E74657276616C71007E000B4C000673746174757371007E000B7872002A636F6D2E71696E7765697A68616F2E636F6D6D6F6E2E636F72652E626173652E42617365456E74697479278F29A490E71E230200064C0008637265617465427971007E00094C000A63726561746554696D657400194C6A6176612F74696D652F4C6F63616C4461746554696D653B4C000764656C6574656471007E000B4C000673746174757371007E000B4C0008757064617465427971007E00094C000A75706461746554696D6571007E000D787074000561646D696E7372000D6A6176612E74696D652E536572955D84BA1B2248B20C00007870770A05000007E601151122FC78707074000561646D696E7371007E0010770E05000007E6011511302B0FBFECA87874000F302F35202A202A202A202A203F202A74000474657374740004656565657372000E6A6176612E6C616E672E4C6F6E673B8BE490CC8F23DF0200014A000576616C7565787200106A6176612E6C616E672E4E756D62657286AC951D0B94E08B0200007870000000000000000A737200116A6176612E6C616E672E496E746567657212E2A0A4F781873802000149000576616C75657871007E0018000000017400047465737471007E001B71007E001B71007E001B7800);

-- ----------------------------
-- Table structure for sys_config
-- ----------------------------
DROP TABLE IF EXISTS `sys_config`;
CREATE TABLE `sys_config`  (
  `config_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '参数主键',
  `type` tinyint(0) NOT NULL COMMENT '参数类型',
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '参数名称',
  `code` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '参数键名',
  `value` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '参数键值',
  `category` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '参数分组',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '状态：1正常、0停用',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '创建者',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '更新者',
  PRIMARY KEY (`config_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '参数配置表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_config
-- ----------------------------
INSERT INTO `sys_config` VALUES (1, 1, '主框架页-默认皮肤样式名称', 'sys.index.skinName', 'skin-blue', 'ui', '蓝色 skin-blue、绿色 skin-green、紫色 skin-purple、红色 skin-red、黄色 skin-yellow', NULL, b'0', '2021-01-05 17:03:48', '2021-01-05 17:03:48', 'admin', '');
INSERT INTO `sys_config` VALUES (2, 1, '用户管理-账号初始密码', 'sys.user.init-password', '123456', 'biz', '初始化密码 123456', NULL, b'0', '2021-01-05 17:03:48', '2021-04-13 03:48:02', 'admin', '');
INSERT INTO `sys_config` VALUES (3, 1, '主框架页-侧边栏主题', 'sys.index.sideTheme', 'theme-dark', 'ui', '深色主题theme-dark，浅色主题theme-light', NULL, b'0', '2021-01-05 17:03:48', '2021-01-19 03:05:21', 'admin', '');

-- ----------------------------
-- Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept`  (
  `dept_id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `parent_id` bigint(0) NULL DEFAULT 0 COMMENT '父ID',
  `name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '名称',
  `phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '电话',
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '邮箱',
  `sort` int(0) NULL DEFAULT 0 COMMENT '排序',
  `leader` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '负责人',
  `deleted` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '删除：1存在、0删除',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '状态：1启用、0禁用',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`dept_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '部门表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_dept
-- ----------------------------
INSERT INTO `sys_dept` VALUES (1, 0, '中国', '2022', 'yvkg@qq.com\r\n', 0, NULL, '0', '1', 'admin', '2021-12-22 17:25:16', 'admin', '2021-12-22 17:25:22');
INSERT INTO `sys_dept` VALUES (2, 1, '广州', '3679', 'yvkg@qq.com', 0, NULL, '0', '1', 'admin', '2021-12-22 17:25:16', 'admin', '2021-12-22 17:25:22');
INSERT INTO `sys_dept` VALUES (3, 1, '北京', '3679', 'yvkg@qq.com', 0, NULL, '0', '1', 'admin', '2021-12-22 17:25:17', 'admin', '2021-12-22 17:25:24');
INSERT INTO `sys_dept` VALUES (4, 1, '上海', '3679', 'yvkg@qq.com', 0, NULL, '0', '1', 'admin', '2021-12-22 17:25:19', 'admin', '2021-12-22 17:25:24');
INSERT INTO `sys_dept` VALUES (5, 4, '宝山', '13523200000', 'yvkg@qq.com', 1, NULL, '0', '1', 'admin', '2021-12-22 17:25:27', 'admin', '2022-01-20 10:44:23');
INSERT INTO `sys_dept` VALUES (6, 4, '浦东', '3679', 'yvkg@qq.com', 0, NULL, '0', '1', 'admin', '2021-12-22 17:25:12', 'admin', '2021-12-22 17:25:23');
INSERT INTO `sys_dept` VALUES (14, 1, '郑州', '13523200000', 'zz@qq.com', 111, NULL, '0', '1', 'admin', '2022-01-18 14:52:26', 'admin', '2022-01-18 14:52:26');
INSERT INTO `sys_dept` VALUES (15, 14, '二七', '17639100000', 'eq@qq.com', 1112, NULL, '0', '1', 'admin', '2022-01-18 14:56:41', 'admin', '2022-01-18 14:56:41');

-- ----------------------------
-- Table structure for sys_dict
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict`;
CREATE TABLE `sys_dict`  (
  `dict_id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '字典主键',
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '字典名称',
  `type` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '字典类型',
  `status` tinyint(0) NOT NULL DEFAULT 0 COMMENT '状态（0正常 1停用）',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  PRIMARY KEY (`dict_id`) USING BTREE,
  UNIQUE INDEX `dict_type`(`type`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 119 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '字典类型表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_dict
-- ----------------------------
INSERT INTO `sys_dict` VALUES (1, '用户性别', 'sys_user_sex', 0, NULL, 'admin', '2021-01-05 17:03:48', '', '2022-01-17 19:05:06', b'0');
INSERT INTO `sys_dict` VALUES (3, '系统开关', 'sys_normal_disable', 0, NULL, 'admin', '2021-01-05 17:03:48', '', '2022-01-17 19:05:06', b'0');
INSERT INTO `sys_dict` VALUES (4, '任务状态的枚举', 'sys_job_status', 0, NULL, 'admin', '2021-01-05 17:03:48', '', '2022-01-17 19:05:06', b'0');
INSERT INTO `sys_dict` VALUES (5, '任务分组', 'sys_job_group', 0, NULL, 'admin', '2021-01-05 17:03:48', '', '2022-01-17 19:05:06', b'0');
INSERT INTO `sys_dict` VALUES (6, '参数类型', 'sys_config_type', 0, NULL, 'admin', '2021-01-05 17:03:48', '', '2022-01-17 19:05:06', b'0');
INSERT INTO `sys_dict` VALUES (7, '通知类型', 'sys_notice_type', 0, NULL, 'admin', '2021-01-05 17:03:48', '', '2022-01-17 19:05:06', b'0');
INSERT INTO `sys_dict` VALUES (8, '通知状态', 'sys_notice_status', 0, NULL, 'admin', '2021-01-05 17:03:48', '', '2022-01-17 19:05:06', b'0');
INSERT INTO `sys_dict` VALUES (9, '操作类型', 'sys_oper_type', 0, NULL, 'admin', '2021-01-05 17:03:48', '', '2022-01-17 19:05:06', b'0');
INSERT INTO `sys_dict` VALUES (10, '系统状态', 'sys_common_status', 0, NULL, 'admin', '2021-01-05 17:03:48', '', '2022-01-17 19:05:06', b'0');
INSERT INTO `sys_dict` VALUES (11, 'Boolean 是否类型', 'sys_boolean_string', 0, 'boolean 转是否', '', '2021-01-19 03:20:08', '', '2022-01-17 19:05:06', b'0');
INSERT INTO `sys_dict` VALUES (104, '登陆结果', 'sys_login_result', 0, '登陆结果', '', '2021-01-18 06:17:11', '', '2022-01-17 19:05:06', b'0');
INSERT INTO `sys_dict` VALUES (105, 'Redis 超时类型', 'inf_redis_timeout_type', 0, 'RedisKeyDefine.TimeoutTypeEnum', '', '2021-01-26 00:52:50', '', '2022-01-17 19:05:06', b'0');
INSERT INTO `sys_dict` VALUES (106, '代码生成模板类型', 'tool_codegen_template_type', 0, NULL, '', '2021-02-05 07:08:06', '', '2022-01-17 19:05:06', b'0');
INSERT INTO `sys_dict` VALUES (107, '定时任务状态', 'inf_job_status', 0, NULL, '', '2021-02-07 07:44:16', '', '2022-01-17 19:05:06', b'0');
INSERT INTO `sys_dict` VALUES (108, '定时任务日志状态', 'inf_job_log_status', 0, NULL, '', '2021-02-08 10:03:51', '', '2022-01-17 19:05:06', b'0');
INSERT INTO `sys_dict` VALUES (109, '用户类型', 'user_type', 0, NULL, '', '2021-02-26 00:15:51', '', '2022-01-17 19:05:06', b'0');
INSERT INTO `sys_dict` VALUES (110, 'API 异常数据的处理状态', 'inf_api_error_log_process_status', 0, NULL, '', '2021-02-26 07:07:01', '', '2022-01-17 19:05:06', b'0');
INSERT INTO `sys_dict` VALUES (111, '短信渠道编码', 'sys_sms_channel_code', 0, NULL, '1', '2021-04-05 01:04:50', '1', '2022-01-17 19:05:06', b'0');
INSERT INTO `sys_dict` VALUES (112, '短信模板的类型', 'sys_sms_template_type', 0, NULL, '1', '2021-04-05 21:50:43', '1', '2022-01-17 19:05:06', b'0');
INSERT INTO `sys_dict` VALUES (113, '短信发送状态', 'sys_sms_send_status', 0, NULL, '1', '2021-04-11 20:18:03', '1', '2022-01-17 19:05:06', b'0');
INSERT INTO `sys_dict` VALUES (114, '短信接收状态', 'sys_sms_receive_status', 0, NULL, '1', '2021-04-11 20:27:14', '1', '2022-01-17 19:05:06', b'0');
INSERT INTO `sys_dict` VALUES (115, '错误码的类型', 'sys_error_code_type', 0, NULL, '1', '2021-04-21 00:06:30', '1', '2022-01-17 19:05:06', b'0');
INSERT INTO `sys_dict` VALUES (116, '登陆日志的类型', 'sys_login_type', 0, '登陆日志的类型', '1', '2021-10-06 00:50:46', '1', '2022-01-17 19:05:06', b'0');
INSERT INTO `sys_dict` VALUES (117, '请假类型', 'oa_leave_type', 0, NULL, '1', '2021-09-21 22:34:33', '1', '2022-01-17 19:05:06', b'0');
INSERT INTO `sys_dict` VALUES (118, '请假流程状态', 'oa_leave_status', 0, NULL, '1', '2021-09-21 22:46:04', '1', '2022-01-17 19:05:07', b'0');

-- ----------------------------
-- Table structure for sys_dict_item
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_item`;
CREATE TABLE `sys_dict_item`  (
  `dict_item_id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '字典编码',
  `sort` int(0) NOT NULL DEFAULT 0 COMMENT '字典排序',
  `label` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '字典标签',
  `value` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '字典键值',
  `dict_type` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '字典类型',
  `status` tinyint(0) NOT NULL DEFAULT 0 COMMENT '状态（0正常 1停用）',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  PRIMARY KEY (`dict_item_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 92 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '字典数据表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_dict_item
-- ----------------------------
INSERT INTO `sys_dict_item` VALUES (1, 1, '男', '1', 'sys_user_sex', 1, '性别男', 'admin', '2021-01-05 17:03:48', '', '2022-01-11 15:53:27', b'0');
INSERT INTO `sys_dict_item` VALUES (2, 2, '女', '2', 'sys_user_sex', 1, '性别女', 'admin', '2021-01-05 17:03:48', '', '2022-01-11 15:53:27', b'0');
INSERT INTO `sys_dict_item` VALUES (8, 1, '正常', '1', 'sys_job_status', 1, '正常状态', 'admin', '2021-01-05 17:03:48', '', '2022-01-11 15:53:27', b'1');
INSERT INTO `sys_dict_item` VALUES (9, 2, '暂停', '0', 'sys_job_status', 1, '停用状态', 'admin', '2021-01-05 17:03:48', '', '2022-01-11 15:53:27', b'1');
INSERT INTO `sys_dict_item` VALUES (10, 1, '默认', 'DEFAULT', 'sys_job_group', 1, '默认分组', 'admin', '2021-01-05 17:03:48', '', '2022-01-11 15:53:27', b'1');
INSERT INTO `sys_dict_item` VALUES (11, 2, '系统', 'SYSTEM', 'sys_job_group', 1, '系统分组', 'admin', '2021-01-05 17:03:48', '', '2022-01-11 15:53:27', b'1');
INSERT INTO `sys_dict_item` VALUES (12, 1, '系统内置', '1', 'sys_config_type', 1, '参数类型 - 系统内置', 'admin', '2021-01-05 17:03:48', '', '2022-01-11 15:53:27', b'0');
INSERT INTO `sys_dict_item` VALUES (13, 2, '自定义', '2', 'sys_config_type', 1, '参数类型 - 自定义', 'admin', '2021-01-05 17:03:48', '', '2022-01-11 15:53:27', b'0');
INSERT INTO `sys_dict_item` VALUES (14, 1, '通知', '1', 'sys_notice_type', 1, '通知', 'admin', '2021-01-05 17:03:48', '', '2022-01-11 15:53:27', b'0');
INSERT INTO `sys_dict_item` VALUES (15, 2, '公告', '2', 'sys_notice_type', 1, '公告', 'admin', '2021-01-05 17:03:48', '', '2022-01-11 15:53:27', b'0');
INSERT INTO `sys_dict_item` VALUES (16, 0, '其它', '0', 'sys_operate_type', 1, '其它操作', 'admin', '2021-01-05 17:03:48', '', '2022-01-11 15:53:27', b'0');
INSERT INTO `sys_dict_item` VALUES (17, 1, '查询', '1', 'sys_operate_type', 1, '查询操作', 'admin', '2021-01-05 17:03:48', '', '2022-01-11 15:53:27', b'0');
INSERT INTO `sys_dict_item` VALUES (18, 2, '新增', '2', 'sys_operate_type', 1, '新增操作', 'admin', '2021-01-05 17:03:48', '', '2022-01-11 15:53:27', b'0');
INSERT INTO `sys_dict_item` VALUES (19, 3, '修改', '3', 'sys_operate_type', 1, '修改操作', 'admin', '2021-01-05 17:03:48', '', '2022-01-11 15:53:27', b'0');
INSERT INTO `sys_dict_item` VALUES (20, 4, '删除', '4', 'sys_operate_type', 1, '删除操作', 'admin', '2021-01-05 17:03:48', '', '2022-01-11 15:53:27', b'0');
INSERT INTO `sys_dict_item` VALUES (22, 5, '导出', '5', 'sys_operate_type', 1, '导出操作', 'admin', '2021-01-05 17:03:48', '', '2022-01-11 15:53:27', b'0');
INSERT INTO `sys_dict_item` VALUES (23, 6, '导入', '6', 'sys_operate_type', 1, '导入操作', 'admin', '2021-01-05 17:03:48', '', '2022-01-11 15:53:27', b'0');
INSERT INTO `sys_dict_item` VALUES (27, 1, '开启', '1', 'sys_common_status', 1, '开启状态', 'admin', '2021-01-05 17:03:48', '', '2022-01-11 15:53:27', b'0');
INSERT INTO `sys_dict_item` VALUES (28, 2, '关闭', '0', 'sys_common_status', 1, '关闭状态', 'admin', '2021-01-05 17:03:48', '', '2022-01-11 15:53:27', b'0');
INSERT INTO `sys_dict_item` VALUES (29, 1, '目录', '1', 'sys_menu_type', 1, '目录', 'admin', '2021-01-05 17:03:48', '', '2022-01-11 15:53:27', b'0');
INSERT INTO `sys_dict_item` VALUES (30, 2, '菜单', '2', 'sys_menu_type', 1, '菜单', 'admin', '2021-01-05 17:03:48', '', '2022-01-11 15:53:27', b'0');
INSERT INTO `sys_dict_item` VALUES (31, 3, '按钮', '3', 'sys_menu_type', 1, '按钮', 'admin', '2021-01-05 17:03:48', '', '2022-01-11 15:53:27', b'0');
INSERT INTO `sys_dict_item` VALUES (32, 1, '内置', '1', 'sys_role_type', 1, '内置角色', 'admin', '2021-01-05 17:03:48', '', '2022-01-11 15:53:27', b'0');
INSERT INTO `sys_dict_item` VALUES (33, 2, '自定义', '2', 'sys_role_type', 1, '自定义角色', 'admin', '2021-01-05 17:03:48', '', '2022-01-11 15:53:27', b'0');
INSERT INTO `sys_dict_item` VALUES (34, 1, '全部数据权限', '1', 'sys_data_scope', 1, '全部数据权限', 'admin', '2021-01-05 17:03:48', '', '2022-01-11 15:53:28', b'0');
INSERT INTO `sys_dict_item` VALUES (35, 2, '指定部门数据权限', '2', 'sys_data_scope', 1, '指定部门数据权限', 'admin', '2021-01-05 17:03:48', '', '2022-01-11 15:53:28', b'0');
INSERT INTO `sys_dict_item` VALUES (36, 3, '本部门数据权限', '3', 'sys_data_scope', 1, '本部门数据权限', 'admin', '2021-01-05 17:03:48', '', '2022-01-11 15:53:28', b'0');
INSERT INTO `sys_dict_item` VALUES (37, 4, '本部门及以下数据权限', '4', 'sys_data_scope', 1, '本部门及以下数据权限', 'admin', '2021-01-05 17:03:48', '', '2022-01-11 15:53:28', b'0');
INSERT INTO `sys_dict_item` VALUES (38, 5, '仅本人数据权限', '5', 'sys_data_scope', 1, '仅本人数据权限', 'admin', '2021-01-05 17:03:48', '', '2022-01-11 15:53:28', b'0');
INSERT INTO `sys_dict_item` VALUES (39, 0, '成功', '0', 'sys_login_result', 1, '登陆结果 - 成功', '', '2021-01-18 06:17:36', '', '2022-01-11 15:53:28', b'0');
INSERT INTO `sys_dict_item` VALUES (40, 10, '账号或密码不正确', '10', 'sys_login_result', 1, '登陆结果 - 账号或密码不正确', '', '2021-01-18 06:17:54', '', '2022-01-11 15:53:28', b'0');
INSERT INTO `sys_dict_item` VALUES (41, 20, '用户被禁用', '20', 'sys_login_result', 1, '登陆结果 - 用户被禁用', '', '2021-01-18 06:17:54', '', '2022-01-11 15:53:28', b'0');
INSERT INTO `sys_dict_item` VALUES (42, 30, '验证码不存在', '30', 'sys_login_result', 1, '登陆结果 - 验证码不存在', '', '2021-01-18 06:17:54', '', '2022-01-11 15:53:28', b'0');
INSERT INTO `sys_dict_item` VALUES (43, 31, '验证码不正确', '31', 'sys_login_result', 1, '登陆结果 - 验证码不正确', '', '2021-01-18 06:17:54', '', '2022-01-11 15:53:28', b'0');
INSERT INTO `sys_dict_item` VALUES (44, 100, '未知异常', '100', 'sys_login_result', 1, '登陆结果 - 未知异常', '', '2021-01-18 06:17:54', '', '2022-01-11 15:53:28', b'0');
INSERT INTO `sys_dict_item` VALUES (45, 1, '是', 'true', 'sys_boolean_string', 1, 'Boolean 是否类型 - 是', '', '2021-01-19 03:20:55', '', '2022-01-11 15:53:28', b'0');
INSERT INTO `sys_dict_item` VALUES (46, 1, '否', 'false', 'sys_boolean_string', 1, 'Boolean 是否类型 - 否', '', '2021-01-19 03:20:55', '', '2022-01-11 15:53:28', b'0');
INSERT INTO `sys_dict_item` VALUES (47, 1, '永不超时', '1', 'inf_redis_timeout_type', 1, 'Redis 未设置超时的情况', '', '2021-01-26 00:53:17', '', '2022-01-11 15:53:28', b'0');
INSERT INTO `sys_dict_item` VALUES (48, 1, '动态超时', '2', 'inf_redis_timeout_type', 1, '程序里动态传入超时时间，无法固定', '', '2021-01-26 00:55:00', '', '2022-01-11 15:53:28', b'0');
INSERT INTO `sys_dict_item` VALUES (49, 3, '固定超时', '3', 'inf_redis_timeout_type', 1, 'Redis 设置了过期时间', '', '2021-01-26 00:55:26', '', '2022-01-11 15:53:28', b'0');
INSERT INTO `sys_dict_item` VALUES (50, 1, '单表（增删改查）', '1', 'tool_codegen_template_type', 1, NULL, '', '2021-02-05 07:09:06', '', '2022-01-11 15:53:28', b'0');
INSERT INTO `sys_dict_item` VALUES (51, 2, '树表（增删改查）', '2', 'tool_codegen_template_type', 1, NULL, '', '2021-02-05 07:14:46', '', '2022-01-11 15:53:28', b'0');
INSERT INTO `sys_dict_item` VALUES (52, 3, '主子表（增删改查）', '3', 'tool_codegen_template_type', 1, NULL, '', '2021-02-05 07:21:45', '', '2022-01-11 15:53:28', b'1');
INSERT INTO `sys_dict_item` VALUES (53, 0, '初始化中', '0', 'inf_job_status', 1, NULL, '', '2021-02-07 07:46:49', '', '2022-01-11 15:53:28', b'0');
INSERT INTO `sys_dict_item` VALUES (54, 1, '开启', '1', 'inf_job_status', 1, NULL, '', '2021-02-07 07:46:57', '', '2022-01-11 15:53:28', b'0');
INSERT INTO `sys_dict_item` VALUES (56, 3, '暂停', '2', 'inf_job_status', 1, NULL, '', '2021-02-07 07:47:16', '', '2022-01-11 15:53:28', b'0');
INSERT INTO `sys_dict_item` VALUES (57, 0, '运行中', '0', 'inf_job_log_status', 1, 'RUNNING', '', '2021-02-08 10:04:24', '', '2022-01-11 15:53:28', b'0');
INSERT INTO `sys_dict_item` VALUES (58, 1, '成功', '1', 'inf_job_log_status', 1, NULL, '', '2021-02-08 10:06:57', '', '2022-01-11 15:53:28', b'0');
INSERT INTO `sys_dict_item` VALUES (59, 2, '失败', '2', 'inf_job_log_status', 1, '失败', '', '2021-02-08 10:07:38', '', '2022-01-11 15:53:28', b'0');
INSERT INTO `sys_dict_item` VALUES (60, 1, '会员', '1', 'user_type', 1, NULL, '', '2021-02-26 00:16:27', '', '2022-01-11 15:53:28', b'0');
INSERT INTO `sys_dict_item` VALUES (61, 2, '管理员', '2', 'user_type', 1, NULL, '', '2021-02-26 00:16:34', '', '2022-01-11 15:53:28', b'0');
INSERT INTO `sys_dict_item` VALUES (62, 0, '未处理', '0', 'inf_api_error_log_process_status', 1, NULL, '', '2021-02-26 07:07:19', '', '2022-01-11 15:53:28', b'0');
INSERT INTO `sys_dict_item` VALUES (63, 1, '已处理', '1', 'inf_api_error_log_process_status', 1, NULL, '', '2021-02-26 07:07:26', '', '2022-01-11 15:53:28', b'0');
INSERT INTO `sys_dict_item` VALUES (64, 2, '已忽略', '2', 'inf_api_error_log_process_status', 1, NULL, '', '2021-02-26 07:07:34', '', '2022-01-11 15:53:28', b'0');
INSERT INTO `sys_dict_item` VALUES (65, 1, '云片', 'YUN_PIAN', 'sys_sms_channel_code', 1, NULL, '1', '2021-04-05 01:05:14', '1', '2022-01-11 15:53:28', b'0');
INSERT INTO `sys_dict_item` VALUES (66, 2, '阿里云', 'ALIYUN', 'sys_sms_channel_code', 1, NULL, '1', '2021-04-05 01:05:26', '1', '2022-01-11 15:53:29', b'0');
INSERT INTO `sys_dict_item` VALUES (67, 1, '验证码', '1', 'sys_sms_template_type', 1, NULL, '1', '2021-04-05 21:50:57', '1', '2022-01-11 15:53:29', b'0');
INSERT INTO `sys_dict_item` VALUES (68, 2, '通知', '2', 'sys_sms_template_type', 1, NULL, '1', '2021-04-05 21:51:08', '1', '2022-01-11 15:53:29', b'0');
INSERT INTO `sys_dict_item` VALUES (69, 0, '营销', '3', 'sys_sms_template_type', 1, NULL, '1', '2021-04-05 21:51:15', '1', '2022-01-11 15:53:29', b'0');
INSERT INTO `sys_dict_item` VALUES (70, 0, '初始化', '0', 'sys_sms_send_status', 1, NULL, '1', '2021-04-11 20:18:33', '1', '2022-01-11 15:53:29', b'0');
INSERT INTO `sys_dict_item` VALUES (71, 1, '发送成功', '10', 'sys_sms_send_status', 1, NULL, '1', '2021-04-11 20:18:43', '1', '2022-01-11 15:53:29', b'0');
INSERT INTO `sys_dict_item` VALUES (72, 2, '发送失败', '20', 'sys_sms_send_status', 1, NULL, '1', '2021-04-11 20:18:49', '1', '2022-01-11 15:53:29', b'0');
INSERT INTO `sys_dict_item` VALUES (73, 3, '不发送', '30', 'sys_sms_send_status', 1, NULL, '1', '2021-04-11 20:19:44', '1', '2022-01-11 15:53:29', b'0');
INSERT INTO `sys_dict_item` VALUES (74, 0, '等待结果', '0', 'sys_sms_receive_status', 1, NULL, '1', '2021-04-11 20:27:43', '1', '2022-01-11 15:53:29', b'0');
INSERT INTO `sys_dict_item` VALUES (75, 1, '接收成功', '10', 'sys_sms_receive_status', 1, NULL, '1', '2021-04-11 20:29:25', '1', '2022-01-11 15:53:29', b'0');
INSERT INTO `sys_dict_item` VALUES (76, 2, '接收失败', '20', 'sys_sms_receive_status', 1, NULL, '1', '2021-04-11 20:29:31', '1', '2022-01-11 15:53:29', b'0');
INSERT INTO `sys_dict_item` VALUES (77, 0, '调试(钉钉)', 'DEBUG_DING_TALK', 'sys_sms_channel_code', 1, NULL, '1', '2021-04-13 00:20:37', '1', '2022-01-11 15:53:29', b'0');
INSERT INTO `sys_dict_item` VALUES (78, 1, '自动生成', '1', 'sys_error_code_type', 1, NULL, '1', '2021-04-21 00:06:48', '1', '2022-01-11 15:53:29', b'0');
INSERT INTO `sys_dict_item` VALUES (79, 2, '手动编辑', '2', 'sys_error_code_type', 1, NULL, '1', '2021-04-21 00:07:14', '1', '2022-01-11 15:53:29', b'0');
INSERT INTO `sys_dict_item` VALUES (80, 100, '账号登录', '100', 'sys_login_type', 1, '账号登录', '1', '2021-10-06 00:52:02', '1', '2022-01-11 15:53:29', b'0');
INSERT INTO `sys_dict_item` VALUES (81, 101, '社交登录', '101', 'sys_login_type', 1, '社交登录', '1', '2021-10-06 00:52:17', '1', '2022-01-11 15:53:29', b'0');
INSERT INTO `sys_dict_item` VALUES (82, 102, 'Mock 登录', '102', 'sys_login_type', 1, 'Mock 登录', '1', '2021-10-06 00:52:32', '1', '2022-01-11 15:53:29', b'0');
INSERT INTO `sys_dict_item` VALUES (83, 200, '主动登出', '200', 'sys_login_type', 1, '主动登出', '1', '2021-10-06 00:52:58', '1', '2022-01-11 15:53:29', b'0');
INSERT INTO `sys_dict_item` VALUES (84, 201, '超时登出', '201', 'sys_login_type', 1, '超时登出', '1', '2021-10-06 00:53:17', '1', '2022-01-11 15:53:29', b'0');
INSERT INTO `sys_dict_item` VALUES (85, 202, '强制登出', '202', 'sys_login_type', 1, '强制退出', '1', '2021-10-06 00:53:41', '1', '2022-01-11 15:53:29', b'0');
INSERT INTO `sys_dict_item` VALUES (86, 0, '病假', '1', 'oa_leave_type', 1, NULL, '1', '2021-09-21 22:35:28', '1', '2022-01-11 15:53:29', b'0');
INSERT INTO `sys_dict_item` VALUES (87, 1, '事假', '2', 'oa_leave_type', 1, NULL, '1', '2021-09-21 22:36:11', '1', '2022-01-11 15:53:29', b'0');
INSERT INTO `sys_dict_item` VALUES (88, 2, '婚假', '3', 'oa_leave_type', 1, NULL, '1', '2021-09-21 22:36:38', '1', '2022-01-11 15:53:29', b'0');
INSERT INTO `sys_dict_item` VALUES (89, 0, '处理中', '1', 'oa_leave_status', 1, NULL, '1', '2021-09-21 22:46:46', '1', '2022-01-11 15:53:29', b'0');
INSERT INTO `sys_dict_item` VALUES (90, 1, '流程结束', '2', 'oa_leave_status', 1, NULL, '1', '2021-09-21 22:47:03', '1', '2022-01-11 15:53:29', b'0');
INSERT INTO `sys_dict_item` VALUES (91, 2, '完成', '3', 'oa_leave_status', 1, NULL, '1', '2021-09-21 22:47:25', '1', '2022-01-11 15:53:29', b'1');

-- ----------------------------
-- Table structure for sys_job
-- ----------------------------
DROP TABLE IF EXISTS `sys_job`;
CREATE TABLE `sys_job`  (
  `job_id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '任务编号',
  `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '任务名称',
  `status` tinyint(0) NOT NULL COMMENT '任务状态',
  `handler_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '处理器的名字',
  `handler_param` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '处理器的参数',
  `cron_expression` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'CRON 表达式',
  `retry_count` int(0) NOT NULL DEFAULT 0 COMMENT '重试次数',
  `retry_interval` int(0) NOT NULL DEFAULT 0 COMMENT '重试间隔',
  `monitor_timeout` int(0) NOT NULL DEFAULT 0 COMMENT '监控超时时间',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  PRIMARY KEY (`job_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '定时任务表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_job
-- ----------------------------
INSERT INTO `sys_job` VALUES (10, 'test', 1, 'test', 'eeee', '0/5 * * * * ? *', 1, 1, 1, 'admin', '2022-01-21 17:34:03', 'admin', '2022-01-21 17:48:43', b'0');

-- ----------------------------
-- Table structure for sys_job_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_job_log`;
CREATE TABLE `sys_job_log`  (
  `job_log_id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '日志编号',
  `job_id` bigint(0) NOT NULL COMMENT '任务编号',
  `handler_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '处理器的名字',
  `handler_param` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '处理器的参数',
  `execute_index` tinyint(0) NULL DEFAULT 1 COMMENT '第几次执行',
  `begin_time` datetime(0) NULL DEFAULT NULL COMMENT '开始执行时间',
  `end_time` datetime(0) NULL DEFAULT NULL COMMENT '结束执行时间',
  `duration` int(0) NULL DEFAULT NULL COMMENT '执行时长',
  `status` tinyint(0) NOT NULL COMMENT '任务状态',
  `result` varchar(4000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '结果数据',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  PRIMARY KEY (`job_log_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 35 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '定时任务日志表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_job_log
-- ----------------------------
INSERT INTO `sys_job_log` VALUES (1, 1, '1', '1', 1, '2022-01-23 19:27:46', '2022-01-20 19:27:50', 1, 1, '1', '1', '2022-02-02 19:27:08', '', '2022-02-02 19:27:22', b'0');
INSERT INTO `sys_job_log` VALUES (2, 6, 'test', NULL, 1, NULL, NULL, 0, 0, '', '', '2022-01-21 16:11:05', '', '2022-01-21 16:11:05', b'0');
INSERT INTO `sys_job_log` VALUES (3, 6, 'test', NULL, 1, NULL, NULL, 0, 0, '', '', '2022-01-21 16:11:10', '', '2022-01-21 16:11:10', b'0');
INSERT INTO `sys_job_log` VALUES (4, 6, 'test', NULL, 1, NULL, NULL, 1, 0, '', '', '2022-01-21 16:11:15', '', '2022-01-21 16:11:15', b'0');
INSERT INTO `sys_job_log` VALUES (5, 6, 'test', NULL, 1, NULL, NULL, 1, 0, '', '', '2022-01-21 16:11:20', '', '2022-01-21 16:11:20', b'0');
INSERT INTO `sys_job_log` VALUES (6, 6, 'test', NULL, 1, NULL, NULL, 0, 0, '', '', '2022-01-21 16:11:25', '', '2022-01-21 16:11:25', b'0');
INSERT INTO `sys_job_log` VALUES (7, 6, 'test', NULL, 1, NULL, NULL, 0, 0, '', '', '2022-01-21 16:11:30', '', '2022-01-21 16:11:30', b'0');
INSERT INTO `sys_job_log` VALUES (8, 6, 'test', NULL, 1, NULL, NULL, 0, 0, '', '', '2022-01-21 16:11:35', '', '2022-01-21 16:11:35', b'0');
INSERT INTO `sys_job_log` VALUES (9, 7, 'test', 'sssss', 1, NULL, NULL, 0, 0, '', '', '2022-01-21 16:12:15', '', '2022-01-21 16:12:15', b'0');
INSERT INTO `sys_job_log` VALUES (10, 7, 'test', 'sssss', 1, NULL, NULL, 0, 0, '', '', '2022-01-21 16:12:20', '', '2022-01-21 16:12:20', b'0');
INSERT INTO `sys_job_log` VALUES (11, 7, 'test', 'sssss', 1, NULL, NULL, 0, 0, '', '', '2022-01-21 16:12:25', '', '2022-01-21 16:12:25', b'0');
INSERT INTO `sys_job_log` VALUES (12, 7, 'test', 'sssss', 1, NULL, NULL, 1, 0, '', '', '2022-01-21 16:12:30', '', '2022-01-21 16:12:30', b'0');
INSERT INTO `sys_job_log` VALUES (13, 8, 'tests', 'test', 1, NULL, NULL, 1, 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'tests\' available', '', '2022-01-21 16:12:50', '', '2022-01-21 16:12:50', b'0');
INSERT INTO `sys_job_log` VALUES (14, 8, 'tests', 'test', 1, NULL, NULL, 2, 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'tests\' available', '', '2022-01-21 16:12:55', '', '2022-01-21 16:12:55', b'0');
INSERT INTO `sys_job_log` VALUES (15, 8, 'tests', 'test', 1, NULL, NULL, 1, 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'tests\' available', '', '2022-01-21 16:13:00', '', '2022-01-21 16:13:00', b'0');
INSERT INTO `sys_job_log` VALUES (16, 8, 'tests', 'test', 1, NULL, NULL, 1, 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'tests\' available', '', '2022-01-21 16:13:05', '', '2022-01-21 16:13:05', b'0');
INSERT INTO `sys_job_log` VALUES (17, 8, 'tests', 'test', 1, NULL, NULL, 1, 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'tests\' available', '', '2022-01-21 16:13:10', '', '2022-01-21 16:13:10', b'0');
INSERT INTO `sys_job_log` VALUES (18, 8, 'tests', 'test', 1, NULL, NULL, 1, 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'tests\' available', '', '2022-01-21 16:13:15', '', '2022-01-21 16:13:15', b'0');
INSERT INTO `sys_job_log` VALUES (19, 8, 'tests', 'test', 1, NULL, NULL, 0, 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'tests\' available', '', '2022-01-21 16:13:20', '', '2022-01-21 16:13:20', b'0');
INSERT INTO `sys_job_log` VALUES (20, 8, 'tests', 'test', 1, NULL, NULL, 1, 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'tests\' available', '', '2022-01-21 16:13:25', '', '2022-01-21 16:13:25', b'0');
INSERT INTO `sys_job_log` VALUES (21, 8, 'tests', 'test', 1, NULL, NULL, 1, 1, 'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'tests\' available', '', '2022-01-21 16:13:30', '', '2022-01-21 16:13:30', b'0');
INSERT INTO `sys_job_log` VALUES (22, 9, 'test', 'test', 1, NULL, NULL, 0, 0, '', '', '2022-01-21 17:27:01', '', '2022-01-21 17:27:01', b'0');
INSERT INTO `sys_job_log` VALUES (23, 9, 'test', 'test', 1, NULL, NULL, 1, 0, '', '', '2022-01-21 17:28:40', '', '2022-01-21 17:28:40', b'0');
INSERT INTO `sys_job_log` VALUES (24, 9, 'test', 'test', 1, NULL, NULL, 0, 0, '', '', '2022-01-21 17:28:45', '', '2022-01-21 17:28:45', b'0');
INSERT INTO `sys_job_log` VALUES (25, 9, 'test', 'test', 1, NULL, NULL, 0, 0, '', '', '2022-01-21 17:28:50', '', '2022-01-21 17:28:50', b'0');
INSERT INTO `sys_job_log` VALUES (26, 9, 'test', 'test', 1, NULL, NULL, 1, 0, '', '', '2022-01-21 17:28:55', '', '2022-01-21 17:28:55', b'0');
INSERT INTO `sys_job_log` VALUES (27, 10, 'test', 'eeee', 1, NULL, NULL, 0, 0, '', '', '2022-01-21 17:34:10', '', '2022-01-21 17:34:10', b'0');
INSERT INTO `sys_job_log` VALUES (28, 10, 'test', 'eeee', 1, NULL, NULL, 1, 0, '', '', '2022-01-21 17:35:00', '', '2022-01-21 17:35:00', b'0');
INSERT INTO `sys_job_log` VALUES (29, 10, 'test', 'eeee', 1, NULL, NULL, 0, 0, '', '', '2022-01-21 17:36:00', '', '2022-01-21 17:36:00', b'0');
INSERT INTO `sys_job_log` VALUES (30, 10, 'test', 'eeee', 1, NULL, NULL, 0, 0, '', '', '2022-01-21 17:37:00', '', '2022-01-21 17:37:00', b'0');
INSERT INTO `sys_job_log` VALUES (31, 10, 'test', 'eeee', 1, NULL, NULL, 1, 0, '', '', '2022-01-21 17:37:52', '', '2022-01-21 17:37:52', b'0');
INSERT INTO `sys_job_log` VALUES (32, 10, 'test', 'eeee', 1, NULL, NULL, 0, 0, '', '', '2022-01-21 17:38:00', '', '2022-01-21 17:38:00', b'0');
INSERT INTO `sys_job_log` VALUES (33, 10, 'test', 'eeee', 1, NULL, NULL, 0, 0, '', '', '2022-01-21 17:47:00', '', '2022-01-21 17:47:00', b'0');
INSERT INTO `sys_job_log` VALUES (34, 10, 'test', 'eeee', 1, NULL, NULL, 0, 0, '', '', '2022-01-21 17:48:00', '', '2022-01-21 17:48:00', b'0');

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log`  (
  `log_id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '日志编号',
  `type` char(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '1' COMMENT '日志类型',
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '日志标题',
  `ip` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '操作地址',
  `request` json NULL COMMENT '请求信息',
  `response` json NULL COMMENT '请求信息',
  `exception` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '响应信息',
  `time` mediumtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '执行时间',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
  `deleted` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '删除标记',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '状态：0成功、1失败',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`log_id`) USING BTREE,
  INDEX `sys_log_create_by`(`create_by`) USING BTREE,
  INDEX `sys_log_type`(`type`) USING BTREE,
  INDEX `sys_log_create_date`(`create_time`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 140 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '日志表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_log
-- ----------------------------
INSERT INTO `sys_log` VALUES (18, '操作日志', '新增用户', '10.200.47.47', '{\"className\": \"com.qinweizhao.system.module.manage.controller.SysUserController\", \"methodName\": \"delete\"}', '{\"className\": \"com.qinweizhao.system.module.manage.controller.SysUserController\", \"methodName\": \"delete\"}', '\r\n### Error updating database.  Cause: java.sql.SQLIntegrityConstraintViolationException: Duplicate entry \'1\' for key \'sys_user.username\'\r\n### The error may exist in com/qinweizhao/system/module/manage/mapper/SysUserMapper.java (best guess)\r\n### The error may involve com.qinweizhao.system.module.manage.mapper.SysUserMapper.insert-Inline\r\n### The error occurred while setting parameters\r\n### SQL: INSERT INTO sys_user  ( username, password, nick_name, sex, phone,     status )  VALUES  ( ?, ?, ?, ?, ?,     ? )\r\n### Cause: java.sql.SQLIntegrityConstraintViolationException: Duplicate entry \'1\' for key \'sys_user.username\'\n; Duplicate entry \'1\' for key \'sys_user.username\'; nested exception is java.sql.SQLIntegrityConstraintViolationException: Duplicate entry \'1\' for key \'sys_user.username\'', '1', NULL, '0', '0', 'admin', 'admin', '2022-01-20 14:35:08', NULL);
INSERT INTO `sys_log` VALUES (19, '操作日志', '新增用户', '10.200.47.47', '{\"className\": \"com.qinweizhao.system.module.manage.controller.SysUserController\", \"methodName\": \"delete\"}', '{\"className\": \"com.qinweizhao.system.module.manage.controller.SysUserController\", \"methodName\": \"delete\"}', '\r\n### Error updating database.  Cause: java.sql.SQLIntegrityConstraintViolationException: Duplicate entry \'1\' for key \'sys_user.username\'\r\n### The error may exist in com/qinweizhao/system/module/manage/mapper/SysUserMapper.java (best guess)\r\n### The error may involve com.qinweizhao.system.module.manage.mapper.SysUserMapper.insert-Inline\r\n### The error occurred while setting parameters\r\n### SQL: INSERT INTO sys_user  ( username, password, nick_name, sex, phone,     status )  VALUES  ( ?, ?, ?, ?, ?,     ? )\r\n### Cause: java.sql.SQLIntegrityConstraintViolationException: Duplicate entry \'1\' for key \'sys_user.username\'\n; Duplicate entry \'1\' for key \'sys_user.username\'; nested exception is java.sql.SQLIntegrityConstraintViolationException: Duplicate entry \'1\' for key \'sys_user.username\'', '1', NULL, '0', '0', 'admin', 'admin', '2022-01-20 14:35:08', NULL);
INSERT INTO `sys_log` VALUES (20, '操作日志', '新增用户', '10.200.47.47', '{\"className\": \"com.qinweizhao.system.module.manage.controller.SysUserController\", \"methodName\": \"delete\"}', '{\"className\": \"com.qinweizhao.system.module.manage.controller.SysUserController\", \"methodName\": \"delete\"}', NULL, '1', NULL, '0', '1', 'admin', 'admin', '2022-01-20 14:35:08', NULL);
INSERT INTO `sys_log` VALUES (21, '操作日志', '删除用户', '10.200.47.47', '{\"className\": \"com.qinweizhao.system.module.manage.controller.SysUserController\", \"methodName\": \"delete\"}', '{\"className\": \"com.qinweizhao.system.module.manage.controller.SysUserController\", \"methodName\": \"delete\"}', NULL, '1', NULL, '0', '1', 'admin', 'admin', '2022-01-20 14:35:08', NULL);
INSERT INTO `sys_log` VALUES (22, '操作日志', '删除用户', '10.200.47.47', '{\"className\": \"com.qinweizhao.system.module.manage.controller.SysUserController\", \"methodName\": \"delete\"}', '{\"className\": \"com.qinweizhao.system.module.manage.controller.SysUserController\", \"methodName\": \"delete\"}', NULL, '1', NULL, '0', '1', 'admin', 'admin', '2022-01-20 14:35:08', NULL);
INSERT INTO `sys_log` VALUES (23, '操作日志', '新增用户', '10.200.47.47', '{\"path\": \"/sys/user/save\", \"method\": \"POST\", \"className\": \"com.qinweizhao.system.module.manage.controller.SysUserController\", \"methodName\": \"save\"}', NULL, NULL, '1', NULL, '0', '1', 'admin', 'admin', '2022-01-20 14:35:08', NULL);
INSERT INTO `sys_log` VALUES (24, '操作日志', '新增用户', '10.200.47.47', '{\"path\": \"/sys/user/save\", \"method\": \"POST\", \"className\": \"com.qinweizhao.system.module.manage.controller.SysUserController\", \"methodName\": \"save\"}', NULL, '\r\n### Error updating database.  Cause: java.sql.SQLIntegrityConstraintViolationException: Duplicate entry \'1111\' for key \'sys_user.username\'\r\n### The error may exist in com/qinweizhao/system/module/manage/mapper/SysUserMapper.java (best guess)\r\n### The error may involve com.qinweizhao.system.module.manage.mapper.SysUserMapper.insert-Inline\r\n### The error occurred while setting parameters\r\n### SQL: INSERT INTO sys_user  ( username, password, nick_name,       status )  VALUES  ( ?, ?, ?,       ? )\r\n### Cause: java.sql.SQLIntegrityConstraintViolationException: Duplicate entry \'1111\' for key \'sys_user.username\'\n; Duplicate entry \'1111\' for key \'sys_user.username\'; nested exception is java.sql.SQLIntegrityConstraintViolationException: Duplicate entry \'1111\' for key \'sys_user.username\'', '1', NULL, '0', '0', 'admin', 'admin', '2022-01-20 14:35:08', NULL);
INSERT INTO `sys_log` VALUES (25, '操作日志', '新增用户', '10.200.47.47', '{\"path\": \"/system/manage/user/save\", \"method\": \"POST\", \"className\": \"com.qinweizhao.system.module.manage.controller.SysUserController\", \"methodName\": \"save\"}', NULL, '\r\n### Error updating database.  Cause: java.sql.SQLSyntaxErrorException: You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near \'\' at line 1\r\n### The error may exist in com/qinweizhao/system/module/manage/mapper/SysUserMapper.java (best guess)\r\n### The error may involve com.qinweizhao.system.module.manage.mapper.SysUserMapper.insert-Inline\r\n### The error occurred while setting parameters\r\n### SQL: INSERT INTO sys_user    VALUES\r\n### Cause: java.sql.SQLSyntaxErrorException: You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near \'\' at line 1\n; bad SQL grammar []; nested exception is java.sql.SQLSyntaxErrorException: You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near \'\' at line 1', '1', NULL, '0', '0', 'admin', 'admin', '2022-01-20 14:35:08', NULL);
INSERT INTO `sys_log` VALUES (26, '操作日志', '新增用户', '10.200.47.47', '{\"path\": \"/system/manage/user/save\", \"method\": \"POST\", \"className\": \"com.qinweizhao.system.module.manage.controller.SysUserController\", \"methodName\": \"save\"}', NULL, '\r\n### Error updating database.  Cause: java.sql.SQLSyntaxErrorException: You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near \'\' at line 1\r\n### The error may exist in com/qinweizhao/system/module/manage/mapper/SysUserMapper.java (best guess)\r\n### The error may involve com.qinweizhao.system.module.manage.mapper.SysUserMapper.insert-Inline\r\n### The error occurred while setting parameters\r\n### SQL: INSERT INTO sys_user    VALUES\r\n### Cause: java.sql.SQLSyntaxErrorException: You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near \'\' at line 1\n; bad SQL grammar []; nested exception is java.sql.SQLSyntaxErrorException: You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near \'\' at line 1', '1', NULL, '0', '0', 'admin', 'admin', '2022-01-20 14:35:08', NULL);
INSERT INTO `sys_log` VALUES (27, '操作日志', '新增用户', '10.200.47.47', '{\"path\": \"/system/manage/user/save\", \"method\": \"POST\", \"className\": \"com.qinweizhao.system.module.manage.controller.SysUserController\", \"methodName\": \"save\"}', NULL, '\r\n### Error updating database.  Cause: java.sql.SQLSyntaxErrorException: You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near \'\' at line 1\r\n### The error may exist in com/qinweizhao/system/module/manage/mapper/SysUserMapper.java (best guess)\r\n### The error may involve com.qinweizhao.system.module.manage.mapper.SysUserMapper.insert-Inline\r\n### The error occurred while setting parameters\r\n### SQL: INSERT INTO sys_user    VALUES\r\n### Cause: java.sql.SQLSyntaxErrorException: You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near \'\' at line 1\n; bad SQL grammar []; nested exception is java.sql.SQLSyntaxErrorException: You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near \'\' at line 1', '1', NULL, '0', '0', 'admin', 'admin', '2022-01-20 14:35:08', NULL);
INSERT INTO `sys_log` VALUES (28, '操作日志', '新增用户', '10.200.47.47', '{\"path\": \"/system/manage/user/save\", \"method\": \"POST\", \"className\": \"com.qinweizhao.system.module.manage.controller.SysUserController\", \"methodName\": \"save\"}', NULL, '\r\n### Error updating database.  Cause: java.sql.SQLIntegrityConstraintViolationException: Column \'user_id\' cannot be null\r\n### The error may exist in file [E:\\Code\\qwz-calf\\calf-backend\\calf-platform\\calf-platform-system\\target\\classes\\mapper\\manage\\SysUserPostMapper.xml]\r\n### The error may involve defaultParameterMap\r\n### The error occurred while setting parameters\r\n### SQL: insert into sys_user_post(user_id, post_id) values                        (?,?)\r\n### Cause: java.sql.SQLIntegrityConstraintViolationException: Column \'user_id\' cannot be null\n; Column \'user_id\' cannot be null; nested exception is java.sql.SQLIntegrityConstraintViolationException: Column \'user_id\' cannot be null', '1', NULL, '0', '0', 'admin', 'admin', '2022-01-20 14:35:08', NULL);
INSERT INTO `sys_log` VALUES (29, '操作日志', '新增用户', '10.200.47.47', '{\"path\": \"/system/manage/user/save\", \"method\": \"POST\", \"className\": \"com.qinweizhao.system.module.manage.controller.SysUserController\", \"methodName\": \"save\"}', NULL, '用户账号已经存在', '1', NULL, '0', '0', 'admin', 'admin', '2022-01-20 14:35:08', NULL);
INSERT INTO `sys_log` VALUES (30, '操作日志', '新增用户', '10.200.47.47', '{\"path\": \"/system/manage/user/save\", \"method\": \"POST\", \"className\": \"com.qinweizhao.system.module.manage.controller.SysUserController\", \"methodName\": \"save\"}', NULL, '用户账号已经存在', '1', NULL, '0', '0', 'admin', 'admin', '2022-01-20 14:35:08', NULL);
INSERT INTO `sys_log` VALUES (31, '操作日志', '新增用户', '10.200.47.47', '{\"path\": \"/system/manage/user/save\", \"method\": \"POST\", \"className\": \"com.qinweizhao.system.module.manage.controller.SysUserController\", \"methodName\": \"save\"}', NULL, '用户账号已经存在', '1', NULL, '0', '0', 'admin', 'admin', '2022-01-20 14:35:08', NULL);
INSERT INTO `sys_log` VALUES (32, '操作日志', '新增用户', '10.200.47.47', '{\"path\": \"/system/manage/user/save\", \"method\": \"POST\", \"className\": \"com.qinweizhao.system.module.manage.controller.SysUserController\", \"methodName\": \"save\"}', NULL, '\r\n### Error updating database.  Cause: java.sql.SQLIntegrityConstraintViolationException: Column \'user_id\' cannot be null\r\n### The error may exist in file [E:\\Code\\qwz-calf\\calf-backend\\calf-platform\\calf-platform-system\\target\\classes\\mapper\\manage\\SysUserPostMapper.xml]\r\n### The error may involve defaultParameterMap\r\n### The error occurred while setting parameters\r\n### SQL: insert into sys_user_post(user_id, post_id) values                        (?,?)\r\n### Cause: java.sql.SQLIntegrityConstraintViolationException: Column \'user_id\' cannot be null\n; Column \'user_id\' cannot be null; nested exception is java.sql.SQLIntegrityConstraintViolationException: Column \'user_id\' cannot be null', '1', NULL, '0', '0', 'admin', 'admin', '2022-01-20 14:35:08', NULL);
INSERT INTO `sys_log` VALUES (33, '操作日志', '新增用户', '10.200.47.47', '{\"path\": \"/system/manage/user/save\", \"method\": \"POST\", \"className\": \"com.qinweizhao.system.module.manage.controller.SysUserController\", \"methodName\": \"save\"}', NULL, '用户账号已经存在', '1', NULL, '0', '0', 'admin', 'admin', '2022-01-20 14:35:08', NULL);
INSERT INTO `sys_log` VALUES (34, '操作日志', '新增用户', '10.200.47.47', '{\"path\": \"/system/manage/user/save\", \"method\": \"POST\", \"className\": \"com.qinweizhao.system.module.manage.controller.SysUserController\", \"methodName\": \"save\"}', NULL, '用户账号已经存在', '1', NULL, '0', '0', 'admin', 'admin', '2022-01-20 14:35:08', NULL);
INSERT INTO `sys_log` VALUES (35, '操作日志', '新增用户', '10.200.47.47', '{\"path\": \"/system/manage/user/save\", \"method\": \"POST\", \"className\": \"com.qinweizhao.system.module.manage.controller.SysUserController\", \"methodName\": \"save\"}', NULL, '用户账号已经存在', '1', NULL, '0', '0', 'admin', 'admin', '2022-01-20 14:35:08', NULL);
INSERT INTO `sys_log` VALUES (36, '操作日志', '新增用户', '10.200.47.47', '{\"path\": \"/system/manage/user/save\", \"method\": \"POST\", \"className\": \"com.qinweizhao.system.module.manage.controller.SysUserController\", \"methodName\": \"save\"}', NULL, '用户账号已经存在', '1', NULL, '0', '0', 'admin', 'admin', '2022-01-20 14:35:08', NULL);
INSERT INTO `sys_log` VALUES (37, '操作日志', '新增用户', '10.200.47.47', '{\"path\": \"/system/manage/user/save\", \"method\": \"POST\", \"className\": \"com.qinweizhao.system.module.manage.controller.SysUserController\", \"methodName\": \"save\"}', NULL, '用户账号已经存在', '1', NULL, '0', '0', 'admin', 'admin', '2022-01-20 14:35:08', NULL);
INSERT INTO `sys_log` VALUES (38, '操作日志', '新增用户', '10.200.47.47', '{\"path\": \"/system/manage/user/save\", \"method\": \"POST\", \"className\": \"com.qinweizhao.system.module.manage.controller.SysUserController\", \"methodName\": \"save\"}', NULL, '用户账号已经存在', '1', NULL, '0', '0', 'admin', 'admin', '2022-01-20 14:35:08', NULL);
INSERT INTO `sys_log` VALUES (39, '操作日志', '新增用户', '10.200.47.47', '{\"path\": \"/system/manage/user/save\", \"method\": \"POST\", \"className\": \"com.qinweizhao.system.module.manage.controller.SysUserController\", \"methodName\": \"save\"}', NULL, '用户账号已经存在', '1', NULL, '0', '0', 'admin', 'admin', '2022-01-20 14:35:08', NULL);
INSERT INTO `sys_log` VALUES (40, '操作日志', '新增用户', '10.200.47.47', '{\"path\": \"/system/manage/user/save\", \"method\": \"POST\", \"className\": \"com.qinweizhao.system.module.manage.controller.SysUserController\", \"methodName\": \"save\"}', NULL, NULL, '1', NULL, '0', '1', 'admin', 'admin', '2022-01-20 14:35:08', NULL);
INSERT INTO `sys_log` VALUES (41, '操作日志', '新增用户', '10.200.47.47', '{\"path\": \"/system/manage/user/save\", \"method\": \"POST\", \"className\": \"com.qinweizhao.system.module.manage.controller.SysUserController\", \"methodName\": \"save\"}', NULL, NULL, '1', NULL, '0', '1', 'admin', 'admin', '2022-01-20 14:35:08', NULL);
INSERT INTO `sys_log` VALUES (42, '操作日志', '新增用户', '10.200.47.47', '{\"path\": \"/system/manage/user/save\", \"method\": \"POST\", \"className\": \"com.qinweizhao.system.module.manage.controller.SysUserController\", \"methodName\": \"save\"}', NULL, NULL, '1', NULL, '0', '1', 'admin', 'admin', '2022-01-20 14:35:08', NULL);
INSERT INTO `sys_log` VALUES (43, '操作日志', '新增用户', '10.200.47.47', '{\"path\": \"/system/manage/user/save\", \"method\": \"POST\", \"className\": \"com.qinweizhao.system.module.manage.controller.SysUserController\", \"methodName\": \"save\"}', NULL, '\r\n### Error updating database.  Cause: java.sql.SQLIntegrityConstraintViolationException: Column \'user_id\' cannot be null\r\n### The error may exist in file [E:\\Code\\qwz-calf\\calf-backend\\calf-platform\\calf-platform-system\\target\\classes\\mapper\\manage\\SysUserPostMapper.xml]\r\n### The error may involve defaultParameterMap\r\n### The error occurred while setting parameters\r\n### SQL: insert into sys_user_post(user_id, post_id) values                        (?,?)\r\n### Cause: java.sql.SQLIntegrityConstraintViolationException: Column \'user_id\' cannot be null\n; Column \'user_id\' cannot be null; nested exception is java.sql.SQLIntegrityConstraintViolationException: Column \'user_id\' cannot be null', '1', NULL, '0', '0', 'admin', 'admin', '2022-01-20 14:35:08', NULL);
INSERT INTO `sys_log` VALUES (44, '操作日志', '新增用户', '10.200.47.47', '{\"path\": \"/system/manage/user/save\", \"method\": \"POST\", \"className\": \"com.qinweizhao.system.module.manage.controller.SysUserController\", \"methodName\": \"save\"}', NULL, '用户账号已经存在', '1', NULL, '0', '0', 'admin', 'admin', '2022-01-20 14:35:08', NULL);
INSERT INTO `sys_log` VALUES (45, '操作日志', '新增用户', '10.200.47.47', '{\"path\": \"/system/manage/user/save\", \"method\": \"POST\", \"className\": \"com.qinweizhao.system.module.manage.controller.SysUserController\", \"methodName\": \"save\"}', NULL, '手机号已经存在', '1', NULL, '0', '0', 'admin', 'admin', '2022-01-20 14:35:08', NULL);
INSERT INTO `sys_log` VALUES (46, '操作日志', '新增用户', '10.200.47.47', '{\"path\": \"/system/manage/user/save\", \"method\": \"POST\", \"className\": \"com.qinweizhao.system.module.manage.controller.SysUserController\", \"methodName\": \"save\"}', NULL, '手机号已经存在', '1', NULL, '0', '0', 'admin', 'admin', '2022-01-20 14:35:08', NULL);
INSERT INTO `sys_log` VALUES (47, '操作日志', '新增用户', '10.200.47.47', '{\"path\": \"/system/manage/user/save\", \"method\": \"POST\", \"className\": \"com.qinweizhao.system.module.manage.controller.SysUserController\", \"methodName\": \"save\"}', NULL, '手机号已经存在', '1', NULL, '0', '0', 'admin', 'admin', '2022-01-20 14:35:08', NULL);
INSERT INTO `sys_log` VALUES (48, '操作日志', '新增用户', '10.200.47.47', '{\"path\": \"/system/manage/user/save\", \"method\": \"POST\", \"className\": \"com.qinweizhao.system.module.manage.controller.SysUserController\", \"methodName\": \"save\"}', NULL, '邮箱已经存在', '1', NULL, '0', '0', 'admin', 'admin', '2022-01-20 14:35:08', NULL);
INSERT INTO `sys_log` VALUES (49, '操作日志', '新增用户', '10.200.47.47', '{\"path\": \"/system/manage/user/save\", \"method\": \"POST\", \"className\": \"com.qinweizhao.system.module.manage.controller.SysUserController\", \"methodName\": \"save\"}', NULL, '\r\n### Error updating database.  Cause: java.sql.SQLIntegrityConstraintViolationException: Column \'user_id\' cannot be null\r\n### The error may exist in file [E:\\Code\\qwz-calf\\calf-backend\\calf-platform\\calf-platform-system\\target\\classes\\mapper\\manage\\SysUserPostMapper.xml]\r\n### The error may involve defaultParameterMap\r\n### The error occurred while setting parameters\r\n### SQL: insert into sys_user_post(user_id, post_id) values                        (?,?)\r\n### Cause: java.sql.SQLIntegrityConstraintViolationException: Column \'user_id\' cannot be null\n; Column \'user_id\' cannot be null; nested exception is java.sql.SQLIntegrityConstraintViolationException: Column \'user_id\' cannot be null', '1', NULL, '0', '0', 'admin', 'admin', '2022-01-20 14:35:08', NULL);
INSERT INTO `sys_log` VALUES (50, '操作日志', '新增用户', '10.200.47.47', '{\"path\": \"/system/manage/user/save\", \"method\": \"POST\", \"className\": \"com.qinweizhao.system.module.manage.controller.SysUserController\", \"methodName\": \"save\"}', NULL, '用户账号已经存在', '1', NULL, '0', '0', 'admin', 'admin', '2022-01-20 14:35:08', NULL);
INSERT INTO `sys_log` VALUES (51, '操作日志', '新增用户', '10.200.47.47', '{\"path\": \"/system/manage/user/save\", \"method\": \"POST\", \"className\": \"com.qinweizhao.system.module.manage.controller.SysUserController\", \"methodName\": \"save\"}', NULL, '用户账号已经存在', '1', NULL, '0', '0', 'admin', 'admin', '2022-01-20 14:35:08', NULL);
INSERT INTO `sys_log` VALUES (52, '操作日志', '新增用户', '10.200.47.47', '{\"path\": \"/system/manage/user/save\", \"method\": \"POST\", \"className\": \"com.qinweizhao.system.module.manage.controller.SysUserController\", \"methodName\": \"save\"}', NULL, '\r\n### Error updating database.  Cause: java.sql.SQLIntegrityConstraintViolationException: Column \'user_id\' cannot be null\r\n### The error may exist in file [E:\\Code\\qwz-calf\\calf-backend\\calf-platform\\calf-platform-system\\target\\classes\\mapper\\manage\\SysUserPostMapper.xml]\r\n### The error may involve defaultParameterMap\r\n### The error occurred while setting parameters\r\n### SQL: insert into sys_user_post(user_id, post_id) values                        (?,?)\r\n### Cause: java.sql.SQLIntegrityConstraintViolationException: Column \'user_id\' cannot be null\n; Column \'user_id\' cannot be null; nested exception is java.sql.SQLIntegrityConstraintViolationException: Column \'user_id\' cannot be null', '1', NULL, '0', '0', 'admin', 'admin', '2022-01-20 14:35:08', NULL);
INSERT INTO `sys_log` VALUES (53, '操作日志', '新增用户', '10.200.47.47', '{\"path\": \"/system/manage/user/save\", \"method\": \"POST\", \"className\": \"com.qinweizhao.system.module.manage.controller.SysUserController\", \"methodName\": \"save\"}', NULL, NULL, '1', NULL, '0', '1', 'admin', 'admin', '2022-01-20 14:35:08', NULL);
INSERT INTO `sys_log` VALUES (54, '操作日志', '删除用户', '10.200.47.47', '{\"path\": \"/system/manage/user/delete\", \"method\": \"DELETE\", \"className\": \"com.qinweizhao.system.module.manage.controller.SysUserController\", \"methodName\": \"delete\"}', NULL, NULL, '1', NULL, '0', '1', 'admin', 'admin', '2022-01-20 14:35:08', NULL);
INSERT INTO `sys_log` VALUES (55, '操作日志', '新增用户', '10.200.47.47', '{\"path\": \"/system/manage/user/save\", \"method\": \"POST\", \"className\": \"com.qinweizhao.system.module.manage.controller.SysUserController\", \"methodName\": \"save\"}', NULL, NULL, '1', NULL, '0', '1', 'admin', 'admin', '2022-01-20 14:35:08', NULL);
INSERT INTO `sys_log` VALUES (56, '操作日志', '新增用户', '10.200.47.47', '{\"path\": \"/system/manage/user/save\", \"method\": \"POST\", \"className\": \"com.qinweizhao.system.module.manage.controller.SysUserController\", \"methodName\": \"save\"}', NULL, NULL, '1', NULL, '0', '1', 'admin', 'admin', '2022-01-20 14:35:08', NULL);
INSERT INTO `sys_log` VALUES (57, '操作日志', '新增用户', '10.200.47.47', '{\"path\": \"/system/manage/user/save\", \"method\": \"POST\", \"className\": \"com.qinweizhao.system.module.manage.controller.SysUserController\", \"methodName\": \"save\"}', NULL, '用户账号已经存在', '1', NULL, '0', '0', 'admin', 'admin', '2022-01-20 14:35:08', NULL);
INSERT INTO `sys_log` VALUES (58, '操作日志', '新增用户', '10.200.47.47', '{\"path\": \"/system/manage/user/save\", \"method\": \"POST\", \"className\": \"com.qinweizhao.system.module.manage.controller.SysUserController\", \"methodName\": \"save\"}', NULL, NULL, '1', NULL, '0', '1', 'admin', 'admin', '2022-01-20 14:35:08', NULL);
INSERT INTO `sys_log` VALUES (59, '操作日志', '新增用户', '10.200.47.47', '{\"path\": \"/system/manage/user/save\", \"method\": \"POST\", \"className\": \"com.qinweizhao.system.module.manage.controller.SysUserController\", \"methodName\": \"save\"}', NULL, NULL, '1', NULL, '0', '1', 'admin', 'admin', '2022-01-20 14:35:08', NULL);
INSERT INTO `sys_log` VALUES (60, '操作日志', '新增用户', '10.200.47.47', '{\"path\": \"/system/manage/user/save\", \"method\": \"POST\", \"className\": \"com.qinweizhao.system.module.manage.controller.SysUserController\", \"methodName\": \"save\"}', NULL, NULL, '1', NULL, '0', '1', 'admin', 'admin', '2022-01-20 14:35:08', NULL);
INSERT INTO `sys_log` VALUES (61, '操作日志', '新增用户', '10.200.47.47', '{\"path\": \"/system/manage/user/save\", \"method\": \"POST\", \"className\": \"com.qinweizhao.system.module.manage.controller.SysUserController\", \"methodName\": \"save\"}', NULL, NULL, '1', NULL, '0', '1', 'admin', 'admin', '2022-01-20 14:35:08', NULL);
INSERT INTO `sys_log` VALUES (62, '操作日志', '新增用户', '10.200.47.47', '{\"path\": \"/system/manage/user/save\", \"method\": \"POST\", \"className\": \"com.qinweizhao.system.module.manage.controller.SysUserController\", \"methodName\": \"save\"}', NULL, NULL, '1', NULL, '0', '1', 'admin', 'admin', '2022-01-20 14:35:08', NULL);
INSERT INTO `sys_log` VALUES (63, '操作日志', '删除用户', '10.200.47.47', '{\"path\": \"/system/manage/user/delete\", \"method\": \"DELETE\", \"className\": \"com.qinweizhao.system.module.manage.controller.SysUserController\", \"methodName\": \"delete\"}', NULL, NULL, '1', NULL, '0', '1', 'admin', 'admin', '2022-01-20 14:35:08', NULL);
INSERT INTO `sys_log` VALUES (64, '操作日志', '删除用户', '10.200.47.47', '{\"path\": \"/system/manage/user/delete\", \"method\": \"DELETE\", \"className\": \"com.qinweizhao.system.module.manage.controller.SysUserController\", \"methodName\": \"delete\"}', NULL, NULL, '1', NULL, '0', '1', 'admin', 'admin', '2022-01-20 14:35:08', NULL);
INSERT INTO `sys_log` VALUES (65, '操作日志', '新增用户', '10.200.47.47', '{\"path\": \"/system/manage/user/save\", \"method\": \"POST\", \"className\": \"com.qinweizhao.system.module.manage.controller.SysUserController\", \"methodName\": \"save\"}', NULL, NULL, '1', NULL, '0', '1', 'admin', 'admin', '2022-01-20 14:35:08', NULL);
INSERT INTO `sys_log` VALUES (66, '操作日志', '新增用户', '10.200.47.47', '{\"path\": \"/system/manage/user/save\", \"method\": \"POST\", \"className\": \"com.qinweizhao.system.module.manage.controller.SysUserController\", \"methodName\": \"save\"}', NULL, NULL, '1', NULL, '0', '1', 'admin', 'admin', '2022-01-20 14:35:08', NULL);
INSERT INTO `sys_log` VALUES (67, '操作日志', '新增用户', '10.200.47.47', '{\"path\": \"/system/manage/user/save\", \"method\": \"POST\", \"className\": \"com.qinweizhao.system.module.manage.controller.SysUserController\", \"methodName\": \"save\"}', NULL, NULL, '1', NULL, '0', '1', 'admin', 'admin', '2022-01-20 14:35:08', NULL);
INSERT INTO `sys_log` VALUES (68, '操作日志', '新增用户', '10.200.47.47', '{\"path\": \"/system/manage/user/save\", \"method\": \"POST\", \"className\": \"com.qinweizhao.system.module.manage.controller.SysUserController\", \"methodName\": \"save\"}', NULL, '邮箱已经存在', '1', NULL, '0', '0', 'admin', 'admin', '2022-01-20 14:35:08', NULL);
INSERT INTO `sys_log` VALUES (69, '操作日志', '新增用户', '10.200.47.47', '{\"path\": \"/system/manage/user/save\", \"method\": \"POST\", \"className\": \"com.qinweizhao.system.module.manage.controller.SysUserController\", \"methodName\": \"save\"}', NULL, NULL, '1', NULL, '0', '1', 'admin', 'admin', '2022-01-20 14:35:08', NULL);
INSERT INTO `sys_log` VALUES (70, '操作日志', '新增用户', '10.200.47.47', '{\"path\": \"/system/manage/user/save\", \"method\": \"POST\", \"className\": \"com.qinweizhao.system.module.manage.controller.SysUserController\", \"methodName\": \"save\"}', NULL, NULL, '1', NULL, '0', '1', 'admin', 'admin', '2022-01-20 14:35:08', NULL);
INSERT INTO `sys_log` VALUES (71, '操作日志', '编辑用户', '10.200.47.47', '{\"path\": \"/system/manage/user/update\", \"method\": \"PUT\", \"className\": \"com.qinweizhao.system.module.manage.controller.SysUserController\", \"methodName\": \"edit\"}', NULL, '当前岗位不存在', '1', NULL, '0', '0', 'admin', 'admin', '2022-01-20 14:35:08', NULL);
INSERT INTO `sys_log` VALUES (72, '操作日志', '编辑用户', '10.200.47.47', '{\"path\": \"/system/manage/user/update\", \"method\": \"PUT\", \"className\": \"com.qinweizhao.system.module.manage.controller.SysUserController\", \"methodName\": \"edit\"}', NULL, '当前岗位不存在', '1', NULL, '0', '0', 'admin', 'admin', '2022-01-20 14:35:08', NULL);
INSERT INTO `sys_log` VALUES (73, '操作日志', '编辑用户', '10.200.47.47', '{\"path\": \"/system/manage/user/update\", \"method\": \"PUT\", \"className\": \"com.qinweizhao.system.module.manage.controller.SysUserController\", \"methodName\": \"edit\"}', NULL, '当前岗位不存在', '1', NULL, '0', '0', 'admin', 'admin', '2022-01-20 14:35:08', NULL);
INSERT INTO `sys_log` VALUES (74, '操作日志', '编辑用户', '10.200.47.47', '{\"path\": \"/system/manage/user/update\", \"method\": \"PUT\", \"className\": \"com.qinweizhao.system.module.manage.controller.SysUserController\", \"methodName\": \"edit\"}', NULL, '当前岗位不存在', '1', NULL, '0', '0', 'admin', 'admin', '2022-01-20 14:35:08', NULL);
INSERT INTO `sys_log` VALUES (75, '操作日志', '编辑用户', '10.200.47.47', '{\"path\": \"/system/manage/user/update\", \"method\": \"PUT\", \"className\": \"com.qinweizhao.system.module.manage.controller.SysUserController\", \"methodName\": \"edit\"}', NULL, '当前岗位不存在', '1', NULL, '0', '0', 'admin', 'admin', '2022-01-20 14:35:08', NULL);
INSERT INTO `sys_log` VALUES (76, '操作日志', '编辑用户', '10.200.47.47', '{\"path\": \"/system/manage/user/update\", \"method\": \"PUT\", \"className\": \"com.qinweizhao.system.module.manage.controller.SysUserController\", \"methodName\": \"edit\"}', NULL, '当前岗位不存在', '1', NULL, '0', '0', 'admin', 'admin', '2022-01-20 14:35:08', NULL);
INSERT INTO `sys_log` VALUES (77, '操作日志', '编辑用户', '10.200.47.47', '{\"path\": \"/system/manage/user/update\", \"method\": \"PUT\", \"className\": \"com.qinweizhao.system.module.manage.controller.SysUserController\", \"methodName\": \"edit\"}', NULL, NULL, '1', NULL, '0', '1', 'admin', 'admin', '2022-01-20 14:35:08', NULL);
INSERT INTO `sys_log` VALUES (78, '操作日志', '新增用户', '10.200.47.47', '{\"path\": \"/system/manage/user/save\", \"method\": \"POST\", \"className\": \"com.qinweizhao.system.module.manage.controller.SysUserController\", \"methodName\": \"save\"}', NULL, '用户账号已经存在', '1', NULL, '0', '0', 'admin', 'admin', '2022-01-20 14:35:08', NULL);
INSERT INTO `sys_log` VALUES (79, '操作日志', '新增用户', '10.200.47.47', '{\"path\": \"/system/manage/user/save\", \"method\": \"POST\", \"className\": \"com.qinweizhao.system.module.manage.controller.SysUserController\", \"methodName\": \"save\"}', NULL, NULL, '1', NULL, '0', '1', 'admin', 'admin', '2022-01-20 14:35:08', NULL);
INSERT INTO `sys_log` VALUES (80, '操作日志', '新增用户', '10.200.47.47', '{\"path\": \"/system/manage/user/save\", \"method\": \"POST\", \"className\": \"com.qinweizhao.system.module.manage.controller.SysUserController\", \"methodName\": \"save\"}', NULL, '用户账号已经存在', '1', NULL, '0', '0', 'admin', 'admin', '2022-01-20 14:35:08', NULL);
INSERT INTO `sys_log` VALUES (81, '操作日志', '新增用户', '10.200.47.47', '{\"path\": \"/system/manage/user/save\", \"method\": \"POST\", \"className\": \"com.qinweizhao.system.module.manage.controller.SysUserController\", \"methodName\": \"save\"}', NULL, '用户账号已经存在', '1', NULL, '0', '0', 'admin', 'admin', '2022-01-20 14:35:08', NULL);
INSERT INTO `sys_log` VALUES (82, '操作日志', '编辑用户', '10.200.47.47', '{\"path\": \"/system/manage/user/update\", \"method\": \"PUT\", \"className\": \"com.qinweizhao.system.module.manage.controller.SysUserController\", \"methodName\": \"edit\"}', NULL, '手机号已经存在', '1', NULL, '0', '0', 'admin', 'admin', '2022-01-20 14:35:08', NULL);
INSERT INTO `sys_log` VALUES (83, '操作日志', '编辑用户', '10.200.47.47', '{\"path\": \"/system/manage/user/update\", \"method\": \"PUT\", \"className\": \"com.qinweizhao.system.module.manage.controller.SysUserController\", \"methodName\": \"edit\"}', NULL, NULL, '1', NULL, '0', '1', 'admin', 'admin', '2022-01-20 14:35:08', NULL);
INSERT INTO `sys_log` VALUES (84, '操作日志', '编辑用户', '10.200.47.47', '{\"path\": \"/system/manage/user/update\", \"method\": \"PUT\", \"className\": \"com.qinweizhao.system.module.manage.controller.SysUserController\", \"methodName\": \"edit\"}', NULL, NULL, '1', NULL, '0', '1', 'admin', 'admin', '2022-01-20 14:35:08', NULL);
INSERT INTO `sys_log` VALUES (85, '操作日志', '编辑用户', '10.200.47.47', '{\"path\": \"/system/manage/user/update\", \"method\": \"PUT\", \"className\": \"com.qinweizhao.system.module.manage.controller.SysUserController\", \"methodName\": \"edit\"}', NULL, NULL, '1', NULL, '0', '1', 'admin', 'admin', '2022-01-20 14:35:08', NULL);
INSERT INTO `sys_log` VALUES (86, '操作日志', '修改用户', '10.200.47.47', '{\"path\": \"/system/manage/user/update\", \"method\": \"PUT\", \"className\": \"com.qinweizhao.system.module.manage.controller.SysUserController\", \"methodName\": \"edit\"}', NULL, NULL, '1', NULL, '0', NULL, 'admin', 'admin', '2022-01-20 14:35:08', NULL);
INSERT INTO `sys_log` VALUES (87, '操作日志', '修改用户', '10.200.47.47', '{\"path\": \"/system/manage/user/update\", \"method\": \"PUT\", \"className\": \"com.qinweizhao.system.module.manage.controller.SysUserController\", \"methodName\": \"edit\"}', NULL, NULL, '1', NULL, '0', NULL, 'admin', 'admin', '2022-01-20 14:35:08', NULL);
INSERT INTO `sys_log` VALUES (88, '操作日志', '修改用户', '10.200.47.47', '{\"path\": \"/system/manage/user/update\", \"method\": \"PUT\", \"className\": \"com.qinweizhao.system.module.manage.controller.SysUserController\", \"methodName\": \"edit\"}', NULL, '当前岗位不存在', '1', NULL, '0', '0', 'admin', 'admin', '2022-01-20 14:35:08', NULL);
INSERT INTO `sys_log` VALUES (89, '操作日志', '修改用户', '10.200.47.47', '{\"path\": \"/system/manage/user/update\", \"method\": \"PUT\", \"className\": \"com.qinweizhao.system.module.manage.controller.SysUserController\", \"methodName\": \"edit\"}', NULL, NULL, '1', NULL, '0', NULL, 'admin', 'admin', '2022-01-20 14:35:08', NULL);
INSERT INTO `sys_log` VALUES (90, '操作日志', '修改用户', '10.200.47.47', '{\"path\": \"/system/manage/user/update\", \"method\": \"PUT\", \"className\": \"com.qinweizhao.system.module.manage.controller.SysUserController\", \"methodName\": \"edit\"}', NULL, NULL, '1', NULL, '0', '1', 'admin', 'admin', '2022-01-20 14:35:08', NULL);
INSERT INTO `sys_log` VALUES (91, '操作日志', '导出用户', '10.200.47.47', '{\"path\": \"/system/manage/user/export\", \"method\": \"GET\", \"className\": \"com.qinweizhao.system.module.manage.controller.SysUserController\", \"methodName\": \"exportUsers\"}', NULL, 'Can not find \'Converter\' support class List.', '1', NULL, '0', '0', 'admin', 'admin', '2022-01-20 14:35:08', NULL);
INSERT INTO `sys_log` VALUES (92, '操作日志', '导出用户', '10.200.47.47', '{\"path\": \"/system/manage/user/export\", \"method\": \"GET\", \"className\": \"com.qinweizhao.system.module.manage.controller.SysUserController\", \"methodName\": \"exportUsers\"}', NULL, NULL, '1', NULL, '0', '1', 'admin', 'admin', '2022-01-20 14:35:08', NULL);
INSERT INTO `sys_log` VALUES (93, '操作日志', '修改用户', '10.200.47.47', '{\"path\": \"/system/manage/user/update\", \"method\": \"PUT\", \"className\": \"com.qinweizhao.system.module.manage.controller.SysUserController\", \"methodName\": \"edit\"}', NULL, '当前岗位不存在', '1', NULL, '0', '0', 'admin', 'admin', '2022-01-20 14:35:08', NULL);
INSERT INTO `sys_log` VALUES (94, '操作日志', '修改用户', '10.200.47.47', '{\"path\": \"/system/manage/user/update\", \"method\": \"PUT\", \"className\": \"com.qinweizhao.system.module.manage.controller.SysUserController\", \"methodName\": \"edit\"}', NULL, '当前岗位不存在', '1', NULL, '0', '0', 'admin', 'admin', '2022-01-20 14:35:08', NULL);
INSERT INTO `sys_log` VALUES (95, '操作日志', '修改用户', '10.200.47.47', '{\"path\": \"/system/manage/user/update\", \"method\": \"PUT\", \"className\": \"com.qinweizhao.system.module.manage.controller.SysUserController\", \"methodName\": \"edit\"}', NULL, '当前岗位不存在', '1', NULL, '0', '0', 'admin', 'admin', '2022-01-20 14:35:08', NULL);
INSERT INTO `sys_log` VALUES (96, '操作日志', '修改用户', '10.200.47.47', '{\"path\": \"/system/manage/user/update\", \"method\": \"PUT\", \"className\": \"com.qinweizhao.system.module.manage.controller.SysUserController\", \"methodName\": \"edit\"}', NULL, NULL, '1', NULL, '0', '1', 'admin', 'admin', '2022-01-20 14:35:08', NULL);
INSERT INTO `sys_log` VALUES (97, '操作日志', '修改用户', '10.200.47.47', '{\"path\": \"/system/manage/user/update\", \"method\": \"PUT\", \"className\": \"com.qinweizhao.system.module.manage.controller.SysUserController\", \"methodName\": \"edit\"}', NULL, '当前岗位不存在', '1', NULL, '0', '0', 'admin', 'admin', '2022-01-20 14:35:08', NULL);
INSERT INTO `sys_log` VALUES (98, '操作日志', '分配权限', '10.200.47.47', '{\"path\": \"/system/manage/role/update_role_permission\", \"method\": \"PUT\", \"className\": \"com.qinweizhao.system.module.manage.controller.SysRoleController\", \"methodName\": \"updateRolePermission\"}', NULL, '不能操作类型为系统内置的角色', '1', NULL, '0', '0', 'admin', 'admin', '2022-01-20 14:35:08', NULL);
INSERT INTO `sys_log` VALUES (99, '操作日志', '分配权限', '10.200.47.47', '{\"path\": \"/system/manage/role/update_role_permission\", \"method\": \"PUT\", \"className\": \"com.qinweizhao.system.module.manage.controller.SysRoleController\", \"methodName\": \"updateRolePermission\"}', NULL, NULL, '1', NULL, '0', '0', 'admin', 'admin', '2022-01-20 14:35:08', NULL);
INSERT INTO `sys_log` VALUES (100, '操作日志', '分配权限', '10.200.47.47', '{\"path\": \"/system/manage/role/update_role_permission\", \"method\": \"PUT\", \"className\": \"com.qinweizhao.system.module.manage.controller.SysRoleController\", \"methodName\": \"updateRolePermission\"}', NULL, NULL, '1', NULL, '0', '0', 'admin', 'admin', '2022-01-20 14:35:08', NULL);
INSERT INTO `sys_log` VALUES (101, '操作日志', '分配权限', '10.200.47.47', '{\"path\": \"/system/manage/role/update_role_permission\", \"method\": \"PUT\", \"className\": \"com.qinweizhao.system.module.manage.controller.SysRoleController\", \"methodName\": \"updateRolePermission\"}', NULL, '\r\n### Error updating database.  Cause: java.sql.SQLSyntaxErrorException: You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near \'\' at line 1\r\n### The error may exist in file [E:\\Code\\qwz-calf\\calf-backend\\calf-platform\\calf-platform-system\\target\\classes\\mapper\\manage\\SysRoleDeptMapper.xml]\r\n### The error may involve defaultParameterMap\r\n### The error occurred while setting parameters\r\n### SQL: DELETE FROM sys_role_dept WHERE role_id=? AND dept_id IN\r\n### Cause: java.sql.SQLSyntaxErrorException: You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near \'\' at line 1\n; bad SQL grammar []; nested exception is java.sql.SQLSyntaxErrorException: You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near \'\' at line 1', '1', NULL, '0', '0', 'admin', 'admin', '2022-01-20 14:35:08', NULL);
INSERT INTO `sys_log` VALUES (102, '操作日志', '分配权限', '10.200.47.47', '{\"path\": \"/system/manage/role/update_role_permission\", \"method\": \"PUT\", \"className\": \"com.qinweizhao.system.module.manage.controller.SysRoleController\", \"methodName\": \"updateRolePermission\"}', NULL, '\r\n### Error updating database.  Cause: java.sql.SQLSyntaxErrorException: You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near \'\' at line 1\r\n### The error may exist in file [E:\\Code\\qwz-calf\\calf-backend\\calf-platform\\calf-platform-system\\target\\classes\\mapper\\manage\\SysRoleDeptMapper.xml]\r\n### The error may involve defaultParameterMap\r\n### The error occurred while setting parameters\r\n### SQL: DELETE FROM sys_role_dept WHERE role_id=? AND dept_id IN\r\n### Cause: java.sql.SQLSyntaxErrorException: You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near \'\' at line 1\n; bad SQL grammar []; nested exception is java.sql.SQLSyntaxErrorException: You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near \'\' at line 1', '1', NULL, '0', '0', 'admin', 'admin', '2022-01-20 14:35:08', NULL);
INSERT INTO `sys_log` VALUES (103, '操作日志', '分配权限', '10.200.47.47', '{\"path\": \"/system/manage/role/update_role_permission\", \"method\": \"PUT\", \"className\": \"com.qinweizhao.system.module.manage.controller.SysRoleController\", \"methodName\": \"updateRolePermission\"}', NULL, '\r\n### Error updating database.  Cause: java.sql.SQLSyntaxErrorException: You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near \'\' at line 1\r\n### The error may exist in file [E:\\Code\\qwz-calf\\calf-backend\\calf-platform\\calf-platform-system\\target\\classes\\mapper\\manage\\SysRoleDeptMapper.xml]\r\n### The error may involve defaultParameterMap\r\n### The error occurred while setting parameters\r\n### SQL: DELETE FROM sys_role_dept WHERE role_id=? AND dept_id IN\r\n### Cause: java.sql.SQLSyntaxErrorException: You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near \'\' at line 1\n; bad SQL grammar []; nested exception is java.sql.SQLSyntaxErrorException: You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near \'\' at line 1', '1', NULL, '0', '0', 'admin', 'admin', '2022-01-20 14:35:08', NULL);
INSERT INTO `sys_log` VALUES (104, '操作日志', '分配权限', '10.200.47.47', '{\"path\": \"/system/manage/role/update_role_permission\", \"method\": \"PUT\", \"className\": \"com.qinweizhao.system.module.manage.controller.SysRoleController\", \"methodName\": \"updateRolePermission\"}', NULL, NULL, '1', NULL, '0', '1', 'admin', 'admin', '2022-01-20 14:35:08', NULL);
INSERT INTO `sys_log` VALUES (105, '操作日志', '分配权限', '10.200.47.47', '{\"path\": \"/system/manage/role/update_role_permission\", \"method\": \"PUT\", \"className\": \"com.qinweizhao.system.module.manage.controller.SysRoleController\", \"methodName\": \"updateRolePermission\"}', NULL, NULL, '1', NULL, '0', '1', 'admin', 'admin', '2022-01-20 14:35:08', NULL);
INSERT INTO `sys_log` VALUES (106, '操作日志', '分配权限', '10.200.47.47', '{\"path\": \"/system/manage/role/update_role_permission\", \"method\": \"PUT\", \"className\": \"com.qinweizhao.system.module.manage.controller.SysRoleController\", \"methodName\": \"updateRolePermission\"}', NULL, NULL, '1', NULL, '0', '1', 'admin', 'admin', '2022-01-20 14:35:08', NULL);
INSERT INTO `sys_log` VALUES (107, '操作日志', '分配权限', '10.200.47.47', '{\"path\": \"/system/manage/role/update_role_permission\", \"method\": \"PUT\", \"className\": \"com.qinweizhao.system.module.manage.controller.SysRoleController\", \"methodName\": \"updateRolePermission\"}', NULL, '不能操作类型为系统内置的角色', '1', NULL, '0', '0', 'admin', 'admin', '2022-01-20 14:35:08', NULL);
INSERT INTO `sys_log` VALUES (108, '操作日志', '分配权限', '10.200.47.47', '{\"path\": \"/system/manage/role/update_role_permission\", \"method\": \"PUT\", \"className\": \"com.qinweizhao.system.module.manage.controller.SysRoleController\", \"methodName\": \"updateRolePermission\"}', NULL, NULL, '1', NULL, '0', '1', 'admin', 'admin', '2022-01-20 14:35:08', NULL);
INSERT INTO `sys_log` VALUES (109, '操作日志', '分配权限', '10.200.47.47', '{\"path\": \"/system/manage/role/update_role_permission\", \"method\": \"PUT\", \"className\": \"com.qinweizhao.system.module.manage.controller.SysRoleController\", \"methodName\": \"updateRolePermission\"}', NULL, 'nested exception is org.apache.ibatis.binding.BindingException: Parameter \'list\' not found. Available parameters are [roleId, menuIds, param1, param2]', '1', NULL, '0', '0', 'admin', 'admin', '2022-01-20 14:35:08', NULL);
INSERT INTO `sys_log` VALUES (110, '操作日志', '分配权限', '10.200.47.47', '{\"path\": \"/system/manage/role/update_role_permission\", \"method\": \"PUT\", \"className\": \"com.qinweizhao.system.module.manage.controller.SysRoleController\", \"methodName\": \"updateRolePermission\"}', NULL, NULL, '1', NULL, '0', '1', 'admin', 'admin', '2022-01-20 14:35:08', NULL);
INSERT INTO `sys_log` VALUES (111, '操作日志', '分配权限', '10.200.47.47', '{\"path\": \"/system/manage/role/update_role_permission\", \"method\": \"PUT\", \"className\": \"com.qinweizhao.system.module.manage.controller.SysRoleController\", \"methodName\": \"updateRolePermission\"}', NULL, NULL, '1', NULL, '0', '1', 'admin', 'admin', '2022-01-20 14:35:08', NULL);
INSERT INTO `sys_log` VALUES (112, '操作日志', '分配权限', '10.200.47.47', '{\"path\": \"/system/manage/role/update_role_permission\", \"method\": \"PUT\", \"className\": \"com.qinweizhao.system.module.manage.controller.SysRoleController\", \"methodName\": \"updateRolePermission\"}', NULL, NULL, '1', NULL, '0', '1', 'admin', 'admin', '2022-01-20 14:35:08', NULL);
INSERT INTO `sys_log` VALUES (113, '操作日志', '分配权限', '10.200.47.47', '{\"path\": \"/system/manage/role/update_role_permission\", \"method\": \"PUT\", \"className\": \"com.qinweizhao.system.module.manage.controller.SysRoleController\", \"methodName\": \"updateRolePermission\"}', NULL, NULL, '1', NULL, '0', '1', 'admin', 'admin', '2022-01-20 14:35:08', NULL);
INSERT INTO `sys_log` VALUES (114, '操作日志', '分配权限', '10.200.47.47', '{\"path\": \"/system/manage/role/update_role_permission\", \"method\": \"PUT\", \"className\": \"com.qinweizhao.system.module.manage.controller.SysRoleController\", \"methodName\": \"updateRolePermission\"}', NULL, NULL, '1', NULL, '0', '1', 'admin', 'admin', '2022-01-20 14:35:08', NULL);
INSERT INTO `sys_log` VALUES (115, '操作日志', '分配权限', '10.200.47.47', '{\"path\": \"/system/manage/role/update_role_permission\", \"method\": \"PUT\", \"className\": \"com.qinweizhao.system.module.manage.controller.SysRoleController\", \"methodName\": \"updateRolePermission\"}', NULL, NULL, '1', NULL, '0', '1', 'admin', 'admin', '2022-01-20 14:35:08', NULL);
INSERT INTO `sys_log` VALUES (116, '操作日志', '分配权限', '10.200.47.47', '{\"path\": \"/system/manage/role/update_role_permission\", \"method\": \"PUT\", \"className\": \"com.qinweizhao.system.module.manage.controller.SysRoleController\", \"methodName\": \"updateRolePermission\"}', NULL, '角色不存在', '1', NULL, '0', '0', 'admin', 'admin', '2022-01-20 14:35:08', NULL);
INSERT INTO `sys_log` VALUES (117, '操作日志', '分配权限', '10.200.47.47', '{\"path\": \"/system/manage/role/update_role_permission\", \"method\": \"PUT\", \"className\": \"com.qinweizhao.system.module.manage.controller.SysRoleController\", \"methodName\": \"updateRolePermission\"}', NULL, '角色不存在', '1', NULL, '0', '0', 'admin', 'admin', '2022-01-20 14:35:08', NULL);
INSERT INTO `sys_log` VALUES (118, '操作日志', '删除用户', '10.200.47.47', '{\"path\": \"/system/manage/user/remove\", \"method\": \"DELETE\", \"className\": \"com.qinweizhao.system.module.manage.controller.SysUserController\", \"methodName\": \"remove\"}', NULL, NULL, '1', NULL, '0', '1', 'admin', 'admin', '2022-01-20 14:35:08', NULL);
INSERT INTO `sys_log` VALUES (119, '操作日志', '分配权限', '10.200.47.47', '{\"path\": \"/system/manage/role/update_role_permission\", \"method\": \"PUT\", \"className\": \"com.qinweizhao.system.module.manage.controller.SysRoleController\", \"methodName\": \"updateRolePermission\"}', NULL, NULL, '1', NULL, '0', '1', 'admin', 'admin', '2022-01-20 14:35:08', NULL);
INSERT INTO `sys_log` VALUES (120, '操作日志', '分配权限', '10.200.47.47', '{\"path\": \"/system/manage/role/update_role_permission\", \"method\": \"PUT\", \"className\": \"com.qinweizhao.system.module.manage.controller.SysRoleController\", \"methodName\": \"updateRolePermission\"}', NULL, NULL, '1', NULL, '0', '1', 'admin', 'admin', '2022-01-20 14:35:08', NULL);
INSERT INTO `sys_log` VALUES (121, '操作日志', '分配权限', '10.200.47.47', '{\"path\": \"/system/manage/role/update_role_permission\", \"method\": \"PUT\", \"className\": \"com.qinweizhao.system.module.manage.controller.SysRoleController\", \"methodName\": \"updateRolePermission\"}', NULL, NULL, '1', NULL, '0', '1', 'admin', 'admin', '2022-01-20 14:35:08', NULL);
INSERT INTO `sys_log` VALUES (122, '操作日志', '分配权限', '10.200.47.47', '{\"path\": \"/system/manage/role/update_role_permission\", \"method\": \"PUT\", \"className\": \"com.qinweizhao.system.module.manage.controller.SysRoleController\", \"methodName\": \"updateRolePermission\"}', NULL, NULL, '1', NULL, '0', '1', 'admin', 'admin', '2022-01-20 14:35:08', NULL);
INSERT INTO `sys_log` VALUES (123, '操作日志', '分配权限', '10.200.47.47', '{\"path\": \"/system/manage/role/update_role_permission\", \"method\": \"PUT\", \"className\": \"com.qinweizhao.system.module.manage.controller.SysRoleController\", \"methodName\": \"updateRolePermission\"}', NULL, NULL, '1', NULL, '0', '1', 'admin', 'admin', '2022-01-20 14:35:08', NULL);
INSERT INTO `sys_log` VALUES (124, '操作日志', '分配权限', '10.200.47.47', '{\"path\": \"/system/manage/role/update_role_permission\", \"method\": \"PUT\", \"className\": \"com.qinweizhao.system.module.manage.controller.SysRoleController\", \"methodName\": \"updateRolePermission\"}', NULL, '不能操作类型为系统内置的角色', '1', NULL, '0', '0', 'admin', 'admin', '2022-01-20 14:35:08', NULL);
INSERT INTO `sys_log` VALUES (125, '操作日志', '分配权限', '10.200.47.47', '{\"path\": \"/system/manage/role/update_role_permission\", \"method\": \"PUT\", \"className\": \"com.qinweizhao.system.module.manage.controller.SysRoleController\", \"methodName\": \"updateRolePermission\"}', NULL, '不能操作类型为系统内置的角色', '1', NULL, '0', '0', 'admin', 'admin', '2022-01-20 14:35:08', NULL);
INSERT INTO `sys_log` VALUES (126, '操作日志', '分配权限', '10.200.47.47', '{\"path\": \"/system/manage/role/update_role_permission\", \"method\": \"PUT\", \"className\": \"com.qinweizhao.system.module.manage.controller.SysRoleController\", \"methodName\": \"updateRolePermission\"}', NULL, '不能操作类型为系统内置的角色', '1', NULL, '0', '0', 'admin', 'admin', '2022-01-20 14:35:08', NULL);
INSERT INTO `sys_log` VALUES (127, '操作日志', '修改用户状态', '10.200.47.47', '{\"path\": \"/system/manage/user/update_status\", \"method\": \"PUT\", \"className\": \"com.qinweizhao.system.module.manage.controller.SysUserController\", \"methodName\": \"updateUserStatus\"}', NULL, NULL, '1', NULL, '0', '1', 'admin', 'admin', '2022-01-20 14:35:08', NULL);
INSERT INTO `sys_log` VALUES (128, '操作日志', '修改用户状态', '10.200.47.47', '{\"path\": \"/system/manage/user/update_status\", \"method\": \"PUT\", \"className\": \"com.qinweizhao.system.module.manage.controller.SysUserController\", \"methodName\": \"updateUserStatus\"}', NULL, NULL, '1', NULL, '0', '1', 'admin', 'admin', '2022-01-20 14:35:08', NULL);
INSERT INTO `sys_log` VALUES (129, '操作日志', '分配权限', '10.200.47.47', '{\"path\": \"/system/manage/role/update_role_permission\", \"method\": \"PUT\", \"className\": \"com.qinweizhao.system.module.manage.controller.SysRoleController\", \"methodName\": \"updateRolePermission\"}', NULL, NULL, '1', NULL, '0', '1', 'admin', 'admin', '2022-01-20 14:35:08', NULL);
INSERT INTO `sys_log` VALUES (130, '操作日志', '修改用户状态', '10.200.47.47', '{\"path\": \"/system/manage/user/update_status\", \"method\": \"PUT\", \"className\": \"com.qinweizhao.system.module.manage.controller.SysUserController\", \"methodName\": \"updateUserStatus\"}', NULL, NULL, '1', NULL, '0', '1', 'admin', 'admin', '2022-01-20 14:35:08', NULL);
INSERT INTO `sys_log` VALUES (131, '操作日志', '修改用户', '10.200.47.47', '{\"path\": \"/system/manage/user/update\", \"method\": \"PUT\", \"className\": \"com.qinweizhao.system.module.manage.controller.SysUserController\", \"methodName\": \"update\"}', NULL, '当前岗位不存在', '1', NULL, '0', '0', 'admin', 'admin', '2022-01-20 14:35:08', NULL);
INSERT INTO `sys_log` VALUES (132, '操作日志', '修改用户', '10.200.47.47', '{\"path\": \"/system/manage/user/update\", \"method\": \"PUT\", \"className\": \"com.qinweizhao.system.module.manage.controller.SysUserController\", \"methodName\": \"update\"}', NULL, NULL, '1', NULL, '0', '1', 'admin', 'admin', '2022-01-20 14:35:08', NULL);
INSERT INTO `sys_log` VALUES (133, '操作日志', '修改用户', '10.200.47.47', '{\"path\": \"/system/manage/user/update\", \"method\": \"PUT\", \"className\": \"com.qinweizhao.system.module.manage.controller.SysUserController\", \"methodName\": \"update\"}', NULL, NULL, '1', NULL, '0', '1', 'admin', 'admin', '2022-01-20 14:35:08', NULL);
INSERT INTO `sys_log` VALUES (134, '操作日志', '修改用户', '10.200.47.47', '{\"path\": \"/system/manage/user/update\", \"method\": \"PUT\", \"className\": \"com.qinweizhao.system.module.manage.controller.SysUserController\", \"methodName\": \"update\"}', NULL, NULL, '1', NULL, '0', '1', 'admin', 'admin', '2022-01-20 14:35:08', NULL);
INSERT INTO `sys_log` VALUES (135, '操作日志', '修改用户', '10.200.47.47', '{\"path\": \"/system/manage/user/update\", \"method\": \"PUT\", \"className\": \"com.qinweizhao.system.module.manage.controller.SysUserController\", \"methodName\": \"update\"}', NULL, NULL, '1', NULL, '0', '1', 'admin', 'admin', '2022-01-20 14:35:08', NULL);
INSERT INTO `sys_log` VALUES (136, '操作日志', '修改用户', '10.200.47.47', '{\"path\": \"/system/manage/user/update\", \"method\": \"PUT\", \"className\": \"com.qinweizhao.system.module.manage.controller.SysUserController\", \"methodName\": \"update\"}', NULL, NULL, '1', NULL, '0', '1', 'admin', 'admin', '2022-01-20 14:35:08', NULL);
INSERT INTO `sys_log` VALUES (137, '操作日志', '分配权限', '127.0.0.1', '{\"path\": \"/system/manage/role/update_role_permission\", \"method\": \"PUT\", \"className\": \"com.qinweizhao.system.module.manage.controller.SysRoleController\", \"methodName\": \"updateByolePermission\"}', NULL, '不能操作类型为系统内置的角色', NULL, NULL, '0', '0', 'admin', 'admin', '2022-01-20 14:34:00', '2022-01-20 14:34:00');
INSERT INTO `sys_log` VALUES (138, '操作日志', '修改用户', '127.0.0.1', '{\"path\": \"/system/manage/user/update\", \"method\": \"PUT\", \"className\": \"com.qinweizhao.system.module.manage.controller.SysUserController\", \"methodName\": \"update\", \"methodParam\": \"\"}', '{\"msg\": \"操作成功\", \"code\": 200, \"time\": 1642837783726}', NULL, NULL, NULL, '0', '1', 'admin', 'admin', '2022-01-22 15:49:44', '2022-01-22 15:49:44');
INSERT INTO `sys_log` VALUES (139, '操作日志', '修改用户', '127.0.0.1', '{\"path\": \"/system/manage/user/update\", \"method\": \"PUT\", \"className\": \"com.qinweizhao.system.module.manage.controller.SysUserController\", \"methodName\": \"update\", \"methodParam\": \"\"}', '{\"msg\": \"操作成功\", \"code\": 200, \"time\": 1642837792267}', NULL, NULL, NULL, '0', '1', 'admin', 'admin', '2022-01-22 15:49:52', '2022-01-22 15:49:52');

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `menu_id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '名称',
  `parent_id` bigint(0) NULL DEFAULT 0 COMMENT '父ID',
  `path` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '路径',
  `component` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '组件',
  `type` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '类型：M目录、C菜单、F按钮',
  `permission` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '权限',
  `icon` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '#' COMMENT '图标',
  `sort` int(0) NULL DEFAULT NULL COMMENT '排序',
  `deleted` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '删除：1存在、0删除',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '状态：1正常、0停用',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '创建者',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '更新者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`menu_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1073 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '菜单权限表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES (1, '系统管理', 0, '/system', ' ', '1', NULL, 'system', 1, '0', '1', 'admin', 'wz', '2021-01-05 01:03:48', '2021-01-05 01:03:48');
INSERT INTO `sys_menu` VALUES (2, '系统监控', 0, '/monitor', '', '1', NULL, 'monitor', 1, '0', '1', 'admin', 'wz', '2021-01-05 17:03:48', '2021-01-05 17:03:48');
INSERT INTO `sys_menu` VALUES (3, '系统工具', 0, '/tool', ' ', '1', NULL, 'tool', 1, '0', '1', 'admin', 'wz', '2021-01-05 17:03:48', '2021-01-05 17:03:48');
INSERT INTO `sys_menu` VALUES (100, '用户管理', 1, 'user', 'system/manage/user/index', '2', 'system:user:list', 'user', 1, '0', '1', 'admin', 'wz', '2021-01-05 17:03:48', '2021-01-05 17:03:48');
INSERT INTO `sys_menu` VALUES (101, '角色管理', 1, 'role', 'system/manage/role/index', '2', '', 'peoples', 1, '0', '1', 'admin', 'wz', '2021-01-05 17:03:48', '2021-01-05 17:03:48');
INSERT INTO `sys_menu` VALUES (102, '菜单管理', 1, 'menu', 'system/manage/menu/index', '2', '', 'tree-table', 1, '0', '1', 'admin', 'wz', '2021-01-05 17:03:48', '2021-01-05 17:03:48');
INSERT INTO `sys_menu` VALUES (103, '部门管理', 1, 'dept', 'system/manage/dept/index', '2', '', 'tree', 1, '0', '1', 'admin', 'wz', '2021-01-05 17:03:48', '2021-01-05 17:03:48');
INSERT INTO `sys_menu` VALUES (104, '岗位管理', 1, 'post', 'system/manage/post/index', '2', '', 'post', 1, '0', '1', 'admin', 'wz', '2021-01-05 17:03:48', '2021-01-05 17:03:48');
INSERT INTO `sys_menu` VALUES (105, '字典管理', 1, 'dict', 'system/manage/dict/index', '2', '', 'dict', 1, '0', '1', 'admin', 'wz', '2021-01-05 17:03:48', '2021-01-05 17:03:48');
INSERT INTO `sys_menu` VALUES (106, '配置管理', 1, 'config', 'system/manage/config/index', '2', '', 'edit', 1, '0', '1', 'admin', 'wz', '2021-01-05 17:03:48', '2021-01-05 17:03:48');
INSERT INTO `sys_menu` VALUES (200, '日志记录', 2, 'log', 'system/monitor/log/index', '2', '', 'log', 1, '0', '1', 'admin', 'wz', '2021-01-05 17:03:48', '2021-01-05 17:03:48');
INSERT INTO `sys_menu` VALUES (202, 'MySQL 监控', 2, 'druid', 'system/monitor/druid/index', '', NULL, 'druid', 1, '0', '1', 'admin', 'wz', '2021-01-05 17:03:48', '2021-01-05 17:03:48');
INSERT INTO `sys_menu` VALUES (300, '定时任务', 3, 'job', 'system/tool/job/index', '2', '', 'job', 1, '0', '1', 'admin', 'wz', '2021-01-05 17:03:48', '2021-01-05 17:03:48');
INSERT INTO `sys_menu` VALUES (301, '系统接口', 3, 'swagger', 'system/tool/swagger/index', '', 'tool:swagger:list', 'swagger', 1, '0', '1', 'admin', 'wz', '2021-01-05 17:03:48', '2021-01-05 17:03:48');
INSERT INTO `sys_menu` VALUES (1001, '用户查询', 100, '', '', '3', 'system:user:query', '#', 1, '0', '1', 'admin', 'wz', '2021-01-05 17:03:48', '2021-01-05 17:03:48');
INSERT INTO `sys_menu` VALUES (1002, '用户新增', 100, '', '', '3', 'system:user:create', '', 1, '0', '1', 'admin', 'wz', '2021-01-05 17:03:48', '2021-01-05 17:03:48');
INSERT INTO `sys_menu` VALUES (1003, '用户修改', 100, '', '', '3', 'system:user:update', '', 1, '0', '1', 'admin', 'wz', '2021-01-05 17:03:48', '2021-01-05 17:03:48');
INSERT INTO `sys_menu` VALUES (1004, '用户删除', 100, '', '', '3', 'system:user:delete', '', 1, '0', '1', 'admin', 'wz', '2021-01-05 17:03:48', '2021-01-05 17:03:48');
INSERT INTO `sys_menu` VALUES (1005, '用户导出', 100, '', '', '3', 'system:user:export', '#', 1, '0', '1', 'admin', 'wz', '2021-01-05 17:03:48', '2021-01-05 17:03:48');
INSERT INTO `sys_menu` VALUES (1006, '用户导入', 100, '', '', '3', 'system:user:import', '#', 1, '0', '1', 'admin', 'wz', '2021-01-05 17:03:48', '2021-01-05 17:03:48');
INSERT INTO `sys_menu` VALUES (1007, '重置密码', 100, '', '', '3', 'system:user:update-password', '', 1, '0', '1', 'admin', 'wz', '2021-01-05 17:03:48', '2021-01-05 17:03:48');
INSERT INTO `sys_menu` VALUES (1008, '角色查询', 101, '', '', '3', 'system:role:query', '#', 1, '0', '1', 'admin', 'wz', '2021-01-05 17:03:48', '2021-01-05 17:03:48');
INSERT INTO `sys_menu` VALUES (1009, '角色新增', 101, '', '', '3', 'system:role:create', '', 1, '0', '1', 'admin', 'wz', '2021-01-05 17:03:48', '2021-01-05 17:03:48');
INSERT INTO `sys_menu` VALUES (1010, '角色修改', 101, '', '', '3', 'system:role:update', '', 1, '0', '1', 'admin', 'wz', '2021-01-05 17:03:48', '2021-01-05 17:03:48');
INSERT INTO `sys_menu` VALUES (1011, '角色删除', 101, '', '', '3', 'system:role:delete', '', 1, '0', '1', 'admin', 'wz', '2021-01-05 17:03:48', '2021-01-05 17:03:48');
INSERT INTO `sys_menu` VALUES (1012, '角色导出', 101, '', '', '3', 'system:role:export', '#', 1, '0', '1', 'admin', 'wz', '2021-01-05 17:03:48', '2021-01-05 17:03:48');
INSERT INTO `sys_menu` VALUES (1013, '菜单查询', 102, '', '', '3', 'system:menu:query', '#', 1, '0', '1', 'admin', 'wz', '2021-01-05 17:03:48', '2021-01-05 17:03:48');
INSERT INTO `sys_menu` VALUES (1014, '菜单新增', 102, '', '', '3', 'system:menu:create', '#', 1, '0', '1', 'admin', 'wz', '2021-01-05 17:03:48', '2021-01-05 17:03:48');
INSERT INTO `sys_menu` VALUES (1015, '菜单修改', 102, '', '', '3', 'system:menu:update', '#', 1, '0', '1', 'admin', 'wz', '2021-01-05 17:03:48', '2021-01-05 17:03:48');
INSERT INTO `sys_menu` VALUES (1016, '菜单删除', 102, '', '', '3', 'system:menu:delete', '#', 1, '0', '1', 'admin', 'wz', '2021-01-05 17:03:48', '2021-01-05 17:03:48');
INSERT INTO `sys_menu` VALUES (1017, '部门查询', 103, '', '', '3', 'system:dept:query', '#', 1, '0', '1', 'admin', 'wz', '2021-01-05 17:03:48', '2021-01-05 17:03:48');
INSERT INTO `sys_menu` VALUES (1018, '部门新增', 103, '', '', '3', 'system:dept:create', '', 1, '0', '1', 'admin', 'wz', '2021-01-05 17:03:48', '2021-01-05 17:03:48');
INSERT INTO `sys_menu` VALUES (1019, '部门修改', 103, '', '', '3', 'system:dept:update', '', 1, '0', '1', 'admin', 'wz', '2021-01-05 17:03:48', '2021-01-05 17:03:48');
INSERT INTO `sys_menu` VALUES (1020, '部门删除', 103, '', '', '3', 'system:dept:delete', '', 1, '0', '1', 'admin', 'wz', '2021-01-05 17:03:48', '2021-01-05 17:03:48');
INSERT INTO `sys_menu` VALUES (1021, '岗位查询', 104, '', '', '3', 'system:post:query', '#', 1, '0', '1', 'admin', 'wz', '2021-01-05 17:03:48', '2021-01-05 17:03:48');
INSERT INTO `sys_menu` VALUES (1022, '岗位新增', 104, '', '', '3', 'system:post:create', '', 1, '0', '1', 'admin', 'wz', '2021-01-05 17:03:48', '2021-01-05 17:03:48');
INSERT INTO `sys_menu` VALUES (1023, '岗位修改', 104, '', '', '3', 'system:post:update', '', 1, '0', '1', 'admin', 'wz', '2021-01-05 17:03:48', '2021-01-05 17:03:48');
INSERT INTO `sys_menu` VALUES (1024, '岗位删除', 104, '', '', '3', 'system:post:delete', '', 1, '0', '1', 'admin', 'wz', '2021-01-05 17:03:48', '2021-01-05 17:03:48');
INSERT INTO `sys_menu` VALUES (1025, '岗位导出', 104, '', '', '3', 'system:post:export', '#', 1, '0', '1', 'admin', 'wz', '2021-01-05 17:03:48', '2021-01-05 17:03:48');
INSERT INTO `sys_menu` VALUES (1026, '字典查询', 105, '#', '', '3', 'system:dict:query', '#', 1, '0', '1', 'admin', 'wz', '2021-01-05 17:03:48', '2021-01-05 17:03:48');
INSERT INTO `sys_menu` VALUES (1027, '字典新增', 105, '', '', '3', 'system:dict:create', '', 1, '0', '1', 'admin', 'wz', '2021-01-05 17:03:48', '2021-01-05 17:03:48');
INSERT INTO `sys_menu` VALUES (1028, '字典修改', 105, '', '', '3', 'system:dict:update', '', 1, '0', '1', 'admin', 'wz', '2021-01-05 17:03:48', '2021-01-05 17:03:48');
INSERT INTO `sys_menu` VALUES (1029, '字典删除', 105, '', '', '3', 'system:dict:delete', '', 1, '0', '1', 'admin', 'wz', '2021-01-05 17:03:48', '2021-01-05 17:03:48');
INSERT INTO `sys_menu` VALUES (1030, '字典导出', 105, '#', '', '3', 'system:dict:export', '#', 1, '0', '1', 'admin', 'wz', '2021-01-05 17:03:48', '2021-01-05 17:03:48');
INSERT INTO `sys_menu` VALUES (1031, '配置查询', 106, '', '', '3', 'system:config:query', '', 1, '0', '1', 'admin', 'wz', '2021-01-05 17:03:48', '2021-01-05 17:03:48');
INSERT INTO `sys_menu` VALUES (1032, '配置新增', 106, '', '', '3', 'system:config:create', '', 1, '0', '1', 'admin', 'wz', '2021-01-05 17:03:48', '2021-01-05 17:03:48');
INSERT INTO `sys_menu` VALUES (1033, '配置修改', 106, '', '', '3', 'system:config:update', '', 1, '0', '1', 'admin', 'wz', '2021-01-05 17:03:48', '2021-01-05 17:03:48');
INSERT INTO `sys_menu` VALUES (1034, '配置删除', 106, '', '', '3', 'system:config:delete', '', 1, '0', '1', 'admin', 'wz', '2021-01-05 17:03:48', '2021-01-05 17:03:48');
INSERT INTO `sys_menu` VALUES (1035, '配置导出', 106, '', '', '3', 'system:config:export', '', 1, '0', '1', 'admin', 'wz', '2021-01-05 17:03:48', '2021-01-05 17:03:48');
INSERT INTO `sys_menu` VALUES (1046, '在线查询', 109, '', '', '3', 'system:user-session:list', '', 1, '0', '1', 'admin', 'wz', '2021-01-05 17:03:48', '2021-01-05 17:03:48');
INSERT INTO `sys_menu` VALUES (1047, '批量强退', 109, '#', '', '3', 'monitor:online:batchLogout', '#', 1, '0', '1', 'admin', 'wz', '2021-01-05 17:03:48', '2021-01-05 17:03:48');
INSERT INTO `sys_menu` VALUES (1048, '单条强退', 109, '', '', '3', 'system:user-session:delete', '', 1, '0', '1', 'admin', 'wz', '2021-01-05 17:03:48', '2021-01-05 17:03:48');
INSERT INTO `sys_menu` VALUES (1049, '任务查询', 110, '#', '', '3', 'monitor:job:query', '#', 1, '0', '1', 'admin', 'wz', '2021-01-05 17:03:48', '2021-01-05 17:03:48');
INSERT INTO `sys_menu` VALUES (1050, '任务新增', 110, '', '', '3', 'system:job:create', '', 1, '0', '1', 'admin', 'wz', '2021-01-05 17:03:48', '2021-01-05 17:03:48');
INSERT INTO `sys_menu` VALUES (1051, '任务修改', 110, '', '', '3', 'system:job:update', '', 1, '0', '1', 'admin', 'wz', '2021-01-05 17:03:48', '2021-01-05 17:03:48');
INSERT INTO `sys_menu` VALUES (1052, '任务删除', 110, '', '', '3', 'system:job:delete', '', 1, '0', '1', 'admin', 'wz', '2021-01-05 17:03:48', '2021-01-05 17:03:48');
INSERT INTO `sys_menu` VALUES (1053, '状态修改', 110, '', '', '3', 'system:job:update', '', 1, '0', '1', 'admin', 'wz', '2021-01-05 17:03:48', '2021-01-05 17:03:48');
INSERT INTO `sys_menu` VALUES (1054, '任务导出', 110, '', '', '3', 'system:job:export', '', 1, '0', '1', 'admin', 'wz', '2021-01-05 17:03:48', '2021-01-05 17:03:48');
INSERT INTO `sys_menu` VALUES (1063, '设置角色菜单权限', 101, '', '', '3', 'system:permission:assign-role-menu', '', 1, '0', '1', 'admin', 'wz', '2021-01-05 17:03:48', '2021-01-05 17:03:48');
INSERT INTO `sys_menu` VALUES (1064, '设置角色数据权限', 101, '', '', '3', 'system:permission:assign-role-data-scope', '', 1, '0', '1', 'admin', 'wz', '2021-01-05 17:03:48', '2021-01-05 17:03:48');
INSERT INTO `sys_menu` VALUES (1065, '设置用户角色', 101, '', '', '3', 'system:permission:assign-user-role', '', 1, '0', '1', 'admin', 'wz', '2021-01-05 17:03:48', '2021-01-05 17:03:48');
INSERT INTO `sys_menu` VALUES (1071, '查看日志', 200, '', '', '3', 'system:log:get', '', 1, '0', '1', 'admin', 'admin', '2022-01-20 14:31:38', '2022-01-20 14:31:38');
INSERT INTO `sys_menu` VALUES (1072, '查询任务', 300, '', '', '3', 'system:job:query', '', 1, '0', '1', 'admin', 'admin', '2022-01-21 17:42:37', '2022-01-21 17:42:37');

-- ----------------------------
-- Table structure for sys_post
-- ----------------------------
DROP TABLE IF EXISTS `sys_post`;
CREATE TABLE `sys_post`  (
  `post_id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '岗位ID',
  `code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '岗位编码',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '岗位名称',
  `sort` int(0) NOT NULL COMMENT '显示顺序',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '状态（1正常 0停用）',
  `deleted` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '删除标志：1存在、0删除',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`post_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '岗位信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_post
-- ----------------------------
INSERT INTO `sys_post` VALUES (1, '1', '1', 1, '1', '0', 'wz', '2022-01-19 16:36:53', 'wz', '2022-01-19 16:37:02');
INSERT INTO `sys_post` VALUES (3, '3', '3', 2, '1', '0', 'admin', '2022-01-19 16:49:03', 'admin', '2022-01-19 16:49:03');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `role_id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '名称',
  `code` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '标识',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `data_scope` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '数据范围：1全部数据权限、2自定数据权限、3本部门数据权限、4本部门及以下数据权限',
  `sort` int(0) NOT NULL COMMENT '排序',
  `deleted` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '删除：0存在、1删除',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '1' COMMENT '状态：1正常、0停用',
  `create_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建者',
  `update_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建日期',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`role_id`) USING BTREE,
  UNIQUE INDEX `uniq_name`(`name`) USING BTREE,
  INDEX `role_name_index`(`name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, '超级管理员', 'admin', '1', '1', 1, '0', '1', '1', '1', '2021-12-21 16:26:05', '2021-12-21 16:26:07');
INSERT INTO `sys_role` VALUES (3, '测试角色一', 'role_a', '1', '2', 1, '0', '1', '1', 'admin', '2022-01-12 19:31:42', '2022-01-13 19:07:56');
INSERT INTO `sys_role` VALUES (5, '测试角色二', 'role_b', '1', '2', 2, '0', '1', 'admin', 'admin', '2022-01-13 15:52:37', '2022-01-13 17:28:47');
INSERT INTO `sys_role` VALUES (6, '测试角色3', 'role_c', NULL, NULL, 2, '1', '1', 'admin', 'admin', '2022-01-13 15:56:08', '2022-01-13 15:56:08');
INSERT INTO `sys_role` VALUES (7, '测试角色4', 'role_d', NULL, '2', 1, '1', '1', 'admin', 'admin', '2022-01-13 16:01:08', '2022-01-13 16:10:48');
INSERT INTO `sys_role` VALUES (8, '测试角色三', 'role_cd', NULL, NULL, 2, '1', '1', 'admin', 'admin', '2022-01-19 16:32:31', '2022-01-19 16:32:31');

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
INSERT INTO `sys_role_dept` VALUES (3, 1);
INSERT INTO `sys_role_dept` VALUES (3, 2);
INSERT INTO `sys_role_dept` VALUES (3, 3);
INSERT INTO `sys_role_dept` VALUES (3, 4);
INSERT INTO `sys_role_dept` VALUES (3, 5);
INSERT INTO `sys_role_dept` VALUES (5, 1);
INSERT INTO `sys_role_dept` VALUES (5, 2);
INSERT INTO `sys_role_dept` VALUES (5, 3);
INSERT INTO `sys_role_dept` VALUES (5, 4);
INSERT INTO `sys_role_dept` VALUES (5, 5);
INSERT INTO `sys_role_dept` VALUES (7, 2);

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
INSERT INTO `sys_role_menu` VALUES (1, 108);
INSERT INTO `sys_role_menu` VALUES (1, 109);
INSERT INTO `sys_role_menu` VALUES (1, 110);
INSERT INTO `sys_role_menu` VALUES (1, 111);
INSERT INTO `sys_role_menu` VALUES (1, 112);
INSERT INTO `sys_role_menu` VALUES (1, 113);
INSERT INTO `sys_role_menu` VALUES (1, 114);
INSERT INTO `sys_role_menu` VALUES (1, 115);
INSERT INTO `sys_role_menu` VALUES (1, 116);
INSERT INTO `sys_role_menu` VALUES (1, 1000);
INSERT INTO `sys_role_menu` VALUES (1, 1001);
INSERT INTO `sys_role_menu` VALUES (1, 1002);
INSERT INTO `sys_role_menu` VALUES (1, 1003);
INSERT INTO `sys_role_menu` VALUES (1, 1004);
INSERT INTO `sys_role_menu` VALUES (1, 1005);
INSERT INTO `sys_role_menu` VALUES (1, 1006);
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
INSERT INTO `sys_role_menu` VALUES (1, 1040);
INSERT INTO `sys_role_menu` VALUES (1, 111);
INSERT INTO `sys_role_menu` VALUES (1, 112);
INSERT INTO `sys_role_menu` VALUES (1, 113);
INSERT INTO `sys_role_menu` VALUES (1, 114);
INSERT INTO `sys_role_menu` VALUES (1, 116);
INSERT INTO `sys_role_menu` VALUES (1, 120);
INSERT INTO `sys_role_menu` VALUES (1, 202);
INSERT INTO `sys_role_menu` VALUES (1, 204);
INSERT INTO `sys_role_menu` VALUES (1, 300);
INSERT INTO `sys_role_menu` VALUES (1, 301);
INSERT INTO `sys_role_menu` VALUES (1, 200);
INSERT INTO `sys_role_menu` VALUES (1, 1050);
INSERT INTO `sys_role_menu` VALUES (1, 1051);
INSERT INTO `sys_role_menu` VALUES (1, 1052);
INSERT INTO `sys_role_menu` VALUES (1, 1053);
INSERT INTO `sys_role_menu` VALUES (1, 1054);
INSERT INTO `sys_role_menu` VALUES (1, 1065);
INSERT INTO `sys_role_menu` VALUES (1, 1071);
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
INSERT INTO `sys_role_menu` VALUES (3, 2);
INSERT INTO `sys_role_menu` VALUES (3, 200);
INSERT INTO `sys_role_menu` VALUES (3, 1040);
INSERT INTO `sys_role_menu` VALUES (3, 202);
INSERT INTO `sys_role_menu` VALUES (3, 3);
INSERT INTO `sys_role_menu` VALUES (3, 300);
INSERT INTO `sys_role_menu` VALUES (3, 301);
INSERT INTO `sys_role_menu` VALUES (5, 2);
INSERT INTO `sys_role_menu` VALUES (5, 200);
INSERT INTO `sys_role_menu` VALUES (5, 1040);
INSERT INTO `sys_role_menu` VALUES (5, 202);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `user_id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `dept_id` bigint(0) NULL DEFAULT NULL COMMENT '部门编号',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `nick_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `sex` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号码',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `avatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像',
  `sort` int(0) NULL DEFAULT NULL COMMENT '排序',
  `deleted` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '删除：0存在、1删除',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '状态：1启用、0禁用',
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
  INDEX `inx_enabled`(`status`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 38 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统用户' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 1, 'admin', '$2a$10$ilcr9HuLeFYN20olWqOv5.BFaN492M48V2Y93vWEzXwA3sVxWNkgG', 'YVKG', '1', '17703911201', 'yvkg@qq.com', 'https://www.qinweizhao.com/upload/2022/01/blob84e4e075-d7e0-4d09-8d99-20af90b64df8-7f12e9500f6445b08c04e553fb5437bd.jpg', 1, '0', '1', 'admin', 'admin', '2021-12-20 17:50:42', '2022-01-22 17:17:23');
INSERT INTO `sys_user` VALUES (25, 2, '测试1', '', '测试1', '1', '17703910001', 'cs1@qq.com', 'https://www.qinweizhao.com/upload/2021/11/avatar-9b1b1e49686548049357f88d3eba6e7e.png', NULL, '0', '1', 'admin', 'admin', '2022-01-11 14:39:02', '2022-01-19 16:13:17');
INSERT INTO `sys_user` VALUES (26, 3, '测试2', '$2a$10$PoNn/.89UjcO1keO9pEL8ecHsLXT1PmZ4sT9H/2erkOs/UBSAoa.K', '测试2', '1', '17703910002', 'cs2@qq.com', 'https://www.qinweizhao.com/upload/2021/11/avatar-9b1b1e49686548049357f88d3eba6e7e.png', NULL, '0', '1', 'admin', 'admin', '2022-01-11 14:43:08', '2022-01-11 22:23:14');
INSERT INTO `sys_user` VALUES (27, 3, '测试3', '', '测试3', '1', '17703910003', 'cs3@qq.com', 'https://www.qinweizhao.com/upload/2021/11/avatar-9b1b1e49686548049357f88d3eba6e7e.png', NULL, '0', '1', 'admin', 'admin', '2022-01-11 14:44:24', '2022-01-17 18:27:04');
INSERT INTO `sys_user` VALUES (28, 3, '测试4', '$2a$10$PoNn/.89UjcO1keO9pEL8ecHsLXT1PmZ4sT9H/2erkOs/UBSAoa.K', '测试4', '1', '17703910004', 'cs4@qq.com', 'https://www.qinweizhao.com/upload/2021/11/avatar-9b1b1e49686548049357f88d3eba6e7e.png', NULL, '0', '1', 'admin', 'admin', '2022-01-11 14:47:24', NULL);
INSERT INTO `sys_user` VALUES (29, 3, '测试5', '$2a$10$PoNn/.89UjcO1keO9pEL8ecHsLXT1PmZ4sT9H/2erkOs/UBSAoa.K', '测试5', '1', '17703910005', 'cs5@qq.com', 'https://www.qinweizhao.com/upload/2021/11/avatar-9b1b1e49686548049357f88d3eba6e7e.png', NULL, '0', '1', 'admin', 'admin', '2022-01-11 14:58:06', NULL);
INSERT INTO `sys_user` VALUES (30, 3, '测试6', '$2a$10$PoNn/.89UjcO1keO9pEL8ecHsLXT1PmZ4sT9H/2erkOs/UBSAoa.K', '测试6', '1', '17703910006', 'cs6@qq.com', 'https://www.qinweizhao.com/upload/2021/11/avatar-9b1b1e49686548049357f88d3eba6e7e.png', NULL, '0', '1', 'admin', 'admin', '2022-01-11 15:00:27', NULL);
INSERT INTO `sys_user` VALUES (31, 2, '测试7', '$2a$10$PoNn/.89UjcO1keO9pEL8ecHsLXT1PmZ4sT9H/2erkOs/UBSAoa.K', '测试7', '1', '17703910007', 'cs7@qq.com', 'https://www.qinweizhao.com/upload/2021/11/avatar-9b1b1e49686548049357f88d3eba6e7e.png', NULL, '0', '1', 'admin', 'admin', '2022-01-11 15:10:08', '2022-01-11 15:10:08');
INSERT INTO `sys_user` VALUES (32, 2, '测试8', '$2a$10$PoNn/.89UjcO1keO9pEL8ecHsLXT1PmZ4sT9H/2erkOs/UBSAoa.K', '测试8', '1', '17703910008', 'cs8@qq.com', 'https://www.qinweizhao.com/upload/2021/11/avatar-9b1b1e49686548049357f88d3eba6e7e.png', 2147483647, '0', '1', 'admin', 'admin', '2022-01-11 15:33:19', '2022-01-11 15:33:19');
INSERT INTO `sys_user` VALUES (33, 2, '测试9', '$2a$10$PoNn/.89UjcO1keO9pEL8ecHsLXT1PmZ4sT9H/2erkOs/UBSAoa.K', '测试9', '1', '17703910009', 'cs9@qq.com', 'https://www.qinweizhao.com/upload/2021/11/avatar-9b1b1e49686548049357f88d3eba6e7e.png', 2147483647, '0', '0', 'admin', 'admin', '2022-01-11 15:40:42', '2022-01-11 15:40:42');
INSERT INTO `sys_user` VALUES (34, NULL, '测试10', '$2a$10$PoNn/.89UjcO1keO9pEL8ecHsLXT1PmZ4sT9H/2erkOs/UBSAoa.K', '测试10', '1', '17703910010', 'cs10@qq.com', 'https://www.qinweizhao.com/upload/2021/11/avatar-9b1b1e49686548049357f88d3eba6e7e.png', 2147483647, '0', '0', 'admin', 'admin', '2022-01-11 15:44:21', '2022-01-11 15:44:21');
INSERT INTO `sys_user` VALUES (35, NULL, '测试11', '$2a$10$PoNn/.89UjcO1keO9pEL8ecHsLXT1PmZ4sT9H/2erkOs/UBSAoa.K', '测试11', '1', '17703910011', 'cs11@qq.com', 'https://www.qinweizhao.com/upload/2021/11/avatar-9b1b1e49686548049357f88d3eba6e7e.png', 2147483647, '0', '0', 'admin', 'admin', '2022-01-11 15:46:43', '2022-01-11 15:46:43');
INSERT INTO `sys_user` VALUES (36, NULL, '测试12', '$2a$10$PoNn/.89UjcO1keO9pEL8ecHsLXT1PmZ4sT9H/2erkOs/UBSAoa.K', '测试12', '1', '17703910012', 'cs12@qq.com', 'https://www.qinweizhao.com/upload/2021/11/avatar-9b1b1e49686548049357f88d3eba6e7e.png', 2147483647, '1', '0', 'admin', 'admin', '2022-01-11 15:48:37', '2022-01-11 15:48:37');
INSERT INTO `sys_user` VALUES (37, NULL, '测试1122', '$2a$10$PoNn/.89UjcO1keO9pEL8ecHsLXT1PmZ4sT9H/2erkOs/UBSAoa.K', '测试1', NULL, '17639106098', 'yvkg2@qq.com', 'https://www.qinweizhao.com/upload/2021/11/avatar-9b1b1e49686548049357f88d3eba6e7e.png', 2147483647, '1', '1', 'admin', 'admin', '2022-01-11 18:22:02', '2022-01-11 18:22:02');

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
INSERT INTO `sys_user_post` VALUES (25, 1);
INSERT INTO `sys_user_post` VALUES (26, 1);
INSERT INTO `sys_user_post` VALUES (27, 1);
INSERT INTO `sys_user_post` VALUES (28, 1);
INSERT INTO `sys_user_post` VALUES (29, 1);
INSERT INTO `sys_user_post` VALUES (30, 1);
INSERT INTO `sys_user_post` VALUES (31, 1);
INSERT INTO `sys_user_post` VALUES (32, 1);
INSERT INTO `sys_user_post` VALUES (33, 1);
INSERT INTO `sys_user_post` VALUES (34, 1);
INSERT INTO `sys_user_post` VALUES (35, 1);

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
INSERT INTO `sys_user_role` VALUES (25, 3);
INSERT INTO `sys_user_role` VALUES (26, 1);
INSERT INTO `sys_user_role` VALUES (26, 3);

SET FOREIGN_KEY_CHECKS = 1;
