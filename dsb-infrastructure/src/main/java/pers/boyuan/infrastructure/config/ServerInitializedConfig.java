package pers.boyuan.infrastructure.config;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * description 控制台输出 Swagger 接口文档地址
 *
 * @author ZhangBoyuan
 * @date 2022-02-08
 */
@Data
@Slf4j
@Component
public class ServerInitializedConfig implements ApplicationListener<WebServerInitializedEvent> {

    @Value("${server.servlet.context-path}")
    private String path;

    private Integer serverPort;

    public Integer getPort() {
        return this.serverPort;
    }

    @Override
    public void onApplicationEvent(WebServerInitializedEvent event) {
        try {
            InetAddress inetAddress = InetAddress.getLocalHost();
            this.serverPort = event.getWebServer().getPort();
            log.info("项目启动成功！接口文档地址: http://" + inetAddress.getHostAddress() + ":" + serverPort + path + "/doc.html");
        } catch (UnknownHostException e) {
            log.error(e.getMessage(), e);
        }
    }

}
