package tests.day17;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.Driver;

public class C07_SoftAssertYouTubeTest {

        //https://www.youtube.com adresinegidin

    SoftAssert softAssert=new SoftAssert();

    @Test
    public void titleTest() {
        // Sayfa başlığının “YouTube” oldugunu testedin

        Driver.getDriver().get("https://www.youtube.com");
        softAssert.assertTrue(Driver.getDriver().getTitle().equals("YouTube"));

    }

    @Test
    public void imageTest() {
        //YouTube resminin görüntülendiğini (isDisplayed()) testedin
    }

    @Test
    public void searchBoxTest() {
        //Search Box 'in erisilebilir oldugunu test edin (isEnabled())

    }

    @Test
    public void wrongTitleTest() {
        //wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin

    }
}
