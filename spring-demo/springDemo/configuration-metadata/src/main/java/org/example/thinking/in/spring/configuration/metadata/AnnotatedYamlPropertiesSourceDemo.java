package org.example.thinking.in.spring.configuration.metadata;

import org.example.thinking.in.spring.ioc.overview.dependency.domain.User;
import org.example.thinking.in.spring.ioc.overview.dependency.enums.City;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

import java.util.Map;

/**
 *  基于 Java 注解的 YAML 外部化配置示例
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2022年10月24日 11:03:00
 */
@PropertySource(
        name = "yamlPropertiesSource",
        value = "classpath:META-INF/user.yaml",
        factory = YamlPropertySourceFactory.class)
public class AnnotatedYamlPropertiesSourceDemo {

    /**
     * user.name 是 Java Properties 默认存在的，是当前用户
     * @param id
     * @param name
     * @return
     */
    @Bean
    public User yamlUser(@Value("${user.id}") Long id,
                              @Value("${user.name}") String name,
                              @Value("${user.city}") City city){
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setCity(city);
        return user;
    }


    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        // 注册当前类作为 Configuration Class
        context.register(AnnotatedYamlPropertiesSourceDemo.class);
        // 启动 Spring 应用上下文
        context.refresh();
        // 获取 Map YAML 对象
        User user = context.getBean("yamlUser", User.class);
        System.out.println(user);
        context.close();
    }
}
