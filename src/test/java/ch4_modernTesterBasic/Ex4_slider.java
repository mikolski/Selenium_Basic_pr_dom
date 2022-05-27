package ch4_modernTesterBasic;

import ch3_testbase.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Ex4_slider extends TestBase {



//    @Test
//    public void shouldSlide(){
//        driver.get("https://seleniumui.moderntester.pl/slider.php");
//
//        WebElement slider = driver.findElement(By.cssSelector("#custom-handle"));
//
//        for(int i = 0; i<50;i++){
//            slider.sendKeys(Keys.ARROW_RIGHT);
//        }
//
//        for(int i = 0; i<20;i++){
//            slider.sendKeys(Keys.ARROW_LEFT);
//        }
//
//    }

    @Test
    public void shouldSlide2(){
        driver.get("https://seleniumui.moderntester.pl/slider.php");

        slide(50);
        slide(30);
        slide(30);
        slide(50);

    }

    private void slide(int requiredSliderValue){
        WebElement slider = driver.findElement(By.cssSelector("#custom-handle"));
        int currentSliderValue = Integer.parseInt(slider.getText());
        int amountOfMoves = Math.abs(requiredSliderValue - currentSliderValue);
        Keys direction;

        if (currentSliderValue < requiredSliderValue){
            direction = Keys.ARROW_RIGHT;
        }else{
            direction = Keys.ARROW_LEFT;
        }

        for(int i = 0; i<amountOfMoves;i++){
            slider.sendKeys(direction);
        }
    }
}
