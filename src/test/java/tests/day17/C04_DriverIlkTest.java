package tests.day17;

import org.testng.annotations.Test;
import utilities.Driver;

public class C04_DriverIlkTest {


    @Test
    public void test01() {

        Driver.getDriver().get("https://amazon.com");

        Driver.getDriver().get("https://youtube.com");

        Driver.closeDriver();


    }
}
