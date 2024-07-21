package tr.com.ziraatbank.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import tr.com.ziraatbank.driver.DriverFactory;
import tr.com.ziraatbank.pages.MevduatGetirisiHesaplamaPage;
import tr.com.ziraatbank.pages.TuketiciKredisiPage;

public class MevduatGetirisiHesaplamaStepDefinitions {
    WebDriver driver = DriverFactory.getDriver();
    MevduatGetirisiHesaplamaPage mevduatGetirisiHesaplamaPage = new MevduatGetirisiHesaplamaPage(driver);

    @Given("Mevduat getirisi hesaplamaya tiklanir")
    public void mevduatKredisineTiklanir() throws InterruptedException {
        mevduatGetirisiHesaplamaPage.mevduatKredisineTiklanir();
    }

    @When("Mevduat getirisi hesaplama doviz cinsi {string} olarak secilir")
    public void mevduatGetirisiHesaplamaDovizCinsi(String arg0) throws InterruptedException {
        mevduatGetirisiHesaplamaPage.mevduatGetirisiHesaplamaDovizCinsiSec(arg0);
    }

    @When("Mevduat getirisi hesaplama vade suresine {string} yazilir")
    public void mevduatGetirisiHesaplamaVadeSuresiYaz(String arg0) throws InterruptedException {
        mevduatGetirisiHesaplamaPage.mevduatGetirisiHesaplamaVadeSuresiYaz(arg0);
    }

    @When("Mevduat getirisi hesaplama tutar degerine {string} yazilir")
    public void mevduatGetirisiHesaplamaTutarYaz(String arg0) throws InterruptedException {
        mevduatGetirisiHesaplamaPage.mevduatGetirisiHesaplamaTutarYaz(arg0);
    }

    @Then("Mevduat getirisi hesaplama hesapla butonuna tiklar")
    public void mevduatGetirisiHesaplamaHesaplaButonTiklanir() throws InterruptedException {
        mevduatGetirisiHesaplamaPage.mevduatGetirisiHesaplamaHesaplaButonTiklanir();
    }

    @Then("Mevduat getirisi hesaplama sonucu vade sonu tutari {string} ve faiz orani {string} oldugu kontrol edilir")
    public void mevduatGetirisiHesaplamaSonucKontrolEdilir(String arg0, String arg1) {
        mevduatGetirisiHesaplamaPage.mevduatGetirisiHesaplamaSonucKontrolEdilir(arg0, arg1);
    }

    @Given("Mevduat getirisi hesaplama tutar bilgisi bos birakilamaz uyarisinin goruntulenmesi kontrol edilir")
    public void mevduatGetirisiHesaplamaTutarErrorGoruntulenir() {
        mevduatGetirisiHesaplamaPage.mevduatGetirisiHesaplamaTutarErrorGoruntulenir();
    }

}
