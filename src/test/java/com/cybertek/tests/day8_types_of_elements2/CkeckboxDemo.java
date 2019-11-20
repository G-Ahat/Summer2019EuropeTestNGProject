package com.cybertek.tests.day8_types_of_elements2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CkeckboxDemo {

    @Test
    public void test1() {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://practice.cybertekschool.com/checkboxes");

        WebElement checkbox1 = driver.findElement(By.xpath("//input[1]"));
        WebElement checkbox2 = driver.findElement(By.xpath("//input[2]"));

        //verify that checkbox 1 is unselected and 2 is selected
        Assert.assertTrue(checkbox2.isSelected(), "verify that checkbox 1 is selected");
        Assert.assertFalse(checkbox1.isSelected(),"verify that checkbox 1 is selected");

        //select the first checkbos
        checkbox1.click();
        Assert.assertTrue(checkbox2.isSelected(), "verify that checkbox 1 is selected");
        Assert.assertTrue(checkbox1.isSelected(),"verify that checkbox 1 is selected");





        driver.quit();

    }
}
