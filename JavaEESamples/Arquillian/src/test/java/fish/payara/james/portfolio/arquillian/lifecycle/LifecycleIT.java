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

@RunWith(Arquillian.class)
public class LifecycleIT {

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @BeforeDeploy
    public void doBeforeDeploy() {
        System.out.println("@BeforeDeploy");
    }

    @AfterDeploy
    public void doAfterDeploy() {
        System.out.println("@AfterDeploy");
    }

    @BeforeUnDeploy
    public void doBeforeUnDeploy() {
        System.out.println("@BeforeUnDeploy");
    }

    @AfterUnDeploy
    public void doAfterUnDeploy() {
        System.out.println("@AfterUnDeploy");
    }

    @Test
    public void shouldBeAbleToOne() {
        System.out.println("@Test - 1");
    }

    @Test
    public void shouldBeAbleToTwo() {
        System.out.println("@Test - 2");
    }
}
