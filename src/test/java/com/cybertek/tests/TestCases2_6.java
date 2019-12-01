package com.cybertek.tests;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCases2_6 {
    @Test
            public void test6() throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.tempmailaddress.com/");
        WebElement eMail=driver.findElement(By.id("email"));
        String mail=eMail.getText();
        driver.get("https://practice-cybertekschool.herokuapp.com");
        WebElement signUp=driver.findElement(By.linkText("Sign Up For Mailing List"));
        signUp.click();
        driver.findElement(By.name("full_name")).sendKeys("Ayse");
        driver.findElement(By.name("email")).sendKeys(mail);
        driver.findElement(By.name("wooden_spoon")).click();
        String actualMessage=driver.findElement(By.name("signup_message")).getText();
        String expectedMessage="Thank you for signing up. Click the button below to return to the home page.";
        Assert.assertEquals(expectedMessage,actualMessage,"verifying messages");
        driver.navigate().to("https://www.tempmailaddress.com/");

        Thread.sleep(3000);

        boolean isEmailDisplayed=driver.findElement(By.xpath("//*[@id='schranka']/tr[1]")).isDisplayed();
        Assert.assertTrue(isEmailDisplayed);
        WebElement doNotReply=driver.findElement(By.xpath("//*[@id='schranka']/tr[1]"));
        doNotReply.click();
        String actualEmail=driver.findElement(By.xpath("//span[.='do-not-reply@practice.cybertekschool.com']")).getText();
        String expectedEmail="do-not-reply@practice.cybertekschool.com";
        Assert.assertEquals(actualEmail,expectedEmail);
        String actualSubject=driver.findElement(By.cssSelector("[id='predmet']")).getText();
        String expectedSubject="Thanks for subscribing to practice.cybertekschool.com!";
        Assert.assertEquals(actualSubject,expectedSubject);


    }


}
