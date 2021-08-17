package fish.payara.james.portfolio.testng.junitvstestng;

import fish.payara.james.portfolio.testng.junitvstestngUtils.Months;
import fish.payara.james.portfolio.testng.junitvstestngUtils.TestingUtils;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@FixMethodOrder(MethodSorters.DEFAULT)
public class Junit {

    TestingUtils testingUtils = new TestingUtils();

    /**
     * Ignore test
     */
    @Test
    @Disabled
    public void junitFail(){
        assertTrue(false);
    }

    /**
     * Testing a certain exception is thrown from the test
     */
    @Test
    public void junitException(){
        assertThrows(ArithmeticException.class, () -> {int i = 1/0;});
    }

    /**
     * Timeout a test if it takes longer than specified time
     */
    /*
    An issue with JUnit timeout means infinite loops like this don't work with the timeout annotation
    https://github.com/junit-team/junit5/issues/2087

    @Test
    @Timeout(2)
    public void testngTimeout(){
        while (true);
    }
     */

    @Test
    @Timeout(2)
    public void junitTimeout() throws InterruptedException {
        Thread.sleep(3000);
    }

    /**
     * Test with parameters.
     */
    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, -3, 15, Integer.MAX_VALUE})
    public void junitParameters(int number){
        assertTrue(number % 2 != 0);
    }

    @ParameterizedTest
    @NullSource
    public void junitNullParameter(Object param){
        assertNull(param);
    }

    @ParameterizedTest
    @EnumSource(
            value = Months.class,
            names = ".+BER",
            mode = EnumSource.Mode.MATCH_ANY)
    public void junitEnumParameter(Months month){
        assertNotNull(month);
        assertTrue(String.valueOf(month).endsWith("BER"));
    }

    /**
     * Those sources make it hard to provide complex objects. Method source can solve that
     */

    @ParameterizedTest
    @MethodSource("TestingUtils#numberData")
    public void junitMethodParameter(int a, int b, int result){
        int sum = a + b;
        assertEquals(result, sum);
    }

}
