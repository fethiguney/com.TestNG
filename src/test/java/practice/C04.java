package practice;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestPagesJavaScriptPage;
import utilities.Driver;

import java.util.List;

public class C04 {

    TestPagesJavaScriptPage testpage;
    Actions actions;

    @Test
    public void test01() throws InterruptedException {

        //Go to https://testpages.herokuapp.com/styled/events/javascript-events.html
        Driver.getDriver().get("https://testpages.herokuapp.com/styled/events/javascript-events.html");

        // Click all the buttons and verify they are all clicked
        testpage=new TestPagesJavaScriptPage();
        actions=new Actions(Driver.getDriver());

        testpage.onblur.click();

        testpage.onclick.click();

        testpage.onclick.click();

        actions.contextClick(testpage.onContextMenu).perform();

        actions.doubleClick(testpage.onDoubleClick).perform();

        testpage.onFocus.click();

        actions.click(testpage.onKeyDown).
                sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.ENTER).perform();

        Thread.sleep(1000);

        actions.click(testpage.onKeyUp).
                sendKeys(Keys.PAGE_UP).
                sendKeys(Keys.ENTER).perform();

        Thread.sleep(1000);

        actions.click(testpage.onKeyPress).
                sendKeys(Keys.ENTER).perform();

        Thread.sleep(1000);

        actions.moveToElement(testpage.onMouseOver).perform();

        actions.moveToElement(testpage.onMouseLeave).
                moveToElement(testpage.onMouseOver).perform();

        testpage.onMouseDown.click();

        Thread.sleep(1000);



    }


    @Test (dependsOnMethods = "test01")
    public void test02() {

        List<WebElement> clickedElements=testpage.eventTriggeredText;
        Assert.assertEquals(clickedElements.size(), 11);

    }
}
