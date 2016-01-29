/*
Navicat MySQL Data Transfer

Source Server         : loc
Source Server Version : 50096
Source Host           : 127.0.0.1:3306
Source Database       : newday

Target Server Type    : MYSQL
Target Server Version : 50096
File Encoding         : 65001

Date: 2016-01-11 19:29:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for a_dicts
-- ----------------------------
DROP TABLE IF EXISTS `a_dicts`;
CREATE TABLE `a_dicts` (
`code`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`name`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`detailinfo`  text CHARACTER SET utf8 COLLATE utf8_general_ci NULL ,
`type`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`typedetail`  text CHARACTER SET utf8 COLLATE utf8_general_ci NULL ,
PRIMARY KEY (`code`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Records of a_dicts
-- ----------------------------
BEGIN;
INSERT INTO `a_dicts` VALUES ('goods', '商品信息', '表示商品信息', 'ab_goods', '商品'), ('index_mall', '商城首页活动', 'index_mall', 'ac_mall_activity', '商城活动'), ('no', '不可用', '当前状态为不可用', 'a_state', '信息状态'), ('yes', '可用', '当前状态为可用', 'a_state', '信息状态');
COMMIT;

-- ----------------------------
-- Table structure for a_files
-- ----------------------------
DROP TABLE IF EXISTS `a_files`;
CREATE TABLE `a_files` (
`id`  int(11) NOT NULL AUTO_INCREMENT ,
`filename`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`dir`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`type`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
/*!50003 AUTO_INCREMENT=1 */

;

