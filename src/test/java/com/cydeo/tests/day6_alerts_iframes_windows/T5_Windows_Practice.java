package com.cydeo.tests.day6_alerts_iframes_windows;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T5_Windows_Practice {

    WebDriver driver;
    //@BeforeMethod
    @BeforeClass
    public void setupMethod(){
        //1. Open browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //2. Go to website: https://practice.cydeo.com/windows
        driver.get("https://practice.cydeo.com/windows ");

    }

    @Test
    public void multiple_windows_test(){
        //Storing the main page's window handle as string is
        // good practice for future re-usable purposes
        String mainHandle = driver.getWindowHandle();
        System.out.println("mainHandle = " + mainHandle);

        //4. Assert: Title is “Windows”
        String expectedTitle = "Windows";
        String actualeTitle = driver.getTitle();

        Assert.assertEquals(actualeTitle,expectedTitle);

        System.out.println("Title before click : "+actualeTitle);

        //5. Click to: “Click Here” link
        WebElement clickHereLink= driver.findElement(By.linkText("Click Here"));
        clickHereLink.click();


        System.out.println("Title after click: "+actualeTitle);

        //6. Switch to new Window.
        //Set<String> allWindowHandles = driver.getWindowHandles();
        // window handle 1 - main window
        // window handle 2 - 2nd window

        for(String  each : driver.getWindowHandles()){
          driver.switchTo().window(each);
          System.out.println("Current Title while switching windows: "+driver.getTitle());
      }

        //7. Assert: Title is “New Window”
        String expectedTitleAfterclick = "New Window";
        actualeTitle= driver.getTitle();
        Assert.assertEquals(actualeTitle,expectedTitleAfterclick);

        System.out.println("Title after click: "+actualeTitle);

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


}
