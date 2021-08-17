package fish.payara.james.portfolio.testng.assertions;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

public class Assertions {

    @Test(groups = "testngShowcase")
    public void assertEqual(){
        List<String> fruits = Arrays.asList("Banana", "Pineapple", "Orange");
        Object object = null;

        assertTrue(fruits.contains("Orange"));
        assertFalse(fruits.contains("Lime"));
        assertEquals(fruits.get(0), "Banana", "Banana should be at index 0.");
        assertNull(object);
        assertNotNull(new Object());
    }

}
