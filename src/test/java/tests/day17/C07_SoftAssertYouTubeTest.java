package tests.day17;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.YouTubePage;
import utilities.Driver;

public class C07_SoftAssertYouTubeTest {

        //https://www.youtube.com adresinegidin

    SoftAssert softAssert=new SoftAssert();
    YouTubePage youtube=new YouTubePage();

    @Test (priority = 0)
    public void titleTest() {
        // Sayfa başlığının “YouTube” oldugunu testedin

        Driver.getDriver().get("https://www.youtube.com");
        softAssert.assertTrue(Driver.getDriver().getTitle().equals("YouTube"));

    }

    @Test (priority = 1)
    public void imageTest() {
        //YouTube resminin görüntülendiğini (isDisplayed()) testedin
        softAssert.assertTrue(youtube.youTubeLogo.isDisplayed());

    }

    @Test (priority = 2)
    public void searchBoxTest() {
        //Search Box 'in erisilebilir oldugunu test edin (isEnabled())
        softAssert.assertTrue(youtube.searchbox.isEnabled());
    }

    @Test (priority = 3)
    public void wrongTitleTest() {
        //wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
        softAssert.assertTrue(Driver.getDriver().getTitle().equals("youtube"));
        softAssert.assertAll();
    }

}
