package tests.day23;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C03_DataProvider {



    @DataProvider
    public static Object[][] aranacakKelimeler() {
        return new Object[][]{{"amazonUrl", 5}, {"facebookUrl", 7}, {"saucedemoUrl", 10} };
    }

    @Test (dataProvider = "aranacakKelimeler")
    public void test01(String kelimeler, int sayi) {
        Driver.getDriver().get(ConfigReader.getProperty(kelimeler));
        Driver.getDriver().navigate().refresh();


    }

    @DataProvider
    public static Object[][] siteler() {
        return new Object[][]{{"https://amazon.com"}, {"https://facebook.com"} };
    }

    @Test(dataProvider = "siteler")
    public void test02(String site) {

            Driver.getDriver().get(site);
            Driver.getDriver().navigate().refresh();


        }





}
