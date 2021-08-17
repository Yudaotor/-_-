package com.laurie.service.Impl;

import com.laurie.dao.GroupDao;
import com.laurie.dao.Impl.GroupDaoImpl;
import com.laurie.dao.Impl.UserDaoImpl;
import com.laurie.dao.UserDao;
import com.laurie.service.GroupService;

/**
 * @author Laurie
 */
public class GroupServiceImpl implements GroupService {
    private final GroupDao groupDao;

    public GroupServiceImpl() {
        groupDao = new GroupDaoImpl();
    }


    @Override
    public void create(String name, String info, int memberid) {
        groupDao.createGroup(name, info, memberid);
    }

    @Override
    public void join(String name, int memberid) {
        groupDao.joinGroup(name, memberid);
    }

}
