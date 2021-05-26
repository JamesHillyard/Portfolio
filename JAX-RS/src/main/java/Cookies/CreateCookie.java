package Cookies;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;

@Path("/newCookie")
public class CreateCookie {

    @POST
    @Path("{name}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response createCookie(@PathParam("name") String name) {
        return Response
                .ok()
                .cookie(new NewCookie("Name-Cookie", name, "/tutorial", "localhost", "A name storing cookie", 10000, false))
                .build();
    }
}
