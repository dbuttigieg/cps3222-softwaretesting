package com.cps3222.stubs;

import com.cps3222.Supervisor;

/**
 * Created by denise on 02/01/2018.
 */

//login key string is a dummy value since as of right now, we do not know what format the login key should be in
public class StubGenerateLoginKey implements Supervisor {
    public String getLoginKey(String agentId) {
        return "ABCDE12345"; //dummy value
    }
}
