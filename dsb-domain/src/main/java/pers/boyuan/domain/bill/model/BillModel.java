package pers.boyuan.domain.bill.model;

import lombok.var;
import pers.boyuan.common.constants.DictionaryTypeConstant;
import pers.boyuan.common.enums.BaseEnum;
import pers.boyuan.common.util.CreateBeanUtil;
import pers.boyuan.domain.bill.enums.BillEnum;
import pers.boyuan.domain.dictionary.service.DictionaryDomainService;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * 账单表领域层模型
 *
 * @author ZhangBoyuan
 * @date 2022-06-22
 */
public class BillModel {

    private DictionaryDomainService dictionaryDomainService = CreateBeanUtil.getBean(DictionaryDomainService.class);

    /**
     * 主键id
     */
    private Long id;

    /**
     * 账单类型: 1 -> 收入, -1 -> 支出
     */
    private Integer type;

    /**
     * 账单类型名称
     */
    private String typeName;

    /**
     * 账单分类code, 详见字典表bill_category类型
     */
    private String categoryCode;

    /**
     * 账单分类名称
     */
    private String category;

    /**
     * 账单内容
     */
    private String content;

    /**
     * 账单备注
     */
    private String remark;

    /**
     * 账单金额: 单位(元)
     */
    private BigDecimal amount;

    /**
     * 账单所属年份yyyy
     */
    private Integer year;

    /**
     * 账单所属月份: 1~12
     */
    private Integer month;

    /**
     * 账单所属日: 1~31
     */
    private Integer day;

    /**
     * 账单所属星期: 1~7
     */
    private Integer week;

    /**
     * 付款时间
     */
    private LocalDateTime paymentTime;

    /**
     * 最先付款时间
     */
    private String beginPaymentTime;

    /**
     * 最后付款时间
     */
    private String endPaymentTime;

    /**
     * 当前页
     */
    private Integer pageIndex;

    /**
     * 分页大小
     */
    private Integer pageSize;

    public BillModel() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getType() {
        return this.type;
    }

    public void setType(Integer type) {
        this.type = type;
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

    public String getCategoryCode() {
        return this.categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getCategory() {
        if (Objects.nonNull(this.categoryCode) && Objects.isNull(this.category)) {
            var queryResult = dictionaryDomainService
                    .queryByTypeAndCode(DictionaryTypeConstant.BILL_CATEGORY, this.categoryCode);

            if (Objects.nonNull(queryResult)) {
                return queryResult.getName();
            }
        }

        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;

        var queryResult = dictionaryDomainService
                .queryByTypeAndCode(DictionaryTypeConstant.BILL_CATEGORY, this.categoryCode);

        if (Objects.nonNull(queryResult)) {
            this.category = queryResult.getName();
        }
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public BigDecimal getAmount() {
        return this.amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Integer getYear() {
        return this.year;
    }

    public void setYear(Integer year) {
        if (Objects.nonNull(this.paymentTime)) {
            year = this.paymentTime.getYear();
        }
        this.year = year;
    }

    public Integer getMonth() {
        return this.month;
    }

    public void setMonth(Integer month) {
        if (Objects.nonNull(this.paymentTime)) {
            month = this.paymentTime.getMonth().getValue();
        }
        this.month = month;
    }

    public Integer getDay() {
        return this.day;
    }

    public void setDay(Integer day) {
        if (Objects.nonNull(this.paymentTime)) {
            day = this.paymentTime.getDayOfMonth();
        }
        this.day = day;
    }

    public Integer getWeek() {
        return this.week;
    }

    public void setWeek(Integer week) {
        if (Objects.nonNull(this.paymentTime)) {
            week = this.paymentTime.getDayOfWeek().getValue();
        }
        this.week = week;
    }

    public LocalDateTime getPaymentTime() {
        return this.paymentTime;
    }

    public void setPaymentTime(LocalDateTime paymentTime) {
        this.paymentTime = paymentTime;
        this.setYear(null);
        this.setMonth(null);
        this.setDay(null);
        this.setWeek(null);
    }

    public String getBeginPaymentTime() {
        return this.beginPaymentTime;
    }

    public void setBeginPaymentTime(String beginPaymentTime) {
        this.beginPaymentTime = beginPaymentTime;
    }

    public String getEndPaymentTime() {
        return this.endPaymentTime;
    }

    public void setEndPaymentTime(String endPaymentTime) {
        this.endPaymentTime = endPaymentTime;
    }

    public Integer getPageIndex() {
        return this.pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

}
