INSERT INTO `data_dictionary`(`type`, `code`, `name`, `remark`) VALUE ('BillCategory', '0', '餐饮', '账单分类');
INSERT INTO `data_dictionary`(`type`, `code`, `name`, `remark`) VALUE ('BillCategory', '1', '交通', '账单分类');
INSERT INTO `data_dictionary`(`type`, `code`, `name`, `remark`) VALUE ('BillCategory', '2', '书籍', '账单分类');
INSERT INTO `data_dictionary`(`type`, `code`, `name`, `remark`) VALUE ('BillCategory', '3', '礼金', '账单分类');
INSERT INTO `data_dictionary`(`type`, `code`, `name`, `remark`) VALUE ('BillCategory', '4', '住房', '账单分类');
INSERT INTO `data_dictionary`(`type`, `code`, `name`, `remark`) VALUE ('BillCategory', '5', '通讯', '账单分类');
INSERT INTO `data_dictionary`(`type`, `code`, `name`, `remark`) VALUE ('BillCategory', '6', '学习', '账单分类');
INSERT INTO `data_dictionary`(`type`, `code`, `name`, `remark`) VALUE ('BillCategory', '7', '购物', '账单分类');
INSERT INTO `data_dictionary`(`type`, `code`, `name`, `remark`) VALUE ('BillCategory', '8', '其他', '账单分类');

INSERT INTO `data_dictionary`(`type`, `code`, `name`, `remark`) VALUE ('BillDimension', 'day', '日统计维度', '账单统计维度');
INSERT INTO `data_dictionary`(`type`, `code`, `name`, `remark`) VALUE ('BillDimension', 'month', '月统计维度', '账单统计维度');
INSERT INTO `data_dictionary`(`type`, `code`, `name`, `remark`) VALUE ('BillDimension', 'year', '年统计维度', '账单统计维度');

INSERT INTO `data_dictionary`(`type`, `code`, `name`, `remark`) VALUE ('BillIndicator', 'sum', '消费金额总和', '账单统计指标');
INSERT INTO `data_dictionary`(`type`, `code`, `name`, `remark`) VALUE ('BillIndicator', 'min', '最小消费金额', '账单统计指标');
INSERT INTO `data_dictionary`(`type`, `code`, `name`, `remark`) VALUE ('BillIndicator', 'max', '最大消费金额', '账单统计指标');
INSERT INTO `data_dictionary`(`type`, `code`, `name`, `remark`) VALUE ('BillIndicator', 'avg', '平均消费金额', '账单统计指标');