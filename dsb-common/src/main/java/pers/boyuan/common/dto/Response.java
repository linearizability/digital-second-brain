package pers.boyuan.common.dto;

import pers.boyuan.common.constants.ResponseEnum;

/**
 * @author ZhangBoyuan
 * @date 2022-06-11
 */
public class Response<T> {
    /**
     * 是否操作成功
     */
    private Boolean isSuccess;

    /**
     * 响应code
     */
    private String code;

    /**
     * 响应信息
     */
    private String message;

    /**
     * 响应数据
     */
    private T data;

    public Boolean getSuccess() {
        return this.isSuccess;
    }

    public void setSuccess(Boolean success) {
        this.isSuccess = success;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Response() {
    }

    public Response(Boolean isSuccess, String code, String msg) {
        this(isSuccess, code, msg, null);
    }

    public Response(Boolean isSuccess, String code, String msg, T data) {
        this.code = code;
        this.data = data;
        this.message = msg;
    }

    public static Response success() {
        return new Response(Boolean.TRUE, ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getMessage());
    }

    public static Response success(String message) {
        return new Response(Boolean.TRUE, ResponseEnum.SUCCESS.getCode(), message);
    }

    public static <T> Response<T> success(T data) {
        Response<T> response = new Response();
        response.setSuccess(Boolean.TRUE);
        response.setCode(ResponseEnum.SUCCESS.getCode());
        response.setMessage(ResponseEnum.SUCCESS.getMessage());
        response.setData(data);
        return response;
    }

    public static Response error(ResponseEnum responseEnum) {
        return new Response(Boolean.FALSE, responseEnum.getCode(), responseEnum.getMessage());
    }

    public static Response error(String code, String msg) {
        return new Response(Boolean.FALSE, code, msg);
    }

}
