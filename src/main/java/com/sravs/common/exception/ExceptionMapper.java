package com.sravs.common.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ExceptionMapper implements javax.ws.rs.ext.ExceptionMapper<ApplicationException> {
    @Override
    public Response toResponse(ApplicationException exception) {
        Response response = Response.status(exception.getStatus()).entity(exception.getResponse()).build();
        return response;
    }
}
