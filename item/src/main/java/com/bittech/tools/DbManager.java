package com.bittech.tools;

import java.sql.*;

public class DbManager {
    public String username = "root";
    public String password = "3306";
    public String driver = "com.mysql.jdbc.Driver";
    public String url = "jdbc:mysql://localhost:3306/spring";

    public Connection connection = null;
    public Statement statement = null;
    public ResultSet resultSet = null;

    public DbManager(){

    }
    //获取数据库连接
    public Connection getConnection(){

        try {
            Class.forName(driver);
            System.out.println("it is that load driver from db ");
            connection = DriverManager.getConnection(url,username,password);
            System.out.println("connection success");
            return connection;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return connection;
    }

    //全查
    public ResultSet executeQueryForUser(String strSql){
        connection = this.getConnection();
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(strSql);
            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public void closeConnection(){
        try{
            if(resultSet != null){
                resultSet.close();
            }
            if(statement != null){
                statement.close();
            }
            if(connection != null){
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
