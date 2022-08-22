package pers.boyuan.domain.dictionary.service;

import pers.boyuan.domain.dictionary.model.DictionaryModel;

import java.util.List;
import java.util.Map;

/**
 * 字典表领域层服务
 *
 * @author ZhangBoyuan
 * @date 2022-06-11
 */
public interface DictionaryDomainService {

    /**
     * 创建字典
     *
     * @param modelList 字典模型列表
     * @return 是否创建成功
     */
    Boolean create(List<DictionaryModel> modelList);

    /**
     * 根据参数删除字典
     *
     * @param model 删除参数
     * @return 是否删除成功
     */
    Boolean delete(DictionaryModel model);

    /**
     * 根据参数更新字典数据
     *
     * @param model 入参
     * @return 是否创建成功
     */
    Boolean update(DictionaryModel model);

    /**
     * 获取字典表所有数据
     *
     * @return 字典表所有数据
     */
    List<DictionaryModel> getAll();

    /**
     * 根据参数查询字典数据
     *
     * @param model 字典表查询参数
     * @return 领域层处理后数据
     */
    Map<String, List<DictionaryModel>> query(DictionaryModel model);

}
