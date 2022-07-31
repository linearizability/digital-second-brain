package pers.boyuan.infrastructure.converter.dictionary;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pers.boyuan.domain.dictionary.model.DictionaryModel;
import pers.boyuan.infrastructure.db.entity.Dictionary;

import java.util.List;

/**
 * Dictionary实体类与Dictionary模型 转换类
 *
 * @author ZhangBoyuan
 * @date 2022-06-11
 */
@Mapper
public interface DictionaryEntityConverter {

    DictionaryEntityConverter INSTANCE = Mappers.getMapper(DictionaryEntityConverter.class);

    Dictionary modelToEntity(DictionaryModel model);

    List<Dictionary> modelToEntityList(List<DictionaryModel> modelList);

    DictionaryModel entityToModel(Dictionary entity);

    List<DictionaryModel> entityToModelList(List<Dictionary> entityList);

}
