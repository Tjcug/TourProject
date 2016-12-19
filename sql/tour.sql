/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50617
Source Host           : localhost:3306
Source Database       : tour

Target Server Type    : MYSQL
Target Server Version : 50617
File Encoding         : 65001

Date: 2016-12-19 15:14:18
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
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '发布时间',
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
-- Table structure for t_jyanswers
-- ----------------------------
DROP TABLE IF EXISTS `t_jyanswers`;
CREATE TABLE `t_jyanswers` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `question_id` bigint(20) NOT NULL COMMENT '回答的问题id',
  `user_id` bigint(20) DEFAULT NULL COMMENT '回答的人id',
  `state` tinyint(1) DEFAULT NULL COMMENT '解决/未解决',
  `fromuserscore` double DEFAULT NULL COMMENT '发布问题用户评分',
  `touserscore` double DEFAULT NULL COMMENT '回答问题用户评分',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '解答时间',
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `question_id` (`question_id`),
  CONSTRAINT `t_jyanswers_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`),
  CONSTRAINT `t_jyanswers_ibfk_2` FOREIGN KEY (`question_id`) REFERENCES `t_jyquestions` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_jyanswers
-- ----------------------------

-- ----------------------------
-- Table structure for t_jyanswerscontent
-- ----------------------------
DROP TABLE IF EXISTS `t_jyanswerscontent`;
CREATE TABLE `t_jyanswerscontent` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '回答内容id',
  `answer_id` bigint(20) NOT NULL COMMENT '对应的回答id',
  `user_id` bigint(20) NOT NULL COMMENT '回答人的id或追问人（提问者）的id',
  `type` tinyint(1) NOT NULL COMMENT '0为解答者回答，1为提问者追答',
  `content` varchar(128) NOT NULL COMMENT '回答内容（或追问内容），【图片】标记为图片',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `t_assistantanswerscontent_ibfk_1` (`answer_id`),
  KEY `t_assistantanswerscontent_ibfk_2` (`user_id`),
  CONSTRAINT `t_jyanswerscontent_ibfk_1` FOREIGN KEY (`answer_id`) REFERENCES `t_jyanswers` (`id`),
  CONSTRAINT `t_jyanswerscontent_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_jyanswerscontent
-- ----------------------------

-- ----------------------------
-- Table structure for t_jyanswerscontentimage
-- ----------------------------
DROP TABLE IF EXISTS `t_jyanswerscontentimage`;
CREATE TABLE `t_jyanswerscontentimage` (
  `id` bigint(20) NOT NULL,
  `answer_content_id` bigint(20) NOT NULL COMMENT '回答内容的id',
  `image_pack` varchar(50) NOT NULL COMMENT '图片路径',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `t_assistantanswerscontentimage_ibfk_1` (`answer_content_id`),
  CONSTRAINT `t_jyanswerscontentimage_ibfk_1` FOREIGN KEY (`answer_content_id`) REFERENCES `t_jyanswerscontent` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_jyanswerscontentimage
-- ----------------------------

-- ----------------------------
-- Table structure for t_jyquestions
-- ----------------------------
DROP TABLE IF EXISTS `t_jyquestions`;
CREATE TABLE `t_jyquestions` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '问题id',
  `content` varchar(100) NOT NULL COMMENT '内容',
  `state` tinyint(1) NOT NULL DEFAULT '0' COMMENT '0为未解决，1为解决',
  `reward` double NOT NULL COMMENT '赏金',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '发布时间',
  `user_id` bigint(20) NOT NULL COMMENT '发布用户id',
  `longitude` double DEFAULT NULL COMMENT '维度',
  `latitude` double DEFAULT NULL COMMENT '经度',
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `t_jyquestions_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_jyquestions
-- ----------------------------
INSERT INTO `t_jyquestions` VALUES ('1', '迷路了求接送会ASD大街的凯宁大宾馆', '0', '10', '2016-12-12 22:31:28', '31', '0', '0');
INSERT INTO `t_jyquestions` VALUES ('2', '我又迷路了，求接送会ASD大街的凯宁大宾馆', '0', '15', '2016-12-12 22:32:48', '31', '0', '0');
INSERT INTO `t_jyquestions` VALUES ('3', '唉，我又迷路了，求接送会ASD大街的凯宁大宾馆', '0', '20', '2016-12-12 22:33:16', '31', '0', '0');
INSERT INTO `t_jyquestions` VALUES ('4', '我又又迷路了！求接送会ASD大街的凯宁大宾馆', '0', '25', '2016-12-12 22:33:43', '31', '0', '0');
INSERT INTO `t_jyquestions` VALUES ('5', '我在蛙店，求帮点餐，两人份，不要辣', '0', '5', '2016-12-12 22:35:38', '90', '0', '0');
INSERT INTO `t_jyquestions` VALUES ('6', '明天9点去XX景点，求一名导游，要求能说会道', '0', '100', '2016-12-14 16:09:59', '90', '0', '0');

