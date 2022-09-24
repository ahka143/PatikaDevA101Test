package stepDefinitions;

import com.github.javafaker.Faker;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import utilities.Driver;
import utilities.ReusableMethods;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Set;

public class A101MobileStepdefs {
    AndroidDriver driver = null;

    @Given("Kullanici A101 mobile anasayfasina gider")
    public void kullanici_a101_mobile_anasayfasina_gider() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Note8");
        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "chrome");
        capabilities.setCapability("chromedriverExecutable", "C:\\Users\\ahka1\\IdeaProjects\\com.PatikaDev_A101_Test\\driver\\chromedriver.exe");

        try {
            driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }


        driver.get("https://www.a101.com.tr");

    }

    @And("Kullanici menu butonuna tiklar")
    public void kullaniciMenuButonunaTiklar() throws InterruptedException {

        driver.context("NATIVE_APP");
        Thread.sleep(3);
        driver.findElement(By.id("com.android.chrome:id/negative_button")).click();
        driver.context("CHROMIUM");
        driver.findElement(By.xpath("//button[@id='CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll']")).click();
        driver.findElement(By.xpath("//a[@class='menu-toggle js-navigation-toggle visible-xs']")).click();
    }

    @And("Kullanici Giyim Aksesuar menusune tiklar")
    public void kullaniciGiyimAksesuarMenusuneTiklar() {
        ReusableMethods.waitFor(3);
        driver.context("NATIVE_APP");
        driver.findElement(By.xpath("//android.view.View[@content-desc=\"\uE922 GİYİM & AKSESUAR\"]/android.view.View")).click();
    }

    @And("Kullanici Kadin ic giyim menusune tiklar")
    public void kullaniciKadinIcGiyimMenusuneTiklar() {
        ReusableMethods.waitFor(2);
        driver.findElement(By.xpath("//android.view.View[@content-desc=\"Kadın İç Giyim \uE922\"]/android.view.View")).click();

    }

    @And("Kullanici Dizalti Corap menusune tiklar")
    public void kullaniciDizaltiCorapMenusuneTiklar() {

        ReusableMethods.waitFor(2);
        driver.findElement(By.xpath("//android.view.View[@content-desc=\"Dizaltı Çorap \uE922\"]/android.view.View")).click();
    }

    @And("Kullanici ilk urunu secer")
    public void kullaniciIlkUrunuSecer() {
        driver.context("CHROMIUM");
        ReusableMethods.waitFor(3);
        List<WebElement> urunlerList = driver.findElements(By.xpath("//figure[@class='product-image ']"));
        urunlerList.get(0).click();
    }

    @Then("Kullanici secilen urunun renginin siyah oldugunu dogrular")
    public void kullaniciSecilenUrununRengininSiyahOldugunuDogrular() {
        ReusableMethods.waitFor(5);
        WebElement ilkUrunText = driver.findElement(By.xpath("//h1"));


        Assert.assertTrue(ilkUrunText.getText().contains("Siyah"));
    }

    @And("Kullanici sepete ekle butonuna tiklar")
    public void kullaniciSepeteEkleButonunaTiklar() {


        driver.findElement(By.xpath("//button[@class='add-to-basket button green block with-icon js-add-basket']")).click();

    }


    @And("Kullanici mobilde {string} butonuna tiklar")
    public void kullaniciMobildeButonunaTiklar(String button) {
        ReusableMethods.waitFor(3);
        driver.findElement(By.partialLinkText(button)).click();
    }

    @And("Kullanici mobil {string} butonuna tiklar")
    public void kullaniciMobilButonunaTiklar(String button) {
        ReusableMethods.waitFor(3);
        driver.findElement(By.xpath("//*[contains(text(),'"+button+"')]")).click();
    }

    @And("Kullanici mobilde gecerli bir mail adresi girer ve Devam et butonuna tiklar")
    public void kullaniciMobildeGecerliBirMailAdresiGirerVeDevamEtButonunaTiklar() {
        ReusableMethods.waitFor(2);
        Faker faker = new Faker();
        driver.findElement(By.xpath("//input[@name='user_email']")).sendKeys(faker.internet().emailAddress());
        driver.findElement(By.xpath("(//*[contains(text(),'DEVAM ET')])[2]")).click();
    }

    @And("Kullanici mobilde yeni adres olustur butonuna tiklar")
    public void kullaniciMobildeYeniAdresOlusturButonunaTiklar() {
        ReusableMethods.waitFor(3);
        driver.findElement(By.xpath("(//a[@class='new-address js-new-address'])[1]")).click();
    }

    @And("Kullanici mobilde yeni adres bilgilerini girer ve kaydet butonuna tiklar")
    public void kullaniciMobildeYeniAdresBilgileriniGirerVeKaydetButonunaTiklar() {
        Faker faker = new Faker();

        driver.findElement(By.xpath("//input[@name='title']")).sendKeys("EV");
        driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys(faker.name().firstName());
        driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys(faker.name().lastName());


        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.TAB, "12345678900").perform();
        ReusableMethods.waitFor(1);
        actions.sendKeys(Keys.TAB, Keys.ARROW_DOWN).perform();
        ReusableMethods.waitFor(1);
        actions.sendKeys(Keys.TAB, Keys.ARROW_DOWN).perform();
        ReusableMethods.waitFor(1);
        actions.sendKeys(Keys.TAB, Keys.ARROW_DOWN).perform();
        ReusableMethods.waitFor(1);
        actions.sendKeys(Keys.TAB, faker.address().fullAddress()).perform();



    }

    @Then("Kullanici odeme ekraninda oldugunu dogrular")
    public void kullaniciOdemeEkranindaOldugunuDogrular() {
        ReusableMethods.waitFor(3);
        WebElement kartIleOdemeText=driver.findElement(By.xpath("//*[contains(text(),'Kart ile ödeme')]"));
        Assert.assertTrue(kartIleOdemeText.isDisplayed());
    }

    @And("Kullanici mobil sayfayi kapatir")
    public void kullaniciMobilSayfayiKapatir() {
        driver.quit();
    }
}
