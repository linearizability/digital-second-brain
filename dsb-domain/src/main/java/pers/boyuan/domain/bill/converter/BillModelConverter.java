package pers.boyuan.domain.bill.converter;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pers.boyuan.domain.bill.model.BillExportExcelBO;
import pers.boyuan.domain.bill.model.BillImportExcelBO;
import pers.boyuan.domain.bill.model.BillModel;

import java.util.List;

/**
 * @author ZhangBoyuan
 * @since 2022-06-11
 */
@Mapper
public interface BillModelConverter {

    BillModelConverter INSTANCE = Mappers.getMapper(BillModelConverter.class);

    BillExportExcelBO modelToExportExcelBO(BillModel model);

    List<BillExportExcelBO> modelToExportExcelBOList(List<BillModel> modelList);

    BillModel importExcelToModel(BillImportExcelBO bo);

    List<BillModel> importExcelToModelList(List<BillImportExcelBO> boList);

}
