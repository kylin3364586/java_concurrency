package com.example.mybatis.bean;


/**
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2023-02-06- 11:25:00
 */
public class User {
    private String id;
    private String username;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
