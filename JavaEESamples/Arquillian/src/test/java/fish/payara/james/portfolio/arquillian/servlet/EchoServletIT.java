package fish.payara.james.portfolio.arquillian.servlet;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;

import static org.junit.Assert.assertEquals;

@RunWith(Arquillian.class)
public class EchoServletIT {
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(EchoServlet.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @ArquillianResource
    URL deploymentUrl;

    @Test
    public void echoServletTest() throws Exception {
        String requestUrl = deploymentUrl + "echo?" + EchoServlet.MESSAGE_PARAM + "=hello";
        String body = readAll(new URL(requestUrl).openStream());

        assertEquals("Verify that the servlet was deployed and returns expected result", "hello", body);
    }

    public static String readAll(InputStream is) throws Exception {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int read;
        while ((read = is.read()) != -1) {
            out.write(read);
        }
        return out.toString();
    }

}
