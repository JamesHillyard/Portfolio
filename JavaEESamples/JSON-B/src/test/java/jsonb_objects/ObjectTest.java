package jsonb_objects;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ObjectTest {
    private Dog dog;
    private Dog secondDog;
    private List<Dog> dogs;
    private Person person;
    private Jsonb jsonb = JsonbBuilder.create(new JsonbConfig().withNullValues(true));

    @BeforeEach
    void setUp() {
        dog = new Dog("Lime", 4, false);
        secondDog = new Dog("Lemon", 6, true);
        dogs = new ArrayList<>();

        person = new Person("Mike", "Chef", 15.99);

    }

    @Test
    public void JSONObjectTest() {
        // Create Jsonb and serialize
        String jsonDog = jsonb.toJson(dog);
        assertEquals("{\"age\":4,\"bitable\":false,\"name\":\"Lime\"}", jsonDog);

        // Deserialize Back
        dog = jsonb.fromJson(jsonDog, Dog.class);
        assertEquals(4, dog.age);
        assertEquals("Lime", dog.name);
        assertFalse(dog.bitable);
    }

    @Test
    public void JSONCollectionTest() {
        // Create Jsonb and serialize
        dogs.addAll(Arrays.asList(dog, secondDog));
        String jsonDogsCollection = jsonb.toJson(dogs);
        assertEquals("[{\"age\":4,\"bitable\":false,\"name\":\"Lime\"},{\"age\":6,\"bitable\":true,\"name\":\"Lemon\"}]",
                jsonDogsCollection);

        // Deserialize Back
        dogs = jsonb.fromJson(jsonDogsCollection, new ArrayList<Dog>(){}.getClass().getGenericSuperclass());
        assertEquals(6, dogs.get(1).age);
    }

    @Test
    public void JSONPropertyTest(){
        String jsonPerson = jsonb.toJson(person);
        assertTrue(jsonPerson.contains("Forename") && jsonPerson.contains("profession"));
        assertFalse(jsonPerson.contains("name") && jsonPerson.contains("salary"));
    }
}