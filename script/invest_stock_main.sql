/*
 Navicat Premium Data Transfer

 Source Server         : scale
 Source Server Type    : MySQL
 Source Server Version : 50729
 Source Host           : localhost:3306
 Source Schema         : invest_fof

 Target Server Type    : MySQL
 Target Server Version : 50729
 File Encoding         : 65001

 Date: 09/01/2022 23:55:50
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for invest_stock_main
-- ----------------------------
DROP TABLE IF EXISTS `invest_stock_main`;
CREATE TABLE `invest_stock_main`  (
  `id` bigint(50) NOT NULL COMMENT 'id',
  `trade_date` int(20) NOT NULL COMMENT '交易日',
  `stock_code` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '证券名称',
  `stock_name` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '证券代码 ',
  `new_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '最新价格',
  `change_amount` decimal(10, 2) NULL DEFAULT NULL COMMENT '涨跌额度',
  `price_limit` decimal(10, 2) NULL DEFAULT NULL COMMENT '涨跌幅',
  `create_time` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of invest_stock_main
-- ----------------------------
INSERT INTO `invest_stock_main` VALUES (1479741994135728130, 20220108, 'BK1051', '昨日连板_含一字', 1397.55, 45.13, 3.34, '17:09:18.093', '17:09:18.093');
INSERT INTO `invest_stock_main` VALUES (1479741994731319298, 20220108, 'BK0822', '租售同权', 809.13, 19.19, 2.38, '17:09:18.476', '17:09:18.476');
INSERT INTO `invest_stock_main` VALUES (1479741994769068033, 20220108, 'BK0841', '体外诊断', 1601.17, 36.14, 2.27, '17:09:18.485', '17:09:18.485');
INSERT INTO `invest_stock_main` VALUES (1479741994785845250, 20220108, 'BK0563', '油价相关', 5057.79, 93.56, 1.85, '17:09:18.491', '17:09:18.491');
INSERT INTO `invest_stock_main` VALUES (1479741994815205377, 20220108, 'BK0979', '低碳冶金', 1280.85, 21.27, -1.66, '17:09:18.498', '17:09:18.499');
INSERT INTO `invest_stock_main` VALUES (1479741994857148418, 20220108, 'BK0992', 'REITs概念', 960.41, 11.06, 1.15, '17:09:18.506', '17:09:18.506');
INSERT INTO `invest_stock_main` VALUES (1479741994920062977, 20220108, 'BK0818', '可燃冰', 1134.78, 10.89, 0.96, '17:09:18.521', '17:09:18.521');
INSERT INTO `invest_stock_main` VALUES (1479741994936840194, 20220108, 'BK0991', '工程机械概念', 1068.77, 9.26, -0.87, '17:09:18.527', '17:09:18.527');
INSERT INTO `invest_stock_main` VALUES (1479741994966200321, 20220108, 'BK0849', '京东金融', 1161.07, 6.00, 0.52, '17:09:18.538', '17:09:18.538');
INSERT INTO `invest_stock_main` VALUES (1479741994966200322, 20220108, 'BK0611', '上证50_', 1943.84, 9.86, 0.51, '17:09:18.547', '17:09:18.547');
INSERT INTO `invest_stock_main` VALUES (1479741994966200323, 20220108, 'BK0724', '海绵城市', 806.95, 4.07, 0.51, '17:09:18.559', '17:09:18.559');
INSERT INTO `invest_stock_main` VALUES (1479741994966200324, 20220108, 'BK0881', '3D玻璃', 938.98, 3.32, -0.35, '17:09:18.569', '17:09:18.569');
INSERT INTO `invest_stock_main` VALUES (1479741995133972482, 20220108, 'BK0499', 'AH股', 6709.01, 22.66, 0.34, '17:09:18.580', '17:09:18.580');
INSERT INTO `invest_stock_main` VALUES (1479741995205275649, 20220108, 'BK0945', '装配建筑', 1028.68, 3.43, 0.33, '17:09:18.590', '17:09:18.590');
INSERT INTO `invest_stock_main` VALUES (1479741995247218689, 20220108, 'BK0868', 'GDR', 1168.00, 3.75, 0.32, '17:09:18.599', '17:09:18.599');
INSERT INTO `invest_stock_main` VALUES (1479741995381436417, 20220108, 'BK0947', '屏下摄像', 988.03, 1.29, 0.13, '17:09:18.631', '17:09:18.631');
INSERT INTO `invest_stock_main` VALUES (1479741995456933890, 20220108, 'BK0505', '中字头', 6239.94, 7.55, 0.12, '17:09:18.652', '17:09:18.652');
INSERT INTO `invest_stock_main` VALUES (1479741995503071234, 20220108, 'BK0999', '茅指数', 873.09, 1.05, 0.12, '17:09:18.661', '17:09:18.661');
INSERT INTO `invest_stock_main` VALUES (1479741995524042754, 20220108, 'BK0806', '精准医疗', 1201.03, 1.38, 0.11, '17:09:18.666', '17:09:18.666');
INSERT INTO `invest_stock_main` VALUES (1479741995578568705, 20220108, 'BK0606', '油气设服', 1467.70, 1.50, 0.10, '17:09:18.678', '17:09:18.678');
INSERT INTO `invest_stock_main` VALUES (1479883897439293442, 20220109, 'BK1051', '昨日连板_含一字', 1397.55, 45.13, 3.34, '02:33:10.530', '02:33:10.531');
INSERT INTO `invest_stock_main` VALUES (1479883897611259905, 20220109, 'BK0822', '租售同权', 809.13, 19.19, 2.38, '02:33:10.762', '02:33:10.762');
INSERT INTO `invest_stock_main` VALUES (1479883897611259906, 20220109, 'BK0841', '体外诊断', 1601.17, 36.14, 2.27, '02:33:10.771', '02:33:10.772');
INSERT INTO `invest_stock_main` VALUES (1479883897611259907, 20220109, 'BK0563', '油价相关', 5057.79, 93.56, 1.85, '02:33:10.776', '02:33:10.776');
INSERT INTO `invest_stock_main` VALUES (1479883897611259908, 20220109, 'BK0979', '低碳冶金', 1280.85, 21.27, 1.66, '02:33:10.784', '02:33:10.784');
INSERT INTO `invest_stock_main` VALUES (1479883897770643458, 20220109, 'BK0992', 'REITs概念', 960.41, 11.06, 2.15, '02:33:10.800', '02:33:10.800');
INSERT INTO `invest_stock_main` VALUES (1479883897808392193, 20220109, 'BK0818', '可燃冰', 1134.78, 10.89, -0.36, '02:33:10.809', '02:33:10.809');
INSERT INTO `invest_stock_main` VALUES (1479883897850335234, 20220109, 'BK0991', '工程机械概念', 1068.77, 9.26, 0.87, '02:33:10.820', '02:33:10.821');
INSERT INTO `invest_stock_main` VALUES (1479883897850335235, 20220109, 'BK0849', '京东金融', 1161.07, 6.00, 0.52, '02:33:10.827', '02:33:10.827');
INSERT INTO `invest_stock_main` VALUES (1479883897913249793, 20220109, 'BK0611', '上证50_', 1943.84, 9.86, 0.51, '02:33:10.832', '02:33:10.832');
INSERT INTO `invest_stock_main` VALUES (1479883897913249794, 20220109, 'BK0724', '海绵城市', 806.95, 4.07, 4.21, '02:33:10.848', '02:33:10.848');
INSERT INTO `invest_stock_main` VALUES (1479883897913249795, 20220109, 'BK0881', '3D玻璃', 938.98, 3.32, 0.35, '02:33:10.856', '02:33:10.856');
INSERT INTO `invest_stock_main` VALUES (1479883897913249796, 20220109, 'BK0499', 'AH股', 6709.01, 22.66, -3.34, '02:33:10.860', '02:33:10.861');
INSERT INTO `invest_stock_main` VALUES (1479883897913249797, 20220109, 'BK0945', '装配建筑', 1028.68, 2.60, 0.33, '02:33:10.868', '02:33:10.868');
INSERT INTO `invest_stock_main` VALUES (1479883898156519425, 20220109, 'BK0868', 'GDR', 1168.00, -3.75, 0.32, '02:33:10.888', '02:33:10.888');
INSERT INTO `invest_stock_main` VALUES (1479883898244599809, 20220109, 'BK0947', '屏下摄像', 988.03, 1.29, -2.13, '02:33:10.917', '02:33:10.917');
INSERT INTO `invest_stock_main` VALUES (1479883898294931457, 20220109, 'BK0505', '中字头', 6239.94, -7.55, 0.12, '02:33:10.941', '02:33:10.941');
INSERT INTO `invest_stock_main` VALUES (1479883898429149186, 20220109, 'BK0999', '茅指数', 873.09, 1.05, -0.12, '02:33:10.956', '02:33:10.956');
INSERT INTO `invest_stock_main` VALUES (1479883898450120706, 20220109, 'BK0806', '精准医疗', 1201.03, 1.38, -2.30, '02:33:10.964', '02:33:10.965');
INSERT INTO `invest_stock_main` VALUES (1479883898504646658, 20220109, 'BK0606', '油气设服', 1467.70, -1.50, -0.80, '02:33:10.973', '02:33:10.973');

SET FOREIGN_KEY_CHECKS = 1;
