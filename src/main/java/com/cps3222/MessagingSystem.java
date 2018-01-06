package com.cps3222;

/**
 * Created by denise on 02/01/2018.
 */
public class MessagingSystem {

    public MessagingSystem() {
    }

    public String login(String AgentId, String loginKey) {
        //grants login access
        return null;
    }

    public boolean registerLoginKey(String loginKey, String agentId){
        //Takes a login key and agentId such that when an agent with that
        // Id tries to login she will only be allowed access if the key also matches.
        return false;
    }

    public String sendMessage(String sessionKey, String sourceAgentId, String targetAgentId, String message) {
        //Sends a message from the sourceAgent to the targetAgent
        return null;
    }
}
