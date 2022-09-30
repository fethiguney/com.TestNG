package tests.day17;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase_BeforeMethod_AfterMethod;

public class C03_SoftAssert extends TestBase_BeforeMethod_AfterMethod {


    @Test
    public void test01() {

        SoftAssert softAssert=new SoftAssert();

        //1-amazon anasayfaya gidin
        driver.get("https://amazon.com");
        driver.navigate().refresh();

        //2-title in Amazon içerdigini test edin
        softAssert.assertTrue(driver.getTitle().contains("Amazon"));

        //3-arama kutusnun erişilebilir oldugunu tets edin
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        softAssert.assertTrue(searchBox.isEnabled());

        //4-arama kutusuna Nuella yazıp aratın
        searchBox.sendKeys("Nutella", Keys.ENTER);

        //5-arama yapıldıgını test edin
        WebElement resultWE = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        softAssert.assertTrue(resultWE.isDisplayed());

        //6-arama sonucunun Nutella içerdigini test edin
        softAssert.assertTrue(resultWE.getText().contains("Nutella"));

        softAssert.assertAll();
    }
}
