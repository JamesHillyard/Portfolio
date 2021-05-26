package Cookies;

import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/getCookie")
public class GetCookie {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response getCookie(@CookieParam("Name-Cookie") Cookie cookie) {
        if (cookie == null) {
            return Response.serverError().entity("ERROR").build();
        } else {
            return Response
                    .ok(cookie.getValue())
                    .build();
        }
    }
}
