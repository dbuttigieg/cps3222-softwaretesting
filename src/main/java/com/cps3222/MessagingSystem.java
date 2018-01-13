package com.cps3222;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by denise on 02/01/2018.
 */
public class MessagingSystem {
    //pair will save <AgentId, LoginKey>
    ArrayList<ArrayList<String>> loginInfo = new ArrayList<ArrayList<String>>();
    String blockedWords[] = new String[]{"recipe", "ginger", "nuclear", "dish", "salt"};
    String sessionKey = "";

    public MessagingSystem() {
    }

    public String login(String agentId, String loginKey) {
        if(registerLoginKey(agentId, loginKey)) {

            for (ArrayList<String> pair: loginInfo) {
                if (!((pair.get(0) == agentId) && (pair.get(1) == loginKey))){
                    return "ID and key do not match";
                }
            }

        }
            sessionKey = RandomStringUtils.randomAlphanumeric(50);
        return sessionKey;
    }

    public boolean registerLoginKey(String loginKey, String agentId){
        if (!checkLoginKeyLength(loginKey)) {
            System.out.print("Invalid Key Length");
            return false;
        }
        if (checkUniqueKey(loginKey)) {
            System.out.print("Key not unique");
            return false;
        }

        ArrayList<String> loginPair = new ArrayList<String>(Arrays.asList(agentId, loginKey));
        loginInfo.add(loginPair);

        /*
        for (Pair<String, String> pair: loginInfo) {
            if (!(pair.getLeft() == agentId && pair.getRight() == loginKey)) {
                System.out.print("Login and ID do not match");
                return false;
            }
        }*/
        // Takes a login key and agentId such that when an agent with that
        // ID tries to login she will only be allowed access if the key also matches.
        return true;
    }

    public String sendMessage(String sessionKey, String sourceAgentId, String targetAgentId, String message) {
        return null;
    }

    private boolean checkLoginKeyLength(String loginKey) {
        return loginKey.length() == 10;
    }

    private boolean checkUniqueKey(String loginKey){
        boolean found = false;
        for (ArrayList<String> pair: loginInfo) {
            if (pair.get(1) == loginKey) found = true;
        }
        return found;
    }
}
