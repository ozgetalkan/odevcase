package tr.com.ziraatbank.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import tr.com.ziraatbank.driver.DriverFactory;
import tr.com.ziraatbank.pages.TuketiciKredisiPage;

public class TuketiciKredisiStepDefinitions {
    WebDriver driver = DriverFactory.getDriver();
    TuketiciKredisiPage tuketiciKredisiPage = new TuketiciKredisiPage(driver);

    @Given("Kredi hesaplama altındaki tuketici kredisine tiklanir")
    public void tuketiciKredisineTiklanir() throws InterruptedException {
    tuketiciKredisiPage.tuketiciKredisineTiklanir();
    }

    @When("Tuketici kredisi turunu {string} olarak secilir")
    public void tuketiciKrediTur(String arg0) throws InterruptedException {
    tuketiciKredisiPage.tuketiciKrediTur(arg0);
    }

    @When("Tuketici kredisi tutar degerine {string} yazilir")
    public void tuketiciKrediTutarYaz(String arg0) throws InterruptedException {
        tuketiciKredisiPage.tuketiciKrediTutarYaz(arg0);
    }

    @When("Tuketici kredisi vade degerine {string} yazilir")
    public void tuketiciKrediVadeYaz(String arg0) throws InterruptedException {
        tuketiciKredisiPage.tuketiciKrediVadeYaz(arg0);
    }

    @When("Tuketici kredisi faiz degerine {string} yazilir")
    public void tuketiciKrediFaizYaz(String arg0) throws InterruptedException {
        tuketiciKredisiPage.tuketiciKrediFaizYaz(arg0);
    }

    @Then("Tuketici kredisi hesapla butonuna tiklar")
    public void hesaplaButonunaTiklar() throws InterruptedException {
        tuketiciKredisiPage.tuketiciKrediHesaplaButonTiklanir();
    }

    @Then("Tuketici kredisi hesaplama sonucu taksit tutari {string}, faiz orani {string} ve yillik maliyet orani {string} oldugu kontrol edilir")
    public void hesaplamaSonucKontrolEdilir(String arg0, String arg1, String arg2) {
        tuketiciKredisiPage.tuketiciKrediHesaplamaSonucKontrolEdilir(arg0, arg1, arg2);
    }

    @Then("Tuketici kredisi tutar degerine negatif deger girildiginde en yakin pozitif sayi olan 1 yazilir")
    public void tutarNegatifDegerGirilmesiKontrolEdilir() {
        tuketiciKredisiPage.tutarNegatifDegerGirilmesiKontrolEdilir();
    }

    @Then("Tuketici kredisi tutar degerine sıfır girildiginde sonuc hesaplanmaz")
    public void sonucHesaplanmamaGoruntulenir() {
        tuketiciKredisiPage.sonucHesaplanmamaGoruntulenir();
    }
}
