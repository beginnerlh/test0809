package com.bittech.service;

import com.bittech.dao.UserDao;
import com.bittech.po.User;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDao();

    @Override
    public List<User> queryUserService() throws SQLException {
        return userDao.queryUserDao();
    }
}
