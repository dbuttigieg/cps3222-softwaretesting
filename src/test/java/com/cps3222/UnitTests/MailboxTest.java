package com.cps3222.UnitTests;

import com.cps3222.Agent;
import com.cps3222.Mailbox;
import com.cps3222.Message;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.Assert.assertEquals;

/**
 * @author Denise Buttigieg, Raoul Fenech
 * @version 14/01/2018
 */
public class MailboxTest {

    private Queue<Message> mockMailbox = new LinkedList<Message>();
    private Mailbox m;

    @Before
    public void setUp() throws Exception {
        m = new Mailbox("007");
        Message m1 = new Message(new Agent("007", "Denise"), new Agent("008", "Dennis"), "Message1", 10000);
        Message m2 = new Message(new Agent("007", "Denise"), new Agent("008", "Dennis"), "Message2", 20000);
        Message m3 = new Message(new Agent("007", "Denise"), new Agent("008", "Dennis"), "Message3", 30000);

        mockMailbox.add(m1);
        mockMailbox.add(m2);
        mockMailbox.add(m3);
    }

    @Test
    public void testConsumeNextMessage() throws Exception {
        assertEquals(mockMailbox.peek(), m.consumeNextMessage(mockMailbox));
    }

    @Test
    public void testConsumeMessage_emptyMailbox() throws Exception {
        //making the queue empty
        mockMailbox.remove();
        mockMailbox.remove();
        mockMailbox.remove();

        assertEquals(null, m.consumeNextMessage(mockMailbox));
    }

    @Test
    public void testHasMessages_emptyMailbox() throws Exception {

        //making the queue empty
        mockMailbox.remove();
        mockMailbox.remove();
        mockMailbox.remove();

        assertEquals(false, m.hasMessages(mockMailbox));
    }

    @Test
    public void testHasMessages() throws Exception {
        assertEquals(true, m.hasMessages(mockMailbox));
    }

}