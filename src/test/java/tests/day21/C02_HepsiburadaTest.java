package tests.day21;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.HepsiburadaPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;
import java.time.Duration;

public class C02_HepsiburadaTest {


    HepsiburadaPage hepsiburadaPage;

    @Test
    public void test01() throws IOException {

        //hepsiburada sayfasina gidiniz
        Driver.getDriver().get("https://hepsiburada.com");

        //Elektronik menusune mouse ile yaklasin
        hepsiburadaPage=new HepsiburadaPage();
        ReusableMethods.hover(hepsiburadaPage.elektronikMenu);

        //Acilan menude bilgisayar/tablet altindaki tum linkleri tiklayin
        ReusableMethods.hover(hepsiburadaPage.bilgisayarTabletMenu);


        //Her linki tikladiktan sonra sayfa erisimini dogrulayin ve ana sayfaya geri donun
       for (int i = 0; i <hepsiburadaPage.bilgisayarTabletMenuList.size() ; i++) {
            hepsiburadaPage.bilgisayarTabletMenuList.get(i).click();
            Driver.getDriver().navigate().back();

            ReusableMethods.waitForPageToLoad(10);
            //Geri donuste sayfa yuklemesi gec oldugundan wait komutu eklendi

            WebDriverWait wait=new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
            wait.ignoring(StaleElementReferenceException.class).
            until(ExpectedConditions.elementToBeClickable(hepsiburadaPage.elektronikMenu));
            //Dongu ilerlediginde bazen html kodlarina erisimde sikinti yasadigi icin
           //StaleElementReferenceException verdi bunu handle etmek icin bu wait komutu yazildi

            ReusableMethods.hover(hepsiburadaPage.elektronikMenu);
            ReusableMethods.hover(hepsiburadaPage.bilgisayarTabletMenu);
        }

        //sayfayi kapatin
        Driver.getDriver().close();


    }

}
