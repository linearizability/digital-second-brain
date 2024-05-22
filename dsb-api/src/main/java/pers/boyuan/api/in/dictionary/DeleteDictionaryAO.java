package pers.boyuan.api.in.dictionary;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 删除字典入参
 *
 * @author ZhangBoyuan
 * @since 2022-06-11
 */
@Data
@Schema(name = "删除字典入参")
public class DeleteDictionaryAO {
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

}
