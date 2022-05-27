package ch4_modernTesterBasic;

import ch3_testbase.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Ex2_alerts_test extends TestBase {

    @BeforeMethod
    public void testSetup(){
        driver.get("https://seleniumui.moderntester.pl/alerts.php");
    }

    @Test
    public void shouldAcceptAlert(){

        //click simple alert
        WebElement simpleAlertButton = driver.findElement(By.cssSelector("#simple-alert"));
        simpleAlertButton.click();
        //click ok
        driver.switchTo().alert().accept();
        //assert text
        WebElement simpleAlertText = driver.findElement(By.cssSelector("#simple-alert-label"));
        Assert.assertEquals(simpleAlertText.getText(), "OK button pressed");
    }

    @Test
    public void shouldFillPromptAlert(){
        WebElement promptAlertButton = driver.findElement(By.cssSelector("#prompt-alert"));
        promptAlertButton.click();

        String name = "Jan";
        driver.switchTo().alert().sendKeys(name);
        driver.switchTo().alert().accept();

        WebElement promptAlertLabel = driver.findElement(By.cssSelector("#prompt-label"));
        Assert.assertEquals(promptAlertLabel.getText(), "Hello "+name+"! How are you today?");



    }

    @Test
    public void shouldDismissAlert() {
        WebElement confirmAlertButton = driver.findElement(By.cssSelector("#confirm-alert"));
        confirmAlertButton.click();

        driver.switchTo().alert().dismiss();

        WebElement confirmAlertText = driver.findElement(By.cssSelector("#confirm-label"));
        Assert.assertEquals(confirmAlertText.getText(), "You pressed Cancel!");

    }

}
