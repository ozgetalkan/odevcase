package tr.com.ziraatbank.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import tr.com.ziraatbank.driver.DriverFactory;
import tr.com.ziraatbank.pages.IbanHesaplamaPage;
import tr.com.ziraatbank.pages.MevduatGetirisiHesaplamaPage;

public class IbanHesaplamaStepDefinition {

    WebDriver driver = DriverFactory.getDriver();
    IbanHesaplamaPage ibanHesaplamaPage = new IbanHesaplamaPage(driver);

    @Given("Iban hesaplamaya tiklanir")
    public void ibanHesaplamayaTiklanir() throws InterruptedException {
        ibanHesaplamaPage.ibanHesaplamayaTiklanir();
    }

    @Given("Iban hesaplama sube kodlarina gore sirala checkboxina tiklanir")
    public void ibanHesaplamaSubeKodCheckboxTiklanir() throws InterruptedException {
        ibanHesaplamaPage.ibanHesaplamaSubeKodCheckboxTiklanir();
    }

    @Given("Iban hesaplama {string} kodlu sube secilir")
    public void ibanHesaplamaSubeSec(String arg0) throws InterruptedException {
        ibanHesaplamaPage.ibanHesaplamaSubeSec(arg0);
    }

    @Given("Iban hesaplama {string} kodlu sube isim secilir")
    public void ibanHesaplamaSubeIsimSec(String arg0) throws InterruptedException {
        ibanHesaplamaPage.ibanHesaplamaSubeIsimSec(arg0);
    }

    @When("Iban hesaplama musteri no {string} yazilir")
    public void ibanHesaplamaMusteriNoYaz(String arg0) throws InterruptedException {
        ibanHesaplamaPage.ibanHesaplamaMusteriNoYaz(arg0);
    }

    @When("Iban hesaplama ek no {string} yazilir")
    public void ibanHesaplamaEkNoYaz(String arg0) throws InterruptedException {
        ibanHesaplamaPage.ibanHesaplamaEkNoYaz(arg0);
    }

    @Then("Iban hesaplama hesapla butonuna tiklar")
    public void ibanHesaplamaHesaplaButonTiklanir() throws InterruptedException {
        ibanHesaplamaPage.ibanHesaplamaHesaplaButonTiklanir();
    }

    @Then("Iban hesaplama sonucu iban degeri {string} oldugu kontrol edilir")
    public void ibanHesaplamaSonucKontrolEdilir(String arg0) {
        ibanHesaplamaPage.ibanHesaplamaSonucKontrolEdilir(arg0);
    }

    @Given("Iban hesaplama musteri no bilgisi ve ek no bilgisi bos birakilamaz uyarilarinin goruntulenmesi kontrol edilir")
    public void ibanHesaplamaMusteriNoIbanNoNullErrorGoruntulenir() {
        ibanHesaplamaPage.ibanHesaplamaMusteriNoIbanNoNullErrorGoruntulenir();
    }

    @Given("Iban hesaplama musteri no bilgisi ve ek no bilgisi eksik girilmistir uyarilarinin goruntulenmesi kontrol edilir")
    public void ibanHesaplamaMusteriNoIbanNoEksikErrorGoruntulenir() {
        ibanHesaplamaPage.ibanHesaplamaMusteriNoIbanNoEksikErrorGoruntulenir();
    }
}
