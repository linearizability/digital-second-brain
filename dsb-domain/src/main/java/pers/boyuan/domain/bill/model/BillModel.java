package pers.boyuan.domain.bill.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import pers.boyuan.common.enums.BaseEnum;
import pers.boyuan.common.util.CreateBeanUtil;
import pers.boyuan.domain.bill.enums.BillEnum;
import pers.boyuan.domain.dictionary.service.DictionaryCache;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

import static pers.boyuan.common.constants.DictionaryTypeConstant.BILL_CATEGORY;

/**
 * 账单表领域层模型
 *
 * @author ZhangBoyuan
 * @since 2022-06-22
 */
@Data
public class BillModel {

    private DictionaryCache dictionaryCache = CreateBeanUtil.getBean(DictionaryCache.class);

    /**
     * 主键id
     */
    @Setter
    @Getter
    private Long id;

    /**
     * 账单类型: 1 -> 收入, -1 -> 支出
     */
    @Setter
    @Getter
    private Integer type;

    /**
     * 账单类型名称
     */
    private String typeName;

    /**
     * 账单分类code, 详见字典表bill_category类型
     */
    @Setter
    @Getter
    private String categoryCode;

    /**
     * 账单分类名称
     */
    private String category;

    /**
     * 账单内容
     */
    @Setter
    @Getter
    private String content;

    /**
     * 账单备注
     */
    @Setter
    @Getter
    private String remark;

    /**
     * 账单金额: 单位(元)
     */
    @Setter
    @Getter
    private BigDecimal amount;

    /**
     * 账单所属年份yyyy
     */
    @Getter
    private Integer year;

    /**
     * 账单所属月份: 1~12
     */
    @Getter
    private Integer month;

    /**
     * 账单所属日: 1~31
     */
    @Getter
    private Integer day;

    /**
     * 账单所属星期: 1~7
     */
    @Getter
    private Integer week;

    /**
     * 付款时间
     */
    @Getter
    private LocalDateTime paymentTime;

    /**
     * 最先付款时间
     */
    @Setter
    @Getter
    private String beginPaymentTime;

    /**
     * 最后付款时间
     */
    @Setter
    @Getter
    private String endPaymentTime;

    /**
     * 当前页
     */
    @Setter
    @Getter
    private Integer pageIndex;

    /**
     * 分页大小
     */
    @Setter
    @Getter
    private Integer pageSize;

    public BillModel() {
    }

    public String getTypeName() {
        if (Objects.nonNull(this.type) && Objects.isNull(this.typeName)) {
            return BaseEnum.findByValue(BillEnum.BillTypeEnum.class, this.type).get().getText();
        }

        return this.typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;

        if (Objects.nonNull(this.type)) {
            this.typeName = BaseEnum.findByValue(BillEnum.BillTypeEnum.class, this.type).get().getText();
        }
    }

    public String getCategory() {
        if (Objects.nonNull(this.categoryCode) && Objects.isNull(this.category)) {
            var result = dictionaryCache
                    .getDictionaryName(BILL_CATEGORY, this.categoryCode);

            if (Objects.nonNull(result)) {
                return result;
            }
        }

        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;

        var result = dictionaryCache
                .getDictionaryName(BILL_CATEGORY, this.categoryCode);

        if (Objects.nonNull(result)) {
            this.category = result;
        }
    }

    public void setYear(Integer year) {
        if (Objects.nonNull(this.paymentTime)) {
            year = this.paymentTime.getYear();
        }
        this.year = year;
    }

    public void setMonth(Integer month) {
        if (Objects.nonNull(this.paymentTime)) {
            month = this.paymentTime.getMonth().getValue();
        }
        this.month = month;
    }

    public void setDay(Integer day) {
        if (Objects.nonNull(this.paymentTime)) {
            day = this.paymentTime.getDayOfMonth();
        }
        this.day = day;
    }

    public void setWeek(Integer week) {
        if (Objects.nonNull(this.paymentTime)) {
            week = this.paymentTime.getDayOfWeek().getValue();
        }
        this.week = week;
    }

    public void setPaymentTime(LocalDateTime paymentTime) {
        this.paymentTime = paymentTime;
        this.setYear(null);
        this.setMonth(null);
        this.setDay(null);
        this.setWeek(null);
    }

}
