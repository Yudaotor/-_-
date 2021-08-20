package com.laurie.pojo;

/**
 * @author Laurie
 */
public class Topic {
    private Integer topicId;
    private String groupName;
    private Integer userId;
    private String userName;
    private  String topicName;
    private  String topicContent;

    public Topic() {
    }

    public Topic(Integer topicId, String groupName, Integer userId ,String userName, String topicName, String topicContent) {
        this.topicId = topicId;
        this.groupName = groupName;
        this.userId = userId;
        this.userName = userName;
        this.topicName = topicName;
        this.topicContent = topicContent;
    }

    public Integer getTopicId() {
        return topicId;
    }

    public void setTopicId(Integer topicId) {
        this.topicId = topicId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public String getTopicContent() {
        return topicContent;
    }

    public void setTopicContent(String topicContent) {
        this.topicContent = topicContent;
    }
}
