package pers.boyuan.api.in.dictionary;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 查询字典数据入参
 *
 * @author ZhangBoyuan
 * @since 2022-07-31
 */
@Data
@Schema(name = "查询字典数据入参")
public class QueryDictionaryAO {

    /**
     * 字典表主键id
     */
    @Schema(name = "字典表主键id")
    private Integer id;

    /**
     * 字典表类型
     */
    @Schema(name = "字典表类型")
    private String type;

    /**
     * 字典表编码
     */
    @Schema(name = "字典表编码")
    private String code;

    /**
     * 字典表名称
     */
    @Schema(name = "字典表名称")
    private String name;

}
