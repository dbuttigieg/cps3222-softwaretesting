package com.cps3222;

/**
 * Created by denise on 02/01/2018.
 */
//holds all messages for a user
public class Mailbox {
    String ownerID;

    public Mailbox(){
    }

    public Message consumeNextMessage() {
        //Returns the next message in the box on a FIFO basis.
        return null;
    }

    public boolean hasMessages() {
        //Checks if there are any messages in the mailbox.
        return false;
    }
}
