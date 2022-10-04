package practice;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.WebUniversityPage;
import utilities.Driver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C03 {

    WebUniversityPage webUniversityPage;

    @Test
    public void test01() {

        // http://webdriveruniversity.com/To-Do-List/index.html adresine gidin
        Driver.getDriver().get("http://webdriveruniversity.com/To-Do-List/index.html");

        // Todos ekle: (Kahvaltıyı hazırla,
        // Bulaşıkları yıka,
        //Bebekle ilgilen,
        // Çocuğunun ödevine yardım et,
        // Selenyum çalış, Uyu)
        List<String> workList=new ArrayList<>(Arrays.asList("Kahvaltiyi hazirla",
                "Bulasiklari yika","Bebekle ilgilen","Cocugun odevine yardim et","Selenyum calis","Uyu"));
        webUniversityPage=new WebUniversityPage();
        for (String each:workList) {
            webUniversityPage.toDoAdd.sendKeys(each, Keys.ENTER);
        }

        //Tüm yapılacakların üzerini çiz.
        webUniversityPage.toDoList.forEach(WebElement::click);

        //Tüm yapılacakları sil.
        webUniversityPage.toDoListErase.forEach(WebElement::click);

        //Tüm yapılacakların silindiğini doğrulayın.
        Assert.assertTrue(webUniversityPage.toDoAdd.getText().isEmpty());



    }
}
