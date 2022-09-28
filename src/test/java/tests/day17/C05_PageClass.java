package tests.day17;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.Driver;

public class C05_PageClass {

    @Test
    public void test01() {

        Driver.getDriver().get("https://amazon.com");

        AmazonPage amazon=new AmazonPage();

        System.out.println(amazon.aramaSonucuElementi.getText());

    }
}
