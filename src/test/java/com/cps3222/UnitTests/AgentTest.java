package com.cps3222.UnitTests;

import com.cps3222.Agent;
import com.cps3222.UnitTests.stubs.StubGenerateLoginKey;
import com.cps3222.UnitTests.stubs.StubLoginFailure;
import com.cps3222.UnitTests.stubs.StubLoginSuccess;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * @author Denise Buttigieg, Raoul Fenech
 * @version 14/01/2018
 */
public class AgentTest {
    private Agent sender_agent, receiver_agent;

    @Before
    public void setUp() throws Exception {
        sender_agent = new Agent("007", "Roll");
        receiver_agent = new Agent("008", "Denise");
    }

    @Test
    public void testLoginPass() throws Exception {
        StubLoginSuccess sls = new StubLoginSuccess();
        boolean loginSuccess = sls.login();
        assertEquals(true, loginSuccess);

        StubGenerateLoginKey stubGenerateLoginKey = new StubGenerateLoginKey();
        sender_agent.loginKey = stubGenerateLoginKey.getLoginKey(sender_agent);
        assertEquals(sender_agent.loginKey, "ABCDE12345");
    }

    @Test
    public void testLoginFail() throws Exception {

        StubLoginFailure slf = new StubLoginFailure();
        boolean loginFail = slf.login();

        assertEquals(false, loginFail);
    }
}