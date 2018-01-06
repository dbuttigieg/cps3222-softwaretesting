package com.cps3222.stubs;

import com.cps3222.Agent;

/**
 * Created by denise on 02/01/2018.
 */
public class StubLoginFailure extends Agent {
    @Override
    public boolean login() {
        return false;
    }
}
