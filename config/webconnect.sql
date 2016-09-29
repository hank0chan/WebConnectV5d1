/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50162
Source Host           : 127.0.0.1:3306
Source Database       : webconnect

Target Server Type    : MYSQL
Target Server Version : 50162
File Encoding         : 65001

Date: 2016-09-29 16:05:19
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `friends`
-- ----------------------------
DROP TABLE IF EXISTS `friends`;
CREATE TABLE `friends` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `usera` varchar(20) CHARACTER SET gbk DEFAULT NULL,
  `userb` varchar(20) CHARACTER SET gbk DEFAULT NULL,
  `isfriend` int(1) DEFAULT '1',
  `content` varchar(70) CHARACTER SET gbk DEFAULT NULL,
  `isshow` int(1) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `message`
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) CHARACTER SET gbk NOT NULL,
  `content` varchar(70) CHARACTER SET gbk DEFAULT NULL,
  `time` varchar(30) DEFAULT NULL,
  `receiver` varchar(20) CHARACTER SET gbk DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=257 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `privatechat`
-- ----------------------------
DROP TABLE IF EXISTS `privatechat`;
CREATE TABLE `privatechat` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `sender` varchar(20) NOT NULL,
  `receiver` varchar(20) NOT NULL,
  `content` varchar(70) DEFAULT NULL,
  `time` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=740 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Table structure for `root`
-- ----------------------------
DROP TABLE IF EXISTS `root`;
CREATE TABLE `root` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) CHARACTER SET gbk NOT NULL,
  `password` varchar(16) CHARACTER SET gbk NOT NULL,
  `level` int(2) DEFAULT '5',
  `tips` varchar(70) CHARACTER SET gbk DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of root
-- ----------------------------
INSERT INTO `root` VALUES ('1', 'aa', 'a', '5', 'aaaa');
INSERT INTO `root` VALUES ('2', 'root', 'root', '5', '管理员');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `username` varchar(20) CHARACTER SET gbk NOT NULL,
  `password` varchar(16) CHARACTER SET gbk NOT NULL,
  `state` int(1) DEFAULT '0',
  `speak` int(1) DEFAULT '1' COMMENT '1为允许发言',
  `nickname` varchar(20) CHARACTER SET gbk DEFAULT NULL,
  `gender` int(1) DEFAULT '1' COMMENT '1为男性，0为女性',
  `age` int(2) DEFAULT '0',
  `college` varchar(20) CHARACTER SET gbk DEFAULT NULL,
  `tel` varchar(20) CHARACTER SET gbk DEFAULT NULL,
  `email` varchar(30) CHARACTER SET gbk DEFAULT NULL,
  `weixin` varchar(20) CHARACTER SET gbk DEFAULT NULL,
  `qq` varchar(20) CHARACTER SET gbk DEFAULT NULL,
  `id` int(10) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`username`,`id`),
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `user2`
-- ----------------------------
DROP TABLE IF EXISTS `user2`;
CREATE TABLE `user2` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(16) NOT NULL,
  `state` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`,`username`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Table structure for `user_copy`
-- ----------------------------
DROP TABLE IF EXISTS `user_copy`;
CREATE TABLE `user_copy` (
  `username` varchar(20) CHARACTER SET gbk NOT NULL,
  `password` varchar(16) CHARACTER SET gbk NOT NULL,
  `state` int(1) DEFAULT '0',
  `speak` int(1) DEFAULT '1' COMMENT '1为允许发言',
  `nickname` varchar(20) CHARACTER SET gbk DEFAULT NULL,
  `gender` int(1) DEFAULT '1' COMMENT '1为男性，0为女性',
  `age` int(2) DEFAULT '0',
  `college` varchar(20) CHARACTER SET gbk DEFAULT NULL,
  `tel` varchar(20) CHARACTER SET gbk DEFAULT NULL,
  `email` varchar(30) CHARACTER SET gbk DEFAULT NULL,
  `weixin` varchar(20) CHARACTER SET gbk DEFAULT NULL,
  `qq` varchar(20) CHARACTER SET gbk DEFAULT NULL,
  `id` int(10) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`username`,`id`),
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;

