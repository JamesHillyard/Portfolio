package fish.payara.james.portfolio.jaxrs.jsonb;


import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.ws.rs.*;
import java.util.ArrayList;
import java.util.List;

@Path("cats")
@Consumes("application/json")
public class CatResource {
    private static List<Cat> cats = new ArrayList<>();

    static {
        cats.add(new Cat("Rose", "Ginger", true));
        cats.add(new Cat("Tim", "Black", false));
        cats.add(new Cat("Tony", "White/Brown", true));
    }

    @Path("one")
    @GET
    @Produces("application/json")
    public Cat getRandomCat(){
        return cats.get((int) (Math.round(Math.random()*2)));
    }

    @Path("all")
    @GET
    @Produces("application/json")
    public List<Cat> getAllCats(){
        return cats;
    }

    @Path("add")
    @POST
    public String createCat(@QueryParam("Name") String name, @QueryParam("Colour") String colour,
                            @QueryParam("Domesticated") boolean domesticated){
        Cat cat = new Cat(name, colour, domesticated);
        Jsonb jsonb = JsonbBuilder.create();
        cats.add(cat);
        return jsonb.toJson(cat);

    }
}
