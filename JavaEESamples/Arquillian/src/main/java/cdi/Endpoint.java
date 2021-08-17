package cdi;

import javax.ws.rs.GET;
import javax.ws.rs.core.Response;

public interface Endpoint {

    @GET
    public Response getResponse();

    @GET
    public Response largeIncrement();

}