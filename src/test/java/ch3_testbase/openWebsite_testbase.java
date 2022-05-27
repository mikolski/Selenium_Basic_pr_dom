package ch3_testbase;

import org.testng.annotations.Test;

public class openWebsite_testbase extends TestBase {
    @Test
    public void shouldOpenWebsite(){

        driver.get("https://seleniumui.moderntester.pl/");


    }
}
