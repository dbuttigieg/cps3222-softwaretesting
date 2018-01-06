package com.cps3222;

import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.Assert.assertEquals;

/**
 * Created by denise on 02/01/2018.
 */
public class MailboxTest {

    private Queue<Message> mockMailbox = new LinkedList<Message>();
    private Mailbox m;

    @Before
    public void setUp() throws Exception {

        m = new Mailbox();
        mockMailbox.add(new Message());
    }

    @Test
    public void testConsumeMessage_emptyMailbox() throws Exception {

        //making the queue empty
        mockMailbox.remove();

        assertEquals(null, m.consumeNextMessage(mockMailbox));
    }

    @Test
    public void testConsumeMessage() throws Exception {

        assertEquals(mockMailbox.peek(), m.consumeNextMessage(mockMailbox));
    }

    @Test
    public void testHasMessages_emptyMailbox() throws Exception {

        //making the queue empty
        mockMailbox.remove();

        assertEquals(false, m.hasMessages(mockMailbox));
    }

    @Test
    public void testHasMessages() throws Exception {

        assertEquals(true, m.hasMessages(mockMailbox));
    }

}