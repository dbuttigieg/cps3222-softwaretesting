package com.cps3222.AutomatedTests.PageObjects;

import org.openqa.selenium.WebDriver;

public class RequestLoginPage extends Page{

    public RequestLoginPage(WebDriver browser){
        super(browser);
    }

    // Populate form to request key
    public void populateKeyForm(String id, String name){
        find("idField").sendKeys(id);
        find("nameField").sendKeys(name);
    }

    // Submit form for key request
    public void submitKeyForm(){
        find("requestLoginButton").click();
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
