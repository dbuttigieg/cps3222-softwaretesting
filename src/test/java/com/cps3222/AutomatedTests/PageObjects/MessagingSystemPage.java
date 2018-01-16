package com.cps3222.AutomatedTests.PageObjects;

import org.openqa.selenium.WebDriver;

public class MessagingSystemPage extends Page{

    public MessagingSystemPage(WebDriver browser){
        super(browser);
    }

    public void sendMessage(String id, String msg){
        find("idField").sendKeys(id);
        find("msgField").sendKeys(msg);
        find("sendButton").click();
    }

    public void checkMessagesButton(){
        find("checkMessagesButton").click();
    }

    public void logout(){
        find("logoutButton").click();
    }
}
