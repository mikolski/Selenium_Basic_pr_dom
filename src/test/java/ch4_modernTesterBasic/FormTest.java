package ch4_modernTesterBasic;

import ch3_testbase.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;
import java.util.Random;

public class FormTest extends TestBase {

    @Test
    public void shouldFillFormWithSuccess() {
        driver.get("https://seleniumui.moderntester.pl/form.php");

        WebElement firstName = driver.findElement(By.id("inputFirstName3"));
        firstName.sendKeys("Jan");

        WebElement lastName = driver.findElement(By.id("inputLastName3"));
        lastName.sendKeys("Kowalski");

        WebElement email = driver.findElement(By.id("inputEmail3"));
        email.sendKeys("email@email.com");

        List<WebElement> genders = driver.findElements(By.name("gridRadiosSex"));
        genders.get(0).click();

        WebElement age = driver.findElement(By.id("inputAge3"));
        age.sendKeys("18");

        List<WebElement> yearsOfExperience = driver.findElements(By.name("gridRadiosExperience"));
//        yearsOfExperience.get(2).click();

        getRandomElement(yearsOfExperience).click();

        List<WebElement> professions = driver.findElements(By.name("gridCheckboxProfession"));

        Assert.assertTrue(professions.size() > 0);

        for (WebElement profession : professions
        ) {
            profession.click();

        }

        Select continents = new Select(driver.findElement((By.id("selectContinents"))));

        continents.selectByIndex(6);
        //continents.selectByVisibleText("North America");

        Select seleniumCommands = new Select(driver.findElement((By.id("selectSeleniumCommands"))));
        seleniumCommands.selectByValue("navigation-commands");

        WebElement fileUpload = driver.findElement(By.id("chooseFile"));
        File file = new File("src/main/resources/file.txt");

        fileUpload.sendKeys(file.getAbsolutePath());

        //tutaj dopisz dalsza cześć testu


        WebElement signInButton = driver.findElement(By.className("btn-primary"));
        signInButton.click();


        String msg = driver.findElement((By.id("validator-message"))).getText();

        Assert.assertEquals(msg, "Form send with success");
    }

    public WebElement getRandomElement(List<WebElement> elements) {
        Random rnd = new Random();
        return elements.get(rnd.nextInt(elements.size()));
    }
}
