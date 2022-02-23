package batch.batchlet;

import javax.batch.operations.JobOperator;
import javax.batch.runtime.BatchRuntime;
import javax.ejb.Schedule;
import javax.ejb.Stateless;

@Stateless
public class BatchSchedule {

    JobOperator jobOperator = BatchRuntime.getJobOperator();

    @Schedule(second = "*/30", minute = "*", hour = "*", persistent = false) // Thirty second intervals
    public void runBatchJob() {
        jobOperator.start("batch-jobs", null);
    }


}
