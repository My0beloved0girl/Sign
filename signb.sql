/*
SQLyog v10.2 
MySQL - 5.5.37 : Database - signb
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`signb` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;

USE `signb`;

/*Table structure for table `easybuy_user` */

DROP TABLE IF EXISTS `easybuy_user`;

CREATE TABLE `easybuy_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户名',
  `userName` varchar(20) NOT NULL COMMENT '用户真实姓名',
  `loginName` varchar(20) NOT NULL COMMENT '用户登陆用户名',
  `password` varchar(50) NOT NULL COMMENT '密码',
  `sex` int(1) NOT NULL COMMENT '性别',
  `identityCode` bigint(18) DEFAULT NULL COMMENT '身份证号',
  `email` varchar(80) DEFAULT NULL COMMENT '电子邮箱',
  `mobile` varchar(11) DEFAULT NULL COMMENT '手机',
  `type` int(1) NOT NULL COMMENT '用户类型',
  `role` int(11) NOT NULL COMMENT '角色',
  `clas` varchar(255) DEFAULT NULL COMMENT '班级',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8 COMMENT='用户表';

/*Data for the table `easybuy_user` */

insert  into `easybuy_user`(`id`,`userName`,`loginName`,`password`,`sex`,`identityCode`,`email`,`mobile`,`type`,`role`,`clas`) values (2,'系统管理员','admin','1',1,130406198302141869,'hello11@bdqn.com','15832335151',1,1,''),(10,'程广','cgn','123456',1,140225189987854589,'1044732267@qq.com','13366055011',0,2,'97'),(11,'韩语良','hyl','1',1,140225198874584539,'1044732267@qq.com','13366055010',0,2,'97'),(12,'陈康','ck','1',1,140225189987854589,'1044732267@qq.com','13366055010',0,2,'96'),(13,'康有沈','kys','1',1,140225198551254152,'1044732267@qq.com','13366055010',0,3,'97'),(14,'沈白','sb','1',1,140225158987854589,'1044732267@qq.com','13366055010',0,3,'97'),(15,'李白','lb','1',1,140225189987854589,'10447322658@qq.com','13369985541',0,3,'97'),(16,'李高伟','lgw','1',1,140225189987854589,'1011322658@qq.com','13369985545',0,3,'97'),(18,'尚泽忠','szz','1',1,140225198810013745,'1044888844@qq.com','13366528458',0,3,'97'),(19,'李光亮','lgl','1',1,140225198841547785,'1047777@qq.com','13366055048',0,3,'96'),(20,'李光亮','szz','1',1,140225198810013748,'1044732267@qq.com','13366555010',1,3,'96'),(22,'错付','1','1',1,123456789789456125,'1@qq.com','1597453214',0,3,'96'),(24,'李庆磊','lql','123456',1,340521200312275486,'1@qq.com','12345678912',0,3,'96'),(25,'1111','111','123456',1,340521222222224581,'1@qq.com','15422256386',0,3,'96');

/*Table structure for table `grade` */

DROP TABLE IF EXISTS `grade`;

CREATE TABLE `grade` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bname` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `grade` */

insert  into `grade`(`id`,`bname`) values (1,'96'),(2,'97');

/*Table structure for table `ls_butten` */

DROP TABLE IF EXISTS `ls_butten`;

CREATE TABLE `ls_butten` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `btntype` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `ls_butten` */

insert  into `ls_butten`(`id`,`btntype`) values (1,'<button type=\'button\' lay-event=\'delFunc\' class=\'layui-btn layui-btn-danger xz\'><i class=\'layui-icon\'>&#xe640;</i>删除</button>'),(2,'<button type=\'button\' lay-event=\'addFunc\' class=\'layui-btn layui-btn-warm xz\'><i class=\'layui-icon\'>&#xe654;</i>新增</button>'),(3,'<button type=\'button\' lay-event=\'upFunc\' class=\'layui-btn layui-btn-normal xz\'><i class=\'layui-icon\'>&#xe642;</i>修改</button>'),(4,'<button type=\'button\' lay-event=\'shangFunc\' class=\'layui-btn layui-btn-radius xz\'><i class=\'layui-icon\'>&#xe681;</i>上传</button>'),(5,'<button type=\'button\' lay-event=\'xiaFunc\' class=\'layui-btn layui-btn-radius xz\'><i class=\"layui-icon\">&#xe601;</i>下载</button>'),(6,'<button type=\'button\' lay-event=\'fenFunc\' class=\'layui-btn layui-btn-primary xz\'><i class=\'layui-icon\'>&#xe654;</i>分配</button>');

/*Table structure for table `ls_menu` */

DROP TABLE IF EXISTS `ls_menu`;

CREATE TABLE `ls_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mname` varchar(255) NOT NULL,
  `mfatherid` int(11) NOT NULL,
  `type` int(11) NOT NULL,
  `url` varchar(255) DEFAULT NULL,
  `buttom` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8;

