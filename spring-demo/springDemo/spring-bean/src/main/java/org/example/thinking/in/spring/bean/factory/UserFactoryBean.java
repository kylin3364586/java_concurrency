package org.example.thinking.in.spring.bean.factory;

import org.example.thinking.in.spring.ioc.overview.dependency.domain.User;
import org.springframework.beans.factory.FactoryBean;

/**
 * FactoryBean 实例化Bean
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2022年07月19日 16:16:00
 */
public class UserFactoryBean implements FactoryBean {

    @Override
    public Object getObject() throws Exception {
        return User.createUser();
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }
}
