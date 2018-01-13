package com.cps3222.stubs;

import com.cps3222.Agent;
import com.cps3222.Supervisor;

/**
 * Created by denise on 02/01/2018.
 */

//login key string is a dummy value since as of right now, we do not know what format the login key should be in
public class StubGenerateLoginKey implements Supervisor {

    public void getLoginKey(Agent agent) {
        agent.loginKey = "ABCDE12345";
        agent.loginTime = System.currentTimeMillis();
    }
}
