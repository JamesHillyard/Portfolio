package fish.payara.james.portfolio.arquillian.cdi;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;

import static javax.ws.rs.core.Response.Status.OK;
import static org.jboss.shrinkwrap.api.ShrinkWrap.create;
import static org.junit.Assert.assertEquals;

@RunWith(Arquillian.class)
public class EndpointIT {

    private static final Logger LOGGER = Logger.getLogger(EndpointIT.class.getName());

    public EndpointIT() throws MalformedURLException {
    }

    @Deployment
    public static WebArchive createDeployment() {
        return create(WebArchive.class, "arquillian-test.war")
                .addPackage(CdiBean.class.getPackage())
                .addAsWebInfResource("web.xml");
    }

    @Inject
    CdiBean bean;

    private HttpURLConnection connection;
    private HttpURLConnection largeIncrementConnection;
    private final URL BASE_URL = new URL("http://localhost:8181/arquillian-test");

    @Before
    public void configureConnection() throws IOException {
        connection = (HttpURLConnection) new URL(BASE_URL+"/beanCounter").openConnection();
        largeIncrementConnection = (HttpURLConnection) new URL(BASE_URL+"/largeIncrement").openConnection();
    }

    @Test
    public void testCdiBeanInjection() throws IOException {
        assertEquals(OK.getStatusCode(), connection.getResponseCode());
    }

    @Test
    public void testEndpointIncrement() throws IOException {
        assertEquals(200, connection.getResponseCode());
        assertEquals(1, bean.getCounter());
    }

    @Test
    public void largeIncrementTest() throws IOException {
        assertEquals(200, largeIncrementConnection.getResponseCode());
        assertEquals(100, bean.getCounter());
    }

}