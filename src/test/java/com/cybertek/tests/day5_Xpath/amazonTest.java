package com.cybertek.tests.day5_Xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class amazonTest {
    public static void main(String[] args) {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://amazon.com");

       // WebElement search=driver.findElement(By.xpath("//input[@type='submit']"));
        //search.sendKeys("Selenium");
        //search.click();


        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("Selenium");
        driver.findElement(By.xpath("//*[@value='Go']")).click();
    }
}
