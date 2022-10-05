package tests.day22;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BlueRentalCarPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseReport;

public class C01_RaporluTest extends TestBaseReport {


    BlueRentalCarPage blueRentalCarPage;

    @Test
    public void test01() {
        extentTest=extentReports.createTest("Pozitif Test","Gecerli kullanici adi ve password ile giris");

    // -https://www.bluerentalcars.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("bluerentalUrl"));
        extentTest.info("Blue rentalCar sitesine gidildi");

        //    -login butonuna bas
        blueRentalCarPage=new BlueRentalCarPage();
        blueRentalCarPage.login.click();
        extentTest.info("Login butonuna tiklandi");


        //    -test data user email: customer@bluerentalcars.com ,
        //    -test data password : 12345
        //    dataları girip login e basın
        blueRentalCarPage.emailBar.sendKeys(ConfigReader.getProperty("blueRentUserEmail"));
        extentTest.info("Gecerli email girildi");

        blueRentalCarPage.passwordBar.sendKeys(ConfigReader.getProperty("blueRentPassword"));
        extentTest.info("Gecerli sifre girildi");

        //    -login butonuna tiklayin
        blueRentalCarPage.loginClick.click();
        extentTest.info("Login butonuna tiklandi");

        //    -Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        String actualUserName=blueRentalCarPage.ddmBar.getText();
        String expectedUserName="John Walker";
        Assert.assertEquals(actualUserName, expectedUserName);
        extentTest.info("Sayfaya basarili giris yapildi");



    }
}
