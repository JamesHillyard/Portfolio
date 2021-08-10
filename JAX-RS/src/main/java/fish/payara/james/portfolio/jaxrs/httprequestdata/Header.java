package fish.payara.james.portfolio.jaxrs.httprequestdata;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import java.util.stream.Collectors;

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
    @Path("allHeaders")
    public Response allHeaders(@Context HttpHeaders headers) {
        MultivaluedMap<String, String> rh = headers.getRequestHeaders();
        String str = rh.entrySet()
                .stream()
                .map(e -> e.getKey() + " = " + e.getValue())
                .collect(Collectors.joining("\n"));

        return Response.status(200)
                .entity(str)
                .build();

    }

    @GET
    @Path("customHeader")
    public Response customHeader(@Context HttpServletResponse response){
        response.setHeader("HeaderName", "HeaderValue");
        return Response.status(200).build();
    }
}
