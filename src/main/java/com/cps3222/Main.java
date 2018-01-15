package com.cps3222;

public class Main {

    public static Agent agent =  new Agent();
    public static Mailbox mailbox =  new Mailbox();
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
