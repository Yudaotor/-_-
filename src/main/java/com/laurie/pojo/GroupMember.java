package com.laurie.pojo;

/**
 * @author Laurie
 */
public class GroupMember {
    private Integer memberId;
    private String memberName;

    public GroupMember() {

    }

    public GroupMember(Integer memberId, String memberName) {
        this.memberId = memberId;
        this.memberName = memberName;
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
