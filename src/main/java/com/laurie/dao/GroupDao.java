package com.laurie.dao;


import com.laurie.pojo.Group;

/**
 * @author Laurie
 */
public interface GroupDao {
    /**
     * 根据输入的信息创建学习小组
     * @param name 小组名称
     * @param info 小组简介
     */
    void createGroup(String name, String info, int memberid);

    /**
     * 根据想加的小组编号和用户编号来完成加入小组的指令
     * @param groupId 想要加入的小组编号
     * @param userId 用户编号
     */
    void joinGroup(Integer groupId,Integer userId);

    /**
     * 根据小组名字来查询小组信息
     * @param name 小组的名字
     * @return 返回一个存放着对应编号小组的数据
     */
    Group getGroupByName(String name);
}
