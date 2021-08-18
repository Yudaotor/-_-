package com.laurie.service.Impl;

import com.laurie.dao.Impl.UserDaoImpl;
import com.laurie.dao.UserDao;
import com.laurie.pojo.User;
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

    @Override
    public boolean modify(int id, String password1, String password2) {
        boolean flag = false;
        User user = userDao.getUserById(id);
        String pwd = user.getPassword();
        if(pwd.equals(password1)){
            userDao.modify(id, password2);
            flag = true;
        }
        return flag;
    }
}
