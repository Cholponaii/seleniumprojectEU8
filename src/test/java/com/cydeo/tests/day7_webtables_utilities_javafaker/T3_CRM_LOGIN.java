package com.cydeo.tests.day7_webtables_utilities_javafaker;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class T3_CRM_LOGIN {

    WebDriver driver;

    @Test
    public void crm_login_test(){

        //1. Create new test and make set ups
        //2. Go to : http://login1.nextbasecrm.com/
        driver.get("http://login1.nextbasecrm.com/");

        //3. Enter valid username
        //4. Enter valid password
        //5. Click to `Log In` button
        //6. Verify title is as expected:
        //Expected: Portal

    }
}
