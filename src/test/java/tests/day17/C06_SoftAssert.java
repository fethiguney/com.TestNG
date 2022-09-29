package tests.day17;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase_BeforeMethod_AfterMethod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class C06_SoftAssert extends TestBase_BeforeMethod_AfterMethod {


    @Test
    public void test01() {

        SoftAssert softAssert=new SoftAssert();

        //“http://zero.webappsecurity.com/” Adresine gidin
        driver.get("http://zero.webappsecurity.com");

        //Sign in butonuna basin
        driver.findElement(By.xpath("//*[@id='signin_button']")).click();

        //Login kutusuna “username” yazin
        driver.findElement(By.xpath("//*[@id='user_login']")).sendKeys("username");

        //Password kutusuna “password” yazin
        driver.findElement(By.xpath("//*[@id='user_password']")).sendKeys("password");

        //Sign in tusuna basin
        driver.findElement(By.xpath("//*[@name='submit']")).click();
        driver.navigate().back();

        //Online banking menusu icinde Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//*[@id='onlineBankingMenu']")).click();
        driver.findElement(By.xpath("//*[@id='pay_bills_link']")).click();

        //“Purchase Foreign Currency” tusuna basin
        driver.findElement(By.xpath("//*[text()='Purchase Foreign Currency']")).click();

        //“Currency” drop down menusunden Eurozone’u secin
        WebElement ddm=driver.findElement(By.xpath("//*[@id='pc_currency']"));
        Select select=new Select(ddm);
        select.selectByVisibleText("Eurozone (euro)");

        //soft assert kullanarak "Eurozone (Euro)" secildigini test edin
        String actualOption=select.getFirstSelectedOption().getText();
        String expectedOption="Eurozone (Euro)";
        softAssert.assertEquals(actualOption, expectedOption, "secilen secenek beklenen degere esit degil");


        //soft assert kullanarak DropDown listesinin su secenekleri oldugunu test edin
        List<String> expectedOptionsList=new ArrayList<>(Arrays.asList("Select One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)",
                "China (yuan)","Denmark (krone)","Eurozone (euro)","Great Britain (pound)",
                "Hong Kong (dollar)","Japan (yen)","Mexico (peso)","Norway (krone)",
                "New Zealand (dollar)","Sweden (krona)","Singapore (dollar)","Thailand (baht)"));

        Collections.sort(expectedOptionsList);


       List<WebElement> actualOptionsWE=select.getOptions();
        List<String> actualOptionsList=new ArrayList<>();
        for (int i = 0; i <actualOptionsWE.size() ; i++) {
            actualOptionsList.add(actualOptionsWE.get(i).getText());
        }
        Collections.sort(actualOptionsList);

        softAssert.assertTrue(actualOptionsList.containsAll(expectedOptionsList), "Listeler birbirine esit degil");
        softAssert.assertAll();



    }
}
