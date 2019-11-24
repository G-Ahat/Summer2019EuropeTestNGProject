package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PopupsAndAlerts {
    WebDriver driver;
    @BeforeMethod
    public void setUpMethod(){
       driver= WebDriverFactory.getDriver("chrome");

    }
    @AfterMethod
    public void tearDownMethod() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void test1(){
        driver.get("https://www.primefaces.org/showcase/ui/overlay/confirmDialog.xhtml");
        //locating and clicking destroy button
        driver.findElement(By.xpath("//*[text()='Destroy the World']")).click();
        //locating no button and click it
        driver.findElement(By.xpath("//*[text()='No']")).click();


    }
    @Test
    public void test2() throws InterruptedException {
        driver.get("https://practice.cybertekschool.com/javascript_alerts");
        //click for js alert
        driver.findElement(By.xpath("//button[1]")).click();
        Alert alert=driver.switchTo().alert();
        Thread.sleep(2000);
        //accept alert-->clicking ok
        alert.accept();


    }
}
