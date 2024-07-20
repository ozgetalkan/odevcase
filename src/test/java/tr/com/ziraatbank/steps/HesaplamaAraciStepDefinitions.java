package tr.com.ziraatbank.steps;

import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import tr.com.ziraatbank.driver.DriverFactory;
import tr.com.ziraatbank.pages.HesaplamaAraciPage;


public class HesaplamaAraciStepDefinitions {
    WebDriver driver = DriverFactory.getDriver();
    HesaplamaAraciPage hesaplamaAraclariPage = new HesaplamaAraciPage(driver);
    @Given("Hesaplama araci gorunur oluncaya kadar beklenir")
    public void kullaniciHesaplamaAraciSayfasindadir() {
        hesaplamaAraclariPage.hesaplamaAraciGoruntulenir();
    }
}
