package com.cybertek.tests.day8_types_of_elements2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class NoSelectDropdown {
    @Test
    public void test1(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        WebElement dropdownElement = driver.findElement(By.id("dropdownMenuLink"));
        //open the dropdown
        dropdownElement.click();
        List<WebElement> listofLinks = driver.findElements(By.className("dropdown-item"));
        System.out.println("Number of links "+listofLinks.size());

        //print text of each link

        System.out.println(listofLinks.get(0).getText()); //prints first element of list
        for(WebElement links:listofLinks){
            System.out.println(links.getText());
        }

        listofLinks.get(0).click();//index of the list and click


        //
         //driver.findElement(By.linkText("Yahoo")).click();//locate the element and click it
    }
}
