package com.kylin.db;

import com.mysql.cj.jdbc.ConnectionGroupManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * JDBC 测试
 *
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2023-02-15- 15:07:00
 */
public class JDBCTest {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://127.0.0.1:3306/my_test?useSSL=false&useUnicode=true&characterEncoding=UTF-8";
        String username= "root";
        String password= "root";

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from user");
        while (resultSet.next()){
            System.out.println(resultSet.getObject("id")+"---"+resultSet.getObject("username"));
        }

        resultSet.close();
        statement.close();
        connection.close();
    }
}
