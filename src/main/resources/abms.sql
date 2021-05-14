/*
Navicat MySQL Data Transfer

Source Server         : abms
Source Server Version : 80021
Source Host           : 129.211.59.87:3306
Source Database       : abms

Target Server Type    : MYSQL
Target Server Version : 80021
File Encoding         : 65001

Date: 2021-05-14 10:15:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `contacts`
-- ----------------------------
DROP TABLE IF EXISTS `contacts`;
CREATE TABLE `contacts` (
  `contact_id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `contact_name` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '联系人姓名',
  `contact_mobile` varchar(11) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '联系人手机',
  `contact_tel` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '联系人电话',
  `contact_email` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '联系人邮箱',
  `contact_address` varchar(100) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '联系人地址',
  `contact_nickname` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '联系人称呼',
  `contact_birthday` varchar(10) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '联系人生日',
  `contact_remark` varchar(100) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '联系人备注',
  `contact_icon` varchar(100) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '联系人头像',
  `status` varchar(2) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '数据状态 从dict表中取',
  `create_user` int DEFAULT NULL COMMENT '创建人',
  `create_time` varchar(19) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '创建时间',
  `update_user` int DEFAULT NULL COMMENT '修改人',
  `update_time` varchar(19) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`contact_id`),
  UNIQUE KEY `index_contacts` (`contact_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='联系人表';

-- ----------------------------
-- Records of contacts
-- ----------------------------
INSERT INTO `contacts` VALUES ('1', '联系人一', '12345678945', '0755-95361', '123@aniikiki.com', '广东省深圳市T3航站楼', '老大', '1988-10-17', '第一个联系人', null, '1', '1', '2021-04-26 09:35:32', null, null);
INSERT INTO `contacts` VALUES ('3', '联系人二', '12345678912', '0755-95361', '123@aniikiki.com', '广东省深圳市T3航站楼', '老二', '2021-04-01', null, null, '1', '1', '2021-04-26 14:10:51', null, null);
INSERT INTO `contacts` VALUES ('4', '联系人三', '12345678912', '0755-95361', '123@aniikiki.com', '广东省深圳市T3航站楼', '老三', '2021-04-02', null, null, '1', '1', '2021-04-26 14:11:03', '1', '2021-05-08 14:28:26');
INSERT INTO `contacts` VALUES ('5', '联系人四', '12345678912', '0755-95361', '123@aniikiki.com', '广东省深圳市T3航站楼', '老四', '2021-04-03', null, null, '1', '1', '2021-04-26 14:13:25', null, null);
INSERT INTO `contacts` VALUES ('6', '联系人五', '12345678912', '0755-95361', '123@aniikiki.com', '广东省深圳市T3航站楼', '老五', '2021-04-05', null, null, '1', '1', '2021-04-26 14:13:38', null, null);
INSERT INTO `contacts` VALUES ('7', '联系人六', '12345678912', '0755-95361', '123@aniikiki.com', '广东省深圳市T3航站楼', '老六', '2021-04-06', null, null, '1', '1', '2021-04-26 14:13:50', null, null);
INSERT INTO `contacts` VALUES ('8', '联系人七', '12345678912', '0755-95361', '123@aniikiki.com', '广东省深圳市T3航站楼', '老七', '2021-04-07', null, null, '1', '1', '2021-04-26 14:14:06', null, null);
INSERT INTO `contacts` VALUES ('9', '联系人八', '12345678912', '0755-95361', '123@aniikiki.com', '广东省深圳市T3航站楼', '老八', '2021-04-08', null, null, '1', '1', '2021-04-26 14:14:15', null, null);
INSERT INTO `contacts` VALUES ('10', '联系人九', '12345678912', '0755-95361', '123@aniikiki.com', '广东省深圳市T3航站楼', '老九', '2021-04-09', null, null, '1', '1', '2021-04-26 14:14:32', null, null);
INSERT INTO `contacts` VALUES ('11', '联系人十', '12345678912', '0755-95361', '123@aniikiki.com', '广东省深圳市T3航站楼', '老十', '2021-04-10', null, null, '1', '1', '2021-04-26 14:14:46', null, null);
INSERT INTO `contacts` VALUES ('12', '联系人十一', '12345678912', '0755-95361', '123@aniikiki.com', '广东省深圳市T3航站楼', '老十一', '2021-04-11', null, null, '1', '1', '2021-04-26 14:20:42', null, null);
INSERT INTO `contacts` VALUES ('13', '联系人十二', '12345678912', '0755-95361', '123@aniikiki.com', '广东省深圳市T3航站楼', '老十二', '2021-04-12', null, null, '1', '1', '2021-04-26 14:20:56', null, null);
INSERT INTO `contacts` VALUES ('14', '联系人十三', '12345678912', '0755-95361', '123@aniikiki.com', '广东省深圳市T3航站楼', '老十三', '2021-04-13', null, null, '1', '1', '2021-04-26 14:21:08', null, null);
INSERT INTO `contacts` VALUES ('15', '联系人十四', '12345678912', '0755-95361', '123@aniikiki.com', '广东省深圳市T3航站楼', '老十四', '2021-04-14', null, null, '1', '1', '2021-04-26 14:21:18', null, null);
INSERT INTO `contacts` VALUES ('16', '联系人十五', '12345678912', '0755-95361', '123@aniikiki.com', '广东省深圳市T3航站楼', '老十五', '2021-04-15', null, null, '1', '1', '2021-04-26 14:21:32', null, null);
INSERT INTO `contacts` VALUES ('17', '联系人十六', '12345678912', '0755-95361', '123@aniikiki.com', '广东省深圳市T3航站楼', '老十六', '2021-04-16', null, null, '1', '1', '2021-04-26 14:21:43', '1', '2021-04-26 14:58:13');
INSERT INTO `contacts` VALUES ('18', '十一', '18316688725', '1008611', '1589754125@qq.com', '无法', 'df', '2021-05-04', null, null, '-1', '1', '2021-05-06 11:26:14', '1', '2021-05-06 11:26:55');

-- ----------------------------
-- Table structure for `contacts_group`
-- ----------------------------
DROP TABLE IF EXISTS `contacts_group`;
CREATE TABLE `contacts_group` (
  `group_id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `group_name` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '群组名称',
  `group_remark` varchar(100) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '群组备注',
  `status` varchar(2) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '数据状态 从dict表中取',
  `create_user` int DEFAULT NULL COMMENT '创建人',
  `create_time` varchar(19) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '创建时间',
  `update_user` int DEFAULT NULL COMMENT '修改人',
  `update_time` varchar(19) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`group_id`),
  UNIQUE KEY `index_group` (`group_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='联系人群组表';

-- ----------------------------
-- Records of contacts_group
-- ----------------------------
INSERT INTO `contacts_group` VALUES ('1', '群组一', '这是一个测试群组', '1', '1', '2021-04-28 17:14:01', '1', '2021-04-29 14:50:54');
INSERT INTO `contacts_group` VALUES ('2', '群组二', '测试群组二', '1', '1', '2021-04-29 14:52:44', '1', '2021-04-29 15:03:05');

-- ----------------------------
-- Table structure for `contacts_group_rel`
-- ----------------------------
DROP TABLE IF EXISTS `contacts_group_rel`;
CREATE TABLE `contacts_group_rel` (
  `group_id` int NOT NULL COMMENT '群组id',
  `contact_id` int NOT NULL COMMENT '联系人id',
  `status` varchar(2) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '数据状态 从dict表中取',
  `create_user` int DEFAULT NULL COMMENT '创建人',
  `create_time` varchar(19) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '创建时间',
  `update_user` int DEFAULT NULL COMMENT '修改人',
  `update_time` varchar(19) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '修改时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='群组联系人关联表';

-- ----------------------------
-- Records of contacts_group_rel
-- ----------------------------
INSERT INTO `contacts_group_rel` VALUES ('1', '1', '1', '1', '2021-04-28 17:14:36', null, null);
INSERT INTO `contacts_group_rel` VALUES ('1', '3', '1', '1', '2021-04-28 17:14:36', null, null);
INSERT INTO `contacts_group_rel` VALUES ('1', '4', '1', '1', '2021-04-28 17:14:36', '1', '2021-05-08 14:28:26');
INSERT INTO `contacts_group_rel` VALUES ('2', '1', '1', '1', '2021-04-30 16:45:10', '1', '2021-05-08 14:25:47');
INSERT INTO `contacts_group_rel` VALUES ('2', '3', '1', '1', '2021-04-30 16:45:10', '1', '2021-05-08 14:25:47');
INSERT INTO `contacts_group_rel` VALUES ('2', '4', '1', '1', '2021-04-30 16:45:10', '1', '2021-05-08 14:28:26');
INSERT INTO `contacts_group_rel` VALUES ('2', '5', '1', '1', '2021-04-30 16:45:10', '1', '2021-05-08 14:25:47');
INSERT INTO `contacts_group_rel` VALUES ('2', '6', '1', '1', '2021-04-30 16:45:10', '1', '2021-05-08 14:25:47');

-- ----------------------------
-- Table structure for `dict`
-- ----------------------------
DROP TABLE IF EXISTS `dict`;
CREATE TABLE `dict` (
  `dict_id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `dict_type_cn` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '字典类型中文名',
  `dict_type_en` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '字典类型英文名',
  `dict_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '字典名称',
  `dict_value` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '字典值',
  `sort` int DEFAULT NULL COMMENT '排序',
  `status` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '数据状态 从dict表获取',
  `create_user` int DEFAULT NULL COMMENT '创建人',
  `create_time` varchar(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '创建时间',
  `update_user` int DEFAULT NULL COMMENT '修改人',
  `update_time` varchar(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`dict_id`),
  UNIQUE KEY `index_dict` (`dict_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='数据字典表';

-- ----------------------------
-- Records of dict
-- ----------------------------
INSERT INTO `dict` VALUES ('1', '数据状态', 'status', '正常', '1', '0', '1', '1', '2021-04-20 21:12:30', null, null);
INSERT INTO `dict` VALUES ('2', '数据状态', 'status', '停用', '0', '1', '1', '1', '2021-04-20 21:12:30', null, null);
INSERT INTO `dict` VALUES ('3', '数据状态', 'status', '删除', '-1', '2', '1', '1', '2021-04-20 21:12:30', null, null);
INSERT INTO `dict` VALUES ('4', '菜单类型', 'menu_type', '路由', 'route', '0', '1', '1', '2021-04-20 21:12:30', null, null);
INSERT INTO `dict` VALUES ('5', '菜单类型', 'menu_type', '外链', 'link', '1', '1', '1', '2021-04-20 21:12:30', null, null);

-- ----------------------------
-- Table structure for `menu`
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `menu_id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `menu_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '菜单名称',
  `menu_type` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '菜单类型 从dict表中取',
  `menu_url` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '菜单地址',
  `menu_icon` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '菜单图标',
  `sort` int DEFAULT NULL COMMENT '排序',
  `pid` int DEFAULT NULL COMMENT '父级菜单id',
  `status` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '数据状态 从dict表中取',
  `create_user` int DEFAULT NULL COMMENT '创建人',
  `create_time` varchar(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '创建时间',
  `update_user` int DEFAULT NULL COMMENT '修改人',
  `update_time` varchar(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '淇敼鏃堕棿',
  PRIMARY KEY (`menu_id`),
  UNIQUE KEY `index_menu` (`menu_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='菜单表';

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES ('1', '联系人管理', 'route', 'contacts', 'el-icon-notebook-1', '0', '0', '1', '1', '2021-04-22 09:35:09', null, null);
INSERT INTO `menu` VALUES ('2', '联系人列表', 'route', 'contacts-list', 'el-icon-notebook-2', '0', '1', '1', '1', '2021-04-22 09:35:09', '1', '2021-05-13 16:30:22');
INSERT INTO `menu` VALUES ('3', '联系人群组', 'route', 'contacts-group', 'el-icon-collection', '1', '1', '1', '1', '2021-04-22 09:35:09', '1', '2021-05-13 16:30:26');
INSERT INTO `menu` VALUES ('4', '系统管理', 'route', 'system', 'el-icon-setting', '1', '0', '1', '1', '2021-04-22 09:35:09', null, null);
INSERT INTO `menu` VALUES ('5', '用户管理', 'route', 'system-user', 'el-icon-user', '0', '4', '1', '1', '2021-04-22 09:35:09', '1', '2021-05-13 16:30:46');
INSERT INTO `menu` VALUES ('6', '角色管理', 'route', 'system-role', 'el-icon-s-custom', '1', '4', '1', '1', '2021-04-22 09:35:09', '1', '2021-05-13 16:31:24');
INSERT INTO `menu` VALUES ('7', '菜单管理', 'route', 'system-menu', 'el-icon-menu', '2', '4', '1', '1', '2021-04-22 09:35:09', '1', '2021-05-13 16:31:30');
INSERT INTO `menu` VALUES ('8', '角色菜单分配', 'route', 'role-menu', 'el-icon-thumb', '3', '4', '-1', '1', '2021-04-22 09:35:09', '1', '2021-04-25 14:47:45');
INSERT INTO `menu` VALUES ('9', '接口文档', 'link', 'doc', 'el-icon-document', '4', '4', '1', '1', '2021-04-22 09:35:09', '1', '2021-05-14 10:14:52');
INSERT INTO `menu` VALUES ('20', '测试菜单', 'link', 'test', 'el-icon-setting', '2', '0', '1', '1', '2021-04-25 16:08:51', '1', '2021-05-11 15:37:51');
INSERT INTO `menu` VALUES ('21', '测试菜单1', 'route', '1', 'el-icon-setting', '1', '20', '1', '1', '2021-04-25 16:09:05', '1', '2021-05-11 15:37:55');
INSERT INTO `menu` VALUES ('22', '测试菜单2', 'route', '2', 'el-icon-setting', '4', '20', '1', '1', '2021-04-25 16:09:24', '1', '2021-05-11 15:38:07');
INSERT INTO `menu` VALUES ('23', '测试菜单3', 'route', '3', 'el-icon-setting', '3', '20', '1', '1', '2021-04-25 16:09:59', '1', '2021-05-11 15:38:04');
INSERT INTO `menu` VALUES ('24', '测试菜单11', 'route', '11', 'el-icon-setting', '0', '21', '1', '1', '2021-04-25 16:10:10', '1', '2021-05-11 15:37:58');
INSERT INTO `menu` VALUES ('25', '测试菜单12', 'route', '12', 'el-icon-setting', '1', '21', '1', '1', '2021-04-25 16:10:19', '1', '2021-05-11 15:38:01');

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `role_id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_name` varchar(50) COLLATE utf8mb4_bin NOT NULL COMMENT '角色名称',
  `role_desc` varchar(100) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '角色描述',
  `status` varchar(2) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '数据状态 从dict表中取',
  `create_user` int DEFAULT NULL COMMENT '创建人',
  `create_time` varchar(19) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '创建时间',
  `update_user` int DEFAULT NULL COMMENT '修改人',
  `update_time` varchar(19) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`role_id`),
  UNIQUE KEY `index_role` (`role_id`) USING BTREE,
  UNIQUE KEY `index_role_name` (`role_name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='角色表';

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('2', '超级管理员', '系统超级管理员，具有所有菜单权限', '1', '1', '2021-04-21 14:41:05', '1', '2021-04-21 14:43:23');
INSERT INTO `role` VALUES ('3', '普通用户', '系统普通用户，只有联系人管理模块权限', '1', '1', '2021-04-27 08:53:03', null, null);
INSERT INTO `role` VALUES ('4', '十一', '无法', '-1', '1', '2021-05-06 11:27:25', '1', '2021-05-06 11:27:46');
INSERT INTO `role` VALUES ('5', '用户管理员', '管理系统用户', '1', '1', '2021-05-10 14:47:07', null, null);
INSERT INTO `role` VALUES ('6', '角色管理员', '管理系统角色', '1', '1', '2021-05-10 14:47:19', null, null);
INSERT INTO `role` VALUES ('7', '菜单管理员', '管理系统菜单', '1', '1', '2021-05-10 14:47:31', null, null);
INSERT INTO `role` VALUES ('8', '接口文档管理员', '管理接口文档', '1', '1', '2021-05-14 08:45:44', null, null);

-- ----------------------------
-- Table structure for `role_menu_rel`
-- ----------------------------
DROP TABLE IF EXISTS `role_menu_rel`;
CREATE TABLE `role_menu_rel` (
  `role_id` int NOT NULL COMMENT '角色id',
  `menu_id` int NOT NULL COMMENT '菜单id',
  `status` varchar(2) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '数据状态 从dict表中取',
  `create_user` int DEFAULT NULL COMMENT '创建人',
  `create_time` varchar(19) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '创建时间',
  `update_user` int DEFAULT NULL COMMENT '修改人',
  `update_time` varchar(19) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '修改时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='角色菜单关联表';

-- ----------------------------
-- Records of role_menu_rel
-- ----------------------------
INSERT INTO `role_menu_rel` VALUES ('2', '1', '1', '1', '2021-05-11 15:47:49', null, null);
INSERT INTO `role_menu_rel` VALUES ('2', '2', '1', '1', '2021-05-11 15:47:49', null, null);
INSERT INTO `role_menu_rel` VALUES ('2', '3', '1', '1', '2021-05-11 15:47:49', null, null);
INSERT INTO `role_menu_rel` VALUES ('2', '4', '1', '1', '2021-05-11 15:47:49', null, null);
INSERT INTO `role_menu_rel` VALUES ('2', '5', '1', '1', '2021-05-11 15:47:49', null, null);
INSERT INTO `role_menu_rel` VALUES ('2', '6', '1', '1', '2021-05-11 15:47:49', null, null);
INSERT INTO `role_menu_rel` VALUES ('2', '7', '1', '1', '2021-05-11 15:47:49', null, null);
INSERT INTO `role_menu_rel` VALUES ('2', '9', '1', '1', '2021-05-11 15:47:49', null, null);
INSERT INTO `role_menu_rel` VALUES ('3', '1', '1', '1', '2021-05-11 15:48:03', null, null);
INSERT INTO `role_menu_rel` VALUES ('3', '2', '1', '1', '2021-05-11 15:48:03', null, null);
INSERT INTO `role_menu_rel` VALUES ('3', '3', '1', '1', '2021-05-11 15:48:03', null, null);
INSERT INTO `role_menu_rel` VALUES ('5', '4', '1', '1', '2021-05-11 15:48:07', null, null);
INSERT INTO `role_menu_rel` VALUES ('5', '5', '1', '1', '2021-05-11 15:48:07', null, null);
INSERT INTO `role_menu_rel` VALUES ('6', '4', '1', '1', '2021-05-11 15:48:14', null, null);
INSERT INTO `role_menu_rel` VALUES ('6', '6', '1', '1', '2021-05-11 15:48:14', null, null);
INSERT INTO `role_menu_rel` VALUES ('7', '4', '1', '1', '2021-05-11 15:48:20', null, null);
INSERT INTO `role_menu_rel` VALUES ('7', '7', '1', '1', '2021-05-11 15:48:20', null, null);
INSERT INTO `role_menu_rel` VALUES ('8', '4', '1', '1', '2021-05-14 08:46:03', null, null);
INSERT INTO `role_menu_rel` VALUES ('8', '9', '1', '1', '2021-05-14 08:46:03', null, null);

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '用户名',
  `password` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '密码',
  `nickname` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '昵称',
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'email',
  `remark` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
  `status` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '用户状态 从dict表获取',
  `last_login_ip` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '最后登录IP',
  `last_login_time` varchar(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '最后登录时间',
  `create_time` varchar(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '创建时间',
  `create_user` int DEFAULT NULL COMMENT '创建人',
  `update_time` varchar(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '修改时间',
  `update_user` int DEFAULT NULL COMMENT '修改人',
  `token` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '登录Token',
  UNIQUE KEY `index_user` (`user_id`),
  UNIQUE KEY `index_username` (`username`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='用户表';

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', '$2a$10$8nr4U2h4/LejVtYJDhaGz.lrP7kTM6WqsquM6/OYkJB9ZqeKATDL.', '超级管理员', 'aniikiki@163.com', '个人通讯录管理系统超级管理员', '1', '0:0:0:0:0:0:0:1', '2021-05-14 10:03:46', '2021-04-03 13:00:00', null, '2021-04-20 15:32:03', '1', '414c2682e3404efb9b81a79604045e21');
INSERT INTO `user` VALUES ('2', 'test', '$2a$10$9obBW.YohyIHlOfQ6nBf2usdGA4VOIK6DAHia.gGf3RDPTUReBhHC', '测试用户', 'test@aniikiki.com', '这是一个测试用户', '1', '0:0:0:0:0:0:0:1', '2021-05-14 09:51:53', '2021-04-20 15:35:13', '1', '2021-04-20 21:02:44', '1', '7dc310886935478c87746f496ad59955');

-- ----------------------------
-- Table structure for `user_role_rel`
-- ----------------------------
DROP TABLE IF EXISTS `user_role_rel`;
CREATE TABLE `user_role_rel` (
  `user_id` int NOT NULL COMMENT '用户id',
  `role_id` int NOT NULL COMMENT '角色id',
  `status` varchar(2) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '数据状态 从dict表中取',
  `create_user` int DEFAULT NULL COMMENT '创建人',
  `create_time` varchar(19) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '创建时间',
  `update_user` int DEFAULT NULL COMMENT '修改人',
  `update_time` varchar(19) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '修改时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='用户角色关联表';

-- ----------------------------
-- Records of user_role_rel
-- ----------------------------
INSERT INTO `user_role_rel` VALUES ('1', '2', '1', '1', '2021-05-11 15:46:39', null, null);
INSERT INTO `user_role_rel` VALUES ('2', '3', '1', '1', '2021-05-14 09:51:48', null, null);
