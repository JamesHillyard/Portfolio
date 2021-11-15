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

    @BeforeSuite(groups = "annotations")
    public void testngBeforeSuite(){
        LOGGER.info("Before Suite");
    }

    @AfterSuite(groups = "annotations")
    public void testngAfterSuite(){
        LOGGER.info("After Suite");
    }

    @BeforeTest(groups = "annotations")
    public void testngBeforeTest(){
        LOGGER.info("Before Test");
    }

    @AfterTest(groups = "annotations")
    public void testngAfterTest(){
        LOGGER.info("After Test");
    }

    @BeforeClass(groups = "annotations")
    public void testngBeforeClass(){
        LOGGER.info("Before Class");
    }

    @AfterClass(groups = "annotations")
    public void testngAfterClass(){
        LOGGER.info("After Class");
    }

    @BeforeMethod(groups = "annotations")
    public void testngBeforeMethod(){
        LOGGER.info("Before Method");
    }

    @AfterMethod(groups = "annotations")
    public void testngAfterMethod(){
        LOGGER.info("After Method");
    }

    @BeforeGroups(groups = "annotations")
    public void testngBeforeGroups(){
        LOGGER.info("Before Groups");
    }

    @AfterGroups(groups = "annotations")
    public void testngAfterGroups(){
        LOGGER.info("After Groups");
    }

    @Test(groups = "annotations")
    public void sampleTest(){
        LOGGER.severe("Running test");
    }
}
