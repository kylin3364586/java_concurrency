package org.example.thinking.in.spring.ioc.dependency.injection;

import org.example.thinking.in.spring.ioc.overview.dependency.domain.User;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Lazy;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

/**
 * 注解驱动的依赖注入过程
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2022年08月04日 09:34:00
 */
public class AnnotationDependencyInjectionResolutionDemo {


    @Autowired          //依赖查找（处理）+延迟
    @Lazy
    private User lazyUser;

    @Autowired          //依赖查找（处理）
    private User user;  //DependencyDescriptor ->
                        //必须（required=true）
                        //实时注入（eager=true）
                        //通过类型（User.class）
                        //字段名称（"user"）
                        //是否首要（primary=true）

    @Autowired
    private Map<String, User> userMap; // 集合类型依赖注入

    @Autowired
    private Optional<User> userOptional;

    public static void main(String[] args) {
        //创建BeanFactory容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //注册 Configuration Class 配置类
        applicationContext.register(AnnotationDependencyInjectionResolutionDemo.class);

        //读取 XML
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(applicationContext);
        String xmlResourcePath = "classpath:\\META-INF\\dependency-lookup-context.xml";
        //加载 XML 资源
        beanDefinitionReader.loadBeanDefinitions(xmlResourcePath);

        //启动 Spring应用上下文
        applicationContext.refresh();

        //依赖查找 AnnotationDependencyFieldInjectionDemo Bean
        AnnotationDependencyInjectionResolutionDemo demo = applicationContext.getBean(AnnotationDependencyInjectionResolutionDemo.class);

        System.out.println("user:" + demo.user);
        System.out.println("userMap:" + demo.userMap);
        System.out.println("userOptional:" + demo.userOptional);

        //关闭 Spring应用上下文
        applicationContext.close();



    }
}
