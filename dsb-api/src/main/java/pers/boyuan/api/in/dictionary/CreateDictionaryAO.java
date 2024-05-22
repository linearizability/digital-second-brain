package pers.boyuan.api.in.dictionary;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * 创建字典入参
 *
 * @author ZhangBoyuan
 * @since 2022-06-11
 */
@Data
@Schema(name = "创建字典入参")
public class CreateDictionaryAO {
    /**
     * 类型
     */
    @NotBlank(message = "字典类型不可为空")
    @Schema(name = "类型")
    private String type;

    /**
     * 编码
     */
    @NotBlank(message = "字典编码不可为空")
    @Schema(name = "编码")
    private String code;

    /**
     * 名称
     */
    @NotBlank(message = "字典名称不可为空")
    @Schema(name = "名称")
    private String name;

    /**
     * 备注
     */
    @Schema(name = "备注")
    private String remark;

}
