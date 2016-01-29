
BEGIN;
INSERT INTO `a_dicts` VALUES ('goods', '商品信息', '表示商品信息', 'ab_goods', '商品'), ('index_mall', '商城首页活动', 'index_mall', 'ac_mall_activity', '商城活动'), ('no', '不可用', '当前状态为不可用', 'a_state', '信息状态'), ('yes', '可用', '当前状态为可用', 'a_state', '信息状态');
COMMIT;

INSERT INTO `a_managers` VALUES ('wuye', '123456', '五爷');

BEGIN;
INSERT INTO `ab_brands` VALUES ('1', 'goods', '欧珀莱'), ('2', 'goods', '一叶子');
COMMIT;


-- ----------------------------
-- Records of ab_goods
-- ----------------------------
BEGIN;
INSERT INTO `ab_goods` VALUES ('1', '1', '1', 'AUPRES欧珀莱涌泉系列', '保湿', null, null, null, 'yes'), ('10', '1', '1', '美白系列套装8', '美白', '', '', '', 'yes'), ('11', '1', '1', '美白系列套装9', '美白', '', '', '', 'yes'), ('12', '1', '1', '美白系列套装8', '美白', '', '', '', 'yes'), ('2', '1', '1', '欧珀莱美白系列', '美白', null, null, null, 'no'), ('3', '1', '1', '美白系列套装1', '美白', null, null, null, 'yes'), ('5', '1', '1', '美白系列套装3', '美白', '', '', '', 'yes'), ('6', '1', '1', '美白系列套装4', '美白', '', '', '', 'yes'), ('7', '1', '1', '美白系列套装5', '美白', '', '', '', 'yes'), ('8', '1', '1', '美白系列套装6', '美白', '', '', '', 'yes'), ('9', '1', '1', '美白系列套装7', '美白', '', '', '', 'yes');
COMMIT;

-- ----------------------------
-- Records of ab_types
-- ----------------------------
BEGIN;
INSERT INTO `ab_types` VALUES ('1', 'goods', '0', '护肤'), ('2', 'goods', '0', '彩妆'), ('3', 'goods', '0', '香水');
COMMIT;

-- ----------------------------
-- Records of ac_mall_activity
-- ----------------------------
BEGIN;
INSERT INTO `ac_mall_activity` VALUES ('1', '今日爆款', '今日爆款', 'index_mall', '每日10点上新', '2016-01-05 11:22:12', 'wuye', 'yes'), ('2', '品牌闪购', '品牌闪购', 'index_mall', '每日10点 准时开抢', '2016-01-05 11:23:02', 'wuye', 'yes');
COMMIT;

-- ----------------------------
-- Records of ac_mall_activity_goods
-- ----------------------------
BEGIN;
INSERT INTO `ac_mall_activity_goods` VALUES ('1', '1', '1', '2016-01-05 11:23:27', 'yes'), ('2', '1', '2', '2016-01-05 14:41:43', 'yes'), ('3', '2', '1', '2016-01-05 14:41:58', 'yes'), ('4', '2', '2', '2016-01-05 14:42:02', 'yes');
COMMIT;
