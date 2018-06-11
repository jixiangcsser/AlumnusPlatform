-- MySQL dump 10.13  Distrib 5.7.22, for macos10.13 (x86_64)
--
-- Host: localhost    Database: springbootdb
-- ------------------------------------------------------
-- Server version	5.7.22

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
-- Table structure for table `message`
--

DROP TABLE IF EXISTS `message`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `message` (
  `mid` varchar(32) NOT NULL,
  `uid` varchar(32) NOT NULL,
  `rid` varchar(32) NOT NULL,
  `reply_username` varchar(20) NOT NULL,
  `pid` varchar(50) NOT NULL,
  `operation` varchar(20) NOT NULL,
  `displayed_content` varchar(80) NOT NULL,
  `msg_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`mid`),
  KEY `mesaage_ibfk` (`uid`),
  CONSTRAINT `mesaage_ibfk` FOREIGN KEY (`uid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `message`
--

LOCK TABLES `message` WRITE;
/*!40000 ALTER TABLE `message` DISABLE KEYS */;
INSERT INTO `message` VALUES ('00932187746744fc82bd0065652a26b6','126b3e597d294e22a3343819309231c1','126b3e597d294e22a3343819309231c1','sa17225131','972c0eba914a4d1da350c0c0be336016','回复了您的帖子','测试笑脸','2018-05-29 05:55:38'),('0a4dcce40b0241508c7d30e5c8cb587b','126b3e597d294e22a3343819309231c1','1f0b975491a14944ae9ae710819c6978','sa17225131','d34d8ca19d284d90a778fb3ac92e56c5','回复了您的帖子','再加一个','2018-05-28 18:14:41'),('0cbffa22c8304a7781f45ab00befa2da','693c5033481a41bea81a273e29357ccc','126b3e597d294e22a3343819309231c1','sa17225131','c24f77ee78c24bd88d8eca5232e80b8d','回复了您的帖子','测试一下格式','2018-05-29 06:32:47'),('16fc0704547848a28df2720eb0b56fd3','693c5033481a41bea81a273e29357ccc','126b3e597d294e22a3343819309231c1','sa17225131','c24f77ee78c24bd88d8eca5232e80b8d','赞了您的帖子','测试一下格式','2018-05-30 15:02:53'),('17f787d0cd7548dfb78c9e16809fb677','b88947c8a2a041cf86b8953e654eda0f','126b3e597d294e22a3343819309231c1','sa17225131','d66b64a1024e48eaaacbd57698a3b7dd','赞了您的帖子','测试','2018-05-31 16:36:05'),('1824827dd7fe4543a9e20cf24ee0f968','693c5033481a41bea81a273e29357ccc','126b3e597d294e22a3343819309231c1','sa17225131','c24f77ee78c24bd88d8eca5232e80b8d','回复了您的帖子','测试一下格式','2018-05-30 03:01:50'),('18e1b6054860404a89f7daf8c160d28e','126b3e597d294e22a3343819309231c1','bb65f7074c7f4e239b2acb6551e308a8','sa17225131','7c760226b1bd4ea2844e7be024228f02','回复了您的帖子','测试图片上传','2018-05-29 03:10:44'),('275b105bfb44491ca61863f374dfd2f2','126b3e597d294e22a3343819309231c1','126b3e597d294e22a3343819309231c1','sa17225131','39e8c39c08944c86bcfbd1e8a0aae5e6','回复了您的帖子','测试多个图片上传','2018-05-29 05:51:01'),('31680723855e4ac681009d080f047302','126b3e597d294e22a3343819309231c1','126b3e597d294e22a3343819309231c1','sa17225131','aab3436fcd9c44fc863a493eadbfc2e7','回复了您的帖子','删库后第一次测试','2018-05-29 05:59:44'),('36cb6bf1c92f4cf6bf4c3a48e219cdd1','11952781bdb74d85aef42ef9c2593972','eb4cf591524f47899fdce729d5da6400','sa17225130','39e8c39c08944c86bcfbd1e8a0aae5e6','回复了您的帖子','测试多个图片上传','2018-05-29 03:17:34'),('3c086a471b6c44028159b6b45d15682e','11952781bdb74d85aef42ef9c2593972','693c5033481a41bea81a273e29357ccc','sa17225134','d34d8ca19d284d90a778fb3ac92e56c5','赞了您的帖子','再加一个','2018-05-30 15:03:53'),('4366277fb7b846b1b17ff04368c65ab5','126b3e597d294e22a3343819309231c1','126b3e597d294e22a3343819309231c1','sa17225131','972c0eba914a4d1da350c0c0be336016','回复了您的帖子','测试笑脸','2018-05-29 05:59:02'),('49149d865b5e4aff9f539a2cda2a1b02','11952781bdb74d85aef42ef9c2593972','126b3e597d294e22a3343819309231c1','sa17225131','d34d8ca19d284d90a778fb3ac92e56c5','赞了您的帖子','再加一个','2018-05-30 15:02:43'),('4be009381bcf4251b21a7fc02911ea40','11952781bdb74d85aef42ef9c2593972','126b3e597d294e22a3343819309231c1','sa17225131','d3f3a97fe6cd4c95b2e51837753a7ea5','赞了您的帖子','再加一个头像','2018-05-30 15:00:37'),('52746acbf55c4626a008a713ebed4b96','126b3e597d294e22a3343819309231c1','126b3e597d294e22a3343819309231c1','sa17225131','36b37fe3f289470b965725e1817793fc','回复了您的帖子','sdsd','2018-05-29 05:52:13'),('570a1d616a974905ad4d0aaa4c4937d1','11952781bdb74d85aef42ef9c2593972','693c5033481a41bea81a273e29357ccc','sa17225134','67b0e3000a814eb8ab28465704f4745e','赞了您的帖子','再加上一个头像','2018-05-30 15:03:59'),('6d7e38c8ef58440a839b93f97de3b4b8','b88947c8a2a041cf86b8953e654eda0f','126b3e597d294e22a3343819309231c1','sa17225131','d66b64a1024e48eaaacbd57698a3b7dd','回复了您的帖子','测试','2018-05-31 16:36:17'),('766e3994adc94417a84e836e3849ec66','126b3e597d294e22a3343819309231c1','dc5e354aa5174ab687bac21da5a33537','sa17225131','d66b64a1024e48eaaacbd57698a3b7dd','回复了您的帖子','测试','2018-05-28 17:32:32'),('7dd60a5d930d4968b5396032fbeeb8b4','b88947c8a2a041cf86b8953e654eda0f','126b3e597d294e22a3343819309231c1','sa17225131','d66b64a1024e48eaaacbd57698a3b7dd','回复了您的帖子','测试','2018-05-29 03:53:54'),('a1722817f7994bbd85813a2332d42fa0','126b3e597d294e22a3343819309231c1','b88947c8a2a041cf86b8953e654eda0f','sa17225132','39e8c39c08944c86bcfbd1e8a0aae5e6','回复了您的帖子','测试多个图片上传','2018-05-30 08:35:26'),('a3fac04253b24eb0af089173f801d216','11952781bdb74d85aef42ef9c2593972','126b3e597d294e22a3343819309231c1','sa17225131','26b7f7122f924019a376514313d6166f','赞了您的帖子','测试多个头像能否显示','2018-05-30 15:02:34'),('a72e0bf9e1d842678c61759c633c75e0','126b3e597d294e22a3343819309231c1','126b3e597d294e22a3343819309231c1','sa17225131','972c0eba914a4d1da350c0c0be336016','赞了您的帖子','测试笑脸','2018-05-31 17:10:55'),('a7a257be1a264a9a8554e2882cd02da8','126b3e597d294e22a3343819309231c1','126b3e597d294e22a3343819309231c1','sa17225131','12d20274e69d4d2da305c0ab2b6758c2','赞了您的帖子','字体的测试','2018-05-31 17:21:41'),('b3b7e1a0edd94943986ebb21f8a580ba','126b3e597d294e22a3343819309231c1','b88947c8a2a041cf86b8953e654eda0f','sa17225132','12d20274e69d4d2da305c0ab2b6758c2','回复了您的帖子','字体的测试','2018-05-31 17:40:17'),('b61978498cc84bc6ba9eb2160ed4abfc','126b3e597d294e22a3343819309231c1','126b3e597d294e22a3343819309231c1','sa17225131','972c0eba914a4d1da350c0c0be336016','回复了您的帖子','测试笑脸','2018-05-29 05:57:22'),('b96370c5e04647628c8218985fe38bee','b88947c8a2a041cf86b8953e654eda0f','693c5033481a41bea81a273e29357ccc','sa17225134','d66b64a1024e48eaaacbd57698a3b7dd','赞了您的帖子','测试','2018-05-30 13:49:13'),('c7a92079111b4529bc1faa36d659ad46','126b3e597d294e22a3343819309231c1','b88947c8a2a041cf86b8953e654eda0f','sa17225132','39e8c39c08944c86bcfbd1e8a0aae5e6','回复了您的帖子','测试多个图片上传','2018-05-29 03:53:13'),('cf1e0a5fff704b3c8703d6f1b2d02c01','126b3e597d294e22a3343819309231c1','b88947c8a2a041cf86b8953e654eda0f','sa17225132','12d20274e69d4d2da305c0ab2b6758c2','回复了您的帖子','字体的测试','2018-05-31 17:43:02'),('d4e44c13fcad49b3a9db24f4b5abbdc7','11952781bdb74d85aef42ef9c2593972','126b3e597d294e22a3343819309231c1','sa17225131','8eedbc32e876498cb35a8ac08c8fe213','赞了您的帖子','另一个用户的测试','2018-05-30 14:46:26'),('d547e24bdf4248c38cbdce7abde65661','693c5033481a41bea81a273e29357ccc','126b3e597d294e22a3343819309231c1','sa17225131','c24f77ee78c24bd88d8eca5232e80b8d','回复了您的帖子','测试一下格式','2018-05-31 15:44:08'),('e470bcb607e74e1bb116ce1bfabc6880','693c5033481a41bea81a273e29357ccc','126b3e597d294e22a3343819309231c1','sa17225131','c24f77ee78c24bd88d8eca5232e80b8d','回复了您的帖子','测试一下格式','2018-05-30 13:42:36'),('e4da3554649047db8fd6f01377a1ba4a','b88947c8a2a041cf86b8953e654eda0f','69d000520eb94744901ff6b5d8426989','sa17225132','39e8c39c08944c86bcfbd1e8a0aae5e6','回复了您的帖子','测试多个图片上传','2018-05-29 03:25:51'),('e6ad0f9687b1471c9dab2707e14e8727','126b3e597d294e22a3343819309231c1','126b3e597d294e22a3343819309231c1','sa17225131','6ca9615077d44767bc0292996038e273','赞了您的帖子','动态图试试','2018-05-31 17:22:29'),('ebc9c565c2974b8bae3f07fb0c3b5519','11952781bdb74d85aef42ef9c2593972','126b3e597d294e22a3343819309231c1','sa17225131','67b0e3000a814eb8ab28465704f4745e','赞了您的帖子','再加上一个头像','2018-05-30 15:00:07');
/*!40000 ALTER TABLE `message` ENABLE KEYS */;
UNLOCK TABLES;

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
INSERT INTO `post` VALUES ('12d20274e69d4d2da305c0ab2b6758c2','字体的测试','<h1><span style=\"font-weight: bold;\">H1</span>的字体</h1>','2018-05-25 09:38:13','2018-06-01 01:43:01',1,1,21,'126b3e597d294e22a3343819309231c1'),('26b7f7122f924019a376514313d6166f','测试多个头像能否显示','<p>内容呢</p>','2018-05-27 00:29:53','2018-05-27 00:29:53',1,1,13,'11952781bdb74d85aef42ef9c2593972'),('36b37fe3f289470b965725e1817793fc','sdsd','<p>sd<img src=\"http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/50/pcmoren_huaixiao_org.png\" alt=\"[坏笑]\" data-w-e=\"1\"></p>','2018-05-25 09:56:08','2018-05-25 09:56:08',2,0,27,'126b3e597d294e22a3343819309231c1'),('38b2a6e50cac42de90ec2a4854577349','我就是想发表','这次还是发表了内容','2018-05-23 14:07:18','2018-05-23 14:07:18',1,0,4,'126b3e597d294e22a3343819309231c1'),('39e8c39c08944c86bcfbd1e8a0aae5e6','测试多个图片上传','<p><img src=\"http://sse-ustc-wangeditor.oss-cn-beijing.aliyuncs.com/wangEditor/32ee85e8-8d54-431c-a63a-43759cc420e11.png?Expires=1842702057&amp;OSSAccessKeyId=LTAIVz7TwaSO7otx&amp;Signature=zIor4FBwD6%2B3lwTqnPOiXchvr1k%3D\" style=\"max-width:100%;\"><img src=\"http://sse-ustc-wangeditor.oss-cn-beijing.aliyuncs.com/wangEditor/5c332fbe-32e2-4576-9285-97c7a0bab3fb2.png?Expires=1842702064&amp;OSSAccessKeyId=LTAIVz7TwaSO7otx&amp;Signature=APzh7%2F0j7uJISL0xObKvXvYth8w%3D\" style=\"max-width: 100%;\"><br></p>','2018-05-26 21:41:07','2018-05-26 21:41:07',18,1,1254,'126b3e597d294e22a3343819309231c1'),('5dc95e8545804e7fb7a1537124e8f47a','测试一下','<p><img src=\"http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/fd/2018new_baibai_org.png\" alt=\"[拜拜]\" data-w-e=\"1\"><br></p>','2018-05-25 10:05:02','2018-05-25 10:05:02',0,0,0,'126b3e597d294e22a3343819309231c1'),('67b0e3000a814eb8ab28465704f4745e','再加上一个头像','<p>我也还不信</p>','2018-05-27 00:30:41','2018-05-27 00:30:41',1,2,15,'11952781bdb74d85aef42ef9c2593972'),('6ca9615077d44767bc0292996038e273','动态图试试','<p><img src=\"http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/58/mb_thumb.gif\" alt=\"[太开心]\" data-w-e=\"1\"><br></p>','2018-05-25 10:10:28','2018-05-25 10:10:28',3,1,23,'126b3e597d294e22a3343819309231c1'),('760f7c2f78c64cd2b145e9cb1da78032','测试一下字体','ss','2018-05-25 09:11:45','2018-05-25 09:11:45',0,0,1,'126b3e597d294e22a3343819309231c1'),('7c760226b1bd4ea2844e7be024228f02','测试图片上传','<p><img src=\"http://sse-ustc-wangeditor.oss-cn-beijing.aliyuncs.com/wangEditor/d287d522-67f4-46d6-933b-c44b8793f95e2.png?Expires=1842701938&amp;OSSAccessKeyId=LTAIVz7TwaSO7otx&amp;Signature=50C9Fgk7kVPs%2FrPWvjqWrfYCBI8%3D\" style=\"max-width:100%;\"><br></p>','2018-05-26 21:39:01','2018-05-26 21:39:01',3,0,30,'126b3e597d294e22a3343819309231c1'),('8eedbc32e876498cb35a8ac08c8fe213','另一个用户的测试','<p><img src=\"http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/58/mb_thumb.gif\" alt=\"[太开心]\" data-w-e=\"1\">恭喜了<br></p>','2018-05-26 22:12:31','2018-05-26 22:12:31',0,1,11,'11952781bdb74d85aef42ef9c2593972'),('964bc7664d884010947d1313fc45b867','我擦，','<p>为什么出现了这种情况</p>','2018-05-31 23:43:12','2018-06-01 00:44:28',0,7,16,'126b3e597d294e22a3343819309231c1'),('972c0eba914a4d1da350c0c0be336016','测试笑脸','<p><img src=\"http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/40/pcmoren_tian_org.png\" alt=\"[舔屏]\" data-w-e=\"1\"><br></p>','2018-05-25 09:22:36','2018-05-25 09:22:36',3,1,17,'126b3e597d294e22a3343819309231c1'),('a9d8bf0b83b04a9fb2961f69ab8cdf83','这次测试一下啊','希望成功吧','2018-05-24 14:27:56','2018-05-24 14:27:56',0,0,0,'126b3e597d294e22a3343819309231c1'),('aab3436fcd9c44fc863a493eadbfc2e7','删库后第一次测试','测试内容','2018-05-18 10:59:19','2018-05-18 10:59:19',1,0,4,'126b3e597d294e22a3343819309231c1'),('c24f77ee78c24bd88d8eca5232e80b8d','测试一下格式','<p>111111</p>','2018-05-29 14:29:33','2018-05-29 14:29:33',4,2,63,'693c5033481a41bea81a273e29357ccc'),('d34d8ca19d284d90a778fb3ac92e56c5','再加一个','<p>哈哈哈</p>','2018-05-27 00:35:24','2018-05-27 00:35:24',14,2,60,'11952781bdb74d85aef42ef9c2593972'),('d3f3a97fe6cd4c95b2e51837753a7ea5','再加一个头像','<p>我就不信了</p>','2018-05-27 00:30:18','2018-05-27 00:30:18',2,1,11,'11952781bdb74d85aef42ef9c2593972'),('d66b64a1024e48eaaacbd57698a3b7dd','测试','<p>玩玩啊</p>','2018-05-28 14:59:33','2018-06-01 00:36:17',3,2,37,'b88947c8a2a041cf86b8953e654eda0f'),('e61ff5580d794381a32c43449ae8570c','测试一下笑脸','','2018-05-25 09:13:34','2018-05-25 09:13:34',0,0,2,'126b3e597d294e22a3343819309231c1');
/*!40000 ALTER TABLE `post` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reply`
--

DROP TABLE IF EXISTS `reply`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reply` (
  `rid` varchar(32) NOT NULL,
  `content` text,
  `pid` varchar(50) NOT NULL,
  `uid` varchar(32) NOT NULL,
  `reply_time` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`rid`),
  KEY `mypid` (`pid`),
  KEY `uid` (`uid`),
  CONSTRAINT `reply_ibfk_1` FOREIGN KEY (`pid`) REFERENCES `post` (`pid`) ON DELETE CASCADE,
  CONSTRAINT `reply_ibfk_2` FOREIGN KEY (`uid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reply`
--

LOCK TABLES `reply` WRITE;
/*!40000 ALTER TABLE `reply` DISABLE KEYS */;
INSERT INTO `reply` VALUES ('003a1ac9728c4525860e74f74e11d35b','<p>回复一下试试</p>','c24f77ee78c24bd88d8eca5232e80b8d','126b3e597d294e22a3343819309231c1','2018-05-30 21:42:36'),('060d325fe23d4785bdf1ee0d9cac3723','<p>什么情况啊</p><p><br></p>','7c760226b1bd4ea2844e7be024228f02','126b3e597d294e22a3343819309231c1','2018-05-28 00:38:07'),('0af271ee622746df8761a8619d958c36','湿答答','aab3436fcd9c44fc863a493eadbfc2e7','126b3e597d294e22a3343819309231c1','2018-05-18 13:51:11'),('0e24625a171a4291aff678d693d1f2fd','<p><img src=\"http://sse-ustc-wangeditor.oss-cn-beijing.aliyuncs.com/wangEditor/a7d0216c-e47d-420a-9851-153fcf866cb91.png?Expires=1842703349&amp;OSSAccessKeyId=LTAIVz7TwaSO7otx&amp;Signature=qYjOS%2BHyaKgKw5COgKPNMZ4R1co%3D\" style=\"max-width:100%;\"><br></p>','39e8c39c08944c86bcfbd1e8a0aae5e6','126b3e597d294e22a3343819309231c1','2018-05-26 22:02:32'),('133a8e5c6c294a87ac0a9e99080e6114','<p>匿名在回复一次</p>','39e8c39c08944c86bcfbd1e8a0aae5e6','11952781bdb74d85aef42ef9c2593972','2018-05-27 00:39:15'),('148db0dc576949c2b44a62ea92f12a74','<p>测试一下</p>','d34d8ca19d284d90a778fb3ac92e56c5','b88947c8a2a041cf86b8953e654eda0f','2018-05-28 15:20:21'),('165ce380f2134a8da3f490fdf5230910','应该会成功的','aab3436fcd9c44fc863a493eadbfc2e7','126b3e597d294e22a3343819309231c1','2018-05-18 13:47:33'),('1b93dc75eeda4f5b897115e7bc52b7b7','<p>我来回复你一条</p>','39e8c39c08944c86bcfbd1e8a0aae5e6','b88947c8a2a041cf86b8953e654eda0f','2018-05-29 11:53:12'),('1c56ccd5d3f649d69336aeffe477a4f8','<p>我也回复一下你啦</p>','d66b64a1024e48eaaacbd57698a3b7dd','126b3e597d294e22a3343819309231c1','2018-05-29 11:53:54'),('1f0b975491a14944ae9ae710819c6978','<p>回复一下看看</p>','d34d8ca19d284d90a778fb3ac92e56c5','126b3e597d294e22a3343819309231c1','2018-05-29 02:14:41'),('1fb5e04453a848a391e9ac1925931387','<p><img src=\"http://sse-ustc-wangeditor.oss-cn-beijing.aliyuncs.com/wangEditor/0c167b1f-17bd-4802-8802-30f8bcd5f0c52.png?Expires=1842839672&amp;OSSAccessKeyId=LTAIVz7TwaSO7otx&amp;Signature=%2BHcaHgIIXDNtL57qEVx%2FvxsDNB0%3D\" style=\"max-width:100%;\"><br></p>','d34d8ca19d284d90a778fb3ac92e56c5','126b3e597d294e22a3343819309231c1','2018-05-28 11:54:34'),('232a1f49291341309d2eacb0bf78e1bc','就是不稳定很讨厌','38b2a6e50cac42de90ec2a4854577349','126b3e597d294e22a3343819309231c1','2018-05-24 13:43:02'),('28c2f62581dd4a9b8353ba0f24432d1c','<p>我擦</p>','d34d8ca19d284d90a778fb3ac92e56c5','126b3e597d294e22a3343819309231c1','2018-05-28 11:54:53'),('293bf910d09b4e79aa1f672c7fef2d89','<p>另一个用户测试</p>','39e8c39c08944c86bcfbd1e8a0aae5e6','b88947c8a2a041cf86b8953e654eda0f','2018-05-27 14:47:27'),('318e295ce80f4e76bb101f94b217612c','刘琳了','38b2a6e50cac42de90ec2a4854577349','126b3e597d294e22a3343819309231c1','2018-05-24 13:46:20'),('369ad072ebe4459c8000c19c56706c76','<p>我就是测下缓存</p>','c24f77ee78c24bd88d8eca5232e80b8d','126b3e597d294e22a3343819309231c1','2018-05-31 23:44:08'),('39054e73b9044a378a81e697edbe14ff','<p>调转的调整</p>','39e8c39c08944c86bcfbd1e8a0aae5e6','11952781bdb74d85aef42ef9c2593972','2018-05-28 00:44:31'),('39c731f24f8e4ef2b928728e748ba381','<p>搞什么呀</p>','7c760226b1bd4ea2844e7be024228f02','126b3e597d294e22a3343819309231c1','2018-05-26 23:50:01'),('3ab19debc5304969a107ffec43f4760e','<p>回复第二贴</p>','d34d8ca19d284d90a778fb3ac92e56c5','126b3e597d294e22a3343819309231c1','2018-05-28 11:54:11'),('3e492cc2d47a4cb8b66a411cee4e9d6f','<p>评论2</p>','6ca9615077d44767bc0292996038e273','c9c2c4d46ebb49119d3009b5d4629c9a','2018-05-28 13:24:00'),('40cc70f02640413a9dc96f383e953534','<p>测试回复数是否变化</p>','39e8c39c08944c86bcfbd1e8a0aae5e6','11952781bdb74d85aef42ef9c2593972','2018-05-26 22:36:16'),('410db1b11b1348989b243b221f9c970b','<p>评论1</p>','6ca9615077d44767bc0292996038e273','c9c2c4d46ebb49119d3009b5d4629c9a','2018-05-28 13:23:54'),('41d97ea5fcab46e8b4bf51565cbd3c1d','<p>我晕</p>','39e8c39c08944c86bcfbd1e8a0aae5e6','11952781bdb74d85aef42ef9c2593972','2018-05-28 01:03:02'),('47b28a140a9c42648203a2f461b4aad8','<p>评论3</p>','6ca9615077d44767bc0292996038e273','c9c2c4d46ebb49119d3009b5d4629c9a','2018-05-28 13:24:06'),('4aceb630961245dd90f04b5da8d61a44','<p><img src=\"http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/6e/2018new_guzhang_thumb.png\" alt=\"[鼓掌]\" data-w-e=\"1\"><br></p>','39e8c39c08944c86bcfbd1e8a0aae5e6','126b3e597d294e22a3343819309231c1','2018-05-26 22:06:00'),('4c85a7102b8e4f2e88434e66580cd6a4','<p>我来回复你一条</p>','39e8c39c08944c86bcfbd1e8a0aae5e6','b88947c8a2a041cf86b8953e654eda0f','2018-05-29 11:49:17'),('4daf4f7fb910419287ca463fb3f56618','<p>mmmmmm</p>','972c0eba914a4d1da350c0c0be336016','126b3e597d294e22a3343819309231c1','2018-05-29 13:59:02'),('638882fc03f04e3facd0924dfa0875b2','<p>测试一下是否加载头像</p>','36b37fe3f289470b965725e1817793fc','126b3e597d294e22a3343819309231c1','2018-05-26 23:48:47'),('65f23200f8a4474d9eac9f285246bc57','我想测试一下回帖','aab3436fcd9c44fc863a493eadbfc2e7','126b3e597d294e22a3343819309231c1','2018-05-18 11:29:05'),('68b854409bc040c88c7734da07297590','<p><img src=\"http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/fd/2018new_baibai_org.png\" alt=\"[拜拜]\" data-w-e=\"1\"><br></p>','d34d8ca19d284d90a778fb3ac92e56c5','126b3e597d294e22a3343819309231c1','2018-05-28 11:55:03'),('694dddae29c148de86ab581b57179d5a','<p>说的是谁<span style=\"text-decoration-line: underline;\"></span><br></p>','39e8c39c08944c86bcfbd1e8a0aae5e6','11952781bdb74d85aef42ef9c2593972','2018-05-26 22:13:06'),('69d000520eb94744901ff6b5d8426989','<p>我就不信了</p>','39e8c39c08944c86bcfbd1e8a0aae5e6','b88947c8a2a041cf86b8953e654eda0f','2018-05-29 11:25:51'),('6a72f1376a6a43e1b536f9a568d35fcc','阿瑟费说','aab3436fcd9c44fc863a493eadbfc2e7','126b3e597d294e22a3343819309231c1','2018-05-18 13:34:38'),('6aa3de3183f548498b99bd7b813bb0be','测试一下','aab3436fcd9c44fc863a493eadbfc2e7','126b3e597d294e22a3343819309231c1','2018-05-18 13:37:06'),('6f7f85092eb2493ea0798dd5e942db23','<p>测试一下回复时间</p>','d66b64a1024e48eaaacbd57698a3b7dd','126b3e597d294e22a3343819309231c1','2018-06-01 00:36:17'),('707f10c3c01c473886bc85f2ab673b64','<p>mmmmmm</p>','aab3436fcd9c44fc863a493eadbfc2e7','126b3e597d294e22a3343819309231c1','2018-05-29 13:59:44'),('71fe34a3c685490da9f6b7616007dcfc','测试一下啊刘琳了','aab3436fcd9c44fc863a493eadbfc2e7','126b3e597d294e22a3343819309231c1','2018-05-18 13:54:13'),('73c443e827de41aa92e24102ff59aa1f','<p>再试试哈<img src=\"http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/f6/2018new_aini_org.png\" alt=\"[爱你]\" data-w-e=\"1\"></p>','39e8c39c08944c86bcfbd1e8a0aae5e6','693c5033481a41bea81a273e29357ccc','2018-05-28 00:11:58'),('76973fb918cd470480165b357c045f55','<p>回复第三贴</p><p><br></p>','d34d8ca19d284d90a778fb3ac92e56c5','126b3e597d294e22a3343819309231c1','2018-05-28 11:54:22'),('795d480288844204833762d9081609cb','<p>再次回复一下</p>','d3f3a97fe6cd4c95b2e51837753a7ea5','b88947c8a2a041cf86b8953e654eda0f','2018-05-28 15:23:12'),('79cc097bcccd4405b24fd2596e87e217','<p>我再试试回复</p>','67b0e3000a814eb8ab28465704f4745e','b88947c8a2a041cf86b8953e654eda0f','2018-05-28 15:23:28'),('7a30b2652c5c4c779870c956f0570bf5','问题好多啊','aab3436fcd9c44fc863a493eadbfc2e7','126b3e597d294e22a3343819309231c1','2018-05-18 13:50:16'),('7aa1c44ca60f4d18ad41023f3a2944de','<p>我就是想写信</p>','39e8c39c08944c86bcfbd1e8a0aae5e6','b88947c8a2a041cf86b8953e654eda0f','2018-05-30 16:35:26'),('8c100a47fed248f3bc2577d150b52e6a','<p>测试一下啊</p>','39e8c39c08944c86bcfbd1e8a0aae5e6','c9c2c4d46ebb49119d3009b5d4629c9a','2018-05-28 14:05:28'),('90a5101d4da246d886219738ce1cb0b4','<p>真牛逼呀<span style=\"text-decoration-line: underline;\"></span></p>','39e8c39c08944c86bcfbd1e8a0aae5e6','11952781bdb74d85aef42ef9c2593972','2018-05-26 22:12:54'),('94e3c6ba94184e0b8f3df094f6a15274','<p>我擦</p>','12d20274e69d4d2da305c0ab2b6758c2','b88947c8a2a041cf86b8953e654eda0f','2018-06-01 01:43:01'),('9789ba9447da4ee599ef2a4d2e4c7ef3','<p>111111</p>','26b7f7122f924019a376514313d6166f','b88947c8a2a041cf86b8953e654eda0f','2018-05-28 14:48:53'),('97d3cb71e5d048f6939787a5f959015d','明天','aab3436fcd9c44fc863a493eadbfc2e7','126b3e597d294e22a3343819309231c1','2018-05-18 13:46:05'),('98787c80cdbf41629a4b44255ea9131e','<p>卧槽</p>','972c0eba914a4d1da350c0c0be336016','126b3e597d294e22a3343819309231c1','2018-05-29 13:57:22'),('9954e92fd1674a9db97842e1091729eb','<p>在测试一次</p>','39e8c39c08944c86bcfbd1e8a0aae5e6','11952781bdb74d85aef42ef9c2593972','2018-05-28 00:57:59'),('9d7cd8a789564d73ad8ae3d3f573e12f','最后一次刷新一下','38b2a6e50cac42de90ec2a4854577349','126b3e597d294e22a3343819309231c1','2018-05-24 13:53:57'),('9df9dd901c85443dbe544927e319019b','<p>我吃吃吃</p>','38b2a6e50cac42de90ec2a4854577349','126b3e597d294e22a3343819309231c1','2018-05-29 14:01:00'),('9ecebeeb519c4a7f897425fc4b1cfe2b','<p>回复一下试试</p>','c24f77ee78c24bd88d8eca5232e80b8d','126b3e597d294e22a3343819309231c1','2018-05-29 14:32:47'),('a274f4bfde33445ba96a6ccc5a8633df','ssssssss','38b2a6e50cac42de90ec2a4854577349','126b3e597d294e22a3343819309231c1','2018-05-24 13:34:07'),('a67a3e25abed49d1a01557c060f17be5','<p>1111</p>','972c0eba914a4d1da350c0c0be336016','126b3e597d294e22a3343819309231c1','2018-05-29 13:55:38'),('a7b03fb46b2d4809853171a7d2647166','<p>回复第一帖</p>','d34d8ca19d284d90a778fb3ac92e56c5','126b3e597d294e22a3343819309231c1','2018-05-28 11:54:01'),('ab070655cbe34faa9d013d54b898d944','<p>回复一下</p>','d34d8ca19d284d90a778fb3ac92e56c5','b88947c8a2a041cf86b8953e654eda0f','2018-05-28 15:21:38'),('af63bbb61f86451dabd20e990c4a93ef','zhsshi&nbsp;','aab3436fcd9c44fc863a493eadbfc2e7','126b3e597d294e22a3343819309231c1','2018-05-18 13:41:01'),('af677139bccc4a37845194752680ac75','是不是可以成功一次了呢','38b2a6e50cac42de90ec2a4854577349','126b3e597d294e22a3343819309231c1','2018-05-24 14:01:22'),('b67cffd19fcd4679ab1f71581da9bd0d','<p>加个130的评论</p><p><br></p>','d34d8ca19d284d90a778fb3ac92e56c5','11952781bdb74d85aef42ef9c2593972','2018-05-28 12:45:26'),('b90f946a95fc4e7e98d1d8fbeda17c90','测试一下啊刘琳了','aab3436fcd9c44fc863a493eadbfc2e7','126b3e597d294e22a3343819309231c1','2018-05-18 13:55:29'),('bb65f7074c7f4e239b2acb6551e308a8','<p>自己回复自己有意思</p>','7c760226b1bd4ea2844e7be024228f02','126b3e597d294e22a3343819309231c1','2018-05-29 11:10:44'),('bc53e55925a2488a9478eb9617a6aab4','<p>wpca</p>','12d20274e69d4d2da305c0ab2b6758c2','b88947c8a2a041cf86b8953e654eda0f','2018-06-01 01:40:17'),('bc6f29a2fb0f49a78e0934de65a7f659','<p>你好呀</p>','39e8c39c08944c86bcfbd1e8a0aae5e6','693c5033481a41bea81a273e29357ccc','2018-05-28 00:10:30'),('bf2ce6c1adab4f36ad7a0d23bb4dc113','<p>回复一下</p><p><br></p>','c24f77ee78c24bd88d8eca5232e80b8d','126b3e597d294e22a3343819309231c1','2018-05-30 11:01:50'),('bf7019a33c5748a4a4655c443f1ec67c','<p>测试一下回复信息</p>','39e8c39c08944c86bcfbd1e8a0aae5e6','126b3e597d294e22a3343819309231c1','2018-05-29 13:51:01'),('c33cbe8f5f3348f5b904902e50f3d0d5','为什么不稳定呢？','38b2a6e50cac42de90ec2a4854577349','126b3e597d294e22a3343819309231c1','2018-05-24 13:39:04'),('c37a3fe760e741289632916988778a5e','我想成功了','38b2a6e50cac42de90ec2a4854577349','126b3e597d294e22a3343819309231c1','2018-05-24 14:17:19'),('c99b3092fb9c44b6be2649e71f203f15','<p>回复一下</p>','36b37fe3f289470b965725e1817793fc','126b3e597d294e22a3343819309231c1','2018-05-29 13:52:13'),('cc29e3e5fcfc48df9487326a24db8fae','我就不信邪了','38b2a6e50cac42de90ec2a4854577349','126b3e597d294e22a3343819309231c1','2018-05-24 13:45:47'),('d4e23bb5a51a4eb6a6f8006c249a95e8','<p>测试一下回复</p>','d3f3a97fe6cd4c95b2e51837753a7ea5','b88947c8a2a041cf86b8953e654eda0f','2018-05-28 15:22:46'),('dc5e354aa5174ab687bac21da5a33537','<p>回复一下</p>','d66b64a1024e48eaaacbd57698a3b7dd','126b3e597d294e22a3343819309231c1','2018-05-29 01:32:32'),('dddc5aebd3da4e3384524146da593782','<p>我擦</p>','d34d8ca19d284d90a778fb3ac92e56c5','126b3e597d294e22a3343819309231c1','2018-05-28 11:54:41'),('df87838ae69548308428122d9709ead7','<p>11</p>','d34d8ca19d284d90a778fb3ac92e56c5','b88947c8a2a041cf86b8953e654eda0f','2018-05-28 15:21:47'),('dfb91b258de34f2485341ff77b14b925','<p>测试一下内容</p>','d66b64a1024e48eaaacbd57698a3b7dd','126b3e597d294e22a3343819309231c1','2018-05-28 22:14:58'),('eb4cf591524f47899fdce729d5da6400','<p>测试一下消息</p>','39e8c39c08944c86bcfbd1e8a0aae5e6','11952781bdb74d85aef42ef9c2593972','2018-05-29 11:17:33'),('ed61c524e07b4c0db5660ca15bca9a8d','这次测试一下回复','a9d8bf0b83b04a9fb2961f69ab8cdf83','126b3e597d294e22a3343819309231c1','2018-05-24 14:28:22'),('ee3135b999a943eaa3569755f1a09633','<p>我擦不信了</p>','964bc7664d884010947d1313fc45b867','126b3e597d294e22a3343819309231c1','2018-06-01 00:44:28'),('f1eb93dc86c0498695f350455b755e3d','<p>测试一下回复</p>','12d20274e69d4d2da305c0ab2b6758c2','126b3e597d294e22a3343819309231c1','2018-06-01 01:22:03'),('f7db4be8f0ef4c5bbec3e4613c154af4','<p>我就想看看有什么问题<img src=\"http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/2d/2018new_xiaoerbuyu_org.png\" alt=\"[笑而不语]\" data-w-e=\"1\"></p>','39e8c39c08944c86bcfbd1e8a0aae5e6','693c5033481a41bea81a273e29357ccc','2018-05-28 00:29:52'),('fbe3cb7e8a2d491ab001ef3f2880e669','<p>马蒂</p>','d34d8ca19d284d90a778fb3ac92e56c5','126b3e597d294e22a3343819309231c1','2018-05-28 11:54:48'),('fc9e57092eaa40c89097f0993343ab9f','<p>再次测试一下</p>','39e8c39c08944c86bcfbd1e8a0aae5e6','11952781bdb74d85aef42ef9c2593972','2018-05-28 00:56:01'),('fcb8a1c131104934b7c98a86051e8fce','<p>测试一下评论后后退的情况</p>','39e8c39c08944c86bcfbd1e8a0aae5e6','11952781bdb74d85aef42ef9c2593972','2018-05-28 00:52:50'),('ffcae594c3ed49cfa70ae34c26c2107b','<p><img src=\"http://sse-ustc-wangeditor.oss-cn-beijing.aliyuncs.com/wangEditor/9c3805b8-b7f5-45b4-a791-784d401e623f1111.png?Expires=1842839720&amp;OSSAccessKeyId=LTAIVz7TwaSO7otx&amp;Signature=HPd2aRUn0%2FvDSrJ%2Ftg4BMHaUHak%3D\" style=\"max-width:100%;\"><br></p>','d34d8ca19d284d90a778fb3ac92e56c5','126b3e597d294e22a3343819309231c1','2018-05-28 11:55:21');
/*!40000 ALTER TABLE `reply` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` varchar(32) NOT NULL,
  `user_name` varchar(20) NOT NULL,
  `password` varchar(50) NOT NULL,
  `phone` varchar(15) NOT NULL,
  `email` varchar(30) NOT NULL,
  `actived` varchar(1) NOT NULL DEFAULT '0',
  `timestamp` timestamp(4) NOT NULL DEFAULT CURRENT_TIMESTAMP(4) ON UPDATE CURRENT_TIMESTAMP(4),
  `headUrlFlag` int(11) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`) USING BTREE,
  UNIQUE KEY `user_name` (`user_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('11952781bdb74d85aef42ef9c2593972','sa17225130','7B8F8886983640E2D6681086B26634BBD3B5A1D4','18896713913','285827923@qq.com','1','2018-05-28 06:23:30.1429',1),('126b3e597d294e22a3343819309231c1','sa17225131','7B8F8886983640E2D6681086B26634BBD3B5A1D4','18896713913','285827923@qq.com','1','2018-06-06 02:24:39.1323',1),('693c5033481a41bea81a273e29357ccc','sa17225134','7B8F8886983640E2D6681086B26634BBD3B5A1D4','18896713913','285827923@qq.com','1','2018-05-28 06:38:34.6502',1),('b88947c8a2a041cf86b8953e654eda0f','sa17225132','7B8F8886983640E2D6681086B26634BBD3B5A1D4','15938387790','285827923@qq.com','1','2018-05-28 06:44:36.1146',1),('c9c2c4d46ebb49119d3009b5d4629c9a','sa17225133','7B8F8886983640E2D6681086B26634BBD3B5A1D4','18896713913','285827923@qq.com','1','2018-05-28 06:08:58.3989',1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userinfo`
--

DROP TABLE IF EXISTS `userinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `userinfo` (
  `id` varchar(32) NOT NULL,
  `name` varchar(20) NOT NULL,
  `sex` int(5) NOT NULL,
  `nation` int(10) NOT NULL,
  `home` varchar(50) NOT NULL,
  `political` int(5) NOT NULL,
  `workstation` varchar(50) DEFAULT NULL,
  `job` varchar(50) DEFAULT NULL,
  `undergraduate` varchar(50) NOT NULL,
  `speciality` varchar(50) NOT NULL,
  `date1` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6),
  `date2` timestamp(6) NOT NULL DEFAULT '1978-12-31 17:01:01.000001',
  PRIMARY KEY (`id`),
  CONSTRAINT `userinfo_ibfk_1` FOREIGN KEY (`id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userinfo`
--

LOCK TABLES `userinfo` WRITE;
/*!40000 ALTER TABLE `userinfo` DISABLE KEYS */;
INSERT INTO `userinfo` VALUES ('11952781bdb74d85aef42ef9c2593972','马云',1,1,'1',1,'1','1','1','1','2018-05-15 16:00:00.000000','2018-05-29 16:00:00.000000'),('126b3e597d294e22a3343819309231c1','来了',1,1,'1',1,'1','1','1','1','2018-06-18 16:00:00.000000','2018-06-27 16:00:00.000000'),('b88947c8a2a041cf86b8953e654eda0f','武炼',1,1,'1',1,'1','1','1','1','2018-05-07 16:00:00.000000','2018-05-29 16:00:00.000000'),('c9c2c4d46ebb49119d3009b5d4629c9a','姬祥',1,1,'1',1,'1','1','1','1','2018-05-20 16:00:00.000000','2018-05-29 16:00:00.000000');
/*!40000 ALTER TABLE `userinfo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-06-06 13:50:28
