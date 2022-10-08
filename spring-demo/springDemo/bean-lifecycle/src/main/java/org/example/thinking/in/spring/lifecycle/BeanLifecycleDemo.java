package org.example.thinking.in.spring.lifecycle;

import org.example.thinking.in.spring.ioc.overview.dependency.domain.User;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.CommonAnnotationBeanPostProcessor;

/**
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2022年09月20日 16:31:00
 */
public class BeanLifecycleDemo {

    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        //添加 BeanPostProcessor实现 MyInstantiationAwareBeanPostProcessor
        beanFactory.addBeanPostProcessor(new MyInstantiationAwareBeanPostProcessor());
        //添加 MyDestructionAwareBeanPostProcessor 执行销毁前回调
        beanFactory.addBeanPostProcessor(new MyDestructionAwareBeanPostProcessor());
        //添加 CommonAnnotationBeanPostProcessor 解决 @PostConstruct @PreDestroy
        beanFactory.addBeanPostProcessor(new CommonAnnotationBeanPostProcessor());

        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);

        String[] locations = {"META-INF\\dependency-lookup-context.xml", "META-INF\\bean-constructor-dependency-injection.xml"};
        int beanNumbers = beanDefinitionReader.loadBeanDefinitions(locations);
        System.out.println("已加载 BeanDefinition 数量：" + beanNumbers);

        //显示的执行 preInstantiateSingletons()
        //SmartInitializingSingleton 通常在SpringApplicationContext场景使用
        //preInstantiateSingletons 将已注册的 BeanDefinition 初始化成 Spring Bean
        beanFactory.preInstantiateSingletons();

        //通过 Bean Id 和类型进行依赖查找
        User user = beanFactory.getBean("user", User.class);
        System.out.println(user);

        User superUser = beanFactory.getBean("superUser", User.class);
        System.out.println(superUser);

        //构造器注入按照类型注入，resolveDependency
        UserHolder userHolder = beanFactory.getBean("userHolder", UserHolder.class);
        System.out.println(userHolder);

        // 执行 Bean 销毁（容器内）
        beanFactory.destroyBean("userHolder", userHolder);

        System.out.println(userHolder);
    }
}
