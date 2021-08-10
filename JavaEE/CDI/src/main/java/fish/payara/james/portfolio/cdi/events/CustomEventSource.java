package fish.payara.james.portfolio.cdi.events;

import fish.payara.james.portfolio.cdi.CustomBean;
import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.event.Event;
import jakarta.inject.Inject;

import java.util.function.Supplier;

@Dependent
public class CustomEventSource extends CustomBean {

    private final Supplier<CustomEvent> eventSupplier = () -> new CustomEvent(getRandomInt());

    @Inject
    private Event<CustomEvent> event;

    public void fireRandomEvent() {
        event.fire(eventSupplier.get());
    }

    public void fireAsyncRandomEvent() {
        event.fireAsync(eventSupplier.get());
    }

    public void fireRandomAdminEvent() {
        event.select(CustomEvent.class, new Admin.Literal()) //
                .fire(eventSupplier.get());
    }

}