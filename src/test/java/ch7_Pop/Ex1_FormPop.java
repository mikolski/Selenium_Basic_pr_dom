package ch7_Pop;

import ch3_testbase.TestBase;
import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.FormPage;

import java.io.File;
import java.util.Locale;

public class Ex1_FormPop extends TestBase {

    private FormPage formPage;
    private File file = new File("src/main/resources/forTestingPurposeFile.txt");
    private Faker faker;
    private FakeValuesService fakeValuesService;
    private String firstName;
    private String lastName;

    @BeforeMethod
    public void testSetup() {
        formPage = new FormPage(driver);
        driver.get("https://seleniumui.moderntester.pl/form.php");
        faker = new Faker();
        fakeValuesService = new FakeValuesService(
                new Locale("en-GB"), new RandomService());
        firstName = faker.name().firstName();
        lastName = faker.name().lastName();
    }

    @Test
    public void shouldFillFirmWithSuccess() {

        formPage.setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(fakeValuesService.bothify("????##@gmail.com"))
                .selectRandomGender()
                .setAge(String.valueOf(faker.number().numberBetween(18, 100)))
                .selectRandomYearsOfExperience()
                .selectRandomProfession()
                .selectSeleniumCommand("wait-commands")
                .selectContinent("europe")
                .uploadFile(file)
                .signIn();

        Assert.assertEquals(formPage.getValidationMsg(), "Form send with success");

    }
}
