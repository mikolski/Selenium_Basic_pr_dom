package ch7_waits;

import ch3_testbase.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Ex2_DelayedAlert extends TestBase {

    @Test
    public void shouldWaitForAlert() {
        driver.get("https://seleniumui.moderntester.pl/alerts.php");

        WebElement alertButton = driver.findElement(By.cssSelector("#delayed-alert"));
        alertButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.alertIsPresent());

        driver.switchTo().alert().accept();

        WebElement simpleAlertText = driver.findElement(By.cssSelector("#delayed-alert-label"));
        Assert.assertEquals(simpleAlertText.getText(), "OK button pressed");


    }
}
