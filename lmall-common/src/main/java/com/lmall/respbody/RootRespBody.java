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
        INTERNAL_SERVER_ERROR(500),
        BAD_REQUEST(400);
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
