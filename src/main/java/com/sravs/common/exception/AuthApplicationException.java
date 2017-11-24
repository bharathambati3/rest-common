package com.sravs.common.exception;

import com.sravs.common.response.BaseResponse;

import javax.ws.rs.core.Response;

public class AuthApplicationException extends RuntimeException {

    private Response.Status status = Response.Status.CONFLICT;
    private BaseResponse response = new BaseResponse().setStatus(BaseResponse.FAILURE);

    public AuthApplicationException() {
        super();
    }

    public AuthApplicationException(String message) {
        super(message);
        response.setMessage(message);
    }

    public AuthApplicationException(String message, Throwable cause) {
        super(message, cause);
        response.setMessage(message).setData("Cause: " + cause.getMessage());
    }

    public AuthApplicationException setStatus(Response.Status status) {
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

    public AuthApplicationException setData(Object data) {
        response.setData(data);
        return this;
    }
}
