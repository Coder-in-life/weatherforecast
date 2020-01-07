/*
 Navicat MySQL Data Transfer

 Source Server         : weatherforecast
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : localhost:3306
 Source Schema         : weatherforecast

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 06/01/2020 19:56:02
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for city
-- ----------------------------
DROP TABLE IF EXISTS `city`;
CREATE TABLE `city`  (
  `CityName` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `CityNum` int(11) NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of city
-- ----------------------------
INSERT INTO `city` VALUES ('北京市市辖区', 110100);
INSERT INTO `city` VALUES ('天津市市辖区', 120100);
INSERT INTO `city` VALUES ('石家庄市', 130100);
INSERT INTO `city` VALUES ('太原市', 140100);
INSERT INTO `city` VALUES ('呼和浩特市', 150100);
INSERT INTO `city` VALUES ('沈阳市', 210100);
INSERT INTO `city` VALUES ('长春市', 220100);
INSERT INTO `city` VALUES ('哈尔滨市', 230100);
INSERT INTO `city` VALUES ('上海市市辖区', 310100);
INSERT INTO `city` VALUES ('南京市', 320100);
INSERT INTO `city` VALUES ('杭州市', 330100);
INSERT INTO `city` VALUES ('合肥市', 340100);
INSERT INTO `city` VALUES ('福州市', 350100);
INSERT INTO `city` VALUES ('南昌市', 360100);
INSERT INTO `city` VALUES ('济南市', 370100);
INSERT INTO `city` VALUES ('郑州市', 410100);
INSERT INTO `city` VALUES ('武汉市', 420100);
INSERT INTO `city` VALUES ('长沙市', 430100);
INSERT INTO `city` VALUES ('广州市', 440100);
INSERT INTO `city` VALUES ('南宁市', 450100);
INSERT INTO `city` VALUES ('海口市', 460100);
INSERT INTO `city` VALUES ('重庆市市辖区', 500100);
INSERT INTO `city` VALUES ('成都市', 510100);
INSERT INTO `city` VALUES ('贵阳市', 520100);
INSERT INTO `city` VALUES ('昆明市', 530100);
INSERT INTO `city` VALUES ('拉萨市', 540100);
INSERT INTO `city` VALUES ('西安市', 610100);
INSERT INTO `city` VALUES ('兰州市', 620100);
INSERT INTO `city` VALUES ('西宁市', 630100);
INSERT INTO `city` VALUES ('银川市', 640100);
INSERT INTO `city` VALUES ('乌鲁木齐市', 650100);

-- ----------------------------
-- Table structure for weather
-- ----------------------------
DROP TABLE IF EXISTS `weather`;
CREATE TABLE `weather`  (
  `id` int(11) NULL DEFAULT NULL,
  `date` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `week` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `dayweather` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `nightweather` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `daytemp` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `nighttemp` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `daywind` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `nightwind` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `daypower` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `nightpower` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of weather
-- ----------------------------
INSERT INTO `weather` VALUES (1101001, '2020-01-06', '1', '阴', '多云', '3', '-2', '无风向', '无风向', '4', '4');
INSERT INTO `weather` VALUES (1101002, '2020-01-07', '2', '多云', '晴', '4', '-4', '无风向', '无风向', '≤3', '≤3');
INSERT INTO `weather` VALUES (1101003, '2020-01-08', '3', '晴', '晴', '5', '-7', '西南', '西南', '≤3', '≤3');
INSERT INTO `weather` VALUES (1101004, '2020-01-09', '4', '多云', '多云', '3', '-7', '西北', '西北', '≤3', '≤3');
INSERT INTO `weather` VALUES (1201001, '2020-01-06', '1', '阴', '多云', '1', '0', '东北', '东北', '5', '5');
INSERT INTO `weather` VALUES (1201002, '2020-01-07', '2', '多云', '多云', '3', '-3', '北', '北', '5', '5');
INSERT INTO `weather` VALUES (1201003, '2020-01-08', '3', '晴', '晴', '4', '-4', '西南', '西南', '≤3', '≤3');
INSERT INTO `weather` VALUES (1201004, '2020-01-09', '4', '晴', '晴', '4', '-4', '西南', '西南', '≤3', '≤3');
INSERT INTO `weather` VALUES (1301001, '2020-01-06', '1', '中雪', '小雪', '1', '-1', '无风向', '无风向', '≤3', '≤3');
INSERT INTO `weather` VALUES (1301002, '2020-01-07', '2', '小雪', '多云', '2', '-4', '无风向', '无风向', '≤3', '≤3');
INSERT INTO `weather` VALUES (1301003, '2020-01-08', '3', '晴', '晴', '3', '-4', '北', '北', '≤3', '≤3');
INSERT INTO `weather` VALUES (1301004, '2020-01-09', '4', '多云', '多云', '2', '-5', '北', '北', '≤3', '≤3');
INSERT INTO `weather` VALUES (1401001, '2020-01-06', '1', '多云', '小雪', '1', '-3', '东北', '东北', '≤3', '≤3');
INSERT INTO `weather` VALUES (1401002, '2020-01-07', '2', '雨夹雪', '晴', '1', '-9', '西', '西', '≤3', '≤3');
INSERT INTO `weather` VALUES (1401003, '2020-01-08', '3', '多云', '多云', '3', '-9', '东南', '东南', '≤3', '≤3');
INSERT INTO `weather` VALUES (1401004, '2020-01-09', '4', '阴', '多云', '3', '-7', '北', '北', '≤3', '≤3');
INSERT INTO `weather` VALUES (1501001, '2020-01-06', '1', '多云', '多云', '-2', '-13', '东北', '东北', '≤3', '≤3');
INSERT INTO `weather` VALUES (1501002, '2020-01-07', '2', '多云', '多云', '-3', '-15', '南', '南', '≤3', '≤3');
INSERT INTO `weather` VALUES (1501003, '2020-01-08', '3', '晴', '多云', '-4', '-15', '西', '西', '≤3', '≤3');
INSERT INTO `weather` VALUES (1501004, '2020-01-09', '4', '多云', '多云', '-2', '-14', '北', '北', '≤3', '≤3');
INSERT INTO `weather` VALUES (2101001, '2020-01-06', '1', '雨夹雪', '阵雪', '1', '-8', '无风向', '无风向', '4', '4');
INSERT INTO `weather` VALUES (2101002, '2020-01-07', '2', '晴', '多云', '-6', '-13', '无风向', '无风向', '5', '5');
INSERT INTO `weather` VALUES (2101003, '2020-01-08', '3', '多云', '多云', '-7', '-17', '北', '北', '≤3', '≤3');
INSERT INTO `weather` VALUES (2101004, '2020-01-09', '4', '晴', '晴', '-3', '-14', '南', '南', '≤3', '≤3');
INSERT INTO `weather` VALUES (2201001, '2020-01-06', '1', '阴', '小雪', '-1', '-12', '西北', '西北', '≤3', '≤3');
INSERT INTO `weather` VALUES (2201002, '2020-01-07', '2', '多云', '阵雪', '-9', '-14', '无风向', '无风向', '≤3', '≤3');
INSERT INTO `weather` VALUES (2201003, '2020-01-08', '3', '阵雪', '多云', '-9', '-18', '西南', '西南', '≤3', '≤3');
INSERT INTO `weather` VALUES (2201004, '2020-01-09', '4', '多云', '晴', '-7', '-17', '西南', '西南', '≤3', '≤3');
INSERT INTO `weather` VALUES (2301001, '2020-01-06', '1', '阴', '中雪', '-7', '-12', '东南', '东南', '≤3', '≤3');
INSERT INTO `weather` VALUES (2301002, '2020-01-07', '2', '小雪', '多云', '-9', '-19', '东北', '东北', '≤3', '≤3');
INSERT INTO `weather` VALUES (2301003, '2020-01-08', '3', '晴', '晴', '-13', '-24', '西北', '西北', '≤3', '≤3');
INSERT INTO `weather` VALUES (2301004, '2020-01-09', '4', '晴', '晴', '-11', '-25', '西', '西', '≤3', '≤3');
INSERT INTO `weather` VALUES (3101001, '2020-01-06', '1', '多云', '多云', '21', '13', '东', '东', '≤3', '≤3');
INSERT INTO `weather` VALUES (3101002, '2020-01-07', '2', '小雨', '阴', '21', '5', '西', '西', '6', '6');
INSERT INTO `weather` VALUES (3101003, '2020-01-08', '3', '多云', '阴', '6', '4', '西北', '西北', '5', '5');
INSERT INTO `weather` VALUES (3101004, '2020-01-09', '4', '小雨', '小雨', '9', '6', '北', '北', '≤3', '≤3');
INSERT INTO `weather` VALUES (3201001, '2020-01-06', '1', '阴', '小雨', '12', '8', '西北', '西北', '≤3', '≤3');
INSERT INTO `weather` VALUES (3201002, '2020-01-07', '2', '小雨', '阴', '9', '2', '西北', '西北', '6', '6');
INSERT INTO `weather` VALUES (3201003, '2020-01-08', '3', '多云', '阴', '6', '2', '东北', '东北', '4', '4');
INSERT INTO `weather` VALUES (3201004, '2020-01-09', '4', '小雨', '小雨', '5', '2', '东', '东', '4', '4');
INSERT INTO `weather` VALUES (3301001, '2020-01-06', '1', '雾', '多云', '24', '11', '西', '西', '4', '4');
INSERT INTO `weather` VALUES (3301002, '2020-01-07', '2', '小雨', '阴', '22', '4', '西', '西', '5', '5');
INSERT INTO `weather` VALUES (3301003, '2020-01-08', '3', '阴', '多云', '8', '1', '无风向', '无风向', '≤3', '≤3');
INSERT INTO `weather` VALUES (3301004, '2020-01-09', '4', '阴', '阴', '10', '3', '东', '东', '4', '4');
INSERT INTO `weather` VALUES (3401001, '2020-01-06', '1', '中雨', '中雨', '7', '6', '西北', '西北', '4', '4');
INSERT INTO `weather` VALUES (3401002, '2020-01-07', '2', '小雨', '阴', '8', '2', '西北', '西北', '4', '4');
INSERT INTO `weather` VALUES (3401003, '2020-01-08', '3', '阴', '小雨', '6', '1', '东北', '东北', '≤3', '≤3');
INSERT INTO `weather` VALUES (3401004, '2020-01-09', '4', '小雨', '小雨', '4', '1', '东', '东', '4', '4');
INSERT INTO `weather` VALUES (3501001, '2020-01-06', '1', '多云', '阴', '27', '15', '南', '南', '4', '4');
INSERT INTO `weather` VALUES (3501002, '2020-01-07', '2', '多云', '晴', '27', '11', '无风向', '无风向', '≤3', '≤3');
INSERT INTO `weather` VALUES (3501003, '2020-01-08', '3', '多云', '阴', '19', '10', '东', '东', '4', '4');
INSERT INTO `weather` VALUES (3501004, '2020-01-09', '4', '多云', '多云', '18', '10', '无风向', '无风向', '≤3', '≤3');
INSERT INTO `weather` VALUES (3601001, '2020-01-06', '1', '阴', '小雨', '24', '12', '西南', '西南', '4', '4');
INSERT INTO `weather` VALUES (3601002, '2020-01-07', '2', '小雨', '晴', '16', '4', '东北', '东北', '4', '4');
INSERT INTO `weather` VALUES (3601003, '2020-01-08', '3', '晴', '晴', '11', '4', '北', '北', '4', '4');
INSERT INTO `weather` VALUES (3601004, '2020-01-09', '4', '多云', '多云', '11', '5', '北', '北', '4', '4');
INSERT INTO `weather` VALUES (3701001, '2020-01-06', '1', '雾', '雨夹雪', '2', '0', '北', '北', '≤3', '≤3');
INSERT INTO `weather` VALUES (3701002, '2020-01-07', '2', '大雪', '多云', '1', '-6', '无风向', '无风向', '5', '5');
INSERT INTO `weather` VALUES (3701003, '2020-01-08', '3', '晴', '晴', '2', '-7', '无风向', '无风向', '≤3', '≤3');
INSERT INTO `weather` VALUES (3701004, '2020-01-09', '4', '多云', '多云', '2', '-6', '南', '南', '≤3', '≤3');
INSERT INTO `weather` VALUES (4101001, '2020-01-06', '1', '雨夹雪', '大雪', '3', '0', '无风向', '无风向', '4', '4');
INSERT INTO `weather` VALUES (4101002, '2020-01-07', '2', '中雪', '阴', '2', '-5', '西南', '西南', '≤3', '≤3');
INSERT INTO `weather` VALUES (4101003, '2020-01-08', '3', '多云', '多云', '2', '-3', '东南', '东南', '≤3', '≤3');
INSERT INTO `weather` VALUES (4101004, '2020-01-09', '4', '多云', '阴', '1', '-2', '东南', '东南', '≤3', '≤3');
INSERT INTO `weather` VALUES (4201001, '2020-01-06', '1', '小雨', '中雨', '7', '3', '无风向', '无风向', '5', '5');
INSERT INTO `weather` VALUES (4201002, '2020-01-07', '2', '多云', '多云', '8', '-1', '东北', '东北', '≤3', '≤3');
INSERT INTO `weather` VALUES (4201003, '2020-01-08', '3', '小雨', '小雨', '6', '0', '东北', '东北', '≤3', '≤3');
INSERT INTO `weather` VALUES (4201004, '2020-01-09', '4', '小雨', '小雨', '4', '2', '北', '北', '≤3', '≤3');
INSERT INTO `weather` VALUES (4301001, '2020-01-06', '1', '雾', '中雨', '9', '5', '西北', '西北', '4', '4');
INSERT INTO `weather` VALUES (4301002, '2020-01-07', '2', '阴', '多云', '9', '3', '西北', '西北', '≤3', '≤3');
INSERT INTO `weather` VALUES (4301003, '2020-01-08', '3', '多云', '多云', '13', '3', '北', '北', '≤3', '≤3');
INSERT INTO `weather` VALUES (4301004, '2020-01-09', '4', '小雨', '小雨', '9', '5', '西北', '西北', '≤3', '≤3');
INSERT INTO `weather` VALUES (4401001, '2020-01-06', '1', '阴', '阴', '25', '19', '无风向', '无风向', '≤3', '≤3');
INSERT INTO `weather` VALUES (4401002, '2020-01-07', '2', '多云', '多云', '26', '15', '无风向', '无风向', '4', '4');
INSERT INTO `weather` VALUES (4401003, '2020-01-08', '3', '多云', '多云', '24', '13', '东北', '东北', '4', '4');
INSERT INTO `weather` VALUES (4401004, '2020-01-09', '4', '多云', '多云', '24', '14', '无风向', '无风向', '≤3', '≤3');
INSERT INTO `weather` VALUES (4501001, '2020-01-06', '1', '阴', '多云', '26', '19', '东南', '东南', '≤3', '≤3');
INSERT INTO `weather` VALUES (4501002, '2020-01-07', '2', '多云', '多云', '27', '17', '东北', '东北', '≤3', '≤3');
INSERT INTO `weather` VALUES (4501003, '2020-01-08', '3', '多云', '多云', '27', '17', '东南', '东南', '≤3', '≤3');
INSERT INTO `weather` VALUES (4501004, '2020-01-09', '4', '多云', '小雨', '25', '17', '东南', '东南', '≤3', '≤3');
INSERT INTO `weather` VALUES (4601001, '2020-01-06', '1', '多云', '多云', '25', '19', '无风向', '无风向', '≤3', '≤3');
INSERT INTO `weather` VALUES (4601002, '2020-01-07', '2', '多云', '多云', '26', '19', '无风向', '无风向', '≤3', '≤3');
INSERT INTO `weather` VALUES (4601003, '2020-01-08', '3', '小雨', '多云', '24', '19', '无风向', '无风向', '≤3', '≤3');
INSERT INTO `weather` VALUES (4601004, '2020-01-09', '4', '小雨', '多云', '25', '20', '无风向', '无风向', '≤3', '≤3');
INSERT INTO `weather` VALUES (5001001, '2020-01-06', '1', '小雨', '阴', '10', '7', '西北', '西北', '≤3', '≤3');
INSERT INTO `weather` VALUES (5001002, '2020-01-07', '2', '多云', '阴', '13', '7', '无风向', '无风向', '≤3', '≤3');
INSERT INTO `weather` VALUES (5001003, '2020-01-08', '3', '小雨', '阴', '10', '8', '西', '西', '≤3', '≤3');
INSERT INTO `weather` VALUES (5001004, '2020-01-09', '4', '阴', '阴', '11', '8', '东南', '东南', '≤3', '≤3');
INSERT INTO `weather` VALUES (5101001, '2020-01-06', '1', '阴', '多云', '11', '4', '无风向', '无风向', '≤3', '≤3');
INSERT INTO `weather` VALUES (5101002, '2020-01-07', '2', '多云', '多云', '11', '4', '无风向', '无风向', '≤3', '≤3');
INSERT INTO `weather` VALUES (5101003, '2020-01-08', '3', '多云', '多云', '11', '5', '无风向', '无风向', '≤3', '≤3');
INSERT INTO `weather` VALUES (5101004, '2020-01-09', '4', '多云', '小雨', '9', '5', '无风向', '无风向', '≤3', '≤3');
INSERT INTO `weather` VALUES (5201001, '2020-01-06', '1', '小雨', '小雨', '16', '4', '南', '南', '4', '4');
INSERT INTO `weather` VALUES (5201002, '2020-01-07', '2', '多云', '阴', '16', '4', '东南', '东南', '≤3', '≤3');
INSERT INTO `weather` VALUES (5201003, '2020-01-08', '3', '小雨', '小雨', '16', '10', '南', '南', '≤3', '≤3');
INSERT INTO `weather` VALUES (5201004, '2020-01-09', '4', '小雨', '小雨', '18', '10', '东南', '东南', '≤3', '≤3');
INSERT INTO `weather` VALUES (5301001, '2020-01-06', '1', '小雨', '多云', '16', '3', '无风向', '无风向', '≤3', '≤3');
INSERT INTO `weather` VALUES (5301002, '2020-01-07', '2', '晴', '晴', '18', '3', '无风向', '无风向', '≤3', '≤3');
INSERT INTO `weather` VALUES (5301003, '2020-01-08', '3', '晴', '晴', '19', '3', '无风向', '无风向', '≤3', '≤3');
INSERT INTO `weather` VALUES (5301004, '2020-01-09', '4', '晴', '多云', '19', '4', '无风向', '无风向', '≤3', '≤3');
INSERT INTO `weather` VALUES (5401001, '2020-01-06', '1', '多云', '晴', '0', '-8', '东南', '东南', '4', '4');
INSERT INTO `weather` VALUES (5401002, '2020-01-07', '2', '晴', '多云', '9', '-8', '无风向', '无风向', '≤3', '≤3');
INSERT INTO `weather` VALUES (5401003, '2020-01-08', '3', '多云', '多云', '9', '-6', '无风向', '无风向', '≤3', '≤3');
INSERT INTO `weather` VALUES (5401004, '2020-01-09', '4', '多云', '多云', '7', '-5', '无风向', '无风向', '≤3', '≤3');
INSERT INTO `weather` VALUES (6101001, '2020-01-06', '1', '阴', '雨夹雪', '4', '0', '西北', '西北', '≤3', '≤3');
INSERT INTO `weather` VALUES (6101002, '2020-01-07', '2', '多云', '晴', '7', '-4', '西', '西', '4', '4');
INSERT INTO `weather` VALUES (6101003, '2020-01-08', '3', '阴', '阴', '4', '-3', '东北', '东北', '4', '4');
INSERT INTO `weather` VALUES (6101004, '2020-01-09', '4', '阴', '阴', '3', '-1', '东', '东', '≤3', '≤3');
INSERT INTO `weather` VALUES (6201001, '2020-01-06', '1', '小雪', '多云', '0', '-8', '东', '东', '≤3', '≤3');
INSERT INTO `weather` VALUES (6201002, '2020-01-07', '2', '晴', '多云', '5', '-8', '东南', '东南', '≤3', '≤3');
INSERT INTO `weather` VALUES (6201003, '2020-01-08', '3', '多云', '多云', '5', '-5', '西', '西', '≤3', '≤3');
INSERT INTO `weather` VALUES (6201004, '2020-01-09', '4', '多云', '多云', '2', '-5', '东南', '东南', '≤3', '≤3');
INSERT INTO `weather` VALUES (6301001, '2020-01-06', '1', '中雪', '多云', '-1', '-12', '东南', '东南', '4', '4');
INSERT INTO `weather` VALUES (6301002, '2020-01-07', '2', '晴', '晴', '2', '-13', '无风向', '无风向', '≤3', '≤3');
INSERT INTO `weather` VALUES (6301003, '2020-01-08', '3', '多云', '多云', '2', '-12', '无风向', '无风向', '≤3', '≤3');
INSERT INTO `weather` VALUES (6301004, '2020-01-09', '4', '晴', '阴', '0', '-9', '无风向', '无风向', '≤3', '≤3');
INSERT INTO `weather` VALUES (6401001, '2020-01-06', '1', '阴', '阴', '-1', '-8', '无风向', '无风向', '≤3', '≤3');
INSERT INTO `weather` VALUES (6401002, '2020-01-07', '2', '晴', '多云', '0', '-10', '无风向', '无风向', '≤3', '≤3');
INSERT INTO `weather` VALUES (6401003, '2020-01-08', '3', '多云', '阴', '1', '-9', '无风向', '无风向', '≤3', '≤3');
INSERT INTO `weather` VALUES (6401004, '2020-01-09', '4', '阴', '阴', '0', '-6', '无风向', '无风向', '≤3', '≤3');
INSERT INTO `weather` VALUES (6501001, '2020-01-06', '1', '雾', '雾', '-13', '-16', '无风向', '无风向', '≤3', '≤3');
INSERT INTO `weather` VALUES (6501002, '2020-01-07', '2', '多云', '多云', '-7', '-15', '无风向', '无风向', '≤3', '≤3');
INSERT INTO `weather` VALUES (6501003, '2020-01-08', '3', '多云', '多云', '-8', '-14', '无风向', '无风向', '≤3', '≤3');
INSERT INTO `weather` VALUES (6501004, '2020-01-09', '4', '多云', '晴', '-8', '-14', '东南', '东南', '4', '4');

SET FOREIGN_KEY_CHECKS = 1;
