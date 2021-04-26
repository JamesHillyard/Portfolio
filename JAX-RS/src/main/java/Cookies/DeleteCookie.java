package Cookies;

import javax.ws.rs.CookieParam;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;

@Path("deleteCookie")
public class DeleteCookie {

    /**
     * As with the servlet tutorial cookies, to delete a JAX-RS cookie you create a new cookie with the same name
     * and a max age of 0.
     */

    @DELETE
    public Response deleteCookie(@CookieParam("name") Cookie cookie){
        if (cookie != null){
            return Response
                    .ok()
                    .cookie(new NewCookie("name", "", "/", "localhost", "Delete Cookie", 0, true))
                    .build();
        }
        return Response.noContent().entity("No cookie found").build();
    }
}
