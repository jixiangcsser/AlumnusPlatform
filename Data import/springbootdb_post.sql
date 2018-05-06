-- MySQL dump 10.13  Distrib 5.7.9, for Win32 (AMD64)
--
-- Host: localhost    Database: springbootdb
-- ------------------------------------------------------
-- Server version	5.7.19

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `post`
--

DROP TABLE IF EXISTS `post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `post` (
  `pid` varchar(50) NOT NULL,
  `title` varchar(80) NOT NULL,
  `content` text,
  `publish_time` varchar(30) NOT NULL,
  `reply_time` varchar(30) NOT NULL,
  `reply_count` int(11) DEFAULT '0',
  `like_count` int(11) DEFAULT '0',
  `scan_count` int(11) DEFAULT '0',
  `uid` varchar(50) NOT NULL,
  PRIMARY KEY (`pid`),
  KEY `uid` (`uid`),
  CONSTRAINT `post_ibfk` FOREIGN KEY (`uid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `post`
--

LOCK TABLES `post` WRITE;
/*!40000 ALTER TABLE `post` DISABLE KEYS */;
INSERT INTO `post` VALUES ('024111f996d04a169af795b70cd479d4','测试4','<p>测试4内容&nbsp;&nbsp;<br></p>','2018-05-02 21:05:43','2018-05-02 21:05:43',0,0,0,'126b3e597d294e22a3343819309231c1'),('0c072d4f7ae0404182b9d7d0e3c28552','测试5','<p>测试5内容&nbsp;&nbsp;<br></p>','2018-05-02 21:05:52','2018-05-02 21:05:52',0,0,0,'126b3e597d294e22a3343819309231c1'),('21ee2ae0d73f4c77bc8884766a90fb73','nisahis ','<p>nishi 好人</p>','2018-05-01 22:05:40','2018-05-01 22:05:40',0,0,0,'126b3e597d294e22a3343819309231c1'),('2bd3c08cd1db40939f35b23934fafa54','sa17225132的测试1','<p>sa17225132的测试1内容</p>','2018-05-03 22:05:16','2018-05-03 22:05:16',0,0,0,'b88947c8a2a041cf86b8953e654eda0f'),('2c2eaf1886004ebfa11da635408bd594','测试6','<p>测试6内容&nbsp;&nbsp;<br></p>','2018-05-02 21:05:57','2018-05-02 21:05:57',0,0,0,'126b3e597d294e22a3343819309231c1'),('2c55c9abbe734abbb5c812c9c6d403b4','无头像测试1','<p>无头像测试1内容</p>','2018-05-03 23:05:05','2018-05-03 23:05:05',0,0,0,'c9c2c4d46ebb49119d3009b5d4629c9a'),('2e2e9815db26497b966a662d4199112a','测试7','<p>测试7内容&nbsp;&nbsp;<br></p>','2018-05-02 21:05:02','2018-05-02 21:05:02',0,0,0,'126b3e597d294e22a3343819309231c1'),('63a486ea761a4c8ba9806e091575eda6','测试9','<p>测试9内容&nbsp;&nbsp;<br></p>','2018-05-02 21:05:12','2018-05-02 21:05:12',0,0,0,'126b3e597d294e22a3343819309231c1'),('95d0ed0399d64f6cb29922ca660bfc13','这是个测试的头','<p>这是测试的内容</p>','2018-05-02 13:05:26','2018-05-02 13:05:26',0,0,0,'126b3e597d294e22a3343819309231c1'),('b9cf1debe43d497c91da2609c57ea7bb','测试8','<p>测试8内容&nbsp;&nbsp;<br></p>','2018-05-02 21:05:07','2018-05-02 21:05:07',0,0,0,'126b3e597d294e22a3343819309231c1'),('e1dc89cdf39e49f8849ba1542f78df22','测试7内容','<p>测试27内容&nbsp;&nbsp;<br></p>','2018-05-02 21:05:44','2018-05-02 21:05:44',0,0,0,'126b3e597d294e22a3343819309231c1'),('ee6f082c51d74ffe803f38f9df3e7208','测试3','<p>测试2内容&nbsp;&nbsp;<br></p>','2018-05-02 21:05:15','2018-05-02 21:05:15',0,0,0,'126b3e597d294e22a3343819309231c1'),('f098c50ef8ad42e7ae4e548bcac9a871','测试2','<p>测试2内容&nbsp;&nbsp;<br></p>','2018-05-02 21:05:46','2018-05-02 21:05:46',0,0,0,'126b3e597d294e22a3343819309231c1');
/*!40000 ALTER TABLE `post` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-05-06 12:38:52
