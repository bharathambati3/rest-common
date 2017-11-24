package com.sravs.common.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class AuthExceptionMapper implements ExceptionMapper<AuthApplicationException> {
    @Override
    public Response toResponse(AuthApplicationException exception) {
        Response response = Response.status(exception.getStatus()).entity(exception.getResponse()).build();
        return response;
    }
}
