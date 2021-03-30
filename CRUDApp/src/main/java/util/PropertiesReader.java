package util;

import javax.enterprise.context.Dependent;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Dependent
public class PropertiesReader {
    private static Properties properties;
    private static final String PROPERTIES_FILE_NAME = "app.properties";

    public PropertiesReader() throws IOException {
        InputStream is = getClass().getClassLoader().getResourceAsStream(PROPERTIES_FILE_NAME);
        this.properties = new Properties();
        this.properties.load(is);
    }

    public String getProperty(String propertyName) {
        return this.properties.getProperty(propertyName);
    }
}
