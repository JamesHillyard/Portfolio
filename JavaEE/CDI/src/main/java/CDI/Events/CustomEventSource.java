package CDI.Events;

import java.util.function.Supplier;

import CDI.CustomBean;
import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.event.Event;
import jakarta.inject.Inject;

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