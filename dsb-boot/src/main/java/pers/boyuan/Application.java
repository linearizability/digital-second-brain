package pers.boyuan;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.Objects;

/**
 * dsb项目启动类
 *
 * @author ZhangBoyuan
 * @date 2022-06-11
 */
@EnableCaching
@EnableFeignClients(basePackages = {"pers.boyuan.thirdparty.*"})
@SpringBootApplication
public class Application {

    static void main() {
        loadEnvVariables();
        SpringApplication.run(Application.class);
    }

    private static void loadEnvVariables() {
        Dotenv dotenv = Dotenv.configure()
                .filename(".env")
                .ignoreIfMissing()
                .load();

        if (Objects.nonNull(dotenv)) {
            dotenv.entries().forEach(item -> System.setProperty(item.getKey(), item.getValue()));
        }
    }

}
