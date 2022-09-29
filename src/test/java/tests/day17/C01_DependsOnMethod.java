package tests.day17;

import org.testng.annotations.Test;
import utilities.TestBase_BeforeMethod_AfterMethod;

public class C01_DependsOnMethod extends TestBase_BeforeMethod_AfterMethod {


    @Test
    public void test01() {
        driver.get("https://amazon.com");
    }

    @Test (dependsOnMethods = "test01")
    public void test02() {
        driver.get("https://youtube.com");
    }
}
