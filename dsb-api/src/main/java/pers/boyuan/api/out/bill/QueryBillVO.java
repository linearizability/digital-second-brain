package pers.boyuan.api.out.bill;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 查询账单出参
 *
 * @author ZhangBoyuan
 * @date 2022-06-25
 */
@Data
@ApiModel("查询账单出参")
public class QueryBillVO {
    /**
     * 主键id
     */
    @ApiModelProperty("主键id")
    private Long id;

    /**
     * 账单类型
     */
    @ApiModelProperty("账单类型")
    private String type;

    /**
     * 账单类型名称
     */
    @ApiModelProperty("账单类型名称")
    private String typeName;

    /**
     * 账单分类code, 详见字典表bill_category类型
     */
    @ApiModelProperty("账单分类code, 详见字典表bill_category类型")
    private String categoryCode;

    /**
     * 账单分类
     */
    @ApiModelProperty("账单分类")
    private String category;

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
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @ApiModelProperty("付款时间")
    private LocalDateTime paymentTime;

}
