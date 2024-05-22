package pers.boyuan.api.out.bill;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 查询账单出参
 *
 * @author ZhangBoyuan
 * @since 2022-06-25
 */
@Data
@Schema(name = "查询账单出参")
public class QueryBillVO {
    /**
     * 主键id
     */
    @Schema(name = "主键id")
    private Long id;

    /**
     * 账单类型
     */
    @Schema(name = "账单类型")
    private String type;

    /**
     * 账单类型名称
     */
    @Schema(name = "账单类型名称")
    private String typeName;

    /**
     * 账单分类code, 详见字典表bill_category类型
     */
    @Schema(name = "账单分类code, 详见字典表bill_category类型")
    private String categoryCode;

    /**
     * 账单分类
     */
    @Schema(name = "账单分类")
    private String category;

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
     * 付款时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @Schema(name = "付款时间")
    private LocalDateTime paymentTime;

}
