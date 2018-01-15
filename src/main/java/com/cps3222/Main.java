package com.cps3222;

import java.util.ArrayList;

public class Main {

    public static MessagingSystem ms = new MessagingSystem();
    public static Supervisor supervisor = new Supervisor() {
        public String getLoginKey(Agent agent) {
            if (agent.id.substring(0, 2) != "spy") {
                return ms.generateAlphaNumericString(10);
            }
            return null;
        }
    };
}
