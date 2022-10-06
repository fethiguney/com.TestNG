package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class BlueRentalCarPage {

    public BlueRentalCarPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//*[@role='button'])[1]")
    public WebElement login;

    @FindBy (xpath = "//input[@id='formBasicEmail']")
    public WebElement emailBar;

    @FindBy (xpath = "//input[@id='formBasicPassword']")
    public WebElement passwordBar;

    @FindBy (xpath = "//button[@type='submit']")
    public WebElement loginClick;

    @FindBy (xpath = "//button[@id='dropdown-basic-button']")
    public WebElement ddmBar;

    @FindBy(xpath = "//*[text()='invalid credentials']")
    public WebElement basarisiz_giris_dogrulama;

}
