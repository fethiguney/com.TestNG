package practice;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SaucedemoPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02 {
    @Test
    public void test01() {
        //     * Navigate to  https://www.saucedemo.com/
        Driver.getDriver().get(ConfigReader.getProperty("saucedemoUrl"));

        //     * Enter the username  as standard_user
        SaucedemoPage saucedemoPage=new SaucedemoPage();

        saucedemoPage.username.sendKeys(ConfigReader.getProperty("saucedemoUserName"));

        //     * Enter the password as   secret_sauce
        saucedemoPage.password.sendKeys(ConfigReader.getProperty("saucedemoPassword"));

        //     * Click on login button
        saucedemoPage.loginButton.click();

        //     * Choose price low to high
        Select select=new Select(saucedemoPage.dropDownMenu);
        select.selectByVisibleText("Price (low to high)");

        //       and verify that PRICE (LOW TO HIGH) is visible
        Assert.assertTrue(saucedemoPage.lowToHighOption.isDisplayed());


    }



}
