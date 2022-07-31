package pers.boyuan.infrastructure.converter.bill;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pers.boyuan.domain.bill.model.BillModel;
import pers.boyuan.infrastructure.db.entity.Bill;

import java.util.List;

/**
 * Bill实体类与Bill模型 转换类
 *
 * @author ZhangBoyuan
 * @date 2022-06-11
 */
@Mapper
public interface BillEntityConverter {

    BillEntityConverter INSTANCE = Mappers.getMapper(BillEntityConverter.class);

    Bill modelToEntity(BillModel model);

    List<Bill> modelToEntityList(List<BillModel> modelList);

    List<BillModel> entityToModelList(List<Bill> entityList);

}
