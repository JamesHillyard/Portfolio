package batch.chunk;

import javax.batch.api.Batchlet;
import javax.batch.runtime.context.JobContext;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.File;
import java.util.logging.Logger;

import static batch.Constants.JAMES_CHUNK_DATA_PATH;

@Dependent
@Named("MyBatchlet")
public class MyBatchlet implements Batchlet {

    private static final Logger LOGGER = Logger.getLogger(MyBatchlet.class.getName());

    @Inject
    JobContext jobContext;

    @Override
    public String process() throws Exception {
        String fileName = jobContext.getProperties().getProperty("output_file");
        LOGGER.info(String.valueOf(new File(JAMES_CHUNK_DATA_PATH+fileName).length()));
        return "COMPLETED";
    }

    @Override
    public void stop() throws Exception {

    }
}
