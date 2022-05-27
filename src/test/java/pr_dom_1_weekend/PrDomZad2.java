package pr_dom_1_weekend;

import ch3_testbase.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.Time;
import java.sql.Timestamp;

public class PrDomZad2 extends TestBase {

    @Test
    public void shouldCreateAccountHarder(){
        //1. Wejść na stronę http://146.59.32.4/index.php
        driver.get("http://146.59.32.4/index.php");

        //2. Kliknąć ‘sign in’
        WebElement singInLink = driver.findElement(By.cssSelector("#_desktop_user_info a"));
        singInLink.click();

        //3. Kliknąć ‘No account? Create one here’
        WebElement noAcountLink = driver.findElement(By.cssSelector(".no-account a"));
        noAcountLink.click();

        //4. Wypełnić wymagane pola formularza (tutaj znaleźć sposób na to aby generować za każdym razem przy uruchomieniu jakiś losowy email -> dzięki temu można cały czas puszczać test rejestracji bo za każdym razem będzie unikalny email)
        WebElement firstNameField = driver.findElement(By.cssSelector("#customer-form [name='firstname']"));
        WebElement lastNameField = driver.findElement(By.cssSelector("#customer-form [name='lastname']"));;
        WebElement emailField = driver.findElement(By.cssSelector("#customer-form [name='email']"));;
        WebElement passwordField = driver.findElement(By.cssSelector("#customer-form [name='password']"));;
        WebElement customerDataPrivacyFieldCheckbox = driver.findElement(By.cssSelector("#customer-form [name='customer_privacy']"));;
        WebElement generalTermsAcceptanceCheckbox = driver.findElement(By.cssSelector("#customer-form [name='psgdpr']"));;
        WebElement saveButton = driver.findElement(By.cssSelector("#customer-form button.form-control-submit"));;

        String firstName = "Jan";
        String lastName = "Kowalski";
        String email = System.currentTimeMillis()+"@email.com";
        String password = "Password123";

        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        customerDataPrivacyFieldCheckbox.click();
        generalTermsAcceptanceCheckbox.click();

        //5. Kliknąć przycisk ‘save’
        saveButton.click();

        //6. Sprawdzić Asercją czy w prawy górnym roku obok koszyka pojawi się tekst równy „imię nazwisko” -> oczywiście te które zostały użyte do wypełnienia formularza
        WebElement customerNameInfo = driver.findElement(By.cssSelector("#_desktop_user_info .account"));
        Assert.assertEquals(firstName+" "+lastName, customerNameInfo.getText());
    }
}
