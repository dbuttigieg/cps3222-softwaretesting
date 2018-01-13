package com.cps3222;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by denise and raoul on 02/01/2018.
 */
public class Agent {
    public String id;
    public String name;
    public String loginKey;

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

    public boolean sendMessage(String destinationAgentId, String message) {
        //true if successful false otherwise
        //Sends a message to the destination agent.
        //true if successful false otherwise
        if (message.length() < 140 && destinationAgentId != null) {
            return true;
        }
        else return false;
    }
}
