package ch1_testNG_intro;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyFirstTest {

    @Test
    public void printHello() {
        System.out.println("This is test - > Hello");
        int i = 1;
        Assert.assertEquals(i, 2);
        System.out.println("To jest koniec testu pierwszego");
    }

    @Test
    public void printHelloWorld() {
        System.out.println("This is test - > Hello World");
        int i = 2;
        Assert.assertEquals(i, 2);
        System.out.println("To jest koniec testu drugiego");
    }

    @BeforeMethod
    public void beforeEachTestMethod() {
        System.out.println(">>I ws executed BEFORE each test");
    }

    @AfterMethod
    public void afterEachTestMethod() {
        System.out.println(">>I ws executed AFTER each test");
    }
}
