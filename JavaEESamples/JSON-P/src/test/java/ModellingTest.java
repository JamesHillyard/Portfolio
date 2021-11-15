import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonPointer;
import javax.json.JsonReader;
import java.io.StringReader;

import static org.junit.jupiter.api.Assertions.*;

public class ModellingTest {

    String jsonName;

    @BeforeEach
    void setUp() {
        jsonName = "{\"name\":\"james\"}";
    }

    @Test
    void createObject() {
        JsonObject jsonObject = Json.createObjectBuilder()
                .add("name", "James")
                .add("age", 19)
                .add("skills",
                        Json.createArrayBuilder()
                                .add("JSON-P")
                                .add("JSON-B")
                                .build())
                .add("address",
                        Json.createObjectBuilder()
                                .add("HouseNo", 12)
                                .add("Street", "PStreet")
                                .build())
                .build();
        assertEquals("\"name\":\"James\",\"age\":19,\"skills\":[\"JSON-P\",\"JSON-B\"],\"address\":{\"HouseNo\":12,\"Street\":\"PStreet\"}", jsonObject);
    }

    @Test
    void readJSON() {
        JsonReader jsonReader = Json.createReader(new StringReader(jsonName));
        JsonObject jsonObject = jsonReader.readObject();
        assertEquals("{\"name\":\"james\"}", jsonObject.toString());
    }

    @Test
    void jsonPointer() {
        String jsonString = "{\"name\":\"James\",\"age\":19,\"skills\":[\"JSON P\", \"JSON B\"]}";

        JsonObject jsonObject = Json.createReader(new StringReader(jsonString)).readObject();

        JsonPointer arrayElementPointer = Json.createPointer("/skills/1");
        JsonPointer agePointer = Json.createPointer("/age");
        JsonPointer namePointer = Json.createPointer("/name");
        JsonPointer addressPointer = Json.createPointer("/address");
        JsonPointer tagsPointer = Json.createPointer("/tags");

        //Gets data at arrayElementPointer
        assertEquals("\"JSON B\"", arrayElementPointer.getValue(jsonObject).toString());

        //Removes data at agePointer
        JsonObject jsonObjectAgeRemoved = agePointer.remove(jsonObject);
        assertFalse(jsonObjectAgeRemoved.toString().contains("age"));


        //Replaces data at namePointer
        JsonObject jsonObjectNameReplaced = namePointer.replace(jsonObject, Json.createValue("John"));
        assertTrue(jsonObjectNameReplaced.toString().contains("John"));

        //Checks if jsonObject contains value defined in address pointer
        assertFalse(addressPointer.containsValue(jsonObject));

        //Check tags are added to json object
        JsonObject jsonObjectAddedTags = tagsPointer.add(jsonObject, Json.createArrayBuilder().add("nice").build());
        assertTrue(jsonObjectAddedTags.toString().contains("nice"));
    }
}
