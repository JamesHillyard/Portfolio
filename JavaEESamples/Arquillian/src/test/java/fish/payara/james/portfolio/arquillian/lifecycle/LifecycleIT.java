package fish.payara.james.portfolio.arquillian.lifecycle;

import fish.payara.james.portfolio.arquillian.lifecycle.api.AfterDeploy;
import fish.payara.james.portfolio.arquillian.lifecycle.api.AfterUnDeploy;
import fish.payara.james.portfolio.arquillian.lifecycle.api.BeforeDeploy;
import fish.payara.james.portfolio.arquillian.lifecycle.api.BeforeUnDeploy;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.logging.Logger;

@RunWith(Arquillian.class)
public class LifecycleIT {

    private static final Logger LOGGER = Logger.getLogger(LifecycleIT.class.getName());

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @BeforeDeploy
    public void doBeforeDeploy() {
        LOGGER.info("@BeforeDeploy");
    }

    @AfterDeploy
    public void doAfterDeploy() {
        LOGGER.info("@AfterDeploy");
    }

    @BeforeUnDeploy
    public void doBeforeUnDeploy() {
        LOGGER.info("@BeforeUnDeploy");
    }

    @AfterUnDeploy
    public void doAfterUnDeploy() {
        LOGGER.info("@AfterUnDeploy");
    }

    @Test
    public void shouldBeAbleToOne() {
        LOGGER.severe("@Test - 1");
    }

    @Test
    public void shouldBeAbleToTwo() {
        LOGGER.severe("@Test - 2");
    }
}
