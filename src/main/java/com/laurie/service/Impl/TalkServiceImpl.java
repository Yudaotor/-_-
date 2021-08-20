package com.laurie.service.Impl;

import com.laurie.dao.Impl.TalkDaoImpl;
import com.laurie.dao.TalkDao;
import com.laurie.service.TalkService;

import java.util.Date;

/**
 * @author Laurie
 */
public class TalkServiceImpl implements TalkService {
    @Override
    public void create(String name, int tid1, int tid2, String content) {
        TalkDao talkDao = new TalkDaoImpl();
        talkDao.createTalk(name,tid1,tid2,content);
    }
}
