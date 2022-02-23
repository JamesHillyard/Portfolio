package batch.chunk;

import javax.batch.operations.JobOperator;
import javax.batch.runtime.BatchRuntime;
import javax.ejb.Schedule;
import javax.ejb.Stateless;

@Stateless
public class ChunkSchedule {

    JobOperator jobOperator = BatchRuntime.getJobOperator();

    @Schedule(second = "*/30", minute = "*", hour = "*", persistent = false) // Thirty second intervals
    public void runBatchJob() {
        jobOperator.start("chunk-jobs", null);
    }


}
