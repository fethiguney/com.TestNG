package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AutomationExercisePage {

    public AutomationExercisePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath = "//i[@class='material-icons card_travel']")
    public WebElement products;

    @FindBy (xpath = "//input[@id='search_product']")
    public WebElement productSearchBar;

    @FindBy (xpath = "//*[@class='fa fa-search']")
    public WebElement productSearchBarClick;


    @FindBy (xpath = "//h2[@class='title text-center']")
    public WebElement searchedProductsText;

    @FindBy (linkText = "View Product")
    public WebElement viewProduct;

    @FindBy (xpath = "//h2[text()='Blue Top']")
    public WebElement blueTopText;

}
