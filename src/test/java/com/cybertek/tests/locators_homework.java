package com.cybertek.tests;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class locators_homework {
    public static void main(String[] args) {

        //TEST CASE 1
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("https://ebay.com");


        driver.findElement(By.xpath("//*[@id=\"gh-ac\"]")).sendKeys("selenium webdriver");
        WebElement searchLink=driver.findElement(By.id("gh-btn"));
        searchLink.click();

        WebElement result=driver.findElement(By.className("srp-controls__count-heading"));

        System.out.println("result = " + result.getText());

        driver.quit();

        //test case 2





    }
}
