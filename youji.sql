/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 50721
 Source Host           : localhost:3306
 Source Schema         : youji

 Target Server Type    : MySQL
 Target Server Version : 50721
 File Encoding         : 65001

 Date: 07/05/2019 22:46:20
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
  `category_id` int(255) NOT NULL COMMENT '主键',
  `category_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '类别名称',
  PRIMARY KEY (`category_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for elf
-- ----------------------------
DROP TABLE IF EXISTS `elf`;
CREATE TABLE `elf`  (
  `elf_id` int(255) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` int(11) NOT NULL COMMENT '外键',
  `nickname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '昵称',
  `experience_value` int(255) NOT NULL COMMENT '经验值',
  PRIMARY KEY (`elf_id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  CONSTRAINT `elf_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of elf
-- ----------------------------
INSERT INTO `elf` VALUES (1, 1, '嘿嘿哈嘿', 12);

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods`  (
  `goods_id` int(11) NOT NULL COMMENT '主键',
  `category_id` int(11) NOT NULL COMMENT '外键',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品名称',
  `price` decimal(10, 2) NOT NULL COMMENT '商品价格',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品描述',
  PRIMARY KEY (`goods_id`) USING BTREE,
  INDEX `category_id`(`category_id`) USING BTREE,
  CONSTRAINT `goods_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `category` (`category_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for image
-- ----------------------------
DROP TABLE IF EXISTS `image`;
CREATE TABLE `image`  (
  `image_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` int(11) NOT NULL COMMENT '外键',
  `image_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '照片名称',
  `image_src` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '照片的保存路径',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '说说',
  `attraction_id` int(11) NOT NULL COMMENT '外键',
  `longitude` decimal(10, 7) NULL DEFAULT NULL COMMENT '经度',
  `latitude` decimal(10, 7) NULL DEFAULT NULL COMMENT '纬度',
  `number_of_likes` int(10) UNSIGNED ZEROFILL NOT NULL COMMENT '点赞数 Default 0',
  `sharing` int(255) UNSIGNED ZEROFILL NOT NULL COMMENT '分享 Default 0（不分享）',
  `add_time` datetime(0) NOT NULL COMMENT '拍照时间',
  PRIMARY KEY (`image_id`) USING BTREE,
  INDEX `attraction_id`(`attraction_id`) USING BTREE,
  INDEX `image_ibfk_1`(`user_id`) USING BTREE,
  CONSTRAINT `image_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of image
-- ----------------------------
INSERT INTO `image` VALUES (1, 1, 'hah', 'D:\\Desktop\\照片\\a.png', 'dd', 1, 11.0000000, 7.0000000, 0000000001, 000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001, '2019-05-07 14:56:45');

-- ----------------------------
-- Table structure for reloading
-- ----------------------------
DROP TABLE IF EXISTS `reloading`;
CREATE TABLE `reloading`  (
  `reloading_id` int(11) NOT NULL COMMENT '主键',
  `elf_id` int(11) NOT NULL COMMENT '外键',
  `goods_id` int(11) NOT NULL COMMENT '外键',
  `price` decimal(10, 2) NULL DEFAULT NULL COMMENT '购买价格',
  `add_time` datetime(0) NOT NULL COMMENT '购买时间',
  `status` int(255) NOT NULL COMMENT '0-不启用，1-启用',
  PRIMARY KEY (`reloading_id`) USING BTREE,
  INDEX `goods_id`(`goods_id`) USING BTREE,
  INDEX `elf_id`(`elf_id`) USING BTREE,
  CONSTRAINT `reloading_ibfk_2` FOREIGN KEY (`goods_id`) REFERENCES `goods` (`goods_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `reloading_ibfk_3` FOREIGN KEY (`elf_id`) REFERENCES `elf` (`elf_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tourist_attraction
-- ----------------------------
DROP TABLE IF EXISTS `tourist_attraction`;
CREATE TABLE `tourist_attraction`  (
  `attraction_id` int(11) NOT NULL COMMENT '主键',
  `attraction_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '景点名称',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地址',
  `longitude` decimal(10, 7) NULL DEFAULT NULL COMMENT '经度',
  `latitude` decimal(10, 7) NULL DEFAULT NULL COMMENT '纬度',
  `experience_value` int(255) UNSIGNED ZEROFILL NOT NULL COMMENT '经验值 Default 0',
  PRIMARY KEY (`attraction_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tourist_attraction
-- ----------------------------
INSERT INTO `tourist_attraction` VALUES (1, '1', '1', 1.0000000, 1.0000000, 000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001);

-- ----------------------------
-- Table structure for travel
-- ----------------------------
DROP TABLE IF EXISTS `travel`;
CREATE TABLE `travel`  (
  `travel_id` int(11) NOT NULL COMMENT '主键',
  `user_id` int(11) NOT NULL COMMENT '外键',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标题',
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '内容',
  `attraction_id` int(11) NOT NULL COMMENT '外键',
  `longitude` decimal(10, 7) NULL DEFAULT NULL COMMENT '经度',
  `latitude` decimal(10, 7) NULL DEFAULT NULL COMMENT '纬度',
  `number_of_likes` int(10) UNSIGNED ZEROFILL NOT NULL COMMENT '点赞数 Default 0',
  `sharing` int(10) UNSIGNED ZEROFILL NOT NULL COMMENT '分享 Default 0（不分享）',
  `add_time` datetime(0) NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`travel_id`) USING BTREE,
  INDEX `attraction_id`(`attraction_id`) USING BTREE,
  INDEX `travel_ibfk_1`(`user_id`) USING BTREE,
  CONSTRAINT `travel_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `travel_ibfk_2` FOREIGN KEY (`attraction_id`) REFERENCES `tourist_attraction` (`attraction_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID 主键',
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户密码',
  `role` int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '用户角色',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户真实姓名',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户邮箱',
  `gender` tinyint(1) NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', '777', 0000000001, NULL, NULL, NULL);
INSERT INTO `user` VALUES (2, 'admub', '666666', NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (3, 'admin1', '666666', NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (4, '555', '555', NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (5, '999', '999', NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for wallet
-- ----------------------------
DROP TABLE IF EXISTS `wallet`;
CREATE TABLE `wallet`  (
  `wallet_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `balance` decimal(10, 7) UNSIGNED ZEROFILL NOT NULL,
  PRIMARY KEY (`wallet_id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  CONSTRAINT `wallet_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
