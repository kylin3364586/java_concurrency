package org.example.thinking.in.spring.bean.factory;

import org.example.thinking.in.spring.ioc.overview.dependency.domain.User;

/**
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2022年07月19日 15:49:00
 */
public interface UserFactory {

    default User createUser(){
        User user = new User();
        user.setId(1L);
        user.setName("111");
        return user;
    }

}
