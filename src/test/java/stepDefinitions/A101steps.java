package stepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.A101Pages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class A101steps {

    @Given("Kulllanici {string} anasayfasina gider")
    public void kulllanici_anasayfasina_gider(String url) {
        Driver.getDriver().get(ConfigReader.getProperty(url));
    }

    @And("Kullanici Giyim aksesuar butonuna tiklar")
    public void kullaniciGiyimAksesuarButonunaTiklar() {
        A101Pages a101Pages = new A101Pages();
        a101Pages.giyimButonu.click();

    }

    @And("Kullanici cerezleri kabul eder")
    public void KullaniciCerezleriKabulEder() {
        A101Pages a101Pages = new A101Pages();
        if (!a101Pages.cerezKabulButonuList.isEmpty()) {
            a101Pages.cerezKabulButonuList.get(0).click();
        }
    }

    @And("Kullanici Kategoriler butonunu tiklar")
    public void kullaniciKategorilerButonunuTiklar() {
        A101Pages a101Pages = new A101Pages();
        if (!a101Pages.kategorilerButonuList.isEmpty()) {
            a101Pages.kategorilerButonuList.get(0).click();
        }
    }


    @And("Kullanici {string} butonuna tiklar")
    public void kullaniciButonunaTiklar(String button) {

        ReusableMethods.jsClick(Driver.getDriver().findElement(By.partialLinkText(button)));

    }

    @And("Kullanici Dizalti Corap butonuna tiklar")
    public void kullaniciDizaltiCorapButonunaTiklar() {

        A101Pages a101Pages = new A101Pages();

        ReusableMethods.jsClick(a101Pages.dizAltiCorapButonu);
    }

    @And("Kullanici ilk urune tiklar")
    public void kullaniciIlkUruneTiklar() {
        A101Pages a101Pages = new A101Pages();
        ReusableMethods.waitFor(4);
        a101Pages.urunlerList.get(0).click();

    }


    @Then("Kullanici urun renginin {string} oldugunu dogrular")
    public void kullaniciUrunRengininOldugunuDogrular(String renk) {
        A101Pages a101Pages = new A101Pages();

        Assert.assertTrue(a101Pages.secilenRenkText.getText().contains(renk));
    }

    @And("Sepete ekle butonuna tiklar")
    public void sepeteEkleButonunaTiklar() {

        A101Pages a101Pages = new A101Pages();
        a101Pages.sepeteEkleButonu.click();

    }

    @And("Kullanici Sepeti Goruntule butonuna tiklar")
    public void kullaniciSepetiGoruntuleButonunaTiklar() {

        A101Pages a101Pages = new A101Pages();
        a101Pages.sepetiGoruntuleButonu.click();
    }

    @And("Kullanici gecerli bir mail adresi girer ve Devam et butonuna tiklar")
    public void kullaniciGecerliBirMailAdresiGirerVeDevamEtButonunaTiklar() {
        Faker faker = new Faker();
        A101Pages a101Pages = new A101Pages();
        a101Pages.emailTextBox.sendKeys(faker.internet().emailAddress());
        a101Pages.devamEtButonu.click();

    }

    @And("Kullanici gerekli alanlari doldurur ve kaydet butonuna tiklar")
    public void kullaniciGerekliAlanlariDoldururVeKaydetButonunaTiklar() {
        Faker faker = new Faker();
        A101Pages a101Pages = new A101Pages();

        a101Pages.adresBasligiTextBox.sendKeys("EV");
        a101Pages.nameTextBox.sendKeys(faker.name().firstName());
        a101Pages.lastNameTextBox.sendKeys(faker.name().lastName());
        a101Pages.phoneNumberTextBox.sendKeys("5555555555");
        Select city = new Select(a101Pages.cityDDM);
        city.selectByIndex(2);
        ReusableMethods.waitFor(1);
        Select ilce = new Select(a101Pages.ilceDDM);
        ilce.selectByIndex(2);
        ReusableMethods.waitFor(1);
        Select mahalle = new Select(a101Pages.mahalleDDM);
        mahalle.selectByIndex(2);
        a101Pages.adresTextBox.sendKeys(faker.address().fullAddress());
        a101Pages.kaydetButonu.click();
    }

    @And("Kullanici kaydet ve devam et butonununa tiklar")
    public void kullaniciKaydetVeDevamEtButonununaTiklar() {
        A101Pages a101Pages = new A101Pages();

        ReusableMethods.waitFor(3);
        a101Pages.kaydetDevamEtButonu.click();
    }

    @Then("Kullanici odeme ekranina gidildigini dogrular")
    public void kullaniciOdemeEkraninaGidildiginiDogrular() {

        A101Pages a101Pages=new A101Pages();
        Assert.assertTrue(a101Pages.kartIleOdemeText.isDisplayed());
        ReusableMethods.waitFor(4);
    }

    @And("Kullanici sayfayi kapatir")
    public void kullaniciSayfayiKapatir() {
        Driver.closeDriver();
    }
}
