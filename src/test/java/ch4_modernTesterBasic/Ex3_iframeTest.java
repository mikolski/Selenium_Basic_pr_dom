package ch4_modernTesterBasic;

import ch3_testbase.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Ex3_iframeTest extends TestBase {

    @Test
    public void shouldFillFormIniframes() {
        driver.get("https://seleniumui.moderntester.pl/iframes.php");


        driver.switchTo().frame("iframe1");
        //wszystki szuka tylko w iframe
        WebElement inputFirstName = driver.findElement(By.cssSelector("#inputFirstName3"));

        inputFirstName.sendKeys("Jan");

        //trzeba wyjść z iframe
        driver.switchTo().defaultContent();

        driver.switchTo().frame("iframe2");
        WebElement inputLogin = driver.findElement(By.cssSelector("#inputLogin"));

        inputLogin.sendKeys("Jan123");

        WebElement inputPassword = driver.findElement(By.cssSelector("#inputPassword"));

        inputPassword.sendKeys("Password");





    }

}
