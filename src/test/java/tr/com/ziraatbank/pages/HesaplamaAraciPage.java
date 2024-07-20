package tr.com.ziraatbank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import tr.com.ziraatbank.helper.ElementHelper;


public class HesaplamaAraciPage {
    static WebDriver driver;
    ElementHelper elementHelper;

    By hesaplamaAraclariPageText = By.xpath("//h1[contains(text(), 'Hesaplama Araçları')]");

    public HesaplamaAraciPage(WebDriver driver) {
        HesaplamaAraciPage.driver = driver;
        this.elementHelper = new ElementHelper(driver);
    }

    public void hesaplamaAraciGoruntulenir() {
        Assert.assertTrue(driver.findElement(hesaplamaAraclariPageText).isDisplayed());
        System.out.println("Hesaplama araci texti goruntulenir: " + driver.findElement(hesaplamaAraclariPageText).isDisplayed());
    }

}
