package com.laurie.pojo;

/**
 * @author Laurie
 */
public class Group {
    private String groupName;
    private Integer groupSize;
    private String groupInfo;

    public Group() {

    }

    public Group(String groupName, Integer groupSize, String groupInfo) {
        this.groupName = groupName;
        this.groupSize = groupSize;
        this.groupInfo = groupInfo;
    }

    public Integer getGroupSize() {
        return groupSize;
    }

    public void setGroupSize(Integer groupSize) {
        this.groupSize = groupSize;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupInfo() {
        return groupInfo;
    }

    public void setGroupInfo(String groupInfo) {
        this.groupInfo = groupInfo;
    }

}
