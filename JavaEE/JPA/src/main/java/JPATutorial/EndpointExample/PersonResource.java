package JPATutorial.EndpointExample;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import java.io.IOException;
import java.util.List;

@Stateless
@Path("/person")
public class PersonResource {

    @Inject
    private PersonDAO personDao;

    @GET
    @Produces("application/json")
    public List<Person> all() {
        return personDao.getAll();
    }

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Person byId(@PathParam("id") Long id){
        return personDao.find(id);
    }

    //This won't allow us to submit a JSON array
    @POST
    @Consumes("application/json")
    public void save(Person person) {
        personDao.save(person);
    }

    @POST
    @Consumes("application/json")
    @Path("/multiple")
    public void saveMultiple(String persons) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Person> p = objectMapper.readValue(persons, new TypeReference<List<Person>>(){});
        p.forEach(person -> personDao.save(person));
    }

    @PUT
    @Consumes("application/json")
    public void update(Person person) {
        personDao.update(person);
    }

    @DELETE
    @Path("/{id}")
    @Consumes("application/json")
    public void delete(@PathParam("id") Long id) {
        Person person = personDao.find(id);
        personDao.delete(person);
    }
}