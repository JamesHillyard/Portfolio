package CaseInsensitiveURL;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("{hello : (?i)hello}")
public class InsensitiveUrl {
    @GET
    public Response sayHello(@PathParam("hello") String input){
        return Response.ok().entity(input).build();
    }
}
