package batch.batchlet;

import javax.batch.api.Batchlet;
import javax.batch.runtime.context.JobContext;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

@Dependent
@Named("SimpleBatchlet")
public class SimpleBatchlet implements Batchlet {

    private static final Logger LOGGER = Logger.getLogger(SimpleBatchlet.class.getName());

    @Inject
    private JobContext jobCtx;

    @Override
    public String process() throws Exception {
        String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        LOGGER.info("Processed at "+timestamp);
        return "DONE";
    }

    @Override
    public void stop() throws Exception {

    }
}
