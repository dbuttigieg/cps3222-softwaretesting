package com.cps3222.AutomatedTests.PageObjects;

import org.openqa.selenium.WebDriver;

public class LoginPage extends Page{

    public LoginPage(WebDriver browser){
        super(browser);
    }

    // Populate form with login key
    public void populateLoginForm(String loginKey){
        find("loginKeyField").sendKeys(loginKey);
    }

    // Click login button
    public void submitLoginForm(){
        find("loginButton").click();
    }

    /*
    // Method to automatically login the agent
    public void login(){
        goTo();
        submit();
    }

    // Method to go back to the home page
    public void back(){
        find("backButton").click();
    }*/
}
