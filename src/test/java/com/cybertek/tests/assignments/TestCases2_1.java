package com.cybertek.tests.assignments;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCases2_1 {
    WebDriver driver;
    @BeforeMethod
    public void setUpMethod(){
        driver=WebDriverFactory.getDriver("chrome");
    }
    @AfterMethod
    public void closeDriverMethod() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
    @Test
    public void test1(){
        driver.get("https://practice-cybertekschool.herokuapp.com");
        WebElement registrationForm=driver.findElement(By.xpath("//*[text()='Registration Form']"));
        registrationForm.click();
        WebElement dateOfBirth=driver.findElement(By.name("birthday"));
        dateOfBirth.sendKeys("wrong_dob");
        String expectedMessage="The date of birth is not valid";
        WebElement actualMessage=driver.findElement(By.xpath("//*[text()=\"The date of birth is not valid\"]"));
        Assert.assertEquals(actualMessage.getText(),expectedMessage,"verifying the warning message");
    }
    @Test
    public void test2(){
        driver.get("https://practice-cybertekschool.herokuapp.com");
        WebElement registrationForm=driver.findElement(By.xpath("//*[text()='Registration Form']"));
        registrationForm.click();
        String C=driver.findElement(By.xpath("//*[text()='C++']")).getText();
        String JS=driver.findElement(By.xpath("//*[text()='JavaScript']")).getText();
        String J=driver.findElement(By.xpath("//*[text()='Java']")).getText();
        Assert.assertEquals(JS,"JavaScript","verifying JS=JavaScript");
        Assert.assertEquals(C,"C++","verifying C=C++");
        Assert.assertEquals(J,"Java","verifying J=Java");
    }
    @Test
    public void test3(){
        driver.get("https://practice-cybertekschool.herokuapp.com");
        WebElement registrationForm=driver.findElement(By.xpath("//*[text()='Registration Form']"));
        registrationForm.click();
        WebElement FirstName=driver.findElement(By.name("firstname"));
        FirstName.sendKeys("a");
        String actualMessage=driver.findElement(By.xpath("//*[text()='first name must be more than 2 and less than 64 characters long']")).getText();
        String expectedMessage="first name must be more than 2 and less than 64 characters long";
        Assert.assertEquals(expectedMessage,actualMessage,"verifying name message");

    }
    @Test
    public void test4(){
        driver.get("https://practice-cybertekschool.herokuapp.com");
        WebElement registrationForm=driver.findElement(By.xpath("//*[text()='Registration Form']"));
        registrationForm.click();
        WebElement lastName=driver.findElement(By.name("lastname"));
        lastName.sendKeys("a");
        String actualMessage=driver.findElement(By.xpath("//*[text()='The last name must be more than 2 and less than 64 characters long']")).getText();
        String expectedMessage="The last name must be more than 2 and less than 64 characters long";
        Assert.assertEquals(actualMessage,expectedMessage,"verifying lastname message");

    }
    @Test
    public void test5(){
        driver.get("https://practice-cybertekschool.herokuapp.com");
        WebElement registrationForm=driver.findElement(By.xpath("//*[text()='Registration Form']"));
        registrationForm.click();
        WebElement FirstName=driver.findElement(By.name("firstname"));
        FirstName.sendKeys("Ayse");
        WebElement lastName=driver.findElement(By.name("lastname"));
        lastName.sendKeys("Sag");
        WebElement userName=driver.findElement(By.name("username"));
        userName.sendKeys("userName");
        WebElement email=driver.findElement(By.name("email"));
        email.sendKeys("abc@gmail.com");
        WebElement password=driver.findElement(By.name("password"));
        password.sendKeys("passWord1");
        WebElement phoneNumber=driver.findElement(By.name("phone"));
        phoneNumber.sendKeys("571-123-1234");
        WebElement gender=driver.findElement(By.xpath("//*[@value='female']"));
        gender.click();
        WebElement dateOfBirth=driver.findElement(By.name("birthday"));
        dateOfBirth.sendKeys("03/23/1988");
        WebElement Department= driver.findElement(By.name("department"));
        Select department=new Select(Department);
        department.selectByIndex(2);
        WebElement jobTitle=driver.findElement(By.name("job_title"));
        Select jTitle=new Select(jobTitle);
        jTitle.selectByIndex(1);
        driver.findElement(By.xpath("//*[text()='Java']")).click();
        driver.findElement(By.id("wooden_spoon")).click();
        String actualMessage = driver.findElement(By.xpath("//*[text()=\"You've successfully completed registration!\"]")).getText();
        String expectedMessage = "You've successfully completed registration!";
        Assert.assertEquals(actualMessage,expectedMessage,"verifying messages");








    }


}
