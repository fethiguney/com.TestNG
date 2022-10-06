package practice;

import com.mongodb.operation.DropUserOperation;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AutomationExercisePage;
import utilities.Driver;

public class SearchProductTest {

    SoftAssert softAssert;
    AutomationExercisePage automationExercisePage;

    @Test
    public void test01() {

        softAssert=new SoftAssert();
        automationExercisePage=new AutomationExercisePage();

        // 1. Tarayıcıyı başlat
        // 2. 'http://automationexercise.com' url'sine gidin
        Driver.getDriver().get("https://automationexercise.com");

        // 3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
        String homeUrl="https://automationexercise.com/";
        String actualUrl=Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(homeUrl, actualUrl);

        // 4. 'Ürünler' butonuna tıklayın
        automationExercisePage.products.click();

        // 5. Kullanıcının TÜM ÜRÜNLER sayfasına başarıyla gittiğini doğrulayın
        String productsUrl="https://automationexercise.com/products";
        softAssert.assertEquals(Driver.getDriver().getCurrentUrl(), productsUrl);

        // 6. Arama girişine ürün adını girin ve ara düğmesine tıklayın
        automationExercisePage.productSearchBar.sendKeys("blue top");

        automationExercisePage.productSearchBarClick.click();

        // 7. 'ARARAN ÜRÜNLER'in görünür olduğunu doğrulayın
        softAssert.assertTrue(automationExercisePage.searchedProductsText.isDisplayed());

        // 8. Aramayla ilgili ürünün ("blue top") görünür olduğunu doğrulayın
        automationExercisePage.viewProduct.click();

        softAssert.assertTrue(automationExercisePage.blueTopText.isDisplayed());

    }
}