-- ----------------------------
-- Records of a_files
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for a_managers
-- ----------------------------
DROP TABLE IF EXISTS `a_managers`;
CREATE TABLE `a_managers` (
`code`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`password`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`name`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`code`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Records of a_managers
-- ----------------------------
BEGIN;
INSERT INTO `a_managers` VALUES ('wuye', '123456', '五爷');
COMMIT;

-- ----------------------------
-- Table structure for a_menus
-- ----------------------------
DROP TABLE IF EXISTS `a_menus`;
CREATE TABLE `a_menus` (
`id`  int(11) NOT NULL ,
`name`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`type`  char(3) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`level`  int(11) NULL DEFAULT NULL ,
`orderid`  int(11) NULL DEFAULT NULL ,
`pid`  int(11) NULL DEFAULT NULL ,
`status`  char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`usercode`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`createtime`  date NULL DEFAULT NULL ,
PRIMARY KEY (`id`),
FOREIGN KEY (`usercode`) REFERENCES `a_managers` (`code`) ON DELETE RESTRICT ON UPDATE RESTRICT,
INDEX `FK_user_menu` USING BTREE (`usercode`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='InnoDB free: 4096 kB; (`usercode`) REFER `newday/a_managers`(`code`)'

;

-- ----------------------------
-- Records of a_menus
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for a_users
-- ----------------------------
DROP TABLE IF EXISTS `a_users`;
CREATE TABLE `a_users` (
`code`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`password`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`name`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`code`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Records of a_users
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for ab_brands
-- ----------------------------
DROP TABLE IF EXISTS `ab_brands`;
CREATE TABLE `ab_brands` (
`id`  int(11) NOT NULL ,
`type`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`name`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`id`),
FOREIGN KEY (`type`) REFERENCES `a_dicts` (`code`) ON DELETE RESTRICT ON UPDATE RESTRICT,
INDEX `FK_brand_dict` USING BTREE (`type`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='InnoDB free: 4096 kB; (`type`) REFER `newday/a_dicts`(`code`)'

;

-- ----------------------------
-- Records of ab_brands
-- ----------------------------
BEGIN;
INSERT INTO `ab_brands` VALUES ('1', 'goods', '欧珀莱'), ('2', 'goods', '一叶子');
COMMIT;

-- ----------------------------
-- Table structure for ab_goods
-- ----------------------------
DROP TABLE IF EXISTS `ab_goods`;
CREATE TABLE `ab_goods` (
`id`  char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`type`  int(11) NULL DEFAULT NULL ,
`brand`  int(11) NULL DEFAULT NULL ,
`name`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`effect`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`spec`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`area`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`packing`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`state`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`id`),
FOREIGN KEY (`state`) REFERENCES `a_dicts` (`code`) ON DELETE RESTRICT ON UPDATE RESTRICT,
FOREIGN KEY (`brand`) REFERENCES `ab_brands` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
FOREIGN KEY (`type`) REFERENCES `ab_types` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
INDEX `FK_good_brand` USING BTREE (`brand`),
INDEX `FK_good_type` USING BTREE (`type`),
INDEX `FK_goods_state` USING BTREE (`state`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='InnoDB free: 4096 kB; (`state`) REFER `newday/a_dicts`(`code`); (`brand`) REFER '

;

-- ----------------------------
-- Records of ab_goods
-- ----------------------------
BEGIN;
INSERT INTO `ab_goods` VALUES ('1', '1', '1', 'AUPRES欧珀莱涌泉系列', '保湿', null, null, null, 'yes'), ('10', '1', '1', '美白系列套装8', '美白', '', '', '', 'yes'), ('11', '1', '1', '美白系列套装9', '美白', '', '', '', 'yes'), ('12', '1', '1', '美白系列套装8', '美白', '', '', '', 'yes'), ('2', '1', '1', '欧珀莱美白系列', '美白', null, null, null, 'no'), ('3', '1', '1', '美白系列套装1', '美白', null, null, null, 'yes'), ('5', '1', '1', '美白系列套装3', '美白', '', '', '', 'yes'), ('6', '1', '1', '美白系列套装4', '美白', '', '', '', 'yes'), ('7', '1', '1', '美白系列套装5', '美白', '', '', '', 'yes'), ('8', '1', '1', '美白系列套装6', '美白', '', '', '', 'yes'), ('9', '1', '1', '美白系列套装7', '美白', '', '', '', 'yes');
COMMIT;

-- ----------------------------
-- Table structure for ab_types
-- ----------------------------
DROP TABLE IF EXISTS `ab_types`;
CREATE TABLE `ab_types` (
`id`  int(11) NOT NULL ,
`dictcode`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`pid`  int(11) NULL DEFAULT NULL ,
`name`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`id`),
FOREIGN KEY (`dictcode`) REFERENCES `a_dicts` (`code`) ON DELETE RESTRICT ON UPDATE RESTRICT,
INDEX `FK_type_dict` USING BTREE (`dictcode`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='InnoDB free: 4096 kB; (`dictcode`) REFER `newday/a_dicts`(`code`)'

;

-- ----------------------------
-- Records of ab_types
-- ----------------------------
BEGIN;
INSERT INTO `ab_types` VALUES ('1', 'goods', '0', '护肤'), ('2', 'goods', '0', '彩妆'), ('3', 'goods', '0', '香水');
COMMIT;

-- ----------------------------
-- Table structure for ac_mall_activity
-- ----------------------------
DROP TABLE IF EXISTS `ac_mall_activity`;
CREATE TABLE `ac_mall_activity` (
`id`  int(11) NOT NULL ,
`title`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`name`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`dictcode`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`detailinfo`  text CHARACTER SET utf8 COLLATE utf8_general_ci NULL ,
`createtime`  datetime NULL DEFAULT NULL ,
`mcode`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`state`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`id`),
FOREIGN KEY (`dictcode`) REFERENCES `a_dicts` (`code`) ON DELETE RESTRICT ON UPDATE RESTRICT,
FOREIGN KEY (`mcode`) REFERENCES `a_managers` (`code`) ON DELETE RESTRICT ON UPDATE RESTRICT,
INDEX `FK_Reference_9` USING BTREE (`mcode`),
INDEX `FK_Mall_Activity_Type` USING BTREE (`dictcode`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='InnoDB free: 4096 kB; (`dictcode`) REFER `newday/a_dicts`(`code`); (`mcode`) REF'

;

-- ----------------------------
-- Records of ac_mall_activity
-- ----------------------------
BEGIN;
INSERT INTO `ac_mall_activity` VALUES ('1', '今日爆款', '今日爆款', 'index_mall', '每日10点上新', '2016-01-05 11:22:12', 'wuye', 'yes'), ('2', '品牌闪购', '品牌闪购', 'index_mall', '每日10点 准时开抢', '2016-01-05 11:23:02', 'wuye', 'yes');
COMMIT;

-- ----------------------------
-- Table structure for ac_mall_activity_goods
-- ----------------------------
DROP TABLE IF EXISTS `ac_mall_activity_goods`;
CREATE TABLE `ac_mall_activity_goods` (
`id`  int(11) NOT NULL ,
`mallid`  int(11) NULL DEFAULT NULL ,
`goodid`  char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`createtime`  datetime NULL DEFAULT NULL ,
`state`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`id`),
FOREIGN KEY (`goodid`) REFERENCES `ab_goods` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
FOREIGN KEY (`mallid`) REFERENCES `ac_mall_activity` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
INDEX `FK_mallactivitylist_mallactivity` USING BTREE (`mallid`),
INDEX `FK_mallactivitylist_goods` USING BTREE (`goodid`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='InnoDB free: 4096 kB; (`goodid`) REFER `newday/ab_goods`(`id`); (`mallid`) REFER'

;

-- ----------------------------
-- Records of ac_mall_activity_goods
-- ----------------------------
BEGIN;
INSERT INTO `ac_mall_activity_goods` VALUES ('1', '1', '1', '2016-01-05 11:23:27', 'yes'), ('2', '1', '2', '2016-01-05 14:41:43', 'yes'), ('3', '2', '1', '2016-01-05 14:41:58', 'yes'), ('4', '2', '2', '2016-01-05 14:42:02', 'yes');
COMMIT;

-- ----------------------------
-- Auto increment value for a_files
-- ----------------------------
ALTER TABLE `a_files` AUTO_INCREMENT=1;
