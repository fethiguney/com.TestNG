package tests.day16;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase_BeforeClass_AfterClass;
import utilities.TestBase_BeforeMethod_AfterMethod;

public class C04_DependsOnMethod extends TestBase_BeforeClass_AfterClass {


    @Test
    public void test01() {

        //Amazon ana sayfasina gidiniz
        driver.get("https://amazon.com");

    }

    @Test (dependsOnMethods = "test01")
    public void test02() {

        //Nutella aratin
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella", Keys.ENTER);

    }

    @Test (dependsOnMethods = "test02")
    public void test03() {

        //sonuc yazisinin amazon icerdigini test edin
        WebElement sonuc = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        Assert.assertFalse(sonuc.getText().contains("amazon"));
    }
}
