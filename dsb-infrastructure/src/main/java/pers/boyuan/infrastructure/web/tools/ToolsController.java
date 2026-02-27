package pers.boyuan.infrastructure.web.tools;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pers.boyuan.application.tools.ToolsAppServiceImpl;
import pers.boyuan.application.tools.impl.ToolsAppService;
import pers.boyuan.common.dto.Response;

/**
 * 常用工具汇总接口
 *
 * @author ZhangBoyuan
 * @date 2023-02-16
 */
@RestController
@RequestMapping("/tools")
@Api(tags = "常用工具接口")
public class ToolsController {

    @Autowired
    private ToolsAppService toolsAppService;

    @GetMapping("/staticVariableNameVariable")
    @ApiOperation("静态变量名生成")
    public Response staticVariableNameVariable(@RequestParam("str") String str) {
        var result = toolsAppService.staticVariableNameVariable(str);
        return Response.success(result);
    }

    @GetMapping("/jsonFormat")
    @ApiOperation("json数据格式化")
    public JsonNode jsonFormat(@RequestParam("jsonStr") String jsonStr) throws JsonProcessingException {
        return new ObjectMapper().readValue(jsonStr, JsonNode.class);
    }

}
