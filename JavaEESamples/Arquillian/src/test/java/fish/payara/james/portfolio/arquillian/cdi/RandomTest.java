package fish.payara.james.portfolio.arquillian.cdi;

import cdi.RandomNumberGenerator;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

import static org.jboss.shrinkwrap.api.ShrinkWrap.create;
import static org.junit.Assert.assertTrue;

@RunWith(Arquillian.class)
public class RandomTest {
    @Deployment
    public static WebArchive createDeployment() {
        return create(WebArchive.class, "arquillian-test.war")
                .addPackage(RandomNumberGenerator.class.getPackage())
                .addAsWebInfResource("web.xml");
    }

    @Inject
    RandomNumberGenerator randomNumberGenerator;

    @Test
    public void shouldGenerateRandomNumber() {
        int randomNumber = randomNumberGenerator.getRandomNumber();
        assertTrue(randomNumber >= 0);
        assertTrue(randomNumber <= 100);
    }
}
