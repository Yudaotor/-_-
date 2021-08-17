package com.laurie.dao;


import com.laurie.pojo.Group;

import java.util.List;

/**
 * @author Laurie
 */
public interface GroupDao {
    /**
     * 根据输入的信息创建学习小组
     * @param name 小组名称
     * @param info 小组简介
     * @param memberid 创始人编号
     */
    void createGroup(String name, String info, int memberid);

    /**
     * 根据想加的小组名字和用户编号来完成加入小组的指令
     * @param groupName 想要加入的小组名字
     * @param userId 用户编号
     */
    void joinGroup(String groupName,Integer userId);

    /**
     * 根据小组名字来查询小组信息
     * @param name 小组的名字
     * @return 返回一个存放着对应编号小组的数据
     */
    Group getGroupByName(String name);

    /**
     * 查找出所有小组的信息
     * @return 存放着学校小组信息的Group的链表
     */
    List<Group> selectGroupAll();
}
