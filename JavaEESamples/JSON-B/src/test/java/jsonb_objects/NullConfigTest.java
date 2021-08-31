package jsonb_objects;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;

import static org.junit.jupiter.api.Assertions.*;

public class NullConfigTest {
    /**
     * Using a JsonbConfig we can set the JsonbBuilder to still create null values in the JSON formatting.
     * Without this they will simply be ignored.
     */
    private Dog dog;

    JsonbConfig nillableConfig = new JsonbConfig().withNullValues(true);
    Jsonb jsonbWithNull = JsonbBuilder.create(nillableConfig);
    Jsonb jsonb = JsonbBuilder.create();

    @BeforeEach
    void setUp() {
        dog = new Dog(null, 3, false);
    }

    @Test
    public void nullValuesConfigTest() {
        String nullJsonDog = jsonbWithNull.toJson(dog);
        String jsonDog = jsonb.toJson(dog);

        assertTrue(nullJsonDog.contains("\"name\":null"));
        assertFalse(jsonDog.contains("\"name\""));
    }

    @Test
    public void nullValuesPropertyTest(){
        NullDog nullDog = new NullDog(null, 3, false, null);
        String jsonDog = jsonb.toJson(nullDog);
        assertEquals("{\"age\":3,\"bitable\":false,\"collarColour\":null}", jsonDog);
    }
}
