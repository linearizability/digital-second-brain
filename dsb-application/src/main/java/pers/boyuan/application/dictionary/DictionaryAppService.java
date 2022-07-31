package pers.boyuan.application.dictionary;

import pers.boyuan.api.in.dictionary.CreateDictionaryAO;
import pers.boyuan.api.in.dictionary.DeleteDictionaryAO;
import pers.boyuan.api.in.dictionary.QueryDictionaryAO;
import pers.boyuan.api.in.dictionary.UpdateDictionaryAO;
import pers.boyuan.api.out.dictionary.QueryDictionaryVO;

import java.util.List;
import java.util.Map;

/**
 * 字典表应用服务
 *
 * @author ZhangBoyuan
 * @date 2022-06-11
 */
public interface DictionaryAppService {

    /**
     * 新增字典数据
     *
     * @param aoList 入参列表
     * @return 是否创建成功
     */
    Boolean create(List<CreateDictionaryAO> aoList);

    /**
     * 根据参数删除相关字典数据
     *
     * @param ao 入参
     * @return 是否创建成功
     */
    Boolean delete(DeleteDictionaryAO ao);

    /**
     * 根据参数更新字典数据
     *
     * @param ao 入参
     * @return 是否创建成功
     */
    Boolean update(UpdateDictionaryAO ao);

    /**
     * 查询字典表数据
     *
     * @param ao 查询字典参数
     * @return 应用层转换后数据
     */
    Map<String, List<QueryDictionaryVO>> query(QueryDictionaryAO ao);

}
