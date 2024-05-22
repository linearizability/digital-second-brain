package pers.boyuan.application.bill.impl;

import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pers.boyuan.api.in.bill.CreateBillAO;
import pers.boyuan.api.in.bill.ExportBillAO;
import pers.boyuan.api.in.bill.QueryBillPageAO;
import pers.boyuan.api.in.bill.UpdateBillAO;
import pers.boyuan.api.out.bill.QueryBillVO;
import pers.boyuan.application.bill.BillAppService;
import pers.boyuan.application.bill.converter.BillDomainConverter;
import pers.boyuan.common.dto.PageResponse;
import pers.boyuan.domain.bill.service.BillDomainService;

import java.util.List;

/**
 * 账单表应用服务实现类
 *
 * @author ZhangBoyuan
 * @since 2022-06-22
 */
@Service
public class BillAppServiceImpl implements BillAppService {

    @Autowired
    private BillDomainService billDomainService;

    /**
     * 创建账单表数据
     *
     * @param aoList 创建账单表数据入参列表
     * @return 是否创建成功
     */
    @Override
    public Boolean create(List<CreateBillAO> aoList) {
        if (CollectionUtils.isEmpty(aoList)) {
            return Boolean.FALSE;
        }

        var modelList = BillDomainConverter.INSTANCE.createBillToModelList(aoList);

        return billDomainService.create(modelList);
    }

    /**
     * 根据主键id删除账单表数据
     *
     * @param idList 主键id列表
     * @return 是否删除成功
     */
    @Override
    public Boolean delete(List<Long> idList) {
        if (CollectionUtils.isEmpty(idList)) {
            return Boolean.FALSE;
        }
        return billDomainService.delete(idList);
    }

    /**
     * 更新账单表数据
     *
     * @param ao 更新账单表数据入参
     * @return 是否更新成功
     */
    @Override
    public Boolean update(UpdateBillAO ao) {
        var model = BillDomainConverter.INSTANCE.updateToModel(ao);
        return billDomainService.update(model);
    }

    /**
     * 查询账单表数据分页
     *
     * @param ao 查询账单表数据分页入参
     * @return 查询账单表分页数据
     */
    @Override
    public PageResponse<QueryBillVO> queryPage(QueryBillPageAO ao) {
        var param = BillDomainConverter.INSTANCE.queryPageToModel(ao);
        var result = billDomainService.queryPage(param);

        return PageResponse.success(result.getTotalCount(), result.getPageIndex(), result.getPageSize(), BillDomainConverter.INSTANCE.modelToQueryBill(result.getData()));
    }

    /**
     * 根据指定条件导出账单表数据为excel
     *
     * @param ao       指定条件
     * @param response 响应头，导出数据写入
     */
    @Override
    public void exportExcel(ExportBillAO ao, HttpServletResponse response) {
        var model = BillDomainConverter.INSTANCE.exportToModel(ao);
        billDomainService.exportExcel(model, response);
    }

    /**
     * 导入账单excel
     *
     * @param excelFile 导入excel文件
     * @return 导入成功行数
     */
    @Override
    public Integer importExcel(MultipartFile excelFile) {
        return billDomainService.importExcel(excelFile);
    }

}
