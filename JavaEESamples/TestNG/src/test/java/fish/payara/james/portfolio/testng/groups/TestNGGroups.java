package fish.payara.james.portfolio.testng.groups;

import org.testng.annotations.Test;

import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;

public class TestNGGroups {
    private static final Logger LOGGER = Logger.getLogger(TestNGGroups.class.getName());

    @Test (groups = "Numbers")
    public void numbersTestOne(){
        LOGGER.info("Running numbers test.");
        int result = 5 + 2;
        assertEquals(7, result);
    }

    @Test(groups = "Strings")
    public void stringsTestOne(){
        LOGGER.info("Running strings test.");
        String name = "James";
        String surname = "Hillyard";
        assertEquals("JamesHillyard", name+surname);
    }
}
