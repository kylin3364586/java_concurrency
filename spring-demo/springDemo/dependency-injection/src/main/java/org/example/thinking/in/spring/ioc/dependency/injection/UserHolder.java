package org.example.thinking.in.spring.ioc.dependency.injection;

import org.example.thinking.in.spring.ioc.overview.dependency.domain.User;

/**
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2022年07月26日 15:06:00
 */
public class UserHolder {

    public User user;

    public UserHolder(){

    }

    public UserHolder(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserHolder{" +
                "user=" + user +
                '}';
    }
}
