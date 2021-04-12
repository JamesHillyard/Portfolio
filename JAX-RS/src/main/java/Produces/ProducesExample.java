package Produces;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/produces")
@Produces("text/plain")
public class ProducesExample {

    private static final String JSONSTRING = "{\"age\":30}";
    private static final String HTMLSTRING = "<h1>JAX-RS Tutorial<h1>";

    // Using the JSON String variable
    @GET
    @Path("/jsonplain")
    public Response doGetJsonAsPlainTest(){
        return Response.status(200)
                .entity(JSONSTRING)
                .build();
    }

    @GET
    @Path("/json")
    @Produces("application/json")
    public Response doGetAsJson(){
        return Response.status(200)
                .entity(JSONSTRING)
                .build();
    }

    //Using HTML String variable

    @GET
    @Path("/htmlplain")
    public Response doGetHtmlAsPlainTest(){
        return Response.status(200)
                .entity(HTMLSTRING)
                .build();
    }

    @GET
    @Path("/html")
    @Produces("text/html")
    public Response doGetAsHtml(){
        return Response.status(200)
                .entity(HTMLSTRING)
                .build();
    }


}
