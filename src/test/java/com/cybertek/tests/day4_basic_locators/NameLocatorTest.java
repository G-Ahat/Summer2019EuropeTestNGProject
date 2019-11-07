package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NameLocatorTest {
    public static void main(String[] args) throws InterruptedException {
        //open browser

        WebDriver driver= WebDriverFactory.getDriver("chrome");

        //navigate to website
        driver.get("https://practice.cybertekschool.com/sign_up");

        //enter fullname
        WebElement fullnameinput=driver.findElement(By.name("full_name"));
        fullnameinput.sendKeys("Mike Smith");

        //enter email
        WebElement emailinput=driver.findElement(By.name("email"));
        emailinput.sendKeys("mikesmith@cybertekschool.com");
        //click signup button
        WebElement signupbutton=driver.findElement(By.name("wooden_spoon"));
        signupbutton.click();

        //verfy that you got message
        String expectedConfirmationMessage="Thank you for signing up. Click the button below to return to the home page.";
        WebElement messageElement=driver.findElement(By.name("signup_message"));
        String actualConfirmationMessage=messageElement.getText();
        Thread.sleep(3000);
        if(expectedConfirmationMessage.equals(actualConfirmationMessage)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("actualConfirmationMessage = " + actualConfirmationMessage);
            System.out.println("expectedConfirmationMessage = " + expectedConfirmationMessage);
        }



        driver.quit();





    }
}
