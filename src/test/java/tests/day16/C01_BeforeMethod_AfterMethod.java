package tests.day16;

import org.testng.annotations.Test;
import utilities.TestBase_BeforeClass_AfterClass;
import utilities.TestBase_BeforeMethod_AfterMethod;

public class C01_BeforeMethod_AfterMethod extends TestBase_BeforeMethod_AfterMethod {

    @Test
    public void amazonTest() {
        driver.get("https://amazon.com");

    }

    @Test
    public void bestbuyTest() {

        driver.get("https://bestbuy.com");

    }

    @Test
    public void techproTest() {
        driver.get("https://techproeducation.com");

    }
}
