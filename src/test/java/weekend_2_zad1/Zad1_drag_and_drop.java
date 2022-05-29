package weekend_2_zad1;

import ch3_testbase.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Zad1_drag_and_drop extends TestBase {

    WebElement drag;
    WebElement drop;

    Actions actions;

    @BeforeMethod
    public void testSetup(){

        driver.get("https://seleniumui.moderntester.pl/droppable.php");
        drag = driver.findElement(By.cssSelector("#draggable"));
        drop = driver.findElement(By.cssSelector("#droppable"));
        actions = new Actions(driver);

    }

    @Test
    public void shouldDragAndDrop(){

        actions.clickAndHold(drag)
                .moveToElement(drop)
                .release()
                .perform();

        Assert.assertEquals(drop.getText(), "Dropped!");
    }

    @Test
    public void shouldDragAndDrop2(){

        actions.dragAndDrop(drag, drop)
                .perform();

        Assert.assertEquals(drop.getText(), "Dropped!");
    }

    @Test
    public void shouldDragAndDrop3(){

        actions.clickAndHold(drag)
                .release(drop)
                .perform();

        Assert.assertEquals(drop.getText(), "Dropped!");
    }

    @Test
    public void shouldDragAndDrop4(){

        int x = drop.getLocation().getX() - drag.getLocation().getX();
        int y = drop.getLocation().getY() - drag.getLocation().getY();

        actions.clickAndHold(drag)
                .moveByOffset(x,y)
                .release()
                .perform();

        Assert.assertEquals(drop.getText(), "Dropped!");
    }
}
