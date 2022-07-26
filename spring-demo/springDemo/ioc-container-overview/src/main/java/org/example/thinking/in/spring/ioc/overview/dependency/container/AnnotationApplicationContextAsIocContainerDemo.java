package org.example.thinking.in.spring.ioc.overview.dependency.container;

import org.example.thinking.in.spring.ioc.overview.dependency.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Map;

/**
 * {@link ApplicationContext} 作为 Ioc 容器示例
 *
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2022年07月14日 14:23:00
 */
public class AnnotationApplicationContextAsIocContainerDemo {

    public static void main(String[] args) {
        //创建应用上下文
        AnnotationConfigApplicationContext applicationContext =  new AnnotationConfigApplicationContext();
        //将当前类 AnnotationApplicationContextAsIocContainerDemo 作为配置类
        applicationContext.register(AnnotationApplicationContextAsIocContainerDemo.class);
        //启动（刷新）应用上下文
        applicationContext.refresh();
        //依赖查找集合对象
        lookupCollectionByType(applicationContext);
        //关闭应用上下文
        applicationContext.close();
    }

    @Bean
    public User User(){
        User user = new User();
        user.setId(1L);
        user.setName("kylin");
        return user;
    }

    private static void lookupCollectionByType(BeanFactory beanFactory) {
        if(beanFactory instanceof ListableBeanFactory){
            Map<String, User> beansOfType = ((ListableBeanFactory) beanFactory).getBeansOfType(User.class);
            System.out.println("根据类型查找集合bean:" +beansOfType);
        }
    }
}
