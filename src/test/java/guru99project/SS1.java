package guru99project;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Guru99;
import utilities.ConfigReader;
import utilities.Driver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class SS1 {

    Guru99 guru;

    @Test
    public void validUserId_ValidPassword() throws IOException {

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

        //Verify managerID shown in o/p
        Assert.assertTrue(guru.managerIdtext.isDisplayed());

        //Take screenshot of o/p
        TakesScreenshot ts= (TakesScreenshot) Driver.getDriver();
        File output=ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(output, new File("target/ekranresmi/guru99.jpeg"));


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
    public void invalidUserId_InvalidPassword() throws InterruptedException {
        //Go to http://www.demo.guru99.com/V4
        Driver.getDriver().get(ConfigReader.getProperty("guruUrl"));

        //Enter invalid user id
        guru=new Guru99();
        guru.userId.sendKeys(ConfigReader.getProperty("invalidUserId"));

        //Enter invalid user password
        guru.password.sendKeys(ConfigReader.getProperty("invalidPassword"));

        //click login
        guru.loginButton.click();

        Thread.sleep(2000);

        //A pop-up "User or Password is not valid" is shown
        WebDriverWait wait=new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alt=Driver.getDriver().switchTo().alert();
        String actualMessage=alt.getText();
        alt.accept();
        Assert.assertTrue(actualMessage.contains(ConfigReader.getProperty("loginfailedmessage")));


    }
}
