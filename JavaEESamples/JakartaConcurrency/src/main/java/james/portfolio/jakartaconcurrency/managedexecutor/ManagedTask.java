package james.portfolio.jakartaconcurrency.managedexecutor;

import javax.enterprise.concurrent.ManagedTaskListener;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

public class ManagedTask implements Callable<Long>, javax.enterprise.concurrent.ManagedTask {

    private int id;

    public ManagedTask(int id) {
        this.id = id;
    }

    @Override
    public Long call() throws Exception {
        return new Long(id * 3);
    }

    @Override
    public ManagedTaskListener getManagedTaskListener() {
        return new TaskListener();
    }

    @Override
    public Map<String, String> getExecutionProperties() {
        return new HashMap<>();
    }
}
