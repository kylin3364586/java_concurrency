package org.example.thinking.in.spring.ioc.dependency.source;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.annotation.PostConstruct;

/**

    ResolvableDependency 作为依赖来源
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2022年08月09日 18:31:00
 */
public class ResolvableDependencySourceDemo {

    @Autowired
    private String value;

    @PostConstruct
    public void init(){
        System.out.println(value);
    }

    public static void main(String[] args) {
        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        // 注册配置类
        applicationContext.register(ResolvableDependencySourceDemo.class);

        applicationContext.addBeanFactoryPostProcessor(beanFactory -> {
            //注册 Resolvable Dependency
            beanFactory.registerResolvableDependency(String.class, "Hello,World....");
        });

        // 刷新启动上下文
        applicationContext.refresh();

         //关闭上下文
        applicationContext.close();
    }
}
