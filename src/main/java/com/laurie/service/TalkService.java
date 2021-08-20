package com.laurie.service;

import java.util.Date;

/**
 * @author Laurie
 */
public interface TalkService {
    /**
     * 创建一级评论
     * @param name 被评论话题名字
     * @param tid1 评论者编号
     * @param tid2 被评论者编号
     * @param content 评论内容
     */
    void create(String name, int tid1, int tid2, String content);
}
