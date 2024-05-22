package pers.boyuan.api.in.bill;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;

/**
 * 导出账单入参
 *
 * @author ZhangBoyuan
 * @since 2022-06-25
 */
@Data
@Schema(name = "导出账单入参")
public class ExportBillAO {
    /**
     * 主键id
     */
    @NotNull(message = "主键id不可为空")
    @Schema(name = "主键id")
    private Long id;

    /**
     * 账单类型
     */
    @Schema(name = "账单类型")
    private Integer type;

    /**
     * 账单分类code, 详见字典表bill_category类型
     */
    @Schema(name = "账单分类code, 详见字典表bill_category类型")
    private String categoryCode;

    /**
     * 账单内容
     */
    @Schema(name = "账单内容")
    private String content;

    /**
     * 账单备注
     */
    @Schema(name = "账单备注")
    private String remark;

    /**
     * 账单金额: 单位(元)
     */
    @Schema(name = "账单金额: 单位(元)")
    private BigDecimal amount;

    /**
     * 最先付款时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Schema(name = "最先付款时间")
    private String beginPaymentTime;

    /**
     * 最后付款时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Schema(name = "最后付款时间")
    private String endPaymentTime;

}
