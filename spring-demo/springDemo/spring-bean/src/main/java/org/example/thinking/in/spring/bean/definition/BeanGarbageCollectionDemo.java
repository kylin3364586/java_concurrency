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
public class BeanGarbageCollectionDemo {

    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //注册
        applicationContext.register(BeanInitializationDemo.class);
        //启动Spring应用上下文
        applicationContext.refresh();
        //关闭Spring应用上下文
        applicationContext.close();
        Thread.sleep(5000L);
        //触发GC
        System.gc();
        Thread.sleep(5000L);
    }

}
