package batch.chunk;

import javax.batch.api.chunk.ItemWriter;
import javax.batch.runtime.context.JobContext;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.Serializable;
import java.util.List;

import static batch.Constants.JAMES_CHUNK_DATA_PATH;

@Dependent
@Named("MyWriter")
public class MyWriter implements ItemWriter {

    private BufferedWriter bufferedWriter;

    @Inject
    JobContext jobContext;

    @Override
    public void open(Serializable serializable) throws Exception {
        String filePath = jobContext.getProperties().getProperty("output_file");
        bufferedWriter = new BufferedWriter(new FileWriter(JAMES_CHUNK_DATA_PATH+filePath, serializable != null));
    }

    @Override
    public void close() throws Exception {
        bufferedWriter.close();
    }

    @Override
    public void writeItems(List<Object> list) throws Exception {
        for (Object item: list) {
            bufferedWriter.write((String) item);
            bufferedWriter.newLine();
        }
    }

    @Override
    public Serializable checkpointInfo() throws Exception {
        return new MyCheckpoint();
    }
}
