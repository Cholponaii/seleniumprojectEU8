package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LibraryLoginPage {
    //#1- initialize the driver instance and object of the class

    public LibraryLoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    //#2- use @FindBy annotation to locate web elements

    @FindBy(xpath ="//input[@id='inputEmail']" )
    public WebElement inputUsername;

    @FindBy(id ="inputPassword")
    public WebElement inputPassword;

    @FindBy(xpath = "//button[text()='Sign in']")
    public WebElement signInButton;

    @FindBy(xpath = "//div[@id='inputEmail-error']")
    public WebElement fieldRequiredErrorMessage;

    @FindBy(xpath = "//div[.= 'Please enter a valid email address.']")
    public WebElement enterValidEmailErrorMessage;

    @FindBy(xpath = "//div[text()='Sorry, Wrong Email or Password']")
    public WebElement wrongEmailOrPasswordErrorMessage;
}
