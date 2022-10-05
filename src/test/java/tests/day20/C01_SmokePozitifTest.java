package tests.day20;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelMyCampPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C01_SmokePozitifTest {

    @Test
    public void test01() {


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

        Driver.getDriver().close();

    }
}
