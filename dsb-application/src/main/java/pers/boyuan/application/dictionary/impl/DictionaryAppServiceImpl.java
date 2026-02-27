package pers.boyuan.application.dictionary.impl;

import lombok.var;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.boyuan.api.in.dictionary.CreateDictionaryAO;
import pers.boyuan.api.in.dictionary.DeleteDictionaryAO;
import pers.boyuan.api.in.dictionary.QueryDictionaryAO;
import pers.boyuan.api.in.dictionary.UpdateDictionaryAO;
import pers.boyuan.api.out.dictionary.QueryDictionaryVO;
import pers.boyuan.application.dictionary.DictionaryAppService;
import pers.boyuan.application.dictionary.converter.DictionaryDomainConverter;
import pers.boyuan.domain.dictionary.service.DictionaryDomainService;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 字典表应用服务实现类
 *
 * @author ZhangBoyuan
 * @date 2022-06-11
 */
@Service
public class DictionaryAppServiceImpl implements DictionaryAppService {

    @Autowired
    private DictionaryDomainService dictionaryDomainService;

    /**
     * 新增字典数据
     *
     * @param aoList 入参列表
     * @return 是否创建成功
     */
    @Override
    public Boolean create(List<CreateDictionaryAO> aoList) {
        if (CollectionUtils.isEmpty(aoList)) {
            return Boolean.FALSE;
        }

        var modelList = DictionaryDomainConverter.INSTANCE.createDictionaryToModelList(aoList);

        return dictionaryDomainService.create(modelList);
    }

    /**
     * 根据参数删除相关字典数据
     *
     * @param ao 入参
     * @return 是否创建成功
     */
    @Override
    public Boolean delete(DeleteDictionaryAO ao) {
        var model = DictionaryDomainConverter.INSTANCE.deleteDictionaryToModel(ao);

        return dictionaryDomainService.delete(model);
    }

    /**
     * 根据参数更新字典数据
     *
     * @param ao 入参
     * @return 是否创建成功
     */
    @Override
    public Boolean update(UpdateDictionaryAO ao) {
        var model = DictionaryDomainConverter.INSTANCE.updateDictionaryToModel(ao);

        return dictionaryDomainService.update(model);
    }

    /**
     * 查询字典表数据
     *
     * @param ao 查询字典参数
     * @return 应用层转换后数据
     */
    @Override
    public Map<String, List<QueryDictionaryVO>> query(QueryDictionaryAO ao) {
        var param = DictionaryDomainConverter.INSTANCE.queryDictionaryToModel(ao);
        var queryResult = dictionaryDomainService.query(param);

        if (MapUtils.isEmpty(queryResult)) {
            return Collections.emptyMap();
        }

        Map<String, List<QueryDictionaryVO>> result = new HashMap(queryResult.keySet().size());
        queryResult.keySet().forEach(
                item -> result.put(item, DictionaryDomainConverter.INSTANCE.modelToQueryDictionary(queryResult.get(item)))
        );

        return result;
    }

}
