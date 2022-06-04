package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.List;
import java.util.Random;

public class FormPage {
    public FormPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#inputFirstName3")
    private WebElement firstName;

    @FindBy(css = "#inputLastName3")
    private WebElement lastName;

    @FindBy(css = "#inputEmail3")
    private WebElement email;

    @FindBy(css = "#inputAge3")
    private WebElement age;

    @FindBy(css = "[name='gridRadiosSex']")
    private List<WebElement> genders;

    @FindBy(css = "#selectContinents")
    private WebElement selectContinents;

    @FindBy(css = "#selectSeleniumCommands")
    private WebElement selectSeleniumCommands;

    @FindBy(css = "#validator-message")
    private WebElement validationMsg;

    @FindBy(css = "[name='gridRadiosExperience']")
    private List<WebElement> yearsOfExperience;

    @FindBy(css = "[name='gridCheckboxProfession']")
    private List<WebElement> professions;

    @FindBy(css = "#chooseFile")
    private WebElement fileUpload;

    @FindBy(css = ".btn-primary")
    private WebElement signInButton;

    public FormPage signIn() {
        signInButton.click();
        return this;
    }

    public FormPage uploadFile(File file) {
        fileUpload.sendKeys(file.getAbsolutePath());
        return this;
    }

    public FormPage setFirstName(String firstName) {
        this.firstName.sendKeys(firstName);
        return this;
    }

    public FormPage setLastName(String lastName) {
        this.lastName.sendKeys(lastName);
        return this;
    }

    public FormPage setEmail(String email) {
        this.email.sendKeys(email);
        return this;

    }

    public FormPage setAge(String age) {
        this.age.sendKeys(age);
        return this;
    }

    public FormPage selectRandomGender() {
        getRandomElement(genders).click();
        return this;
    }

    public FormPage selectRandomProfession() {
        getRandomElement(professions).click();
        return this;
    }

    public FormPage selectContinent(String continent) {
        new Select(selectContinents).selectByValue(continent);
        return this;
    }

    public FormPage selectSeleniumCommand(String command) {
        new Select(selectSeleniumCommands).selectByValue(command);
        return this;
    }

    public FormPage selectRandomYearsOfExperience() {
        getRandomElement(yearsOfExperience).click();
        return this;
    }

    public String getValidationMsg() {
        return validationMsg.getText();
    }

    public WebElement getRandomElement(List<WebElement> elements) {
        Random rnd = new Random();
        int randomListIndex = rnd.nextInt(elements.size());
        return elements.get(randomListIndex);
    }
}
