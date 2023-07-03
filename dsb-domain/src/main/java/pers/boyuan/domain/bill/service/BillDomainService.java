package pers.boyuan.domain.bill.service;

import org.springframework.web.multipart.MultipartFile;
import pers.boyuan.common.dto.PageResponse;
import pers.boyuan.domain.bill.model.BillModel;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 账单表领域层服务
 *
 * @author ZhangBoyuan
 * @date 2022-06-22
 */
public interface BillDomainService {

    /**
     * 创建账单表数据
     *
     * @param modelList 创建账单表数据入参列表
     * @return 是否创建成功
     */
    Boolean create(List<BillModel> modelList);

    /**
     * 根据主键id删除账单表数据
     *
     * @param idList 主键id列表
     * @return 是否删除成功
     */
    Boolean delete(List<Long> idList);

    /**
     * 更新账单表数据
     *
     * @param model 更新账单表数据入参
     * @return 是否更新成功
     */
    Boolean update(BillModel model);

    /**
     * 查询账单表数据分页
     *
     * @param param 查询账单表数据分页入参
     * @return 查询账单表分页数据
     */
    PageResponse<BillModel> queryPage(BillModel param);

    /**
     * 根据指定条件导出账单表数据为excel
     *
     * @param model    指定条件
     * @param response 响应头，导出数据写入
     */
    void exportExcel(BillModel model, HttpServletResponse response);

    /**
     * 导入账单excel
     *
     * @param excelFile 导入excel文件
     * @return 导入成功行数
     */
    Integer importExcel(MultipartFile excelFile);

}
