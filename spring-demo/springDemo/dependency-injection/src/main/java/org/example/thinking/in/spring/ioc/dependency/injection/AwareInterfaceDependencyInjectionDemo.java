package org.example.thinking.in.spring.ioc.dependency.injection;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.Aware;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanInitializationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 基于 {@link Aware} 接口回调的依赖注入示例
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2022年07月28日 15:13:00
 */
public class AwareInterfaceDependencyInjectionDemo implements BeanFactoryAware, ApplicationContextAware {

    public static BeanFactory beanFactory;
    public static ApplicationContext applicationContext;

    public static void main(String[] args) {
        //创建BeanFactory容器
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        //注册 Configuration Class 配置类 -> Spring Bean
        context.register(AwareInterfaceDependencyInjectionDemo.class);

        //启动 Spring应用上下文
        context.refresh();

        System.out.println(beanFactory == context.getBeanFactory());
        System.out.println(applicationContext == context);

        //关闭 Spring应用上下文
        context.close();

    }


    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        AwareInterfaceDependencyInjectionDemo.beanFactory = beanFactory;
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        AwareInterfaceDependencyInjectionDemo.applicationContext = applicationContext;
    }
}