-- ----------------------------
-- Table structure for t_jyquestionsimage
-- ----------------------------
DROP TABLE IF EXISTS `t_jyquestionsimage`;
CREATE TABLE `t_jyquestionsimage` (
  `id` bigint(20) NOT NULL COMMENT '图片id',
  `question_id` bigint(20) NOT NULL COMMENT '图片对应的内容表的ID',
  `image_pack` varchar(50) NOT NULL COMMENT '图片路径',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `t_assistantquestionsimage_ibfk_1` (`question_id`),
  CONSTRAINT `t_jyquestionsimage_ibfk_1` FOREIGN KEY (`question_id`) REFERENCES `t_jyquestions` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_jyquestionsimage
-- ----------------------------

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `type` int(11) DEFAULT NULL,
  `question_id` bigint(20) NOT NULL,
  `price` double DEFAULT NULL,
  `order_fromuser` bigint(20) DEFAULT NULL,
  `order_touser` bigint(20) DEFAULT NULL,
  `state` tinyint(1) DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `paytime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`),
  KEY `order_fromuser` (`order_fromuser`),
  KEY `order_touser` (`order_touser`),
  KEY `question_id` (`question_id`),
  CONSTRAINT `t_order_ibfk_1` FOREIGN KEY (`order_fromuser`) REFERENCES `t_user` (`id`),
  CONSTRAINT `t_order_ibfk_2` FOREIGN KEY (`order_touser`) REFERENCES `t_user` (`id`),
  CONSTRAINT `t_order_ibfk_3` FOREIGN KEY (`question_id`) REFERENCES `t_jyquestions` (`id`)
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
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '回复时间',
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
  `wechat_id` bigint(20) DEFAULT NULL COMMENT '用户微信号',
  `password` varchar(30) DEFAULT NULL,
  `sex` tinyint(4) DEFAULT NULL COMMENT '性别',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `picture` varchar(50) DEFAULT NULL COMMENT '图像',
  `country` varchar(10) DEFAULT NULL COMMENT '国家',
  `city` varchar(10) DEFAULT NULL COMMENT '城市',
  `creditcard` longtext COMMENT '银行卡',
  `telephone` varchar(20) NOT NULL COMMENT '电话号码',
  `score` double DEFAULT NULL COMMENT '评分星级',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新建用户的时间',
  `pushnotifcation` tinyint(1) DEFAULT '0' COMMENT '是否接受推送',
  `longitude` double DEFAULT NULL COMMENT '纬度',
  `latitude` double DEFAULT NULL COMMENT '经度',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=92 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('31', '谭杰', '798750509@qq.com', '0', 'woainixxx1314', '0', '1995-10-02', null, '中国', '湖南', null, '13873650653', '0', '2016-04-29 09:07:04', '0', '0', '0');
INSERT INTO `t_user` VALUES ('58', 'test5', null, '0', '123456', '0', null, null, null, null, null, '13072783289', '0', '2016-11-30 20:06:34', '0', '0', '0');
INSERT INTO `t_user` VALUES ('90', 'newUser', null, '1', null, '0', null, null, null, null, null, '15337197800', '0', '2016-12-04 17:19:52', '0', '0', '0');
INSERT INTO `t_user` VALUES ('91', 'newUser', null, '1', null, '0', null, null, null, null, null, '15607113057', '0', '2016-12-04 17:41:47', '0', '0', '0');

-- ----------------------------
-- Table structure for t_userlocation
-- ----------------------------
DROP TABLE IF EXISTS `t_userlocation`;
CREATE TABLE `t_userlocation` (
  `user_id` bigint(20) NOT NULL,
  `number` int(11) NOT NULL,
  `longitude` double DEFAULT NULL COMMENT '维度',
  `latitude` double DEFAULT NULL COMMENT '经度',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`user_id`,`number`),
  KEY `FK1ACE566BC363FB80` (`user_id`),
  CONSTRAINT `FK1ACE566BC363FB80` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_userlocation
-- ----------------------------
