package com.cybertek.tests;

import com.cybertek.utilities.Driver;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {
    protected WebDriver driver;
    protected Actions action;
    protected WebDriverWait wait;
    @BeforeMethod
    public void setUpMethod(){
        driver= Driver.get();
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        action=new Actions(driver);
        wait = new WebDriverWait(driver, 10);

    }
    @AfterMethod
    public void quitMethod() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}
