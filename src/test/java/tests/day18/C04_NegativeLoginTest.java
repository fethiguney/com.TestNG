package tests.day18;

import org.testng.annotations.Test;
import pages.HotelMyCampPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C04_NegativeLoginTest {

    @Test
    public void test01() {

        //https://www.hotelmycamp.com/ adresinegit
        Driver.getDriver().get(ConfigReader.getProperty("hotelMyCampUrl"));

        //login butonuna bas
        HotelMyCampPage hotelMyCampPage=new HotelMyCampPage();
        hotelMyCampPage.homePagelogin.click();

        //test data username: manager1, test data password :manager1!
        hotelMyCampPage.username.sendKeys(ConfigReader.getProperty("hotelMyCampInvalidUserName"));

        hotelMyCampPage.password.sendKeys(ConfigReader.getProperty("hotelMyCampInvalidPassword"));

        hotelMyCampPage.loginClickButton.click();

        //Degerleri girildiginde sayfaya girilemedigini test et
        hotelMyCampPage.loginFailed.isDisplayed();



    }
}
