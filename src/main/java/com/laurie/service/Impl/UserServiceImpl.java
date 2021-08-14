package com.laurie.service.Impl;

import com.laurie.dao.Impl.UserDaoImpl;
import com.laurie.dao.UserDao;
import com.laurie.service.UserService;
import com.laurie.utils.JdbcUtil;

import java.sql.Connection;

/**
 * @author Laurie
 */
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    public UserServiceImpl() {
        userDao = new UserDaoImpl();
    }

    @Override
    public boolean login(String username, String password) {
        boolean flag = false;
        flag = userDao.loginVerify(username, password);
        return flag;
    }

    @Override
    public void register(String username, String password, String email, String cellphone) {
        userDao.register(username, password, email, cellphone);
    }
}
