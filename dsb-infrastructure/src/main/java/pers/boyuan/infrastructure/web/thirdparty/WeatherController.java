package pers.boyuan.infrastructure.web.thirdparty;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.boyuan.thirdparty.weather.WeatherService;

/**
 * 天气相关接口 前端控制器
 *
 * @author ZhangBoyuan
 * @since 2022-06-14
 */
@Deprecated
@RestController
@RequestMapping("/thirdparty/weather")
@Tag(name = "天气相关接口")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    /**
     * 天气api响应成功 code
     */
    private final String RESPONSE_SUCCESS_CODE = "1000";

    /**
     * 天气api响应状态码 key
     */
    private final String RESPONSE_STATUS_KEY = "status";

    /**
     * 天气api响应数据 key
     */
    private final String RESPONSE_DATA_KEY = "data";

    /**
     * 天气api预测未来天气 key
     */
    private final String RESPONSE_FORECAST_KEY = "forecast";

    /**
     * 原服务方停止服务，该接口废弃
     */
//    @GetMapping("/query")
//    @ApiOperation("根据城市名称查询天气")
//    public Response query(@RequestParam(name = "city") String cityName) throws IOException {
//        String unzipStr = StringUnzipUtil.gzip(weatherService.getCityWeather(cityName));
//
//        if (Objects.nonNull(unzipStr)) {
//            JsonNode jsonNode = new ObjectMapper().readValue(unzipStr, JsonNode.class);
//            if (RESPONSE_SUCCESS_CODE.equals(jsonNode.get(RESPONSE_STATUS_KEY).asText())) {
//                return Response.success(jsonNode.get(RESPONSE_DATA_KEY).get(RESPONSE_FORECAST_KEY));
//            }
//        }
//
//        return Response.error(ResponseEnum.FAIL);
//    }

}
