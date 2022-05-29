package ch7_waits;

import ch3_testbase.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Ex3_LoadinBar extends TestBase {

    @Test
    public void shouldWaitForProgressBar(){
        driver.get("https://seleniumui.moderntester.pl/progressbar.php");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //wait.until(ExpectedConditions.textToBe(By.cssSelector(".progress-label"), "Complete!"));

        wait.until(ExpectedConditions.attributeContains(
               By.cssSelector(".ui-progressbar-value"),"class","ui-progressbar-complete"));
    }
}
