/*
 Navicat Premium Data Transfer

 Source Server         : guoshun
 Source Server Type    : MySQL
 Source Server Version : 80017
 Source Host           : localhost:3306
 Source Schema         : first_blog

 Target Server Type    : MySQL
 Target Server Version : 80017
 File Encoding         : 65001

 Date: 21/10/2020 10:24:31
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article`  (
  `article_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '文章ID',
  `article_user_id` int(11) NULL DEFAULT NULL COMMENT '用户的ID',
  `article_title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '文章名称',
  `article_content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '文章内容',
  `article_view` int(11) NULL DEFAULT 0 COMMENT '观看人数',
  `article_comment` int(11) NULL DEFAULT 0 COMMENT '评论数',
  `article_status` int(11) NULL DEFAULT 0 COMMENT '状态 为0表示已发布，1为未发布',
  `article_collect` int(11) NULL DEFAULT 0 COMMENT '被收藏数',
  `article_update_time` datetime(0) NULL DEFAULT NULL,
  `article_create` datetime(0) NULL DEFAULT NULL COMMENT '创建的时间',
  PRIMARY KEY (`article_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of article
-- ----------------------------

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu`  (
  `menu_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
  `parent_id` int(11) NULL DEFAULT 0 COMMENT '上级菜单id',
  `menu_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '菜单名称',
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '菜单跳转地址',
  `icon` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '图标样式',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`menu_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES (1, 0, '个人中心', '', 'el-icon-user-solid', '2020-10-20 16:14:46');
INSERT INTO `menu` VALUES (2, 1, '我的主页', NULL, '', '2020-10-20 16:14:49');
INSERT INTO `menu` VALUES (3, 0, '我的关注', NULL, 'el-icon-star-off', '2020-10-20 16:14:51');
INSERT INTO `menu` VALUES (4, 3, '我的关注', NULL, '', '2020-10-20 16:14:53');
INSERT INTO `menu` VALUES (5, 3, '我的收藏', NULL, NULL, '2020-10-20 16:14:55');
INSERT INTO `menu` VALUES (6, 3, '我的粉丝', NULL, NULL, '2020-10-20 16:14:56');
INSERT INTO `menu` VALUES (7, 0, '我的博客', NULL, 'el-icon-edit', '2020-10-20 16:14:58');
INSERT INTO `menu` VALUES (8, 7, '我的博客', NULL, NULL, '2020-10-20 16:15:00');
INSERT INTO `menu` VALUES (9, 7, '管理博客', NULL, NULL, '2020-10-20 16:15:01');
INSERT INTO `menu` VALUES (10, 7, '添加博客', NULL, '', '2020-10-20 16:15:04');
INSERT INTO `menu` VALUES (11, 0, '我的标签', '', 'el-icon-price-tag', '2020-10-20 16:15:05');
INSERT INTO `menu` VALUES (12, 11, '我的标签', NULL, NULL, '2020-10-20 16:15:07');
INSERT INTO `menu` VALUES (14, 11, '添加标签', NULL, NULL, '2020-10-20 16:15:09');
INSERT INTO `menu` VALUES (15, 0, '账号设置', NULL, 'el-icon-s-tools', '2020-10-20 16:15:22');
INSERT INTO `menu` VALUES (16, 15, '账号首页', '/admin/user/', NULL, '2020-10-20 16:17:09');
INSERT INTO `menu` VALUES (17, 15, '修改密码', '/admin/user/editPass', NULL, '2020-10-20 16:17:11');
INSERT INTO `menu` VALUES (18, 15, '修改邮箱', '/admin/user/editEmail', NULL, '2020-10-20 16:17:12');
INSERT INTO `menu` VALUES (19, 15, '登录日志', NULL, NULL, '2020-10-20 16:17:11');
INSERT INTO `menu` VALUES (20, 15, '账号注销', NULL, NULL, '2020-10-20 16:17:13');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` int(11) NULL DEFAULT NULL COMMENT '权限Id',
  `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '权限\n',
  `nameZh` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '权限名称'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, 'ROLE_admin', '用户管理员');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户名',
  `user_pass` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '密码',
  `user_nickname` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户名称',
  `user_email` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '邮箱',
  `user_avatar` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '头像',
  `user_status` int(11) NULL DEFAULT NULL COMMENT '状态 等于0为正常1为有风险',
  `user_follow_id` int(11) NULL DEFAULT NULL COMMENT '为关注的id 和用户id进行匹配',
  `user_collect_id` int(11) NULL DEFAULT NULL COMMENT '为收藏id匹配，和文章id进行匹配',
  `user_register_time` datetime(0) NULL DEFAULT NULL,
  `user_last_login_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 40 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'zhaoguoshun', '985211', '赵国顺', 'guoshunsir@qq.com', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (10, ' gf ', '  f gf', '123', 'cds@qq.com', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (11, 'vgrvg', 'fv ', '985211', 'vf@qq.com', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (12, 'zhaoguoshun', 'zhaoguoshun', '985211', 'fcre@qq.com', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (14, 'zhaoguoshun', 'cnsdj', '1234', 'cdbk@qq.com', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (16, 'zhaoguoshun', 'xdsbhk', '985211', 'cds@qq.com', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (17, 'zhaoguoshuns', 'xdsbhk', '985211', 'cds@qq.com', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (18, 'zhaoguoshun', 'bhbhj', '1234', 'vfdnl@qq.com', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (19, 'zhaoguoshun', 'xsdnajk', '1234', 'dscfd@qq.com', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (20, 'zhaoguoshunsx', 'xsanl', '111', 'xdsjk@qq.com', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (21, 'zhaoguoshunsxs', '我是赵国顺的小号', 'zhaoguoshun666', 'guoshunsir@qq.com', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (22, 'zhaoguoshunaaa', '下好', '111', 'cdksb@qq.com', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (23, 'zhaoguoshunaaa', '下好', '111', 'cdksb@qq.com', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (24, '赵国顺', '国顺', '123456', 'guoshunsir@qq.com', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (25, '赵国顺', '国顺', '123456', 'guoshunsir@qq.com', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (26, 'cdscds', 'cdscsd', '123', 'cdso@qq.com', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (27, '赵国顺2', '赵国顺', '123456', 'cdsdcs@qq.com', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (28, '赵国顺2', '赵国顺', '123456', 'cdsdcs@qq.com', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (29, '赵国顺2', '123456', '123456', 'cdscsd@qq.com', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (30, 'zhaoguoshunsscc', '11', 'cdsnjkd', 'cdsdcc@qq.com', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (31, 'zhaoguoshunsscc', '11', 'cdsnjkd', 'cdsdcc@qq.com', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (32, 'aaa', '123456', 'aaaa', 'cdd@qq.com', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (33, 'zzzzz', '123', 'zzzz', 'cdcds@qq.com', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (35, 'zhaoguoshundddd', '123', 'cdssd', 'cds@qq.com', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (36, 'cdsf', '111', 'cds', 'cdssd@qq.com', NULL, NULL, NULL, NULL, '2020-10-20 07:54:36', NULL);
INSERT INTO `user` VALUES (37, 'cdsnjkcsdc', '123', '1cdsdcscd', 'cdcsd@qq.com', NULL, NULL, NULL, NULL, '2020-10-20 16:01:19', NULL);
INSERT INTO `user` VALUES (38, 'zhaoguoshunvd', '11', 'jfsioosd', 'cnakdsjn@qq.com', NULL, NULL, NULL, NULL, '2020-10-20 23:35:20', NULL);
INSERT INTO `user` VALUES (39, 'zhaoguoshunvda', '11', 'jfsioosd', 'cnakdsjn@qq.com', NULL, NULL, NULL, NULL, '2020-10-20 23:38:41', NULL);

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `id` int(11) NULL DEFAULT NULL,
  `uid` int(11) NULL DEFAULT NULL,
  `rid` int(11) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES (1, 1, 1);

SET FOREIGN_KEY_CHECKS = 1;
