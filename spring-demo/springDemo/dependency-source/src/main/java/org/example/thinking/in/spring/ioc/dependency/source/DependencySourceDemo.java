package org.example.thinking.in.spring.ioc.dependency.source;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.ResourceLoader;

import javax.annotation.PostConstruct;

/**
 * 依赖来源示例
 *
 * 依赖注入 比依赖查找多一项（非Spring管理对象）
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2022年08月09日 18:31:00
 */
public class DependencySourceDemo {

    //注入在 postProcessProperties 方法执行，早于 setter注入，也早于@PostConstruct
    @Autowired
    private BeanFactory beanFactory;
    @Autowired
    private ResourceLoader resourceLoader;
    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @PostConstruct
    public void init(){
        System.out.println("beanFactory == applicationContext :" + ( beanFactory == applicationContext));
        System.out.println("beanFactory == applicationContext.getAutowireCapableBeanFactory() :" + ( beanFactory ==applicationContext.getAutowireCapableBeanFactory()));
        System.out.println("resourceLoader == applicationContext :" + ( resourceLoader == applicationContext));
        System.out.println("applicationEventPublisher == applicationContext :" + ( applicationEventPublisher == applicationContext));
    }

    @PostConstruct
    public void initByLookup(){
        getBean(BeanFactory.class);
        getBean(ApplicationContext.class);
        getBean(ResourceLoader.class);
        getBean(ApplicationEventPublisher.class);
    }

    private <T> T getBean(Class<T> beanType){
        try {
            return beanFactory.getBean(beanType);
        }catch (NoSuchBeanDefinitionException e){
            System.err.println("当前类型 " + beanType.getName() + " 无法在 Bean Factory 中查找！");
        }
        return null;
    }


    public static void main(String[] args) {
        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 注册配置类
        applicationContext.register(DependencySourceDemo.class);
        // 刷新启动上下文
        applicationContext.refresh();
        // 依赖查找 DependencySourceDemo Bean
        DependencySourceDemo demo = applicationContext.getBean(DependencySourceDemo.class);


         //关闭上下文
        applicationContext.close();
    }
}
