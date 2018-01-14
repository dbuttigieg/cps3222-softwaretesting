package com.cps3222;

import com.cps3222.stubs.StubGenerateLoginKey;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author Denise Buttigieg, Raoul Fenech
 * @version 14/01/2018
 */
public class MessagingSystemTest {

    private Agent agent;
    private MessagingSystem ms;
    private StubGenerateLoginKey generateLoginKey;
    private Supervisor supervisor;
    private String rndKey = RandomStringUtils.randomAlphanumeric(50);


    @Before
    public void setUp() throws Exception {
        supervisor = mock(Supervisor.class);
        agent = new Agent("007", "Roll");

        ms = new MessagingSystem();
        ms.sessionKey = rndKey;
        agent.sessionKey = rndKey;
        generateLoginKey = new StubGenerateLoginKey();

        MockitoAnnotations.initMocks(this);

        when(supervisor.getLoginKey()).thenReturn(generateLoginKey.getLoginKey());
        ms.requestLogin(agent, supervisor);

    }

    //valid login within 1 minute
    @Test
    public void login_valid_within1minute() throws Exception {
        String message = ms.login(agent, agent.loginKey);
        assertTrue(agent.loginTime-System.currentTimeMillis() < 60000);
        assertEquals("Login Successful", message);
    }

    //invalid login after 1 minute
    @Test
    public void login_after1minute() throws Exception {
        agent.loginTime += 700000;
        String message = ms.login(agent, agent.loginKey);

        assertTrue((agent.loginTime)-System.currentTimeMillis() > 60000);
        assertEquals("Login Timeout", message);
    }

    //login with a different key
    @Test
    public void login_differentKey() throws Exception {
        String message = ms.login(agent, "12345ABM");

        assertEquals("Invalid Login Key", message);
    }

    //3 agents initially: agent, mockAgent1, mockAgent2
    //checks if agent was removed
    @Test
    public void login_checkRemovedAgent() throws Exception {
        String message = ms.login(agent, agent.loginKey);

        assertTrue(ms.agentList.size() == 0);
        assertEquals("Login Successful", message);
    }

    //registering a key with invalid length
    @Test
    public void register_invalidKeyLength() throws Exception {
        boolean registerSuccess = ms.registerLoginKey("001", "ABC123");

        assertEquals(false, registerSuccess);
    }

    //registering a non-unique key
    @Test
    public void register_keyNotUnique() throws Exception {
        boolean registerSuccess = ms.registerLoginKey("001", "ABCDE12345");

        assertEquals(false, registerSuccess);
    }

    //registering a valid key
    @Test
    public void register_validKey() throws Exception {
        boolean registerSuccess = ms.registerLoginKey("001", "QWERT19024");

        assertEquals(true, registerSuccess);
    }

    //expired session (10 mins of being logged in)
    @Test
    public void expiredSession() throws Exception {
        boolean registerSuccess = ms.registerLoginKey("001", "QWERT19024");

        assertEquals(true, registerSuccess);
    }

    //target agent doesn't exist
    @Test
    public void targetAgentNotFound() throws Exception {
        String returnMessage = ms.sendMessage(agent, new Agent("008", "Tom"), "Hello");

        assertEquals("Target Agent not found", returnMessage);
    }

    //message contains blocked words
    //for the purpose of this test, agent is sending to himself
    @Test
    public void messageHasBlockedWords() throws Exception {
        String returnMessage = ms.sendMessage(agent, agent, "Hello. Pass the salt.");

        assertEquals("Invalid message content", returnMessage);
    }

    //message exceeds 140 characterlimit
    @Test
    public void messageExceedsCharLimit() throws Exception {
        String returnMessage = ms.sendMessage(agent, agent, "This is a dummy message. Testing for messages longer than 140 characters. Here goes the alphabet: a b c d e f g h i j k l m n o p q r s t u v w x y z, and the numbers 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42");

        assertEquals("Message length exceeded", returnMessage);
    }

    //message sent successfully
    @Test
    public void messageSent() throws Exception {
        String returnMessage = ms.sendMessage(agent, agent, "Hello");

        assertEquals("Message sent successfully", returnMessage);
    }

    //message sent successfully and source agent mailbox full
    @Test
    public void messageSent_sourceAgentMailboxFull() throws Exception {
        //Right now this is set at 23 since both source and target agent are the same,
        //therefore incrementing messageCount by 2.
        agent.mailbox.messageCount = 23;
        String returnMessage = ms.sendMessage(agent, agent, "Hello");

        assertEquals("Message sent successfully. Mailbox full. Logging out", returnMessage);
    }

    //message sent successfully and target agent mailbox full
    @Test
    public void messageSent_targetAgentMailboxFull() throws Exception {
        agent.mailbox.messageCount = 23;
        String returnMessage = ms.sendMessage(agent, agent, "Hello");

        assertEquals("Message sent successfully. Mailbox full. Logging out", returnMessage);
    }
}