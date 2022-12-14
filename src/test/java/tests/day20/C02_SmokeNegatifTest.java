package tests.day20;

import org.testng.annotations.Test;
import pages.HotelMyCampPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_SmokeNegatifTest {

    HotelMyCampPage hotelMyCampPage;

    @Test (priority = 1, groups = "grp1")
    public void InvalidUserAndPassword() {

        //https://www.hotelmycamp.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("hotelMyCampUrl"));

        //login butonuna bas
        hotelMyCampPage=new HotelMyCampPage();
        hotelMyCampPage.homePagelogin.click();

        //test data username: manager1, test data password :manager1!
        hotelMyCampPage.username.sendKeys(ConfigReader.getProperty("hotelMyCampInvalidUserName"));

        hotelMyCampPage.password.sendKeys(ConfigReader.getProperty("hotelMyCampInvalidPassword"));

        hotelMyCampPage.loginClickButton.click();

        //Degerleri girildiginde sayfaya girilemedigini test et
        hotelMyCampPage.loginFailed.isDisplayed();



    }

    @Test(priority =2, groups = "grp1")
    public void InvalidUser() {
        //https://www.hotelmycamp.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("hotelMyCampUrl"));

        //login butonuna bas
        hotelMyCampPage=new HotelMyCampPage();
        hotelMyCampPage.homePagelogin.click();

        //test data username: manager1, test data password :manager1!
        hotelMyCampPage.username.sendKeys(ConfigReader.getProperty("hotelMyCampInvalidUserName"));

        hotelMyCampPage.password.sendKeys(ConfigReader.getProperty("hotelMyCampPassword"));

        hotelMyCampPage.loginClickButton.click();

        //Degerleri girildiginde sayfaya girilemedigini test et
        hotelMyCampPage.loginFailed.isDisplayed();



    }


    @Test (priority = 3, groups = "grp1")
    public void InvalidPassWord() {
        //https://www.hotelmycamp.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("hotelMyCampUrl"));

        //login butonuna bas
        hotelMyCampPage=new HotelMyCampPage();
        hotelMyCampPage.homePagelogin.click();

        //test data username: manager1, test data password :manager1!
        hotelMyCampPage.username.sendKeys(ConfigReader.getProperty("hotelMyCampUserName"));

        hotelMyCampPage.password.sendKeys(ConfigReader.getProperty("hotelMyCampInvalidPassword"));

        hotelMyCampPage.loginClickButton.click();

        //Degerleri girildiginde sayfaya girilemedigini test et
        hotelMyCampPage.loginFailed.isDisplayed();

        Driver.getDriver().close();

    }
}
