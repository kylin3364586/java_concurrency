package org.example.thinking.in.spring.bean.definition;

import org.example.thinking.in.spring.ioc.overview.dependency.domain.User;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Map;

import static org.springframework.beans.factory.support.BeanDefinitionBuilder.genericBeanDefinition;

/**
 * 注解 BeanDefinition示例
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2022年07月18日 14:04:00
 */
@Import(AnnotationBeanDefinitionDemo.Config.class)//3. 通过Import 方式导入
public class AnnotationBeanDefinitionDemo {

    public static void main(String[] args) {
        //创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //注册 Configuration Class 配置类
        applicationContext.register(AnnotationBeanDefinitionDemo.class);


        //1.命名Bean方式注册
        registerUserBeanDefinition(applicationContext, "my_user");
        //1.非命名Bean方式注册
        registerUserBeanDefinition(applicationContext);


        //启动（刷新）应用上下文
        applicationContext.refresh();
        System.out.println(applicationContext.getBeansOfType(Config.class));
        System.out.println(applicationContext.getBeansOfType(User.class));
        //显示关闭Spring应用上下文
        applicationContext.close();
    }


    public static void registerUserBeanDefinition(BeanDefinitionRegistry registry, String beanName){
        BeanDefinitionBuilder beanDefinitionBuilder = genericBeanDefinition(User.class);
        beanDefinitionBuilder.addPropertyValue("id",1L).addPropertyValue("name","kylin");
        AbstractBeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
        if(StringUtils.hasText(beanName)){
            //注册 BeanDefinition
            registry.registerBeanDefinition(beanName, beanDefinition);
        }else{
            //非命名 Bean 方式注册
            BeanDefinitionReaderUtils.registerWithGeneratedName(beanDefinition, registry);
        }
    }

    public static void registerUserBeanDefinition(BeanDefinitionRegistry registry){
        registerUserBeanDefinition(registry, null);
    }

    //2. 通过Component 方式
    @Component
    public static class Config{
        //1. 通过bean方式定义
        @Bean(name = {"user","user1"})
        public User user(){
            User user = new User();
            user.setId(1L);
            user.setName("11111");
            return user;
        }
    }
}
