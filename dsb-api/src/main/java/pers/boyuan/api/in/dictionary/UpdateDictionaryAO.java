package pers.boyuan.api.in.dictionary;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


/**
 * 修改字典入参
 *
 * @author ZhangBoyuan
 * @since 2022-06-13
 */
@Data
@Schema(name = "修改字典入参")
public class UpdateDictionaryAO {
    /**
     * 主键自增id
     */
    @NotNull(message = "字典id不可为空")
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
