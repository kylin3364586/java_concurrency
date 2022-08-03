package com.jike.spring.ioc.bean;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2022年05月07日 17:20:00
 */
public class HelloFactoryBean implements FactoryBean<Hello> {

    @Override
    public Hello getObject() throws Exception {
        return new Hello();
    }

    @Override
    public Class<?> getObjectType() {
        return Hello.class;
    }
}
