package pers.boyuan.infrastructure.db.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 消费账单表实体类
 *
 * @author ZhangBoyuan
 * @date 2022-06-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("biz_bill")
public class Bill implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 账单类型：1 -> 收入, -1 -> 支出
     */
    private Integer type;

    /**
     * 账单分类code, 详见字典表bill_category类型
     */
    private String categoryCode;

    /**
     * 账单内容
     */
    private String content;

    /**
     * 账单备注
     */
    private String remark;

    /**
     * 账单金额(元)
     */
    private BigDecimal amount;

    /**
     * 账单所属年份：yyyy
     */
    private Integer year;

    /**
     * 账单所属月份：1~12
     */
    private Integer month;

    /**
     * 账单所属日：1~31
     */
    private Integer day;

    /**
     * 账单所属星期：1~7
     */
    private Integer week;

    /**
     * 付款时间
     */
    private LocalDateTime paymentTime;

    /**
     * 创建时间
     */
    private LocalDateTime gmtCreate;

    /**
     * 更新时间
     */
    private LocalDateTime gmtUpdate;

}
