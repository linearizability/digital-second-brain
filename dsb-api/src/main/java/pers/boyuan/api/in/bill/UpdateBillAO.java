package pers.boyuan.api.in.bill;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 修改账单入参
 *
 * @author ZhangBoyuan
 * @since 2022-06-25
 */
@Data
@Schema(name = "修改账单入参")
public class UpdateBillAO {
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
     * 付款时间
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @Schema(name = "付款时间")
    private LocalDateTime paymentTime;

}
