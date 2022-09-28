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
//Bir class oluşturun: DependsOnTest
//https://www.amazon.com/ adresine gidin.
//Test : Amazon ana sayfaya gittiginizi test edin
//Test : 1.Test basarili ise search Box’i kullanarak “Nutella” icin
//arama yapin ve aramanizin gerceklestigini Test edin
//Test : “Nutella” icin arama yapildiysa ilk urunu tiklayin ve fiyatinin
//$16.83 oldugunu test edin