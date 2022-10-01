package tests.day18;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FaceBookPage;
import utilities.Driver;

public class C01_FaceBookTest {


    //POM’a uygun olarak email, sifre kutularini ve giris yap
    //butonunu locate edin
    //Faker class’ini kullanarak email ve sifre degerlerini
    //yazdirip, giris butonuna basin
    //Basarili giris yapilamadigini test edin


    @Test
    public void testName() {
        //https://www.facebook.com/ adresine gidin
        Driver.getDriver().get("https://www.facebook.com");

        Faker faker=new Faker();
        FaceBookPage faceBook=new FaceBookPage();

        faceBook.email.sendKeys(faker.internet().emailAddress());

        faceBook.password.sendKeys(faker.internet().password());

        faceBook.girisbutonu.click();

        Assert.assertTrue(faceBook.uyarıMesaji.isDisplayed());

        Driver.closeDriver();


    }
}
