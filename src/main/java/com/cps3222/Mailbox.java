package com.cps3222;

import java.util.ArrayList;

/**
 * Created by denise on 02/01/2018.
 */
//holds all messages for a user
public class Mailbox {
    public String ownerID;
    int indexOfCurrentMessage;

    public Mailbox(){
    }

    public Mailbox(String ownerID) {
        this.ownerID = ownerID;
    }

    public Message consumeNextMessage(ArrayList<Message> incomingMessages) {
        if (incomingMessages.get(indexOfCurrentMessage++) == null) return null;
        else return incomingMessages.get(indexOfCurrentMessage);
        //Returns the next message in the box on a FIFO basis.
    }

    public boolean hasMessages(ArrayList<Message> mailbox) {
        //Checks if there are any messages in the mailbox.
        if (mailbox.isEmpty()) return false;
        else return true;
    }
}
