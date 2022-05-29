package ch7_waits;

import ch3_testbase.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Ex4_AddToBasket extends TestBase {

    @Test
    public void shouldWait() {
        driver.get("http://146.59.32.4/index.php?id_product=6&rewrite=mug-the-best-is-yet-to-come&controller=product&id_l");

        WebElement addToCart = driver.findElement(By.cssSelector(".btn-primary.add-to-cart"));
        addToCart.click();

        //WebElement proceedButton = driver.findElement(By.cssSelector("#blockcart-modal .btn-primary"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("#blockcart-modal .btn-primary"))).click();

        WebElement binButton = driver.findElement(By.cssSelector(".remove-from-cart"));

        binButton.click();

        wait.until(ExpectedConditions.invisibilityOf(binButton));

        WebElement noItemsLabel = driver.findElement(By.cssSelector(".no-items"));

        Assert.assertEquals(noItemsLabel.getText(), "There are no more items in your cart");

    }
}
