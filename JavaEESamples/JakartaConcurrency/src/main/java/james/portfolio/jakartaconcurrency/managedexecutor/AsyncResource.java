package james.portfolio.jakartaconcurrency.managedexecutor;

import james.portfolio.jakartaconcurrency.MyJob;

import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import java.time.LocalDateTime;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Path("concurrency")
@RequestScoped
public class AsyncResource {

    @Context
    private UriInfo uriInfo;

    @Resource
    private ManagedExecutorService managedExecutorService;

    @GET
    @Path("simpleJob")
    @Produces(MediaType.TEXT_PLAIN)
    public String simpleJob() {
        managedExecutorService.submit(new MyJob(1));
        return "Job Submitted";
    }

    @GET
    @Path("parallelJob")
    @Produces(MediaType.TEXT_PLAIN)
    public String runParallelJob() throws ExecutionException {
        Future future1 = managedExecutorService.submit(() -> {
            new MyJob(2);
            sleep(350);
            System.out.println("Job 1 finished at " + LocalDateTime.now());
        });
        Future future2 = managedExecutorService.submit(() -> {
            new MyJob(3);
            System.out.println("Job 2 finished at " + LocalDateTime.now());
        });

        return "Jobs completed";
    }

    @GET
    @Path("listener")
    @Produces(MediaType.TEXT_PLAIN)
    public String runListenerJob() throws Exception {
        Future<Long> futureResult = managedExecutorService.submit(new ManagedTask(5));
        while (!futureResult.isDone()) {
            try {
                System.out.println("Waiting");
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            System.out.println("Callable Task returned " + futureResult.get());
        } catch (Exception e) {
            return e.getMessage();
        }
        return "Job executed successfully";
    }


    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (Exception e) {

        }
    }
}
