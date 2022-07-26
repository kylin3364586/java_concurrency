package org.example.thinking.in.spring.dependency.lookup;

import org.example.thinking.in.spring.ioc.overview.dependency.domain.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.concurrent.Callable;

/**
 * 类型安全 依赖查找
 *
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2022年07月20日 16:57:00
 */
public class TypeSafetyDependencyLookupDemo {

    public static void main(String[] args) {
        //创建BeanFactory容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //将当前 TypeSafetyDependencyLookupDemo 作为配置类
        applicationContext.register(TypeSafetyDependencyLookupDemo.class);
        //启动 Spring应用上下文
        applicationContext.refresh();

        // 演示 BeanFactory#getBean 方法安全性
        displayBeanFactoryGetBean(applicationContext);
        //演示 ObjectFactory#getObject 方法安全性
        displayBeanFactoryGetObject(applicationContext);//不安全
        //演示 ObjectProvide#getIfAvaiable 方法安全性
        displayObjectProviderIfAvailable(applicationContext);//不安全

        //演示 ListableBeanFactory#getBeansOfType 方法安全性
        displayListableBeanFactoryGetBeansOfType(applicationContext);
        //演示 ObjectProvider Stream 操作安全性
        displayObjectProviderStreamOps(applicationContext);

        //关闭 Spring应用上下文
        applicationContext.close();
    }

    private static void displayObjectProviderStreamOps(AnnotationConfigApplicationContext applicationContext) {
        ObjectProvider<User> userObjectProvider = applicationContext.getBeanProvider(User.class);
        printBeanException("displayObjectProviderStreamOps", () -> userObjectProvider.forEach(System.out::println));
    }

    private static void displayListableBeanFactoryGetBeansOfType(ListableBeanFactory beanFactory) {
        printBeanException("displayListableBeanFactoryGetBeansOfType", () -> beanFactory.getBeansOfType(User.class));
    }

    private static void displayObjectProviderIfAvailable(AnnotationConfigApplicationContext applicationContext) {
        ObjectProvider<User> userObjectProvider = applicationContext.getBeanProvider(User.class);
        printBeanException("displayObjectProviderIfAvailable", () -> userObjectProvider.getIfAvailable());
    }

    private static void displayBeanFactoryGetBean(AnnotationConfigApplicationContext applicationContext) {
        ObjectFactory<User> userObjectFactory = applicationContext.getBeanProvider(User.class);
        printBeanException("displayBeanFactoryGetBean", () -> userObjectFactory.getObject());
     }

    private static void displayBeanFactoryGetObject(BeanFactory beanFactory) {
        printBeanException("displayBeanFactoryGetObject", () -> beanFactory.getBean(User.class));
    }


    private static void printBeanException(String message, Runnable runnable) {
        System.err.println("Source form:" + message);
        System.err.println("========================");
        try {
            runnable.run();
        } catch (BeansException e) {
            e.printStackTrace();
        }
    }
}
