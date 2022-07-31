package pers.boyuan.api.out.dictionary;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 查询字典出参
 *
 * @author ZhangBoyuan
 * @date 2022-06-13
 */
@Data
@ApiModel("查询字典出参")
public class QueryDictionaryVO {
    /**
     * 主键自增id
     */
    @ApiModelProperty("主键自增id")
    private Integer id;

    /**
     * 类型
     */
    @ApiModelProperty("类型")
    private String type;

    /**
     * 编码
     */
    @ApiModelProperty("编码")
    private String code;

    /**
     * 名称
     */
    @ApiModelProperty("名称")
    private String name;

    /**
     * 备注
     */
    @ApiModelProperty("备注")
    private String remark;

}
