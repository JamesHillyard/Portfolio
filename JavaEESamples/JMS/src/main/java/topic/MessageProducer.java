package topic;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.Topic;
import java.util.Date;

@Stateless
@LocalBean
public class MessageProducer {

    @Inject
    JMSContext context;

    @Resource(lookup = "java:global/topic/simpleTopic")
    Topic topic;

    public void sendMessage(String msg) {
        context.createProducer().send(topic, msg);
    }

    @Schedule(dayOfMonth = "*", dayOfWeek = "*", hour = "*", minute = "*", second = "*/5", persistent = false)
    public void myTimer() {
        sendMessage(new Date().toString());
    }
}
