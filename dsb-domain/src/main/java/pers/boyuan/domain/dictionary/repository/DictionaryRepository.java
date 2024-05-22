package pers.boyuan.domain.dictionary.repository;

import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;
import pers.boyuan.domain.dictionary.model.DictionaryModel;

import java.util.List;

/**
 * 字典表底层数据库接口
 *
 * @author ZhangBoyuan
 * @since 2022-06-11
 */
@Validated
public interface DictionaryRepository {

    /**
     * 创建字典
     *
     * @param modelList 字典列表
     * @return 是否创建成功
     */
    Boolean create(List<DictionaryModel> modelList);

    /**
     * 根据参数删除字典
     *
     * @param model 删除参数
     * @return 是否删除成功
     */
    Boolean delete(@NotNull(message = "删除字典入参不可为空") DictionaryModel model);

    /**
     * 根据参数更新字典数据
     *
     * @param model 入参
     * @return 是否创建成功
     */
    Boolean update(DictionaryModel model);

    /**
     * 根据参数查询字典数据
     *
     * @param model
     * @return 数据库查询结果模型
     */
    List<DictionaryModel> query(DictionaryModel model);

    /**
     * 获取字典表所有数据
     *
     * @return 字典表所有数据
     */
    List<DictionaryModel> getAll();

}
