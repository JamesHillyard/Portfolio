package fish.payara.james.portfolio.testng.sample;

import org.testng.annotations.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ClusterJspTest {

    private HttpURLConnection connection;
    private HttpURLConnection clusterJspConnection;

    @BeforeClass(alwaysRun = true)
    public void setupWebClient() throws IOException {
        URL url = new URL("http://localhost:8080");
        URL clusterjspUrl = new URL("http://localhost:8080/clusterjsp");
        connection = (HttpURLConnection) url.openConnection();
        clusterJspConnection = (HttpURLConnection) clusterjspUrl.openConnection();
        connection.setRequestMethod("GET");
        clusterJspConnection.setRequestMethod("GET");

    }

    @BeforeMethod
    public void checkPayaraIsRunning() throws IOException {
        assertEquals(connection.getResponseCode(), 200);
    }

    @Test(groups = "testngShowcase")
    public void checkClusterJspIsDeployed() throws IOException {
        setupWebClient();
        assertEquals(clusterJspConnection.getResponseCode(), 200);
    }

    @Test(groups = "testngShowcase", dependsOnMethods = "checkClusterJspIsDeployed")
    @Parameters("executedServer")
    public void checkResponseBody(String computerName){
        String response = getPage();
        assertTrue(response.contains(computerName));
    }

    @AfterClass
    public void after(){
        clusterJspConnection.disconnect();
        connection.disconnect();
    }

    public String getPage() {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader((clusterJspConnection.getInputStream())));
            StringBuilder sb = new StringBuilder();
            String output;
            while ((output = br.readLine()) != null) {
                sb.append(output);
            }
            return sb.toString();
        } catch (IOException ex){
            return null;
        }

    }



}
