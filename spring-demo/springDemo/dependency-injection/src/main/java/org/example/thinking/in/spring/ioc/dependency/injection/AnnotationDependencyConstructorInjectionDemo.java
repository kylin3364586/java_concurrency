package org.example.thinking.in.spring.ioc.dependency.injection;

import org.example.thinking.in.spring.ioc.overview.dependency.domain.User;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * 基于注解资源的依赖 Constructor 注入示例
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2022年07月26日 15:20:00
 */
public class AnnotationDependencyConstructorInjectionDemo {

    public static void main(String[] args) {
        //创建BeanFactory容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //注册 Configuration Class 配置类
        applicationContext.register(AnnotationDependencyConstructorInjectionDemo.class);

        //读取 XML
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(applicationContext);
        String xmlResourcePath = "classpath:\\META-INF\\dependency-lookup-context.xml";
        //加载 XML 资源
        beanDefinitionReader.loadBeanDefinitions(xmlResourcePath);


        //启动 Spring应用上下文
        applicationContext.refresh();

        //依赖查找Bean
        UserHolder userHolder = applicationContext.getBean(UserHolder.class);
        System.out.println(userHolder);

        //关闭 Spring应用上下文
        applicationContext.close();



    }

    @Bean
    public UserHolder userHolder(User user){
        return new UserHolder(user);
    }
}
