package pers.boyuan.infrastructure.web.git;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.boyuan.common.dto.Response;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.Optional;
import java.util.Properties;

/**
 * git相关信息接口
 *
 * @author ZhangBoyuan
 * @since 2022-10-14
 */
@Slf4j
@RestController
@Tag(name = "获取git信息")
@RequestMapping("/gitInformation")
public class GitInformationController {

    @Data
    class GitDetail {
        String branch;
        String commitMessage;
        String commitTime;
    }

    @Operation(summary = "获取本次打包git信息")
    @GetMapping("/detail")
    public Response getDetail() {
        GitDetail gitDetail = new GitDetail();
        try {
            // 加载git.properties文件，并获取指定属性值
            Properties properties = loadGitProperties();
            gitDetail.setBranch(getStringProperty(properties, "git.branch"));
            gitDetail.setCommitMessage(getStringProperty(properties, "git.commit.message.full"));
            gitDetail.setCommitTime(getStringProperty(properties, "git.commit.time"));
        } catch (Exception e) {
            // 加载出错则返回错误信息
            return Response.success(e.getMessage());
        }
        return Response.success(gitDetail);
    }

    /**
     * 加载git.properties文件
     *
     * @return Properties对象
     * @throws RuntimeException 若读取失败则抛出运行时异常
     */
    private Properties loadGitProperties() {
        Properties properties = new Properties();
        try (InputStream in = getClass().getClassLoader().getResourceAsStream("git.properties")) {
            if (Objects.isNull(in)) {
                log.error("未找到 git.properties 文件");
                return new Properties();
            }
            properties.load(in);
        } catch (IOException e) {
            log.error("读取 git.properties 文件失败：", e);
        }
        return properties;
    }

    /**
     * 获取git.properties文件中的指定属性值
     *
     * @param properties Properties对象
     * @param key        属性名
     * @return String 属性值
     */
    private static String getStringProperty(Properties properties, String key) {
        return Optional.ofNullable(properties.getProperty(key, "")).map(Object::toString).orElse("");
    }


}
