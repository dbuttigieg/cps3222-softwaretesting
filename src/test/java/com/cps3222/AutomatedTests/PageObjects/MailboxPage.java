package com.cps3222.AutomatedTests.PageObjects;

import org.openqa.selenium.WebDriver;

public class MailboxPage extends Page{

    public MailboxPage(WebDriver browser){
        super(browser);
    }

    public void consumeMessageButton(){
        find("consumeMessageButton").click();
    }

    public String readConsumedMessage(){
        return find("messageText").getText();
    }
}
