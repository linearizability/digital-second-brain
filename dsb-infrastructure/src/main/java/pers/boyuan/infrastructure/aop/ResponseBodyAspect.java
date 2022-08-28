package pers.boyuan.infrastructure.aop;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.apache.commons.lang3.RandomStringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 请求日志打印
 *
 * @author ZhangBoyuan
 * @date 2022-08-28
 */
@Aspect
@Order(-1)
@Component
@Slf4j
public class ResponseBodyAspect {

    private static final Integer REQUEST_ID_LENGTH = 8;

    @Pointcut("(@within(org.springframework.web.bind.annotation.RestController)) || @annotation(org.springframework.web.bind.annotation.RequestBody)")
    public void responseBody() {

    }

    @Around("responseBody()")
    public Object around(ProceedingJoinPoint point) {
        Object result = null;

        String requestId = RandomStringUtils.randomAlphanumeric(REQUEST_ID_LENGTH);

        var args = point.getArgs();
        var signature = (MethodSignature) point.getSignature();
        var startTime = System.currentTimeMillis();

        try {
            printRequestParam(requestId, signature, args);
            result = point.proceed(args);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            log.info("requestId：{}, 耗时：{}毫秒，请求应答：{}",
                    requestId,
                    System.currentTimeMillis() - startTime,
                    printResponseBody(result));
        }

        return result;
    }

    private void printRequestParam(String requestId, MethodSignature signature, Object[] args) {
        var argList = Arrays.stream(args).collect(Collectors.toList());
        try {
            log.info("requestId：{}, 调用方法：{}.{} 请求参数：{}",
                    requestId,
                    signature.getDeclaringType().getSimpleName(),
                    signature.getMethod().getName(),
                    argList.size() > 0 ? new ObjectMapper().writeValueAsString(argList) : "");
        } catch (JsonProcessingException e) {
            log.error(e.getMessage(), e);
        }
    }

    private String printResponseBody(Object object) {
        String result = "";

        try {
            result = new ObjectMapper().writeValueAsString(object);
        } catch (JsonProcessingException e) {
            log.error(e.getMessage(), e);
        }

        return result;
    }

}
