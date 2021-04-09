package GET;

import sun.security.provider.certpath.OCSPResponse;

import javax.management.Notification;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/notifications")
public class NotificationsResource {
    @GET
    @Path("/ping")
    public Response ping() {
        return Response.ok().entity("Service online").build();
    }

    @GET
    @Path("/get/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public int getNotification(@PathParam("id") int id) {
        return id;
    }

    @GET
    @Path("users/{username}")
    public String validatedUsername(@PathParam("username") String name) {
        return name;
    }
}
