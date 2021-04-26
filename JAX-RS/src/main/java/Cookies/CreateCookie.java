package Cookies;

import javax.ws.rs.*;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;

@Path("/newCookie")
public class CreateCookie {

    @POST
    @Path("{name}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response createCookie(@PathParam("name") String name) {
        Cookie cookie = new Cookie("name", name, "/", "localhost");
        return Response
                .ok()
                .cookie(new NewCookie(cookie))
                .build();
    }
}
