/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50617
Source Host           : localhost:3306
Source Database       : tour

Target Server Type    : MYSQL
Target Server Version : 50617
File Encoding         : 65001

Date: 2016-11-12 17:23:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for administrator
-- ----------------------------
DROP TABLE IF EXISTS `administrator`;
CREATE TABLE `administrator` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(10) DEFAULT NULL,
  `username` varchar(20) NOT NULL COMMENT '用户名',
  `password` varchar(20) NOT NULL COMMENT '密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of administrator
-- ----------------------------
INSERT INTO `administrator` VALUES ('1', '谭杰', 'admin', 'admin');

-- ----------------------------
-- Table structure for t_assistantanswers
-- ----------------------------
DROP TABLE IF EXISTS `t_assistantanswers`;
CREATE TABLE `t_assistantanswers` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `question_id` bigint(20) NOT NULL COMMENT '回答的问题id',
  `user_id` bigint(20) DEFAULT NULL COMMENT '回答的人id',
  `state` tinyint(1) DEFAULT NULL COMMENT '解决/未解决',
  `fromuserscore` double DEFAULT NULL COMMENT '发布问题用户评分',
  `touserscore` double DEFAULT NULL COMMENT '回答问题用户评分',
  `answer` varchar(100) DEFAULT NULL COMMENT '回答问题的内容',
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '回答问题时间',
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `t_assistantanswers_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_assistantanswers
-- ----------------------------

-- ----------------------------
-- Table structure for t_assistantquestions
-- ----------------------------
DROP TABLE IF EXISTS `t_assistantquestions`;
CREATE TABLE `t_assistantquestions` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `content` varchar(100) NOT NULL COMMENT '内容',
  `state` tinyint(1) DEFAULT NULL COMMENT '解决/未解决',
  `reward` double DEFAULT NULL COMMENT '赏金',
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '发布时间',
  `user_id` bigint(20) DEFAULT NULL COMMENT '发布用户id',
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `t_assistantquestions_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_assistantquestions
-- ----------------------------

-- ----------------------------
-- Table structure for t_discuss
-- ----------------------------
DROP TABLE IF EXISTS `t_discuss`;
CREATE TABLE `t_discuss` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL COMMENT '发布论坛的人',
  `content` longtext COMMENT '内容',
  `category` varchar(10) DEFAULT NULL COMMENT '类别',
  `pictures` varchar(100) DEFAULT NULL COMMENT '众多照片',
  `area` varchar(10) DEFAULT NULL COMMENT '地区',
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '发布时间',
  `hot` tinyint(1) DEFAULT NULL COMMENT '是否是热度',
  `likesnumber` bigint(20) DEFAULT NULL COMMENT '点赞数量',
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `t_discuss_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_discuss
-- ----------------------------

-- ----------------------------
-- Table structure for t_discusslikes
-- ----------------------------
DROP TABLE IF EXISTS `t_discusslikes`;
CREATE TABLE `t_discusslikes` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL,
  `disscuss_id` bigint(20) DEFAULT NULL COMMENT '被点赞的表id',
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `disscuss_id` (`disscuss_id`),
  CONSTRAINT `t_discusslikes_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`),
  CONSTRAINT `t_discusslikes_ibfk_2` FOREIGN KEY (`disscuss_id`) REFERENCES `t_discuss` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_discusslikes
-- ----------------------------

-- ----------------------------
-- Table structure for t_imagelibary
-- ----------------------------
DROP TABLE IF EXISTS `t_imagelibary`;
CREATE TABLE `t_imagelibary` (
  `image_id` bigint(20) NOT NULL,
  `image_type_id` int(2) NOT NULL,
  `business_tabel_id` bigint(20) NOT NULL,
  `image_pack` varchar(50) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`image_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_imagelibary
-- ----------------------------

-- ----------------------------
-- Table structure for t_imagetype
-- ----------------------------
DROP TABLE IF EXISTS `t_imagetype`;
CREATE TABLE `t_imagetype` (
  `image_type_id` bigint(22) NOT NULL,
  `type_name` varchar(10) NOT NULL,
  PRIMARY KEY (`image_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_imagetype
-- ----------------------------
INSERT INTO `t_imagetype` VALUES ('1', '求助');
INSERT INTO `t_imagetype` VALUES ('2', '论坛');

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `type` int(11) DEFAULT NULL,
  `assistant_id` bigint(20) unsigned DEFAULT NULL,
  `price` double DEFAULT NULL,
  `order_fromuser` bigint(20) DEFAULT NULL,
  `order_touser` bigint(20) DEFAULT NULL,
  `state` tinyint(1) DEFAULT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `paytime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`),
  KEY `order_fromuser` (`order_fromuser`),
  KEY `order_touser` (`order_touser`),
  CONSTRAINT `t_order_ibfk_1` FOREIGN KEY (`order_fromuser`) REFERENCES `t_user` (`id`),
  CONSTRAINT `t_order_ibfk_2` FOREIGN KEY (`order_touser`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_order
-- ----------------------------

-- ----------------------------
-- Table structure for t_replay
-- ----------------------------
DROP TABLE IF EXISTS `t_replay`;
CREATE TABLE `t_replay` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `discuss_id` bigint(20) NOT NULL COMMENT '讨论表的id',
  `fromuser` bigint(20) NOT NULL COMMENT '来自回复的人',
  `touser` bigint(20) DEFAULT NULL COMMENT '回复的人',
  `content` longtext COMMENT '回复内容',
  `pictures` varchar(100) DEFAULT NULL COMMENT '众多照片',
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '回复时间',
  PRIMARY KEY (`id`),
  KEY `discuss_id` (`discuss_id`),
  KEY `fromuser` (`fromuser`),
  KEY `touser` (`touser`),
  CONSTRAINT `t_replay_ibfk_1` FOREIGN KEY (`discuss_id`) REFERENCES `t_discuss` (`id`),
  CONSTRAINT `t_replay_ibfk_2` FOREIGN KEY (`fromuser`) REFERENCES `t_user` (`id`),
  CONSTRAINT `t_replay_ibfk_3` FOREIGN KEY (`touser`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_replay
-- ----------------------------

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(20) DEFAULT NULL COMMENT '用户名',
  `email` varchar(30) DEFAULT NULL COMMENT 'email',
  `password` varchar(30) DEFAULT NULL,
  `sex` tinyint(4) DEFAULT NULL COMMENT '性别',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `picture` varchar(50) DEFAULT NULL COMMENT '图像',
  `country` varchar(10) DEFAULT NULL COMMENT '国家',
  `city` varchar(10) DEFAULT NULL COMMENT '城市',
  `creditcard` longtext COMMENT '银行卡',
  `telephone` varchar(20) DEFAULT NULL COMMENT '电话号码',
  `score` double DEFAULT NULL COMMENT '评分星级',
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新建用户的时间',
  `pushnotifcation` tinyint(1) DEFAULT '0' COMMENT '是否接受推送',
  `longitude` double DEFAULT NULL COMMENT '纬度',
  `latitude` double DEFAULT NULL COMMENT '经度',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('31', '谭杰', '798750509@qq.com', 'woainixxx1314', '0', '1995-10-02', '123', '中国', '湖南', null, null, '0', '2016-04-29 09:07:04', '0', '0', '0');
