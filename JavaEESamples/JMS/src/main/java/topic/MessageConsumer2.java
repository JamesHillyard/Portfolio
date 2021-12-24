package topic;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSDestinationDefinition;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import java.util.logging.Logger;

@JMSDestinationDefinition(
        name="java:global/topic/simpleTopic",
        interfaceName="javax.jms.Topic",
        destinationName = "simpleTopic"
)
@MessageDriven(activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "java:global/topic/simpleTopic"),
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic")
})
public class MessageConsumer2 implements MessageListener {

    private static final Logger LOGGER = Logger.getLogger(MessageConsumer2.class.getName());

    @Override
    public void onMessage(Message message) {
        try {
            System.out.println("Listener 2 Message received: " + message.getBody(String.class));
        } catch (JMSException ex) {
            LOGGER.severe(ex.getMessage());
        }
    }
}