/*Data for the table `ls_menu` */

insert  into `ls_menu`(`id`,`mname`,`mfatherid`,`type`,`url`,`buttom`) values (1,'系统权限菜单',0,1,'',''),(2,'用户管理',1,2,'/Sign/YHS?action=yhan','js/zxjs/ZxList.js'),(3,'权限管理',1,2,'/Sign/YHS?action=qxan','js/zxjs/menlist.js'),(4,'删除用户',2,3,'','<button type=\"button\" lay-event=\"delUser\" class=\"layui-btn layui-btn-danger\">删除用户</button>'),(5,'修改用户',2,3,'','<button type=\"button\" lay-event=\"uapUser\" class=\"layui-btn layui-btn-normal\">修改用户</button>'),(6,'增加用户',2,3,'','<button type=\"button\" lay-event=\"insUser\" class=\"layui-btn layui-btn-warm\">增加用户</button>'),(7,'删除权限',3,3,'','<button type=\"button\" lay-event=\"delMenu\" class=\"layui-btn layui-btn-danger\">删除权限</button>'),(8,'修改权限',3,3,'','<button type=\"button\" lay-event=\"uapMenu\" class=\"layui-btn layui-btn-normal\">修改权限</button>'),(9,'增加权限',3,3,'','<button type=\"button\" lay-event=\"addMenu\" class=\"layui-btn layui-btn-warm\">增加权限</button>'),(18,'角色管理',1,2,'/Sign/YHS?action=jsan','js/zxjs/JsList.js'),(20,'删除角色',18,3,NULL,'<button type=\"button\" lay-event=\"deljs\" class=\"layui-btn layui-btn-danger\">删除角色</button>'),(21,'修改角色',18,3,NULL,'<button type=\"button\" lay-event=\"upajs\" class=\"layui-btn layui-btn-normal\">修改角色</button>'),(23,'增加角色',18,3,NULL,'<button type=\"button\" lay-event=\"insjs\" class=\"layui-btn layui-btn-warm\">增加角色</button>'),(30,'分配权限',18,3,'','<button type=\"button\" lay-event=\"hairMenu\" class=\"layui-btn layui-btn-primary\"><i class=\"layui-icon\">&#xe654;</i>分配权限</button>'),(32,'打卡签到',37,3,'/Sign/QDS?action=insqd','<button type=\"button\" lay-event=\"insqd\" class=\"layui-btn layui-btn-warm\">打卡签到</button>'),(37,'查看签到',1,2,'/Sign/YHS?action=qiandao','js/zxjs/QdList.js'),(39,'查看班级',1,2,'/Sign/YHS?action=bjan','js/zxjs/BjList.js');

/*Table structure for table `ls_role` */

DROP TABLE IF EXISTS `ls_role`;

CREATE TABLE `ls_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rname` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `ls_role` */

insert  into `ls_role`(`id`,`rname`) values (1,'管理员'),(2,'老师'),(3,'学生');

/*Table structure for table `students` */

DROP TABLE IF EXISTS `students`;

CREATE TABLE `students` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `logname` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `signTime` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `sex` int(11) NOT NULL,
  `clas` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `role` int(11) NOT NULL,
  `ip` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `students` */

insert  into `students`(`id`,`name`,`logname`,`signTime`,`sex`,`clas`,`role`,`ip`) values (1,'王五','wangwu','2021-4-28',1,'96',3,'117.136.117.205'),(2,'李四','lisi','2021-8-9',1,'96',3,'117.136.117.205'),(17,'李庆磊','lql','2021-04-29 15:23:19',1,'97',3,'117.136.117.205'),(18,'系统管理员','admin','2021-04-29 15:57:11',1,'',1,'117.136.117.205'),(19,'系统管理员','admin','2021-04-30 08:38:45',1,'',1,'117.136.117.205'),(20,'李庆磊','lql','2021-04-30 08:39:03',1,'96',3,'117.136.117.205'),(21,'程广','cgn','2021-04-30 09:24:53',1,'97',2,'117.136.117.205'),(22,'沈白','sb','2021-04-30 10:58:51',1,'97',3,'114.107.28.189');

/*Table structure for table `user_menu` */

DROP TABLE IF EXISTS `user_menu`;

CREATE TABLE `user_menu` (
  `userid` int(11) NOT NULL,
  `menuid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user_menu` */

insert  into `user_menu`(`userid`,`menuid`) values (3,1),(3,32),(3,37),(1,1),(1,2),(1,4),(1,5),(1,6),(1,3),(1,7),(1,8),(1,9),(1,18),(1,20),(1,21),(1,23),(1,30),(1,37),(1,32),(1,39),(1,40),(1,41),(1,42),(2,1),(2,37),(2,32),(2,39);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
