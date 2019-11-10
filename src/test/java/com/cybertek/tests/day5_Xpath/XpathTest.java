package com.cybertek.tests.day5_Xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class XpathTest {
    public static void main(String[] args) {

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //driver.get("https://practice.cybertekschool.com/multiple_buttons");

       // WebElement homeLink=driver.findElement(By.xpath("/html/body/nav/ul/li/a"));
        //WebElement example=driver.findElement(By.xpath("/html/body/div/div/div/div/p"));
        driver.get("https://practice.cybertekschool.com/sign_up");

        WebElement signUp=driver.findElement(By.xpath("//button[.='Sign Up']"));

    }
}
