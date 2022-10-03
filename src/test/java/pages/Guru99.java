package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Guru99 {

    public Guru99 () {
        PageFactory.initElements(Driver.getDriver(), this);
        }


        @FindBy (xpath = "//input[@name='uid']")
        public WebElement userId;

        @FindBy (xpath = "//input[@name='password']")
        public WebElement password;

        @FindBy (xpath = "//input[@name='btnLogin']")
        public WebElement loginButton;

        @FindBy (xpath = "//*[text()='Log out']")
        public WebElement logOut;

        @FindBy (xpath = "//tr[@class='heading3']")
        public WebElement managerIdtext;




}
