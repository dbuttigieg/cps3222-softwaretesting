package com.cps3222.AutomatedTests.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Page {

    WebDriver browser;

    public Page(WebDriver browser){
        this.browser = browser;
    }

    //get page title
    public String getPageTitle(){
        return browser.getTitle();
    }

    // find page element
    public WebElement find(String name){
        return browser.findElement(By.name(name));
    }
}

