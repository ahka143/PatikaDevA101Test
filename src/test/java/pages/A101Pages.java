package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class A101Pages {

    public A101Pages() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(partialLinkText = "Giyim")
    public WebElement giyimButonu;

    @FindBy(xpath = "//*[text()='Kabul Et']")
    public List<WebElement> cerezKabulButonuList;

    @FindBy(xpath = "//div[@class='hype-link hype-dropdown hype-categories-link']")
    public List <WebElement> kategorilerButonuList;

    @FindBy(partialLinkText = "Dizaltı Çorap")
    public WebElement dizAltiCorapButonu;

    @FindBy(partialLinkText = "Kadın İç Giyim")
    public WebElement kadinIcGiyimButonu;

    @FindBy (xpath = "//figure[@class='product-image ']")
    public List<WebElement> urunlerList;

    @FindBy (xpath = "//li[@class='derin ']")
    public List<WebElement> kategorilerList;


    @FindBy(xpath = "//div[@class='selected-variant-text']")
    public WebElement secilenRenkText;

    @FindBy(xpath = "//button[@class='add-to-basket button green block with-icon js-add-basket']")
    public WebElement sepeteEkleButonu;

    @FindBy(xpath = "//a[@class='go-to-shop']")
    public WebElement sepetiGoruntuleButonu;

    //
    @FindBy(partialLinkText = "Sepeti Onayla")
    public WebElement SepetiOnaylaButonu;

    @FindBy(xpath = "//input[@name='user_email']")
    public WebElement emailTextBox;

    @FindBy (xpath = "//button[@class='button block green']")
    public  WebElement devamEtButonu;

    @FindBy(xpath = "//input[@name='title']")
    public WebElement adresBasligiTextBox;

    @FindBy(xpath = "//input[@name='first_name']")
    public WebElement nameTextBox;

    @FindBy(xpath = "//input[@name='last_name']")
    public WebElement lastNameTextBox;

    @FindBy(xpath = "//input[@name='phone_number']")
    public WebElement phoneNumberTextBox;

    @FindBy(xpath = "//select[@name='city']")
    public WebElement cityDDM;

    @FindBy(xpath = "//select[@name='township']")
    public WebElement ilceDDM;

    @FindBy(xpath = "//select[@name='district']")
    public WebElement mahalleDDM;

    @FindBy(xpath = "//textarea[@aria-describedby='line-error']")
    public WebElement adresTextBox;

    @FindBy(xpath = "//button[@class='button green js-set-country js-prevent-emoji']")
    public WebElement kaydetButonu;

}
