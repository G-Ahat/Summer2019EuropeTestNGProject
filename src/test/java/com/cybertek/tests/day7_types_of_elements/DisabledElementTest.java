package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DisabledElementTest {

    @Test
    public void test1(){
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/radio_buttons");

        WebElement greenRadioButton=driver.findElement(By.id("green"));

        //how to check button enabled or not
        System.out.println("is element enabled: "+ greenRadioButton.isEnabled());
        //verfy that green button is disabled
        Assert.assertFalse(greenRadioButton.isEnabled(),"verify that green button is disabled");

        greenRadioButton.click();
    }
    @Test
    public void test2(){
        WebDriver driver=WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/dynamic_controls");
        WebElement inputBox=driver.findElement(By.cssSelector("#input-example>input"));
        System.out.println("is inpu enabled: "+ inputBox.isEnabled());

        inputBox.sendKeys("Mike Smith");




    }



}
