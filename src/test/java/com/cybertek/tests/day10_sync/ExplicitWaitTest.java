package com.cybertek.tests.day10_sync;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExplicitWaitTest {
    WebDriver driver;
    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");
    }
    @AfterMethod
    public void tearDownMethod() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
    @Test
    public void test1(){
        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");

        driver.findElement(By.tagName("button")).click();
        //find the username inputbox
        WebElement username=driver.findElement(By.id("username"));

        //how to wait explicitly
        //create explicit wait object
        WebDriverWait wait=new WebDriverWait(driver,10);
        //waiting for the specific element to be visible (up to ten seconds)
        wait.until(ExpectedConditions.visibilityOf(username));

        //sending some username
        username.sendKeys("MikeSmith");
    }
    @Test
    public void test2(){
        driver.get("http://practice.cybertekschool.com/dynamic_controls");
        //click enable
        driver.findElement(By.xpath("//button[contains(text(),'Enable')]")).click();
        //finding input box
        WebElement inputBox = driver.findElement(By.cssSelector("input[type='text']"));
        //Wait until inputbox is enabled or clickable
        //create to object to wait
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.elementToBeClickable(inputBox));
        //type something in the inputbox
        inputBox.sendKeys("Something something");
    }

}

