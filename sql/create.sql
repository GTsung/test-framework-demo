-- 表结构

-- 申请表
DROP TABLE IF EXISTS `apply`;
CREATE TABLE `apply`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `apply_code`     varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '申请编号，业务主键',
    `approval_code`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci          DEFAULT NULL COMMENT '审批编号',
    `stage`          int(11) DEFAULT NULL COMMENT '当前状态',
    `applicant`      varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci          DEFAULT NULL COMMENT '申请人',
    `id_card_number` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci          DEFAULT NULL COMMENT '身份证号',
    `phone_number`   varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci          DEFAULT NULL COMMENT '申请人电话',
    `company_name`   varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci         DEFAULT NULL COMMENT '企业名称',
    `amount`         decimal(20, 2)                                                  DEFAULT NULL COMMENT '申请额度',
    `reason`         varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci          DEFAULT NULL COMMENT '贷款原因',
    `apply_date`     timestamp(3) NULL DEFAULT NULL COMMENT '申请时间',
    `status`         varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci          DEFAULT NULL COMMENT '审批状态：处理中/通过/未通过',
    `period`         int(11) DEFAULT NULL COMMENT '分期期数',
    `rate`           decimal(20, 2)                                                  DEFAULT NULL COMMENT '利率',
    `del_flag`       tinyint(1) NOT NULL DEFAULT '1' COMMENT '删除标记：0->未删除， 1->已删除',
    `create_time`    datetime                                               NOT NULL COMMENT '创建时间',
    `create_user`    varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '创建人',
    `update_time`    datetime                                                        DEFAULT NULL COMMENT '更新时间',
    `update_user`    varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '更新用户',
    `remark`         varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci         DEFAULT '' COMMENT '备注',
    PRIMARY KEY (`id`) USING BTREE,
    KEY              `idx_apply_code` (`apply_code`) USING BTREE,
    KEY              `idx_approval_code` (`approval_code`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3668 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='申请表';


-- 审批表
DROP TABLE IF EXISTS `approval`;
CREATE TABLE `approval`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `approval_code`  varchar(32)                                                     DEFAULT NULL COMMENT '审批编号',
    `applicant`      varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci          DEFAULT NULL COMMENT '申请人',
    `credit_line`    decimal(20, 2)                                                  DEFAULT NULL COMMENT '申请额度',
    `reason`         varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci          DEFAULT NULL COMMENT '贷款原因',
    `apply_date`     timestamp(3) NULL DEFAULT NULL COMMENT '申请时间',
    `status`         varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci          DEFAULT NULL COMMENT '审批状态：处理中/通过/未通过',
    `period`         int(11) DEFAULT NULL COMMENT '分期期数',
    `rate`           decimal(20, 2)                                                  DEFAULT NULL COMMENT '利率',
    `repay_way`      varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci          DEFAULT NULL COMMENT '还款方式',
    `application_id` bigint(20) DEFAULT NULL COMMENT '申请单id',
    `apply_code`     varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '0' COMMENT '申请单编号',
    `del_flag`       tinyint(1) NOT NULL DEFAULT '1' COMMENT '删除标记：0->未删除， 1->已删除',
    `remark`         varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci        DEFAULT NULL COMMENT '备注',
    `create_user`    varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci          DEFAULT NULL COMMENT '创建人',
    `update_user`    varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci          DEFAULT NULL COMMENT '更新人',
    `create_time`    datetime                                                        DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime                                                        DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `uk_apply_id` (`approval_code`) USING BTREE,
    KEY              `idx_approval_apply_code` (`apply_code`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3247 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='审批信息';

