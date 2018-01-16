package com.cps3222.AutomatedTests.stepdefs;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
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
    public void iAmAnAgentTryingToLogIn() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
    }

    @When("^I obtain a key from the supervisor using a valid id$")
    public void iObtainAKeyFromTheSupervisorUsingAValidId() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
    }

    @Then("^the supervisor should give me a valid key$")
    public void theSupervisorShouldGiveMeAValidKey() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
    }

    @When("^I log in using that key$")
    public void iLogInUsingThatKey() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
    }

    @Then("^I should be allowed to log in$")
    public void iShouldBeAllowedToLogIn() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
    }

    @When("^I wait for (\\d+) seconds$")
    public void iWaitForSeconds(int arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
    }

    @Then("^I should not be allowed to log in$")
    public void iShouldNotBeAllowedToLogIn() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
    }

    @Given("^I am a logged in agent$")
    public void iAmALoggedInAgent() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
    }

    @When("^I attempt to send (\\d+) messages$")
    public void iAttemptToSendMessages(int arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
    }

    @Then("^the messages should be successfully sent$")
    public void theMessagesShouldBeSuccessfullySent() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
    }

    @When("^I try to send another message$")
    public void iTryToSendAnotherMessage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
    }

    @Then("^the system will inform me that I have exceeded my quota$")
    public void theSystemWillInformMeThatIHaveExceededMyQuota() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
    }

    @And("^I will be logged out$")
    public void iWillBeLoggedOut() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
    }

    @When("^I attempt to send the message <message> to another agent$")
    public void iAttemptToSendTheMessageMessageToAnotherAgent() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
    }

    @Then("^the other agent should recieve the message <new-message>$")
    public void theOtherAgentShouldRecieveTheMessageNewMessage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
    }

    @When("^I click on \"([^\"]*)\"$")
    public void iClickOn(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
    }

    @Then("^I should be logged out$")
    public void iShouldBeLoggedOut() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
    }

    @After
    public void tearDown(){
        browser.quit();
    }
}
