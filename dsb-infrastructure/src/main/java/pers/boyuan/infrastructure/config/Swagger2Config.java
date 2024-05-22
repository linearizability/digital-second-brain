package pers.boyuan.infrastructure.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Swagger2API文档配置
 *
 * @author ZhangBoyuan
 * @since 2022-02-08
 */
@Configuration
public class Swagger2Config {

    @Value("${swagger.enable}")
    private boolean swaggerEnable;

    @Bean
    public GroupedOpenApi dsbApi() {
        return GroupedOpenApi.builder()
                .group("dsbApi")
                .pathsToMatch("/dsb/**")
                .build();
    }

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Knife4j标题")
                        .description("Knife4j说明")
                        .version("v1")
                        .contact(new Contact().name("robin").email("robin@gmail.com"))
                        .license(new License().name("Apache 2.0").url("http://springdoc.org"))
                );

    }

}
