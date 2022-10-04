package tests.day21;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.List;

public class C02_WindowHandleReusableMethod {

    @Test
    public void test01() {
        //● https://the-internet.herokuapp.com/windows adresine gidin.
        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");

        //● Click Here butonuna basın.
        Driver.getDriver().findElement(By.xpath("//*[text()='Click Here']")).click();

        // acilan yeni tab'in title'inin "New Window" oldugunu test edin
        List<String> windowHandleList=new ArrayList<>(Driver.getDriver().getWindowHandles());
        Driver.getDriver().switchTo().window(windowHandleList.get(1));
        String actualTitle=Driver.getDriver().getTitle();
        String expectedTitle="New Window";

        Assert.assertEquals(actualTitle,expectedTitle);



    }

    @Test
    public void test02() {
        //● https://the-internet.herokuapp.com/windows adresine gidin.
        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");

        //● Click Here butonuna basın.
        Driver.getDriver().findElement(By.xpath("//*[text()='Click Here']")).click();

        // acilan yeni tab'in title'inin "New Window" oldugunu test edin
        ReusableMethods.switchToWindow("New Window");

        String actualTitle=Driver.getDriver().getTitle();
        String expectedTitle="New Window";

        Assert.assertEquals(actualTitle,expectedTitle);

        Driver.getDriver().quit();


    }
}
