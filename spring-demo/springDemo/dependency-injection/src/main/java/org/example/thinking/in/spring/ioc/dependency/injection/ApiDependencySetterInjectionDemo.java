package org.example.thinking.in.spring.ioc.dependency.injection;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 基于 Java注解的依赖 Setter注入示例
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2022年07月26日 15:20:00
 */
public class ApiDependencySetterInjectionDemo {

    public static void main(String[] args) {
        //创建BeanFactory容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //注册 Configuration Class 配置类
//        applicationContext.register(ApiDependencySetterInjectionDemo.class);

        //生成 UserHolder 的 BeanDefinition
        BeanDefinition userHolderBeanDefinition = createUserHolderBeanDefinition();
        //注册 UserHolder 的 BeanDefinition
        applicationContext.registerBeanDefinition("userHolder", userHolderBeanDefinition);


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
        applicationContext.close() ;



    }

    private static BeanDefinition createUserHolderBeanDefinition(){
        BeanDefinitionBuilder definitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(UserHolder.class);
        definitionBuilder.addPropertyReference("user", "superUser");
        return definitionBuilder.getBeanDefinition();
    }

//    @Bean
//    public UserHolder userHolder(User user){
//        UserHolder userHolder = new UserHolder();
//        userHolder.setUser(user);
//        return userHolder;
//    }
}
