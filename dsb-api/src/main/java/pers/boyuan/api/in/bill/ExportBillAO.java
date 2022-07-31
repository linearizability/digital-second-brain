package pers.boyuan.api.in.bill;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * 导出账单入参
 *
 * @author ZhangBoyuan
 * @date 2022-06-25
 */
@Data
@ApiModel("导出账单入参")
public class ExportBillAO {
    /**
     * 主键id
     */
    @NotNull(message = "主键id不可为空")
    @ApiModelProperty("主键id")
    private Long id;

    /**
     * 账单类型
     */
    @ApiModelProperty("账单类型")
    private Integer type;

    /**
     * 账单分类code, 详见字典表bill_category类型
     */
    @ApiModelProperty("账单分类code, 详见字典表bill_category类型")
    private String categoryCode;

    /**
     * 账单内容
     */
    @ApiModelProperty("账单内容")
    private String content;

    /**
     * 账单备注
     */
    @ApiModelProperty("账单备注")
    private String remark;

    /**
     * 账单金额: 单位(元)
     */
    @ApiModelProperty("账单金额: 单位(元)")
    private BigDecimal amount;

    /**
     * 最先付款时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty("最先付款时间")
    private String beginPaymentTime;

    /**
     * 最后付款时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty("最后付款时间")
    private String endPaymentTime;

}
