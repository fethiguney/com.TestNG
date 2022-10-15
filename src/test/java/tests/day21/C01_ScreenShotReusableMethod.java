package tests.day21;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.AmazonPage;
import tests.log4J.Log4jTest2;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

public class C01_ScreenShotReusableMethod {

    private static Logger logger= LogManager.getLogger(Log4jTest2.class.getName());

    @Test
    public void test01() throws IOException {

        logger.info("Hepsiburada sitesine gidilir");
        //hepsiburada sayfasina gidiniz ve
        // ekran goruntusu aliniz
        Driver.getDriver().get("https://hepsiburada.com");

        logger.info("ekran goruntusu alinir");
        ReusableMethods.getScreenshot("hepsiburada");



    }

    AmazonPage amazonPage;
    @Test
    public void test02() throws IOException {
        //amazon sayfasina gidiniz
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

        //nutella aratiniz
        amazonPage=new AmazonPage();
        amazonPage.aramaKutusu.sendKeys("Nutella", Keys.ENTER);

        //arama sonuc yazisi webelementin ekran resmini aliniz
        ReusableMethods.getScreenshotWebElement("amazon",amazonPage.aramaSonucuElementi);

        Driver.getDriver().close();

    }
}
