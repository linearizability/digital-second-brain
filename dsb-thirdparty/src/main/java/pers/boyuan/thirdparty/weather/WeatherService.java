package pers.boyuan.thirdparty.weather;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 获取天气数据
 *
 * @author ZhangBoyuan
 * @date 2022-06-14
 */
@FeignClient(name = "${thirdparty.weather.service-name}", url = "${thirdparty.weather.url}")
public interface WeatherService {

    /**
     * 获取指定城市天气
     *
     * @param cityName 城市名称
     * @return 查询结果（压缩状态）
     */
    @GetMapping(value = "/weather_mini")
    String getCityWeather(@RequestParam("city") String cityName);

}
