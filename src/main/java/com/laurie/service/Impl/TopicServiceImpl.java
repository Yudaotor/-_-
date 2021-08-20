package com.laurie.service.Impl;

import com.laurie.dao.Impl.TopicDaoImpl;
import com.laurie.dao.TopicDao;
import com.laurie.pojo.Topic;
import com.laurie.service.TopicService;

/**
 * @author Laurie
 */
public class TopicServiceImpl implements TopicService {
    @Override
    public Topic selectTopicByTopicId(int topicId) {
        TopicDao topicDao = new TopicDaoImpl();
        return topicDao.selectTopicByTopicId(topicId);
    }

    @Override
    public void createTopic(int userId, String groupName, String userName, String topicName, String topicContent) {
        TopicDao topicDao = new TopicDaoImpl();
        topicDao.createTopic(userId,groupName,userName,topicName,topicContent);
    }

    @Override
    public void deleteTopic(int topicId) {
        TopicDao topicDao = new TopicDaoImpl();
        topicDao.deleteTopic(topicId);
    }
}
