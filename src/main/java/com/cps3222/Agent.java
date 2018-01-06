package com.cps3222;

/**
 * Created by denise and raoul on 02/01/2018.
 */
public class Agent {
    public String id;
    public String name;

    public Agent() {
    }

    public boolean login() {
        //true if successful false otherwise
        //Initiates contact with a supervisor to get a login key and subsequently logs into the system.
        return true;
    }

    public boolean sendMessage(String destinationAgentId, String message) {
        //true if successful false otherwise
        //Sends a message to the destination agent.
        //true if successful false otherwise
        if (message.length() < 140 && destinationAgentId != null) {
            return true;
        }
        return false;
    }
}
