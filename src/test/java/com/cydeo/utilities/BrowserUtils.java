package com.cydeo.utilities;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Set;

public class BrowserUtils {

    /*
In this class only general utility methods that are NOT related to some specific page.
 */

    public void sleep(int second){
        second*=1000;

        try {
            Thread.sleep(second);
        } catch (InterruptedException e) {

        }

    }


    /*
    This method accepts 3 arguments.
    Arg1: webdriver
    Arg2: expectedInUrl : for verify if the url contains given String.
        - If condition matches, will break loop.
    Arg3: expectedInTitle to be compared against actualTitle
     */

    public static void switchWindowAndVerify(WebDriver driver,String expectedInUrl, String expectedInTitle){

        Set<String> allWindowHandles= driver.getWindowHandles();

        for (String each : allWindowHandles) {
            driver.switchTo().window(each);
            System.out.println("Current URL: "+ driver.getCurrentUrl());

            if(driver.getCurrentUrl().contains(expectedInUrl)){
                break;
            }
        }

        //5. Assert: Title contains “expectedInTitle”
        String actualTitle = driver.getTitle();

        Assert.assertTrue(actualTitle.contains(expectedInTitle));

    }

      /*
    This method accepts a String "expectedTitle" and Asserts if it is true
     */

    public static void verifyTitle(WebDriver driver, String expectedTitle){
        Assert.assertEquals(driver.getTitle(),expectedTitle);
    }

}
