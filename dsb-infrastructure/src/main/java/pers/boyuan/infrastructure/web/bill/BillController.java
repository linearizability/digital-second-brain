package pers.boyuan.infrastructure.web.bill;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pers.boyuan.api.in.bill.CreateBillAO;
import pers.boyuan.api.in.bill.ExportBillAO;
import pers.boyuan.api.in.bill.QueryBillPageAO;
import pers.boyuan.api.in.bill.UpdateBillAO;
import pers.boyuan.api.out.bill.QueryBillVO;
import pers.boyuan.application.bill.BillAppService;
import pers.boyuan.common.dto.PageResponse;
import pers.boyuan.common.dto.Response;

import java.util.List;

import static java.lang.Boolean.TRUE;
import static pers.boyuan.common.constants.ResponseEnum.FAIL;

/**
 * 消费账单表 前端控制器
 *
 * @author ZhangBoyuan
 * @since 2022-06-22
 */
@RestController
@RequestMapping("/biz/bill")
@Tag(name = "账单表相关接口")
public class BillController {

    @Autowired
    private BillAppService billAppService;

    @PostMapping("/create")
    @Operation(summary = "创建账单表数据")
    public Response<Boolean> create(@RequestBody List<CreateBillAO> aoList) {
        var createFlag = billAppService.create(aoList);
        return createFlag ? Response.success(TRUE) : Response.error(FAIL);
    }

    @PostMapping("/delete")
    @Operation(summary = "根据主键id删除账单表数据")
    public Response<Boolean> delete(@RequestBody List<Long> idList) {
        var deleteFlag = billAppService.delete(idList);
        return deleteFlag ? Response.success(TRUE) : Response.error(FAIL);
    }

    @PostMapping("/update")
    @Operation(summary = "更新账单表数据")
    public Response<Boolean> update(@RequestBody @Valid UpdateBillAO ao) {
        var updateFlag = billAppService.update(ao);
        return updateFlag ? Response.success(TRUE) : Response.error(FAIL);
    }

    @PostMapping("/queryPage")
    @Operation(summary = "查询账单表数据分页")
    public PageResponse<QueryBillVO> queryPage(@RequestBody QueryBillPageAO ao) {
        return billAppService.queryPage(ao);
    }

    @GetMapping("/exportExcel")
    @Operation(summary = "根据指定条件导出账单表数据为excel")
    public void exportExcel(ExportBillAO ao, HttpServletResponse response) {
        billAppService.exportExcel(ao, response);
    }

    @PostMapping("/importExcel")
    @Operation(summary = "导入账单数据")
    public Response<Integer> importExcel(@RequestParam("excelFile") MultipartFile excelFile) {
        Integer saveRow = billAppService.importExcel(excelFile);
        return Response.success(saveRow);
    }

}
