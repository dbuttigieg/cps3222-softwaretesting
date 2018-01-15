package com.cps3222.UnitTests.stubs;

import com.cps3222.Agent;
import com.cps3222.Supervisor;

/**
 * @author Denise Buttigieg, Raoul Fenech
 * @version 14/01/2018
 */

public class StubGenerateLoginKey implements Supervisor {

    /**
     * Stub method to generate a 10-char loginKey (dummy value)
     * @return a loginKey of length 10
     */
    public String getLoginKey(Agent agent) {
        if(agent.id.substring(0,2) != "spy") {
            return "ABCDE12345";
        }
        return null;
    }
}
