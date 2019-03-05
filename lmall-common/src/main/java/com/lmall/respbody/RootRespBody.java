package com.lmall.respbody;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Created by reckywangbowen_i on 2018/12/11
 */
public class RootRespBody<T> {
    private Status status;
    private String message;
    private T data;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
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

    @Override
    public String toString() {
        return "status" + status + ",message=" + message;
    }

    public static <T> RootRespBody<T> success(T data){
        RootRespBody<T> respBody = new RootRespBody<>();
        respBody.setStatus(Status.SUCCESS);
        respBody.setMessage("SUCCESS");
        respBody.setData(data);
        return respBody;
    }

    public static <T> RootRespBody<T> success(){
        RootRespBody<T> respBody = new RootRespBody<>();
        respBody.setStatus(Status.SUCCESS);
        respBody.setMessage("SUCCESS");
        return respBody;
    }

    public static <T> RootRespBody<T> failure(Status status, String message){
        RootRespBody<T> respBody = new RootRespBody<>();
        respBody.setStatus(status);
        respBody.setMessage(message);
        return respBody;
    }

    public static <T> RootRespBody<T> failure(Status status, String message, T data){
        RootRespBody<T> respBody = new RootRespBody<>();
        respBody.setStatus(status);
        respBody.setMessage(message);
        respBody.setData(data);
        return respBody;
    }

    public enum Status {
        //状态码
        SUCCESS(200),
        DUPLICATE_RECORD_ERROR(210),
        RELEVANT_DATA_INEXISTENCE_ERROR(220),
        HIVE_METASTORE_ERROR(230),
        PERMISSION_DENIED_ERROR(240),
        ILLEGAL_OPERATION_ERROR(250),
        INSERT_RECORD_ERROR(260),
        FORM_INVALID_ERROR(270),
        INVALID_PARAM(280), // 无效参数
        UNSUPPORTED_OPERATION(290),
        PAGE_QUERY_PARAM_ERROR(301), //分页查询请求的参数错误
        PROCESS_TASK_NOT_FOUND(401),
        PROCESS_TASK_FORM_FORMAT_ERROR(402),
        PROCESS_TASK_FORM_INTEGRITY_ERROR(403),
        PROCESS_DELEGATE_ERROR(405),
        REQUEST_PARAMETER_ERROR(406), //请求参数错误
        APPLICANT_NOT_FOUND(409),    //申请人未找到
        SYSTEM_API_ERROR(411),
        PERMISSION_DENIED(428), //没有权限
        DATA_ERROR(432), // 数据格式正确但语义错误
        INTERNAL_SERVER_ERROR(500),
        PROCESS_FORM_PARAM_ERROR(415), //流程表单参数错误
        BAD_REQUEST(400),
        COOKIE_NOT_SET(201);
        private int value;

        Status(int value) {
            this.value = value;
        }

        @JsonValue
        public int getValue() {
            return value;
        }

    }
}
