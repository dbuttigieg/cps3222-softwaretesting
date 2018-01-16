package com.cps3222.AutomatedTests.PageObjects;

import org.openqa.selenium.WebDriver;

public class MessageResponsePage extends Page{

    public MessageResponsePage(WebDriver browser){
        super(browser);
    }

    public void backToSystem(){
        find("backToMailboxButton").click();
    }

    public String getSuccessMessage(){
        return find("returnMessage").getText();
    }
}
