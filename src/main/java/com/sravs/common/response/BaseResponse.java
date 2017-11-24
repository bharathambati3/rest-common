package com.sravs.common.response;

public class BaseResponse {

    public static final String SUCCESS = "success";
    public static final String FAILURE = "failure";

    private String status = SUCCESS;
    private String message;
    private Object data;

    public BaseResponse() {
    }

    public String getStatus() {
        return status;
    }

    public BaseResponse setStatus(String status) {
        this.status = status;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public BaseResponse setMessage(String message) {
        this.message = message;
        return this;
    }

    public Object getData() {
        return data;
    }

    public BaseResponse setData(Object data) {
        this.data = data;
        return this;
    }

    public static BaseResponse build(Object data, String... params) {
        if (data == null && params.length == 0) {
            return new BaseResponse();
        }

        switch (params.length) {
            case 0:
                return new BaseResponse().setData(data);
            case 1:
                return new BaseResponse().setData(data).setStatus(params[0]);
            case 2:
                return new BaseResponse().setData(data).setStatus(params[0]).setMessage(params[1]);
            default:
                return null;
        }
    }
}
