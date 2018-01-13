package com.cps3222;

/**
 * Created by denise and raoul on 02/01/2018.
 */
public class Agent {
    public String id;
    public String name;
    public String loginKey;
    public long loginTime;
    public Mailbox mailbox = new Mailbox();
//    public String sessionKey;

    public Agent() {
    }

    public Agent(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public boolean login() {
        //true if successful false otherwise
        //Initiates contact with a supervisor to get a login key and subsequently logs into the system.
        return true;
    }

    public boolean sendMessage(Message m) {
        m.targetAgent.mailbox.addMessage(m);
        return true;
    }

    public String logout(){
        //some logout code
        return "Message sent successfully. Mailbox full. Logging out";
    }
}
