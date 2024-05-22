package pers.boyuan.infrastructure.repository.dictionary;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import jakarta.validation.constraints.NotNull;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import pers.boyuan.domain.dictionary.model.DictionaryModel;
import pers.boyuan.domain.dictionary.repository.DictionaryRepository;
import pers.boyuan.infrastructure.converter.dictionary.DictionaryEntityConverter;
import pers.boyuan.infrastructure.db.entity.Dictionary;
import pers.boyuan.infrastructure.db.service.IDictionaryService;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * 字典表底层数据库接口 Mybatis 实现类
 *
 * @author ZhangBoyuan
 * @since 2022-06-11
 */
@Validated
@Component
public class DictionaryMybatisRepository implements DictionaryRepository {

    @Autowired
    private IDictionaryService dictionaryService;

    /**
     * 创建字典
     *
     * @param modelList 字典列表
     * @return 是否创建成功
     */
    @Override
    @CacheEvict(cacheNames = "dsb:cache:dictionary", allEntries = true)
    public Boolean create(List<DictionaryModel> modelList) {
        var saveList = DictionaryEntityConverter.INSTANCE.modelToEntity(modelList);

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
    public Boolean delete(@NotNull(message = "删除字典入参不可为空") DictionaryModel param) {
        var queryWrapper = buildBasicQueryWrapper(param);

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
     * @param model 入参
     * @return 数据库查询结果模型
     */
    @Override
    @Cacheable(cacheNames = "dsb:cache:dictionary")
    public List<DictionaryModel> query(DictionaryModel model) {
        if (Objects.isNull(model)) {
            return getAll();
        }
        var queryWrapper = buildBasicQueryWrapper(model);

        var queryResult = dictionaryService.list(queryWrapper);

        if (CollectionUtils.isNotEmpty(queryResult)) {
            return DictionaryEntityConverter.INSTANCE.entityToModel(queryResult);
        }

        return Collections.emptyList();
    }

    /**
     * 获取字典表所有数据
     *
     * @return 字典表所有数据
     */
    @Override
    public List<DictionaryModel> getAll() {
        return DictionaryEntityConverter.INSTANCE.entityToModel(dictionaryService.list());
    }

    /**
     * 查询字典通用wrapper
     *
     * @param param 查询条件
     * @return 生成wrapper
     */
    private LambdaQueryWrapper<Dictionary> buildBasicQueryWrapper(DictionaryModel param) {
        return Wrappers.<Dictionary>lambdaQuery()
                .eq(Objects.nonNull(param.getId()), Dictionary::getId, param.getId())
                .eq(StringUtils.isNotBlank(param.getType()), Dictionary::getType, param.getType())
                .eq(StringUtils.isNotBlank(param.getCode()), Dictionary::getCode, param.getCode())
                .eq(StringUtils.isNotBlank(param.getName()), Dictionary::getName, param.getName());
    }

}
