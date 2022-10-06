package tests.day23;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.BlueRentalCarPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.io.ObjectInputFilter;

public class C02_DataProvider {


    BlueRentalCarPage blueRentalCarPage;

    @DataProvider
    public static Object[][] kullanicilar() {
        return new Object[][]{{"fethi@gmail.com", "1234"}, {"guney@gmail.com", "2345"}, {"user@gmail.com", "9876"}};
    }

    @Test(dataProvider = "kullanicilar")
    public void test01(String userEmail, String password) {
        blueRentalCarPage=new BlueRentalCarPage();
        //https://www.bluerentalcars.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("bluerentalUrl"));

        //login butonuna bas
        blueRentalCarPage.login.click();

        //Data provider ile 3 farklı userEmail ve 3 farklı password girelim
        blueRentalCarPage.emailBar.sendKeys(userEmail);
        blueRentalCarPage.passwordBar.sendKeys(password);

        //login butonuna tiklayin
        blueRentalCarPage.loginClick.click();

        //Degerleri girildiginde sayfaya basarili sekilde girilemedigini test et
        Assert.assertTrue(blueRentalCarPage.login.isDisplayed());
    }
}
