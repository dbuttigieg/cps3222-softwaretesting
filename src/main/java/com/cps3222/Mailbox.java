package com.cps3222;

import java.util.Queue;

/**
 * Created by denise on 02/01/2018.
 */
//holds all messages for a user
public class Mailbox {
    public String ownerID;
    //Queue<Message> mailboxQueue = new LinkedList<Message>();

    public Mailbox(){
    }

    public Mailbox(String ownerID) {
        this.ownerID = ownerID;
    }

    public Message consumeNextMessage(Queue<Message> q) {
        //Returns the next message in the box on a FIFO basis.
        Message messageToConsume;
        if (q.isEmpty()) return null;
        else {
            messageToConsume = q.peek();
            q.remove();
            return messageToConsume;
        }
    }

    public boolean hasMessages(Queue<Message> q) {
        //Checks if there are any messages in the mailbox.
        return !q.isEmpty();
    }
}
