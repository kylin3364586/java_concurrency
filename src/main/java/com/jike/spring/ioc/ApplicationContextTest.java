package com.jike.spring.ioc;

import com.jike.spring.ioc.bean.Service;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2022年05月07日 16:55:00
 */
public class ApplicationContextTest {

    String configLocation = "ioc-config.xml";
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext(configLocation);
    /**
     * bean别名测试
     */
    @Test
    public void aliasTest(){
        System.out.println(applicationContext.getBean("hello"));
        System.out.println(applicationContext.getBean("aliasHello"));
    }

    /**
     * 嵌套bean
     */
    @Test
    public void nested(){
        Service service = (Service)applicationContext.getBean("service");
        System.out.println(service);
        System.out.println(service.getMongoService());
        System.out.println(service.getMysqlService());
    }

    @Test
    public void factoryBean(){
        System.out.println(applicationContext.getBean("helloFactoryBean"));//返回的是HelloFactoryBean中getObject方法返回的对象
        System.out.println(applicationContext.getBean("&helloFactoryBean"));//返回的是HelloFactoryBean对象
    }

    @Test
    public void parentTest(){
        System.out.println(applicationContext.getBean("hello"));
        System.out.println(applicationContext.getBean("helloChild"));
    }
}
