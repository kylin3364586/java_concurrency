package org.example.thinking.in.spring.bean.definition;

import org.example.thinking.in.spring.ioc.overview.dependency.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Bean 别名示例
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2022年07月18日 10:54:00
 */
public class BeanAliasDemo {

    public static void main(String[] args) {
        //配置XML，启动应用上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:\\META-INF\\bean-definitions-context.xml");
        // 通过别名获取Bean
        User bean = beanFactory.getBean("alias-User1", User.class);
        System.out.println(bean);
    }
}
