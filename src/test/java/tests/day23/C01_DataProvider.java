package tests.day23;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C01_DataProvider {

    AmazonPage amazonPage;

   @DataProvider
    public static Object[][] aranacakKelimeler() {
        return new Object[][]{{"java"}, {"selenium"}, {"samsung"}, {"iphone"}};
    }

    @Test (dataProvider = "aranacakKelimeler")
    public void test01(String kelimeler) {
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        Driver.getDriver().navigate().refresh();

        amazonPage=new AmazonPage();

        //Selenium, java, samsung ve iphone icin arama yapın
        amazonPage.aramaKutusu.sendKeys(kelimeler, Keys.ENTER);

        //sonuclarin aradigimiz kelimeler icerdigini test edin
        String actualtext=amazonPage.aramaSonucuElementi.getText();
        Assert.assertTrue(actualtext.contains(kelimeler));
        System.out.println(actualtext);
        Driver.closeDriver();

    }


}
