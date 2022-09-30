package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class FaceBookPage {

    public FaceBookPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }



    @FindBy (xpath = "//button[@value='1']")
    public WebElement girisbutonu;

    @FindBy (xpath = "//input[@id='email']")
    public WebElement email;

    @FindBy (xpath = "//input[@id='pass']")
    public WebElement password;

    @FindBy (xpath = "//div[text()='Girdiğin e-posta bir hesaba bağlı değil. ']")
    public WebElement uyarıMesaji;

}
