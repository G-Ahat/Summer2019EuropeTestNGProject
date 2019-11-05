package com.cybertek.tests.day3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifyConfirmationMessage {
    /*open browser
go to http://practice.cybertekschool.com/forgot_password Links to an external site.
enter any email
verify that email is displayed in the input box
click on Retrieve password
verify that confirmation message says 'Your e-mail's been sent!'*/
    public static void main(String [] args) throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");
        WebElement emailInput=driver.findElement(By.name("email"));
        String expectedEmail="test@gmail.com";
        emailInput.sendKeys(expectedEmail);
        //verify that email is displayed in the input box
        //getting text from webelements
        //getText()-->get text from webelemnt(if getText() doesnt work we use getAttribute()
        //getAttribute()-->gets value of attributes
        String actualEmail=emailInput.getAttribute("value");
        
        if(expectedEmail.equals(actualEmail)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("expectedEmail= " + expectedEmail);
            System.out.println("actualEmail = " + actualEmail);
        }

        //click on retrieve password
        WebElement retrievePasswordButton=driver.findElement(By.id("form_submit"));
       retrievePasswordButton.click();
         String expectedConfirmationMessage="Your e-mail's been sent!";
         WebElement messageElement=driver.findElement(By.name("confirmation_message"));
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
