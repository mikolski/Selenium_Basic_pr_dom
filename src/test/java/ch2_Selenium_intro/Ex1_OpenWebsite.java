package ch2_Selenium_intro;

import ch3_testbase.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class Ex1_OpenWebsite extends TestBase {
    //WebDriver driver;



    @Test
    public void shouldOpenWebsite(){
//        WebDriverManager.chromedriver().setup();
//
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("start-maximized");

        //driver = new ChromeDriver(options);

        driver.get("https://seleniumui.moderntester.pl/");


    }

//    @AfterMethod
//    public void cleanUp(){
//        driver.quit();
//    }
}
