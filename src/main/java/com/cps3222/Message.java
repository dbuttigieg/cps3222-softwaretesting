package com.cps3222;

/**
 * @author Denise Buttigieg, Raoul Fenech
 * @version 14/01/2018
 *
 * NOTE: There were no specific tests created for this class at this point since
 * coverage was tested by using the class in other methods.
 */

public class Message {
    public Agent sourceAgent;
    public Agent targetAgent;
    public long timestamp;
    public String content;

    /**
     * Default constructor for Message Clas
     */
    public Message() {
    }

    /**
     * Constructor for Message class to create a message with specific parameters
     *
     * @param sourceAgent agent who is sending the message
     * @param targetAgent agent who is receiving the message
     * @param content message
     * @param timestamp timestamp of when the message was created
     */
    public Message(Agent sourceAgent, Agent targetAgent, String content, long timestamp){
        this.sourceAgent = sourceAgent;
        this.targetAgent = targetAgent;
        this.content = content;
        this.timestamp = timestamp;
    }
}