package jsonb_objects;

import org.junit.jupiter.api.Test;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomInstantiationTest {
    private final Jsonb JSONB = JsonbBuilder.create();
    private final String jsonHouse = "{\"Number Of Rooms\":5,\"Roof Colour\":\"Red\",\"Property Value\":234000.0}";

    @Test
    void instantiationTest() {
        House house = JSONB.fromJson(jsonHouse, House.class);
        assertEquals(5, house.getNumberOfRooms());
        assertEquals("Red", house.getRoofColour());
        assertEquals(234000.00, house.getValue());
    }
}
