package tests.day20;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.devtools.v94.input.model.DragDataItem;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelMyCampPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.time.Duration;

public class C03_E2ETest {

    @Test
    public void E2ETest() {

        //https://www.hotelmycamp.com adresine git.
        Driver.getDriver().get(ConfigReader.getProperty("hotelMyCampUrl"));

        HotelMyCampPage hotelMyCampPage=new HotelMyCampPage();
        hotelMyCampPage.homePagelogin.click();

        //Username : manager
        //Password  : Manager1!
        //Login butonuna tıklayın.

        hotelMyCampPage.username.sendKeys(ConfigReader.getProperty("hotelMyCampUserName"));

        hotelMyCampPage.password.sendKeys(ConfigReader.getProperty("hotelMyCampPassword"));

       hotelMyCampPage.loginClickButton.click();
        //Hotel Management/Room reservation menusunden ADD ROOM RESERVATION butonuna tiklayin

       hotelMyCampPage.hotelManagement.click();

       hotelMyCampPage.roomReservation.click();

       hotelMyCampPage.addRoomReservation.click();

       //Açılan sayfadaki tüm metin kutularına istediğiniz verileri girin.

        hotelMyCampPage.idUserSelectMenu.sendKeys(ConfigReader.getProperty("hotelMyCampUserName"));

        Faker faker=new Faker();
        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(Keys.TAB).sendKeys("Happy Hotel").
                sendKeys(Keys.TAB).sendKeys("2000").
                sendKeys(Keys.TAB).sendKeys("10/03/2022").sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).sendKeys("10/10/2022").sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).sendKeys("2").
                sendKeys(Keys.TAB).sendKeys("1").
                sendKeys(Keys.TAB).sendKeys(faker.name().fullName()).
                sendKeys(Keys.TAB).sendKeys(faker.phoneNumber().cellPhone()).
                sendKeys(Keys.TAB).sendKeys(faker.internet().emailAddress()).
                sendKeys(Keys.TAB).sendKeys("Notes").
                sendKeys(Keys.TAB).sendKeys(Keys.ENTER).
                sendKeys(Keys.TAB).sendKeys(Keys.ENTER).
                sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
        //Save butonuna tıklayın.

        WebDriverWait wait=new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(hotelMyCampPage.roomReservationInsertedText));


        //“RoomReservation was inserted successfully” textinin göründüğünü test edin.
        Assert.assertTrue(hotelMyCampPage.roomReservationInsertedText.isDisplayed());

        //OK butonuna tıklayın.
        hotelMyCampPage.roomReservationInsertedText.click();

        Driver.getDriver().close();
    }
}
