package com.cps3222;

import com.cps3222.stubs.StubGenerateLoginKey;
import com.cps3222.stubs.StubLoginFailure;
import com.cps3222.stubs.StubLoginSuccess;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * Created by denise on 02/01/2018.
 */
public class AgentTest {
    private Agent sender_agent, receiver_agent;


    //@Mock
    //private Agent sender_agent = new Agent("007", "Roll");
    //private Agent receiver_agent = new Agent("008", "Denise");

    @Before
    public void setUp() throws Exception {
        // sender_agent = mock(Agent.class);
        // receiver_agent = mock(Agent.class);

        sender_agent = new Agent("007", "Roll");
        receiver_agent = new Agent("008", "Denise");
        StubGenerateLoginKey stubGenerateLoginKey = new StubGenerateLoginKey();
        sender_agent.loginKey = stubGenerateLoginKey.getLoginKey("007");
    }

    @Test
    public void testLoginPass() throws Exception {
        StubLoginSuccess sls = new StubLoginSuccess();
        boolean loginSuccess = sls.login();
        assertEquals(true, loginSuccess);
    }

    @Test
    public void testLoginFail() throws Exception {

        StubLoginFailure slf = new StubLoginFailure();
        boolean loginFail = slf.login();

        assertEquals(false, loginFail);
    }


    @Test
    public void testsendMessage_nonExistingAgent_messageTooLong() throws Exception {
        String message = "This is a dummy message. Testing for messages longer than 140 characters. Here goes the alphabet: a b c d e f g h i j k l m n o p q r s t u v w x y z, and the numbers 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42";
        assertEquals(false, sender_agent.sendMessage(null, message));
    }

    @Test
    public void testsendMessage_existingAgent_messageTooLong() throws Exception {
        String message = "This is a dummy message. Testing for messages longer than 140 characters. Here goes the alphabet: a b c d e f g h i j k l m n o p q r s t u v w x y z, and the numbers 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42";
        assertEquals(false, sender_agent.sendMessage("ABCDE12345", message));
    }

    @Test
    public void testsendMessage_nonExistingAgent_messageLengthOk() throws Exception {
        assertEquals(false, sender_agent.sendMessage(null, "Hello"));
    }

    @Test
    public void testsendMessage_existingAgent_messageLengthOk() throws Exception {
        assertEquals(true, sender_agent.sendMessage("008", "Hello"));
    }
}