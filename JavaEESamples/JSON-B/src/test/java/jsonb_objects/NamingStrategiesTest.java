package jsonb_objects;

import org.junit.jupiter.api.*;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;
import javax.json.bind.config.PropertyNamingStrategy;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class NamingStrategiesTest {
    private Car car;
    private JsonbConfig config;
    private Jsonb jsonb;
    private static int i = 1;

    @BeforeEach
    void setUp() {
        car = new Car(1.2, 5);
        switch (i) {
            case 1:
                config = new JsonbConfig()
                        .withPropertyNamingStrategy(PropertyNamingStrategy.IDENTITY);
                break;

            case 2:
                config = new JsonbConfig()
                        .withPropertyNamingStrategy(PropertyNamingStrategy.LOWER_CASE_WITH_DASHES);
                break;

            case 3:
                config = new JsonbConfig()
                        .withPropertyNamingStrategy(PropertyNamingStrategy.LOWER_CASE_WITH_UNDERSCORES);
                break;

            case 4:
                config = new JsonbConfig()
                        .withPropertyNamingStrategy(PropertyNamingStrategy.UPPER_CAMEL_CASE);
                break;

            case 5:
                config = new JsonbConfig()
                        .withPropertyNamingStrategy(PropertyNamingStrategy.UPPER_CAMEL_CASE_WITH_SPACES);
                break;

            case 6:
                config = new JsonbConfig()
                        .withPropertyNamingStrategy(PropertyNamingStrategy.CASE_INSENSITIVE);
                break;

        }
        i++;
        jsonb = JsonbBuilder.create(config);
    }

    @Test
    @Order(1)
    void identityNamingStrategyTest() {
        String jsonCar = jsonb.toJson(car);
        assertEquals("{\"engineSize\":1.2,\"numberOfDoors\":5}", jsonCar);
    }

    @Test
    @Order(2)
    void lowerCaseWithDashesNamingStrategyTest() {
        String jsonCar = jsonb.toJson(car);
        assertEquals("{\"engine-size\":1.2,\"number-of-doors\":5}", jsonCar);
    }

    @Test
    @Order(3)
    void lowerCaseWithUnderscoresNamingStrategyTest() {
        String jsonCar = jsonb.toJson(car);
        assertEquals("{\"engine_size\":1.2,\"number_of_doors\":5}", jsonCar);
    }

    @Test
    @Order(4)
    void upperCamelCaseNamingStrategyTest() {
        String jsonCar = jsonb.toJson(car);
        assertEquals("{\"EngineSize\":1.2,\"NumberOfDoors\":5}", jsonCar);
    }

    @Test
    @Order(5)
    void upperCamelCaseWithSpacesNamingStrategyTest() {
        String jsonCar = jsonb.toJson(car);
        assertEquals("{\"Engine Size\":1.2,\"Number Of Doors\":5}", jsonCar);
    }

    @Test
    @Order(6)
    void caseInsensitiveNamingStrategyTest() {
        String jsonCar = jsonb.toJson(car);
        assertEquals("{\"engineSize\":1.2,\"numberOfDoors\":5}", jsonCar);
    }
}
