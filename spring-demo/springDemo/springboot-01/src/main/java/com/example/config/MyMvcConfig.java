package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
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

//@EnableWebMvc
/**
 * 扩展springMvc配置时候不能添加 @EnableWebMvc 注解，原因如下：
 * @EnableWebMvc 注解引入了 @Import(DelegatingWebMvcConfiguration.class)
 * DelegatingWebMvcConfiguration 继承自 WebMvcConfigurationSupport
 * WebMvcConfigurer 实现类 WebMvcAutoConfiguration 当中包含 @ConditionalOnMissingBean(WebMvcConfigurationSupport.class) 注解
 *
 */
public class MyMvcConfig implements WebMvcConfigurer {

    // 1 ============================
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
    //测试
    // DispatcherServlet $ doDispatch -> viewResolvers


    // 2 ============================
    //视图跳转
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/kylin").setViewName("test");
    }
    //测试
    // http://192.168.20.49:8080/kylin

}
