package pers.boyuan.application.dictionary.converter;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pers.boyuan.api.in.dictionary.CreateDictionaryAO;
import pers.boyuan.api.in.dictionary.DeleteDictionaryAO;
import pers.boyuan.api.in.dictionary.QueryDictionaryAO;
import pers.boyuan.api.in.dictionary.UpdateDictionaryAO;
import pers.boyuan.api.out.dictionary.QueryDictionaryVO;
import pers.boyuan.domain.dictionary.model.DictionaryModel;

import java.util.List;

/**
 * @author ZhangBoyuan
 * @date 2022-06-11
 */
@Mapper
public interface DictionaryDomainConverter {

    DictionaryDomainConverter INSTANCE = Mappers.getMapper(DictionaryDomainConverter.class);

    List<DictionaryModel> createDictionaryToModelList(List<CreateDictionaryAO> aoList);

    DictionaryModel deleteDictionaryToModel(DeleteDictionaryAO ao);

    DictionaryModel updateDictionaryToModel(UpdateDictionaryAO ao);

    List<QueryDictionaryVO> modelToQueryDictionary(List<DictionaryModel> modelList);

    DictionaryModel queryDictionaryToModel(QueryDictionaryAO ao);

}
