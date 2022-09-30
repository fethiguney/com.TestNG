package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SaucedemoPage {

    public SaucedemoPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath = "//input[@id='user-name']")
    public WebElement username;

    @FindBy (xpath = "//input[@id='password']")
    public WebElement password;

    @FindBy (xpath = "//input[@id='login-button']")
    public WebElement loginButton;

    @FindBy (xpath = "//select[@class='product_sort_container']")
    public WebElement dropDownMenu;

    @FindBy (xpath = "//option[@value='lohi']")
    public WebElement lowToHighOption;

}
