package tests.day18;

import org.junit.Assert;
import org.testng.annotations.Test;
import pages.HotelMyCampPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_PositiveLoginTest {

    @Test
    public void test01() {

        //Bir test method olustur positiveLoginTest()
        // https://www.hotelmycamp.com/ adresine git
        String url= ConfigReader.getProperty("hotelMyCampUrl");
        Driver.getDriver().get(url);

        // login butonuna bas
        HotelMyCampPage hotelMyCampPage=new HotelMyCampPage();
        hotelMyCampPage.homePagelogin.click();

        //test data username: manager ,
        // test data password :Manager1!
        String username=ConfigReader.getProperty("hotelMyCampUserName");
        String password=ConfigReader.getProperty("hotelMyCampPassword");

        hotelMyCampPage.username.sendKeys(username);
        hotelMyCampPage.password.sendKeys(password);
        hotelMyCampPage.loginClickButton.click();

        //Degerleri girildiginde sayfaya basarili sekilde
        // girilebildigini testet
        Assert.assertTrue(hotelMyCampPage.verifyLogin.isEnabled());
    }
}
