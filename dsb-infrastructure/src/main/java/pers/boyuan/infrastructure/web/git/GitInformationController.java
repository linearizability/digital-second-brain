package pers.boyuan.infrastructure.web.git;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.boyuan.common.dto.Response;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.Properties;

/**
 * git相关信息接口
 *
 * @author ZhangBoyuan
 * @date 2022-10-14
 */
@Slf4j
@RestController
@Api(tags = "获取git信息")
@RequestMapping("/gitInformation")
public class GitInformationController {

    @Data
    class GitDetail {
        private String branch;

        private String commitMessage;

        private String commitTime;
    }

    @ApiOperation("获取本次打包git信息")
    @GetMapping("/detail")
    public Response getDetail() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        Properties properties = new Properties();

        InputStream in = classLoader.getResourceAsStream("git.properties");

        if (Objects.isNull(in)) {
            return Response.success("获取版本信息失败，请检查jar包文件");
        }

        properties.load(in);

        GitDetail gitDetail = new GitDetail();
        gitDetail.setBranch(properties.get("git.branch").toString());
        gitDetail.setCommitMessage(properties.get("git.commit.message.full").toString());
        gitDetail.setCommitTime(properties.get("git.commit.time").toString());

        return Response.success(gitDetail);
    }

}
