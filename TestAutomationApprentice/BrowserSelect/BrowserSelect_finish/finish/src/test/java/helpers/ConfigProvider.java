package helpers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigProvider {

    private Properties properties;

    public ConfigProvider() {
        properties = new Properties();
        try {
            FileInputStream inputStream = new FileInputStream("src/test/resources/e2e.properties");
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getBrowser() {
        return properties.getProperty("browser");
    }
}
