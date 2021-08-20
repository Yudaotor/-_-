package com.laurie.dao;

import com.laurie.pojo.Talk1;

import java.util.Date;
import java.util.List;

/**
 * @author Laurie
 */
public interface TalkDao {
    /**
     * 创建一级评论
     * @param name 被评论话题名字
     * @param tid1 评论者编号
     * @param tid2 被评论者编号
     * @param content 评论内容
     */
    void createTalk(String name, int tid1, int tid2, String content);

    /**
     * 根据话题编号查找对应的评论
     * @param name 话题名称
     * @return 存储着评论信息的链表
     */
    List<Talk1> selectTalkByTopicName(String name);
}
