package jsonb_objects.adapters;

import jsonb_objects.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PersonAdapterTest {
    private Person person;
    private Jsonb jsonb = JsonbBuilder.create();

    private JsonbConfig jsonbConfig = new JsonbConfig().withAdapters(new PersonAdapter());
    private Jsonb jsonbAdapter = JsonbBuilder.create(jsonbConfig);

    @BeforeEach
    void setUp() {
        person = new Person("Mike", "Chef", 13.50);
    }

    @Test
    void jsonPersonWithoutAdapter() {
        assertEquals("{\"Forename\":\"Mike\",\"Yearly-Income\":13.5,\"profession\":\"Chef\"}", jsonb.toJson(person));
    }

    /**
     * Deserialising with an adapter will override any annotations changing the Json Naming in the main class
     */
    @Test
    void jsonPersonWithAdapter() {
        assertEquals("{\"Name\":\"Mike\",\"Profession\":\"Chef\"}", jsonbAdapter.toJson(person));
    }

}