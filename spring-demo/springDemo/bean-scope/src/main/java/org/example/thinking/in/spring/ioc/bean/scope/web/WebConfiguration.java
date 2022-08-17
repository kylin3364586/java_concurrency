package org.example.thinking.in.spring.ioc.bean.scope.web;

import org.example.thinking.in.spring.ioc.overview.dependency.domain.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 *
 * Web MVC 配置类
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2022年08月16日 15:33:00
 */
@Configuration
@EnableWebMvc
public class WebConfiguration {

    @Bean
    @RequestScope
    public User user(){
        User user = new User();
        user.setId(1L);
        user.setName("kylin");
        return user;
    }
}
