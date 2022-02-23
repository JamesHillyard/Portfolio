package batch.chunk;

import javax.batch.api.chunk.ItemProcessor;
import javax.enterprise.context.Dependent;
import javax.inject.Named;

@Dependent
@Named("MyProcessor")
public class MyProcessor implements ItemProcessor {

    public MyProcessor() {
    }

    @Override
    public Object processItem(Object o) throws Exception {
        String line = (String) o;
        return line.toUpperCase();
    }
}
