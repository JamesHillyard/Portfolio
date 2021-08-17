package fish.payara.james.portfolio.testng.testngannotations;

import org.testng.annotations.*;

import java.util.logging.Logger;

public class Annotations {
    private static final Logger LOGGER = Logger.getLogger(Annotations.class.getName());

    /**
     * @BeforeSuite
     * @BeforeTest
     * @BeforeClass
     * @BeforeMethod
     * @Test
     * @AfterMethod
     * @AfterClass
     * @AfterTest
     * @AfterSuite
     */

    @BeforeSuite
    public void testngBeforeSuite(){
        LOGGER.info("Before Suite");
    }

    @AfterSuite
    public void testngAfterSuite(){
        LOGGER.info("After Suite");
    }

    @BeforeTest
    public void testngBeforeTest(){
        LOGGER.info("Before Test");
    }

    @AfterTest
    public void testngAfterTest(){
        LOGGER.info("After Test");
    }

    @BeforeClass
    public void testngBeforeClass(){
        LOGGER.info("Before Class");
    }

    @AfterClass
    public void testngAfterClass(){
        LOGGER.info("After Class");
    }

    @BeforeMethod
    public void testngBeforeMethod(){
        LOGGER.info("Before Method");
    }

    @AfterMethod
    public void testngAfterMethod(){
        LOGGER.info("After Method");
    }

    @BeforeGroups
    public void testngBeforeGroups(){
        LOGGER.info("Before Groups");
    }

    @AfterGroups
    public void testngAfterGroups(){
        LOGGER.info("After Groups");
    }

    @Test(groups = "testngShowcase")
    public void sampleTest(){
        LOGGER.severe("Running test");
    }
}
