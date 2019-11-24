package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class iframes {
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
        driver.get("http://practice.cybertekschool.com/iframe");

        //HOW TO SWITCH FRAMES
        //1.switch by using name or id attribute of iframe
        driver.switchTo().frame("mce_0_ifr");
        //clear the text inside box
        driver.findElement(By.id("tinymce")).clear();
        //locate and send some text
        driver.findElement(By.id("tinymce")).sendKeys("HELLOOOOOO");

        //go back to first frame ,useful when we have switched multiple frames
        driver.switchTo().defaultContent();

        //2.using index
        driver.switchTo().frame(0);
        driver.findElement(By.id("tinymce")).clear();
        //locate and send some text
        driver.findElement(By.id("tinymce")).sendKeys("We Used index Here");
        //go back to first frame, only to parent
        driver.switchTo().parentFrame();


        //3.using webelement
        //locating iframe with any valid locator
        WebElement frameElement=driver.findElement(By.tagName("iframe"));

        //passing frame as a webelement
        driver.switchTo().frame(frameElement);

        driver.findElement(By.id("tinymce")).clear();
        //locate and send some text
        driver.findElement(By.id("tinymce")).sendKeys("we located with element");



    }

    @Test
    public void multipleFrames(){
        driver.get("https://practice.cybertekschool.com/nested_frames");
        //switching to frame top
        driver.switchTo().frame("frame-top");
        //frame top has three children frame,left middle and right
        //switching the middle frame
        driver.switchTo().frame("frame-middle");
        //get the middle text and print it
        System.out.println(driver.findElement(By.id("content")).getText());

        //go back to parent top frame to switch right
        driver.switchTo().parentFrame();

        //switching right using text
        driver.switchTo().frame(2);

        //print right from right frame

        System.out.println(driver.findElement(By.tagName("body")).getText());

        //go up to top level HTML
        driver.switchTo().defaultContent();

        //switch to frame bottom
        driver.switchTo().frame(1);
        System.out.println(driver.findElement(By.tagName("body")).getText());

        driver.switchTo().defaultContent();
        driver.switchTo().frame(0);
        driver.switchTo().frame("frame-left");
        System.out.println(driver.findElement(By.tagName("body")).getText());



    }

}
