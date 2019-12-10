package com.cybertek.tests.assignments;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestCases3 {

    //1.Go to “https://qa1.vytrack.com/"
    // 2.Login as a store manager
    // 3.Navigate to “Activities -> Calendar Events”
    // 4.Verify that page subtitle "Options" is displayedTest case #2

    WebDriver driver;
    @BeforeMethod
    public void setUpMethod(){
        driver=WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://qa1.vytrack.com/");
        driver.manage().window().maximize();
        driver.findElement(By.name("_username")).sendKeys("storemanager85");
        driver.findElement(By.name("_password")).sendKeys("UserUser123");
        driver.findElement(By.xpath("//button")).click();
        WebElement calendarActivities=driver.findElement(By.xpath("(//*[.='Calendar Events'])[3]"));
        JavascriptExecutor jse= (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].click();",calendarActivities);



    }
    @AfterMethod
    public void quitMethod() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }

    @Test
    public void test1(){


        Boolean options= driver.findElement(By.xpath("(//*[contains(text(),'Options')])[2]")).isDisplayed();
        Assert.assertTrue(options);
    }

    @Test
    public void test2(){
        //Go to “https://qa1.vytrack.com/"
        // 2.Login as a store manager
        // 3.Navigate to “Activities -> Calendar Events”
        // 4.Verify that page number is equals to "1"


        String actualValue= driver.findElement(By.cssSelector("input[type='number']")).getAttribute("value");
        String expectedValue="1";
        Assert.assertEquals(actualValue,expectedValue);
    }

    @Test
    public void test3(){
        String page=driver.findElement(By.xpath("//button[@class='btn dropdown-toggle ']")).getText();
        String expected="25";
        Assert.assertEquals(page,expected,"verifying");

    }
    @Test
    public void test4(){
        //Verify that number of calendar events (rows in the table) is equals to number of records

       int numberOfRaws=driver.findElements(By.xpath("//tr[@class='grid-row row-click-action']")).size();
        System.out.println("numberOfRaws = " + numberOfRaws);
      String numberOfRecords=driver.findElement(By.xpath("//label[text()='Total of 24 records']")).getText();
        String[] num=numberOfRecords.split(" ");
        int records=Integer.valueOf(num[2]);




       Assert.assertEquals(numberOfRaws,records,"verifying");




    }

    @Test
    public void test5(){
        //Click on the top checkbox to select all
        // 5.Verify that all calendar events were selected
        int numberOfRaws=driver.findElements(By.xpath("//tr[@class='grid-row row-click-action']")).size();

       // for(int i=1;i<=numberOfRaws;i++){
        WebElement clickButton= driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/div[3]/div[2]/div[2]/div[2]/div/table/thead/tr/th[1]/div/button/input"));
        clickButton.click();

        for(int i=1;i<=numberOfRaws;i++){
            WebElement checkbox=driver.findElement(By.xpath("(//tbody/tr/td/input)["+i+"]"));
            Assert.assertTrue(checkbox.isDisplayed(),"verifying");
        }



    }

    @Test
    public void test6() throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        for (int i = 0; i < 10; i++) {
            Thread.sleep(500);
            //scrolling down
            jse.executeScript("window.scrollBy(0,250)");
        }


        driver.findElement(By.xpath("(//tbody/tr)[14]")).click();
        WebElement info=driver.findElement(By.xpath("//*[@class='row-fluid form-horizontal']"));
        Assert.assertTrue(info.isDisplayed());
    }

}
