package james.portfolio.jakartaconcurrency.managedexecutor;

import javax.enterprise.concurrent.ManagedExecutorService;
import javax.enterprise.concurrent.ManagedTaskListener;
import java.util.concurrent.Future;
import java.util.logging.Logger;

public class TaskListener implements ManagedTaskListener {

    private final Logger LOGGER = Logger.getLogger(TaskListener.class.getName());

    @Override
    public void taskSubmitted(Future<?> future, ManagedExecutorService managedExecutorService, Object o) {
        LOGGER.info("Task submitted");
    }

    @Override
    public void taskAborted(Future<?> future, ManagedExecutorService managedExecutorService, Object o, Throwable throwable) {
        LOGGER.warning("Task aborted");
    }

    @Override
    public void taskDone(Future<?> future, ManagedExecutorService managedExecutorService, Object o, Throwable throwable) {
        LOGGER.info("Task finished");
    }

    @Override
    public void taskStarting(Future<?> future, ManagedExecutorService managedExecutorService, Object o) {
        LOGGER.info("Task starting");
    }
}
