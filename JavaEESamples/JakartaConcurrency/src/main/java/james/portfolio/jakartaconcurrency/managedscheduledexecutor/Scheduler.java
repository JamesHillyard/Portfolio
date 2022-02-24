package james.portfolio.jakartaconcurrency.managedscheduledexecutor;

import james.portfolio.jakartaconcurrency.MyJob;

import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedScheduledExecutorService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@Path("concurrency")
public class Scheduler {

    @Resource(name = "managedScheduledExecutorService")
    ManagedScheduledExecutorService executorService;

    @GET
    @Path("schedule")
    @Produces(MediaType.TEXT_PLAIN)
    public String scheduleTask() throws InterruptedException, ExecutionException {
        Future future = executorService.schedule(new MyJob(5), 3, TimeUnit.SECONDS);
        while (true) {
            if (future.isDone()) {
                break;
            } else {
                System.out.println("Checking Callable Future, waiting for 1 sec");
                Thread.sleep(1000);
            }
        }
        return "Callable Task completed: " + future.isDone();
    }
}
