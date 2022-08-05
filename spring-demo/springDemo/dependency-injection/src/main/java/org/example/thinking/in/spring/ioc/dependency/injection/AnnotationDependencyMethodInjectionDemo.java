package org.example.thinking.in.spring.ioc.dependency.injection;

import org.example.thinking.in.spring.ioc.overview.dependency.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.annotation.Resource;

/**
 * 基于注解资源的依赖 方法注入示例
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2022年07月26日 15:20:00
 */
public class AnnotationDependencyMethodInjectionDemo {

    private UserHolder userHolder;

    private UserHolder userHolder2;

    @Autowired
    public void initUserHolder(UserHolder userHolder){
        this.userHolder = userHolder;
    }
    @Resource
    public void initUserHolder2(UserHolder userHolder2){
        this.userHolder2 = userHolder2;
    }

    @Bean
    public UserHolder userHolder(User user){
        UserHolder userHolder = new UserHolder();
        userHolder.setUser(user);
        return userHolder;
    }

    public static void main(String[] args) {
        //创建BeanFactory容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //注册 Configuration Class 配置类
        applicationContext.register(AnnotationDependencyMethodInjectionDemo.class);

        //读取 XML
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(applicationContext);
        String xmlResourcePath = "classpath:\\META-INF\\dependency-lookup-context.xml";
        //加载 XML 资源
        beanDefinitionReader.loadBeanDefinitions(xmlResourcePath);


        //启动 Spring应用上下文
        applicationContext.refresh();


        //依赖查找 AnnotationDependencyFieldInjectionDemo Bean
        AnnotationDependencyMethodInjectionDemo demo = applicationContext.getBean(AnnotationDependencyMethodInjectionDemo.class);
        //@Autowired 字段关联
        UserHolder userHolder = demo.userHolder;
        System.out.println(userHolder);
        System.out.println(demo.userHolder2);

        System.out.println(userHolder == demo.userHolder2);

        //关闭 Spring应用上下文
        applicationContext.close();



    }

}
