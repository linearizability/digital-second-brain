package pers.boyuan.application.bill;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.web.multipart.MultipartFile;
import pers.boyuan.api.in.bill.CreateBillAO;
import pers.boyuan.api.in.bill.ExportBillAO;
import pers.boyuan.api.in.bill.QueryBillPageAO;
import pers.boyuan.api.in.bill.UpdateBillAO;
import pers.boyuan.api.out.bill.QueryBillVO;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 账单表应用服务
 *
 * @author ZhangBoyuan
 * @date 2022-06-22
 */
public interface BillAppService {

    /**
     * 创建账单表数据
     *
     * @param aoList 创建账单表数据入参列表
     * @return 是否创建成功
     */
    Boolean create(List<CreateBillAO> aoList);

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
     * @param ao 更新账单表数据入参
     * @return 是否更新成功
     */
    Boolean update(UpdateBillAO ao);

    /**
     * 查询账单表数据分页
     *
     * @param ao 查询账单表数据分页入参
     * @return 查询账单表分页数据
     */
    IPage<QueryBillVO> queryPage(QueryBillPageAO ao);

    /**
     * 根据指定条件导出账单表数据为excel
     *
     * @param ao       指定条件
     * @param response 响应头，导出数据写入
     */
    void exportExcel(ExportBillAO ao, HttpServletResponse response);

    /**
     * 导入账单excel
     *
     * @param excelFile 导入excel文件
     * @return 导入成功行数
     */
    Integer importExcel(MultipartFile excelFile);

}
