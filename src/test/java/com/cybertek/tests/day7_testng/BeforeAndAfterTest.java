package com.cybertek.tests.day7_testng;

import org.testng.annotations.*;

public class BeforeAndAfterTest {
    @Test
    public void test1(){
        System.out.println("This is test1");

        //beginning of the each test
        //webdriver code
        //driver.get--open browser
        //maximize window or some settings before test

        //after each
        //driver.quit--close browser

    }
    @Test
    public void  test2(){
        System.out.println("This is my Test2");
    }
     @Test
    public void test3(){
        System.out.println("this is my test3");
    }

    @BeforeMethod
    public void setUpMethod(){
        System.out.println("BEFORE METHOD");
        System.out.println("OPENNING THE BROWSER");
    }

    @AfterMethod
    public  void tearDown(){
        System.out.println("AFTER METHOD");
        System.out.println("CLOSE BROWSER");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("BEFORE CLASS CODE");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("AFTER CLASS CODE");
        System.out.println("REPORTING");
    }

}
