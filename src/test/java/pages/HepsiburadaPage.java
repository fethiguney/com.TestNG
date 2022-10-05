package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class HepsiburadaPage {

    public HepsiburadaPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath = "(//span[@class='sf-MenuItems-UHHCg2qrE5_YBqDV_7AC'])[1]")
    public WebElement elektronikMenu;

    @FindBy (xpath = "//*[text()='Bilgisayar/Tablet']")
    public WebElement bilgisayarTabletMenu;

    @FindBy (xpath = "(//div[@class='sf-ChildMenuItems-OMxRJDk0466HYQpTli0P'])[1]//ul//li//a")
    public List<WebElement> bilgisayarTabletMenuList;




}
