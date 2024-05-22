package pers.boyuan.api.out.dictionary;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 查询字典出参
 *
 * @author ZhangBoyuan
 * @since 2022-06-13
 */
@Data
@Schema(name = "查询字典出参")
public class QueryDictionaryVO {
    /**
     * 主键自增id
     */
    @Schema(name = "主键自增id")
    private Integer id;

    /**
     * 类型
     */
    @Schema(name = "类型")
    private String type;

    /**
     * 编码
     */
    @Schema(name = "编码")
    private String code;

    /**
     * 名称
     */
    @Schema(name = "名称")
    private String name;

    /**
     * 备注
     */
    @Schema(name = "备注")
    private String remark;

}
