package org.example.thinking.in.spring.bean.definition;

import org.example.thinking.in.spring.bean.factory.DefaultUserFactory;
import org.example.thinking.in.spring.bean.factory.UserFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Bean 初始化示例
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2022年07月19日 16:00:00
 */
@Configuration
public class BeanInitializationDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //注册
        applicationContext.register(BeanInitializationDemo.class);
        //启动Spring应用上下文
        applicationContext.refresh();
        System.out.println("Spring 应用上下已启动...");
        UserFactory bean = applicationContext.getBean(UserFactory.class);
        System.out.println(bean);
        System.out.println("Spring 应用上下准备关闭...");
        //关闭Spring应用上下文
        applicationContext.close();
        System.out.println("Spring 应用上下已关闭...");

    }

    @Bean(initMethod = "initUserFactory", destroyMethod = "doDestroy")
    public UserFactory userFactory(){
        return new DefaultUserFactory();
    }
}
