package org.example.thinking.in.spring.configuration.metadata;

import org.example.thinking.in.spring.ioc.overview.dependency.domain.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

import java.util.Map;

/**
 * 基于 Java 注解 Spring IoC 容器元信息配置示例
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2022年10月11日 15:10:00
 */
// 将当前类作为 Configuration Class
@ImportResource("classpath:\\META-INF\\dependency-lookup-context.xml")
@Import(User.class)
@PropertySource("classpath:\\META-INF\\user-bean-definitions.properties")
@PropertySource("classpath:\\META-INF\\user-bean-definitions.properties")
public class AnnotatedSpringIocContainerMetadataConfigurationDemo {

    /**
     * user.name 是 Java Properties 默认存在的，是当前用户
     * @param id
     * @param name
     * @return
     */
    @Bean
    public User configureUser(@Value("${user.id}") Long id, @Value("${user.name}") String name){
        User user = new User();
        user.setId(id);
        user.setName(name);
        return user;
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        // 注册当前类作为 Configuration Class
        context.register(AnnotatedSpringIocContainerMetadataConfigurationDemo.class);
        // 启动 Spring 应用上下文
        context.refresh();
        Map<String, User> userMap = context.getBeansOfType(User.class);
        for(Map.Entry<String, User> entry : userMap.entrySet()){
            System.out.printf("User Bean name : %s , content %s \n", entry.getKey(), entry.getValue());
        }
        // 关闭 Spring 应用上下文
        context.close();
    }
}
