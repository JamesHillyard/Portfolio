package fish.payara.james.portfolio.jaxrs.cookies;

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
    public Response updateCookie(@CookieParam("Name-Cookie") Cookie cookie, @PathParam("name") String name){
        if (cookie != null){
            return Response
                    .ok()
                    .cookie(new NewCookie("Name-Cookie", name, "/tutorial", "localhost", "A name storing cookie", 10000, false))
                    .build();
        }
        return Response.ok().build();
    }
}
