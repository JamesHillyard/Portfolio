package HTTPRequestData;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("/uri")
public class Request {

    @GET
    public Response getUriInfo(@Context UriInfo uri){
        return Response.ok().entity(
                "Request Uri "+uri.getRequestUri() +
                "\nAbsolute Path"+uri.getAbsolutePath() +
                "\nPath Parameters"+uri.getPathParameters())
                .build();
    }
}
