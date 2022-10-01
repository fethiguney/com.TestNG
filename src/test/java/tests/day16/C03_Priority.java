package tests.day16;

import org.testng.annotations.Test;
import utilities.TestBase_BeforeMethod_AfterMethod;

public class C03_Priority extends TestBase_BeforeMethod_AfterMethod {

    @Test (priority = 3)
    public void amazonTest() {
        driver.get("https://amazon.com");


    }

    @Test (priority = 2)
    public void bestbuyTest() {

        driver.get("https://bestbuy.com");

    }

    @Test
    public void techproTest() {
        driver.get("https://techproeducation.com");

    }
}
