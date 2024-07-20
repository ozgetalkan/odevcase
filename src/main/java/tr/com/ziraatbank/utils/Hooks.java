package tr.com.ziraatbank.utils;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import tr.com.ziraatbank.driver.DriverFactory;

import java.util.Properties;

public class Hooks {
    WebDriver driver;
    Properties properties;
    @Before
    public void before() {

        properties = ConfigurationReader.initialize_Properties();
        driver = DriverFactory.initialize_Driver("Chrome");
    }

    @After
    public void after() {

        properties = ConfigurationReader.getProperties();
        Boolean localQuitDriverActive = Boolean.parseBoolean(properties.getProperty("localQuitDriverActive"));

        if (localQuitDriverActive) {
            driver.quit();
        }
    }

}
