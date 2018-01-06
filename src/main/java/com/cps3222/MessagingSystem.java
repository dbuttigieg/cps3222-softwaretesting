package com.cps3222;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by denise on 02/01/2018.
 */
public class MessagingSystem {
    //pair will save <AgentId, LoginKey>
    List<Pair<String, String>> loginInfo = new ArrayList<Pair<String, String>>();

    public MessagingSystem() {
    }

    public String login(String AgentId, String loginKey) {
        String sessionKey = "";
        if(registerLoginKey(AgentId, loginKey)) sessionKey = RandomStringUtils.randomAlphanumeric(50);

        return sessionKey;
        // grants login access
    }

    public boolean registerLoginKey(String loginKey, String agentId){
        if (!checkLoginKeyLength(loginKey)) {
            System.out.print("Invalid Key Length");
            return false;
        }
        if (!checkUniqueKey(loginKey)) {
            System.out.print("Key not unique");
            return false;
        }

        for (Pair<String, String> pair: loginInfo) {
            if (!(pair.getLeft() == agentId && pair.getRight() == loginKey)) {
                System.out.print("Login and ID do not match");
                return false;
            }
        }
        // Takes a login key and agentId such that when an agent with that
        // ID tries to login she will only be allowed access if the key also matches.
        return true;
    }

    public String sendMessage(String sessionKey, String sourceAgentId, String targetAgentId, String message) {
        // Sends a message from the sourceAgent to the targetAgent
        return null;
    }

    private boolean checkLoginKeyLength(String loginKey) {
        return loginKey.length() == 10;
    }

    private boolean checkUniqueKey(String loginKey){
        boolean found = false;
        for (Pair<String, String> pair: loginInfo) {
            if (pair.getRight() == loginKey) found = false;
        }
        return found;
    }
}
