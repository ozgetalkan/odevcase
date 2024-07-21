package tr.com.ziraatbank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import tr.com.ziraatbank.helper.ElementHelper;

public class IbanHesaplamaPage {
    static WebDriver driver;
    ElementHelper elementHelper;

    By ibanHesaplama = By.xpath("//div[@id='landingNav']//a[contains(text(), 'IBAN Hesaplama')]");
    By ibanHesaplamaSubeKodCheckbox = By.xpath("//b[contains(text(), 'Kodlarına')]");
    By ibanHesaplamaSubeSelect = By.id("ddlSube");
    By ibanHesaplamaMusteriNoInput = By.xpath("//input[@id='musteriNo']");
    By ibanHesaplamaEkNoInput = By.xpath("//input[@id='ekNo']");
    By ibanHesaplamaHesaplaButon = By.xpath("//a[@class='btn btn-red iban-calculate']");
    By ibanHesaplamaIbanText = By.xpath("(//div[@class='result-item'])[1]/span");


    public IbanHesaplamaPage(WebDriver driver) {
        IbanHesaplamaPage.driver = driver;
        this.elementHelper = new ElementHelper(driver);
    }

    public void ibanHesaplamayaTiklanir() throws InterruptedException {
        driver.findElement(ibanHesaplama).click();
        JavascriptExecutor jsx = (JavascriptExecutor) driver;
        jsx.executeScript("window.scrollBy(0,450)", " ");
        Thread.sleep(1000);
    }

    public void ibanHesaplamaSubeKodCheckboxTiklanir() throws InterruptedException {
        driver.findElement(ibanHesaplamaSubeKodCheckbox).click();
        Thread.sleep(1000);
    }

    public void ibanHesaplamaSubeSec(String sube) throws InterruptedException {
        Select select = new Select(driver.findElement(ibanHesaplamaSubeSelect));
        select.selectByValue(sube);
        Thread.sleep(1000);
    }

    public void ibanHesaplamaSubeIsimSec(String sube) throws InterruptedException {
        Select select = new Select(driver.findElement(ibanHesaplamaSubeSelect));
        select.selectByVisibleText(sube);
        Thread.sleep(1000);
    }

    public void ibanHesaplamaMusteriNoYaz(String musteriNo) throws InterruptedException {
        driver.findElement(ibanHesaplamaMusteriNoInput).clear();
        driver.findElement(ibanHesaplamaMusteriNoInput).sendKeys(musteriNo);
        Thread.sleep(1000);
    }

    public void ibanHesaplamaEkNoYaz(String ekNo) throws InterruptedException {
        driver.findElement(ibanHesaplamaEkNoInput).clear();
        driver.findElement(ibanHesaplamaEkNoInput).sendKeys(ekNo);
        Thread.sleep(1000);
    }

    public void ibanHesaplamaHesaplaButonTiklanir() throws InterruptedException {
        driver.findElement(ibanHesaplamaHesaplaButon).click();
        Thread.sleep(2000);
    }

    public void ibanHesaplamaSonucKontrolEdilir(String iban) {
        Assert.assertTrue(driver.findElement(ibanHesaplamaIbanText).getText().contains(iban), "Hesaplama sonucunda iban beklenen degere esit degildir.");
        System.out.println("Hesaplanan iban: " + driver.findElement(ibanHesaplamaIbanText).getText() + " Beklenen iban: " + iban);
    }

    public void ibanHesaplamaMusteriNoIbanNoNullErrorGoruntulenir() {
        By ibanHesaplamaMusteriNoErrorLabel = By.xpath("//label[@id='musteriNo-error']");
        By ibanHesaplamaEkNoErrorLabel = By.xpath("//label[@id='ekNo-error']");

        Assert.assertTrue(driver.findElement(ibanHesaplamaMusteriNoErrorLabel).isDisplayed());
        Assert.assertTrue(driver.findElement(ibanHesaplamaMusteriNoErrorLabel).getText().contains("Bu alanın doldurulması zorunludur."));
        System.out.println("Iban hesaplama musteri no bos hatasi goruntulenir: " + driver.findElement(ibanHesaplamaMusteriNoErrorLabel).isDisplayed());

        Assert.assertTrue(driver.findElement(ibanHesaplamaEkNoErrorLabel).isDisplayed());
        Assert.assertTrue(driver.findElement(ibanHesaplamaEkNoErrorLabel).getText().contains("Bu alanın doldurulması zorunludur."));
        System.out.println("Iban hesaplama ek no bos hatasi goruntulenir: " + driver.findElement(ibanHesaplamaEkNoErrorLabel).isDisplayed());
    }

    public void ibanHesaplamaMusteriNoIbanNoEksikErrorGoruntulenir() {
        By ibanHesaplamaMusteriNoErrorLabel = By.xpath("//label[@id='musteriNo-error']");
        By ibanHesaplamaEkNoErrorLabel = By.xpath("//label[@id='ekNo-error']");

        Assert.assertTrue(driver.findElement(ibanHesaplamaMusteriNoErrorLabel).isDisplayed());
        Assert.assertTrue(driver.findElement(ibanHesaplamaMusteriNoErrorLabel).getText().contains("Lütfen en az 8 karakter uzunluğunda bir değer giriniz."));
        System.out.println("Iban hesaplama musteri no eksik girilmesi hatasi goruntulenir: " + driver.findElement(ibanHesaplamaMusteriNoErrorLabel).isDisplayed());

        Assert.assertTrue(driver.findElement(ibanHesaplamaEkNoErrorLabel).isDisplayed());
        Assert.assertTrue(driver.findElement(ibanHesaplamaEkNoErrorLabel).getText().contains("Lütfen en az 4 karakter uzunluğunda bir değer giriniz."));
        System.out.println("Iban hesaplama ek no eksik girilmesi hatasi goruntulenir: " + driver.findElement(ibanHesaplamaEkNoErrorLabel).isDisplayed());
    }
}

