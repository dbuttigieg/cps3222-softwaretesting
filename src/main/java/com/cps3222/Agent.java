package com.cps3222;

/**
 * @author Denise Buttigieg, Raoul Fenech
 * @version 14/01/2018
 */
public class Agent {
    public String id;
    public String name;
    public String loginKey;
    public long loginTime;
    public String sessionKey;
    public Mailbox mailbox = new Mailbox();

    /**
     * Default constructor for class Agent
     */
    public Agent() {
    }

    /**
     * Constructor for class agent to create an agent with a name and id
     *
     * @param id the id of the agent
     * @param name the name of the agent
     */
    public Agent(String id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Initiates contact with a supervisor to get a login key and subsequently logs into the system.
     * TODO: Implement this method further once Supervisor class is implemented
     *
     * @return true if login is successful, false otherwise
     */
    public boolean login() {
       return true;
    }

    /**
     * Adds a successfully delivered message to the target Agent's mailbox
     *
     * @param m a message
     * @return true if successful,
     */
    public boolean sendMessage(Message m) {
        m.targetAgent.mailbox.addMessage(m);
        return true;
    }

    /**
     * Logs out agent
     *
     * @return logout message
     */
    public String logout(){

        mailbox.clearMailbox();
        return "Message sent successfully. Mailbox full. Logging out";
    }
}
