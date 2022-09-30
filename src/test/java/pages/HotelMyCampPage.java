package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HotelMyCampPage {

    public HotelMyCampPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy (xpath = "//*[text()='Log in']")
    public WebElement homePagelogin;

    @FindBy (xpath = "//input[@id='UserName']")
    public WebElement username;

    @FindBy (xpath = "//input[@id='Password']")
    public WebElement password;

    @FindBy (xpath = "//input[@id='btnSubmit']")
    public WebElement loginClickButton;

    @FindBy (xpath = "(//*[@class='dropdown-toggle'])[1]")
    public WebElement verifyLogin;




}
