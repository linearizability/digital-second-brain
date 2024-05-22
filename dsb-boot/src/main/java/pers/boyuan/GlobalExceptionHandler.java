package pers.boyuan;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pers.boyuan.common.dto.Response;
import pers.boyuan.common.exception.CustomException;

import java.util.List;

import static pers.boyuan.common.constants.ResponseEnum.EXCEPTION;
import static pers.boyuan.common.constants.ResponseEnum.PARAM_NOT_STANDARD;

/**
 * 全局异常捕获
 *
 * @author ZhangBoyuan
 * @since 2022-06-13
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    public Response handle(Exception e) {
        log.error("系统错误：", e);
        return Response.error(EXCEPTION);
    }

    @ExceptionHandler(value = CustomException.class)
    public Response handle(CustomException e) {
        log.error("业务异常：{}", e.getMessage());
        return Response.error(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(value = BindException.class)
    public Response handleBindException(BindException e) {
        return paramNotStandard(e.getBindingResult());
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public Response handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        return paramNotStandard(e.getBindingResult());
    }

    /**
     * 入参相关问题异常处理
     */
    private Response paramNotStandard(BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            if (CollectionUtils.isNotEmpty(allErrors)) {
                ObjectError objectError = allErrors.get(0);
                String defaultMessage = objectError.getDefaultMessage();
                log.error("入参不规范：{}", defaultMessage);
                return Response.error(PARAM_NOT_STANDARD.getCode(), objectError.getDefaultMessage());
            }
        }
        log.error("未知入参异常");
        return Response.error(EXCEPTION);
    }

}