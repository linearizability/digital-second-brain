package pers.boyuan.api.in.bill;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 创建账单入参
 *
 * @author ZhangBoyuan
 * @date 2022-06-25
 */
@Data
@ApiModel("创建账单入参")
public class CreateBillAO {
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
     * 付款时间
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("付款时间")
    private LocalDateTime paymentTime;

}
