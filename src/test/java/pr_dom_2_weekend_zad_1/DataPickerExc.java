package pr_dom_2_weekend_zad_1;

import ch3_testbase.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class DataPickerExc extends TestBase {

    @Test
    public void shouldChooseDate(){
        String dateToChoose = "08/31/2022";
        //1. Wejdź na stronę https://seleniumui.moderntester.pl/datepicker.php
        driver.get("https://seleniumui.moderntester.pl/datepicker.php");

        //2. Wybierz datę 31 August 2022 (dokładnie tą )
        WebElement datePicker = driver.findElement(By.cssSelector("#datepicker"));
        datePicker.click();

        WebElement dataPickerNextMonth = driver.findElement(By.cssSelector(".ui-datepicker-next"));
        WebElement dataPickerPreviousMonth = driver.findElement(By.cssSelector(".ui-datepicker-prev"));

        //TODO - zrobić pętlę żeby dowolną date dało się wybierać w przyszłosci czy przeszłosci

        dataPickerNextMonth.click();
        // jeszcze raz trzeba wyszukać żeby uniknąć stale object Exception
        dataPickerNextMonth = driver.findElement(By.cssSelector(".ui-datepicker-next"));
        dataPickerNextMonth.click();

        WebElement chosenDayList = driver.findElement(By.xpath("//*[@data-month='7']/*[text() ='31']"));//"//*[text() ='31']/..[@data-month='7']"));
        chosenDayList.click();

        //3. Sprawdź asercją czy w inpucie pojawiła się data: 08/31/2022
        datePicker.click();
        WebElement chosenDateElement = driver.findElement(By.cssSelector(".ui-datepicker-current-day"));
        int actuallyChosenMonth = Integer.parseInt(chosenDateElement.getAttribute("data-month"))+1;
        String actuallyChosenMonthText = actuallyChosenMonth < 10 ? "0"+ actuallyChosenMonth: String.valueOf(actuallyChosenMonth);
        //TODO: chyba trzeba waita wstawić żeby poczekac na zapalenie na niebiesko na dacie
        WebElement actuallyChosenDay = chosenDateElement.findElement(By.cssSelector(".ui-state-active"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(actuallyChosenDay));



        String actuallyChosenDate = actuallyChosenMonthText + "/" +
                actuallyChosenDay.getText() + "/" + chosenDateElement.getAttribute("data-year");
        System.out.println(actuallyChosenDate);

        Assert.assertEquals(actuallyChosenDate, dateToChoose);
    }


}
