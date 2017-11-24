package com.sravs.common.exception;

import com.sravs.common.response.BaseResponse;

import javax.ws.rs.core.Response;

public class ApplicationException extends RuntimeException {

    private Response.Status status = Response.Status.CONFLICT;
    private BaseResponse response = new BaseResponse().setStatus(BaseResponse.FAILURE);

    public ApplicationException() {
        super();
    }

    public ApplicationException(String message) {
        super(message);
        response.setMessage(message);
    }

    public ApplicationException(String message, Throwable cause) {
        super(message, cause);
        response.setMessage(message).setData("Cause: " + cause.getMessage());
    }

    public ApplicationException setStatus(Response.Status status) {
        this.status = status;
        return this;
    }

    public Response.Status getStatus() {
        return status;
    }

    public BaseResponse getResponse() {
        return response;
    }

    public void setResponse(BaseResponse response) {
        this.response = response;
    }

    public ApplicationException setData(Object data) {
        response.setData(data);
        return this;
    }
}
