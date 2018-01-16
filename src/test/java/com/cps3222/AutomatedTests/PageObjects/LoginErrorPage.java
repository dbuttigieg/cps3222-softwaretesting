package com.cps3222.AutomatedTests.PageObjects;

import org.openqa.selenium.WebDriver;

public class LoginErrorPage extends Page{

    public LoginErrorPage(WebDriver browser){
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

    public String obtainErrorMessage(){
        return find("errorMessage").getText();
    }
}
