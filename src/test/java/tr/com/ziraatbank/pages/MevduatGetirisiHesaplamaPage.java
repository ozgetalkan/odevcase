package tr.com.ziraatbank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import tr.com.ziraatbank.helper.ElementHelper;

public class MevduatGetirisiHesaplamaPage {
    static WebDriver driver;
    ElementHelper elementHelper;

    By mevduatGetirisiHesaplama = By.xpath("//div[@id='landingNav']//a[contains(text(), 'Mevduat Getirisi Hesaplama')]");
    By mevduatGetirisiHesaplamaDovizCinsiSelect = By.cssSelector("#dovizCinsi");
    By mevduatGetirisiHesaplamaVadeSuresiInput = By.xpath("//input[@id='deposit-calc-vade']");
    By mevduatGetirisiHesaplamaTutarInput = By.xpath("//input[@id='tutar']");
    By mevduatGetirisiHesaplamaHesaplaButon = By.xpath("//a[@class='btn btn-red btn-save']");
    By mevduatGetirisiHesaplamaVadeSonuTutariText = By.xpath("(//div[@class='result-item'])[1]/span");
    By mevduatGetirisiHesaplamaFaizOraniText = By.xpath("(//div[@class='result-item'])[2]/span");


    public MevduatGetirisiHesaplamaPage(WebDriver driver) {
        MevduatGetirisiHesaplamaPage.driver = driver;
        this.elementHelper = new ElementHelper(driver);
    }

    public void mevduatKredisineTiklanir() throws InterruptedException {
        driver.findElement(mevduatGetirisiHesaplama).click();
        JavascriptExecutor jsx = (JavascriptExecutor) driver;
        jsx.executeScript("window.scrollBy(0,450)", " ");
        Thread.sleep(1000);
    }

    public void mevduatGetirisiHesaplamaDovizCinsiSec(String dovizCinsi) throws InterruptedException {
        Select select = new Select(driver.findElement(mevduatGetirisiHesaplamaDovizCinsiSelect));
        select.selectByVisibleText(dovizCinsi);
        Thread.sleep(1000);
    }

    public void mevduatGetirisiHesaplamaVadeSuresiYaz(String vadeSuresi) throws InterruptedException {
        driver.findElement(mevduatGetirisiHesaplamaVadeSuresiInput).clear();
        driver.findElement(mevduatGetirisiHesaplamaVadeSuresiInput).sendKeys(vadeSuresi);
        Thread.sleep(1000);
    }

    public void mevduatGetirisiHesaplamaTutarYaz(String tutar) throws InterruptedException {
        driver.findElement(mevduatGetirisiHesaplamaTutarInput).clear();
        driver.findElement(mevduatGetirisiHesaplamaTutarInput).sendKeys(tutar);
        Thread.sleep(1000);
    }

    public void mevduatGetirisiHesaplamaHesaplaButonTiklanir() throws InterruptedException {
        driver.findElement(mevduatGetirisiHesaplamaHesaplaButon).click();
        Thread.sleep(2000);
    }

    public void mevduatGetirisiHesaplamaSonucKontrolEdilir(String vadeSonuTutari, String faizOrani) {
        Assert.assertTrue(driver.findElement(mevduatGetirisiHesaplamaVadeSonuTutariText).getText().contains(vadeSonuTutari), "Hesaplama sonucunda vade sonu tutari beklenen degere esit degildir.");
        Assert.assertTrue(driver.findElement(mevduatGetirisiHesaplamaFaizOraniText).getText().contains(faizOrani), "Hesaplama sonucunda faiz orani degeri beklenen degere esit degildir.");

        System.out.println("Hesaplama sonucu taksit tutari: " + driver.findElement(mevduatGetirisiHesaplamaVadeSonuTutariText).getText() + " Beklenen taksit tutari: " + vadeSonuTutari);
        System.out.println("Hesaplama faiz orani tutari: " + driver.findElement(mevduatGetirisiHesaplamaFaizOraniText).getText() + " Beklenen faiz orani: " + faizOrani);
    }

    public void mevduatGetirisiHesaplamaTutarErrorGoruntulenir() {
        By mevduatGetirisiHesaplamaTutarErrorLabel = By.xpath("//label[@id='tutar-error']");
        Assert.assertTrue(driver.findElement(mevduatGetirisiHesaplamaTutarErrorLabel).isDisplayed());
        Assert.assertTrue(driver.findElement(mevduatGetirisiHesaplamaTutarErrorLabel).getText().contains("Bu alanın doldurulması zorunludur."));
        System.out.println("Mevduat getirisi hesaplama tutar bilgisi bos hatasi goruntulenir: " + driver.findElement(mevduatGetirisiHesaplamaTutarErrorLabel).isDisplayed());
    }

}
