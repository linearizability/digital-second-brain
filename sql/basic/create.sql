-- 新建数据库
CREATE
DATABASE `digital_second_brain` CHARSET = 'utf8';

-- 创建字典表
DROP TABLE IF EXISTS `data_dictionary`;
CREATE TABLE `data_dictionary`
(
    `id`     INT(11) PRIMARY KEY AUTO_INCREMENT COMMENT '自增主键id',
    `type`   VARCHAR(255) NOT NULL COMMENT '类型',
    `code`   VARCHAR(255) NOT NULL COMMENT '编码',
    `name`   VARCHAR(255) NOT NULL COMMENT '名称',
    `remark` VARCHAR(255) COMMENT '备注'
) COMMENT '数据_字典表';

-- 创建账单表
DROP TABLE IF EXISTS `biz_bill`;
CREATE TABLE `biz_bill`
(
    `id`            BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '主键id',
    `type`          TINYINT NOT NULL COMMENT '账单类型: 1->收入, -1->支出',
    `category_code` VARCHAR(255) COMMENT '账单分类code, 详见字典表BillCategory类型',
    `content`       VARCHAR(255) COMMENT '账单内容',
    `remark`        TEXT COMMENT '账单备注',
    `amount`        DECIMAL(10, 2) COMMENT '账单金额: 单位(元)',
    `year`          INT(4) COMMENT '账单所属年份：yyyy',
    `month`         INT(2) COMMENT '账单所属月份：1~12',
    `day`           INT(2) COMMENT '账单所属日：1~31',
    `week`          INT(1) COMMENT '账单所属星期：1~7',
    `payment_time`  DATETIME COMMENT '付款时间',
    `gmt_create`    DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `gmt_update`    DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
) COMMENT '业务_消费账单表';

-- 创建消费账单统计表
DROP TABLE IF EXISTS `data_bill_statistics`;
CREATE TABLE `data_bill_statistics`
(
    `id`               BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '自增主键id',
    `dimension_code`   VARCHAR(10)    NOT NULL COMMENT '统计维度，详见字典表BillDimensionCode类型',
    `indicator_code`   VARCHAR(10)    NOT NULL COMMENT '统计指标，详见字典表BillIndicatorCode类型',
    `bill_id`          BIGINT COMMENT '消费账单表主键id',
    `statistics_value` DECIMAL(20, 2) NOT NULL COMMENT '统计指标值',
    `year`             INT(4) NOT NULL COMMENT '当前数据所统计年份：yyyy',
    `month`            INT(2) NOT NULL COMMENT '当前数据所统计月份：1~12',
    `day`              INT(2) NOT NULL COMMENT '当前数据所统计日：1~31',
    `gmt_create`       DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `gmt_update`       DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
) COMMENT '数据_消费账单统计表';