package tests.day18;

import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class C03_TestConfigReader {


    @Test
    public void test01() {

        String amazonUrl=ConfigReader.getProperty("amazonUrl");
        String facebookUrl=ConfigReader.getProperty("facebookUrl");

        Driver.getDriver().get(amazonUrl);

        Driver.getDriver().get(facebookUrl);
    }
}
