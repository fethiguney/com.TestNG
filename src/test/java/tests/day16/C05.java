package tests.day16;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utilities.TestBase_BeforeMethod_AfterMethod;

import java.time.Duration;

public class C05 extends TestBase_BeforeMethod_AfterMethod {

    //hotelmycamp anasayfasinagidin
    //2 farkli test method’u olusturarak actions class'i ve JsExecutor
    // kullanarak asagidaki oda turlerinden ust sira ortadaki odayi tiklayin
    //istediginiz oda inceleme sayfasi acildigini test edin

    @Test
    public void actionTest() {

        driver.get("https://www.hotelmycamp.com");

        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).perform();

        WebElement ortadakiOda=driver.findElement(By.xpath("(//h3[@class='mb-3'])[2]"));
        ortadakiOda.click();


        }

    @Test
    public void JsExecutorTest() {
        driver.get("https://www.hotelmycamp.com");
        WebElement ortadakiOda=driver.findElement(By.xpath("(//*[@class='btn-custom'])[2]"));

        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", ortadakiOda);

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(ortadakiOda));

        js.executeScript("arguments[0].click();", ortadakiOda);


    }
}
