package PlanetExample;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("planet")
public class PlanetResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Planet getPlanet() {
        Planet p = new Planet();
        p.id = 1;
        p.name = "Earth";
        p.radius = 1.0;

        return p;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createPlanet(Planet p) {
        String result = "Planet saved : " + p;
        return Response.status(201).entity(result).build();
    }

}