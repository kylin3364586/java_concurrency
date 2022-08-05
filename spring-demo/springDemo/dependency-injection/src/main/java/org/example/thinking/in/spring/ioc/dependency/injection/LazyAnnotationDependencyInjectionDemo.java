package org.example.thinking.in.spring.ioc.dependency.injection;

import org.example.thinking.in.spring.ioc.dependency.injection.annotation.UserGroup;
import org.example.thinking.in.spring.ioc.overview.dependency.domain.User;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Collection;
import java.util.Set;

/**
 * {@link ObjectProvider} 实现延迟依赖注入
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2022年08月04日 09:34:00
 */
public class LazyAnnotationDependencyInjectionDemo {

    @Autowired
    private User user; //实时注入

    @Autowired
    private ObjectProvider<User> userObjectProvider;//延迟注入(推荐)

    @Autowired
    private ObjectFactory<Set<User>> objectFactory;//延迟注入

    public static void main(String[] args) {
        //创建BeanFactory容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //注册 Configuration Class 配置类
        applicationContext.register(LazyAnnotationDependencyInjectionDemo.class);

        //读取 XML
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(applicationContext);
        String xmlResourcePath = "classpath:\\META-INF\\dependency-lookup-context.xml";
        //加载 XML 资源
        beanDefinitionReader.loadBeanDefinitions(xmlResourcePath);

        //启动 Spring应用上下文
        applicationContext.refresh();

        //依赖查找 AnnotationDependencyFieldInjectionDemo Bean
        LazyAnnotationDependencyInjectionDemo demo = applicationContext.getBean(LazyAnnotationDependencyInjectionDemo.class);

        System.out.println("user:" + demo.user);
        System.out.println("userObjectProvider:" + demo.userObjectProvider.getObject());
        System.out.println("objectFactory:" + demo.objectFactory.getObject());

        demo.userObjectProvider.stream().forEach(System.out::println);

        //关闭 Spring应用上下文
        applicationContext.close();



    }
}
