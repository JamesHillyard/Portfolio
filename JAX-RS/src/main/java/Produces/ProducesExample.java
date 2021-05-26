package Produces;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/produces")
@Produces("text/plain")
public class ProducesExample {

    private static final String JSONSTRING = "{\"age\":30}";
    private static final String HTMLSTRING = "<b>JAX-RS Tutorial</b>";

    // Using the JSON String variable
    @GET
    @Path("/jsonplain")
    public String doGetJsonAsPlainTest(){
        return JSONSTRING;
    }

    @GET
    @Path("/json")
    @Produces("application/json")
    public String doGetAsJson(){
        return JSONSTRING;
    }

    //Using HTML String variable

    @GET
    @Path("/htmlplain")
    public String doGetHtmlAsPlainTest(){
        return HTMLSTRING;
    }

    @GET
    @Path("/html")
    @Produces("text/html")
    public String doGetAsHtml(){
        return HTMLSTRING;
    }


}
