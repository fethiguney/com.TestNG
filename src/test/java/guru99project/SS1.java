package guru99project;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Guru99;
import utilities.ConfigReader;
import utilities.Driver;

public class SS1 {

    Guru99 guru;

    @Test
    public void validUserId_ValidPassword() {

        //Go to http://www.demo.guru99.com/V4
        Driver.getDriver().get(ConfigReader.getProperty("guruUrl"));

        //Enter valid user id -->  mngr442980
        guru=new Guru99();
        guru.userId.sendKeys(ConfigReader.getProperty("userId"));

        //Enter valid user password -->  pegYdAm
        guru.password.sendKeys(ConfigReader.getProperty("password"));

        //click login
        guru.loginButton.click();

        //verify the output
        String actualTitle=Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle, ConfigReader.getProperty("loginExpectedTitle"));

    }


    @Test
    public void validUserId_InvalidPassword() {
        //Go to http://www.demo.guru99.com/V4
        Driver.getDriver().get(ConfigReader.getProperty("guruUrl"));

        //Enter valid user id -->  mngr442980
        guru=new Guru99();
        guru.userId.sendKeys(ConfigReader.getProperty("userId"));

        //Enter invalid user password
        guru.password.sendKeys(ConfigReader.getProperty("invalidPassword"));

        //click login
        guru.loginButton.click();

       //A pop-up "User or Password is not valid" is shown
        try {
            Alert alt=Driver.getDriver().switchTo().alert();
            String actualMessage=alt.getText();
            alt.accept();
            Assert.assertTrue(actualMessage.contains(ConfigReader.getProperty("loginfailedmessage")));

        } catch (Exception e) {
            System.out.println("Pop up mesaji yazdirmadi");
        }


    }

    @Test
    public void invalidUserId_validPassword() {
        //Go to http://www.demo.guru99.com/V4
        Driver.getDriver().get(ConfigReader.getProperty("guruUrl"));

        //Enter invalid user id
        guru=new Guru99();
        guru.userId.sendKeys(ConfigReader.getProperty("invalidUserId"));

        //Enter valid user password
        guru.password.sendKeys(ConfigReader.getProperty("password"));

        //click login
        guru.loginButton.click();

    }


    @Test
    public void invalidUserId_InvalidPassword() {
        //Go to http://www.demo.guru99.com/V4
        Driver.getDriver().get(ConfigReader.getProperty("guruUrl"));

        //Enter invalid user id
        guru=new Guru99();
        guru.userId.sendKeys(ConfigReader.getProperty("invalidUserId"));

        //Enter invalid user password
        guru.password.sendKeys(ConfigReader.getProperty("invalidPassword"));

        //click login
        guru.loginButton.click();

    }
}
