package com.cps3222.AutomatedTests.stepdefs;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by denise on 15/01/2018.
 */
public class MessagingAppStepDefs {
    WebDriver browser;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "./chromedriver");
        browser = new ChromeDriver();
    }

    @Given("^I am an agent trying to log in$")
    public void i_am_an_agent_trying_to_log_in() throws Throwable {
        browser.get("localhost:8080");
    }

    @When("^I obtain a key from the supervisor using a valid id$")
    public void get_key_from_supervisor_using_valid_id(String agentId, String agentName) throws Exception {

    }

    @After
    public void tearDown(){
        browser.quit();
    }
}
