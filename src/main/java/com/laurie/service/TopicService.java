package com.laurie.service;

import com.laurie.pojo.Topic;

/**
 * @author Laurie
 */
public interface TopicService {
    /**
     * 通过话题编号来查找话题信息
     * @param topicId 话题的编号
     * @return 话题信息
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
