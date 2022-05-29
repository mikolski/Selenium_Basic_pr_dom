package ch6_tables;

import ch3_testbase.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class zad1_table extends TestBase {
    @Test
    public void shouldPrintSelectedPeaks(){
        int minHeight = 4000;

        driver.get("https://seleniumui.moderntester.pl/table.php");

        List<WebElement> peaks = driver.findElements(By.cssSelector("tbody tr"));
        Assert.assertTrue(peaks.size()>0);

        for (WebElement peak: peaks) {
            if(Integer.parseInt(peak.findElements(By.cssSelector("td")).get(3).getText()) > minHeight) {
                System.out.println(peak.findElement(By.cssSelector("th")).getText()
                    + ". "
                    + peak.findElements(By.cssSelector("td")).get(0).getText()
                    + " | "
                    + peak.findElements(By.cssSelector("td")).get(2).getText()
                    + " | "
                    + peak.findElements(By.cssSelector("td")).get(3).getText());
            }
        }

    }
}
