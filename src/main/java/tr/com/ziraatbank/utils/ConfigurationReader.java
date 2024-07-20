package tr.com.ziraatbank.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    private static Properties properties;


    public static Properties initialize_Properties() throws RuntimeException {
        properties = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream("src/test/resources/Configuration.properties");
            properties.load(fileInputStream);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return getProperties();
    }

    public static Properties getProperties() {
        return properties;
    }

}
