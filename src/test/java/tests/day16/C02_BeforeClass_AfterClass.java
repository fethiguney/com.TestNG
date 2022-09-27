package tests.day16;

import org.testng.annotations.Test;
import utilities.TestBase_BeforeClass_AfterClass;

public class C02_BeforeClass_AfterClass extends TestBase_BeforeClass_AfterClass {


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
