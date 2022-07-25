package pers.boyuan;

import cn.hutool.core.collection.CollectionUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pers.boyuan.common.constants.ResponseEnum;
import pers.boyuan.common.dto.Response;
import pers.boyuan.common.exception.CustomException;

import java.util.List;

/**
 * 全局异常捕获
 *
 * @author ZhangBoyuan
 * @date 2022-06-13
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    public Response handle(Exception e) {
        if (e instanceof HttpRequestMethodNotSupportedException) {
            return Response.error("9999", e.getMessage());
        }
        log.error("系统错误：", e);
        return Response.error(ResponseEnum.EXCEPTION);
    }

    @ExceptionHandler(value = CustomException.class)
    public Response handle(CustomException e) {
        log.error("业务异常：{}", e);
        return Response.error(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(value = BindException.class)
    public Response handleBindException(BindException e) {
        BindingResult bindingResult = e.getBindingResult();
        if (bindingResult.hasErrors()) {
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            if (CollectionUtil.isNotEmpty(allErrors)) {
                ObjectError objectError = allErrors.get(0);
                String defaultMessage = objectError.getDefaultMessage();
                log.error("入参不规范：{}", defaultMessage);
                return Response.error(ResponseEnum.PARAM_NOT_STANDARD.getCode(), objectError.getDefaultMessage());
            }
        }
        log.error("未知入参异常");
        return Response.error(ResponseEnum.EXCEPTION);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public Response handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        if (bindingResult.hasErrors()) {
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            if (CollectionUtil.isNotEmpty(allErrors)) {
                ObjectError objectError = allErrors.get(0);
                String defaultMessage = objectError.getDefaultMessage();
                log.error("入参不规范：{}", defaultMessage);
                return Response.error(ResponseEnum.PARAM_NOT_STANDARD.getCode(), objectError.getDefaultMessage());
            }
        }
        log.error("未知入参异常");
        return Response.error(ResponseEnum.EXCEPTION);
    }

}