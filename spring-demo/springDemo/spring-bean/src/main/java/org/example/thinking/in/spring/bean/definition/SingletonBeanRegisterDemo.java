package org.example.thinking.in.spring.bean.definition;

import org.example.thinking.in.spring.bean.factory.DefaultUserFactory;
import org.example.thinking.in.spring.bean.factory.UserFactory;
import org.example.thinking.in.spring.bean.factory.UserFactoryBean;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 单体 Bean 注册示例
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2022年07月20日 15:47:00
 */
public class SingletonBeanRegisterDemo {

    public static void main(String[] args) {
        //创建应用上下文
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //创建外部 UserFactory Bean
        UserFactory userFactory = new DefaultUserFactory();
        ConfigurableListableBeanFactory beanFactory = applicationContext.getDefaultListableBeanFactory();
        //将外部 UserFactory Bean 注册到Spring容器中
        beanFactory.registerSingleton("userFactory", userFactory);
        //启动 Spring 应用上下文
        applicationContext.refresh();

        //通过依赖查找获取 userFactory
        UserFactory factoryBean = beanFactory.getBean("userFactory", UserFactory.class);
        System.out.println("userFactory == factoryBean:"+ (userFactory == factoryBean)); //true

        //关闭 Spring 应用上下文
        applicationContext.close();
    }
}
