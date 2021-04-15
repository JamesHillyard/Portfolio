package Cookies;

import javax.ws.rs.CookieParam;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;

@Path("updateCookie")
public class UpdateCookie {

    @PUT
    @Path("{name}")
    public Response updateCookie(@CookieParam("name") Cookie cookie, @PathParam("name") String name){
        if (cookie != null){
            return Response
                    .ok()
                    .cookie(new NewCookie("name", name))
                    .build();
        }
        return Response.ok().build();
    }
}
