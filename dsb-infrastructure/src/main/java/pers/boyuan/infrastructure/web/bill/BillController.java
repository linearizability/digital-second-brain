package pers.boyuan.infrastructure.web.bill;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pers.boyuan.api.in.bill.CreateBillAO;
import pers.boyuan.api.in.bill.ExportBillAO;
import pers.boyuan.api.in.bill.QueryBillPageAO;
import pers.boyuan.api.in.bill.UpdateBillAO;
import pers.boyuan.api.out.bill.QueryBillVO;
import pers.boyuan.application.bill.BillAppService;
import pers.boyuan.common.constants.ResponseEnum;
import pers.boyuan.common.dto.PageResponse;
import pers.boyuan.common.dto.Response;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

/**
 * 消费账单表 前端控制器
 *
 * @author ZhangBoyuan
 * @date 2022-06-22
 */
@RestController
@RequestMapping("/biz/bill")
@Api(tags = "账单表相关接口")
public class BillController {

    @Autowired
    private BillAppService billAppService;

    @PostMapping("/create")
    @ApiOperation("创建账单表数据")
    public Response<Boolean> create(@RequestBody List<CreateBillAO> aoList) {
        var createFlag = billAppService.create(aoList);
        return createFlag ? Response.success(Boolean.TRUE) : Response.error(ResponseEnum.FAIL);
    }

    @PostMapping("/delete")
    @ApiOperation("根据主键id删除账单表数据")
    public Response<Boolean> delete(@RequestBody List<Long> idList) {
        var deleteFlag = billAppService.delete(idList);
        return deleteFlag ? Response.success(Boolean.TRUE) : Response.error(ResponseEnum.FAIL);
    }

    @PostMapping("/update")
    @ApiOperation("更新账单表数据")
    public Response<Boolean> update(@RequestBody @Valid UpdateBillAO ao) {
        var updateFlag = billAppService.update(ao);
        return updateFlag ? Response.success(Boolean.TRUE) : Response.error(ResponseEnum.FAIL);
    }

    @PostMapping("/queryPage")
    @ApiOperation("查询账单表数据分页")
    public PageResponse<QueryBillVO> queryPage(@RequestBody QueryBillPageAO ao) {
        var iPage = billAppService.queryPage(ao);
        return PageResponse.success(iPage.getTotal(), iPage.getCurrent(), iPage.getSize(), iPage.getRecords());
    }

    @GetMapping("/exportExcel")
    @ApiOperation("根据指定条件导出账单表数据为excel")
    public void exportExcel(ExportBillAO ao, HttpServletResponse response) {
        billAppService.exportExcel(ao, response);
    }

    @PostMapping("/importExcel")
    @ApiOperation("导入账单数据")
    public Response<Integer> importExcel(@RequestParam("excelFile") MultipartFile excelFile) {
        Integer saveRow = billAppService.importExcel(excelFile);
        return Response.success(saveRow);
    }

}
