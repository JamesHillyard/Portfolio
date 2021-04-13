package HTTPRequestData;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

@Path("")
public class Header {

    /**
     * Get a specific HTTP Header using this parameter
     */
    @GET
    @Path("specificHeader")
    public Response singleHeader(@HeaderParam("User-Agent") String userAgent) {
        return Response.status(200)
                .entity(userAgent)
                .build();

    }

    /**
     * Get all HTTP Headers with this @Context parameter
     */
    @GET
    @Path("/allHeaders")
    public Response allHeaders(@Context HttpHeaders headers) {
        String userAgent = headers.getRequestHeader("user-agent").get(0);
        return Response.status(200)
                .entity(userAgent)
                .build();

    }
}
