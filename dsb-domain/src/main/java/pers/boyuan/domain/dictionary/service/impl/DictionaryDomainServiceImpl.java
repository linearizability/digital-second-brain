package pers.boyuan.domain.dictionary.service.impl;

import lombok.var;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.boyuan.common.util.ObjectFieldUtil;
import pers.boyuan.domain.dictionary.model.DictionaryModel;
import pers.boyuan.domain.dictionary.repository.DictionaryRepository;
import pers.boyuan.domain.dictionary.service.DictionaryDomainService;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 字典表领域层服务实现类
 *
 * @author ZhangBoyuan
 * @date 2022-06-11
 */
@Service
public class DictionaryDomainServiceImpl implements DictionaryDomainService {

    @Autowired
    private DictionaryRepository dictionaryRepository;

    /**
     * 创建字典
     *
     * @param modelList 字典模型列表
     * @return 是否创建成功
     */
    @Override
    public Boolean create(List<DictionaryModel> modelList) {
        if (CollectionUtils.isEmpty(modelList)) {
            return Boolean.FALSE;
        }

        return dictionaryRepository.create(modelList);
    }

    /**
     * 根据参数删除字典
     *
     * @param model 删除参数
     * @return 是否删除成功
     */
    @Override
    public Boolean delete(DictionaryModel model) {
        // 添加判断字段属性是否全部为null或空字符串，避免删除全表
        if (ObjectFieldUtil.allBlank(model)) {
            return Boolean.FALSE;
        }

        return dictionaryRepository.delete(model);
    }

    /**
     * 根据参数更新字典数据
     *
     * @param model 入参
     * @return 是否更新成功
     */
    @Override
    public Boolean update(DictionaryModel model) {
        if (ObjectFieldUtil.allBlank(model)) {
            return Boolean.FALSE;
        }

        if (StringUtils.isBlank(model.getType())
                && StringUtils.isBlank(model.getCode())
                && StringUtils.isBlank(model.getName())
                && StringUtils.isBlank(model.getRemark())) {
            return Boolean.FALSE;
        }

        return dictionaryRepository.update(model);
    }

    /**
     * 获取字典表所有数据
     *
     * @return 字典表所有数据
     */
    @Override
    public List<DictionaryModel> getAll() {
        return dictionaryRepository.getAll();
    }

    /**
     * 根据参数查询字典数据
     *
     * @param model 字典表查询参数
     * @return 领域层处理后数据
     */
    @Override
    public Map<String, List<DictionaryModel>> query(DictionaryModel model) {
        var queryResult = dictionaryRepository.query(model);

        if (CollectionUtils.isEmpty(queryResult)) {
            return Collections.emptyMap();
        }

        var result = queryResult.stream()
                .collect(Collectors.groupingBy(DictionaryModel::getType));

        return result;
    }

}
