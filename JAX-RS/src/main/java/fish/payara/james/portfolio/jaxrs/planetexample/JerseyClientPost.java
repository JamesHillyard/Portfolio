package fish.payara.james.portfolio.jaxrs.planetexample;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class JerseyClientPost {

    public static void main(String[] args) {

        try {
            Client client = Client.create();

            WebResource webResource = client.resource("http://localhost:8080/tutorial/planet");
            String input = "{\"id\":\"10\",\"name\":\"Jupiter\",\"radius\":\"10.3\"}";
            ClientResponse response = webResource.type("application/json").post(ClientResponse.class, input);
            if (response.getStatus() != 201) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + response.getStatus());
            }

            String output = response.getEntity(String.class);
            System.out.println(output);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
