package org.example.thinking.in.spring.ioc.overview.dependency.lookup;

import org.example.thinking.in.spring.ioc.overview.dependency.annotation.Super;
import org.example.thinking.in.spring.ioc.overview.dependency.domain.SuperUser;
import org.example.thinking.in.spring.ioc.overview.dependency.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * 依赖查找示例
 * 1.通过名称查找
 *
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2022年07月06日 17:05:00
 */
public class DependencyLookupDemo {

    public static void main(String[] args) {
        // 配置XML 配置文件
        //启动Spring应用上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:\\META-INF\\dependency-lookup-context.xml");
//        lookupInRealTime(beanFactory);
//        lookupInLazy(beanFactory);

        //根据类型查找
        lookupByType(beanFactory);
        //根据集合类型查找
        lookupCollectionByType(beanFactory);
        //通过注解查找
        lookupByAnnotationType(beanFactory);

    }

    private static void lookupByAnnotationType(BeanFactory beanFactory) {
        if(beanFactory instanceof ListableBeanFactory){
            Map<String, User> beansOfType = (Map)((ListableBeanFactory) beanFactory).getBeansWithAnnotation(Super.class);
            System.out.println("根据注解查找集合bean:" +beansOfType);
        }
    }
    private static void lookupCollectionByType(BeanFactory beanFactory) {
        if(beanFactory instanceof ListableBeanFactory){
            Map<String, User> beansOfType = ((ListableBeanFactory) beanFactory).getBeansOfType(User.class);
            System.out.println("根据类型查找集合bean:" +beansOfType);
        }
    }
    private static void lookupByType(BeanFactory beanFactory) {
        User bean = beanFactory.getBean(User.class);
        System.out.println("根据类型查找"+bean);
    }
    private static void lookupInLazy(BeanFactory beanFactory) {
        ObjectFactory<User> objectFactory = (ObjectFactory<User>) beanFactory.getBean("objectFactory");
        User user = objectFactory.getObject();
        System.out.println("延迟查找"+user);
    }
    private static void lookupInRealTime(BeanFactory beanFactory){
        User user = beanFactory.getBean("user", User.class);
        System.out.println("实时查找"+user);
    }
}
