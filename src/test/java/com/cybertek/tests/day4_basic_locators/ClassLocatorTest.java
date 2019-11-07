package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ClassLocatorTest {
    public static void main(String[] args) {
        //open browser
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://practice.cybertekschool.com/sign_up");

        //click home link
        WebElement homeLink=driver.findElement(By.className("nav-link"));
        homeLink.click();

        driver.get("https://practice.cybertekschool.com/multiple_buttons");
        WebElement multipleButtons=driver.findElement(By.className("h3"));
        System.out.println( driver.findElement(By.className("h3")).getText());

        //if there is a space in the class attribute value we can not use it

        driver.quit();


    }
}
