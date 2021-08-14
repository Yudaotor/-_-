package com.laurie.pojo;

/**
 * @author Laurie
 */
public class GroupMember {
    private Integer groupId;
    private Integer memberId;
    private String memberName;

    public GroupMember() {

    }

    public GroupMember(Integer groupId, Integer memberId, String memberName) {
        this.groupId = groupId;
        this.memberId = memberId;
        this.memberName = memberName;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

}
