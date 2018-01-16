package com.cps3222;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author Denise Buttigieg, Raoul Fenech
 * @version 14/01/2018
 */

public class MessagingSystem {
    public static ArrayList<Agent> agentList = new ArrayList<Agent>();
    private String blockedWords[] = new String[]{"recipe", "ginger", "nuclear"};
    public String sessionKey = "";
    public long sessionStart;
    private boolean existingAgent = false;
    boolean requestLoginSuccess = false;

    /**
     * Default constructor for MessagingSystem Class
     */
    public MessagingSystem() {
    }

    /**
     * Validates an agent login by contacting the supervisor and registering the login key
     *
     * @param agent agent
     * @param supervisor supervisor
     */
    public void requestLogin(Agent agent, Supervisor supervisor) {
        if(agent.login()) {
            String supervisorLoginKey = supervisor.getLoginKey(agent);

            if (registerLoginKey(agent.id, supervisorLoginKey)) {
                for(Agent a : agentList){
                    if(a.id.equals(agent.id)) {
                        a.loginKey = supervisorLoginKey;
                        a.loginTime = System.currentTimeMillis();
                        existingAgent = true;
                    }
                }
                if(existingAgent != true) {
                    agent.loginKey = supervisorLoginKey;
                    agent.loginTime = System.currentTimeMillis();
                    agentList.add(agent);
                }
                requestLoginSuccess = true;
            } else {
               requestLoginSuccess = false;
            }
        }
    }

    /**
     * Logs in an agent after a successful login requests
     * Checks that the loginKey is not older than 1 minute
     * Checks that the agent loginKey given by the supervisor matches the key that the agent is trying to login with
     *
     * @param agent agent to log in
     * @param key input login key by agent
     * @return a message of type String depending on the login scenario
     */
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
            if (System.currentTimeMillis() - agent.loginTime  <= 60000) {
                if (agent.loginKey.equals(key)) {
                    //if successfully logged in assign session key
//                        agent.sessionKey = RandomStringUtils.randomAlphanumeric(50);
                    agent.loginTime = System.currentTimeMillis();
                    //generate sessionkey and assign to agent
                    sessionKey = generateAlphaNumericString(50);
                    agent.sessionKey = sessionKey;

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

    /**
     * Takes a login key assigned by the supervisor and checks the length and uniqueness
     * @param agentId id of agent to register login key for
     * @param loginKeyAssigned 10-char string assigned by the Supervisor
     * @return true if the loginKey is OK, false otherwise
     */
    public boolean registerLoginKey(String agentId, String loginKeyAssigned){
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

    /**
     * Generates a 50-character sessionKey
     *
     * @return random 50-char alphanumeric string
     */
    public String generateAlphaNumericString(int stringLength) {
        String upperCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCaseLetters = upperCaseLetters.toLowerCase();
        String numbers = "0123456789";
        String alphanumerical = upperCaseLetters + lowerCaseLetters + numbers;

        Random r = new Random();
        String alphaNumericString = "";

        for (int i=0; i<stringLength; i++) {
            alphaNumericString += alphanumerical.charAt(r.nextInt(alphanumerical.length()));
        }
        return alphaNumericString;
    }

    /**
     * Sends a message from the sourceAgent to the targetAgent.
     * Creates a message object and stores it in the taret agent's mailbox.
     * Checks that a message does not contain any blocked words.
     * Should check that a message is not longer than 140 characters.
     *
     * TODO: Checks that the sourceAgent is the same as the one currently logged in (by matching the session key).
     *
     * @param sourceAgent agent sending the message
     * @param targetAgent agent receiving the message
     * @param message message to be sent
     * @return String message according to the sendMessage scenario
     */
    public String sendMessage(Agent sourceAgent, Agent targetAgent, String message) {
        String returnMessage = "";
        if (sourceAgent.sessionKey.equals(sessionKey)) {
            if(agentList.contains(targetAgent)) {
                message = checkBlockedWords(message);
                if (message.length() < 140) {

                    //incrementing messagecount for source agent
                    sourceAgent.mailbox.messageCount++;

                    //checks if mailbox limit has been reached and logs agents out accordingly.
                    if(checkAgentMailbox(sourceAgent) == 26)
                        returnMessage = sourceAgent.logout();
                    else {
                        //sending message through sendMessage method in Agent
                        Message m = new Message(sourceAgent, targetAgent, message, System.currentTimeMillis());
                        sourceAgent.sendMessage(m);

                        returnMessage = "Message sent successfully";
                    }
                } else {
                    returnMessage = "Message length exceeded";
                }
            } else {
                returnMessage = "Target Agent not found";
            }
        }

        return returnMessage;
    }

    /**
     * Checks the number of messages in an agent's mailbox
     *
     * @param agent agent
     * @return the number of messages
     */
    private int checkAgentMailbox(Agent agent){
        return agent.mailbox.messageCount;
    }

    /**
     * Checks the length of a login key
     *
     * @param loginKey loginKey
     * @return true if the login key is of length 10, false otherwise
     */
    private boolean checkLoginKeyLength(String loginKey) {
        return loginKey.length() == 10;
    }

    /**
     * Checks that the loginKey is not being used by other agents
     *
     * @param loginKey loginKey
     * @return true if the loginKey is unique
     */
    private boolean checkUniqueKey(String loginKey){
        boolean found = false;
        for (Agent agent: agentList) {
            if (loginKey.equals(agent.loginKey))
                found = true;
        }
        return found;
    }

    /**
     * Checks for blocked words in a message
     *
     * @param message the message
     * @return true if the message contains no blocked wods
     */
    private String checkBlockedWords(String message) {
        for (int i = 0; i < blockedWords.length; i++) {
            message = message.replaceAll ("(?i)"+blockedWords[i], "");
        }
        return message;
    }
}
