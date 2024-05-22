package pers.boyuan.infrastructure.web.dictionary;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.boyuan.api.in.dictionary.CreateDictionaryAO;
import pers.boyuan.api.in.dictionary.DeleteDictionaryAO;
import pers.boyuan.api.in.dictionary.QueryDictionaryAO;
import pers.boyuan.api.in.dictionary.UpdateDictionaryAO;
import pers.boyuan.api.out.dictionary.QueryDictionaryVO;
import pers.boyuan.application.dictionary.DictionaryAppService;
import pers.boyuan.common.dto.Response;
import pers.boyuan.common.scheme.ValidationList;

import java.util.List;
import java.util.Map;

import static pers.boyuan.common.constants.ResponseEnum.FAIL;

/**
 * 字典表 前端控制器
 *
 * @author ZhangBoyuan
 * @since 2022-06-11
 */
@RestController
@RequestMapping("/data/dictionary")
@Tag(name = "字典相关接口")
public class DictionaryController {

    @Autowired
    private DictionaryAppService dictionaryAppService;

    @PostMapping("/create")
    @Operation(summary = "创建字典数据")
    public Response<Boolean> create(@RequestBody @Valid ValidationList<CreateDictionaryAO> aoList) {
        var createFlag = dictionaryAppService.create(aoList);
        return createFlag ? Response.success() : Response.error(FAIL);
    }

    @PostMapping("/delete")
    @Operation(summary = "根据参数删除词典")
    public Response<Boolean> delete(@RequestBody DeleteDictionaryAO ao) {
        var deleteFlag = dictionaryAppService.delete(ao);
        return deleteFlag ? Response.success() : Response.error(FAIL);
    }

    @PostMapping("/update")
    @Operation(summary = "更新字典数据")
    public Response<Boolean> update(@RequestBody UpdateDictionaryAO ao) {
        var updateFlag = dictionaryAppService.update(ao);
        return updateFlag ? Response.success() : Response.error(FAIL);
    }

    @PostMapping("/query")
    @Operation(summary = "根据type查询字典数据，无参拉取全量")
    public Response<Map<String, List<QueryDictionaryVO>>> query(@RequestBody QueryDictionaryAO ao) {
        var result = dictionaryAppService.query(ao);
        return Response.success(result);
    }

}
