package ch1_testNG_intro;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MySecondTest {
    public int multiply(int a, int b){
        return 4;
    }

    public int add(int a, int b){
        return a + b;
    }

    @Test
    public void multiplyTest(){
        int result = multiply(2, 3);
        Assert.assertEquals(result, 6);
    }

    @Test
    public void addTest(){
        int result = add(2, 3);
        Assert.assertEquals(result, 5);
    }


    @BeforeMethod
    public void beforeEachTestMethod() {
        System.out.println("run before each test");
    }

    @AfterMethod
    public void afterEachTestMethod() {
        System.out.println("run after each test");
    }

}
