package pers.boyuan.infrastructure.repository.dictionary;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.var;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import pers.boyuan.domain.dictionary.model.DictionaryModel;
import pers.boyuan.domain.dictionary.repository.DictionaryRepository;
import pers.boyuan.infrastructure.converter.dictionary.DictionaryEntityConverter;
import pers.boyuan.infrastructure.db.entity.Dictionary;
import pers.boyuan.infrastructure.db.mapper.DictionaryMapper;
import pers.boyuan.infrastructure.db.service.IDictionaryService;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * 字典表底层数据库接口 Mybatis 实现类
 *
 * @author ZhangBoyuan
 * @date 2022-06-11
 */
@Component
public class DictionaryMybatisRepository implements DictionaryRepository {

    @Autowired
    private IDictionaryService dictionaryService;

    @Autowired
    private DictionaryMapper dictionaryMapper;

    /**
     * 创建字典
     *
     * @param modelList 字典列表
     * @return 是否创建成功
     */
    @Override
    @CacheEvict(cacheNames = "dsb:cache:dictionary", allEntries = true)
    public Boolean create(List<DictionaryModel> modelList) {
        var saveList = DictionaryEntityConverter.INSTANCE.modelToEntityList(modelList);

        return dictionaryService.saveBatch(saveList);
    }

    /**
     * 根据参数删除字典
     *
     * @param param 删除条件参数
     * @return 是否删除成功
     */
    @Override
    @CacheEvict(cacheNames = "dsb:cache:dictionary", allEntries = true)
    public Boolean delete(DictionaryModel param) {
        var queryWrapper = getQueryDictionaryWrapper(param);

        return dictionaryService.remove(queryWrapper);
    }

    /**
     * 根据参数更新字典数据
     *
     * @param model 入参
     * @return 是否创建成功
     */
    @Override
    @CacheEvict(cacheNames = "dsb:cache:dictionary", allEntries = true)
    public Boolean update(DictionaryModel model) {
        var param = DictionaryEntityConverter.INSTANCE.modelToEntity(model);

        var updateWrapper = Wrappers.<Dictionary>lambdaUpdate()
                .set(StringUtils.isNotBlank(param.getType()), Dictionary::getType, param.getType())
                .set(StringUtils.isNotBlank(param.getName()), Dictionary::getName, param.getName())
                .set(StringUtils.isNotBlank(param.getCode()), Dictionary::getCode, param.getCode())
                .set(StringUtils.isNotBlank(param.getRemark()), Dictionary::getRemark, param.getRemark())
                .eq(Dictionary::getId, param.getId());

        return dictionaryService.update(updateWrapper);
    }

    /**
     * 根据type查询字典数据
     *
     * @param model
     * @return 数据库查询结果模型
     */
    @Override
    @Cacheable(cacheNames = "dsb:cache:dictionary")
    public List<DictionaryModel> query(DictionaryModel model) {
        var queryWrapper = getQueryDictionaryWrapper(model);

        var queryResult = dictionaryService.list(queryWrapper);

        if (CollectionUtil.isNotEmpty(queryResult)) {
            var result = DictionaryEntityConverter.INSTANCE.entityToModelList(queryResult);
            return result;
        }

        return Collections.emptyList();
    }

    /**
     * 根据type和code查询字典数据
     *
     * @param type 字典表类型
     * @param code 字典表编码
     * @return 字典表数据模型
     */
    @Override
    public DictionaryModel queryByTypeAndCode(String type, String code) {
        DictionaryModel param = new DictionaryModel();
        param.setType(type);
        param.setCode(code);

        LambdaQueryWrapper<Dictionary> queryWrapper = getQueryDictionaryWrapper(param);

        var queryResult = dictionaryService.getOne(queryWrapper);

        return DictionaryEntityConverter.INSTANCE.entityToModel(queryResult);
    }

    /**
     * 查询账单通用wrapper
     *
     * @param param 查询条件
     * @return 生成wrapper
     */
    private LambdaQueryWrapper<Dictionary> getQueryDictionaryWrapper(DictionaryModel param) {
        var queryWrapper = Wrappers.<Dictionary>lambdaQuery()
                .eq(Objects.nonNull(param.getId()), Dictionary::getId, param.getId())
                .eq(StringUtils.isNotBlank(param.getType()), Dictionary::getType, param.getType())
                .eq(StringUtils.isNotBlank(param.getCode()), Dictionary::getCode, param.getCode())
                .eq(StringUtils.isNotBlank(param.getName()), Dictionary::getName, param.getName());

        return queryWrapper;
    }

}
