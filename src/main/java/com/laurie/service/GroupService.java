package com.laurie.service;

/**
 * @author Laurie
 */
public interface GroupService {
    /**
     * 创建学习小组
     * @param name 小组名字
     * @param info 小组简介
     */
    void create(String name, String info, int memberid);
}
