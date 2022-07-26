package org.example.thinking.in.spring.ioc.overview.dependency.repository;

import org.example.thinking.in.spring.ioc.overview.dependency.domain.User;

import java.util.Collection;

/**
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2022年07月11日 11:08:00
 */
public class UserRepository {

    private Collection<User> users;

    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "UserRepository{" +
                "users=" + users +
                '}';
    }
}
