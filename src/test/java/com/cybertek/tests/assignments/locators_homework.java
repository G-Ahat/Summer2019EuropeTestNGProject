package com.cybertek.tests.assignments;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class locators_homework {
    public static void main(String[] args) {

        //TEST CASE 1
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("https://ebay.com");


        driver.findElement(By.xpath("//*[@id=\"gh-ac\"]")).sendKeys("selenium webdriver");
        WebElement searchLink=driver.findElement(By.id("gh-btn"));
        searchLink.click();

        WebElement result=driver.findElement(By.className("srp-controls__count-heading"));

        System.out.println("result = " + result.getText());



        //test case 2
       // go to amazon
        //Go to ebay
       // enter search term
       // click on search button
        //verify title contains search term
        String title=driver.getTitle();
        System.out.println("title = " + title);
        if(title.contains("selenium webdriver")){
            System.out.println("search term displayed in title");
        }else{
            System.out.println("search term is not displayed");
        }

        driver.get("https://amazon.com");

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("selenium webdriver");
        driver.findElement(By.xpath("//*[@value='Go']")).click();
        String titleOfPage=driver.getTitle();

        if(titleOfPage.contains("selenium webdriver")){
            System.out.println("search term displayed in title");
        }else{
            System.out.println("search term is not displayed");
        }

        //TEST CASE3
        //Go to wikipedia.org (Links to an external site.)
        //enter search term `selenium webdriver`
        //click on search button
        //click on search result `Selenium (software)`
        //verify url ends with `Selenium_(software)'

        driver.get("https://www.wikipedia.org/");
        driver.findElement(By.id("searchInput")).sendKeys("selenium webdriver");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.findElement(By.xpath("//a[@title='Selenium (software)']")).click();

        if(driver.getCurrentUrl().endsWith("Selenium_(software)")){
            System.out.println("url ends with Selenium_(software)");
        }else{
            System.out.println("url does not end with Selenium_(software)");
        }

        driver.quit();


    }
}
