package com.cps3222.UnitTests.stubs;

import com.cps3222.Agent;

/**
 * @author Denise Buttigieg, Raoul Fenech
 * @version 14/01/2018
 *
 * Stub class to mock a successful login
 */

public class StubLoginSuccess extends Agent {

    @Override
    public boolean login() {
        return true;
    }
}