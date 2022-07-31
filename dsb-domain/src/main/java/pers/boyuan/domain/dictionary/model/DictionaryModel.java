package pers.boyuan.domain.dictionary.model;

import lombok.Data;

import java.io.Serializable;

/**
 * 字典表领域层模型
 *
 * @author ZhangBoyuan
 * @date 2022-06-11
 */
@Data
public class DictionaryModel implements Serializable {
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 类型
     */
    private String type;

    /**
     * 编码
     */
    private String code;

    /**
     * 名称
     */
    private String name;

    /**
     * 备注
     */
    private String remark;

}
