package pers.boyuan.infrastructure.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Knife4jAPI文档配置
 *
 * @author ZhangBoyuan
 * @since 2022-02-08
 */
@Configuration
public class Knife4jConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("digital-second-brain")
                        .version("2.0")
                        .description("第二大脑"));
    }
}
