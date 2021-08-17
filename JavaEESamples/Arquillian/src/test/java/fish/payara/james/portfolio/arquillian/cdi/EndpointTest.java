package fish.payara.james.portfolio.arquillian.cdi;

import cdi.CdiBean;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Logger;

import static javax.ws.rs.core.Response.Status.OK;
import static org.jboss.shrinkwrap.api.ShrinkWrap.create;
import static org.junit.Assert.assertEquals;

@RunWith(Arquillian.class)
public class EndpointTest {

    private static final Logger LOGGER = Logger.getLogger(EndpointTest.class.getName());

    @Deployment
    public static WebArchive createDeployment() {
        return create(WebArchive.class, "arquillian-test.war")
                .addPackage(CdiBean.class.getPackage())
                .addAsWebInfResource("web.xml");
    }

    @ArquillianResource
    private URL baseUrl;

    @Inject
    CdiBean bean;

    private HttpURLConnection connection;

    @Before
    public void configureConnection() throws IOException {
        connection = (HttpURLConnection) baseUrl.openConnection();
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

}