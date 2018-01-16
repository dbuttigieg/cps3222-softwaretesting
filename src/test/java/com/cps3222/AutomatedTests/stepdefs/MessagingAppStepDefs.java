package com.cps3222.AutomatedTests.stepdefs;

import com.cps3222.Agent;
import com.cps3222.AutomatedTests.PageObjects.*;
import com.cps3222.Supervisor;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by denise on 15/01/2018.
 */
public class MessagingAppStepDefs {
    WebDriver browser;
    RequestLoginPage requestLoginPage;
    LoginPage loginPage;
    MessagingSystemPage messagingSystemPage;
    LoginErrorPage loginErrorPage;
    MessageResponsePage messageResponsePage;

    @Before
    public void setup() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Raoul\\Desktop\\UNI\\Year III\\Testing\\Assignment\\cps3222-softwaretesting\\chromedriver.exe");
        browser = new ChromeDriver();
    }

    /**SCENARIO 1**/
    @Given("^I am an agent trying to log in$")
    public void iAmAnAgentTryingToLogIn() throws Exception {
        browser.get("localhost:8080/");
    }

    @When("^I obtain a key from the supervisor using a valid id as \"([^\"]*)\" and name as \"([^\"]*)\"$")
    public void iObtainAKeyFromTheSupervisorUsingAValidIdAsAndNameAs(String id, String name) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        requestLoginPage = new RequestLoginPage(browser);
        requestLoginPage.populateKeyForm(id, name);
        requestLoginPage.submitKeyForm();
    }

    @Then("^the supervisor should give me a valid key$")
    public void theSupervisorShouldGiveMeAValidKey() throws Exception {
        loginPage = new LoginPage(browser);
        assertEquals("Agent Login", loginPage.getPageTitle());
    }

    @When("^I log in using that key$")
    public void iLogInUsingThatKey() throws Exception {
        String key = loginPage.obtainSupervisorKey();
        loginPage.populateLoginForm(key);
        loginPage.submitLoginForm();
    }

    @Then("^I should be allowed to log in$")
    public void iShouldBeAllowedToLogIn() throws Exception {
        messagingSystemPage = new MessagingSystemPage(browser);
        assertEquals("Messaging System", messagingSystemPage.getPageTitle());
    }

    /**SCENARIO 2**/

    @When("^I wait for (\\d+) seconds$")
    public void iWaitForSeconds(int arg0) throws Exception {
        Thread.sleep(65000);
    }

    @Then("^I should not be allowed to log in$")
    public void iShouldNotBeAllowedToLogIn() throws Exception {
        loginErrorPage = new LoginErrorPage(browser);
        String errorMessage = loginErrorPage.obtainErrorMessage();
        assertEquals("Login Timeout", errorMessage);
    }

    /**SCENARIO 3**/

    @Given("^I am a logged in agent$")
    public void iAmALoggedInAgent() throws Exception {
        browser.get("localhost:8080/");

        //logging in another agent to allow message sending
        requestLoginPage = new RequestLoginPage(browser);
        requestLoginPage.populateKeyForm("001", "denise");
        requestLoginPage.submitKeyForm();

        loginPage = new LoginPage(browser);
        String key = loginPage.obtainSupervisorKey();
        loginPage.populateLoginForm(key);
        loginPage.submitLoginForm();

        //logging out this agent
        messagingSystemPage = new MessagingSystemPage(browser);
        messagingSystemPage.logout();

        //logging in the source agent to send messages
        requestLoginPage = new RequestLoginPage(browser);
        requestLoginPage.populateKeyForm("007", "raoul");
        requestLoginPage.submitKeyForm();

        loginPage = new LoginPage(browser);
        String key2 = loginPage.obtainSupervisorKey();
        loginPage.populateLoginForm(key2);
        loginPage.submitLoginForm();
    }

    @When("^I attempt to send (\\d+) messages$")
    public void iAttemptToSendMessages(int arg0) throws Exception {
        for(int i = 0; i < 24; i++) {
            messagingSystemPage = new MessagingSystemPage(browser);
            messagingSystemPage.sendMessage("message");
            messageResponsePage = new MessageResponsePage(browser);
            messageResponsePage.backToSystem();
        }
        //to enable next scenario step
        messagingSystemPage = new MessagingSystemPage(browser);
        messagingSystemPage.sendMessage("message");
        messageResponsePage = new MessageResponsePage(browser);
    }

    @Then("^the messages should be successfully sent$")
    public void theMessagesShouldBeSuccessfullySent() throws Exception {
        String successMessage = messageResponsePage.getSuccessMessage();
        assertEquals("Message sent successfully", successMessage);
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
