package com.cps3222;

import org.junit.Before;
import org.junit.Test;
import org.mockito.*;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;


/**
 * Created by denise on 02/01/2018.
 */
public class AgentTest {

    @Mock
    private Agent agent;

    @Before
    public void setUp() throws Exception {
        agent = mock(Agent.class);
    }

    @Test
    public void loginPass() throws Exception {

        when(agent.login()).thenReturn(true);
        boolean loginSuccess = agent.login();

        assertEquals(true, loginSuccess);
    }

    @Test
    public void loginFail() throws Exception {

        when(agent.login()).thenReturn(false);
        boolean loginSuccess = agent.login();

        assertEquals(false, loginSuccess);
    }

    @Test
    public void sendMessage() throws Exception {

    }

}