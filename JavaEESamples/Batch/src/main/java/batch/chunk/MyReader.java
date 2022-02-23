package batch.chunk;

import javax.batch.api.chunk.ItemReader;
import javax.batch.runtime.context.JobContext;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Serializable;

import static batch.Constants.JAMES_CHUNK_DATA_PATH;

@Dependent
@Named("MyReader")
public class MyReader implements ItemReader {
    private MyCheckpoint myCheckpoint;
    private BufferedReader bufferedReader;

    @Inject
    JobContext jobContext;

    public MyReader() {
    }

    @Override
    public void open(Serializable serializable) throws Exception {
        if (serializable == null) {
            myCheckpoint = new MyCheckpoint();
        } else {
            myCheckpoint = (MyCheckpoint) serializable;
        }

        String filePath = jobContext.getProperties().getProperty("input_file");
        bufferedReader = new BufferedReader(new FileReader(JAMES_CHUNK_DATA_PATH + filePath));
        for (long i = 0; i < myCheckpoint.getLineNum(); i++) {
            bufferedReader.readLine();
        }
    }

    @Override
    public void close() throws Exception {
        bufferedReader.close();
    }

    @Override
    public Object readItem() throws Exception {
        return bufferedReader.readLine();
    }

    @Override
    public Serializable checkpointInfo() throws Exception {
        return null;
    }
}
