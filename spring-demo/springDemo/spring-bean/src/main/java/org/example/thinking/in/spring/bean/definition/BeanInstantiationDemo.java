package org.example.thinking.in.spring.bean.definition;

import org.example.thinking.in.spring.ioc.overview.dependency.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Bean 实例化示例
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2022年07月19日 16:00:00
 */
public class BeanInstantiationDemo {

    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:\\META-INF\\bean-instantiation-context.xml");
        User bean = beanFactory.getBean("user-by-static-method", User.class);
        User bean1 = beanFactory.getBean("user-by-instance-method", User.class);
        User bean2 = beanFactory.getBean("user-by-factory-bean", User.class);
        System.out.println(bean);
        System.out.println(bean1);
        System.out.println(bean2);
    }
}
