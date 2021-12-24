package queue;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.Queue;
import java.util.Date;

@Stateless
@LocalBean
public class MessageProducer {

    @Inject
    JMSContext context;

    @Resource(lookup = "java:global/queue/simpleQ")
    Queue queue;

    public void sendMessage(String msg) {
        context.createProducer().send(queue, msg);
    }

    @Schedule(dayOfMonth = "*", dayOfWeek = "*", hour = "*", minute = "*", second = "*/5", persistent = false)
    public void myTimer() {
        sendMessage(new Date().toString());
    }
}
