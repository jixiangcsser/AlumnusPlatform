![](https://coding.net/u/Blust/p/Server-Alumni-platform/git/raw/master/logo.png)
#Server-Alumni-platform
校友平台后端代码库，[bug report点这里](https://coding.net/u/Blust/p/Server-Alumni-platform/topic/tag/6051446)

## Description
* 目前项目配置为springboot + mybatis(mysql) + redis
* 相关库已经在项目内配好，可参考示例代码进行开发。
* mysql表信息已导出，在本地配置好mysql后建立数据库springbootdb后直接执行sql文件导入表结构与信息。
* 支持springboot热部署 [参考网址: IDEA + Springboot热部署实现](http://blog.csdn.net/fws759078664/article/details/79094737)
* [参考网址: springboot入门示例代码1](https://github.com/JeffLi1993/springboot-learning-example)
* [参考网址: springboot入门示例代码2](https://github.com/QDPeng/SpringBootSamples)
* 开发过程中尽量遵循springboot开发思想(such as Aop and ...)
* 异步推荐使用@Async注解。

# 功能列表

- [x] 登陆/注销 -- 完成 
- [x] 注册 -- 完成
- [x] 图表📈 -- 完成
- [x] 用户权限模块 -- 完成
- [x] 用户基本信息 -- 完成
- [x] 用户文件服务 -- 完成 (发放阿里云oss token)

## 未来任务
* 论文代办服务模块
* 简历模块
* 直播服务器

## 技术栈

springboot(restful) + mysql(mybatis) + redis


# 效果演示

#### (可在校友平台进行注册，登陆等相关操作并在前端地址查看效果)

[查看效果请戳这里](sse-ustc.oss-cn-beijing.aliyuncs.com)

##  To get started:
     1: 下载代码库, git clone https://git.coding.net/Blust/Server-Alumni-platform.git
     
     2: 使用Intellij IDEA最新编译器开发，在本地安装好，需要正版的同学在淘宝上购买，5块一个。
     
     3: 配置Maven，具体流程可自行百度idea如何配置maven。
     
     4: 安装配置Mysql, 建立数据库springbootdb，然后在该数据库内执行springbootdb.sql脚本。
     
     5: 安装配置Redis, redis server端口设在6379。
     
     6: 以上步骤完成后，在idea里新建一个maven项目，类型选择maven-archetype-quickstart。
     
     7: 将代码库中的代码导入你的新建项目中，只需等待maven自动下载配置文件中的对应包后，项目即可顺利运行。
     