package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class DhtmlgoodiesPage {

    public DhtmlgoodiesPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    //countries
    @FindBy (xpath = "//div[text()='Italy']")
    public WebElement italy;

    @FindBy (xpath = "//div[text()='Spain']")
    public WebElement spain;

    @FindBy (xpath = "//div[text()='Norway']")
    public WebElement norway;

    @FindBy (xpath = "//div[text()='Denmark']")
    public WebElement denmark;

    @FindBy (xpath = "//div[text()='South Korea']")
    public WebElement soutKorea;

    @FindBy (xpath = "//div[text()='Sweden']")
    public WebElement sweden;

    @FindBy (xpath = "//div[text()='United States']")
    public WebElement us;

    //capitals
    @FindBy (xpath = "//div[@id='box4']")
    public WebElement copenhagen;

    @FindBy (xpath = "//div[@id='box5']")
    public WebElement seoul;

    @FindBy (xpath = "//div[@id='box6']")
    public WebElement rome;

    @FindBy (xpath = "//div[@id='box7']")
    public WebElement madrid;

    @FindBy (xpath = "//div[@id='box1']")
    public WebElement oslo;

    @FindBy (xpath = "//div[@id='box2']")
    public WebElement stockholm;

    @FindBy (xpath = "//div[@id='box3']")
    public WebElement washington;








}
