package com.laurie.dao;

import com.laurie.pojo.Topic;

import java.util.List;

/**
 * @author Laurie
 */
public interface TopicDao {
    /**
     * 通过用户编号来找出他所有发起的话题的信息
     * @param userId 用户编号
     * @return 储存着该用户所有发起的话题信息的链表
     */
    List<Topic> selectTopicByUserId(int userId);

    /**
     * 通过小组名字来找出发起的话题的信息
     * @param groupName 小组名字
     * @return 储存着该小组所有发起的话题信息的链表
     */
    List<Topic> selectTopicByGroupName(String groupName);
    /**
     * 通过话题编号来找出发起的话题的信息
     * @param topicId 话题编号
     * @return 该话题信息
     */
    Topic selectTopicByTopicId(int topicId);

    /**
     * 创建话题
     * @param userId 创建者编号
     * @param groupName 所属小组名字
     * @param userName 创建者用户名
     * @param topicName 话题标题
     * @param topicContent 话题内容
     */
    void createTopic(int userId,String groupName, String userName, String topicName, String topicContent);

    /**
     * 根据话题编号删除话题
     * @param topicId 话题编号
     */
    void deleteTopic(int topicId);

}
