package com.cps3222;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;

/**
 * Created by denise on 02/01/2018.
 */
public class MessagingSystem {
    public ArrayList<Agent> agentList = new ArrayList<Agent>();
    private String blockedWords[] = new String[]{"recipe", "ginger", "nuclear", "dish", "salt"};
    public String sessionKey = "";
//    Supervisor supervisor;
    private boolean requestLoginSuccess = false;

    public MessagingSystem() {
    }

    public void requestLogin(Agent agent, Supervisor supervisor) {
        if(agent.login()) {
            String supervisorLoginKey = supervisor.getLoginKey();

            if (registerLoginKey(supervisorLoginKey)) {
                agent.loginKey = supervisorLoginKey;
                agent.loginTime = System.currentTimeMillis();
                requestLoginSuccess = true;

            } else {
               requestLoginSuccess = false;
            }
        }
    }

    public String login(Agent agent, String key) {
        String message = "";
        /**
         * 1. Agent requests login
         * 2. Contact Supervisor
         * 3. Supervisor assigns LoginKey
         * 4. LoginKey is valid for 1 minute.
         */
        //Supervisor to assign login
        if (requestLoginSuccess) {
            //if allowed, Agent can log in
            //allow 1 minute for login
            if (System.currentTimeMillis() - agent.loginTime <= 60000) {
                if (agent.loginKey.equals(key)) {
                    //if successfully logged in assign session key
//                        agent.sessionKey = RandomStringUtils.randomAlphanumeric(50);
                    agent.loginTime = System.currentTimeMillis();
                    sessionKey = generateSessionKey();
                    message = "Login Successful";
                } else {
                    message = "Invalid Login Key";
                }
            } else {
                message = "Login Timeout";
            }
        }
        return message;
    }

    // Takes a login key and agentId such that when an agent with that
    // ID tries to login she will only be allowed access if the key also matches.

    public boolean registerLoginKey(String loginKeyAssigned){
        if (!checkLoginKeyLength(loginKeyAssigned)) {
            System.out.print("Invalid Key Length");
            return false;
        }

        if (checkUniqueKey(loginKeyAssigned)) {
            System.out.print("Key not unique");
            return false;
        }

        return true;
    }

    public String generateSessionKey() {
        return RandomStringUtils.randomAlphanumeric(50);
    }

    public String sendMessage(String sessionKey, Agent sourceAgent, Agent targetAgent, String message) {
        String returnMessage = "";
        if (sessionKey == this.sessionKey) {
            if(agentList.contains(targetAgent)) {
                if (!checkBlockedWords(message)) {
                    if (sourceAgent.sendMessage(targetAgent.id, message)) {
                        returnMessage = "Message successfully sent";
                    } else {
                        returnMessage = "Message length exceeded";
                    }
                } else {
                    returnMessage = "Invalid message content";
                }
            } else {
                returnMessage = "Target Agent not found";
            }
        } else {
            returnMessage = "Expired Session";
        }

        return returnMessage;
    }

    private boolean checkLoginKeyLength(String loginKey) {
        return loginKey.length() == 10;
    }

    private boolean checkUniqueKey(String loginKey){
        boolean found = false;
        for (Agent agent: agentList) {
            if (loginKey.equals(agent.loginKey))
                found = true;
        }
        return found;
    }

    private boolean checkBlockedWords(String message) {
        for (int i = 0; i < blockedWords.length; i++) {
            if (message.toLowerCase().indexOf(blockedWords[i].toLowerCase()) != -1)
                return true;
        }
        return false;
    }
}
