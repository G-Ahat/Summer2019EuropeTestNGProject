package com.cybertek.tests.assignments;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCases2_7 {
    //Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
    // Step 2. And click on “File Upload".
    // Step 3. Upload any file with .txt extension from your computer.
    // Step 4. Click “Upload” button.
    // Step 5. Verify that subject is: “File Uploaded!”
    // Step 6. Verify that uploaded file name is displayed.
    // Note: use element.sendKeys(“/file/path”) with specifying path to the file for uploading.
    // Run this method against “Choose File” button.

@Test
    public void test1(){
    WebDriver driver= WebDriverFactory.getDriver("chrome");
    driver.get("https://practice-cybertekschool.herokuapp.com");
    driver.findElement(By.linkText("File Upload")).click();
    driver.findElement(By.id("file-upload")).sendKeys("C:\\Users\\User\\Desktop\\New Text Document.txt");
    driver.findElement(By.id("file-submit")).click();

    String actual=driver.findElement(By.xpath("//h3[text()='File Uploaded!']")).getText();
    String expected="File Uploaded!";
    Assert.assertEquals(actual,expected,"verifying messages are same");

    WebElement file=driver.findElement(By.id("uploaded-files"));
    Assert.assertTrue(file.isDisplayed());

}

@Test
    public void test8(){
    //Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
    // Step 2. And click on “Autocomplete”.
    // Step 3. Enter “United States of America” into country input box.
    // Step 4. Verify that following message is displayed: “You selected: United States of America”

    WebDriver driver= WebDriverFactory.getDriver("chrome");
    driver.get("https://practice-cybertekschool.herokuapp.com");
    driver.findElement(By.linkText("Autocomplete")).click();
    driver.findElement(By.id("myCountry")).sendKeys("United States of America");
    driver.findElement(By.xpath("//input[@type='button']")).click();
    WebElement message=driver.findElement(By.id("result"));
    Assert.assertTrue(message.isDisplayed());





}






}


