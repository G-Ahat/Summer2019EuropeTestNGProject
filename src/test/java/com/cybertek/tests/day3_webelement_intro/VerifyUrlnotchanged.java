package com.cybertek.tests.day3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifyUrlnotchanged {
/**
 * Verify URL not changed
 * open chrome
 * go to http://practice.cybertekschool.com/forgot_password Links to an external site.
 * click on Retrieve password
 * verify that url did not change
 */
public static void main(String[] args) {
  //open browser
    WebDriver driver= WebDriverFactory.getDriver("chrome");

    //go to http://practice.cybertekschool.com/forgot_password Links to an external site.
    driver.get("http://practice.cybertekschool.com/forgot_password");

    //save Url to string variable
    String expectedUrl=driver.getCurrentUrl();
//click on retrieve password
    WebElement retrievePasswordButton=driver.findElement(By.id("form_submit"));
    retrievePasswordButton.click();

    String actualUrl=driver.getCurrentUrl();

    if(expectedUrl.equals(actualUrl)){
        System.out.println("PASS");
    }else {
        System.out.println("FAIL");
    }
//close the browser
    driver.quit();


}

 }
