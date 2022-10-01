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

    @FindBy (xpath = "//*[text()='Username or password is incorrect, please correct them and try again']")
    public WebElement loginFailed;

    @FindBy (xpath = "(//span[@class='title'])[3]")
    public WebElement hotelManagement;

    @FindBy (xpath = "(//i[@class='icon-calendar'])[4]")
    public WebElement roomReservation;

    @FindBy (xpath = "//*[text()='Add Room Reservation ']")
    public WebElement addRoomReservation;

    @FindBy (xpath = "//select[@id='IDUser']")
    public WebElement idUserSelectMenu;

    @FindBy (xpath = "(//button[@type='button'])[8]")
    public WebElement roomReservationInsertedText;



}
