package fish.payara.james.portfolio.cdi.Events;

import fish.payara.james.portfolio.cdi.events.CustomEventReceiver;
import fish.payara.james.portfolio.cdi.events.CustomEventSource;
import jakarta.inject.Inject;
import org.jboss.weld.junit5.auto.EnableAutoWeld;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@EnableAutoWeld
public class EventsTest {

    @Inject
    private CustomEventSource source;

    @Inject
    private CustomEventReceiver receiver;

    @Test
    public void testEvent() {
        source.fireRandomEvent();
        assertEquals(1, receiver.getEventsReceived(), "Normal event not received");
    }

    @Test
    public void testAdminEvent() {
        source.fireRandomAdminEvent();
        assertEquals(1, receiver.getAdminEventsReceived(), "Admin event not received");
    }

}