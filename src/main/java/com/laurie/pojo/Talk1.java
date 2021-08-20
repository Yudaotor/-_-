package com.laurie.pojo;

import java.util.Date;

/**
 * @author Laurie
 */
public class Talk1 {
    private Integer talkId;
    private String topicName;
    private Integer talkId1;
    private Integer talkId2;
    private String talkContent;
    private Date talkTime;

    public Talk1() {
    }

    public Talk1(Integer talkId, String topicName, Integer talkId1, Integer talkId2, String talkContent, Date talkTime) {
        this.talkId = talkId;
        this.topicName = topicName;
        this.talkId1 = talkId1;
        this.talkId2 = talkId2;
        this.talkContent = talkContent;
        this.talkTime = talkTime;
    }

    public Integer getTalkId() {
        return talkId;
    }

    public void setTalkId(Integer talkId) {
        this.talkId = talkId;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public Integer getTalkId1() {
        return talkId1;
    }

    public void setTalkId1(Integer talkId1) {
        this.talkId1 = talkId1;
    }

    public Integer getTalkId2() {
        return talkId2;
    }

    public void setTalkId2(Integer talkId2) {
        this.talkId2 = talkId2;
    }

    public String getTalkContent() {
        return talkContent;
    }

    public void setTalkContent(String talkContent) {
        this.talkContent = talkContent;
    }

    public Date getTalkTime() {
        return talkTime;
    }

    public void setTalkTime(Date talkTime) {
        this.talkTime = talkTime;
    }
}
