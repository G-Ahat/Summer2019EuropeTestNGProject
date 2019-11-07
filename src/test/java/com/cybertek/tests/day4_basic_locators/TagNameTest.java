package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TagNameTest {
    public static void main(String [] args){
        //open browser
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //
        driver.get("https://practice.cybertekschool.com/sign_up");

        //enter fullname
        WebElement fullNameInput=driver.findElement(By.tagName("input"));
        fullNameInput.sendKeys("Mike Smith With TagName");

        //enter email
            WebElement emailInput=driver.findElement(By.name("email"));
            emailInput.sendKeys("mike@gmail.com");

            WebElement signUpButton=driver.findElement(By.tagName("button"));
            signUpButton.click();

            //print the confirmation message using tagname locator

        WebElement messageElement=driver.findElement(By.tagName("h3"));
        String message=messageElement.getText();

        System.out.println("message = " + message);

       // System.out.println(driver.findElement(By.tagName("h3")).getText());  shortcut

        driver.quit();


    }
}
