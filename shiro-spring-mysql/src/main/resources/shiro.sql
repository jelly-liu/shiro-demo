/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.6.24 : Database - shiro
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`shiro` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `shiro`;

/*Table structure for table `t_permission` */

DROP TABLE IF EXISTS `t_permission`;

CREATE TABLE `t_permission` (
  `id` varchar(16) NOT NULL,
  `pe_name` varchar(32) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_permission` */

insert  into `t_permission`(`id`,`pe_name`) values ('1','admin:list'),('2','admin:add'),('3','admin:delete'),('4','admin:*'),('5','*');

/*Table structure for table `t_resource` */

DROP TABLE IF EXISTS `t_resource`;

CREATE TABLE `t_resource` (
  `id` varchar(16) NOT NULL,
  `re_name` varchar(128) NOT NULL,
  `re_path` varchar(512) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_resource` */

insert  into `t_resource`(`id`,`re_name`,`re_path`) values ('1','admin','/admin'),('2','adminList','/adminList'),('3','adminAdd','/adminAdd'),('4','adminDelete','/adminDelete'),('5','adminSuper','/adminSuper');

/*Table structure for table `t_role` */

DROP TABLE IF EXISTS `t_role`;

CREATE TABLE `t_role` (
  `id` varchar(16) NOT NULL,
  `ro_name` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_role` */

insert  into `t_role`(`id`,`ro_name`) values ('1','roleSuper'),('2','roleList'),('3','roleAdd'),('4','roleDelete');

/*Table structure for table `t_role_permission` */

DROP TABLE IF EXISTS `t_role_permission`;

CREATE TABLE `t_role_permission` (
  `id` varchar(16) NOT NULL,
  `role_id` varchar(16) NOT NULL,
  `permission_id` varchar(16) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `NewIndex1` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_role_permission` */

insert  into `t_role_permission`(`id`,`role_id`,`permission_id`) values ('1','1','1'),('2','1','2'),('3','1','3'),('4','2','1'),('5','3','2'),('6','4','3');

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `id` varchar(16) NOT NULL,
  `username` varchar(10) NOT NULL,
  `password` varchar(100) NOT NULL,
  `salt` varchar(13) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `NewIndex1` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_user` */

insert  into `t_user`(`id`,`username`,`password`,`salt`) values ('1','adminSuper','e99a18c428cb38d5f260853678922e03','abc'),('2','adminList','e99a18c428cb38d5f260853678922e03','abc'),('3','adminAdd','e99a18c428cb38d5f260853678922e03','abc'),('4','adminDelet','e99a18c428cb38d5f260853678922e03','abc');

/*Table structure for table `t_user_resource` */

DROP TABLE IF EXISTS `t_user_resource`;

CREATE TABLE `t_user_resource` (
  `id` varchar(16) NOT NULL,
  `user_id` varchar(16) NOT NULL,
  `resource_id` varchar(16) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `NewIndex1` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_user_resource` */

insert  into `t_user_resource`(`id`,`user_id`,`resource_id`) values ('1','1','1'),('10','3','2'),('11','3','3'),('12','3','4'),('13','4','1'),('14','4','2'),('15','4','3'),('16','4','4'),('17','1','5'),('2','1','2'),('3','1','3'),('4','1','4'),('5','2','1'),('6','2','2'),('7','2','3'),('8','2','4'),('9','3','1');

/*Table structure for table `t_user_role` */

DROP TABLE IF EXISTS `t_user_role`;

CREATE TABLE `t_user_role` (
  `id` varchar(16) NOT NULL,
  `user_id` varchar(16) NOT NULL,
  `role_id` varchar(16) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `NewIndex1` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_user_role` */

insert  into `t_user_role`(`id`,`user_id`,`role_id`) values ('1','1','1'),('2','1','2'),('3','1','3'),('4','1','4'),('5','2','2'),('6','3','3'),('7','4','4');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
