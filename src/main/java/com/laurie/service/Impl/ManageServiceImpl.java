package com.laurie.service.Impl;

import com.laurie.dao.GroupDao;
import com.laurie.dao.Impl.GroupDaoImpl;
import com.laurie.dao.Impl.UserDaoImpl;
import com.laurie.dao.UserDao;
import com.laurie.service.ManageService;

/**
 * @author Laurie
 */
public class ManageServiceImpl implements ManageService {
    private final UserDao userDao;
    private final GroupDao groupDao;
    public ManageServiceImpl() {
        userDao = new UserDaoImpl();
        groupDao = new GroupDaoImpl();
    }
    @Override
    public void register(String username, String password, String email, String cellphone) {
        userDao.register(username,password,email,cellphone);
    }

    @Override
    public void modifyUser(int userId, String userName, String password, String email, String cellphone) {
        userDao.modifyUser(userId,userName,password,email,cellphone);
    }

    @Override
    public void deleteUserById(int userId) {
        userDao.deleteUserById(userId);
    }

    @Override
    public void deleteGroup(String groupName) {
        groupDao.deleteGroup(groupName);
    }
}
