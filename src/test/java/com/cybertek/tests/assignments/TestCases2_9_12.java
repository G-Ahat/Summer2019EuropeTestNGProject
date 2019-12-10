package com.cybertek.tests.assignments;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestCases2_9_12 {
    WebDriver driver;

    @BeforeMethod
    public void connection() {
        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void quit() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @DataProvider(name = "myData1")
    public Object[][] myDataProvider() {
        Object[][] obj = new Object[4][2];
        obj[0][0] = "[href='status_codes/200']";
        obj[0][1] = "This page returned a 200 status code.\n" +
                "\n" +
                "For a definition and common list of HTTP status codes, go here";
        obj[1][0] = "[href='status_codes/301']";
        obj[1][1] = "This page returned a 301 status code.\n" +
                "\n" +
                "For a definition and common list of HTTP status codes, go here";
        obj[2][0] = "[href='status_codes/404']";
        obj[2][1] = "This page returned a 404 status code.\n" +
                "\n" +
                "For a definition and common list of HTTP status codes, go here";
        obj[3][0] = "[href='status_codes/500']";
        obj[3][1] = "This page returned a 500 status code.\n" +
                "\n" +
                "For a definition and common list of HTTP status codes, go here";
        return obj;
    }

    @Test(dataProvider = "myData1")
    public void test1(String url, String expectedMessage) throws InterruptedException {
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.cssSelector("[href='/status_codes']")).click();
        driver.findElement(By.cssSelector(url)).click();
        String actualMessage = driver.findElement(By.xpath("//p[contains(text(),'This page returned a')]")).getText();
        Assert.assertEquals(actualMessage, expectedMessage, "Verify that message displayed " + actualMessage);
    }
}

