package pers.boyuan.domain.bill.model;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 账单表导入excel业务对象
 *
 * @author ZhangBoyuan
 * @date 2022-07-18
 */
@Data
@ExcelIgnoreUnannotated
public class BillImportExcelBO {

    /**
     * 账单类型: 1 -> 收入, -1 -> 支出
     */
    @ExcelProperty(value = "账单类型")
    private Integer type;

    /**
     * 账单分类id, 关联data_dictionary表
     */
    @ExcelProperty("账单分类")
    private Integer categoryId;

    /**
     * 账单内容
     */
    @ExcelProperty("账单内容")
    private String content;

    /**
     * 账单备注
     */
    @ExcelProperty("账单备注")
    private String remark;

    /**
     * 账单金额: 单位(元)
     */
    @ExcelProperty("账单金额: 单位(元)")
    private BigDecimal amount;

    /**
     * 账单所属年份yyyy
     */
    @ExcelProperty("账单所属年份")
    private Integer year;

    /**
     * 账单所属月份: 1~12
     */
    @ExcelProperty("账单所属月份")
    private Integer month;

    /**
     * 账单所属日: 1~31
     */
    @ExcelProperty("账单所属日")
    private Integer day;

    /**
     * 账单所属星期: 1~7
     */
    @ExcelProperty("账单所属星期")
    private Integer week;

    /**
     * 付款时间
     */
    @ExcelProperty("付款时间")
    private LocalDateTime paymentTime;

}
