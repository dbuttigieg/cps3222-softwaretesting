package com.cps3222;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Denise Buttigieg, Raoul Fenech
 * @version 14/01/2018
 *
 * Class holds all messages for an agent
 */

public class Mailbox {
    public String ownerID;
    public int messageCount = 0;
    public Queue<Message> mailboxQueue = new LinkedList<Message>();

    /**
     * Default constructor for Mailbox class
     */
    public Mailbox(){
    }

    /**
     * Constructor to create a Mailbox for a specific Agent
     *
     * @param ownerID agent ID
     */
    public Mailbox(String ownerID) {
       this.ownerID = ownerID;
    }

    /**
     * Adds message to mailbox
     *
     * @param m message
     */
    public void addMessage(Message m){
        mailboxQueue.add(m);
    }

    /**
     * Returns the next message in the queue
     *
     * @param q Queue data structure to hold the messages in a FIFO manner
     * @return the next message in the queue
     */
    public Message consumeNextMessage(Queue<Message> q) {
        Message messageToConsume;
        if (q.isEmpty()) return null;
        else {
            messageToConsume = q.peek();
            if(System.currentTimeMillis() - messageToConsume.timestamp <= 30000) {
                q.remove();
            }
            else{
                q.remove();
                messageToConsume = consumeNextMessage(q);
            }
        }
        return messageToConsume;
    }

    /**
     * Cheks if there are any messages in the mailbox
     *
     * @param q Queue data structure to hold the messages in a FIFO manner
     * @return true if empty, false if not empty
     */
    public boolean hasMessages(Queue<Message> q) {
        return !q.isEmpty();
    }
}
