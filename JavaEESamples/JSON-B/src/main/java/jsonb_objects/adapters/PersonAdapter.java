package jsonb_objects.adapters;

import jsonb_objects.Person;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.bind.adapter.JsonbAdapter;

public class PersonAdapter implements JsonbAdapter<Person, JsonObject> {
    @Override
    public JsonObject adaptToJson(Person person) throws Exception {
        return Json.createObjectBuilder()
                .add("Name", person.getName())
                .add("Profession", person.getProfession())
                .build();
    }

    @Override
    public Person adaptFromJson(JsonObject jsonObject) throws Exception {
        Person person = new Person();
        person.setName(jsonObject.getString("Name"));
        person.setProfession(jsonObject.getString("Profession"));
        return person;
    }
}
