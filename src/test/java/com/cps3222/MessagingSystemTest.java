package com.cps3222;

import com.cps3222.stubs.StubGenerateLoginKey;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by denise on 02/01/2018.
 */
public class MessagingSystemTest {
    private Agent agent;
    private MessagingSystem ms;
    private StubGenerateLoginKey generateLoginKey;
    private Supervisor supervisor;
//    @Mock
//    Supervisor supervisor;

    @Before
    public void setUp() throws Exception {
        supervisor = mock(Supervisor.class);

        ms = new MessagingSystem();
        agent = new Agent("007", "Roll");
        generateLoginKey = new StubGenerateLoginKey();

        MockitoAnnotations.initMocks(this);

        when(supervisor.getLoginKey()).thenReturn(generateLoginKey.getLoginKey());
        ms.requestLogin(agent, supervisor);
    }

    @Test
    public void login_within1minute() throws Exception {
        String message = ms.login(agent, "ABCDE12345");
        assertTrue(agent.loginTime-System.currentTimeMillis() < 60000);
        assertEquals("Login Successful", message);
    }

    @Test
    public void login_after1minute() throws Exception {
//        agent.loginTime += 70000;

        String message = ms.login(agent, "ABCDE12345");

        assertTrue((agent.loginTime+70000)-System.currentTimeMillis() > 60000);
        assertEquals("Login Timeout", message);
    }

    @Test
    public void registerLoginKey() throws Exception {

    }

    @Test
    public void sendMessage() throws Exception {

    }

}