package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class TestBase_BeforeMethod_AfterMethod {

    protected WebDriver driver;

    LocalDateTime date=LocalDateTime.now();
    DateTimeFormatter formatter=DateTimeFormatter.ofPattern("YYYYMMddhhmmss");
    protected String tarih=date.format(formatter);

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @AfterMethod
    public void tearDown(){
     driver.quit();
    }



}
