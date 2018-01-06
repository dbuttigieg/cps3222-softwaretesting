package com.cps3222;

/**
 * Created by denise on 02/01/2018.
 */
public class Message {
    public String sourceAgentId;
    public String targetAgentId;
    public long timestamp;
    public String content;

    public Message() {
    }

    public Message(String sourceAgentId, String targetAgentId, String content, long timestamp){
        this.sourceAgentId = sourceAgentId;
        this.targetAgentId = targetAgentId;
        this.content = content;
        this.timestamp = timestamp;
    }
}
//this class was not tested using its own seperate testing class since it is only used to store messages and thus
//its functionality is tested in other classes.