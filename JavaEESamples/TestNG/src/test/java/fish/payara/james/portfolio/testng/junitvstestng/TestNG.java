package fish.payara.james.portfolio.testng.junitvstestng;

import fish.payara.james.portfolio.testng.DP;
import org.testng.annotations.*;
import org.testng.internal.thread.ThreadTimeoutException;

import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TestNG {

    private static final Logger LOGGER = Logger.getLogger(TestNG.class.getName());
    private static final String EMAIL = "james.hillyard@payara.fish";

    /**
     * Ignore test
     */
    @Test(groups = "testngShowcase")
    @Ignore
    public void testngFail(){
        assertTrue(false);
    }

    /**
     * Testing a certain exception is thrown from the test
     */
    @Test(groups =  "testngShowcase", expectedExceptions = ArithmeticException.class)
    public void testngException(){
        int i = 1/0;
    }

    /**
     * Timeout a test if it takes longer than specified time
     */
    @Test(groups =  "testngShowcase", timeOut = 1000, expectedExceptions = ThreadTimeoutException.class)
    public void testngTimeout(){
        while (true);
    }

    /**
     * Test with parameters. TestNG doesn't support null as a parameter
     */
    @Test(groups = "testngShowcase")
    @Parameters({"myName", "myList"})
    public void testngParameters(String myName, String myList){
        String[] list = myList.split(",");
        assertEquals(myName, "James");
        assertTrue(list[1].trim().equals("Orange"));
    }

    @Test(groups =  "testngShowcase")
    @Parameters({"mango"})
    public void fruitNames(@Optional("orange") String fruit){
        assertTrue(fruit.equals("mango"));
    }

    /**
     * Those sources make it hard to provide complex objects. Method source can solve that
     */

    @DataProvider(name = "numberData")
    public static Object[][] testData(){
        return new Object[][] {{2, 3 , 5}, {5, 7, 12}};
    }

    @Test(groups =  "testngShowcase", dataProvider = "numberData")
    public void testngMethodParameter(int a, int b, int result){
        int sum = a + b;
        assertEquals(result, sum);
    }

    @Test(groups =  "testngShowcase", dataProvider = "data-provider", dataProviderClass = DP.class)
    public void testngMethodParameter(String value){
        assertEquals("First-Value", value);
    }

    /**
     * TestNG supports dependency testing. This means in a set of test methods, if the initial test fails,
     * all subsequent dependent tests will be skipped, not marked as failed as in the case for JUnit.
     */

    @Test(groups =  "testngShowcase")
    public void checkEmailIsValidTest(){
        assertTrue(EMAIL.contains("@"));
    }

    @Test(groups =  "testngShowcase", dependsOnMethods = "checkEmailIsValidTest")
    public void useEmailToLoginTest(){
        LOGGER.info("Logged in");
    }

    /**
     * TestNG allows tests to be given a priority so they are executed in a deterministic order.
     * This only causes them to invoke in a set order. It does not guarantee that tests in one level are completed
     * before invoking the next priority level.
     */

    @Test(groups =  "testngShowcase", priority = -1)
    public void lowPriorityTest(){
        LOGGER.info("Priority: -1");
    }

    @Test(groups =  "testngShowcase", priority = 5)
    public void highPriorityTest(){
        LOGGER.info("Priority: 5");
    }



}
