package tr.com.ziraatbank.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.openqa.selenium.WebDriver;
import tr.com.ziraatbank.driver.DriverFactory;

@CucumberOptions(
        features = {"src/test/java/tr/com/ziraatbank/features"},
        glue = {"steps", "utils", "helper", "driver"},
        plugin = {
                "summary", "pretty"
        }
)

public class TestRunner extends AbstractTestNGCucumberTests {
    static WebDriver driver = DriverFactory.getDriver();
}
