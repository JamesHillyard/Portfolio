package fish.payara.james.portfolio.testng.groups;

import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;

public class TestNGGroups {

    @Test (groups = "Numbers")
    public void numbersTestOne(){
        int result = 5 + 2;
        assertEquals(7, result);
    }

    @Test(groups = "Strings")
    public void stringsTestOne(){
        String name = "James";
        String surname = "Hillyard";
        assertEquals("JamesHillyard", name+surname);
    }
}
