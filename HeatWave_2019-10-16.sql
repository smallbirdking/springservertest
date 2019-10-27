# ************************************************************
# Sequel Pro SQL dump
# Version 4541
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 127.0.0.1 (MySQL 5.7.27)
# Database: HeatWave
# Generation Time: 2019-10-16 19:47:39 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table User
# ------------------------------------------------------------

DROP TABLE IF EXISTS `User`;

CREATE TABLE `User` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `USER_NAME` varchar(128) NOT NULL DEFAULT '' COMMENT '用户名',
  `USER_PASSWORD` varchar(64) NOT NULL DEFAULT '' COMMENT '用户密码',
  `CREATED_BY` varchar(32) DEFAULT NULL COMMENT '创建方式',
  `CREATED_TIME` datetime NOT NULL COMMENT '创建时间',
  `UPDATED_TIME` datetime DEFAULT NULL COMMENT '更新时间',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '账户状态',
  PRIMARY KEY (`ID`),
  UNIQUE KEY `USER_NAME` (`USER_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='User ';

LOCK TABLES `User` WRITE;
/*!40000 ALTER TABLE `User` DISABLE KEYS */;

INSERT INTO `User` (`ID`, `USER_NAME`, `USER_PASSWORD`, `CREATED_BY`, `CREATED_TIME`, `UPDATED_TIME`, `STATUS`)
VALUES
	(1,'sbk','123',NULL,'2019-09-16 01:15:45',NULL,0),
	(4,'sbk0','123',NULL,'2019-09-18 23:38:03','2019-09-18 23:38:03',0);

/*!40000 ALTER TABLE `User` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table User_Level
# ------------------------------------------------------------

DROP TABLE IF EXISTS `User_Level`;

CREATE TABLE `User_Level` (
  `ID` int(20) NOT NULL COMMENT 'ID',
  `LEVEL` varchar(32) NOT NULL DEFAULT '' COMMENT '用户等级',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='User_Level2 用户权限';



# Dump of table User_Profile
# ------------------------------------------------------------

DROP TABLE IF EXISTS `User_Profile`;

CREATE TABLE `User_Profile` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `USER_ID` bigint(20) NOT NULL,
  `FIRST_NAME` varchar(64) NOT NULL COMMENT '姓',
  `LAST_NAME` varchar(64) NOT NULL COMMENT '名',
  `NICK_NAME` varchar(128) DEFAULT NULL COMMENT '用户昵称',
  `PASSWORD` varchar(64) DEFAULT NULL COMMENT '密码',
  `SEX` int(11) DEFAULT NULL COMMENT '性别',
  `BIRTH_DAY` date DEFAULT NULL COMMENT '生日',
  `EMAIL` varchar(1024) DEFAULT NULL COMMENT '邮箱',
  `TELEPHONE` varchar(64) DEFAULT NULL COMMENT '电话',
  `USER_LEVEL` int(11) DEFAULT NULL COMMENT '用户等级',
  `UPDATED_TIME` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`ID`),
  KEY `USER_ID` (`USER_ID`),
  CONSTRAINT `user_profile_ibfk_1` FOREIGN KEY (`USER_ID`) REFERENCES `User` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='User_Profile 个人基本信息';

LOCK TABLES `User_Profile` WRITE;
/*!40000 ALTER TABLE `User_Profile` DISABLE KEYS */;

INSERT INTO `User_Profile` (`ID`, `USER_ID`, `FIRST_NAME`, `LAST_NAME`, `NICK_NAME`, `PASSWORD`, `SEX`, `BIRTH_DAY`, `EMAIL`, `TELEPHONE`, `USER_LEVEL`, `UPDATED_TIME`)
VALUES
	(1,1,'YUQI','WANG','','',NULL,NULL,NULL,NULL,NULL,NULL),
	(6,1,'YU','W',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);

/*!40000 ALTER TABLE `User_Profile` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table User_Token
# ------------------------------------------------------------

DROP TABLE IF EXISTS `User_Token`;

CREATE TABLE `User_Token` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `USER_ID` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `TOKEN` varchar(1024) DEFAULT NULL COMMENT 'Token',
  `REFRESH_TOKEN` varchar(1024) DEFAULT NULL COMMENT 'RefreshToken',
  `TOKEN_EXPIRY` datetime DEFAULT NULL COMMENT 'Token更新时间',
  `REFRESH_TOKEN_EXPIRY` datetime DEFAULT NULL COMMENT 'RefreshToken更新时间',
  `SCOPE` varchar(1024) DEFAULT NULL COMMENT '用户授权的作用域，使用逗号（,）分隔',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='User_Token 用户登录认证';

LOCK TABLES `User_Token` WRITE;
/*!40000 ALTER TABLE `User_Token` DISABLE KEYS */;

INSERT INTO `User_Token` (`ID`, `USER_ID`, `TOKEN`, `REFRESH_TOKEN`, `TOKEN_EXPIRY`, `REFRESH_TOKEN_EXPIRY`, `SCOPE`)
VALUES
	(1,1,'eyJhbGciOiJIUzI1NiJ9.eyJjdXJEYXRlIjoxNTcxMTgzMTMwMTcxLCJ0eXBlIjoidG9rZW4iLCJ1c2VySWQiOjEsImRldmljZSI6Imh1YXdlaSJ9.0Umx98HWOlinseEdqEwWqffj-ZO2rjO1QT7f-Sv1ijo','eyJhbGciOiJIUzI1NiJ9.eyJjdXJEYXRlIjoxNTcyNDcxOTMwMTcxLCJ0eXBlIjoicmVmcmVzaC10b2tlbiIsInVzZXJJZCI6MSwiZGV2aWNlIjoiaHVhd2VpIn0.elcMUXrkuaw54dVhby8V2trc58jFVvMdt6uXWn13Znw','2019-10-16 01:45:30','2019-10-30 22:45:30','ALL');

/*!40000 ALTER TABLE `User_Token` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;