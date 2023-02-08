package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Locale;

/**
 * 自定义视图解析器
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2023-02-08- 17:59:00
 */
//扩展springmvc
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    //注册后就生效了
    @Bean
    public ViewResolver myViewResolver(){
        return new MyViewResolver();
    }


    //创建视图解析器
    public static class MyViewResolver implements ViewResolver {

        @Override
        public View resolveViewName(String s, Locale locale) throws Exception {
            return null;
        }
    }

}
