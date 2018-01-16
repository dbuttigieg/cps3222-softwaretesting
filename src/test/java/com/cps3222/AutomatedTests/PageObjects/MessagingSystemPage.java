package com.cps3222.AutomatedTests.PageObjects;

import org.openqa.selenium.WebDriver;

public class MessagingSystemPage extends Page{

    public MessagingSystemPage(WebDriver browser){
        super(browser);
    }

    public void sendMessage(String msg){
        find("msgField").sendKeys(msg);
    }

    public void logout(){
        find("logoutButton").click();
    }
}
