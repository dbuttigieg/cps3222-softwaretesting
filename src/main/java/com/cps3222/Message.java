package com.cps3222;

/**
 * Created by denise on 02/01/2018.
 */
public class Message {
    public Agent sourceAgent;
    public Agent targetAgent;
    public long timestamp;
    public String content;

    public Message() {
    }

    public Message(Agent sourceAgent, Agent targetAgent, String content, long timestamp){
        this.sourceAgent = sourceAgent;
        this.targetAgent = targetAgent;
        this.content = content;
        this.timestamp = timestamp;
    }
}
//this class was not tested using its own seperate testing class since it is only used to store messages and thus
//its functionality is tested in other classes.