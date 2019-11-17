package com.cybertek.tests.day7_testng;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RadioButtonTest {
    @Test
    public void radioButton(){
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/radio_buttons");

        WebElement blueRadioButton=driver.findElement(By.id("blue"));
        WebElement redRdioButton=driver.findElement(By.id("red"));

        //how to check radio button selected or not

        System.out.println("is blue selected: " + blueRadioButton.isSelected());
        System.out.println("is red selected: "+ redRdioButton.isSelected());

        //verify that blue is selected
        Assert.assertTrue(blueRadioButton.isSelected(),"verify that blue button is selected");
        //verify that red is not selected
        Assert.assertFalse(redRdioButton.isSelected(),"verfy that red radio button is not selected");

        //how to select radio button
        System.out.println("clicking red radio button");
        redRdioButton.click();

        System.out.println("is blue selected: " + blueRadioButton.isSelected());
        System.out.println("is red selected: " + redRdioButton.isSelected());

        //verfy blue not selected
        Assert.assertFalse(blueRadioButton.isSelected(),"verify that blue not selected");
        //verfy red selected
        Assert.assertTrue(redRdioButton.isSelected(),"verify that red selected");






        driver.quit();

    }
}
