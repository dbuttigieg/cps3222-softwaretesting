package com.cps3222.AutomatedTests.stepdefs;

import com.cps3222.AutomatedTests.PageObjects.*;
import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

/**
 * Created by denise on 15/01/2018.
 */
public class MessagingAppStepDefs {
    WebDriver browser;
    RequestLoginPage requestLoginPage;
    LoginPage loginPage;
    MessagingSystemPage messagingSystemPage;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "./chromedriver");
        browser = new ChromeDriver();
    }

    @Given("^I am an agent trying to log in$")
    public void iAmAnAgentTryingToLogIn() throws Exception {
        browser.get("localhost:8080/");
    }

    @When("^I obtain a key from the supervisor using a valid id$")
    public void iObtainAKeyFromTheSupervisorUsingAValidId(String id, String name) throws Exception {

        requestLoginPage.populateKeyForm(id, name);
        requestLoginPage.submitKeyForm();
    }

    @Then("^the supervisor should give me a valid key$")
    public void theSupervisorShouldGiveMeAValidKey() throws Exception {

        assertEquals("Agent Login", loginPage.getPageTitle());
    }

    @When("^I log in using that key$")
    public void iLogInUsingThatKey(String key) throws Exception {

        loginPage = new LoginPage(browser);
        loginPage.populateLoginForm(key);
        loginPage.submitLoginForm();
    }

    @Then("^I should be allowed to log in$")
    public void iShouldBeAllowedToLogIn() throws Exception {
        assertEquals("Messaging System", messagingSystemPage.getPageTitle());
    }

    @When("^I wait for (\\d+) seconds$")
    public void iWaitForSeconds(int arg0) throws Exception {
        // Write code here that turns the phrase above into concrete actions
    }

    @Then("^I should not be allowed to log in$")
    public void iShouldNotBeAllowedToLogIn() throws Exception {
        // Write code here that turns the phrase above into concrete actions
    }

    @Given("^I am a logged in agent$")
    public void iAmALoggedInAgent() throws Exception {
        // Write code here that turns the phrase above into concrete actions
    }

    @When("^I attempt to send (\\d+) messages$")
    public void iAttemptToSendMessages(int arg0) throws Exception {
        // Write code here that turns the phrase above into concrete actions
    }

    @Then("^the messages should be successfully sent$")
    public void theMessagesShouldBeSuccessfullySent() throws Exception {
        // Write code here that turns the phrase above into concrete actions
    }

    @When("^I try to send another message$")
    public void iTryToSendAnotherMessage() throws Exception {
        // Write code here that turns the phrase above into concrete actions
    }

    @Then("^the system will inform me that I have exceeded my quota$")
    public void theSystemWillInformMeThatIHaveExceededMyQuota() throws Exception {
        // Write code here that turns the phrase above into concrete actions
    }

    @And("^I will be logged out$")
    public void iWillBeLoggedOut() throws Exception {
        // Write code here that turns the phrase above into concrete actions
    }

    @When("^I attempt to send the message <message> to another agent$")
    public void iAttemptToSendTheMessageMessageToAnotherAgent() throws Exception {
        // Write code here that turns the phrase above into concrete actions
    }

    @Then("^the other agent should recieve the message <new-message>$")
    public void theOtherAgentShouldRecieveTheMessageNewMessage() throws Exception {
        // Write code here that turns the phrase above into concrete actions
    }

    @When("^I click on \"([^\"]*)\"$")
    public void iClickOn(String arg0) throws Exception {
        // Write code here that turns the phrase above into concrete actions
    }

    @Then("^I should be logged out$")
    public void iShouldBeLoggedOut() throws Exception {
        // Write code here that turns the phrase above into concrete actions
    }

    @After
    public void tearDown(){
        browser.quit();
    }
}
