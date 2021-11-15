package jsonb_objects;

import org.junit.jupiter.api.Test;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;

import static org.junit.jupiter.api.Assertions.*;

public class JsonTransientTest {

    private Jsonb jsonb = JsonbBuilder.create(new JsonbConfig().withNullValues(true));

    @Test
    public void JSONTransient(){
        Car car = new Car(1, 3, 2010, "blue");
        String jsonCar = jsonb.toJson(car);
        assertFalse(jsonCar.contains("yearManufactured"));
        assertEquals("{\"engineSize\":1.0,\"numberOfDoors\":3}", jsonCar);

        /**
         * As Car colour's getter is transient, the colour property isn't serialized and so will be null once the object
         * is deserialized.
         */
        car = jsonb.fromJson(jsonCar, Car.class);
        assertNull(car.colour);
        assertNotNull(car.numberOfDoors);
    }
}
