package practice;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.DhtmlgoodiesPage;
import utilities.Driver;

public class C01 {

    // Go to URL : http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html
    // Fill in capitals by country.


    @Test
    public void test01() {
        Driver.getDriver().get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");

        DhtmlgoodiesPage goodpage=new DhtmlgoodiesPage();

        Actions actions=new Actions(Driver.getDriver());
        actions.dragAndDrop(goodpage.copenhagen, goodpage.denmark).
                dragAndDrop(goodpage.seoul, goodpage.soutKorea).
                dragAndDrop(goodpage.rome, goodpage.italy).
                dragAndDrop(goodpage.madrid, goodpage.spain).
                dragAndDrop(goodpage.oslo, goodpage.norway).
                dragAndDrop(goodpage.stockholm, goodpage.sweden).
                dragAndDrop(goodpage.washington, goodpage.us).perform();


    }
}
