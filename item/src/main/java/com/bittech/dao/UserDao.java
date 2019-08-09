package com.bittech.dao;

import com.bittech.po.User;
import com.bittech.tools.DbManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    public List<User> queryUserDao() throws SQLException {
        String sqlStr = "SELECT * FROM person";
        ResultSet resultSet = new DbManager().executeQueryForUser(sqlStr);
        List<User> userList = new ArrayList<>();
        while(resultSet.next()){
            User user = new User();
            user.setUserid(resultSet.getInt("userId"));
            user.setUsername(resultSet.getString("userName"));
            user.setUseraddr(resultSet.getString("userAddr"));
            userList.add(user);
        }
        return userList;
    }
}
