package pers.boyuan.api.in.dictionary;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 查询字典数据入参
 *
 * @author ZhangBoyuan
 * @date 2022-07-31
 */
@Data
@ApiModel("查询字典数据入参")
public class QueryDictionaryAO {

    /**
     * 字典表主键id
     */
    @ApiModelProperty("字典表主键id")
    private Integer id;

    /**
     * 字典表类型
     */
    @ApiModelProperty("字典表类型")
    private String type;

    /**
     * 字典表编码
     */
    @ApiModelProperty("字典表编码")
    private String code;

    /**
     * 字典表名称
     */
    @ApiModelProperty("字典表名称")
    private String name;

}
