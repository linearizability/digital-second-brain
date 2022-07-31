package pers.boyuan.domain.bill.model;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;
import pers.boyuan.common.converter.LocalDateTimeStringConverter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 账单表导出excel业务对象
 *
 * @author ZhangBoyuan
 * @date 2022-07-18
 */
@Data
@ExcelIgnoreUnannotated
public class BillExportExcelBO {
    /**
     * 账单类型名称
     */
    @ExcelProperty("账单类型")
    private String typeName;

    /**
     * 账单分类名称
     */
    @ExcelProperty("账单分类")
    private String category;

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
     * 账单金额(元)
     */
    @ExcelProperty("账单金额(元)")
    private BigDecimal amount;

    /**
     * 付款时间
     */
    @ExcelProperty(value = "付款时间", converter = LocalDateTimeStringConverter.class)
    private LocalDateTime paymentTime;

}
