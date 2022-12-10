/*
 Navicat Premium Data Transfer

 Source Server         : Ubuntu-MySql
 Source Server Type    : MySQL
 Source Server Version : 80031 (8.0.31-0ubuntu0.20.04.1)
 Source Host           : ipromise.dynv6.net:3306
 Source Schema         : LibraryManagementSystem

 Target Server Type    : MySQL
 Target Server Version : 80031 (8.0.31-0ubuntu0.20.04.1)
 File Encoding         : 65001

 Date: 09/12/2022 18:44:19
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_book
-- ----------------------------
DROP TABLE IF EXISTS `t_book`;
CREATE TABLE `t_book` (
  `id` int NOT NULL AUTO_INCREMENT,
  `bookName` varchar(20) DEFAULT NULL,
  `author` varchar(20) DEFAULT NULL,
  `sex` varchar(10) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `bookDesc` varchar(1000) DEFAULT NULL,
  `bookTypeId` int DEFAULT NULL,
  `isflag` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_t_book` (`bookTypeId`),
  CONSTRAINT `FK_t_book` FOREIGN KEY (`bookTypeId`) REFERENCES `t_booktype` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of t_book
-- ----------------------------
BEGIN;
INSERT INTO `t_book` (`id`, `bookName`, `author`, `sex`, `price`, `bookDesc`, `bookTypeId`, `isflag`) VALUES (12, 'java ', 'jason', 'Male', 200, 'start java', 1, 0);
INSERT INTO `t_book` (`id`, `bookName`, `author`, `sex`, `price`, `bookDesc`, `bookTypeId`, `isflag`) VALUES (20, 'mysql', 'tom', 'Female', 200, 'start sql', 2, 0);
INSERT INTO `t_book` (`id`, `bookName`, `author`, `sex`, `price`, `bookDesc`, `bookTypeId`, `isflag`) VALUES (23, 'Start c', 'james', 'Male', 100, 'Start c', 13, 0);
COMMIT;

-- ----------------------------
-- Table structure for t_booktype
-- ----------------------------
DROP TABLE IF EXISTS `t_booktype`;
CREATE TABLE `t_booktype` (
  `id` int NOT NULL AUTO_INCREMENT,
  `bookTypeName` varchar(20) DEFAULT NULL,
  `bookTypeDesc` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of t_booktype
-- ----------------------------
BEGIN;
INSERT INTO `t_booktype` (`id`, `bookTypeName`, `bookTypeDesc`) VALUES (1, 'java', 'java for all');
INSERT INTO `t_booktype` (`id`, `bookTypeName`, `bookTypeDesc`) VALUES (2, 'sql', 'mysql sql server');
INSERT INTO `t_booktype` (`id`, `bookTypeName`, `bookTypeDesc`) VALUES (13, 'c/c++', 'Start c/c++');
COMMIT;

-- ----------------------------
-- Table structure for t_borrow
-- ----------------------------
DROP TABLE IF EXISTS `t_borrow`;
CREATE TABLE `t_borrow` (
  `bid` int NOT NULL AUTO_INCREMENT,
  `userid` int DEFAULT NULL,
  `bookid` int DEFAULT NULL,
  `btime` date DEFAULT NULL,
  `rtime` date DEFAULT NULL,
  PRIMARY KEY (`bid`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of t_borrow
-- ----------------------------
BEGIN;
INSERT INTO `t_borrow` (`bid`, `userid`, `bookid`, `btime`, `rtime`) VALUES (15, 2, 12, '2022-12-08', '2022-12-08');
INSERT INTO `t_borrow` (`bid`, `userid`, `bookid`, `btime`, `rtime`) VALUES (16, 2, 20, '2022-12-08', '2022-12-08');
COMMIT;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `userName` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `userid` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of t_user
-- ----------------------------
BEGIN;
INSERT INTO `t_user` (`id`, `userName`, `password`, `userid`) VALUES (1, 'zxs', 'zxs123123', '1');
INSERT INTO `t_user` (`id`, `userName`, `password`, `userid`) VALUES (2, 'user', '123123', '0');
INSERT INTO `t_user` (`id`, `userName`, `password`, `userid`) VALUES (8, 'jason', '123123', '0');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
