package tr.com.ziraatbank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import tr.com.ziraatbank.helper.ElementHelper;

public class TuketiciKredisiPage {
    static WebDriver driver;
    ElementHelper elementHelper;

    By tuketiciKredisi = By.xpath("//div[@class='col-sm-6']//a[contains(text(), 'Tüketici Kredisi')]");
    By tuketiciKredisiKrediTurSelect = By.cssSelector("#ddlCredit");
    By tuketiciKrediTutarInput = By.cssSelector("#calc-tutar");
    By tuketiciKrediVadeInput = By.cssSelector("#calc-vade");
    By tuketiciKrediFaizInput = By.cssSelector("#faiz-orani");
    By tuketiciKrediHesaplaButon = By.xpath("//a[@class='btn btn-red calculation-btn']");
    By tuketiciKrediHesaplaTaksitTutariText = By.xpath("(//div[@class='result-item'])[1]/span");
    By tuketiciKrediHesaplaFaizOraniText = By.xpath("(//div[@class='result-item'])[2]/span");
    By tuketiciKrediHesaplaYillikMaliyetOraniText = By.xpath("(//div[@class='result-item'])[3]/span");


    public TuketiciKredisiPage(WebDriver driver) {
        TuketiciKredisiPage.driver = driver;
        this.elementHelper = new ElementHelper(driver);
    }

    public void tuketiciKredisineTiklanir() throws InterruptedException {
        driver.findElement(tuketiciKredisi).click();
        JavascriptExecutor jsx = (JavascriptExecutor) driver;
        jsx.executeScript("window.scrollBy(0,450)", " ");
        Thread.sleep(1000);
    }

    public void tuketiciKrediTur(String tuketiciKrediTuru) throws InterruptedException {
        Select select = new Select(driver.findElement(tuketiciKredisiKrediTurSelect));
        select.selectByVisibleText(tuketiciKrediTuru);
        Thread.sleep(1000);
    }

    public void tuketiciKrediTutarYaz(String tutar) throws InterruptedException {
        driver.findElement(tuketiciKrediTutarInput).clear();
        driver.findElement(tuketiciKrediTutarInput).sendKeys(tutar);
        Thread.sleep(1000);
    }

    public void tuketiciKrediVadeYaz(String vade) throws InterruptedException {
        driver.findElement(tuketiciKrediVadeInput).clear();
        driver.findElement(tuketiciKrediVadeInput).sendKeys(vade);
        Thread.sleep(1000);
    }

    public void tuketiciKrediFaizYaz(String faiz) throws InterruptedException {
        driver.findElement(tuketiciKrediFaizInput).clear();
        driver.findElement(tuketiciKrediFaizInput).sendKeys(faiz);
        Thread.sleep(1000);
    }

    public void tuketiciKrediHesaplaButonTiklanir() throws InterruptedException {
        driver.findElement(tuketiciKrediHesaplaButon).click();
        Thread.sleep(2000);
    }

    public void tuketiciKrediHesaplamaSonucKontrolEdilir(String taksitTutar, String faizOrani, String yillikMaliyetOrani) {
        Assert.assertTrue(driver.findElement(tuketiciKrediHesaplaTaksitTutariText).getText().contains(taksitTutar), "Hesaplama sonucunda taksit tutar degeri beklenen degere esit degildir.");
        Assert.assertTrue(driver.findElement(tuketiciKrediHesaplaFaizOraniText).getText().contains(faizOrani), "Hesaplama sonucunda faiz orani degeri beklenen degere esit degildir.");
        Assert.assertTrue(driver.findElement(tuketiciKrediHesaplaYillikMaliyetOraniText).getText().contains(yillikMaliyetOrani), "Hesaplama sonucunda yillik maliyet orani degeri beklenen degere esit degildir.");

        System.out.println("Hesaplama sonucu taksit tutari: " + driver.findElement(tuketiciKrediHesaplaTaksitTutariText).getText() + " Beklenen taksit tutari: " + taksitTutar);
        System.out.println("Hesaplama faiz orani tutari: " + driver.findElement(tuketiciKrediHesaplaFaizOraniText).getText() + " Beklenen faiz orani: " + faizOrani);
        System.out.println("Hesaplama sonucu yillik maliyet orani: " + driver.findElement(tuketiciKrediHesaplaYillikMaliyetOraniText).getText() + " Beklenen yillik maliyet orani: " + yillikMaliyetOrani);
    }

    public void tutarNegatifDegerGirilmesiKontrolEdilir() {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(tuketiciKrediTutarInput));
        actions.perform();
        System.out.println(driver.findElement(tuketiciKrediTutarInput).getText().trim());
        Assert.assertEquals(driver.findElement(tuketiciKrediTutarInput).getText().trim(),"1", "Tutar bilgisine negatif deger girildiginde tutar bire yuvarlanmadı.");
    }

    public void sonucHesaplanmamaGoruntulenir() {
        Assert.assertFalse(driver.findElement(tuketiciKrediHesaplaTaksitTutariText).isDisplayed());
        System.out.println("Tutar degerine sıfır girildiginde hesaplama yapılamaz: ");
    }
}
