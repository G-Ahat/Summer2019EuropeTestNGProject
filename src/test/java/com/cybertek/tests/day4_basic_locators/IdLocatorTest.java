package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IdLocatorTest {

    public static void  main(String [] args){
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://practice.cybertekschool.com/multiple_buttons");
        WebElement dontClickButton=driver.findElement(By.id("disappering button"));
        dontClickButton.click();
        driver.quit();


    }

}
